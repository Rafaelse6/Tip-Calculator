package com.cursoandroid.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValue;
    private TextView textPercentage;
    private TextView textTip;
    private TextView textTotal;
    private SeekBar seekBarTip;
    private double percentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue    = findViewById(R.id.editValue);
        textPercentage = findViewById(R.id.textPercentage);
        textTip        = findViewById(R.id.textTip);
        textTotal      = findViewById(R.id.textTotal);
        seekBarTip     = findViewById(R.id.seekBarTip);



        //Add seekBar listener
        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                percentage = seekBar.getProgress();
                textPercentage.setText(Math.round(percentage) + "%");
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(){

        String recoveredValue = editValue.getText().toString();

        if(recoveredValue == null || recoveredValue.equals("")){
            Toast.makeText(getApplicationContext(),"Type a value", Toast.LENGTH_LONG).show();
        }else{
            //String to double convertion

            double typedValue = Double.parseDouble(recoveredValue);

            //Total tip calculation
            double tip = typedValue * (percentage/100);
            double total = tip + typedValue;

            //It shows the tip and total
            textTip.setText("$ " + tip);
            textTotal.setText("$ " +total);

        }

    }
}