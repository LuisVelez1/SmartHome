package org.example.HomeFunctional.Model;

import org.example.HomeFunctional.State.HomeState;
import org.example.HomeFunctional.State.ThermostatOffState;
import org.example.HomeFunctional.State.ThermostatOnState;

public class Thermostat implements Device {
    private HomeState currentState = new ThermostatOffState();
    private int temperature = 20;

    @Override
    public String getName() {
        return "The thermostat";
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
