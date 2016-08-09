package br.com.ufpb.ittalopessoa.t_mind.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.attention.WobbleAnimator;

import br.com.ufpb.ittalopessoa.t_mind.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView icone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        icone = (ImageView)findViewById(R.id.ico_splash);
        YoYo.with(Techniques.Bounce).duration(1500).delay(1000).playOn(icone);

        hideNavigationBar();

        new SplashAsyncTask().execute((Void) null);
    }

    // Ocultar a statusBar e actionBar
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    // Thread para envetuais carregamentos e consultas antes do aplicativo iniciar
    private class SplashAsyncTask extends AsyncTask<Void, Void, Boolean>{

        private final int TIME = 5000;

        @Override
        protected Boolean doInBackground(Void... voids) {
            // Código que roda em segundo plano
            try{
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean sucess) {
            // Código a ser executado após o carregamento do segundo plano
            if(sucess){
                Intent intent = new Intent(SplashActivity.this, SlideActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
