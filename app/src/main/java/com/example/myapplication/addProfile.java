package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addProfile extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("player");

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;

    SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ap_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);



        FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(addProfile.this, "추가 시도..", Toast.LENGTH_LONG).show();

                //3 name 0 키 2 몸무게 4 주종목 5 부종목 6 지역
                Profile chatData = new Profile();
                chatData.setHeight(Integer.parseInt(editText.getText().toString()));
                chatData.setMain(editText4.getText().toString());
                chatData.setSub(editText5.getText().toString());
                chatData.setWeight(Integer.parseInt(editText2.getText().toString()));
                chatData.setName(editText3.getText().toString());
                chatData.setRegion(editText6.getText().toString());
                myRef.push().setValue(chatData);  // 기본 database 하위 message라는 child에 chatData를 list로 만들기

                Intent intent= new Intent(addProfile.this, MainActivity.class);
                startActivity(intent);
                finish();

                pref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("id", editText3.getText().toString());

                editor.commit();

            }
        });




        //myRef.setValue("Hello, World!");


    }
}
