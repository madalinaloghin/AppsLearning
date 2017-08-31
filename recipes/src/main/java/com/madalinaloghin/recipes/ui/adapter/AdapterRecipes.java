package com.madalinaloghin.recipes.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.madalinaloghin.recipes.R;
import com.madalinaloghin.recipes.util.object.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 4/1/2017.
 */

public class AdapterRecipes extends RecyclerView.Adapter<AdapterRecipes.ViewHolder> {

    private List<Recipe> mData;

    private OnItemClickedListener listener;


    public AdapterRecipes(OnItemClickedListener mListener) {
        listener = mListener;
    }

    public void setItems(@NonNull final List<Recipe> data) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);

        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_recipe_image)
        ImageView ivPicture;

        @BindView(R.id.tv_recipe_title)
        TextView tvTitle;

        @BindView(R.id.tv_recipe_from)
        TextView tvFrom;

        private OnItemClickedListener listener;

        public ViewHolder(View itemView, OnItemClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
        }

        public void bind(@NonNull final Recipe recipe) {
            Glide.with(itemView.getContext()).load(recipe.getImageUrl()).into(ivPicture);
            tvTitle.setText(recipe.getName());
            tvFrom.setText(recipe.getFrom());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(recipe);
                }
            });
        }

    }

    public interface OnItemClickedListener {
        void onItemClick(Recipe recipe);
    }

}
