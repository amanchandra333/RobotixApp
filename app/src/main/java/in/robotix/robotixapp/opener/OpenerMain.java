package in.robotix.robotixapp.opener;

/**
 * Created by root on 16/5/17.
 */

import android.content.res.Resources;
import android.graphics.Rect;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.robotix.robotixapp.R;


public class OpenerMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OpenerAdapter adapter;
    private List<OpenerHome> openerList;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opener_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        openerList = new ArrayList<>();
        adapter = new OpenerAdapter(this, openerList);




    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(toolbar);

        initCollapsingToolbar();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareOpeners();

        try {
            Glide.with(this).load(R.drawable.rbtxlogo).into((ImageView) findViewById(R.id.backdrop1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar1);
        collapsingToolbar.setTitle(" fgthrfh");
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar1);
//        appBarLayout.setExpanded(true);
//
//        // hiding & showing the title when toolbar expanded & collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbar.setTitle(getString(R.string.app_name));
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbar.setTitle(" ");
//                    isShow = false;
//                }
//            }
//        });
    }


    private void prepareOpeners() {
        int[] covers = new int[]{
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,
                R.drawable.rbtxlogo,};

        OpenerHome a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);

        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);

        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);
        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);
        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);
        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);
        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);
        a = new OpenerHome("True Romance", covers[0]);
        openerList.add(a);

        adapter.notifyDataSetChanged();
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
}