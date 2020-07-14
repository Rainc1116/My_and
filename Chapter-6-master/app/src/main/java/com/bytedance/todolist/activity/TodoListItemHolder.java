package com.bytedance.todolist.activity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.DBHelper;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;
import android.widget.CompoundButton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
public class TodoListItemHolder extends RecyclerView.ViewHolder {
    private TextView mContent;
    private TextView mTimestamp;
    CheckBox ch;
    public ImageButton im;
    long id;


    public TodoListItemHolder(@NonNull View itemView) {
        super(itemView);
        mContent = itemView.findViewById(R.id.tv_content);
        mTimestamp = itemView.findViewById(R.id.tv_timestamp);
        ch=itemView.findViewById(R.id.com);
        im = itemView.findViewById(R.id.ib_x);
    }

    public long bind(final TodoListEntity entity) {
        mContent.setText(entity.getContent());
        if(entity.getCom() == true){
            mContent.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        id = 0;
        final long cid = entity.getId();
        final String str = entity.getContent();
        mTimestamp.setText(formatDate(entity.getTime()));
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("test", "onCheckedChanged: ");
                    mContent.setText(str);
                    mContent.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    ch.setClickable(false);
                }
            }
        });
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return id;
    }




    private String formatDate(Date date) {
        DateFormat format = SimpleDateFormat.getDateInstance();
        return format.format(date);
    }
}
