package org.HomeFunctional.Factory;

import org.HomeFunctional.Model.Device;
import org.HomeFunctional.Model.Light;
import org.HomeFunctional.Model.Thermostat;

public class DeviceFactory {
    public static Device createDevice(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("LIGHT")) {
            return new Light();
        } else if (type.equalsIgnoreCase("THERMOSTAT")) {
            return new Thermostat();
        }
        throw new IllegalArgumentException("Unknown device type: " + type);
    }
}