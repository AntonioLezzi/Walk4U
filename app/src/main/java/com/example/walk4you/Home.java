package com.example.walk4you;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class Home extends FragmentActivity implements OnFragmentInteractionListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private SocialFragment fragmentSocial;
    private HomeFragment fragmentHome;
    private MapsFragment fragmentMaps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        fragmentSocial = new SocialFragment();
        fragmentHome = new HomeFragment();
        fragmentMaps = new MapsFragment();

        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
        mMainNav.setSelectedItemId(R.id.Nav_Home);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, fragmentHome).commit();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {

                switch (Item.getItemId()) {

                    case R.id.Nav_Social:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragmentSocial).commit();
                        return true;

                    case R.id.Nav_Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragmentHome).commit();
                        return true;

                    case R.id.Nav_Maps:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragmentMaps).commit();
                        return true;

                    default:
                        return false;

                }
            }

        });

    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }



}
