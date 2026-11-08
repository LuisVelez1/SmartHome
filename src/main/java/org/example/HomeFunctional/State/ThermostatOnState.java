package org.example.HomeFunctional.State;

import org.example.HomeFunctional.Model.Device;
import org.example.HomeFunctional.Model.Thermostat;

public class ThermostatOnState implements HomeState {
    @Override
    public void PressTurnOn(Device device) {
        System.out.println("El termostato ya está encendido.");
    }

    @Override
    public void PressTurnOff(Device device) {
        System.out.println("Apagando el termostato...");
        ((Thermostat) device).setState(new ThermostatOffState());
    }
}