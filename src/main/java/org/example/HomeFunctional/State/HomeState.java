package org.example.HomeFunctional.State;
import org.example.HomeFunctional.Model.Device;

public interface HomeState{
    void PressTurnOn(Device device);
    void PressTurnOff(Device device);
}
