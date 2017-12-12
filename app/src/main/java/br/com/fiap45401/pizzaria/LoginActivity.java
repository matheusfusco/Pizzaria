package br.com.fiap45401.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;

    @BindView(R.id.btConectar)
    Button btConectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateUsername();
            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePassword();
            }
        });
    }

    @OnClick(R.id.btConectar)
    public void connectBtnClicked() {
        if (validateUsername() && validatePassword()) {
            Intent proxTela = new Intent(this, MainActivity.class);
            proxTela.putExtra("USUARIO", username.getEditText().getText().toString());
            startActivity(proxTela);
        }
    }

    private boolean validateUsername() {
        if (username.getEditText().getText().toString().isEmpty()) {
            username.setError("Favor informar o login");
            return false;
        }
        else {
            username.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        if (password.getEditText().getText().toString().isEmpty()) {
            password.setError("Favor informar a senha");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }
}
