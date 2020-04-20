package com.example.a014_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a014_dialog.R.*;

public class MainActivity extends AppCompatActivity {


    //대화상자 객체
    Dialog dlg1;
    ImageView ivDlgBanner;
    Button btnDlgEvenet;

    Dialog dlg2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        //Dialog 클래스로 다이얼로그 객체 생성및 세팅
        dlg1 = new Dialog(this); //다이얼로그 객체 생성
        dlg1.setContentView(layout.dialog_layout11); //다이얼로그 화면 등록

        //Dialog 안의 View 객체들 얻어오기
        ivDlgBanner = dlg1.findViewById(id.ivDlgBanner);
        btnDlgEvenet = dlg1.findViewById(id.btnDlgEvent);

        btnDlgEvenet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivDlgBanner.setImageResource(R.drawable.face01);
                Toast.makeText(getApplicationContext(),"다이얼로그 버튼을 눌렀어요", Toast.LENGTH_SHORT).show();
            }
        });

        //Activity에 Dialog 등록하기
        dlg1.setOwnerActivity(MainActivity.this);
        dlg1.setCanceledOnTouchOutside(true); //다이얼로그 바깥 영역 클릭시 (혹은 back 버튼 클릭시)
                                    //종료할 것인지 여부, true : 종료됨, false : 종료 안됨.
    }


    public void showDialog1(View v){
        dlg1.show(); //다이얼로그 띄우기

    }


    public void showDialog2(View v){
        //TODO
    }
}
