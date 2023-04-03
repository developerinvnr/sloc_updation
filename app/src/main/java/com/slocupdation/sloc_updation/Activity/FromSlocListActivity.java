package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.slocupdation.sloc_updation.R;

public class FromSlocListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CheckBox checkBox;
    private Button btn_preview, btn_rescan, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_sloc_list);
        checkBox = findViewById(R.id.checkbox);
        btn_preview = findViewById(R.id.btn_preview);
        btn_rescan = findViewById(R.id.btn_rescan);
        btn_cancel = findViewById(R.id.btn_cancel);

        toolbar = findViewById(R.id.cus_toolbar);
        TextView title_toolbar = findViewById(R.id.title_toolbar);
        title_toolbar.setText("FROM SLOC");


    }
}