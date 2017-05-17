package in.robotix.robotixapp.opener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

import in.robotix.robotixapp.R;

/**
 * Created by root on 16/5/17.
 */

public class OpenerAdapter extends RecyclerView.Adapter<OpenerAdapter.MyViewHolder> {
    private Context mContext;
    private List<OpenerHome> openerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title1);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail1);
        }
    }


    public OpenerAdapter(Context mContext, List<OpenerHome> openerList) {
        this.mContext = mContext;
        this.openerList = openerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.opener_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        OpenerHome opener = openerList.get(position);
        holder.title.setText(opener.getName());

        Glide.with(mContext).load(opener.getThumbnail()).into(holder.thumbnail);

    }


    @Override
    public int getItemCount() {
        return openerList.size();
    }
}
