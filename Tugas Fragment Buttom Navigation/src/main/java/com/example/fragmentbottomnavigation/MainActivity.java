package com.example.fragmentbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;  //mendeklarasikan bottom navigation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_home()).commit();

        //memberi action ketika bottom diklik
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //ketika diklik bottom chat maka akan memanggil chat fragment
                Fragment selectedFragment = null;   //membuat objek dari fragment dan memberi nilai awal 0

                switch (item.getItemId()){
                    case R.id.home_menu:
                        selectedFragment = new Fragment_home();
                        break;
                    case R.id.search_menu:
                        selectedFragment = new Fragment_search();
                        break;
                    case R.id.favorite_menu:
                        selectedFragment = new Fragment_favorite();
                        break;
                    case R.id.account_menu:
                        selectedFragment = new Fragment_account();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}