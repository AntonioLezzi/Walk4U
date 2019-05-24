package com.example.walk4you;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Premi extends AppCompatActivity {
    private ImageButton imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premi);
        imageButton1 = (ImageButton) findViewById(R.id.imageButtonOfferta1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLog();
            }
        });
    }
    public void openActivityLog(){
        Intent intent = new Intent(this, QRcode1.class);
        startActivity(intent);
    }
}