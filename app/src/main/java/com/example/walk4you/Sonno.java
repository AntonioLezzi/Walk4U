package com.example.walk4you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sonno extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonno);

        Button buttonSalva=(Button) findViewById(R.id.buttonSalva);
        buttonSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ore di sonno salvate", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
