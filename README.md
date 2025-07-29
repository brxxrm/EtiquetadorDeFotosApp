# 🚀💖 FOTOGLEES: El Google Lens Chafa ✨

✨ Una aplicación Android inteligente para identificar objetos en tus imágenes, con integración de cámara.

## 🛠️ Construido con la Magia de:

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white&labelColor=282C34)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white&labelColor=282C34)
![Android Jetpack](https://img.shields.io/badge/Android%20Jetpack-3DDC84?style=for-the-badge&logo=android&logoColor=white&labelColor=282C34)
![Material Design](https://img.shields.io/badge/Material%20Design-0081AF?style=for-the-badge&logo=material-design&logoColor=white&labelColor=282C34)
![Google ML Kit](https://img.shields.io/badge/Google%20ML%20Kit-4285F4?style=for-the-badge&logo=google&logoColor=white&labelColor=282C34)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white&labelColor=282C34)

## 📖 Tabla de Contenidos

*   [Descripción del Proyecto](#-descripción-del-proyecto)
*   [Características Principales](#-características-principales)
*   [Tecnologías Utilizadas](#-tecnologías-utilizadas)
*   [Estructura del Proyecto](#-estructura-del-proyecto)
*   [Configuración y Ejecución](#-configuración-y-ejecución)
*   [Uso de la Aplicación](#-uso-de-la-aplicación)
*   [Contribución](#-contribución)
*   [Autores](#-autores)


## 🌟 ¡Bienvenido a FotoGlees! 🌟

¿Cansado de ver fotos y no saber qué demonios hay en ellas? ¡No más! **FotoGlees** es tu nuevo mejor amigo en Android, una aplicación que no solo etiqueta objetos en tus imágenes, sino que lo hace con estilo y la potencia de la **Inteligencia Artificial de Google ML Kit**. Olvídate de los "Google Lens" aburridos, ¡esto es un "Google Lens pero chafa xd" con todo el sabor y la chispa de los **Tortolitos**!

Ya sea que quieras analizar esa foto misteriosa de tu galería o capturar el momento exacto con tu cámara, FotoGlees te dará las respuestas. Y lo mejor: puedes ajustar qué tan "confiable" quieres que sea la IA. ¡Pura magia!


## 🔥 Características que te Volarán la Cabeza:

*   **🧠 IA al Máximo Nivel:** No es magia, es **Google ML Kit** trabajando duro para identificar objetos, lugares y hasta conceptos abstractos en tus fotos. ¡Prepárate para el futuro!
*   **📸 Doble Vía de Entrada:**
    *   **Galería a la Mano:** Importa cualquier imagen de tu galería con un toque. ¡Fácil, rápido y sin complicaciones!
    *   **Cámara Instantánea:** Captura el momento y obtén resultados al instante. ¡Ideal para esos descubrimientos inesperados!
*   **🎯 Control Total de la Confianza:** ¿Quieres solo los resultados más precisos? ¡Usa nuestro deslizador de confianza! Filtra las etiquetas y obtén solo lo que realmente importa.
*   **✨ Resultados con Estilo:** Olvídate de las listas aburridas. Nuestras etiquetas vienen con:
    *   **Emojis Vibrantes:** Para que entiendas de un vistazo.
    *   **Traducciones al Español:** Porque hablamos tu idioma.
    *   **Porcentajes de Confianza:** Para que sepas qué tan segura está la IA.
*   **📱 Interfaz de Usuario de Otro Nivel:** Diseñada con **Material Design**, es tan intuitiva que hasta tu abuela la usaría. ¡Belleza y funcionalidad en un solo paquete!
*   **📤 ¡Comparte la Magia!:** ¿Resultados increíbles? Compártelos con tus amigos y presume de la inteligencia de FotoGlees.
*   **🔒 Seguridad y Permisos:** Manejo impecable de permisos de cámara y almacenamiento. Tu privacidad es nuestra prioridad.
*   **🚨 Mensajes Claros:** Si algo sale mal, te lo decimos sin rodeos para que sepas qué hacer.

## 💻 El Arsenal Tecnológico:

Este proyecto no es solo código, es una sinfonía de las mejores herramientas y bibliotecas del ecosistema Android:

*   **Lenguaje de Programación:**
    *   **Kotlin:** El rey indiscutible del desarrollo Android. Conciso, seguro y con un rendimiento que te dejará boquiabierto. 
*   **Plataforma y Frameworks:**
    *   **Android SDK:** La base de todo.
    *   **Android Jetpack:** La navaja suiza de Android. Hemos usado componentes clave para una arquitectura limpia y moderna:
        *   `AppCompatActivity`: Compatibilidad con versiones anteriores, ¡para que nadie se quede fuera!
        *   `ViewModel` & `LiveData`: Para una UI que reacciona al instante y una lógica de negocio impecable. ¡Adiós a los dolores de cabeza!
        *   `ActivityResultContracts`: Simplificando la interacción con otras apps (galería, cámara).
        *   `FileProvider`: Compartiendo archivos de forma segura, ¡sin fugas de información!
        *   `DialogFragment`: Para esos diálogos elegantes y funcionales, como el de Instagram.
*   **Diseño de Interfaz de Usuario:**
    *   **Material Design Components:** La estética de Google en su máxima expresión. Botones que dan ganas de tocar, tarjetas que resaltan y una experiencia visual que enamora.
*   **Inteligencia Artificial / Machine Learning:**
    *   **Google ML Kit (Image Labeling API):** El cerebro de la operación. Modelos pre-entrenados que hacen el trabajo pesado de reconocimiento de imágenes, ¡sin que tengas que ser un científico de datos!

## 🗺️ Estructura del Proyecto:

Aquí te mostramos cómo está organizado este monstruo de aplicación:

\`\`\`
.
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml       # El corazón de la app: permisos, componentes, etc.
│   │   │   ├── java/
│   │   │   │   └── com/example/etiquetafotoapp/
│   │   │   │       ├── MainActivity.kt           # La pantalla principal, donde todo sucede.
│   │   │   │       ├── ImageLabelingViewModel.kt # El cerebro detrás de la IA y la lógica de datos.
│   │   │   │       └── InstagramLinksDialogFragment.kt # El diálogo mágico para los perfiles de los creadores.
│   │   │   └── res/                      # ¡Aquí viven todos los recursos visuales y de texto!
│   │   │       ├── drawable/             # Iconos, fondos, gradientes... ¡la belleza visual!
│   │   │       │   ├── ic_instagram.xml  # El icono de Instagram, ¡obvio!
│   │   │       │   └── ... (y muchos más)
│   │   │       ├── layout/               # Cómo se ve cada pantalla y diálogo.
│   │   │       │   ├── activity_main.xml # El diseño de la pantalla principal.
│   │   │       │   └── dialog_instagram_links.xml # El diseño del diálogo de Instagram.
│   │   │       ├── values/               # Colores, textos y estilos que dan vida a la app.
│   │   │       │   ├── colors.xml        # La paleta de colores de FotoGlees.
│   │   │       │   ├── strings.xml       # Todos los textos de la app, ¡en español!
│   │   │       │   └── themes.xml        # El estilo general de la aplicación.
│   │   │       └── xml/                  # Archivos de configuración especiales.
│   │   │           └── file_paths.xml    # Crucial para que la cámara guarde las fotos de forma segura.
│   ├── build.gradle                      # Configuración de dependencias y compilación del módulo.
├── build.gradle                          # Configuración global de Gradle para todo el proyecto.
├── README.md                             # ¡Este documento épico que estás leyendo!
└── ... (otros archivos de configuración de Gradle y Git)
\`\`\`

## ⚙️ Configuración y Ejecución:

¿Listo para ver la magia en acción? Sigue estos sencillos pasos:

1.  **Clona este Repositorio (si aún no lo has hecho):**
    Abre tu terminal o Git Bash y ejecuta:
    \`\`\`bash
    git clone https://github.com/tu_usuario/EtiquetadorDeFotosApp.git
    cd EtiquetadorDeFotosApp
    \`\`\`
    *(¡No olvides reemplazar `tu_usuario` y `EtiquetadorDeFotosApp` con los datos de tu repo!)*

2.  **Abre el Proyecto en Android Studio:**
    *   Inicia Android Studio (¡la versión más reciente, por favor!).
    *   Ve a `File` > `Open` y selecciona la carpeta `EtiquetadorDeFotosApp` que acabas de clonar.

3.  **Sincroniza con Gradle (¡El Motor!):**
    *   Android Studio es inteligente y debería sincronizar el proyecto automáticamente. Si no lo hace, busca el icono del elefante con una flecha (sincronizar Gradle) en la barra de herramientas y haz clic. ¡Asegúrate de que todas las dependencias se descarguen sin problemas!

4.  **Verifica los Recursos Vitales:**
    Confirma que los siguientes archivos existen y están en su lugar. Son el alma de la UI y la funcionalidad de la cámara:
    *   `app/src/main/res/values/colors.xml`
    *   `app/src/main/res/values/strings.xml`
    *   `app/src/main/res/values/themes.xml`
    *   `app/src/main/res/drawable/dialog_background.xml`
    *   `app/src/main/res/drawable/ic_instagram.xml` (y todos los demás `drawable` que usamos para los gradientes y estilos).
    *   `app/src/main/res/xml/file_paths.xml` (¡Sin este, la cámara no funciona bien!).

5.  **Ejecuta la Aplicación:**
    *   Conecta tu dispositivo Android (¡con depuración USB activada!) o inicia un emulador.
    *   Haz clic en el botón `Run` (el triángulo verde) en la barra de herramientas de Android Studio.
    *   ¡Observa cómo FotoGlees se instala y cobra vida en tu dispositivo!

## 💡 Guía de Uso:

Una vez que la app esté rugiendo en tu dispositivo

1.  **La Pantalla Principal:** Verás un espacio para tu imagen, botones para la acción, un deslizador para la IA y el área donde aparecerán los resultados.
2.  **Seleccionar Imagen:**
    *   Toca el botón **"Seleccionar Imagen"**.
    *   Elige esa foto épica de tu galería.
    *   ¡Boom! La imagen se carga y la IA entra en acción.
3.  **Tomar Foto (¡Captura el Momento!):**
    *   Presiona el botón **"Tomar Foto"**.
    *   **¡Atención, Permisos!:** La primera vez, te pedirá permiso para la cámara. **¡CONCÉDELO!** Es vital para que la magia suceda.
    *   Toma tu foto, confírmala, y FotoGlees la procesará al instante.
4.  **Ajustar la Confianza (¡Sé el Jefe de la IA!):**
    *   Mueve el deslizador "Confianza Mínima".
    *   ¿Quieres solo resultados súper precisos? Súbele. ¿Quieres ver todo lo que la IA sospecha? Bájale. Los resultados se actualizarán en tiempo real.
5.  **Resultados Brillantes:**
    *   Después del procesamiento, verás los objetos detectados como "chips" coloridos. Cada uno con su emoji, nombre en español y el porcentaje de confianza.
    *   Si la IA no encuentra nada (¡raro, pero pasa!), te lo hará saber con un mensaje amigable.
6.  **¡Comparte tus Descubrimientos!:**
    *   El botón **"Compartir Resultados"** te permite presumir tus hallazgos en tus redes o chats.

## 🤝 ¡Únete a la Banda!:

¿Tienes ideas para hacer FotoGlees aún mejor? ¡Eres bienvenido!

1.  Haz un `fork` de este repositorio.
2.  Crea una nueva rama para tus cambios (`git checkout -b feature/tu-idea-genial`).
3.  Implementa tus mejoras y asegúrate de que todo funcione a la perfección.
4.  Haz un `commit` con un mensaje claro y conciso (`git commit -m "feat: Implementada la función de teletransportación de objetos"`).
5.  Sube tus cambios a tu rama (`git push origin feature/tu-idea-genial`).
6.  Abre un `Pull Request` en GitHub. ¡Estaremos emocionados de revisar tus aportes!

## 👥 Los Cerebritos Detrás de la Magia:

Este proyecto es el fruto del amor y el código de:

*   **Bryan Armando Granados Hernandez**
*   **Lizbeth Rodriguez Roman**
