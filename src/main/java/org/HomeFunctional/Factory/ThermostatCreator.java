package org.HomeFunctional.Factory;

import org.HomeFunctional.Model.Device;
import org.HomeFunctional.Model.Thermostat;

public class ThermostatCreator extends AbstractDeviceCreator {
    @Override public Device createDevice() { return new Thermostat(); }
}
