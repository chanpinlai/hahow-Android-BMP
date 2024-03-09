package com.tom.bmi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edHeight;
    private EditText edWeight;
    private TextView result;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edHeight = findViewById(R.id.ed_height);
        edWeight = findViewById(R.id.ed_weight);
        result = findViewById(R.id.result);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("HELP")
                        .setMessage("ody mass index (BMI) is a value derived from the mass (weight) and height of a person. ")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    public void bmi(View view) {
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity", "BMI:" + bmi);
        Toast.makeText(this, "Your BMI is " + bmi, Toast.LENGTH_LONG).show();
        result.setText("Your BMI is " + bmi);
        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage("Your BMI is " + bmi)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edHeight.setText("");
                        edWeight.setText("");
                    }
                })
                .show();


    }
}