# 💖 FotoGlees

✨ Una aplicación Android inteligente para identificar objetos en tus imágenes, con integración de cámara y enlaces a los creadores.

## 📸 Descripción del Proyecto

"FotoGlees es una aplicación móvil Android diseñada para analizar imágenes y detectar objetos dentro de ellas utilizando el poder de la Inteligencia Artificial (IA) a través de ML Kit de Google. Permite a los usuarios seleccionar imágenes de su galería o tomar fotos directamente con la cámara del dispositivo, y luego muestra etiquetas de los objetos identificados con su nivel de confianza.


## ✨ Características Principales

*   **Selección de Imagen:** Elige fotos de tu galería para analizarlas.
*   **Integración de Cámara:** Toma fotos directamente desde la aplicación para un análisis instantáneo.
*   **Etiquetado de Imágenes con IA:** Utiliza ML Kit para detectar y etiquetar objetos en tus fotos.
*   **Nivel de Confianza Ajustable:** Controla la sensibilidad del reconocimiento de objetos mediante una barra deslizante.
*   **Resultados Claros:** Muestra los objetos detectados con emojis, nombres traducidos al español y porcentajes de confianza.
*   **Compartir Resultados:** Comparte fácilmente las etiquetas detectadas con otras aplicaciones.

## 🚀 Tecnologías Utilizadas

*   **Kotlin:** Lenguaje de programación principal para el desarrollo de Android.
*   **Android Jetpack:**
    *   `AppCompatActivity`
    *   `ViewModel` y `LiveData` para una arquitectura robusta.
    *   `ActivityResultContracts` para manejar resultados de actividades de forma moderna.
    *   `FileProvider` para compartir archivos de forma segura.
    *   `DialogFragment` para ventanas emergentes.
*   **Material Design Components:** Para una interfaz de usuario moderna y atractiva (botones, tarjetas, chips, etc.).
*   **Google ML Kit:** Para la funcionalidad de etiquetado de imágenes basada en IA.

## 🛠️ Configuración y Ejecución del Proyecto

Para configurar y ejecutar este proyecto en tu entorno de desarrollo:

1.  **Clona el repositorio:**
    \`\`\`bash
    git clone https://github.com/tu_usuario/EtiquetadorDeFotosApp.git
    cd EtiquetadorDeFotosApp
    \`\`\`
    *(Reemplaza `tu_usuario` con tu nombre de usuario de GitHub y `EtiquetadorDeFotosApp` con el nombre de tu repositorio)*

2.  **Abre el proyecto en Android Studio:**
    *   Abre Android Studio.
    *   Selecciona `File` > `Open` y navega hasta la carpeta raíz del proyecto que acabas de clonar.

3.  **Sincroniza el proyecto con Gradle:**
    *   Android Studio debería sincronizar automáticamente el proyecto con Gradle. Si no lo hace, haz clic en el icono de sincronización en la barra de herramientas.

4.  **Asegúrate de tener los recursos necesarios:**
    *   **`res/values/colors.xml`**: Contiene las definiciones de color.
    *   **`res/drawable/`**: Contiene los drawables como `header_gradient`, `image_placeholder_bg`, `button_gradient`, `confidence_badge`, `dialog_background.xml` e `ic_instagram.xml`.
    *   **`res/xml/file_paths.xml`**: Asegúrate de que este archivo exista y contenga la ruta para el `FileProvider`.

5.  **Ejecuta la aplicación:**
    *   Conecta un dispositivo Android físico o inicia un emulador.
    *   Haz clic en el botón `Run` (el triángulo verde) en la barra de herramientas de Android Studio.

## 💡 Uso de la Aplicación

1.  **Seleccionar Imagen:** Haz clic en el botón "Seleccionar" para elegir una imagen de tu galería.
2.  **Tomar Foto:** Haz clic en el botón "📸 Tomar Foto 📸" para usar la cámara de tu dispositivo. La primera vez, la aplicación solicitará permiso para acceder a la cámara.
3.  **Ajustar Confianza:** Usa la barra deslizante "Confianza Mínima" para ajustar el umbral de detección de objetos. Los resultados se actualizarán una vez que sueltes el deslizador.
4.  **Ver Resultados:** Los objetos detectados se mostrarán como "chips" con su nombre y porcentaje de confianza.
5.  **Compartir:** Haz clic en "Compartir Resultados" para compartir las etiquetas detectadas.
6.  **Créditos:** Haz clic en el texto "💖 Powered by Tortolitos" en el pie de página para ver los perfiles de Instagram de los creadores.

## 👥 Autores

*   **Bryan Armando Granados Hernandez**
*   **Lizbeth Rodriguez Roman**

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
*(Si no tienes un archivo LICENSE, puedes crearlo en la raíz de tu proyecto con el texto de la licencia MIT o la que prefieras.)*

