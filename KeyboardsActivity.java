package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KeyboardsActivity extends AppCompatActivity {

    Button next_Activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboards);

        next_Activity_button = (Button)findViewById(R.id.first_activity_button);

        next_Activity_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(KeyboardsActivity.this, SpinnerInputControlActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        if (editText != null) {
            String showString = editText.getText().toString();
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
        }
    }
}