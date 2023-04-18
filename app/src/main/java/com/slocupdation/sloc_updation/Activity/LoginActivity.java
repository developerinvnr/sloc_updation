package com.slocupdation.sloc_updation.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.slocupdation.sloc_updation.MainActivity;
import com.slocupdation.sloc_updation.R;
import com.slocupdation.sloc_updation.parser.LoginResponse;
import com.slocupdation.sloc_updation.parser.User;
import com.slocupdation.sloc_updation.retrofit.ApiInterface;
import com.slocupdation.sloc_updation.retrofit.RetrofitClient;
import com.slocupdation.sloc_updation.sessionmanager.SharedPreferences;
import com.slocupdation.sloc_updation.utils.CustomProgressDialogue;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import kotlin.io.TextStreamsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private AppCompatButton login;
    private TextInputEditText et_username, et_password;
    private CustomProgressDialogue customProgressDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        SharedPreferences.getInstance(getApplicationContext());
        //Utils.getInstance(getApplicationContext());
        //Utils.getInstance().initConnectionDetector();
        customProgressDialogue=new CustomProgressDialogue(LoginActivity.this);
        init();
    }

    private void init(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Enter username", Toast.LENGTH_SHORT).show();
                }else if (et_password.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Enter password", Toast.LENGTH_SHORT).show();
                }else {
                    checkLogin(et_username.getText().toString().trim(),et_password.getText().toString().trim());
                }
            }
        });
    }

    private void checkLogin(String username, String password) {
        customProgressDialogue.show();
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Log.e("Login", username+"="+password);
        Call<LoginResponse> call = apiInterface.getLoginInfo(username,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                customProgressDialogue.cancel();
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    customProgressDialogue.cancel();
                    assert loginResponse != null;
                    if (loginResponse.getError()) {
                        String msg = loginResponse.getErrorMsg();
                        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                    } else {

                        //Log.e(TAG, "Status : " + loginResponse.getStatus());
                        User userData = loginResponse.getUser();
                        SharedPreferences.getInstance().storeObject(SharedPreferences.KEY_LOGIN_OBJ, userData);
                        Toast.makeText(LoginActivity.this, "Welcome : "+userData.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    customProgressDialogue.cancel();
                    if (response.errorBody() != null) {
                        try {
                            JSONObject jsonObj = new JSONObject(TextStreamsKt.readText(response.errorBody().charStream()));
                            String msg = jsonObj.getString("message");
                            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                customProgressDialogue.cancel();
                Log.e(TAG, "RetrofitError : " + t.getMessage());
            }
        });
    }
}