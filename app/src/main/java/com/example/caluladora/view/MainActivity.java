package com.example.caluladora.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.caluladora.R;
import com.example.caluladora.databinding.ActivityMainBinding;
import com.example.caluladora.viewmodel.HomeViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private HomeViewModel homeViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        View view = binding.getRoot();
        setContentView(view);
        homeViewModel = new ViewModelProvider.NewInstanceFactory().create(HomeViewModel.class);

        setCalculatorButtonListener(binding.calcButtons.getRoot());
        homeViewModel.getDisplayValue().observe(this, displayValue -> binding.calcResult.tvResult.setText(displayValue));
    }

    @Override
    public void onClick(View view) {
        toggleEnabledState(true);
        switch (view.getId()){
            case R.id.btn_dec:
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mult:
            case R.id.btn_div:
            case R.id.btn_perc : {
                updateExpression(view);
                toggleEnabledState(false);
            }
            case R.id.btn_clear: {
                binding.calcResult.tvInputUser.setText("");
                binding.calcResult.tvResult.setText("");
            }break;
            case R.id.btn_equals: {
                homeViewModel.evaluateOperation(binding.calcResult.tvInputUser.getText().toString());
            }
            default:
                updateExpression(view);
        }
    }

    private void updateExpression(View view){
        if (view instanceof Button) {
         binding.calcResult.tvResult.append(((Button) view).getText().toString());
        }
    }

    private void toggleEnabledState(Boolean enabled) {
        binding.calcButtons.btnAdd.setEnabled(enabled);
        binding.calcButtons.btnSub.setEnabled(enabled);
        binding.calcButtons.btnMult.setEnabled(enabled);
        binding.calcButtons.btnPerc.setEnabled(enabled);
        binding.calcButtons.btnEquals.setEnabled(enabled);
    }

    private void setCalculatorButtonListener(GridLayout gridLayout){
        for (int i = 0 ; i < gridLayout.getChildCount(); i++) {
            final View child = gridLayout.getChildAt(i);
            if(child instanceof Button){
                child.setOnClickListener(this);
            }
        }
    }

}