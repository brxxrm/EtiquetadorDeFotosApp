package com.example.etiquetafotoapp

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions

class ImageLabelingViewModel(application: Application) : AndroidViewModel(application) {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _imageUri = MutableLiveData<Uri?>(null)
    val imageUri: LiveData<Uri?> = _imageUri

    private val _labels = MutableLiveData<List<ImageLabel>?>(null)
    val labels: LiveData<List<ImageLabel>?> = _labels

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage

    private val _confidenceThreshold = MutableLiveData(0.5f)
    val confidenceThreshold: LiveData<Float> = _confidenceThreshold

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
        _labels.value = null
        _errorMessage.value = null
    }

    fun setConfidenceThreshold(threshold: Float) {
        _confidenceThreshold.value = threshold
        _imageUri.value?.let { processImage(it, threshold) }
    }

    fun processImage(imageUri: Uri, currentConfidenceThreshold: Float) {
        _isLoading.value = true
        _errorMessage.value = null
        _labels.value = null

        val applicationContext = getApplication<Application>().applicationContext

        try {
            val image = InputImage.fromFilePath(applicationContext, imageUri)
            val options = ImageLabelerOptions.Builder()
                .setConfidenceThreshold(currentConfidenceThreshold)
                .build()

            val labeler = ImageLabeling.getClient(options)

            labeler.process(image)
                .addOnSuccessListener { labels ->
                    _isLoading.value = false
                    _labels.value = labels
                }
                .addOnFailureListener { exception ->
                    _isLoading.value = false
                    _errorMessage.value = applicationContext.getString(R.string.error_processing_image, exception.localizedMessage)
                }
        } catch (e: Exception) {
            _isLoading.value = false
            _errorMessage.value = applicationContext.getString(R.string.error_processing_image, e.localizedMessage)
        }
    }

    fun clearResults() {
        _labels.value = null
        _errorMessage.value = null
        _imageUri.value = null
    }


    fun translateToSpanish(englishLabel: String): String {
        return when (englishLabel.lowercase()) {
            "person", "human", "people" -> "Persona"
            "car", "vehicle", "automobile" -> "Automóvil"
            "dog", "puppy" -> "Perro"
            "cat", "kitten" -> "Gato"
            "food", "meal", "dish" -> "Comida"
            "flower", "plant" -> "Flor"
            "building", "house", "home" -> "Edificio"
            "tree" -> "Árbol"
            "sky", "cloud" -> "Cielo"
            "water", "sea", "ocean" -> "Agua"
            "phone", "mobile", "smartphone" -> "Teléfono"
            "book" -> "Libro"
            "computer", "laptop" -> "Computadora"
            "chair" -> "Silla"
            "table" -> "Mesa"
            "window" -> "Ventana"
            "door" -> "Puerta"
            "bird" -> "Pájaro"
            "fish" -> "Pez"
            "bicycle", "bike" -> "Bicicleta"
            "motorcycle" -> "Motocicleta"
            "bus" -> "Autobús"
            "truck" -> "Camión"
            "train" -> "Tren"
            "airplane", "plane" -> "Avión"
            "boat", "ship" -> "Barco"
            "bottle" -> "Botella"
            "cup", "mug" -> "Taza"
            "glass" -> "Vaso"
            "plate" -> "Plato"
            "apple" -> "Manzana"
            "banana" -> "Plátano"
            "orange" -> "Naranja"
            "pizza" -> "Pizza"
            "cake" -> "Pastel"
            "bread" -> "Pan"
            "coffee" -> "Café"
            "tea" -> "Té"
            "shirt" -> "Camisa"
            "shoes" -> "Zapatos"
            "hat" -> "Sombrero"
            "bag", "handbag" -> "Bolsa"
            "watch" -> "Reloj"
            "glasses" -> "Lentes"
            "ball" -> "Pelota"
            "toy" -> "Juguete"
            "clock" -> "Reloj"
            "television", "tv" -> "Televisión"
            "camera" -> "Cámara"
            "bed" -> "Cama"
            "face" -> "Cara"
            "eye" -> "Ojo"
            "hand" -> "Mano"
            "grass" -> "Césped"
            "leaf" -> "Hoja"
            "sun" -> "Sol"
            "moon" -> "Luna"
            "star" -> "Estrella"
            else -> englishLabel.replaceFirstChar { it.uppercase() }
        }
    }

    fun getEmojiForLabel(label: String): String {
        return when (label.lowercase()) {
            "person", "human", "people" -> "👤"
            "car", "vehicle", "automobile" -> "🚗"
            "dog", "puppy" -> "🐕"
            "cat", "kitten" -> "🐱"
            "food", "meal", "dish" -> "🍽️"
            "flower", "plant" -> "🌸"
            "building", "house", "home" -> "🏠"
            "tree" -> "🌳"
            "sky", "cloud" -> "☁️"
            "water", "sea", "ocean" -> "🌊"
            "phone", "mobile", "smartphone" -> "📱"
            "book" -> "📚"
            "computer", "laptop" -> "💻"
            "chair" -> "🪑"
            "bird" -> "🐦"
            "fish" -> "🐟"
            "bicycle", "bike" -> "🚲"
            "bus" -> "🚌"
            "truck" -> "🚛"
            "train" -> "🚂"
            "airplane", "plane" -> "✈️"
            "boat", "ship" -> "🚢"
            "apple" -> "🍎"
            "banana" -> "🍌"
            "pizza" -> "🍕"
            "cake" -> "🎂"
            "camera" -> "📷"
            "clock" -> "🕐"
            "television", "tv" -> "📺"
            "sun" -> "☀️"
            "moon" -> "🌙"
            "star" -> "⭐"
            else -> "🏷️"
        }
    }
}
