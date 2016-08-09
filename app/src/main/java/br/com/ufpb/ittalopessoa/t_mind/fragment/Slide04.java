package br.com.ufpb.ittalopessoa.t_mind.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ufpb.ittalopessoa.t_mind.R;
import br.com.ufpb.ittalopessoa.t_mind.activity.LoginActivity;
import br.com.ufpb.ittalopessoa.t_mind.activity.RegisterActivity;
import br.com.ufpb.ittalopessoa.t_mind.activity.SlideActivity;

public class Slide04 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_04, container, false);

        View button1 = view.findViewById(R.id.btn_start);
        button1.setOnClickListener(new OnClickButton(RegisterActivity.class));

        View button2 = view.findViewById(R.id.btn_sing_in);
        button2.setOnClickListener(new OnClickButton(LoginActivity.class));

        return view;
    }

    private class OnClickButton implements View.OnClickListener {

        private Class aClass;

        public OnClickButton(Class aClass) {
            this.aClass = aClass;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), aClass);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getContext(), R.anim.anim_fade_in, R.anim.anim_fade_out);
            ActivityCompat.startActivity(getActivity(), intent, optionsCompat.toBundle());
            getActivity().finish();
        }
    }
}
