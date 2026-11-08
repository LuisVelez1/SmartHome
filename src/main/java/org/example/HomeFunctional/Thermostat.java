package org.example.HomeFunctional;

public abstract class Thermostat implements Device {
    private boolean Ison = false;
    private int Temperature = 20;

    @Override
    public String getName() {
        return "The thermostat";
    }

    @Override
    public void turnOn() {
        Ison = true;
        System.out.println("The thermostat is on");
    }

    @Override
    public void turnOff() {
        Ison = false;
        System.out.println("The thermostat is off");
    }
       }
    }
}
