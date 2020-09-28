package com.example.tipcalculatorapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {
//    EditText checkAmountInput = findViewById(R.id.checkAmountValue);
//    EditText partySizeInput = findViewById(R.id.partySizeValue);
//    EditText fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
//    EditText twentyPercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
//    EditText twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
//    EditText fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
//    EditText twentyPercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
//    EditText twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
//    Button buttonCompute = findViewById(R.id.buttonCompute);

    public boolean isInvalidInput(String checkAmountInput, String partySizeInput){
        if(checkAmountInput.matches("") || partySizeInput.matches("")){
            return true;
        }
        try{
            double checkAmount = Double.parseDouble(checkAmountInput);
            int partySize = Integer.parseInt(partySizeInput);
            if(checkAmount <= 0 && partySize <=0) return true;
        }catch (Exception e){
            return true;
        }
        return false;
    }
    public void calculateTip(View view) {
        EditText checkAmountInput = findViewById(R.id.checkAmountValue);
        EditText partySizeInput = findViewById(R.id.partySizeValue);
        EditText fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        EditText twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        EditText twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        EditText fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        EditText twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        EditText twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
        Button buttonCompute = findViewById(R.id.buttonCompute);
        // if the inputted information is valid checker
        if(isInvalidInput(checkAmountInput.getText().toString(), partySizeInput.getText().toString())){
            Toast.makeText(this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
            return;
        }

        // calculate tip for each percentage
        double checkAmountValue = Double.parseDouble(checkAmountInput.getText().toString());
        int partySizeValue= Integer.parseInt(partySizeInput.getText().toString());
        double fifteenPercent = .15;
        double twentyPercent = .20;
        double twentyfivePercent = .25;
        int fifteenTip = (int) Math.round((checkAmountValue * fifteenPercent) / partySizeValue);
        // cast to int because it return a long and we want an int
        int twentyTip = (int) Math.round((checkAmountValue * twentyPercent) / partySizeValue);
        int twentyFiveTip = (int) Math.round((checkAmountValue * twentyfivePercent) / partySizeValue);
        fifteenPercentTipValue.setText(Integer.toString(fifteenTip));
        twentyPercentTipValue.setText(Integer.toString(twentyTip));
        twentyfivePercentTipValue.setText(Integer.toString(twentyFiveTip));
        int partySplit = (int) Math.round(checkAmountValue / partySizeValue);
        fifteenPercentTotalValue.setText(Integer.toString( partySplit + fifteenTip ));
        twentyPercentTotalValue.setText(Integer.toString( partySplit + twentyTip));
        twentyfivePercentTotalValue.setText(Integer.toString(partySplit + twentyFiveTip));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

    }
}