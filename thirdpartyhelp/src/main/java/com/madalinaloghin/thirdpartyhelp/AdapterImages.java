package com.madalinaloghin.thirdpartyhelp;

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

import butterknife.BindView;

/**
 * Created by madalina.loghin on 7/19/2017.
 */

public class AdapterImages extends RecyclerView.Adapter<AdapterImages.ViewHolder> {

    private List<Images> mData;

    public AdapterImages() {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_text, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    public void setItems(@NonNull final List<Images> data) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image)
        ImageView ivImage;

        @BindView(R.id.tv_text_below_image)
        TextView tvTextImage;


        public ViewHolder(View itemView) {
            super(itemView);
        }


        public void bind(@NonNull final Images images) {

            Glide.with(itemView.getContext()).load(images.getImageUrl()).into(ivImage);
            tvTextImage.setText(images.getmName());
        }
    }
}
