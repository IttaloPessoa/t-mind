package br.com.ufpb.ittalopessoa.t_mind.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

import br.com.ufpb.ittalopessoa.t_mind.R;
import br.com.ufpb.ittalopessoa.t_mind.fragment.Slide01;
import br.com.ufpb.ittalopessoa.t_mind.fragment.Slide02;
import br.com.ufpb.ittalopessoa.t_mind.fragment.Slide03;
import br.com.ufpb.ittalopessoa.t_mind.fragment.Slide04;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        CirclePageIndicator pageIndicator = (CirclePageIndicator) findViewById(R.id.pageIndicator);

        // ViewPager Logic
        if (viewPager != null) {
            viewPager.setAdapter(pagerAdapter);
            viewPager.setPageTransformer(false, new FadePageTransformer());
        }
        // PageIndicator Logic
        if (pageIndicator != null) {
            pageIndicator.setViewPager(viewPager);
            pageIndicator.setCurrentItem(viewPager != null ? viewPager.getCurrentItem() : 0);
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = {"Slide One", "Slide Two", "Slide Three", "Slide Four"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            if(position == 0){
                fragment = new Slide01();
            }else if(position == 1){
                fragment = new Slide02();
            }else if(position == 2){
                fragment = new Slide03();
            }else if(position == 3){
                fragment = new Slide04();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

    private class FadePageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            view.setTranslationX(view.getWidth() * -position);

            if(position <= -1.0F || position >= 1.0F) {
                view.setAlpha(0.0F);
            } else if( position == 0.0F ) {
                view.setAlpha(1.0F);
            } else {
                // position is between -1.0F & 0.0F OR 0.0F & 1.0F
                view.setAlpha(1.0F - Math.abs(position));
            }
        }
    }
}
