package com.example.wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText annualSalary;
    EditText weeksSalary;
    EditText hoursSalary;
    TextView hourPay;
    TextView weeklyPay;
    TextView monthlyPay;
    Button calculate;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annualSalary = findViewById(R.id.blkAs);
        weeksSalary = findViewById(R.id.blkWw);
        hoursSalary = findViewById(R.id.blkWh);

        hourPay = findViewById(R.id.txtHp);
        weeklyPay = findViewById(R.id.txtWp);
        monthlyPay = findViewById(R.id.txtMp);

        calculate = findViewById(R.id.btnCal);
        clear = findViewById(R.id.btnClear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double myAnnualSalary = Double.parseDouble(annualSalary.getText().toString());
                double myWeeksSalary = Double.parseDouble(weeksSalary.getText().toString());
                double myHourSalary = Double.parseDouble(hoursSalary.getText().toString());

                double Hp = myAnnualSalary / (myWeeksSalary * myHourSalary);
                double Wp = myAnnualSalary / myWeeksSalary;
                double Mp = myAnnualSalary / 12;


                String roundedHp = String.format("%.2f", Hp);
                String roundedWp = String.format("%.2f", Wp);
                String roundedMp = String.format("%.2f", Mp);

                hourPay.setText(String.valueOf(roundedHp));
                weeklyPay.setText(String.valueOf(roundedWp));
                monthlyPay.setText(String.valueOf(roundedMp));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all fields
                annualSalary.setText("");
                weeksSalary.setText("");
                hoursSalary.setText("");
                hourPay.setText("");
                weeklyPay.setText("");
                monthlyPay.setText("");
            }
        });
    }

}