package com.example.soronto.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String exp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printExp(String s){
        TextView textView1 = (TextView) findViewById(R.id.expression) ;
        textView1.setText(s) ;
    }
    public void btn0(View v){
        this.exp+="0";
        this.printExp(this.exp);
    }
    public void btn1(View v){
        this.exp+="1";
        this.printExp(this.exp);
    }
    public void btn2(View v){
        this.exp+="2";
        this.printExp(this.exp);
    }
    public void btn3(View v){
        this.exp+="3";
        this.printExp(this.exp);
    }
    public void btn4(View v){
        this.exp+="4";
        this.printExp(this.exp);
    }
    public void btn5(View v){
        this.exp+="5";
        this.printExp(this.exp);
    }
    public void btn6(View v){
        this.exp+="6";
        this.printExp(this.exp);
    }
    public void btn7(View v){
        this.exp+="7";
        this.printExp(this.exp);
    }
    public void btn8(View v){
        this.exp+="8";
        this.printExp(this.exp);
    }
    public void btn9(View v){
        this.exp+="9";
        this.printExp(this.exp);
    }
    public void btn_point(View v){
        this.exp+=".";
        this.printExp(this.exp);
    }
    public void btn_plus(View v){
        this.exp+="+";
        this.printExp(this.exp);
    }
    public void btn_minus(View v){
        this.exp+="-";
        this.printExp(this.exp);
    }
    public void btn_multiple(View v){
        this.exp+="*";
        this.printExp(this.exp);
    }
    public void btn_divide(View v){
        this.exp+="/";
        this.printExp(this.exp);
    }
    public void btn_result(View v){
        SimpleCalculator calc=new SimpleCalculator(exp);
        String result_d=Double.toString(calc.eval());
        TextView textView2 = (TextView) findViewById(R.id.result_d) ;
        textView2.setText(result_d) ;
        this.exp=result_d;
        this.printExp(this.exp);
    }
    public void btn_init(View v){
        this.exp="";
        this.printExp(this.exp);
    }

}
