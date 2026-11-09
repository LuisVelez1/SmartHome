package org.HomeFunctional.Command;

import org.HomeFunctional.Model.Thermostat;

public class ThermostatCommandOff implements Command {
    private final Thermostat turnOffThermosthat;
    public ThermostatCommandOff (Thermostat turnOffThermosthat){
        this.turnOffThermosthat=turnOffThermosthat;
    }

    @Override
    public void execute() {
        turnOffThermosthat.turnOff();
    }
}


