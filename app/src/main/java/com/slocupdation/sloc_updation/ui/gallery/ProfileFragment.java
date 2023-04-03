package com.slocupdation.sloc_updation.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.slocupdation.sloc_updation.R;
import com.slocupdation.sloc_updation.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ImageView cam_img_btn, img_profile;
    private TextView txt_name, txt_dob, txt_mobile, txt_email,txt_address, txt_warehouse;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        cam_img_btn = view.findViewById(R.id.cam_img_btn);
        img_profile = view.findViewById(R.id.img_profile);
        txt_name = view.findViewById(R.id.txt_name);
        txt_dob = view.findViewById(R.id.txt_dob);
        txt_mobile = view.findViewById(R.id.txt_mobile);
        txt_email = view.findViewById(R.id.txt_email);
        txt_address = view.findViewById(R.id.txt_address);
        txt_warehouse = view.findViewById(R.id.txt_warehouse);



        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}