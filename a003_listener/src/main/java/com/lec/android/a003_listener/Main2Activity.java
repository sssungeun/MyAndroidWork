package com.lec.android.a003_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main2Activity extends AppCompatActivity {

    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,
            btn_Add,btn_Sub,btn_Mul,btn_Div,btn_calc,btn_dec,btn_clear;
    EditText etResult;

    float num1, num2;
    boolean Add, Sub, Mul, Div ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_0 =  findViewById(R.id.btn_0);
        btn_1 =  findViewById(R.id.btn_1);
        btn_2 =  findViewById(R.id.btn_2);
        btn_3 =  findViewById(R.id.btn_3);
        btn_4 =  findViewById(R.id.btn_4);
        btn_5 =  findViewById(R.id.btn_5);
        btn_6 =  findViewById(R.id.btn_6);
        btn_7 =  findViewById(R.id.btn_7);
        btn_8 =  findViewById(R.id.btn_8);
        btn_9 =  findViewById(R.id.btn_9);
        btn_Add =  findViewById(R.id.btn_Add);
        btn_Div =  findViewById(R.id.btn_Div);
        btn_Sub =  findViewById(R.id.btn_Sub);
        btn_Mul =  findViewById(R.id.btn_Mul);
        btn_calc =  findViewById(R.id.btn_calc);
        btn_dec =  findViewById(R.id.btn_dec);
        btn_clear =  findViewById(R.id.btn_clear);
        etResult = (EditText) findViewById(R.id.etResult);

        btn_0.setOnClickListener(v -> etResult.setText(etResult.getText()+"0"));

        btn_1.setOnClickListener(v -> etResult.setText(etResult.getText()+"1"));

        btn_2.setOnClickListener(v -> etResult.setText(etResult.getText()+"2"));

        btn_3.setOnClickListener(v -> etResult.setText(etResult.getText()+"3"));

        btn_4.setOnClickListener(v -> etResult.setText(etResult.getText()+"4"));

        btn_5.setOnClickListener(v -> etResult.setText(etResult.getText()+"5"));

        btn_6.setOnClickListener(v -> etResult.setText(etResult.getText()+"6"));

        btn_7.setOnClickListener(v -> etResult.setText(etResult.getText()+"7"));

        btn_8.setOnClickListener(v -> etResult.setText(etResult.getText()+"8"));

        btn_9.setOnClickListener(v -> etResult.setText(etResult.getText()+"9"));

        btn_dec.setOnClickListener(v -> etResult.setText(etResult.getText()+"."));

        btn_Add.setOnClickListener(v -> {

            if (etResult == null){
                etResult.setText("");
            }else {
                num1 = Float.parseFloat(etResult.getText() + "");
                Add = true;
                etResult.setText(null);
            }
        });

        btn_Sub.setOnClickListener(v -> {
            num1 = Float.parseFloat(etResult.getText() + "");
            Sub = true ;
            etResult.setText(null);
        });

        btn_Mul.setOnClickListener(v -> {
            num1 = Float.parseFloat(etResult.getText() + "");
            Mul = true ;
            etResult.setText(null);
        });

        btn_Div.setOnClickListener(v -> {
            num1 = Float.parseFloat(etResult.getText()+"");
            Div = true ;
            etResult.setText(null);
        });

        btn_calc.setOnClickListener(v -> {
            num2 = Float.parseFloat(etResult.getText() + "");

            if (Add == true){

                etResult.setText(num1 + num2 +"");
                Add=false;
            }


            if (Sub == true){
                etResult.setText(num1 - num2 +"");
                Sub=false;
            }

            if (Mul == true){
                etResult.setText(num1 * num2 + "");
                Mul=false;
            }

            if (Div == true){
                etResult.setText(num1 / num2+"");
                Div=false;
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etResult.setText("");
            }
        });
    }

}