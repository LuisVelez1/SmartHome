package org.HomeFunctional.Command;

import org.HomeFunctional.Model.Thermostat;

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
