package com.aarafrao.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();

        String name = getIntent().getStringExtra("name");
        if (name != null) {
            txtName.setText("Welcome " + name);
        }

    }

    private void initViews() {
        txtName = findViewById(R.id.txtName1);
    }
}