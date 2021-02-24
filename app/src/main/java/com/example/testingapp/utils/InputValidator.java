package com.example.testingapp.utils;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidator {
    public boolean  numberValidator(String number, TextInputLayout textLayout){
        if(number.isEmpty()){
            textLayout.setError("Number is empty");
            return false;
        }
        textLayout.setError("");
        return true;
    }
}
