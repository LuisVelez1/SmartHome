package org.HomeFunctional;

import org.HomeFunctional.Command.*;
import org.HomeFunctional.Composite.DeviceGroup;
import org.HomeFunctional.Factory.LightCreator;
import org.HomeFunctional.Factory.ThermostatCreator;
import org.HomeFunctional.Mediator.SmartHomeMediator;
import org.HomeFunctional.Model.Light;
import org.HomeFunctional.Model.Thermostat;
import org.HomeFunctional.Observer.NotificationCenter;
import org.HomeFunctional.Observer.Observer;
import org.HomeFunctional.Observer.Sensor;
import org.HomeFunctional.Singleton.SmartHomeConfig;
import org.HomeFunctional.Strategy.*;

/** Coordinates real user flows; the UI never needs to manipulate pattern internals. */
public class SmartHomeSystem {
    private final Light light = (Light) new LightCreator().createDevice();
    private final Thermostat thermostat = (Thermostat) new ThermostatCreator().createDevice();
    private final Sensor sensor = new Sensor("Entrada principal");
    private final SmartHomeMediator mediator = new SmartHomeMediator();
    private final RemoteControl remote = new RemoteControl();
    private final DeviceGroup allDevices = new DeviceGroup("Toda la casa");
    private final SmartHomeConfig config = SmartHomeConfig.getInstance();

    public SmartHomeSystem() {
        mediator.registerLight(light);
        mediator.registerThermostat(thermostat);
        allDevices.addDevice(light);
        allDevices.addDevice(thermostat);
        sensor.addObserver(new NotificationCenter());
        sensor.addObserver(message -> mediator.notify(light, "MOTION_DETECTED"));
    }

    public void addNotificationListener(Observer observer) { sensor.addObserver(observer); }
    public void setLight(boolean on) { execute(on ? new LightCommand(light) : new LightCommandOff(light)); }
    public void setThermostat(boolean on) { execute(on ? new ThermostatCommand(thermostat) : new ThermostatCommandOff(thermostat)); }
    private void execute(Command command) { remote.setCommand(command); remote.pressButton(); }
    public void setTemperatureMode(String mode) {
        TemperatureStrategy strategy = switch (mode) {
            case "Eco" -> new EcoModeStrategy();
            case "Noche" -> new NigthModeStrategy();
            case "En casa" -> new AtHomeStrategy();
            default -> throw new IllegalArgumentException("Modo desconocido: " + mode);
        };
        thermostat.changeTemperatureStrategy(strategy);
    }
    public void detectMotion() { sensor.detectMotion(); }
    public void leaveHome() { config.setSecurityModeActive(true); mediator.notify(light, "USER_AWAY"); }
    public void arriveHome() { config.setSecurityModeActive(false); }
    public void turnAllOn() { allDevices.turnOn(); }
    public void turnAllOff() { allDevices.turnOff(); }
    public boolean lightOn() { return light.isOn(); }
    public boolean thermostatOn() { return thermostat.isOn(); }
    public int temperature() { return thermostat.getTemperature(); }
    public boolean securityActive() { return config.isSecurityModeActive(); }
    public String homeName() { return config.getHomeName(); }
}
