package main;

import android.content.Context;
import serial.*;
import org.sintef.jarduino.*;
/**
 * Created with IntelliJ IDEA.
 * User: Jonathan
 * Date: 22/08/13
 * Time: 09:19
 */
class process extends JArduino {

    public process(Context c) {
        super(JArduinoCom.Serial, new AndroidUsbProtocolConfiguration(c));
    }

    @Override
    protected void setup() {
        // initialize the digital pin as an output.
        // Pin 13 has an LED connected on most Arduino boards:
        pinMode(DigitalPin.PIN_13, PinMode.OUTPUT);
    }

    @Override
    protected void loop() {
        // set the LED on
        digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH);
        delay(1000); // wait for a second
        // set the LED off
        digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
        delay(1000); // wait for a second
    }
}
