package com.example.rubys.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String expression="";
    private String number ="0";
    private TextView expressionTextView,answerTextView;
    private double afterCalculate =0;
    private String sign = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionTextView = findViewById(R.id.expressionTextView);
        answerTextView = findViewById(R.id.answerTextView);
        findViewById(R.id.Button0).setOnClickListener(this);
        findViewById(R.id.Button1).setOnClickListener(this);
        findViewById(R.id.Button2).setOnClickListener(this);
        findViewById(R.id.Button3).setOnClickListener(this);
        findViewById(R.id.Button4).setOnClickListener(this);
        findViewById(R.id.Button5).setOnClickListener(this);
        findViewById(R.id.Button6).setOnClickListener(this);
        findViewById(R.id.Button7).setOnClickListener(this);
        findViewById(R.id.Button8).setOnClickListener(this);
        findViewById(R.id.Button9).setOnClickListener(this);
        findViewById(R.id.dotButton).setOnClickListener(this);
        findViewById(R.id.equalButton).setOnClickListener(this);
        findViewById(R.id.plusButton).setOnClickListener(this);
        findViewById(R.id.minusButton).setOnClickListener(this);
        findViewById(R.id.timeButton).setOnClickListener(this);
        findViewById(R.id.divisionButton).setOnClickListener(this);
        findViewById(R.id.percentButton).setOnClickListener(this);
        findViewById(R.id.changeSignButton).setOnClickListener(this);
        findViewById(R.id.resetButton).setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.Button0:
                    expression +="0";
                    number +="0";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button1:
                    expression +="1";
                    number +="1";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button2:
                    expression +="2";
                    number +="2";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button3:
                    expression +="3";
                    number +="3";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button4:
                    expression +="4";
                    number +="4";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button5:
                    expression +="5";
                    number +="5";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button6:
                    expression +="6";
                    number +="6";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button7:
                    expression +="7";
                    number +="7";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button8:
                    expression +="8";
                    number +="8";
                    expressionTextView.setText(expression);
                    break;
                case R.id.Button9:
                    expression +="9";
                    number +="9";
                    expressionTextView.setText(expression);
                    break;
                case R.id.dotButton:
                    //FIXME only one dot each number (use do while?)
                    expression +=".";
                    number +=".";
                    expressionTextView.setText(expression);
                    break;
                case R.id.equalButton:
                    calculate(sign);
                    number = String.valueOf(afterCalculate);
                    sign="";
                    expression =expression + " = " + number;
                    expressionTextView.setText(expression);
                    answerTextView.setText(number);
                    break;
                case R.id.plusButton:
                    calculate(sign);
                    number ="0";
                    sign="+";
                    expression +=" + ";
                    expressionTextView.setText(expression);
                    break;
                case R.id.minusButton:
                    calculate(sign);
                    number ="0";
                    sign="-";
                    expression +=" - ";
                    expressionTextView.setText(expression);
                    break;
                case R.id.timeButton:
                    calculate(sign);
                    number ="0";
                    sign="*";
                    expression +=" x ";
                    expressionTextView.setText(expression);
                    break;
                case R.id.divisionButton:
                    calculate(sign);
                    number ="0";
                    sign = "/";
                    expression +=" ÷ ";
                    expressionTextView.setText(expression);
                    break;
                case R.id.percentButton:
                    calculate(sign,number);
                    number="0";
                    sign="";
                    expression +="% ";
                    expressionTextView.setText(expression);
                    break;
                case R.id.changeSignButton:

                    break;
                case R.id.resetButton:
                    number = "0";
                    afterCalculate =0;
                    sign ="";
                    expression = "";
                    expressionTextView.setText("0");
                    answerTextView.setText("0");
                    break;
            }

        }
    public List<String> getNumbers() {
        String[] numbers = expression.split(" ");
        return Arrays.asList(numbers);
    }
    private void calculate(String sign){
        switch (sign){
            case "+":
                afterCalculate = afterCalculate +Double.valueOf(number);
                break;
            case "-":
                afterCalculate = afterCalculate -Double.valueOf(number);
                break;
            case "*":
                afterCalculate = afterCalculate *Double.valueOf(number);
                break;
            case "/":
                afterCalculate = afterCalculate /Double.valueOf(number);
                break;
            case "":
                afterCalculate = afterCalculate +Double.valueOf(number);
                break;
            //case "%":
            //    if (afterCalculate ==0){
            //        afterCalculate = Double.valueOf(number)*0.01;
            //    }else{
            //        afterCalculate = Double.valueOf(number);
            //    }
            //
            //    break;
        }
    }
    private void calculate(String sign,String number){
        switch (sign) {
            case "+":
                afterCalculate = afterCalculate + (afterCalculate*(Double.valueOf(number))*0.01);
                break;
            case "-":
                afterCalculate = afterCalculate - (afterCalculate*(Double.valueOf(number))*0.01);
                break;
            case "*":
                afterCalculate = afterCalculate * ((Double.valueOf(number))*0.01);
                break;
            case "/":
                afterCalculate = afterCalculate / ((Double.valueOf(number))*0.01);
                break;
            case "":
                afterCalculate = (Double.valueOf(number))*0.01;
                break;
        }
    }
}
