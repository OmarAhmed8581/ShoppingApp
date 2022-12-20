package com.aarafrao.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCreateAcc;
    TextView txtSkip, txtAlready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFullScreen();
        initIds();
        clickListeners();

    }

    private void initIds() {
        btnCreateAcc = findViewById(R.id.btnCreateAcc);
        txtSkip = findViewById(R.id.txtSkip);
        txtAlready = findViewById(R.id.txtAlready);
    }

    private void clickListeners() {
        txtSkip.setOnClickListener(this);
        btnCreateAcc.setOnClickListener(this);
        txtAlready.setOnClickListener(this);
    }

    private void setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController controller = getWindow().getInsetsController();
            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        } else {
            //noinspection deprecation
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtSkip:
                //skip to MainActivity
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
                finish();
                break;

            case R.id.txtAlready:
                //loginPage
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;

            case R.id.btnCreateAcc:
                //createAccount
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                finish();
                break;
        }
    }
}