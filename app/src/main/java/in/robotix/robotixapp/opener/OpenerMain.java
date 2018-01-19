package in.robotix.robotixapp.opener;

/**
 * Created by root on 16/5/17.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import in.robotix.robotixapp.NavigationDrawer;
import in.robotix.robotixapp.R;
import in.robotix.robotixapp.RecyclerTouchListener;


public class OpenerMain extends NavigationDrawer {

    RecyclerView recyclerView;
    OpenerAdapter adapter;
    private ArrayList<OpenerHome> openerList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.opener_content, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentMain.addView(contentView, params);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
        adapter = new OpenerAdapter(this);

        initCollapsingToolbar();
        prepareOpeners();

        try {
            Glide.with(this).load(R.drawable.backdrop_home).into((ImageView) findViewById(R.id.backdrop1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    private void prepareOpeners() {
        int[] covers = new int[]{
                R.drawable.noticeboard_b,
                R.drawable.events_b,
                R.drawable.map_b,
                R.drawable.aboutus_b,
                R.drawable.contactus_b,
                R.drawable.faq_b,
                R.drawable.event_bann,
                R.drawable.faq_backdrop,};

        OpenerHome a;
        a = new OpenerHome("Notice Board", covers[0]);
        openerList.add(a);
        a = new OpenerHome("Explore Our Events", covers[1]);
        openerList.add(a);
        a = new OpenerHome("Registrations for Robotix 2018", covers[6]);
        openerList.add(a);
        a = new OpenerHome("Frequently Asked Questions", covers[7]);
        openerList.add(a);
        a = new OpenerHome("Campus Map", covers[2]);
        openerList.add(a);
        a = new OpenerHome("Our Collection of Tutorials", covers[5]);
        openerList.add(a);
        a = new OpenerHome("Know More About Us", covers[3]);
        openerList.add(a);
        a = new OpenerHome("Contact Us", covers[4]);
        openerList.add(a);


        adapter.setListContent(openerList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Intent pushnot;
                switch (position) {
                    case 1:
                        pushnot = new Intent("in.robotix.robotixapp.EVENTS");
                        break;
                    case 2:
                        pushnot = new Intent("in.robotix.robotixapp.WEBVIEW");
                        pushnot.putExtra("Title", "Blog");
                        pushnot.putExtra("Link", "https://2018.robotix.in/blog/registration-for-robotix-2018/");
                        break;
                    case 3:
                        pushnot = new Intent("in.robotix.robotixapp.FAQS");
                        break;
                    case 6:
                        pushnot = new Intent("in.robotix.robotixapp.ABOUTUS");
                        break;
                    case 7:
                        pushnot = new Intent("in.robotix.robotixapp.CONTACTUS");
                        break;
                    case 5:
                        pushnot = new Intent("in.robotix.robotixapp.WEBVIEW");
                        pushnot.putExtra("Title", "Tutorials");
                        pushnot.putExtra("Link", "https://2018.robotix.in/tutorial/");
                        break;
                    case 4:
                        pushnot = new Intent("in.robotix.robotixapp.MAPS");
                        break;
                    default:
                        pushnot = new Intent("in.robotix.robotixapp.NOTICEBOARD");
                        break;
                }

                startActivity(pushnot);
                finish();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}