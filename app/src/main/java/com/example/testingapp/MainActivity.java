 package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.view.View;

import com.example.testingapp.databinding.ActivityMainBinding;
import com.example.testingapp.utils.InputValidator;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binder;
    String result;
    InputValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binder.getRoot();
        validator = new InputValidator();
        doCalculations();
        setContentView(view);
    }
    private void doCalculations(){




        binder.buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String firstNumber = binder.firstNumberText.getEditText().getText().toString().trim();
                String secondNumber = binder.secondNumberText.getEditText().getText().toString().trim();
                if (!validator.numberValidator(firstNumber,binder.firstNumberText)| !validator.numberValidator(secondNumber,binder.secondNumberText)){
                    return;
                }else {
                    Double answer = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                    result = Double.toString(answer);
                    if (result == null) {
                        binder.firstNumberText.setError("Answer is empty");
                    } else {
                        binder.textResults.setText(result);
                    }
                }
            }
        });

        binder.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = binder.firstNumberText.getEditText().getText().toString().trim();
                String secondNumber = binder.secondNumberText.getEditText().getText().toString().trim();
                if (!validator.numberValidator(firstNumber,binder.firstNumberText)| !validator.numberValidator(secondNumber,binder.secondNumberText)){
                    return;
                }else {
                    Double answer = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                    result = Double.toString(answer);
                    if (result == null) {
                        binder.firstNumberText.setError("Answer is empty");
                    } else {
                        binder.textResults.setText(result);
                    }
                }
            }
        });
        binder.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = binder.firstNumberText.getEditText().getText().toString().trim();
                String secondNumber = binder.secondNumberText.getEditText().getText().toString().trim();
                if (!validator.numberValidator(firstNumber,binder.firstNumberText)| !validator.numberValidator(secondNumber,binder.secondNumberText)){
                    return;
                }else {
                    Double answer = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                    result = Double.toString(answer);
                    if (result == null) {
                        binder.firstNumberText.setError("Answer is empty");
                    } else {
                        binder.textResults.setText(result);
                    }
                }
            }
        });
        binder.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = binder.firstNumberText.getEditText().getText().toString().trim();
                String secondNumber = binder.secondNumberText.getEditText().getText().toString().trim();
                if (!validator.numberValidator(firstNumber,binder.firstNumberText)| !validator.numberValidator(secondNumber,binder.secondNumberText)){
                    return;
                }else {
                    Double answer = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                    result = Double.toString(answer);
                    if (result == null) {
                        binder.firstNumberText.setError("Answer is empty");
                    } else {
                        binder.textResults.setText(result);
                    }
                }
            }
        });
    }
}