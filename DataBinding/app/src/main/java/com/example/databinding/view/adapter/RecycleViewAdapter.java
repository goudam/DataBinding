package com.example.databinding.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.BR;
import com.example.databinding.R;
import com.example.databinding.databinding.MemberItemBinding;
import com.example.databinding.model.GlobalConfigDto;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    public final ArrayList<GlobalConfigDto> listdata;
    public Context context;
    private Context mContext;


    public RecycleViewAdapter(Context context, ArrayList<GlobalConfigDto> listdata) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MemberItemBinding  binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.member_item, parent, false);
        return new RecycleViewAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final RecycleViewAdapter.ViewHolder holder, final int position) {
        GlobalConfigDto dataModel = listdata.get(position);
        holder.memberItemBinding.setItemname(dataModel);
        holder.bind(dataModel);

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final MemberItemBinding memberItemBinding;


        public ViewHolder(MemberItemBinding memberItemBinding) {
            super(memberItemBinding.getRoot() );
            this.memberItemBinding = memberItemBinding;
      }
        public void bind(Object obj) {
            memberItemBinding.setVariable(BR.itemname, obj);
            memberItemBinding.executePendingBindings();
        }
    }


}
