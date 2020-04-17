package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    PersonListAdapter adapter;  // Adapter 객체
    RecyclerView rv;
    EditText etName, etAge, etAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddr = findViewById(R.id.etAddr);

        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야 한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        // Adapter객체 생성
        adapter = new PersonListAdapter();

       // initAdapter(adapter);

        rv.setAdapter(adapter);   // RecyclerView 에 Adapter 장착!

        Button btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });




    } // end onCreate()


    protected void insertData(View v){
        // 리스트 맨 앞에 추가
        adapter.addItem(new PersonList(etName.getText().toString(),
                etAge.getText().toString(),
                etAddr.getText().toString()));
        adapter.notifyDataSetChanged();  // 데이터변경을 Adapter 에 알리고, 리스트뷰에 반영 .
    }

} // end Activity
