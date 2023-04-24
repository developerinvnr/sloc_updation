package com.slocupdation.sloc_updation.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.slocupdation.sloc_updation.R;

public class FromSLOCScanner_Activity extends AppCompatActivity {

    private CodeScanner codeScanner;
    private CodeScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_sloc_scanner);

        scannerView = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this, scannerView);
        codeScanner.startPreview();

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(FromSLOCScanner_Activity.this, FromSlocListActivity.class);
                        Toast.makeText(FromSLOCScanner_Activity.this, result.getText(), Toast.LENGTH_SHORT).show();
                        intent.putExtra("scanResult", result.getText());
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    protected void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}