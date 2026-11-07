package org.example.HomeFunctional;

public abstract class Light implements Device{
    private boolean isOn = false;
    @Override
    public String getName() {
        return "Light";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("The smart light is on");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("The smart light is off");
    }

    @Override
    public String getStatus() {
      if ( isOn == true ){
     return "ON";
    } else {
      return "OFF";
    }
}
}
