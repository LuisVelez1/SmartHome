package org.HomeFunctional.Mediator;

import org.HomeFunctional.Model.Device;

public interface HomeMediator {
    void notify(Device sender, String event);
}