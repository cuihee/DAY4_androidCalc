package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.TextView;


public class MyActivity extends Activity {
    private Button btnone = null;       //1
    private Button btntwo = null;       //2
    private Button btnthree = null;     //3
    private Button btnfour = null;      //4
    private Button btnfive = null;      //5
    private Button btnsix = null;       //6
    private Button btnseven = null;     //7
    private Button btneight = null;     //8
    private Button btnnine = null;      //9
    private Button btnzero = null;      //0
    private Button btnplus = null;      //+
    private Button btnminus = null;     //-
    private Button btnmultiply = null;  //*
    private Button btndevide = null;    ///
    private Button btnpoint = null;     //.
    private Button btnequal = null;     //=
    private TextView resultText;
    private String displayed = "";
    private float[] num;                //从resultText分析出num
    private String[] op;                //从resultText分析出op
    private int i, j, k;


    void jiSuan(void){
        int i, j, k, length_num = num.length, length_op = op.length;
        boolean flag_multiplyOrDevide = false, flag_plusOrMinus = false;
        while (length_num > 1){//里面两个while，外面这个没必要了
            //找乘除
            while (flag_multiplyOrDevide){
                //计算并调整位置
                length_num -= 1;
                length_op -= 1;
                //找乘除
            }
            //找加减
            while (flag_plusOrMinus){
                //计算并调整位置
                length_num -= 1;
                length_op -= 1;
                //找加减
            }
        }
        displayed = Float.toString(num[0]);

    }

     void fenXi(String displayed_in){
        int op_i = 0, num_i = 0, displayed_in_i = 0, displayed_in_i_old = 0;
        //获取非数字非小数点的符号位置
        for (displayed_in_i = 0, displayed_in_i < displayed_in.length(), displayed_in_i++){
            if ( (displayed_in.charAt(displayed_in_i) == ".")||
                    ((displayed_in.charAt(displayed_in_i) >= "0")&&
                            (displayed_in.charAt(displayed_in_i) <= "9")) )
                continue;//当前位置是数字或者点就过
            if (displayed_in.charAt(displayed_in_i) == "+")||
                    (displayed_in.charAt(displayed_in_i) == "-")||
                    (displayed_in.charAt(displayed_in_i) == "*")||
                    (displayed_in.charAt(displayed_in_i) == "/")){
                //中间那个取子字符串，开始位置和重点位置现在是有头无尾
                num[num_i++] = Float.parseFloat(displayed_in.substring(displayed_in_i_old+1, displayed_in_i));
                op[op_i++] = displayed_in.charAt(displayed_in_i);
                displayed_in_i_old = displayed_in_i;
            }
            if (displayed_in.charAt(displayed_in_i) == "="){
                //调用计算过程吧
                jiSuan();

            }
        }
        //如果是=号就输出resultText, return 0?
        //取出来float放到num数组中
        //取出来符号放在op数组中
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnone = (Button)super.findViewById(R.id.one);
        btnone.setOnClickListener(new OneOnClickListener());
        btntwo = (Button)super.findViewById(R.id.two);
        btntwo.setOnClickListener(new TwoOnClickListener());
        btnthree = (Button)super.findViewById(R.id.three);
        btnthree.setOnClickListener(new ThreeOnClickListener());

        btnfour = (Button)super.findViewById(R.id.four);
        btnfour.setOnClickListener(new FourOnClickListener());
        btnfive = (Button)super.findViewById(R.id.five);
        btnfive.setOnClickListener(new FiveOnClickListener());
        btnsix = (Button)super.findViewById(R.id.six);
        btnsix.setOnClickListener(new SixOnClickListener());

        btnseven = (Button)super.findViewById(R.id.seven);
        btnseven.setOnClickListener(new SevenOnClickListener());
        btneight = (Button)super.findViewById(R.id.eight);
        btneight.setOnClickListener(new EightOnClickListener());
        btnnine = (Button)super.findViewById(R.id.nine);
        btnnine.setOnClickListener(new NineOnClickListener());
        btnzero = (Button)super.findViewById(R.id.zero);
        btnzero.setOnClickListener(new ZeroOnClickListener());

        btnplus = (Button)super.findViewById(R.id.plus);
        btnplus.setOnClickListener(new PlusOnClickListener());
        btnminus = (Button)super.findViewById(R.id.minus);
        btnminus.setOnClickListener(new MinusOnClickListener());
        btnmultiply = (Button)super.findViewById(R.id.multiply);
        btnmultiply.setOnClickListener(new MultiplyOnClickListener());
        btndevide = (Button)super.findViewById(R.id.devide);
        btndevide.setOnClickListener(new DevideOnClickListener());

        btnpoint = (Button)super.findViewById(R.id.point);
        btnpoint.setOnClickListener(new PointOnClickListener());
        btnequal = (Button)super.findViewById(R.id.equal);
        btnequal.setOnClickListener(new EqualOnClickListener());

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
    private class EqualOnClickListener implements OnClickListener{
        public void onClick(View v) {
            String temps = "=";
            displayed += temps;

            fenXi(displayed);

            resultText.setText(displayed);
            Toast.makeText(getApplicationContext(), temps, Toast.LENGTH_SHORT).show();
        }
    }
}
