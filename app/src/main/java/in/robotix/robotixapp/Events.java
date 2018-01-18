package in.robotix.robotixapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            Glide.with(this).load(R.drawable.event_bann).into((ImageView) findViewById(R.id.backdrop1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Events");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);
    }

    private void prepareOpeners() {
        int[] covers = new int[]{
                R.drawable.polesapart_small,
                R.drawable.fortress_small,
                R.drawable.stax_small,};

        OpenerHome a;
        a = new OpenerHome("The Autonomous Event: STAX", covers[2]);
        openerList.add(a);
        a = new OpenerHome("The Manual Event: Poles Apart", covers[0]);
        openerList.add(a);
        a = new OpenerHome("The IP Event: Fortress", covers[1]);
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
                pushnot = new Intent("in.robotix.robotixapp.EVENT");
                switch (position) {
                    case 0:
                        pushnot.putExtra("Title", "Stax");
                        pushnot.putExtra("ID",0 );
                        pushnot.putExtra("Url", "http://www.robotix.in/event/stax/");
                        pushnot.putExtra("PDF", "http://www.robotix.in/assets/event/stax/stax.pdf");
                        break;
                    case 1:
                        pushnot.putExtra("Title", "Poles Apart");
                        pushnot.putExtra("ID", 1);
                        pushnot.putExtra("Url", "http://www.robotix.in/event/poles-apart/");
                        pushnot.putExtra("PDF", "http://www.robotix.in/assets/event/polesapart/polesapart.pdf");
                        break;
                    default:
                        pushnot.putExtra("Title", "Fortress");
                        pushnot.putExtra("ID", 2);
                        pushnot.putExtra("Url", "http://www.robotix.in/event/fortress/");
                        pushnot.putExtra("PDF", "http://www.robotix.in/assets/event/fortress/fortress.pdf");
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

}
