package pollub.ism.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textArea = null;
    private EditText editArea = null;
    private Button   button1  = null,
                     button2  = null,
                     button3  = null;

    private int createCounter  = 0,
                startCounter   = 0,
                resumeCounter  = 0,
                pauseCounter   = 0,
                stopCounter    = 0,
                restartCounter = 0,
                destroyCounter = 0;

    private static String CREATE_COUNT  = "Wartosc licznika create",
                          START_COUNT   = "Wartosc licznika start",
                          RESUME_COUNT  = "Wartosc licznika resume",
                          PAUSE_COUNT   = "Wartosc licznika pause",
                          STOP_COUNT    = "Wartosc licznika stop",
                          RESTART_COUNT = "Wartosc licznika restart",
                          DESTROY_COUNT = "Wartosc licznika destroy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textArea = (TextView) findViewById(R.id.textView2);
        editArea = (EditText) findViewById(R.id.editText);
        button1  = (Button) findViewById(R.id.button1);
        button2  = (Button) findViewById(R.id.button2);
        button3  = (Button) findViewById(R.id.button3);

        editArea.setEnabled(false);
        button2.setText(getResources().getString(R.string.unlock));

        showActivity("onCreate");
        createCounter++;
    }

    @Override
    protected void onStart() {
        super.onStart();

        showActivity("onStart");
        startCounter++;
    }

    @Override
    protected void onResume() {
        super.onResume();

        showActivity("onResume");
        resumeCounter++;
    }

    @Override
    protected void onPause() {
        super.onPause();

        showActivity("onPause");
        pauseCounter++;
    }

    @Override
    protected void onStop() {
        super.onStop();

        showActivity("onStop");
        stopCounter++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        showActivity("onRestart");
        restartCounter++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showActivity("onDestroy");
        destroyCounter++;
    }

    private void showActivity(String info) {
        textArea.setText(info);
        editArea.append(info);
    }

    public void clearEditArea(View view) {
        editArea.setText("");
    }

    public void toggleEditAreaLock(View view) {
        editArea.setEnabled(!editArea.isEnabled());

        if (editArea.isEnabled()) {
            button2.setText(getResources().getString(R.string.lock));
        } else {
            button2.setText(getResources().getString(R.string.unlock));
        }
    }

    public void showVariables(View view) {
        String info = "create = "    + createCounter  + " "
                    + "start = "     + startCounter   + " "
                    + "resume = "    + resumeCounter  + "\n"
                    + "pause = "     + pauseCounter   + " "
                    + "stop = "      + stopCounter    + " "
                    + "restart = "   + restartCounter + "\n"
                    + "destroy = "   + destroyCounter + "\n";

        editArea.append(info);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CREATE_COUNT, createCounter);
        outState.putInt(START_COUNT, startCounter);
        outState.putInt(RESUME_COUNT, resumeCounter);
        outState.putInt(PAUSE_COUNT, pauseCounter);
        outState.putInt(STOP_COUNT, stopCounter);
        outState.putInt(RESTART_COUNT, restartCounter);
        outState.putInt(DESTROY_COUNT, destroyCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        createCounter  = savedInstanceState.getInt(CREATE_COUNT, 0);
        startCounter   = savedInstanceState.getInt(START_COUNT, 0);
        resumeCounter  = savedInstanceState.getInt(RESUME_COUNT, 0);
        pauseCounter   = savedInstanceState.getInt(PAUSE_COUNT, 0);
        stopCounter    = savedInstanceState.getInt(STOP_COUNT, 0);
        restartCounter = savedInstanceState.getInt(RESTART_COUNT, 0);
        destroyCounter = savedInstanceState.getInt(DESTROY_COUNT, 0);
    }
}