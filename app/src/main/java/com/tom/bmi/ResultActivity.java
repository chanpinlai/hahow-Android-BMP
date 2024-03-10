package com.tom.bmi;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.result2);
        float bmi = getIntent().getFloatExtra("BMI",0);
        result.setText(getString(R.string.your_bmi_is)+bmi);
    }
}