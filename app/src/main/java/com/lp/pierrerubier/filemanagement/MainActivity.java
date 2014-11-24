package com.lp.pierrerubier.filemanagement;

import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lp.pierrerubier.filemanagement.Adapters.DrawerItemCustomAdapter;
import com.lp.pierrerubier.filemanagement.Fragments.MediaFragment;
import com.lp.pierrerubier.filemanagement.Items.ObjectDrawerItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    ArrayList<ObjectDrawerItem> drawerItem;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();

        drawerItem = new ArrayList<ObjectDrawerItem>();
        drawerItem.add(new ObjectDrawerItem(R.drawable.ic_action_photo, getResources().getString(R.string.images)));
        drawerItem.add(new ObjectDrawerItem(R.drawable.ic_action_edit, getResources().getString(R.string.texts)));
        drawerItem.add(new ObjectDrawerItem(R.drawable.ic_action_video, getResources().getString(R.string.videos)));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //to allow click on icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerTitle = getResources().getText(R.string.drawer_open);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        DrawerItemCustomAdapter menuAdapter = new DrawerItemCustomAdapter(getApplicationContext(), drawerItem);
        mDrawerList.setAdapter(menuAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment = null;

                switch (i) {
                    case 0:
                        fragment = new MediaFragment();
                        ((MediaFragment)fragment).setHelloParameters(drawerItem.get(0).name,
                                drawerItem.get(0).icon);
                        break;
                    case 1:
                        fragment = new MediaFragment();
                        ((MediaFragment)fragment).setHelloParameters(drawerItem.get(1).name,
                                drawerItem.get(1).icon);
                        break;
                    case 2:
                        fragment = new MediaFragment();
                        ((MediaFragment)fragment).setHelloParameters(drawerItem.get(2).name,
                                drawerItem.get(2).icon);
                        break;
                    default:
                        break;

                }

                if(fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
                    ft.replace(R.id.content_frame, fragment).commit();
                    mDrawerList.setItemChecked(i, true);
                    mDrawerList.setSelection(i);
                    mTitle = drawerItem.get(i).name;
                    getSupportActionBar().setTitle(mTitle);
                    mDrawerLayout.closeDrawers();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            getActionBar().setTitle(getResources().getString(R.string.drawer_close));
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
