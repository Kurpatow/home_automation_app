package org.example;

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
    private  boolean isOn;

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