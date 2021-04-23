package com.example.inputcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerInputControlActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     private static final String TAG = SpinnerInputControlActivity.class.getSimpleName();
    private String mSpinnerLabel = "";

    Button next_button, previous_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_input_control);

        next_button = (Button)findViewById(R.id.second_activity_next_button);
        previous_button = (Button)findViewById(R.id.second_activity_previous_button);

        next_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(SpinnerInputControlActivity.this, AlertActivity.class);
                startActivity(intent);
            }
        });

        previous_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(SpinnerInputControlActivity.this, KeyboardsActivity.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        if (editText != null) {

            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            TextView phoneNumberResult = (TextView) findViewById(R.id.text_phone_label);
            if (phoneNumberResult != null) phoneNumberResult.setText(showString);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(pos).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }
}
