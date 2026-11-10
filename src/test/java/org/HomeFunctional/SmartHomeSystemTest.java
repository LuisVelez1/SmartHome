package org.HomeFunctional;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SmartHomeSystemTest {
    @Test void commandsAndStatesAreIdempotent() {
        SmartHomeSystem home = new SmartHomeSystem();
        home.setLight(true);
        home.setLight(true);
        assertTrue(home.lightOn());
        home.setLight(false);
        assertFalse(home.lightOn());
        home.setThermostat(true);
        assertTrue(home.thermostatOn());
    }
    @Test void strategiesCanBeSwapped() {
        SmartHomeSystem home = new SmartHomeSystem();
        home.setTemperatureMode("Eco");
        assertEquals(18, home.temperature());
        home.setTemperatureMode("Noche");
        assertEquals(19, home.temperature());
        home.setTemperatureMode("En casa");
        assertEquals(22, home.temperature());
        assertThrows(IllegalArgumentException.class, () -> home.setTemperatureMode("otro"));
    }
    @Test void observerAndMediatorReactToMotion() {
        SmartHomeSystem home = new SmartHomeSystem();
        List<String> alerts = new ArrayList<>();
        home.addNotificationListener(alerts::add);
        home.detectMotion();
        assertEquals(1, alerts.size());
        assertTrue(alerts.getFirst().contains("Entrada principal"));
        assertTrue(home.lightOn());
    }
    @Test void mediatorAndCompositeCoordinateDevices() {
        SmartHomeSystem home = new SmartHomeSystem();
        home.turnAllOn();
        assertTrue(home.lightOn());
        assertTrue(home.thermostatOn());
        home.leaveHome();
        assertFalse(home.lightOn());
        assertFalse(home.thermostatOn());
        assertTrue(home.securityActive());
        home.arriveHome();
        assertFalse(home.securityActive());
    }
}
