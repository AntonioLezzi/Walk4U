
package com.example.walk4you;

        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.content.Intent;

        import com.example.walk4you.Adapter.ContactDBAdapter;

public class MainActivity extends AppCompatActivity {
    int timeout = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Log.class);
                startActivity(i);
                finish();
            }
        }, timeout);
    }
}

