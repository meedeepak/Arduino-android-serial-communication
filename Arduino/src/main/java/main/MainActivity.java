package main;

import android.app.Activity;
import android.os.Bundle;

import org.sintef.jarduino.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JArduino arduino = new process(this);
        arduino.runArduinoProcess();
    }
}
