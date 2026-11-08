package org.example.HomeFunctional.Command;

import org.example.HomeFunctional.Model.Thermostat;

public class ThermostatCommand implements Command {
    private final Thermostat turnOnThermosthat;
    public ThermostatCommand (Thermostat turnOnThermosthat){
        this.turnOnThermosthat=turnOnThermosthat;
    }

    @Override
    public void execute() {
        turnOnThermosthat.turnOn();
    }
}
