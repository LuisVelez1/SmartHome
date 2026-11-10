package org.HomeFunctional.Factory;

import org.HomeFunctional.Model.Device;

/** Factory Method: subclasses decide which concrete device is instantiated. */
public abstract class AbstractDeviceCreator {
    public abstract Device createDevice();
}
