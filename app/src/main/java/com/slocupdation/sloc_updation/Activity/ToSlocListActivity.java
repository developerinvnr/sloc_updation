package com.slocupdation.sloc_updation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.slocupdation.sloc_updation.R;

public class ToSlocListActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_sloc_list);

//        View customView = LayoutInflater.from(this).inflate(R.layout.custom_toolbar, null);
        toolbar = findViewById(R.id.cus_toolbar);
        TextView title_toolbar = findViewById(R.id.title_toolbar);
        title_toolbar.setText("TO SLOC");

    }
}