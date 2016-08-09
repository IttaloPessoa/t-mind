package br.com.ufpb.ittalopessoa.t_mind.util;

import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import br.com.ufpb.ittalopessoa.t_mind.activity.MainActivity;

/**
 * Created by Ittalo Pessoa on 05/05/2016.
 */
public class DrawerItemClickListener implements Drawer.OnDrawerItemClickListener {

    private MainActivity mainActivity;
    public DrawerItemClickListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {


        String tag = drawerItem.getTag().toString();

        switch (tag) {
            case "home":
                return true;
            case "perfil":
                return true;
            case "ranking":

                return true;
            case "sobre":

                return true;

        }
        return false;
    }
}
