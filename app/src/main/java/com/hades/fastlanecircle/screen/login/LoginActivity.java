package com.hades.fastlanecircle.screen.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hades.fastlanecircle.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtUsername = findViewById(R.id.et_username);
        final EditText edtPassword = findViewById(R.id.et_password);
        Button btnSubmit = findViewById(R.id.btn_submit);
        final TextView tvLogin = findViewById(R.id.tv_login);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().equals("Abcxyz")
                        && edtPassword.getText().toString().equals("Aa@123456")) {
                    tvLogin.setText("Success");
                } else {
                    tvLogin.setText("Failure");
                }
            }
        });

    }
}
