package tw.com.blazelisa.myprojectbenquo.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tw.com.blazelisa.myprojectbenquo.R;
import tw.com.blazelisa.myprojectbenquo.bean.Glid;
import tw.com.blazelisa.myprojectbenquo.config.Config;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{
    List<Glid> list = new ArrayList<>();
    Activity activity;//like Context

    public RecycleAdapter(List<Glid> list, Context context) {
        this.list = list;
        this.activity = (Activity) context;//this.context = context
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        頁面關聯
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        元件內容傳送
        holder.items_title.setText(list.get(position).getTitle());
        String path = Config._URL+"images/"+list.get(position).getId()+".png";
        Glide.with(activity).load(path).into(holder.items_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView items_image;
        TextView items_title;
        public MyViewHolder(View itemView) {
            super(itemView);
        items_image = itemView.findViewById(R.id.items_image);
        items_title = itemView.findViewById(R.id.items_title);

        }
    }
}
