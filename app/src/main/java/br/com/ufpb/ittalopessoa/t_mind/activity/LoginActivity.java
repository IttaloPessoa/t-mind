package br.com.ufpb.ittalopessoa.t_mind.activity;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.ufpb.ittalopessoa.t_mind.R;
import br.com.ufpb.ittalopessoa.t_mind.TMindApplication;
import br.com.ufpb.ittalopessoa.t_mind.util.CircleTransform;

/**
 * Tela de login - obrigatório
 */
public class LoginActivity extends AppCompatActivity {


    private EditText mUserView;
    private EditText mPasswordView;
    private TMindApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the application class
        application = (TMindApplication) getApplicationContext();

        ImageView imageView = (ImageView) findViewById(R.id.imageLogin);
        Picasso.with(this).load(R.drawable.ic_people_shadow).transform(new CircleTransform()).into(imageView);

        // Set up Toolbar
        activateToolbar();

        // Set up the login form.
        TextInputLayout mTextInputLayout = (TextInputLayout) findViewById(R.id.textInputEmail);
        mTextInputLayout.setTypeface(getTypefaceRobotoRegular());
        mUserView = (EditText) findViewById(R.id.email);
        mUserView.setTypeface(getTypefaceRobotoRegular());


        TextInputLayout mTextPasswordLayout = (TextInputLayout) findViewById(R.id.textInputSenha);
        mTextPasswordLayout.setTypeface(getTypefaceRobotoRegular());

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setTypeface(getTypefaceRobotoRegular());
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

            }
        });


    }

    private void activateToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private Typeface getTypefaceRobotoRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(LoginActivity.this, SlideActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getBaseContext(), R.anim.anim_fade_in, R.anim.anim_fade_out);
            ActivityCompat.startActivity(LoginActivity.this, intent, optionsCompat.toBundle());
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void attemptLogin() {
        // Reseta os erros.
        mUserView.setError(null);
        mPasswordView.setError(null);

        // Captura os valores nos campos
        String user = mUserView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Verifica se a senha é válida, e se o usuário usuário login com sucesso.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Verifica se o e-mail é válido.
        if (TextUtils.isEmpty(user)) {
            mUserView.setError(getString(R.string.error_field_required));
            focusView = mUserView;
            cancel = true;
        }

        if (cancel) {
            // se houver um erro, o erro é indicado no primeiro campo
            // de texto.
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 4 && password.length() <= 16;
    }


}