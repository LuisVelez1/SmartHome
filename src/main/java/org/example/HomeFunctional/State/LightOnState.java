package org.example.HomeFunctional.State;

import org.example.HomeFunctional.Model.Device;
import org.example.HomeFunctional.Model.Light;

public class LightOnState implements HomeState {
    @Override
    public void PressTurnOn(Device device) {
        System.out.println("The light is already on");
    }

    @Override
    public void PressTurnOff(Device device) {
        System.out.println("turning off the light");
        ((Light)device).setState(new LightOffState());
    }
}