package com.madalinaloghin.scrollandrecycler.recycler_view;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.madalinaloghin.scrollandrecycler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madalina.loghin on 7/17/2017.
 */

public class AdapterCats extends RecyclerView.Adapter<AdapterCats.CatsViewHolder> {

    private List<Cat> mData;


    public AdapterCats(@Nullable final List<Cat> data) {
        if (data != null) {
            if (mData == null) {
                mData = new ArrayList<>();
            } else {
                mData.clear();
            }
            mData.addAll(data);
        }
    }

    @Override
    public AdapterCats.CatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);
        return new CatsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterCats.CatsViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public static class CatsViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName;
        private ImageView mIvCatImage;


        public CatsViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_cat_name);
            mIvCatImage = (ImageView) itemView.findViewById(R.id.iv_cat_item);
        }

        public void bind(Cat cat) {
            mTvName.setText(cat.getName());
            mIvCatImage.setImageResource(cat.getImg());
        }
    }


}
