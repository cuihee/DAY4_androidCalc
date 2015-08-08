package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.TextView;
import java.lang.Math;


public class MyActivity extends Activity {
    private TextView resultText;
    private String displayed = "";
    private float[] num = new float[10];                //displayed分析出num
    private String op = "";                //displayed分析出op


    void jiSuan(int num_i_in){
        int op_i = -1, length_num = num_i_in, length_op = op.length(), temp_i;
        boolean flag_multiplyOrDevide, flag_plusOrMinus;

        while (length_op > 0){
            flag_multiplyOrDevide = false;
            flag_plusOrMinus = false;
            //找乘除
            if (op.contains("/") || op.contains("*")){
                flag_multiplyOrDevide = true;
                op_i = Math.min(op.indexOf("*"), op.indexOf("/"));
                if (op_i == -1) op_i = Math.max(op.indexOf("*"), op.indexOf("/"));
            }
            if (flag_multiplyOrDevide){
                //计算并调整位置
                //num[op_i] op[op_i] num[op_i+1]
                switch (op.charAt(op_i)){
                    case '*':
                        num[op_i] = num[op_i] * num[op_i + 1];
                        break;
                    case '/':
                        if (num[op_i]==0){
                            displayed = "除数不能为0";
                            return;
                        }
                        num[op_i] = num[op_i] / num[op_i + 1];
                        break;
                    }
                for (temp_i=op_i+1; temp_i<length_num;temp_i++){
                    num[temp_i] = num[temp_i+1];
                }
                op = op.substring(0,op_i) + op.substring(op_i+1,length_op);
                length_num -= 1;
                length_op -= 1;
                continue;
            }
//=====================================================================================
            //找加减
            if (op.contains("+") || op.contains("-")){
                flag_plusOrMinus = true;
                op_i = Math.min(op.indexOf("-"), op.indexOf("+"));
                if (op_i == -1) op_i = Math.max(op.indexOf("-"), op.indexOf("+"));
            }
            if (flag_plusOrMinus){
                //计算并调整位置
                //num[op_i] op[op_i] num[op_i+1]
                switch (op.charAt(op_i)){
                    case '+':
                        num[op_i] = num[op_i] + num[op_i + 1];
                        break;
                    case '-':
                        num[op_i] = num[op_i] - num[op_i + 1];
                        break;
                }
                for (temp_i=op_i+1; temp_i<length_num; temp_i++) num[temp_i] = num[temp_i + 1];
                op = op.substring(0,op_i) + op.substring(op_i+1,length_op);
                length_num -= 1;
                length_op -= 1;
            }
        }//while (length_num > 1)
        displayed = Float.toString(num[0]);
    }

     void fenXi(String displayed_in){
        int num_i = 0, displayed_in_i, displayed_in_i_old = 0;
        //获取非数字非小数点的符号位置
        for (displayed_in_i = 0; displayed_in_i<displayed_in.length(); displayed_in_i++){
            if ((displayed_in.charAt(displayed_in_i) == '.')||
                ((displayed_in.charAt(displayed_in_i) >= '0')&&
                 (displayed_in.charAt(displayed_in_i) <= '9')))
                continue;//当前位置是数字或者点就过
            if ((displayed_in.charAt(displayed_in_i) == '+')||
                (displayed_in.charAt(displayed_in_i) == '-')||
                (displayed_in.charAt(displayed_in_i) == '*')||
                (displayed_in.charAt(displayed_in_i) == '/')){
                //中间那个取子字符串，开始位置和重点位置现在是有头无尾
                num[num_i++] = Float.parseFloat(displayed_in.substring(displayed_in_i_old, displayed_in_i));
                op += displayed_in.charAt(displayed_in_i);
                displayed_in_i_old = displayed_in_i+1;
            }
            if (displayed_in.charAt(displayed_in_i) == '='){
                num[num_i++] = Float.parseFloat(displayed_in.substring(displayed_in_i_old, displayed_in_i));
                //调用计算过程
                jiSuan(num_i);
            }
        }
        //取出来float放到num数组中
        //取出来符号放在op数组中
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnone = (Button) super.findViewById(R.id.one);
        btnone.setOnClickListener(new OneOnClickListener());
        Button btntwo = (Button) super.findViewById(R.id.two);
        btntwo.setOnClickListener(new TwoOnClickListener());
        Button btnthree = (Button) super.findViewById(R.id.three);
        btnthree.setOnClickListener(new ThreeOnClickListener());

        Button btnfour = (Button) super.findViewById(R.id.four);
        btnfour.setOnClickListener(new FourOnClickListener());
        Button btnfive = (Button) super.findViewById(R.id.five);
        btnfive.setOnClickListener(new FiveOnClickListener());
        Button btnsix = (Button) super.findViewById(R.id.six);
        btnsix.setOnClickListener(new SixOnClickListener());

        Button btnseven = (Button) super.findViewById(R.id.seven);
        btnseven.setOnClickListener(new SevenOnClickListener());
        Button btneight = (Button) super.findViewById(R.id.eight);
        btneight.setOnClickListener(new EightOnClickListener());
        Button btnnine = (Button) super.findViewById(R.id.nine);
        btnnine.setOnClickListener(new NineOnClickListener());
        Button btnzero = (Button) super.findViewById(R.id.zero);
        btnzero.setOnClickListener(new ZeroOnClickListener());

        Button btnplus = (Button) super.findViewById(R.id.plus);
        btnplus.setOnClickListener(new PlusOnClickListener());
        Button btnminus = (Button) super.findViewById(R.id.minus);
        btnminus.setOnClickListener(new MinusOnClickListener());
        Button btnmultiply = (Button) super.findViewById(R.id.multiply);
        btnmultiply.setOnClickListener(new MultiplyOnClickListener());
        Button btndevide = (Button) super.findViewById(R.id.devide);
        btndevide.setOnClickListener(new DevideOnClickListener());

        Button btnpoint = (Button) super.findViewById(R.id.point);
        btnpoint.setOnClickListener(new PointOnClickListener());
        Button btnequal = (Button) super.findViewById(R.id.equal);
        btnequal.setOnClickListener(new EqualOnClickListener());

        Button btnbackspace = (Button) super.findViewById(R.id.backspace);
        btnbackspace.setOnClickListener(new BackspaceOnClickListener());
        Button btnclear = (Button) super.findViewById(R.id.clear);
        btnclear.setOnClickListener(new ClearOnClickListener());

        resultText = (TextView)super.findViewById(R.id.resultText);

    }

    private class OneOnClickListener implements OnClickListener{
        public void onClick(View view) {
            String temps = "1";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class TwoOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "2";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class ThreeOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "3";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class FourOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "4";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class FiveOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "5";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class SixOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "6";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class SevenOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "7";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class EightOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "8";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class NineOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "9";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class ZeroOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "0";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class PlusOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "+";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class MinusOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "-";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class MultiplyOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "*";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class DevideOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "/";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class PointOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = ".";
            displayed += temps;
            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
    private class BackspaceOnClickListener implements OnClickListener{
        public void onClick(View v) {
            displayed = displayed.substring(0, displayed.length()-1);
            resultText.setText(displayed);
        }
    }
    private class ClearOnClickListener implements OnClickListener{
        public void onClick(View v) {
            displayed = "";
            resultText.setText(displayed);
        }
    }
    private class EqualOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "=";
            displayed += temps;
            fenXi(displayed);
            resultText.setText(displayed);
            displayed = "";
        }
    }
}
