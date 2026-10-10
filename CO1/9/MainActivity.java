package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
    }

    public void Click(View view) {
        String n = name.getText().toString();
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("name", n);
        startActivity(i);
    }

    public static class SecondActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setGravity(Gravity.CENTER);
            layout.setPadding(30, 30, 30, 30);

            TextView tv = new TextView(this);
            tv.setTextSize(24);
            tv.setGravity(Gravity.CENTER);

            String n = getIntent().getStringExtra("name");
            tv.setText("Welcome, " + n);

            layout.addView(tv);
            setContentView(layout);
        }
    }
}
