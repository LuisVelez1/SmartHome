package org.HomeFunctional.Factory;

import org.HomeFunctional.Model.Device;
import org.HomeFunctional.Model.Light;

public class LightCreator extends AbstractDeviceCreator {
    @Override public Device createDevice() { return new Light(); }
}
