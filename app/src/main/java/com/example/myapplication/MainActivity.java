package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClick1(View view) {
        EditText editTextChieuCao = findViewById(R.id.editTextChieuCao);
        EditText editTextCanNang = findViewById(R.id.editTextCanNang);
        EditText editTextBMI = findViewById(R.id.editTextBMI);
        EditText editTextChuanDoan = findViewById(R.id.editTextChuanDoan);

        try {
            // Retrieve the text from the EditText widgets and convert to Double
            double chieuCao = Double.parseDouble(editTextChieuCao.getText().toString());
            double canNang = Double.parseDouble(editTextCanNang.getText().toString());

            // Calculate BMI
            double bmi = canNang / Math.pow(chieuCao, 2);

            // Display the BMI in the editTextBMI
            editTextBMI.setText(String.valueOf(bmi));

            // Determine the diagnosis based on BMI
            String chuanDoan = getChuanDoan(bmi);
            editTextChuanDoan.setText(chuanDoan);
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid number
            editTextBMI.setText("");
            editTextChuanDoan.setText("Invalid input");
        }
    }

    private String getChuanDoan(double bmi) {
        if (bmi < 18) {
            return "Người Gầy";
        } else if (bmi >= 18 && bmi <= 24.9) {
            return "Người bình thường";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Người béo phì độ I";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Người béo phì độ II";
        } else {
            return "Người béo phì độ III";
        }
    }

}