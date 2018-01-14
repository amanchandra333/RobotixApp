package in.robotix.robotixapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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

import org.xmlpull.v1.XmlPullParserException;

import in.robotix.robotixapp.XMLParser.Entry;

/**
 * Created by amanchandra333 on 23/12/17.
 */

public class Tutorials extends ListActivity {
    private static final String URL =
            "https://2018.robotix.in/sitemap.xml";
    Context _mcontext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        new DownloadXmlTask().execute(URL);

    }

    private class DownloadXmlTask extends AsyncTask<String, Void, ListAdapter> {

        @Override
        protected ListAdapter doInBackground(String... urls) {
            ArrayList<HashMap<String, String>> dummy_menu = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> dummy_map = new HashMap<String, String>();
            dummy_map.put("Title", "random");
            dummy_menu.add(dummy_map);
            ListAdapter dummy;
            if(_mcontext!=null) {
                dummy = new SimpleAdapter(_mcontext, dummy_menu,
                        R.layout.tut_row,
                        new String[]{"Title"}, new int[]{
                        R.id.tut_title});
            }
            else
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
        protected void onPostExecute(ListAdapter result) {
            setContentView(R.layout.activity_notice_board);
            setListAdapter(result);
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // getting values from selected ListItem
                    String name = ((TextView) view.findViewById(R.id.tut_title)).getText().toString();
                    String link = ((TextView) view.findViewById(R.id.tut_link)).getText().toString();

                    // Starting new intent
                    Intent in = new Intent(getApplicationContext(), WebviewActivity.class);
                    in.putExtra("Title", name);
                    in.putExtra("Link", link);
                    startActivity(in);

                }
            });
        }
    }

    private ListAdapter loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
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

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
        for (Entry entry : entries) {
            HashMap<String, String>     map = new HashMap<String, String>();
            String[] separated = entry.title.split("/");
            if(separated[separated.length -3].equals("tutorial")) {
                map.put("Title", separated[separated.length - 2]);
                map.put("Link", entry.title);
                menuItems.add(map);
            }
        }

        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.tut_row,
                new String[] { "Title", "Link" }, new int[] {
                R.id.tut_title, R.id.tut_link });

        return adapter;
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
}
