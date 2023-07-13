package com.example.suitmediatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Screen1Activity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPolindrome;
    AppCompatButton btnCheck, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        etName = findViewById(R.id.etName);
        etPolindrome = findViewById(R.id.etPolindrome);
        btnCheck = findViewById(R.id.btnCheck);
        btnNext = findViewById(R.id.btnNext);

        btnCheck.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCheck:
                    String polindrome = etPolindrome.getText().toString();
                    isPalindrome(polindrome);
                break;
            case R.id.btnNext:
                Intent nextPage = new Intent(Screen1Activity.this,Screen2Activity.class);
                String extra = etName.getText().toString();
                nextPage.putExtra("key_name",extra);
                startActivity(nextPage);
                break;
        }
    }

    public void isPalindrome(String inp){
        String processedStr = inp.replaceAll("\\s+", "").toLowerCase();
        String reverseStr="";
        int left = 0;
        int right = processedStr.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (processedStr.charAt(left) != processedStr.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            Toast.makeText(Screen1Activity.this, "isPalindrome", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Screen1Activity.this, "notPalindrome", Toast.LENGTH_SHORT).show();
        }

    }
}