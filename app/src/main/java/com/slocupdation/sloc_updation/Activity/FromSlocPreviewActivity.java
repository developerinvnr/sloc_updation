package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.slocupdation.sloc_updation.R;

public class FromSlocPreviewActivity extends AppCompatActivity {

    private Button btn_submit, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_sloc_preview);

        btn_submit = findViewById(R.id.btn_submit);
        btn_cancel = findViewById(R.id.btn_cancel);

    }
}