package org.HomeFunctional;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HomeController {
    @FXML private Label homeTitle;
    @FXML private Label lightStatus;
    @FXML private Label thermostatStatus;
    @FXML private Label temperatureStatus;
    @FXML private Label securityStatus;
    @FXML private ComboBox<String> modeSelector;
    @FXML private TextArea eventLog;
    private final SmartHomeSystem home = new SmartHomeSystem();

    @FXML
    private void initialize() {
        homeTitle.setText(home.homeName());
        modeSelector.getItems().addAll("En casa", "Eco", "Noche");
        modeSelector.setValue("En casa");
        home.addNotificationListener(message -> log("ALERTA: " + message));
        refresh();
        log("Sistema iniciado. Utiliza los controles para simular el hogar.");
    }

    @FXML private void lightOn() { home.setLight(true); changed("Luz encendida mediante Command y State"); }
    @FXML private void lightOff() { home.setLight(false); changed("Luz apagada mediante Command y State"); }
    @FXML private void thermostatOn() { home.setThermostat(true); changed("Termostato encendido mediante Command y State"); }
    @FXML private void thermostatOff() { home.setThermostat(false); changed("Termostato apagado mediante Command y State"); }
    @FXML private void changeMode() { home.setTemperatureMode(modeSelector.getValue()); changed("Strategy: modo " + modeSelector.getValue()); }
    @FXML private void motion() { home.detectMotion(); changed("Mediator: sensor activa la luz"); }
    @FXML private void leave() { home.leaveHome(); changed("Mediator: salida de casa, dispositivos apagados"); }
    @FXML private void arrive() { home.arriveHome(); changed("Modo presencia activado"); }
    @FXML private void allOn() { home.turnAllOn(); changed("Composite: todos los dispositivos encendidos"); }
    @FXML private void allOff() { home.turnAllOff(); changed("Composite: todos los dispositivos apagados"); }

    private void changed(String text) { refresh(); log(text); }
    private void log(String text) { eventLog.appendText("• " + text + "\n"); }
    private void refresh() {
        lightStatus.setText(home.lightOn() ? "Encendida" : "Apagada");
        thermostatStatus.setText(home.thermostatOn() ? "Encendido" : "Apagado");
        temperatureStatus.setText(home.temperature() + " °C");
        securityStatus.setText(home.securityActive() ? "Ausente · vigilancia" : "En casa");
    }
}
