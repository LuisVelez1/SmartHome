package org.HomeFunctional.State;
import org.HomeFunctional.Model.Device;

public interface HomeState{
    void PressTurnOn(Device device);
    void PressTurnOff(Device device);
}
