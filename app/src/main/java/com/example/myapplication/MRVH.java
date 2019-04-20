package com.example.myapplication;


import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

class MRVH extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{

    public ImageView image;
    public TextView title;
    public TextView subtitle;
    public ImageButton optionButton;

    private VHCL listener;

    public MRVH(View itemView, VHCL listener) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.item_image);
        title = (TextView) itemView.findViewById(R.id.item_title);
        subtitle = (TextView) itemView.findViewById(R.id.item_subtitle);
        optionButton = (ImageButton) itemView.findViewById(R.id.item_optionButton);

        itemView.setOnClickListener(this);
        optionButton.setOnClickListener(this);

        this.listener = listener;

    }

    @Override
    public void onClick(View view) {
        //when option buttton clicked -> open popup menu, call onMenuItemClick
        listener.onViewClicked(view, getAdapterPosition());
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        listener.onPopupMenuClicked(item, getAdapterPosition());
        return true;
    }

}

