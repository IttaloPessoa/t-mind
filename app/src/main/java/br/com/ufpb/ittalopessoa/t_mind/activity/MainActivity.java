package br.com.ufpb.ittalopessoa.t_mind.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.squareup.picasso.Picasso;

import br.com.ufpb.ittalopessoa.t_mind.R;
import br.com.ufpb.ittalopessoa.t_mind.util.CircleTransform;
import br.com.ufpb.ittalopessoa.t_mind.util.DrawerItemClickListener;

public class MainActivity extends AppCompatActivity {

    private View mEasyLevel;
    private View mMediumLevel;
    private View mHardLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        AccountHeader accountHeader = new AccountHeaderBuilder().withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.backgroud)
                .addProfiles(
                        new ProfileDrawerItem().withIcon(R.drawable.ic_people)

                                //.withName(usuario.getNome() + " " + usuario.getSobrenome()).withEmail("Pense diferente, ame sua bike.")
                )
                .build();

        new DrawerBuilder().withActivity(this)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.START)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withItemAnimator(new DefaultItemAnimator())
                .withSelectedItem(-1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home")
                                .withIcon(R.drawable.home)
                                .withTag("home")
                )
                .addDrawerItems(new DividerDrawerItem()
                )
                .addDrawerItems(new PrimaryDrawerItem().withName("Perfil")
                        .withIcon(R.drawable.account)
                        .withTag("perfil")

                )
                .addDrawerItems(new DividerDrawerItem()
                )
                .addDrawerItems(new PrimaryDrawerItem().withName("Ranking")
                        .withIcon(R.drawable.trophy_variant_outline)
                        .withTag("ranking")
                )
                .addDrawerItems(new PrimaryDrawerItem().withName("Sobre")
                        .withIcon(R.drawable.help_circle)
                        .withTag("sobre")
                )

                .withOnDrawerItemClickListener(new DrawerItemClickListener(MainActivity.this))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       onClickDrawer(view, drawerItem.getTag().toString());

                                                       return true;
                                                   }

                                               }
                )
                .build();

        //transformCircleImage();

        mEasyLevel = findViewById(R.id.button_basic);
        mMediumLevel = findViewById(R.id.button_medium);
        mHardLevel = findViewById(R.id.button_hard);

    }



    //private void transformCircleImage(){
        //ImageView imgEasyLevel = (ImageView) findViewById(R.id.img1);
        //ImageView imgMediumLevel = (ImageView) findViewById(R.id.img2);
        //ImageView imgHardLevel = (ImageView) findViewById(R.id.img3);

        //Picasso.with(this).load(R.drawable.ic_boy).transform(new CircleTransform()).into(imgEasyLevel);
        //Picasso.with(this).load(R.drawable.ic_man).transform(new CircleTransform()).into(imgMediumLevel);
        //Picasso.with(this).load(R.drawable.ic_old).transform(new CircleTransform()).into(imgHardLevel);
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.profile_action){
            Intent intent = new Intent(this, null);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getBaseContext(), R.anim.anim_fade_in, R.anim.anim_fade_out);
            ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void onClickDrawer(View view, String TAG) {
        Intent intent;

        switch (TAG){
            case "home":
                intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case "perfil":
                Snackbar.make(view, "Em Breve",Snackbar.LENGTH_LONG).show();
                break;
            case "ranking":
                Snackbar.make(view, "Em Breve",Snackbar.LENGTH_LONG).show();
                break;
            case "sobre":
                Snackbar.make(view, "Em Breve",Snackbar.LENGTH_LONG).show();
                break;
        }

    }

}

