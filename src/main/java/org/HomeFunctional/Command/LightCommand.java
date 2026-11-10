package org.HomeFunctional.Command;

import org.HomeFunctional.Model.Light;

public class LightCommand implements Command {
    private final Light turnOnLight;

    public LightCommand (Light turnOnLight){
    this.turnOnLight = turnOnLight;
}

    @Override
    public void execute() {
        turnOnLight.turnOn();
    }
}
