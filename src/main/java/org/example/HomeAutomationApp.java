package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Controllable {
    void turnOn();
    void  turnOff();
}

interface Measurable {
    double getMeasurement();
}

interface Alertable {
    void sendAlert(String message);
}

abstract class Device {
    protected String name;
    protected String type;

    public Device(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }

    public String getType() { return type; }
}

class Light extends Device implements Controllable, Alertable {
    private boolean isOn;

    public Light(String name) {
        super(name, "Light");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert from " + name + ": " + message);
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " light turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " light turned off.");
    }
}
    class Thermostat extends Device implements Controllable, Measurable {
        private boolean isHeating;
        private  double currentTemperature;

        public Thermostat(String name) {
            super(name, "Thermostat");
            currentTemperature = 20.0;
        }

        @Override
        public void turnOn() {
         isHeating = true;
            System.out.println(name + " thermostat turned on.");
        }

        @Override
        public void turnOff() {
            isHeating = false;
            System.out.println(name + " thermostat turned off.");
        }

        @Override
        public double getMeasurement() {
            return currentTemperature;
        }
    }
    class HomeAutomationSystem {
        private List<Device> devices;
        private Map<String, Device> deviceMap;

        public HomeAutomationSystem() {
            devices = new ArrayList<>();
            deviceMap = new HashMap<>();
        }

        public void addDevice(Device device) {
            devices.add(device);
            deviceMap.put(device.getName(),device);
        }

        public void turnOnDevice(String name) {
            Device device = deviceMap.get(name);
            if (device != null && device instanceof Controllable) {
                ((Controllable) device).turnOn();
            }
        }

        public void sendAlert(String name, String message) {
            Device device = deviceMap.get(name);
            if (device != null && device instanceof Alertable) {
                ((Alertable) device).sendAlert(message);
            }
        }
    }
public class HomeAutomationApp {
    public static void main(String[] args) {
        HomeAutomationSystem system = new HomeAutomationSystem();

        Light livingRoomLight = new Light("Living Room");
        Thermostat bedroomThermostat = new Thermostat("Bedroom");

        system.addDevice(livingRoomLight);
        system.addDevice(bedroomThermostat);

        system.turnOnDevice("Living Room");
        system.turnOnDevice("Bedroom");

        system.sendAlert("Living Room", "Intruder detected!");

        if (bedroomThermostat instanceof Measurable) {
            double temperature = ((Measurable) bedroomThermostat).getMeasurement();
            System.out.println("Current temperature in Bedroom: " + temperature + "C");
        }
    }
}