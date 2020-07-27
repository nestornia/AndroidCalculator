package com.example.caluladora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // To get view from layout

    // 1. Declare and initialize view you want
    // 1a. Declare -> [TYPE] [NAME]; example: MaterialTextView tvResults;
    // 1b. Initialize -> [TYPE] [NAME] = [Create Instance] -> findViewById(SET_ID_AT_LAYOUT)
    // example: MaterialTextView tvResults = findViewById(R.id.tv_results)

    //Declaring my view/Variable
    protected Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00, btndec;
    protected Button btnadd, btnsub, btnperc, btndiv, btnmul, btncl, btnequal;
    protected TextView tvUserInput, tvResult;
    //Declaring and initializing my view/variable [DO NOT INITIALIZE IN CLASS SCOPE]
    //public Button btn8 = findViewById(R.id.btn_8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);

        btn0 = findViewById(R.id.btn_zero);
        btn0.setOnClickListener(this);

        btn00 = findViewById(R.id.btn_double_zero);
        btn00.setOnClickListener(this);

        btndec = findViewById(R.id.btn_dec);
        btndec.setOnClickListener(this);

        btnadd = findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);

        btnsub = findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);

        btnperc = findViewById(R.id.btn_perc);
        btnperc.setOnClickListener(this);

        btndiv = findViewById(R.id.btn_div);
        btndiv.setOnClickListener(this);

        btnmul = findViewById(R.id.btn_mult);
        btnmul.setOnClickListener(this);

        btncl = findViewById(R.id.btn_clear);
        btncl.setOnClickListener(this);

        btnequal = findViewById(R.id.btn_equals);
        btnequal.setOnClickListener(this);

        tvUserInput = findViewById(R.id.tv_input_user);
        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View view) {
        btndec.setEnabled(true);
        btnadd.setEnabled(true);
        btndiv.setEnabled(true);
        btnperc.setEnabled(true);
        btnsub.setEnabled(true);
        btnmul.setEnabled(true);
        switch (view.getId()){
            case R.id.btn_1: {
                tvUserInput.setText(String.format("%s1", tvUserInput.getText()));
            }break;
            case R.id.btn_2: {
                tvUserInput.setText(String.format("%s2", tvUserInput.getText()));
            }break;
            case R.id.btn_3: {
                tvUserInput.setText(String.format("%s3", tvUserInput.getText()));
            }break;
            case R.id.btn_4:{
                tvUserInput.setText(String.format("%s4", tvUserInput.getText()));
            } break;
            case R.id.btn_5: {
                tvUserInput.setText(String.format("%s5", tvUserInput.getText()));
            }break;
            case R.id.btn_6: {
                tvUserInput.setText(String.format("%s6", tvUserInput.getText()));
            }break;
            case R.id.btn_7:{
                tvUserInput.setText(String.format("%s7", tvUserInput.getText()));
            } break;
            case R.id.btn_8: {
                tvUserInput.setText(String.format("%s8", tvUserInput.getText()));
            }break;
            case R.id.btn_9: {
                tvUserInput.setText(String.format("%s9", tvUserInput.getText()));
            }break;
            case R.id.btn_zero: {
                tvUserInput.setText(String.format("%s0", tvUserInput.getText()));
            }break;
            case R.id.btn_double_zero: {
                tvUserInput.setText(String.format("%s00", tvUserInput.getText()));
            }break;
            case R.id.btn_dec: {
                if (tvUserInput == null){
                    tvUserInput.setText("");
                }
                tvUserInput.setText(String.format("%s.", tvUserInput.getText()));
                btndec.setEnabled(false);
                btnmul.setEnabled(false);
                btnadd.setEnabled(false);
                btnsub.setEnabled(false);
                btndiv.setEnabled(false);
                btnperc.setEnabled(false);
            }break;
            case R.id.btn_add: {
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    tvUserInput.setText(String.format("%s+", tvUserInput.getText()));
                    btnadd.setEnabled(false);
                    btndec.setEnabled(false);
                    btnmul.setEnabled(false);
                    btnsub.setEnabled(false);
                    btndiv.setEnabled(false);
                    btnperc.setEnabled(false);
                }
            }break;
            case R.id.btn_sub: {
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    tvUserInput.setText(String.format("%s-", tvUserInput.getText()));
                    btnsub.setEnabled(false);
                    btndec.setEnabled(false);
                    btnmul.setEnabled(false);
                    btnadd.setEnabled(false);
                    btndiv.setEnabled(false);
                    btnperc.setEnabled(false);
                }
            }break;
            case R.id.btn_mult: {
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    tvUserInput.setText(String.format("%s*", tvUserInput.getText()));
                    btnmul.setEnabled(false);
                    btndec.setEnabled(false);
                    btndiv.setEnabled(false);
                    btnperc.setEnabled(false);
                }
            }break;
            case R.id.btn_perc: {
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    tvUserInput.setText(String.format("%s%%", tvUserInput.getText()));
                    btnperc.setEnabled(false);
                    btndec.setEnabled(false);
                    btnmul.setEnabled(false);
                    btnadd.setEnabled(false);
                    btnsub.setEnabled(false);
                    btndiv.setEnabled(false);
                }
            }break;
            case R.id.btn_div: {
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    tvUserInput.setText(String.format("%s/", tvUserInput.getText()));
                    btndiv.setEnabled(false);
                    btndec.setEnabled(false);
                    btnmul.setEnabled(false);
                    btnperc.setEnabled(false);
                }
            }break;
            case R.id.btn_clear: {
                tvUserInput.setText("");
                tvResult.setText("");
            }break;
            case R.id.btn_equals: {
            }
                if (tvUserInput.getText().toString().equals("")){
                    tvUserInput.setText("");
                } else {
                    Expression expression = new Expression(tvUserInput.getText().toString());
                    expression.setPrecision(2);
                    BigDecimal result = expression.eval();
                    tvResult.setText(result.toPlainString());
                }

            break;
        }
    }


}