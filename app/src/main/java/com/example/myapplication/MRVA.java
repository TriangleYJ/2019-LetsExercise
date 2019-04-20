package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jyj on 2017-08-05.
 */

public class MRVA extends RecyclerView.Adapter<MRVH> implements VHCL{
    private Context context;
    public List<BaseListClass> list;


    public MRVA(List<BaseListClass> list){
        this.list = list;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("list");
    DatabaseReference myRef2 = database.getReference("request");

    @Override
    public MRVH onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View layoutView = LayoutInflater.from(context).inflate(R.layout.main_item, null);
        MRVH holder = new MRVH(layoutView, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MRVH holder, int position) {
        BaseListClass data = list.get(position);
        holder.title.setText(data.getTitle());
        String s = data.getStart() +" ~ " + data.getStop() +"  |  " + data.getPlace() +"  |  " + data.getId();
        holder.subtitle.setText(s);
        if(data.getTitle().equals("야구"))holder.image.setImageResource(R.drawable.baseball);
        if(data.getTitle().equals("농구"))holder.image.setImageResource(R.drawable.basketball);
        if(data.getTitle().equals("테니스"))holder.image.setImageResource(R.drawable.tennis);
        if(data.getTitle().equals("탁구"))holder.image.setImageResource(R.drawable.ping);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewClicked(View view, int position) {
        ((listActivity) context).onViewClicked(list.get(position), 0);
    }

    @Override
    public void onPopupMenuClicked(MenuItem menuItem, int position) {
    }


}

