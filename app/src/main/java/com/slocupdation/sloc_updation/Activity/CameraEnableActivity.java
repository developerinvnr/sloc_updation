package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.slocupdation.sloc_updation.MainActivity;
import com.slocupdation.sloc_updation.R;
import com.slocupdation.sloc_updation.ui.home.HomeFragment;

public class CameraEnableActivity extends AppCompatActivity {

    private TextView phone_setting_txt, choose_txt, allow_txt;
    private Toolbar toolbar;
    private ImageView back_icon;
    private Button cameraEnable;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_enable);

        toolbar = findViewById(R.id.cus_toolbar);
        back_icon = findViewById(R.id.back_icon);
        cameraEnable = findViewById(R.id.btn_enableCamera);

        TextView title_toolbar = findViewById(R.id.title_toolbar);
        title_toolbar.setText("Scan QR");

        phone_setting_txt = findViewById(R.id.phone_setting_txt);
        choose_txt = findViewById(R.id.choose_txt);
        allow_txt = findViewById(R.id.allow_txt);

        String phone_setting_str = "Go to Phone Setting";
        String choose_str = "Choose Updation WMS from Apps";
        String allow_str = "Choose Allow Permission";

        // String bold format for first text
        SpannableString spannableString1 = new SpannableString(phone_setting_str);
        spannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#3A3A3A")), 6, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), 6, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        phone_setting_txt.setText(spannableString1);

        // String bold format for second text
        SpannableString spannableString2 = new SpannableString(choose_str);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#3A3A3A")), 6, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), 6, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        choose_txt.setText(spannableString2);

        // String bold format for third text
        SpannableString spannableString3 = new SpannableString(allow_str);
        spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#3A3A3A")), 6, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), 6, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        allow_txt.setText(spannableString3);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CameraEnableActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cameraEnable.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(CameraEnableActivity.this, Manifest.permission.CAMERA)){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                    }
                }
                else {
                    Toast.makeText(CameraEnableActivity.this, "Allow camera permission", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}