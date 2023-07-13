package com.example.suitmediatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView back;
    TextView tvName,tvUsername;
    AppCompatButton btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        back = findViewById(R.id.back1);
        btnChoose = findViewById(R.id.btnChoose);
        tvName = findViewById(R.id.tvName);
        tvUsername = findViewById(R.id.tvUsername);

        Intent extra1 = getIntent();
        String extrastr1 = extra1.getStringExtra("key_name");
        tvName.setText(extrastr1);
        if(tvName.isTextSelectable()){
            tvName.setTextIsSelectable(false);
        };

        Intent extra2 = getIntent();
        tvUsername.setText(extra2.getStringExtra("name"));

        back.setOnClickListener(this);
        btnChoose.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnChoose:
                Intent choose = new Intent(Screen2Activity.this,Screen3Activity.class);
                startActivity(choose);
                break;
            case R.id.back1:
                Intent back = new Intent(Screen2Activity.this, Screen1Activity.class);
                startActivity(back);
                tvName.setTextIsSelectable(true);
                finish();
                break;
        }
    }
}
