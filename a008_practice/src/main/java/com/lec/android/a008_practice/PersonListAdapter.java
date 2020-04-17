package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder>{

    List<PersonList> items = new ArrayList<PersonList>();

    static PersonListAdapter adapter;
    public PersonListAdapter(){this.adapter = this;}



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 주어진 ViewGroup 으로부터 LayoutInflater 추출
        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        // 준비된 레이아웃(XML) 으로부터 View 를 만들어 ViewGroup 에 붙이고
        // 그렇게 만들어진 View 를 리턴한다
        View itemView = inf.inflate(R.layout.item, parent, false);

        // 위에서 마들어진 새로운 View 를 ViewHolder 에 담아 리턴
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            PersonList item = items.get(position);
            holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    // nested class (static inner) 로 ViewHolder 클래스 정의
    static class ViewHolder extends RecyclerView.ViewHolder{

        // ViewHolder 에 담긴 각각의 View 들을 담을 변수
        TextView tvName, tvAge, tvAddr;
        ImageButton btnDel;
       // TextView tvName, tvPhone, tvEmail;

        // 생성자 필수
        public ViewHolder(@NonNull View itemView) {  // item 레이아웃의 View 객체가 전달됨.
            super(itemView);

            // View 객체 가져오기
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddr = itemView.findViewById(R.id.tvAddress);
            btnDel = itemView.findViewById(R.id.btnDel);

            // 삭제버튼 누르면 item 삭제되게 하기
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.removeItem(getAdapterPosition());  // 데이터 삭제
                    // 데이터 변경 (수정, 삭제, 추가) 내역이 adapter 에 반영되어야 정상적으로 동작함!!! ★★★
                    adapter.notifyDataSetChanged();
                }
            });

            // 클릭리스너 장착
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();   // 이 리스너가 장착된 item 의 리스트상의 position 값
//                    //Toast.makeText(v.getContext(), "position:" + position, Toast.LENGTH_LONG).show();
//
//                    // 아이템을 클릭하면 해당 세부 정보 액티비티로 넘겨주기
//                    Intent intent = new Intent(v.getContext(), PhonebookDetail.class);
//
//                    intent.putExtra("pb", adapter.getItem(position));
//
//                    v.getContext().startActivity(intent);
//                }
//            });





        } // end 생성자

        // PersonList 데이터를 받아서 멤버변수 세팅
        public void setItem(PersonList item){
            tvName .setText("이름: "+item.getName());
            tvAge.setText("나이: "+item.getAge());
            tvAddr.setText("주소: "+item.getAddr());
        }


    }  // end ViewHolder


    // 데이터를 다루기 위한 메소드들
    // ArrayList 의 메소드들 사용
    public void addItem(PersonList item) {  items.add(item); }
    public void addItem(int position, PersonList item) {   items.add(position, item);}
    public void setItems(ArrayList<PersonList> items) {   this.items = items;}
    public PersonList getItem(int position) {   return items.get(position);}
    public void setItem(int position, PersonList item) {   items.set(position, item); }
    public void removeItem(int position){ items.remove(position); }




}
