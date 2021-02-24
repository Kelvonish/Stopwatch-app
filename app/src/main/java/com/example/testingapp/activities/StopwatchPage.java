package com.example.testingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.testingapp.R;
import com.example.testingapp.databinding.ActivityStopwatchPageBinding;

public class StopwatchPage extends AppCompatActivity {
    ActivityStopwatchPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStopwatchPageBinding.inflate(getLayoutInflater());
        View view  = binding.getRoot();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Animation imageAnim = AnimationUtils.loadAnimation(this, R.anim.atg);
        Animation btnAnim = AnimationUtils.loadAnimation(this,R.anim.btn_anim);
        Animation pointerAnim = AnimationUtils.loadAnimation(this,R.anim.pointer_anim);

        binding.clock.startAnimation(imageAnim);
        binding.pointer.startAnimation(imageAnim);
        binding.StartBtn.startAnimation(btnAnim);
        binding.StopBtn.setAnimation(btnAnim);
        binding.StopBtn.setAlpha(0);
        binding.StartBtn.setAlpha(1);
        binding.StopBtn.setEnabled(false);
        binding.StartBtn.setEnabled(true);

        binding.StartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.pointer.startAnimation(pointerAnim);
                binding.timer.setBase(SystemClock.elapsedRealtime());
                binding.timer.start();
                binding.StopBtn.setAlpha(1);
                binding.StartBtn.setAlpha(0);
                binding.StopBtn.setEnabled(true);
                binding.StartBtn.setEnabled(false);
            }
        });
        binding.StopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.timer.stop();
                binding.pointer.clearAnimation();
                binding.StopBtn.setAlpha(0);
                binding.StopBtn.setEnabled(false);
                binding.StartBtn.setEnabled(true);
                binding.StartBtn.setAlpha(1);

            }
        });
        setContentView(view);
    }
}