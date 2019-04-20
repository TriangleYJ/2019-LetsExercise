package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class listActivity extends AppCompatActivity {

    RecyclerView recycler;
    private MRVA adapter;
    private LinearLayoutManager glm;
    private List<BaseListClass> list = new ArrayList<>();

    SharedPreferences pref;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("list");
    DatabaseReference myRef2 = database.getReference("request");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.la_activity);

        FloatingActionButton fab = findViewById(R.id.fab);

        pref = getSharedPreferences("pref", MODE_PRIVATE);
        pref.getString("id", "");





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(listActivity.this, "생성 시작", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(listActivity.this, CreateExercise.class);
                startActivity(intent);
            }
        });

        initrecyclerview();
        recyclerPatch(list);






        //myRef.setValue("Hello, World!");

        myRef.addChildEventListener(new ChildEventListener() {  // message는 child의 이벤트를 수신합니다.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                RawList chatData = dataSnapshot.getValue(RawList.class);  // chatData를 가져오고
                list.add(new BaseListClass(chatData.name, chatData.id, chatData.place, chatData.start, chatData.stop));  // adapter에 추가합니다.
                recyclerPatch(list);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                RawList chatData = dataSnapshot.getValue(RawList.class);  // chatData를 가져오고

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        myRef2.addChildEventListener(new ChildEventListener() {  // message는 child의 이벤트를 수신합니다.
            @Override
            public void onChildAdded(final DataSnapshot dataSnapshot, String s) {
                req chatData = dataSnapshot.getValue(req.class);  // chatData를 가져오고

                if(chatData.to.equals(pref.getString("id", null))){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            listActivity.this);

                    alertDialogBuilder.setMessage(chatData.from +" 님과의 운동 신청이 왔습니다. 같이 하시겠습니까?")
                            .setPositiveButton("네",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    // 프로그램을 종료한다
                                    Toast.makeText(listActivity.this, "운동 신청 완료! 잠시만 기다려 주세요", Toast.LENGTH_LONG).show();
                                    dataSnapshot.getRef().removeValue();
                                }
                            })
                            .setNegativeButton("아니오",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            // 다이얼로그를 취소한다
                                            dialog.cancel();
                                            dataSnapshot.getRef().removeValue();
                                        }
                                    });
                    alertDialogBuilder.create().show();
                }

           }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                RawList chatData = dataSnapshot.getValue(RawList.class);  // chatData를 가져오고

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initrecyclerview() {
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        glm = new LinearLayoutManager(this);
        recycler.setNestedScrollingEnabled(false);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(glm);
    }

    private void recyclerPatch(List<BaseListClass> list){
        adapter = new MRVA(list);
        recycler.setAdapter(adapter);
    }

    public void onViewClicked(BaseListClass baseListClass, int i) {
        myRef2.push().setValue(new req(pref.getString("id", null), baseListClass.getId()));  // 기본 database 하위 message라는 child에 chatData를 list로 만들기
        Toast.makeText(listActivity.this, "운동 요청이 완료되었습니다.", Toast.LENGTH_LONG).show();
    }
}
