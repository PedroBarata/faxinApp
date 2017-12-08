package com.example.pedrobarata.faxinapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pedrobarata.faxinapp.model.DataModel;
import com.example.pedrobarata.faxinapp.adapter.DrawerItemCustomAdapter;
import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.fragment.CadastroComodoFragment;
import com.example.pedrobarata.faxinapp.fragment.CadastroUsuarioFragment;
import com.example.pedrobarata.faxinapp.fragment.ContaFragment;
import com.example.pedrobarata.faxinapp.fragment.SemanaFragment;
import com.example.pedrobarata.faxinapp.fragment.VisaoGeralFragment;

public class HomeActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        fragmentManager = getSupportFragmentManager();

        setupToolbar();
        DataModel[] drawerItem = new DataModel[6];

        fragmentManager.beginTransaction().replace(R.id.frame_principal, new SemanaFragment()).commit();

        drawerItem[0] = new DataModel(R.drawable.ic_event_note_black_24dp, "Semana");
        drawerItem[1] = new DataModel(R.drawable.ic_trending_up_black_24dp, "Visão Geral");
        drawerItem[2] = new DataModel(R.drawable.ic_settings_black_24dp, "Conta");
        drawerItem[3] = new DataModel(R.drawable.ic_settings_black_24dp, "Cadastrar Cômodos");
        drawerItem[4] = new DataModel(R.drawable.ic_settings_black_24dp, "Cadastrar Usuários");
        drawerItem[5] = new DataModel(R.drawable.ic_exit_to_app_black_24dp, "Sair");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {

            case 0:
               fragment = new SemanaFragment();
                break;

            case 1:
                fragment = new VisaoGeralFragment();
                break;

            case 2:
                fragment = new ContaFragment();
                break;

            case 3:
                fragment = new CadastroComodoFragment();
                break;

            case 4:
                fragment = new CadastroUsuarioFragment();
                break;

            case 5:
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }

        if (fragment != null) {

            fragmentManager.beginTransaction().replace(R.id.frame_principal, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
}
