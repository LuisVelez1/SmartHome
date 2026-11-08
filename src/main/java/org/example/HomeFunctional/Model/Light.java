package org.example.HomeFunctional.Model;

import org.example.HomeFunctional.State.HomeState;
import org.example.HomeFunctional.State.LightOffState;
import org.example.HomeFunctional.State.LightOnState;

public class Light implements Device {
    private HomeState currentState = new LightOffState();
    @Override
    public String getName() {
        return "Light";
    }
    public void setState(HomeState state) {
        this.currentState = state;
    }

    @Override
    public void turnOn() {
        currentState.PressTurnOn(this);
    }

    @Override
    public void turnOff() {
        currentState.PressTurnOff(this);
    }
}

