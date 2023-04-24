package com.slocupdation.sloc_updation.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.slocupdation.sloc_updation.Activity.CameraEnableActivity;
import com.slocupdation.sloc_updation.Activity.FromSLOCScanner_Activity;
import com.slocupdation.sloc_updation.Activity.FromSlocListActivity;
import com.slocupdation.sloc_updation.Activity.ToSlocListActivity;
import com.slocupdation.sloc_updation.R;
import com.slocupdation.sloc_updation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private Button btn_fromSloc, btn_toSloc;

    private FragmentHomeBinding binding;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_fromSloc = view.findViewById(R.id.btn_fromSloc);
        btn_toSloc = view.findViewById(R.id.btn_toSloc);

//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            requestPermissions(new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
//        }


        btn_fromSloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    //Intent intent = new Intent(getContext(), FromSlocListActivity.class);
                    Intent intent = new Intent(getContext(), FromSLOCScanner_Activity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getContext(), CameraEnableActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_toSloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(getContext(), FromSLOCScanner_Activity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getContext(), CameraEnableActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}