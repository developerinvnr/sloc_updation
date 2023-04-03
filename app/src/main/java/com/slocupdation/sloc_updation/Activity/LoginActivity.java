package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.slocupdation.sloc_updation.MainActivity;
import com.slocupdation.sloc_updation.R;

public class LoginActivity extends AppCompatActivity {

    private CardView login;
    private TextInputEditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        init();

    }

    private void init(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}