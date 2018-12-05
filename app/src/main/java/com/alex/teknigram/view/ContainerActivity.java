package com.alex.teknigram.view;

import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alex.teknigram.R;
import com.alex.teknigram.view.fragment.HomeFragment;
import com.alex.teknigram.view.fragment.ProfileFragment;
import com.alex.teknigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottombarnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId){
                    case R.id.home:
                        addFragment(new HomeFragment());
                        break;
                    case R.id.profile:
                        addFragment(new ProfileFragment());
                        break;
                    case R.id.search:
                        addFragment(new SearchFragment());
                        break;
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);

    }//onCreate

    private void addFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
