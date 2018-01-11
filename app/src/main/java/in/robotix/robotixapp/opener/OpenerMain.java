package in.robotix.robotixapp.opener;

/**
 * Created by root on 16/5/17.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
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
import android.util.TypedValue;
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
            Glide.with(this).load(R.drawable.backdrop1).into((ImageView) findViewById(R.id.backdrop1));
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
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,};

        OpenerHome a = new OpenerHome("Notice Board", covers[0]);
        openerList.add(a);
        a = new OpenerHome("Events", covers[1]);
        openerList.add(a);
        a = new OpenerHome("Campus Map", covers[2]);
        openerList.add(a);
        a = new OpenerHome("About us", covers[3]);
        openerList.add(a);
        a = new OpenerHome("Contact Us", covers[4]);
        openerList.add(a);
        a = new OpenerHome("FAQ", covers[5]);
        openerList.add(a);
        a = new OpenerHome("Tutorials", covers[0]);
        openerList.add(a);
        a = new OpenerHome("Random", covers[0]);
        openerList.add(a);

        adapter.setListContent(openerList);
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Intent pushnot;
                if(position==0)
                    pushnot = new Intent("in.robotix.robotixapp.NOTICEBOARD");
                else if(position==1)
                    pushnot = new Intent("in.robotix.robotixapp.EVENTS");
                else if(position==2)
                    pushnot = new Intent("in.robotix.robotixapp.MAPS");
                else if(position==3)
                    pushnot = new Intent("in.robotix.robotixapp.ABOUTUS");
                else if(position==4)
                    pushnot = new Intent("in.robotix.robotixapp.CONTACTUS");
                else if(position==5)
                    pushnot = new Intent("in.robotix.robotixapp.FAQS");
                else
                    pushnot = new Intent("in.robotix.robotixapp.TUTS");

                startActivity(pushnot);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(OpenerMain.this, "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
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