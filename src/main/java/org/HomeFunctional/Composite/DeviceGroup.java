package org.HomeFunctional.Composite;

import org.HomeFunctional.Model.Device;
import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements Device {
    private String groupName;
    private List<Device> devices = new ArrayList<>();

    public DeviceGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public String getName() {
        return groupName;
    }

    @Override
    public void turnOn() {
        System.out.println("lighting group" + groupName + " ---");
        for (Device device : devices) {
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println("turning off group" + groupName + " ---");
        for (Device device : devices) {
            device.turnOff();
        }
    }
}