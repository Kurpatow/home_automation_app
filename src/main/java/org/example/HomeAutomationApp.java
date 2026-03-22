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