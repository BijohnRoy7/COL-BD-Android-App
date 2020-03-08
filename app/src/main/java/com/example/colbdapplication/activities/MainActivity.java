package com.example.colbdapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.colbdapplication.R;
import com.example.colbdapplication.fragments.CollectedFragment;
import com.example.colbdapplication.fragments.CollectionListFragment;
import com.example.colbdapplication.fragments.ComplainListFragment;
import com.example.colbdapplication.fragments.CustomerListFragment;
import com.example.colbdapplication.fragments.HomeFragment;
import com.example.colbdapplication.fragments.ScheduleFragment;
import com.example.colbdapplication.fragments.ScheduledListFragment;
import com.example.colbdapplication.fragments.SyncFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();

    }

    private void initToolBar() {

        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        showFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.nav_home){
            showFragment(new HomeFragment());
        }

        if (id == R.id.nav_sync){
            showFragment(new SyncFragment());
        }

        if (id == R.id.nav_customer_list){
            showFragment(new CustomerListFragment());
        }

        if (id == R.id.nav_scheduled_list){
            showFragment(new ScheduledListFragment());
        }

        if (id == R.id.nav_complain_list){
            showFragment(new ComplainListFragment());
        }

        if (id == R.id.nav_collection_list){
            showFragment(new CollectionListFragment());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
