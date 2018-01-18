package in.robotix.robotixapp;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean menu = false;
    LatLng myPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View contentView = inflater.inflate(R.layout.activity_maps, null, false);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        mContentMain.addView(contentView, params);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_maps);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btn_poi = (Button)findViewById(R.id.btn_poi);
        btn_poi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                if (menu) {
                    ScrollView one = (ScrollView) findViewById(R.id.menu);
                    one.setVisibility(View.GONE);
                    menu = false;
                }
                else
                {
                    ScrollView one = (ScrollView) findViewById(R.id.menu);
                    one.setVisibility(View.VISIBLE);
                    menu = true;
                }
            }
        });

        TextView lbl_rbtx = (TextView)findViewById(R.id.lbl_rbtx);
        lbl_rbtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.315984, 87.310801);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_tikka = (TextView)findViewById(R.id.lbl_tikka);
        lbl_tikka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.316859, 87.307277);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_sahara = (TextView)findViewById(R.id.lbl_sahara);
        lbl_sahara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.314188, 87.305850);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_dreamland = (TextView)findViewById(R.id.lbl_dreamland);
        lbl_dreamland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.313831, 87.305646);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_ccd = (TextView)findViewById(R.id.lbl_ccd);
        lbl_ccd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319369, 87.305839);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_ifx = (TextView)findViewById(R.id.lbl_ifx);
        lbl_ifx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319657, 87.303962);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_axisatm = (TextView)findViewById(R.id.lbl_axisatm);
        lbl_axisatm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319012, 87.302438);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_sbiatm = (TextView)findViewById(R.id.lbl_sbiatm);
        lbl_sbiatm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.3221895,87.3099734);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_sbi = (TextView)findViewById(R.id.lbl_sbi);
        lbl_sbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321989, 87.310560);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_lbs = (TextView)findViewById(R.id.lbl_lbs);
        lbl_lbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.320899, 87.300051);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_nehru = (TextView)findViewById(R.id.lbl_nehru);
        lbl_nehru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319391, 87.298935);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_llr = (TextView)findViewById(R.id.lbl_llr);
        lbl_llr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321213, 87.303171);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_rk = (TextView)findViewById(R.id.lbl_rk);
        lbl_rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321030, 87.306519);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_rp = (TextView)findViewById(R.id.lbl_rp);
        lbl_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321059, 87.307903);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_mmm = (TextView)findViewById(R.id.lbl_mmm);
        lbl_mmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321019, 87.301868);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_vs = (TextView)findViewById(R.id.lbl_vs);
        lbl_vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319406, 87.304749);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });


        TextView lbl_patel = (TextView)findViewById(R.id.lbl_patel);
        lbl_patel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319577, 87.299824);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_ajad = (TextView)findViewById(R.id.lbl_ajad);
        lbl_ajad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.318936, 87.298727);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_jcb = (TextView)findViewById(R.id.lbl_jcb);
        lbl_jcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.320582, 87.302254);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_hjb = (TextView)findViewById(R.id.lbl_hjb);
        lbl_hjb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319057, 87.302217);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_mt = (TextView)findViewById(R.id.lbl_mt);
        lbl_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319375, 87.307431);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_sn = (TextView)findViewById(R.id.lbl_sn);
        lbl_sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.317611, 87.307305);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_ms = (TextView)findViewById(R.id.lbl_ms);
        lbl_ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.321802, 87.304720);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_bcr = (TextView)findViewById(R.id.lbl_bcr);
        lbl_bcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.317259, 87.300290);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_mainb = (TextView)findViewById(R.id.lbl_mainb);
        lbl_mainb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.319622, 87.309739);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_techm = (TextView)findViewById(R.id.lbl_techm);
        lbl_techm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.314882, 87.300676);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

        TextView lbl_bra = (TextView)findViewById(R.id.lbl_bra);
        lbl_bra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                LatLng latLng = new LatLng(22.316910, 87.296190);
                CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
                mMap.animateCamera(yourLocation);
                ScrollView one = (ScrollView) findViewById(R.id.menu);
                one.setVisibility(View.GONE);
                menu = false;

            }
        });

    }

    private void setUpMap() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) mMap.setMyLocationEnabled(true);
        else return;

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);

        if(location!=null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);
            myPosition = new LatLng(latitude, longitude);
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 17);
            mMap.animateCamera(yourLocation);
        }
        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.320899, 87.300051"))
                .title("LBS Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319391, 87.298935"))
                .title("Nehru Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321213, 87.303171"))
                .title("LLR Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321030, 87.306519"))
                .title("RK Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321059, 87.307903"))
                .title("RP Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321019, 87.301868"))
                .title("MMM Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319839, 87.307930"))
                .title("BC Roy Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319586, 87.306256"))
                .title("Gokhale Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.320389, 87.304813"))
                .title("Vidyasagar Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319583, 87.306292"))
                .title("AM Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319577, 87.299824"))
                .title("Patel Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.318936, 87.298727"))
                .title("Azad Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.317654, 87.296340"))
                .title("Zakir Hussain Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.316910, 87.296190"))
                .title("BR Ambedkar Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319133, 87.302930"))
                .title("JC Bose Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321008, 87.304098"))
                .title("MS Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319546, 87.306055"))
                .title("Rani Laxmibai Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319653, 87.302131"))
                .title("HJB Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319375, 87.307431"))
                .title("MT Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.317611, 87.307305"))
                .title("SN Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.316859, 87.307277"))
                .title("Tikka")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.314188, 87.305850"))
                .title("Sahara Restaurant")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.313831, 87.305646"))
                .title("Dreamland Restaurant")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319369, 87.305839"))
                .title("Cafe Coffee Day")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319657, 87.303962"))
                .title("Iosys Food Xcess")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319012, 87.302438"))
                .title("Axis Bank ATM")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.atm)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.314684, 87.300636"))
                .title("SBI ATM")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.atm)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.321989, 87.310560"))
                .title("State Bank of India")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.atm)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.315984, 87.310801"))
                .title("Robotix Arena")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.arena)));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.314882, 87.300676"))
                .title("Tech Market"));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.317259, 87.300290"))
                .title("BC Hoy Hospital"));

        mMap.addMarker(new MarkerOptions()
                .position(getLatLng("22.319622, 87.309739"))
                .title("Main Building"));

        // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    public LatLng getLatLng(String place){

        return new LatLng(Float.valueOf(place.split(",")[0]),Float.valueOf(place.split(",")[1]));
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in RBTX arena and move the camera
        LatLng latLng = new LatLng(22.314882, 87.300676);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        mMap.animateCamera(yourLocation);
//        LatLng rbtx = new LatLng(22.315984, 87.310801);
//        mMap.addMarker(new MarkerOptions().position(rbtx).title("Marker in Robotix Arena"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(rbtx));
        setUpMap();
    }

    @Override
    public void onBackPressed() {
        Intent pushnot = new Intent("in.robotix.robotixapp.HOME");
        startActivity(pushnot);
        finish();
    }
}
