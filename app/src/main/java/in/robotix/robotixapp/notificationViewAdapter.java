package in.robotix.robotixapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by lenovo on 1/11/2016.
 */
public class notificationViewAdapter extends BaseAdapter {

    Context context;
    String[] title;
    String[] details;
    String[] time;

    private static LayoutInflater inflater = null;

    public notificationViewAdapter(Context context, String[] title, String[] details, String[] time) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.title = title;
        this.details = details;
        this.time = time;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_row, null);
        TextView n_title = (TextView) vi.findViewById(R.id.n_title);
        TextView n_details = (TextView) vi.findViewById(R.id.n_details);
        TextView n_time = (TextView) vi.findViewById(R.id.n_time);
        n_title.setText(title[position]);
        n_details.setText(details[position]);
        n_time.setText(time[position]);
        return vi;
    }

}
