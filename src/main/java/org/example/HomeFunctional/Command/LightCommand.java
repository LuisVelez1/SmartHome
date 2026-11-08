package org.example.HomeFunctional.Command;

import org.example.HomeFunctional.Model.Light;

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
