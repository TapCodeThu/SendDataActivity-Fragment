package com.example.demo01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class HomeFragment extends Fragment {
    private EditText edtEmail;
    private EditText edtName;
    private Button btnUpdate;
    private View mView;
    private MainActivity mMainActivity;
    private ISendDataListener iSendDataListener;



    public static HomeFragment getInstance(User user) {
       HomeFragment homeFragment = new HomeFragment();
       Bundle bundle = new Bundle();
       bundle.putSerializable("object_user",user);
       homeFragment.setArguments(bundle);
       return homeFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mMainActivity = (MainActivity) getActivity();
        iNitUI();
        return mView;
    }

    private void iNitUI() {
        edtEmail = mView.findViewById(R.id.id_email);
        edtName = mView.findViewById(R.id.id_nameuser);
        btnUpdate = mView.findViewById(R.id.id_buttonUpdate);
        User user = (User) getArguments().get("object_user");
        edtEmail.setText(user.getEmail());
        edtName.setText(user.getName());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senDatatoActivity();
            }
        });
    }

    private void senDatatoActivity() {
        String strEmailUpdate = edtEmail.getText().toString().trim();
        String strNamelUpdate = edtName.getText().toString().trim();
       User user = new User(strEmailUpdate,strNamelUpdate);
       iSendDataListener = mMainActivity;
       iSendDataListener.sendData(user);

    }
}