package com.mylocalkart.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.global.utils.GlobalConstants;
import com.mylocalkart.R;

public class SuccessLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_login);

        TextView tvSuccess = (TextView)findViewById(R.id.tvSuccess);
        tvSuccess.setText(GlobalConstants.mCurrentUser.toString());
    }

}
