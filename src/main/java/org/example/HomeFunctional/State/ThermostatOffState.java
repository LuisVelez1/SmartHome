package org.example.HomeFunctional.State;

import org.example.HomeFunctional.Model.Device;
import org.example.HomeFunctional.Model.Thermostat;

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