package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ISendDataListener{
    private EditText edtEmail;
    private EditText edtName;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.id_email);
        edtName = findViewById(R.id.id_name);
        btnSend = findViewById(R.id.id_button);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToFragment();
            }
        });
    }

    private void sendDataToFragment() {
        String strEmail = edtEmail.getText().toString().trim();
        String strName = edtName.getText().toString().trim();
        User user = new User(strEmail,strName);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.id_framgelayout,HomeFragment.getInstance(user));
        fragmentTransaction.commit();

    }



    @Override
    public void sendData(User user) {
        edtEmail.setText(user.getEmail());
        edtName.setText(user.getName());
    }
}