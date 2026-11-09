package org.HomeFunctional.Model;

import org.HomeFunctional.State.HomeState;
import org.HomeFunctional.State.ThermostatOffState;
import org.HomeFunctional.Strategy.TemperatureStrategy;

public class Thermostat implements Device {
    private HomeState currentState = new ThermostatOffState();
    private int temperature = 21;
    public void changeTemperatureStrategy(TemperatureStrategy strategy) {
        this.temperature = strategy.calculateTemperature(this.temperature);
    }

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
