package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int flag;
    ToggleButton toggle;
    TextView tx;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag = 0;
        tx = findViewById(R.id.tx_1);
        et = findViewById(R.id.et_1);
        toggle = findViewById(R.id.toggleBu_1);
        Button btn = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        final TextView tv = findViewById(R.id.tv_title);



        toggle.setText("Click!");
        toggle.setTextColor(Color.BLUE);
        toggle.setOnClickListener(linstener1);
        flag = 0;
        et.getText();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Phone number", et.getText().toString()); //输入完后按下OK，输入内容将进入log
            }
        });
    }

    ToggleButton.OnClickListener linstener1 = new ToggleButton.OnClickListener() {
        public void onClick(View v) {
            if(flag==0)
            {
                tx.setText("Shinomiya Kaguya");
                tx.setTextColor(Color.MAGENTA);
                flag++;
            }
            else
            {
                tx.setText("2A");
                tx.setTextColor(Color.BLACK);
                flag = 0;
            }
        }
    };
}
