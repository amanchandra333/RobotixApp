package in.robotix.robotixapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.robotix.robotixapp.opener.OpenerAdapter;
import in.robotix.robotixapp.opener.OpenerHome;

public class Events extends NavigationDrawer {
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
                R.drawable.polesapart_small,
                R.drawable.fortress_small,
                R.drawable.stax_small,};

        OpenerHome a;
        a = new OpenerHome("The Manual Event: Poles Apart", covers[1]);
        openerList.add(a);
        a = new OpenerHome("The IP Event: Fortress", covers[0]);
        openerList.add(a);
        a = new OpenerHome("The Autonomous Event: STAX", covers[2]);
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
                    case 0:
                        pushnot = new Intent("in.robotix.robotixapp.BOMBDISPOSAL");
                        break;
                    case 1:
                        pushnot = new Intent("in.robotix.robotixapp.CONQUEST");
                        break;
                    default:
                        pushnot = new Intent("in.robotix.robotixapp.BRICKS");
                        break;
                }
                startActivity(pushnot);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }
}
