package org.HomeFunctional.Model;

import org.HomeFunctional.State.HomeState;
import org.HomeFunctional.State.LightOffState;

public class Light implements Device {
    private HomeState currentState = new LightOffState();
    @Override
    public String getName() {
        return "Light";
    }
    public void setState(HomeState state) {
        this.currentState = state;
    }
    public boolean isOn() { return currentState instanceof org.HomeFunctional.State.LightOnState; }

    @Override
    public void turnOn() {
        currentState.PressTurnOn(this);
    }

    @Override
    public void turnOff() {
        currentState.PressTurnOff(this);
    }
}

