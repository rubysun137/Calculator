package com.example.rubys.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String expression="";
    private String number ="";
    private TextView expressionTextView,answerTextView;
    private double afterCalculate =0;
    private double afterCalculateTAndD =0;
    private String sign = "";
    private String signTAndD = "";

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
                    if(expression.equals(""))afterCalculate =0;
                    number +="0";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button1:
                    if(expression.equals(""))afterCalculate =0;
                    number +="1";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button2:
                    if(expression.equals(""))afterCalculate =0;
                    number +="2";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button3:
                    if(expression.equals(""))afterCalculate =0;
                    number +="3";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button4:
                    if(expression.equals(""))afterCalculate =0;
                    number +="4";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button5:
                    if(expression.equals(""))afterCalculate =0;
                    number +="5";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button6:
                    if(expression.equals(""))afterCalculate =0;
                    number +="6";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button7:
                    if(expression.equals(""))afterCalculate =0;
                    number +="7";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button8:
                    if(expression.equals(""))afterCalculate =0;
                    number +="8";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.Button9:
                    if(expression.equals(""))afterCalculate =0;
                    number +="9";
                    expressionTextView.setText(expression+number);
                    break;
                case R.id.dotButton:
                    if(expression.equals(""))afterCalculate =0;
                    if(tryParse() == null){
                        break;
                    }
                    else {
                        number +=".";
                        expressionTextView.setText(expression+number);
                        break;
                    }

                case R.id.equalButton:
                    calculate(number);
                    calcutlateTAndD(signTAndD);
                    sign="";
                    expression =expression+number+" = ";
                    expressionTextView.setText(expression);
                    DecimalFormat df = new DecimalFormat("#.########");
                    String answer =df.format(afterCalculate);
                    answerTextView.setText(answer);
                    expression ="";
                    number ="";
                    break;
                case R.id.plusButton:
                    calculate(number);
                    calcutlateTAndD(signTAndD);
                    sign=" + ";
                    expression =expression+number+sign;
                    expressionTextView.setText(expression);
                    number ="";
                    break;
                case R.id.minusButton:
                    calculate(number);
                    calcutlateTAndD(signTAndD);
                    sign=" - ";
                    expression =expression+number+sign;
                    expressionTextView.setText(expression);
                    number ="";

                    break;
                case R.id.timeButton:
                    if(sign.equals(" x ") || sign.equals(" ÷ ")){
                        calculate(number);
                    }else {
                        signTAndD = sign;
                        afterCalculateTAndD = Double.valueOf(number);
                    }
                    sign = " x ";
                    expression = expression + number + sign;
                    expressionTextView.setText(expression);
                    number = "";
                    break;
                case R.id.divisionButton:
                    if(sign.equals(" x ") || sign.equals(" ÷ ")){
                        calculate(number);
                    }else {
                        signTAndD = sign;
                        afterCalculateTAndD = Double.valueOf(number);
                    }
                    sign=" ÷ ";
                    expression = expression + number + sign;
                    expressionTextView.setText(expression);
                    number = "";
                        break;

                case R.id.percentButton:
                    calculate(sign,number);
                    expression =expression+number+"%";
                    expressionTextView.setText(expression);
                    number="";
                    sign="";
                    break;
                case R.id.changeSignButton:
                    if(number.equals("0") || number.equals("")) {
                        break;
                    }
                    else if(Double.valueOf(number)>0){
                        number = "-"+number;
                        expressionTextView.setText(expression+number);
                        break;
                    }
                    else if (Double.valueOf(number)<0)
                        number = number.replace("-","");
                        expressionTextView.setText(expression+number);
                    break;
                case R.id.resetButton:
                    number = "";
                    afterCalculate =0;
                    sign ="";
                    expression = "";
                    expressionTextView.setText("0");
                    answerTextView.setText("0");
                    break;
            }

        }

    private void calculate(String number){

        if(number.equals(""))number = "0";

        switch (sign){
            case " + ":
                afterCalculate = afterCalculate +Double.valueOf(number);
                break;
            case " - ":
                afterCalculate = afterCalculate -Double.valueOf(number);
                break;
            case " x ":
                afterCalculateTAndD = afterCalculateTAndD *Double.valueOf(number);
                break;
            case " ÷ ":
                afterCalculateTAndD = afterCalculateTAndD /Double.valueOf(number);
                break;
            case "":
                afterCalculate = afterCalculate +Double.valueOf(number);
                break;
        }
    }
    private void calculate(String sign,String number){
        if(number.equals(""))number = "0";
        switch (sign) {
            case " + ":
                afterCalculate = afterCalculate + (afterCalculate*(Double.valueOf(number))*0.01);
                break;
            case " - ":
                afterCalculate = afterCalculate - (afterCalculate*(Double.valueOf(number))*0.01);
                break;
            case " x ":
                afterCalculate = afterCalculate * ((Double.valueOf(number))*0.01);
                break;
            case " ÷ ":
                afterCalculate = afterCalculate / ((Double.valueOf(number))*0.01);
                break;
            case "":
                afterCalculate = (Double.valueOf(number))*0.01;
                break;
        }
    }

    private void calcutlateTAndD(String sign){
        switch (sign){
            case " + ":
                afterCalculate = afterCalculate + afterCalculateTAndD;
                break;
            case " - ":
                afterCalculate = afterCalculate - afterCalculateTAndD;
                break;
            case "":
                afterCalculate = afterCalculate + afterCalculateTAndD;
                break;
        }
        afterCalculateTAndD =0;
        signTAndD ="";
    }

    private Integer tryParse(){
        try{
            return Integer.valueOf(number);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
