package org.HomeFunctional.Strategy;

public class EcoModeStrategy implements TemperatureStrategy{
    @Override
    public int calculateTemperature(int baseTemp) {
        return +7;
    }
}
