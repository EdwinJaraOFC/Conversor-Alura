# 💱 Conversor de Monedas - Alura Challenge

Este proyecto es un conversor de monedas hecho en **Java**, desarrollado como parte de un reto del programa **Alura Challenge - Oracle Next Education**. Permite convertir entre distintas divisas latinoamericanas y el dólar estadounidense, utilizando datos en tiempo real obtenidos de la API de ExchangeRate.

## 🚀 Funcionalidades

- Menú interactivo por consola.
- Conversión entre monedas como:
  - ARS (Peso argentino)
  - BOB (Boliviano)
  - BRL (Real brasileño)
  - CLP (Peso chileno)
  - COP (Peso colombiano)
  - PEN (Sol peruano)
  - USD (Dólar estadounidense)
- Tasas de cambio actualizadas desde una API externa.
- Validaciones de entrada y manejo de errores.

## 🛠️ Tecnologías utilizadas

- **Java 17+**
- **HttpClient** (para consumir la API REST)
- **Gson** (para parseo de JSON)
- **Módulo modularizado por paquetes**: `principal`, `conversor`, `util`

## 🏗️ Estructura del proyecto

```
src/
└── com.alurachallenge
    ├── conversor        # Lógica de conversión y acceso a la API
    │   ├── Conversor.java
    │   └── ConversionResponse.java
    └── principal        # Clase principal y menú interactivo
        ├── Principal.java
        └── Menu.java
```

## ⚙️ ¿Cómo ejecutar el proyecto?

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/conversor-moneda.git
   cd conversor-moneda
   ```

2. Asegúrate de tener Java 17+ instalado. Puedes verificarlo con:
   ```bash
   java -version
   ```

3. Compila y ejecuta desde consola (o usa tu IDE favorito como IntelliJ o Eclipse):
   ```bash
   javac -d out src/com/alurachallenge/**/*.java
   java -cp out com.alurachallenge.principal.Principal
   ```

## 🔑 Sobre la API utilizada

Este proyecto consume datos desde:

🌍 [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

El archivo `Conversor.java` contiene tu clave API personal. **Reemplázala por la tuya** si planeas subir tu versión pública.

## ✨ Posibles mejoras futuras

- Agregar historial de conversiones.
- Persistencia de datos en archivo local o base de datos.
- Interfaz gráfica (GUI) con Swing o JavaFX.
- Soporte para más monedas configurables.

## 📚 Créditos

Desarrollado por **Edwin Junior** como parte del programa **Oracle + Alura LATAM**.

## 📝 Licencia

Este proyecto es de código abierto y puede ser adaptado libremente con fines educativos.
