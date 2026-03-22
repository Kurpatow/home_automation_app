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
