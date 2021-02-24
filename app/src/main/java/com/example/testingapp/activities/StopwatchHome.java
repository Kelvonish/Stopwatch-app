package com.example.testingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.testingapp.R;
import com.example.testingapp.databinding.ActivityStopwatchHomeBinding;

public class StopwatchHome extends AppCompatActivity {
   ActivityStopwatchHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStopwatchHomeBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        Animation btnAnim = AnimationUtils.loadAnimation(this,R.anim.btn_anim);
        Animation textAnim = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        binding.mainImage.startAnimation(atg);
        binding.titleText.setAnimation(textAnim);
        binding.description.setAnimation(textAnim);
        binding.getStartedBtn.setAnimation(btnAnim);

        binding.getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClicked();
            }
        });
        setContentView(view);
    }
    private void btnClicked(){
        startActivity(new Intent(StopwatchHome.this,StopwatchPage.class));
    }
}