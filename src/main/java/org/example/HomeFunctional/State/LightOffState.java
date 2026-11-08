package org.example.HomeFunctional.State;

import org.example.HomeFunctional.Model.Device;
import org.example.HomeFunctional.Model.Light;

public class LightOffState implements HomeState {
    @Override
    public void PressTurnOn(Device device) {
        System.out.println("Encendiendo la luz...");
        ((Light)device).setState(new LightOnState());
    }

    @Override
    public void PressTurnOff(Device device) {
        System.out.println("La luz ya está apagada.");
    }
}