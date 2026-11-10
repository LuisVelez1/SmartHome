package org.HomeFunctional.Mediator;

import org.HomeFunctional.Model.Device;
import org.HomeFunctional.Model.Light;
import org.HomeFunctional.Model.Thermostat;

public class SmartHomeMediator implements HomeMediator {
    private Light light;
    private Thermostat thermostat;

    public void registerLight(Light light) {
        this.light = light;
    }

    public void registerThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void notify(Device sender, String event) {
        if (event.equals("MOTION_DETECTED")) {
            System.out.println("Movement detected. Coordinating actions at home");

            if (light != null) {
                light.turnOn();
            }
        } else if (event.equals("USER_AWAY")) {
            System.out.println("User away. Powering off devices");
            if (light != null) {
                light.turnOff();
            }
            if (thermostat != null) {
                thermostat.turnOff();
            }
        }
    }
}