package br.com.ufpb.ittalopessoa.t_mind.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ufpb.ittalopessoa.t_mind.R;
import br.com.ufpb.ittalopessoa.t_mind.TMindApplication;

public class RegisterActivity extends AppCompatActivity {

    // UI references.
    private EditText mNameView;
    private EditText mSobrenomeView;
    private EditText mEmailView;
    private EditText mPasswordView;


    private TMindApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        application = (TMindApplication) getApplicationContext();

        activateToolbar();

        TextInputLayout mNameInputLayout = (TextInputLayout) findViewById(R.id.textInputName);
        mNameInputLayout.setTypeface(getTypefaceRobotoRegular());
        TextInputLayout mLastNameInputLayout = (TextInputLayout) findViewById(R.id.textInputLastName);
        mLastNameInputLayout.setTypeface(getTypefaceRobotoRegular());
        TextInputLayout mMailInputLayout = (TextInputLayout) findViewById(R.id.textInputMail);
        mMailInputLayout.setTypeface(getTypefaceRobotoRegular());
        TextInputLayout mPasswordInputLayout = (TextInputLayout) findViewById(R.id.textInputPassword);
        mPasswordInputLayout.setTypeface(getTypefaceRobotoRegular());

        mNameView = (EditText) findViewById(R.id.textName);
        mNameView.setTypeface(getTypefaceRobotoMedium());
        mSobrenomeView = (EditText) findViewById(R.id.textSobrenome);
        mSobrenomeView.setTypeface(getTypefaceRobotoMedium());
        mEmailView = (EditText) findViewById(R.id.email_text);
        mEmailView.setTypeface(getTypefaceRobotoMedium());
        mPasswordView = (EditText) findViewById(R.id.senha_text);
        mPasswordView.setTypeface(getTypefaceRobotoMedium());
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent event) {
                if (id == R.id.register || id == EditorInfo.IME_NULL) {
                    attemptRegister();
                    return true;
                }
                return false;
            }
        });

        Button mButtonRegister = (Button) findViewById(R.id.email_register_button);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });


    }

    private Typeface getTypefaceRobotoRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
    }

    private Typeface getTypefaceRobotoMedium() {
        return Typeface.createFromAsset(getAssets(), "fonts/roboto_medium.ttf");
    }

    /**
     * As tentativas de login ou registrar uma nova conta é especificado pelo formulário de login.
     * Se houver erros de formulário (e-mail inválido, campos em falta, etc.), os
     * erros são apresentados e não é feita nenhuma tentativa de login real.
     */
    public void attemptRegister() {

        // Reseta os erros.
        mEmailView.setError(null);

        // Captura os valores nos campos
        String nome = mNameView.getText().toString();
        String sobrenome = mSobrenomeView.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Verifica se a senha é válida, e se o usuário efetuou login com sucesso.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Verifica se o e-mail é válido.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        }         if (cancel) {
            // se houver um erro, o erro é indicado no primeiro campo
            // de texto.
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }



    private boolean isPasswordValid(String password) {
        return password.length() >= 4 && password.length() <= 16;
    }

    /**
     * Exibe o progresso de login.
     */


    private void activateToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id = item.getItemId();
           if (id == android.R.id.home) {
            Intent intent = new Intent(RegisterActivity.this, SlideActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getBaseContext(), R.anim.anim_fade_in, R.anim.anim_fade_out);
            ActivityCompat.startActivity(RegisterActivity.this, intent, optionsCompat.toBundle());
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
