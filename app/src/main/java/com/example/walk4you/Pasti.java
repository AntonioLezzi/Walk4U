package com.example.walk4you;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Pasti extends AppCompatActivity {

    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasti);
        imageButton2 = (ImageButton) findViewById(R.id.imageButtonColazione);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLog();
            }
        });
    }
    public void openActivityLog(){
        Intent intent = new Intent(this, AggiungiCibo.class);
        startActivity(intent);
    }
}
