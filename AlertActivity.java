package com.example.inputcontrols;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertActivity extends AppCompatActivity {

    Button next_button, previous_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        next_button = (Button)findViewById(R.id.second_activity_next_button);
        previous_button = (Button)findViewById(R.id.second_activity_previous_button);

        next_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(AlertActivity.this, PickerActivity.class);

                startActivity(intent);
            }
        });

        previous_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(AlertActivity.this, SpinnerInputControlActivity.class);

                startActivity(intent);
            }
        });

    }

    public void onClickShowAlert(View view) {

        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(AlertActivity.this);
         myAlertBuilder.setTitle(R.string.alert_title);
         myAlertBuilder.setMessage(R.string.alert_message);
         myAlertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.pressed_ok, Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.pressed_cancel, Toast.LENGTH_SHORT).show();
            }
        });

        myAlertBuilder.show();

    }
}
