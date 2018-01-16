package in.robotix.robotixapp;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout mDrawer;
    protected LinearLayout mContentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_navigation_drawer);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mtoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        mContentMain = (LinearLayout) findViewById(R.id.content_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent pushnot = new Intent("in.robotix.robotixapp.HOME");
            startActivity(pushnot);
            finish();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent pushnot = new Intent("in.robotix.robotixapp.HOME");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.noti) {
            Intent pushnot = new Intent("in.robotix.robotixapp.NOTICEBOARD");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.evnts) {
            Intent pushnot = new Intent("in.robotix.robotixapp.EVENTS");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.abtus) {
            Intent pushnot = new Intent("in.robotix.robotixapp.ABOUTUS");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.faq) {
            Intent pushnot = new Intent("in.robotix.robotixapp.FAQS");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.mapp) {
            Intent pushnot = new Intent("in.robotix.robotixapp.MAPS");
            startActivity(pushnot);
            finish();
        } else if (id == R.id.cntct) {
            Intent pushnot = new Intent("in.robotix.robotixapp.CONTACTUS");
            startActivity(pushnot);
            finish();
        }else if (id == R.id.fb) {
            Intent updates = new Intent();
            updates.setAction(Intent.ACTION_VIEW);
            updates.addCategory(Intent.CATEGORY_BROWSABLE);
            updates.setData(Uri.parse("https://www.facebook.com/robotixiitkgp"));
            startActivity(updates);
        }else if (id == R.id.web) {
            Intent website= new Intent();
            website.setAction(Intent.ACTION_VIEW);
            website.addCategory(Intent.CATEGORY_BROWSABLE);
            website.setData(Uri.parse("http://robotix.in/"));
            startActivity(website);
        } else if (id == R.id.youtube) {
            Intent updates = new Intent();
            updates.setAction(Intent.ACTION_VIEW);
            updates.addCategory(Intent.CATEGORY_BROWSABLE);
            updates.setData(Uri.parse("http://www.youtube.com/robotixiitkgp"));
            startActivity(updates);
        }else if (id == R.id.blog) {
            Intent updates = new Intent();
            updates.setAction(Intent.ACTION_VIEW);
            updates.addCategory(Intent.CATEGORY_BROWSABLE);
            updates.setData(Uri.parse("http://blog.robotix.in/"));
            startActivity(updates);
        }else if (id == R.id.twitter) {
            Intent updates = new Intent();
            updates.setAction(Intent.ACTION_VIEW);
            updates.addCategory(Intent.CATEGORY_BROWSABLE);
            updates.setData(Uri.parse("https://twitter.com/robotixiitkgp"));
            startActivity(updates);
        }else if (id == R.id.wiki) {
            Intent updates = new Intent();
            updates.setAction(Intent.ACTION_VIEW);
            updates.addCategory(Intent.CATEGORY_BROWSABLE);
            updates.setData(Uri.parse("https://en.wikipedia.org/wiki/Robotix"));
            startActivity(updates);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
