# 💖 FotoGlees

✨ Una aplicación Android inteligente para identificar objetos en tus imágenes, con integración de cámara y enlaces a los creadores.

## 🚀 Tecnologías Clave

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Android Jetpack](https://img.shields.io/badge/Android%20Jetpack-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-0081AF?style=for-the-badge&logo=material-design&logoColor=white)
![Google ML Kit](https://img.shields.io/badge/Google%20ML%20Kit-4285F4?style=for-the-badge&logo=google&logoColor=white)

## 📖 Tabla de Contenidos

*   [Descripción del Proyecto](#-descripción-del-proyecto)
*   [Características Principales](#-características-principales)
*   [Tecnologías Utilizadas](#-tecnologías-utilizadas)
*   [Estructura del Proyecto](#-estructura-del-proyecto)
*   [Configuración y Ejecución](#-configuración-y-ejecución)
*   [Uso de la Aplicación](#-uso-de-la-aplicación)
*   [Contribución](#-contribución)
*   [Autores](#-autores)

## 📸 Descripción del Proyecto

"FotoGlees" es una innovadora aplicación móvil desarrollada para la plataforma Android, diseñada para transformar la forma en que interactúas con tus imágenes. Utilizando la potente API de **Image Labeling de Google ML Kit**, la aplicación es capaz de analizar fotografías y detectar una amplia gama de objetos, conceptos y escenas presentes en ellas.

Los usuarios pueden cargar imágenes desde su galería personal o capturar nuevas fotos directamente a través de la cámara integrada de la aplicación. Una vez procesada, la aplicación presenta una lista clara y concisa de las etiquetas identificadas, cada una acompañada de un porcentaje de confianza que indica la precisión de la detección. Además, se ha implementado una barra deslizante para que los usuarios puedan ajustar el umbral de confianza, filtrando los resultados según sus preferencias.


## ✨ Características Principales

*   **Análisis Inteligente de Imágenes:** Identifica automáticamente objetos, lugares y conceptos en tus fotos utilizando algoritmos avanzados de Machine Learning.
*   **Múltiples Fuentes de Imagen:**
    *   **Selección de Galería:** Importa fácilmente cualquier imagen almacenada en tu dispositivo.
    *   **Captura Directa con Cámara:** Toma fotos en tiempo real y procésalas al instante.
*   **Control de Confianza:** Ajusta un umbral de confianza mínimo para los resultados de etiquetado, permitiéndote filtrar etiquetas menos precisas.
*   **Resultados Detallados y Localizados:** Muestra las etiquetas detectadas con:
    *   Emojis representativos para una mejor visualización.
    *   Traducciones al español para una comprensión intuitiva.
    *   Porcentajes de confianza para cada objeto identificado.
*   **Interfaz de Usuario Intuitiva:** Diseño limpio y moderno basado en Material Design para una experiencia de usuario fluida.
*   **Compartir Funcionalidad:** Exporta y comparte los resultados del etiquetado con otras aplicaciones o contactos.
*   **Manejo Robusto de Permisos:** Implementación de solicitudes de permisos en tiempo de ejecución para la cámara y el almacenamiento, garantizando la seguridad y la privacidad del usuario.
*   **Manejo de Errores:** Mensajes claros y útiles para guiar al usuario en caso de errores de carga o procesamiento.

## 💻 Tecnologías Utilizadas

Este proyecto ha sido construido utilizando las siguientes tecnologías y bibliotecas:

*   **Lenguaje de Programación:**
    *   **Kotlin:** El lenguaje moderno y preferido para el desarrollo de aplicaciones Android, conocido por su concisión y seguridad.
*   **Plataforma y Frameworks:**
    *   **Android SDK:** El kit de desarrollo de software para la plataforma Android.
    *   **Android Jetpack:** Un conjunto de bibliotecas que ayudan a los desarrolladores a seguir las mejores prácticas, reducir el código repetitivo y escribir código que funcione de manera consistente en diferentes versiones y dispositivos de Android. Componentes clave utilizados incluyen:
        *   `AppCompatActivity`: Para compatibilidad con versiones anteriores de Android.
        *   `ViewModel` y `LiveData`: Para una arquitectura robusta y reactiva, separando la lógica de negocio de la UI.
        *   `ActivityResultContracts`: Para un manejo simplificado de resultados de actividades (selección de imagen, toma de foto).
        *   `FileProvider`: Para compartir archivos de forma segura entre aplicaciones.
        *   `DialogFragment`: Para la creación de diálogos modales (como el de los enlaces de Instagram).
*   **Diseño de Interfaz de Usuario:**
    *   **Material Design Components:** Implementación de componentes UI de Google para una apariencia moderna y consistente (MaterialCardView, MaterialButton, ChipGroup, SeekBar, ProgressBar, etc.).
*   **Inteligencia Artificial / Machine Learning:**
    *   **Google ML Kit (Image Labeling API):** La columna vertebral de la funcionalidad de etiquetado de imágenes, proporcionando modelos pre-entrenados para la detección de objetos.

## 📂 Estructura del Proyecto

La estructura principal del proyecto sigue las convenciones estándar de Android:

\`\`\`
.
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml       # Permisos y configuración de la app
│   │   │   ├── java/
│   │   │   │   └── com/example/etiquetafotoapp/
│   │   │   │       ├── MainActivity.kt           # Actividad principal de la UI
│   │   │   │       ├── ImageLabelingViewModel.kt # Lógica de negocio y ML Kit
│   │   │   │       └── InstagramLinksDialogFragment.kt # Diálogo para enlaces de Instagram
│   │   │   └── res/                      # Recursos de la aplicación
│   │   │       ├── drawable/             # Drawables (iconos, fondos, etc.)
│   │   │       │   ├── ic_instagram.xml
│   │   │       │   └── ... (otros drawables)
│   │   │       ├── layout/               # Archivos de diseño de la UI
│   │   │       │   ├── activity_main.xml
│   │   │       │   └── dialog_instagram_links.xml
│   │   │       ├── values/               # Valores (cadenas, colores, estilos)
│   │   │       │   ├── colors.xml
│   │   │       │   ├── strings.xml
│   │   │       │   └── themes.xml
│   │   │       └── xml/                  # Archivos XML adicionales (FileProvider)
│   │   │           └── file_paths.xml
│   ├── build.gradle                      # Configuración del módulo de la app
├── build.gradle                          # Configuración global del proyecto
├── README.md                             # Este archivo de documentación
└── ... (otros archivos de configuración)
\`\`\`

## ⚙️ Configuración y Ejecución

Para poner en marcha "FotoGlees" en tu entorno de desarrollo:

1.  **Clona el Repositorio:**
    Abre tu terminal o Git Bash y ejecuta:
    \`\`\`bash
    git clone https://github.com/tu_usuario/EtiquetadorDeFotosApp.git
    cd EtiquetadorDeFotosApp
    \`\`\`
    *(Asegúrate de reemplazar `tu_usuario` con tu nombre de usuario de GitHub y `EtiquetadorDeFotosApp` con el nombre exacto de tu repositorio).*

2.  **Abre el Proyecto en Android Studio:**
    *   Inicia Android Studio.
    *   Selecciona `File` > `Open` y navega hasta la carpeta `EtiquetadorDeFotosApp` que acabas de clonar.

3.  **Sincroniza con Gradle:**
    *   Android Studio debería iniciar automáticamente la sincronización del proyecto con Gradle. Si no lo hace, busca el icono de sincronización (un elefante con una flecha) en la barra de herramientas y haz clic en él. Asegúrate de que todas las dependencias se descarguen correctamente.

4.  **Verifica los Recursos Esenciales:**
    Confirma la existencia y el contenido de los siguientes archivos, que son cruciales para el correcto funcionamiento de la UI y la cámara:
    *   `app/src/main/res/values/colors.xml`
    *   `app/src/main/res/values/strings.xml`
    *   `app/src/main/res/values/themes.xml`
    *   `app/src/main/res/drawable/dialog_background.xml`
    *   `app/src/main/res/drawable/ic_instagram.xml` (y otros drawables como `header_gradient`, `button_gradient`, etc.)
    *   `app/src/main/res/xml/file_paths.xml` (esencial para el `FileProvider` de la cámara).

5.  **Ejecuta la Aplicación:**
    *   Conecta un dispositivo Android físico a tu computadora (asegúrate de tener la depuración USB activada) o inicia un emulador de Android.
    *   Haz clic en el botón `Run` (el icono de triángulo verde) en la barra de herramientas de Android Studio. La aplicación se instalará y ejecutará en tu dispositivo/emulador.

## 💡 Uso de la Aplicación

Una vez que la aplicación esté instalada y en ejecución:

1.  **Pantalla Principal:** Verás un área para la imagen, botones para seleccionar/tomar fotos, una barra deslizante de confianza y un área para los resultados.
2.  **Seleccionar Imagen:**
    *   Toca el botón **"Seleccionar imagen"**.
    *   Se abrirá el selector de imágenes de tu dispositivo. Elige una foto de tu galería.
    *   La imagen se cargará y la aplicación comenzará a procesarla automáticamente.
3.  **Tomar Foto:**
    *   Toca el botón **"Tomar Foto"**.
    *   **Permisos:** La primera vez que uses esta función, la aplicación solicitará permiso para acceder a la cámara. **Debes concederlo** para que la función de cámara funcione.
    *   Se abrirá la aplicación de cámara de tu dispositivo. Toma una foto.
    *   Confirma la foto, y esta se cargará en la aplicación para su procesamiento.
4.  **Ajustar Confianza:**
    *   Usa la barra deslizante etiquetada como "Confianza Mínima".
    *   Desliza el control para aumentar o disminuir el umbral de confianza. Los resultados de etiquetado se actualizarán dinámicamente una vez que sueltes el deslizador, mostrando solo las etiquetas que superen el porcentaje de confianza seleccionado.
5.  **Ver Resultados:**
    *   Después de procesar una imagen, los objetos detectados se mostrarán en la sección "🎯 Objetos Detectados" como "chips" interactivos, con su emoji, nombre en español y porcentaje de confianza.
    *   Si no se detectan objetos o no cumplen con el umbral de confianza, se mostrará un mensaje indicando la ausencia de resultados.
6.  **Compartir Resultados:**
    *   Haz clic en el botón **"Compartir Resultados"** para generar un texto con todas las etiquetas detectadas y compartirlo a través de tus aplicaciones de mensajería o redes sociales.

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, por favor:

1.  Haz un "fork" del repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3.  Realiza tus cambios y asegúrate de que el código compile y funcione correctamente.
4.  Escribe un mensaje de "commit" claro (`git commit -m "feat: Añadir nueva funcionalidad X"`).
5.  Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
6.  Abre un "Pull Request" en GitHub.

## 👥 Autores

Este proyecto ha sido desarrollado con 💖 por:

*   **Bryan Armando Granados Hernandez**
*   **Lizbeth Rodriguez Roman**

