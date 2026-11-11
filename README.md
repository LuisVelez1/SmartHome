# SmartHome · Parcial 3

**Aplicación de e**scritorio de gestión y automatización de un hogar inteligente con Java 21, JavaFX y FXML. Simula luces, termostato, sensor de movimiento, modo ausente y control de grupos. La pantalla presenta estados y un registro de eventos; no controla hardware real.

## Requisitos y ejecución

Instalar JDK 21 y Maven 3.9+ y contar con una sesión gráfica:

```bash
java -version
mvn clean test
mvn javafx:run
```

*Maven descarga las dependencias de JavaFX automáticamente.*

## Demostración

1. Encender y apagar la luz y el termostato; repetir la operación para comprobar que **State** maneja estados existentes.
2. Elegir En casa (22 °C), Eco (18 °C) o Noche (19 °C); comprobar el cambio de **Strategy**.
3. Simular movimiento: **Observer** envía la alerta al registro y a **Mediator**, que enciende la luz.
4. Encender toda la casa mediante **Composite** y después pulsar Salir de casa; **Mediator** apaga ambos dispositivos y se activa el indicador de ausencia.
5. Pulsar Volver a casa para desactivar el modo ausente.

## Estructura general

* `src/main/java/org/HomeFunctional/Main.java`: arranque de JavaFX.
* `src/main/resources/smarthome.fxml`: interfaz declarativa FXML.
* `HomeController.java`: acciones de botones, visualización y registro.
* `SmartHomeSystem.java`: casos de uso e integración entre patrones (Fachada).
* `Model/`: dispositivos `Light`, `Thermostat` e interfaz `Device`.
* `Observer/`, `Strategy/`, `Command/`, `State/`, `Mediator/`, `Factory/`, `Composite/`, `Singleton/`: patrones.
* `src/test/java/org/HomeFunctional/SmartHomeSystemTest.java`: pruebas funcionales del núcleo.

## Patrones, ubicaciones y justificación

| Patrón | Clases principales | Uso real | 
| ----- | ----- | ----- | 
| **Observer** (8 puntos) | `Observer/Sensor`, `Observer/Observer`, `Observer/NotificationCenter` | El sensor notifica a múltiples observadores sin conocer sus responsabilidades: registro y automatización. | 
| **Strategy** (8 puntos) | `Strategy/TemperatureStrategy`, `AtHomeStrategy`, `EcoModeStrategy`, `NigthModeStrategy` | El termostato cambia su política de temperatura según el perfil seleccionado en pantalla. | 
| **Command** (8 puntos) | `Command/Command`, `RemoteControl`, `LightCommand`, `LightCommandOff`, `ThermostatCommand`, `ThermostatCommandOff` | Cada botón individual encapsula una orden y la envía por un invocador. | 
| **State** (8 puntos) | `State/HomeState`, `LightOnState`, `LightOffState`, `ThermostatOnState`, `ThermostatOffState` | La respuesta de encender/apagar depende del estado actual de cada dispositivo. | 
| **Mediator** (8 puntos) | `Mediator/HomeMediator`, `SmartHomeMediator` | Coordina las reacciones entre sensor, luz y termostato ante movimiento o salida de casa. | 
| **Factory Method** (creacional, peso 2) | `Factory/AbstractDeviceCreator`, `LightCreator`, `ThermostatCreator` | Las subclases concretas deciden qué dispositivo instanciar. `SmartHomeSystem` usa ambos creadores. | 
| **Composite** (estructural, peso 3) | `Composite/DeviceGroup`, `Model/Device` | El grupo se controla con `turnOn` y `turnOff` como si fuera un dispositivo individual. | 
| **Singleton** (creacional, peso 1) | `Singleton/SmartHomeConfig` | Mantiene la configuración compartida y el indicador del modo ausente. | 
| **Facade** (estructural, extra) | `SmartHomeSystem` | Actúa como puente aislando la interfaz gráfica (`HomeController`) de la complejidad de los otros 8 patrones. | 

> **Nota:** Los patrones creacionales y estructurales adicionales suman 6 de peso de complejidad (2 + 3 + 1); participan activamente en el flujo. `Factory/DeviceFactory` se conserva como fábrica simple por compatibilidad, pero el Factory Method central es `AbstractDeviceCreator` con sus subclases. Además, se implementó un **noveno patrón (Facade)** para garantizar un bajo acoplamiento con la vista FXML.

## Entregables y colaboración completados

* [x] Cada integrante debe aportar commits auténticos desde su cuenta y participar en PRs y merges; no se deben atribuir contribuciones ajenas.
* [x] Verificar en una computadora con escritorio gráfico que abre la pantalla y funcionan los flujos anteriores.
* [x] Grabar video con todos los integrantes visibles, explicando su trabajo, el código y la demostración de los ocho patrones.
* [x] Publicar el video en YouTube y añadir aquí su enlace: **https://www.youtube.com/watch?v=a3JX7COIVp0**
* [x] Entregar los enlaces del repositorio y del video al docente.

**Repositorio del proyecto:** https://github.com/LuisVelez1/SmartHome
