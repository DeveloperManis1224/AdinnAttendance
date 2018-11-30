package com.android.app.devops.adinn_attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.app.devops.adinn_attendance.Util.GpsTracker;

public class LoginPage extends AppCompatActivity {
    private EditText mUsername,mPassword;
    GpsTracker gpsTracker ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
    }
    public void init(){
        mUsername = findViewById(R.id.edt_username);
        mPassword = findViewById(R.id.edt_password);
        gpsTracker = new GpsTracker(LoginPage.this);
    }

    public void onClickLogin(View view) {
        if(isValid())
        {
            Intent in = new Intent(LoginPage.this,HomePage.class);
            startActivity(in);
            finish();
        }
    }

    private boolean isValid()
    {
        boolean val = true;
        if(mUsername.getText().toString().trim().isEmpty())
        {
            val = false;
            mUsername.setError("Invalid");
        }
        if(mPassword.getText().toString().trim().isEmpty())
        {
            val = false;
            mPassword.setError("Invalid");
        }
        return val;
    }
}
