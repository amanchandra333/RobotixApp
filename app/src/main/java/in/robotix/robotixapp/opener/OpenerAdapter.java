package in.robotix.robotixapp.opener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.robotix.robotixapp.R;

/**
 * Created by root on 16/5/17.
 */

public class OpenerAdapter extends RecyclerView.Adapter<OpenerAdapter.MyViewHolder> {

    //Creating an arraylist
    private ArrayList<OpenerHome> list_members =new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context mContext;


    public OpenerAdapter(Context mContext) {
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.opener_card, parent, false);
        holder=new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        OpenerHome list_items = list_members.get(position);
        holder.title.setText(list_items.getName());
        Glide.with(mContext).load(list_items.getThumbnail()).into(holder.thumbnail);
    }

    //Setting the arraylist
    public void setListContent(ArrayList<OpenerHome> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());
    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView thumbnail;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.title1);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail1);
        }
        @Override
        public void onClick(View v) {

        }
    }

    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }
}
