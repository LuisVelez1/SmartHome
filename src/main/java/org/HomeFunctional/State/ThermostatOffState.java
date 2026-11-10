package org.HomeFunctional.State;

import org.HomeFunctional.Model.Device;
import org.HomeFunctional.Model.Thermostat;

public class ThermostatOffState implements HomeState {
    @Override
    public void PressTurnOn(Device device) {
        System.out.println("turning on the thermostat");
        ((Thermostat) device).setState(new ThermostatOnState());
    }

    @Override
    public void PressTurnOff(Device device) {
        System.out.println("The thermostat is already off");
    }
}