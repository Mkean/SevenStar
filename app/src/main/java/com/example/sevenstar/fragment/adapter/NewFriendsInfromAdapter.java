package com.example.sevenstar.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.sevenstar.R;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;

import java.util.List;

/**
 * Created by j on 18.2.26.
 */

public class NewFriendsInfromAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<NewFriendInformBean.ResultBean> result;

    private Context context;

    public NewFriendsInfromAdapter(List<NewFriendInformBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_friends_inform, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     MyViewHolder MyViewHolder = (NewFriendsInfromAdapter.MyViewHolder) holder;
        MyViewHolder.consent.setText(result.get(position).getNotice());
        MyViewHolder.message.setText(result.get(position).getContent());
        MyViewHolder.name.setText(result.get(position).getCreateTime()+"");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name ,message;
        private final ImageView touxiang;
        private final Button consent;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nike_name);
            message = itemView.findViewById(R.id.message);
            touxiang = itemView.findViewById(R.id.head_portrait);
            consent = itemView.findViewById(R.id.consent);

        }
    }


}
