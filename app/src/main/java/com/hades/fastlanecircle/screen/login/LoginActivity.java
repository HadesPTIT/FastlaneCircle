package com.hades.fastlanecircle.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.source.local.SharePreferences;
import com.hades.fastlanecircle.screen.main.MainActivity;

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
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    tvLogin.setText(getString(R.string.str_success));
                    SharePreferences.getInstance().addUser(username, password);
                    Toast.makeText(LoginActivity.this, getString(R.string.str_success), Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    },1500);

                } else {
                    tvLogin.setText(getString(R.string.str_failure));
                    Toast.makeText(LoginActivity.this, getString(R.string.str_failure), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
