package com.example.caluladora.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String>_displayValue = new MutableLiveData<>();

    public LiveData<String> getDisplayValue(){
        return _displayValue;
    }

    public void  evaluateOperation(String displayValue) {
        Expression expression = new Expression(displayValue);
        expression.setPrecision(2);
        BigDecimal res = expression.eval();
        _displayValue.setValue(res.toPlainString());
    }


}
