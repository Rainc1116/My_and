package com.bytedance.todolist.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;

public class AddActivity extends AppCompatActivity {
    private Button confirm;
    private EditText info;
    private String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list_add_layout);
        info = findViewById(R.id.editText);
        confirm = findViewById(R.id.con1);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = info.getText().toString();
                Intent intent = new Intent(AddActivity.this,TodoListActivity.class);
                intent.putExtra("info",input);
                startActivity(intent);
            }
        });
    }

}
