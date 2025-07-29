package com.example.etiquetafotoapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.label.ImageLabel
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import androidx.core.content.FileProvider

class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    private lateinit var imageView: ImageView
    private lateinit var selectImageButton: MaterialButton
    private lateinit var takePhotoButton: MaterialButton
    private lateinit var progressBar: ProgressBar
    private lateinit var resultsCard: MaterialCardView
    private lateinit var emptyImageOverlay: LinearLayout
    private lateinit var confidenceText: TextView
    private lateinit var confidenceSeekBar: SeekBar
    private lateinit var confidenceValueText: TextView
    private lateinit var labelsChipGroup: ChipGroup
    private lateinit var shareResultsButton: MaterialButton
    private lateinit var viewModel: ImageLabelingViewModel
    private lateinit var poweredByText: TextView

    private val selectImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { handleImageSelection(it) }
    }

    private val takePhotoLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            currentPhotoUri?.let { handleImageSelection(it) }
        } else {
            Toast.makeText(this, "No se pudo tomar la foto. Intenta de nuevo.", Toast.LENGTH_SHORT).show()
        }
    }

    private var currentPhotoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
                .get(ImageLabelingViewModel::class.java)
            initializeViews()
            setupClickListeners()
            setupObservers()
            viewModel.imageUri.value?.let {
                imageView.setImageURI(it)
                emptyImageOverlay.visibility = View.GONE
            } ?: run {
                emptyImageOverlay.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, getString(R.string.error_initializing_app, e.message), Toast.LENGTH_LONG).show()
        }
    }

    private fun initializeViews() {
        try {
            imageView = findViewById(R.id.imageView)
            selectImageButton = findViewById(R.id.selectImageBtn)
            takePhotoButton = findViewById(R.id.takePhotoBtn)
            progressBar = findViewById(R.id.progressBar)
            resultsCard = findViewById(R.id.resultsCard)
            emptyImageOverlay = findViewById(R.id.emptyImageOverlay)
            confidenceText = findViewById(R.id.confidenceText)
            confidenceSeekBar = findViewById(R.id.confidenceSeekBar)
            confidenceValueText = findViewById(R.id.confidenceValueText)
            labelsChipGroup = findViewById(R.id.labelsChipGroup)
            shareResultsButton = findViewById(R.id.shareResultsBtn)
            poweredByText = findViewById(R.id.poweredByText)
            val initialConfidence = (viewModel.confidenceThreshold.value!! * 100).toInt()
            confidenceSeekBar.progress = initialConfidence
            confidenceValueText.text = getString(R.string.confidence_label) + " $initialConfidence%"
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, getString(R.string.error_finding_views, e.message), Toast.LENGTH_LONG).show()
        }
    }

    private fun setupClickListeners() {
        selectImageButton.setOnClickListener {
            selectImageLauncher.launch("image/*")
        }

        takePhotoButton.setOnClickListener {
            checkCameraPermission()
        }

        shareResultsButton.setOnClickListener {
            shareResults()
        }

        poweredByText.setOnClickListener {
            val dialog = InstagramLinksDialogFragment()
            dialog.show(supportFragmentManager, "InstagramLinksDialog")
        }

        confidenceSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val threshold = progress / 100f
                confidenceValueText.text = getString(R.string.confidence_label) + " $progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val threshold = seekBar?.progress?.div(100f) ?: 0.5f
                viewModel.setConfidenceThreshold(threshold)
            }
        })
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
        } else {
            startCameraIntent()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCameraIntent()
            } else {
                Toast.makeText(this, "Permiso de cámara denegado. No se puede tomar fotos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startCameraIntent() {
        try {
            currentPhotoUri = createImageFile()?.let { file ->
                getUriForFile(file)
            }

            currentPhotoUri?.let { uri ->
                takePhotoLauncher.launch(uri)
            } ?: run {
                Toast.makeText(this, "Error al crear archivo para la foto", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            showError("Error al configurar la cámara: ${e.localizedMessage}")
        }
    }

    private fun createImageFile(): File? {
        return try {
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val imageFileName = "JPEG_${timeStamp}_"
            val storageDir: File? = getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES)

            storageDir?.let { dir ->
                if (!dir.exists()) {
                    dir.mkdirs()
                }
            }

            File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
            )
        } catch (ex: IOException) {
            ex.printStackTrace()
            Toast.makeText(this, "Error al crear archivo: ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
            null
        }
    }

    private fun getUriForFile(file: File): Uri {
        return FileProvider.getUriForFile(
            this,
            "${applicationContext.packageName}.fileprovider",
            file
        )
    }

    private fun setupObservers() {
        viewModel.isLoading.observe(this) { isLoading ->
            showLoading(isLoading)
        }
        viewModel.imageUri.observe(this) { uri ->
            if (uri != null) {
                imageView.setImageURI(uri)
                emptyImageOverlay.visibility = View.GONE
            } else {
                imageView.setImageDrawable(null)
                emptyImageOverlay.visibility = View.VISIBLE
            }
        }
        viewModel.labels.observe(this) { labels ->
            if (labels != null) {
                if (labels.isEmpty()) {
                    showNoResults()
                } else {
                    displayLabelsAsChips(labels)
                    showResultsCard(true)
                }
            } else {
                showResultsCard(false)
            }
        }
        viewModel.errorMessage.observe(this) { message ->
            if (message != null) {
                showError(message)
            }
        }
    }

    private fun handleImageSelection(imageUri: Uri) {
        try {
            viewModel.setImageUri(imageUri)
            hideResults()
            viewModel.processImage(imageUri, viewModel.confidenceThreshold.value!!)
        } catch (e: Exception) {
            showError(getString(R.string.error_loading_image, e.localizedMessage))
        }
    }

    private fun displayLabelsAsChips(labels: List<ImageLabel>) {
        labelsChipGroup.removeAllViews()
        labels.forEach { label ->
            val confidence = (label.confidence * 100).toInt()
            val emoji = viewModel.getEmojiForLabel(label.text)
            val translatedLabel = viewModel.translateToSpanish(label.text)
            val chip = Chip(this).apply {
                text = "$emoji $translatedLabel ($confidence%)"
                chipBackgroundColor = ContextCompat.getColorStateList(context, R.color.primary_light)
                setTextColor(ContextCompat.getColor(context, R.color.primary_text))
                chipStrokeColor = ContextCompat.getColorStateList(context, R.color.card_stroke)
                chipStrokeWidth = 1f
                isClickable = false
                isFocusable = false
            }
            labelsChipGroup.addView(chip)
        }
        val avgConfidence = labels.map { (it.confidence * 100).toInt() }.average().toInt()
        confidenceText.text = when {
            avgConfidence >= 80 -> getString(R.string.confidence_high)
            avgConfidence >= 60 -> getString(R.string.confidence_medium)
            else -> getString(R.string.confidence_low)
        }
        Snackbar.make(
            findViewById(android.R.id.content),
            getString(R.string.objects_detected_snackbar, labels.size),
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun showNoResults() {
        labelsChipGroup.removeAllViews()
        val chip = Chip(this).apply {
            text = getString(R.string.no_results_found)
            chipBackgroundColor = ContextCompat.getColorStateList(context, R.color.accent_light)
            setTextColor(ContextCompat.getColor(context, R.color.primary_text))
            chipStrokeColor = ContextCompat.getColorStateList(context, R.color.card_stroke)
            chipStrokeWidth = 1f
            isClickable = false
            isFocusable = false
        }
        labelsChipGroup.addView(chip)
        confidenceText.text = getString(R.string.no_results_confidence_label)
        showResultsCard(true)
    }

    private fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        selectImageButton.isEnabled = !show
        takePhotoButton.isEnabled = !show
        confidenceSeekBar.isEnabled = !show
        if (show) {
            selectImageButton.text = getString(R.string.processing_text)
            takePhotoButton.text = getString(R.string.processing_text)
        } else {
            selectImageButton.text = getString(R.string.select_image_button_text)
            takePhotoButton.text = getString(R.string.take_photo_button_text)
        }
    }

    private fun hideResults() {
        showResultsCard(false)
        labelsChipGroup.removeAllViews()
    }

    private fun showResultsCard(show: Boolean) {
        resultsCard.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showError(message: String) {
        labelsChipGroup.removeAllViews()
        val chip = Chip(this).apply {
            text = message
            chipBackgroundColor = ContextCompat.getColorStateList(context, R.color.error_color)
            setTextColor(ContextCompat.getColor(context, R.color.white))
            chipStrokeColor = ContextCompat.getColorStateList(context, R.color.primary_dark)
            chipStrokeWidth = 1f
            isClickable = false
            isFocusable = false
        }
        labelsChipGroup.addView(chip)
        confidenceText.text = getString(R.string.error_label)
        showResultsCard(true)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun shareResults() {
        val labels = viewModel.labels.value
        if (labels != null && labels.isNotEmpty()) {
            val shareText = buildString {
                labels.forEach { label ->
                    val confidence = (label.confidence * 100).toInt()
                    val emoji = viewModel.getEmojiForLabel(label.text)
                    val translatedLabel = viewModel.translateToSpanish(label.text)
                    append("$emoji $translatedLabel (${confidence}% seguro)\n")
                }
            }
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_title))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text_format, shareText))
            }
            startActivity(Intent.createChooser(shareIntent, null))
        } else {
            Toast.makeText(this, "No hay resultados para compartir.", Toast.LENGTH_SHORT).show()
        }
    }
}
