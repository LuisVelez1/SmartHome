package org.HomeFunctional.Strategy;

public class NigthModeStrategy implements TemperatureStrategy{
    @Override
    public int calculateTemperature(int baseTemp) {
        return 19;
    }
}
