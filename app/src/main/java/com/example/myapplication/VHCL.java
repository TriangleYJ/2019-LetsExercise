package com.example.myapplication;

import android.view.MenuItem;
import android.view.View;

/**
 * Created by jnj on 2016-09-04.
 */
public interface VHCL {
    void onViewClicked(View view, int position);

    void onPopupMenuClicked(MenuItem menuItem, int position);
}