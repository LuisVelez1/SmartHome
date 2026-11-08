package org.example.HomeFunctional.Command;

import org.example.HomeFunctional.Model.Light;

public class LightCommandOff implements Command {
    private final Light turnOffLight;

    public LightCommandOff (Light turnOffLight){
        this.turnOffLight = turnOffLight;
    }

    @Override
    public void execute() {
        turnOffLight.turnOff();
    }
}