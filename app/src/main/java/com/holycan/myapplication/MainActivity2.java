package com.holycan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button signOut;
    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        signOut = (Button) findViewById(R.id.btnSignout);

        tvUsername=(TextView) findViewById(R.id.tvUsername);
        Intent myIntent= getIntent();
        Bundle b = myIntent.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("usernm");
            tvUsername.setText(j);
        }

        signOut.setOnClickListener(this::onCLick);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void onCLick(View view) {
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
    }
}