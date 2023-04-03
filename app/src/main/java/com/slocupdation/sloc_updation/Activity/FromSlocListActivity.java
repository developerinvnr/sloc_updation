package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.slocupdation.sloc_updation.R;

public class FromSlocListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_sloc_list);
        checkBox = findViewById(R.id.checkbox);

        toolbar = findViewById(R.id.cus_toolbar);
        TextView title_toolbar = findViewById(R.id.title_toolbar);
        title_toolbar.setText("FROM SLOC");


    }
}