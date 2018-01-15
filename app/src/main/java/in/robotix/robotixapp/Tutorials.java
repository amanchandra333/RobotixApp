package in.robotix.robotixapp;

import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParserException;

import in.robotix.robotixapp.XMLParser.Entry;

/**
 * Created by amanchandra333 on 23/12/17.
 */

public class Tutorials extends ExpandableListActivity {
    private static final String URL =
            "https://2018.robotix.in/sitemap.xml";
    Context _mcontext;
    private ExpandableListAdapter mAdapterView;
    android.widget.ExpandableListView expandableListView;
    private Toolbar supportActionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tut);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tut);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_tut);
        collapsingToolbar.setTitle("Tutorials");

        new DownloadXmlTask().execute(URL);

    }

    private class DownloadXmlTask extends AsyncTask<String, Void, ExpandableListAdapter> {

        @Override
        protected ExpandableListAdapter doInBackground(String... urls) {
            List<Map<String, String>> dummy_menu = new ArrayList<Map<String, String>>();
            List<List<Map<String, String>>> dummy_list = new ArrayList<List<Map<String, String>>>();
            HashMap<String, String> dummy_map = new HashMap<String, String>();
            dummy_map.put("Title", "random");
            dummy_menu.add(dummy_map);
            dummy_list.add(dummy_menu);
            ExpandableListAdapter dummy;
            if (_mcontext != null) {
                dummy = new SimpleExpandableListAdapter(_mcontext, dummy_menu,
                        R.layout.tut_row,
                        new String[]{"Title"}, new int[]{
                        R.id.tut_title},
                        dummy_list,
                        R.layout.tut_row,
                        new String[]{"Title"}, new int[]{
                        R.id.tut_title});
            } else
                dummy = null;

            try {
                return loadXmlFromNetwork(urls[0]);
            } catch (IOException e) {
                return dummy;
            } catch (XmlPullParserException e) {
                return dummy;
            }
        }

        @Override
        protected void onPostExecute(ExpandableListAdapter result) {
            setContentView(R.layout.activity_tut);
            setListAdapter(result);
            expandableListView = getExpandableListView();
            expandableListView.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {
                public boolean onChildClick(android.widget.ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    String name = ((TextView) v.findViewById(R.id.tut_title)).getText().toString();
                    String link = ((TextView) v.findViewById(R.id.tut_link)).getText().toString();

                    Intent in = new Intent(getApplicationContext(), WebviewActivity.class);
                    in.putExtra("Title", name);
                    in.putExtra("Link", link);
                    startActivity(in);

                    return false;
                }
            });
        }
    }

    private ExpandableListAdapter loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
        InputStream stream = null;
        XMLParser TutorialParser = new XMLParser();
        List<Entry> entries = null;
        String title = null;

        try {
            stream = downloadUrl(urlString);
            entries = TutorialParser.parse(stream);
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        List<Map<String, String>> groupListItem = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childListItem = new ArrayList<List<Map<String, String>>>();

        Map<String, String> category = new HashMap<String, String>();
        category.put("Category", "Advanced");
        groupListItem.add(category);
        category.put("Category", "Arduino");
        groupListItem.add(category);
        category.put("Category", "Autonomous");
        groupListItem.add(category);
        category.put("Category", "AVR");
        groupListItem.add(category);
        category.put("Category", "Events");
        groupListItem.add(category);
        category.put("Category", "Image Processing");
        groupListItem.add(category);
        category.put("Category", "Mechanical");
        groupListItem.add(category);
        category.put("Category", "Other");
        groupListItem.add(category);
        category.put("Category", "Path Planning");
        groupListItem.add(category);

        for (Entry entry : entries) {
            Map<String, String> tut = new HashMap<String, String>();

            List<Map<String, String>> advanced = new ArrayList<Map<String, String>>();
            List<Map<String, String>> arduino = new ArrayList<Map<String, String>>();
            List<Map<String, String>> auto = new ArrayList<Map<String, String>>();
            List<Map<String, String>> avr = new ArrayList<Map<String, String>>();
            List<Map<String, String>> event = new ArrayList<Map<String, String>>();
            List<Map<String, String>> ip = new ArrayList<Map<String, String>>();
            List<Map<String, String>> mechanical = new ArrayList<Map<String, String>>();
            List<Map<String, String>> other = new ArrayList<Map<String, String>>();
            List<Map<String, String>> path = new ArrayList<Map<String, String>>();

            String[] separated = entry.title.split("/");
            if (separated[separated.length - 3].equals("tutefeorial")) {
                if (separated[separated.length - 2].equals("advanced")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    advanced.add(tut);
                }
                else if (separated[separated.length - 2].equals("arduino")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    arduino.add(tut);
                }
                else if (separated[separated.length - 2].equals("auto")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    auto.add(tut);
                }
                else if (separated[separated.length - 2].equals("avr")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    avr.add(tut);
                }
                else if (separated[separated.length - 2].equals("event")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    event.add(tut);
                }
                else if (separated[separated.length - 2].equals("imageprocessing")) {
                    category.put("Title", separated[separated.length - 1]);
                    category.put("Link", entry.title);
                    ip.add(category);
                }
                else if (separated[separated.length - 2].equals("mechanical")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    mechanical.add(tut);
                }
                else if (separated[separated.length - 2].equals("other")) {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    other.add(tut);
                } else {
                    tut.put("Title", separated[separated.length - 1]);
                    tut.put("Link", entry.title);
                    path.add(tut);
                }

            }

            childListItem.add(advanced);
            childListItem.add(arduino);
            childListItem.add(auto);
            childListItem.add(avr);
            childListItem.add(event);
            childListItem.add(ip);
            childListItem.add(mechanical);
            childListItem.add(other);
            childListItem.add(path);

        }

        mAdapterView = new SimpleExpandableListAdapter(
                this,
                groupListItem,
                R.layout.tut_row,
                new String[]{"Category"},
                new int[]{R.id.tut_title},
                childListItem,
                R.layout.tut_row,
                new String[]{"Title", "Link"},
                new int[]{R.id.tut_title, R.id.tut_link}
        );

        return mAdapterView;
    }

    // Given a string representation of a URL, sets up a connection and gets
    // an input stream.
    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}
