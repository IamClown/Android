package com.example.zyj.testcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    * 数字
    * */
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    /*
    * 运算符
    * */
    private Button   btn_add;//"+"
    private Button   btn_minus; //"-"
    private Button   btn_multiply;//"*"
    private Button   btn_divide;//"÷"
    private Button   btn_equal;//"="
    private Button   btn_addminus;//"±"
    private Button   btn_genhao;//开平方
    private Button   btn_bai;//"%"
    private Button   btn_fen;//"1/x分数"
    //归零键
    private Button   btn_ac;
    //其他
    private Button   btn_point;
    private Button   btn_del;
    private Button   btn_mc;
    private Button   btn_mr;
    private Button   btn_ms;
    private Button   btn_madd;
    private Button   btn_mminus;
    private Button   btn_c;
    /*
    * 显示结果
    * */
    private TextView tv_result;
    /*
    * 已经输入的字符
    * */
    private String  existedText         = "";
    /*
    * 是否计算过
    * */
    private boolean isCounted           = false;
    /*
    * 以负号开头，但是不是－；
    * */
    private boolean startWithOperator   = false;
    /*
    * 以负号开头，且是运算符
    * */
    private boolean startWithSubtrac    = false;
    /*
    * 不以负号开头，且是运算符
    * */
    private boolean noStartWithOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    /*
    * 初始化控件
    * */
    private void initView() {
        //数字
        num0 = findViewById(R.id.btn_Zero);
        num1 = findViewById(R.id.btn_One);
        num2 = findViewById(R.id.btn_Tow);
        num3 = findViewById(R.id.btn_Three);
        num4 = findViewById(R.id.btn_Four);
        num5 = findViewById(R.id.btn_Five);
        num6 = findViewById(R.id.btn_Six);
        num7 = findViewById(R.id.btn_Seven);
        num8 = findViewById(R.id.btn_Eight);
        num9 = findViewById(R.id.btn_Nine);
        //运算符
        btn_add = findViewById(R.id.btn_Add);
        btn_minus = findViewById(R.id.btn_Minus);
        btn_multiply = findViewById(R.id.btn_Multiply);
        btn_divide = findViewById(R.id.btn_Divide);
        btn_equal = findViewById(R.id.btn_Equal);
        btn_bai = findViewById(R.id.btn_Bai);
        btn_fen = findViewById(R.id.btn_Fen);
        btn_genhao = findViewById(R.id.btn_Genhao);
        btn_addminus = findViewById(R.id.btn_Jj);
        //归零键
        btn_ac = findViewById(R.id.btn_Ac);
        //其他
        btn_mc = findViewById(R.id.btn_Mc);
        btn_mr = findViewById(R.id.btn_Mr);
        btn_ms = findViewById(R.id.btn_Ms);
        btn_madd = findViewById(R.id.btn_Madd);
        btn_mminus = findViewById(R.id.btn_Mminus);
        btn_del = findViewById(R.id.btn_Del);
        btn_point = findViewById(R.id.btn_Point);
        btn_c = findViewById(R.id.btn_C);
        //结果
        tv_result = findViewById(R.id.tv_Result);
    }

    /*
    * 初始化事件
    * */
    private void initEvent() {
        //数字
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        //运算符
        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_addminus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_fen.setOnClickListener(this);
        btn_bai.setOnClickListener(this);
        btn_genhao.setOnClickListener(this);
        //归零键
        btn_ac.setOnClickListener(this);
        //其他
        btn_point.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_mc.setOnClickListener(this);
        btn_mr.setOnClickListener(this);
        btn_ms.setOnClickListener(this);
        btn_madd.setOnClickListener(this);
        btn_mminus.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        //结果
        tv_result = findViewById(R.id.tv_Result);
        /*
        * 已经输入的字符
        * */
        existedText = tv_result.getText().toString();
    }

    /*
    * 点击事件
    * @param v 点击的控件
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        /*
        * 数字
        * */
            case R.id.btn_Zero:
                existedText = isOverRange(existedText, "0");
                break;
            case R.id.btn_One:
                existedText = isOverRange(existedText, "1");
                break;
            case R.id.btn_Three:
                existedText = isOverRange(existedText, "3");
                break;
            case R.id.btn_Four:
                existedText = isOverRange(existedText, "4");
                break;
            case R.id.btn_Five:
                existedText = isOverRange(existedText, "5");
                break;
            case R.id.btn_Six:
                existedText = isOverRange(existedText, "6");
                break;
            case R.id.btn_Seven:
                existedText = isOverRange(existedText, "7");
                break;
            case R.id.btn_Eight:
                existedText = isOverRange(existedText, "8");
                break;
            case R.id.btn_Nine:
                existedText = isOverRange(existedText, "9");
                break;
                /*
                * 运算符
                * */
            case R.id.btn_Add:
                /*
                * 判断已有的字符是否为科学计数
                * 是  置零
                * 否  进行下一步
                *
                * 判读表达式是否可以进行计算
                * 是  先计算再添加字符
                * 否   添加字符
                *
                * 判断计算后的结果是否为error
                * 是   置零
                * 否   添加运算符
                * */
                if (!existedText.contains("e")){

                }
        }
    }

    private String isOverRange(String existedText, String s) {
    return s;
    }
}
