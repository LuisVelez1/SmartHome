package org.HomeFunctional.Strategy;

public class AtHomeStrategy implements TemperatureStrategy{
    @Override
    public int calculateTemperature(int baseTemp) {
        return 22;
    }
}
