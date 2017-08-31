package com.madalinaloghin.contactlistrv;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madalina.loghin on 8/30/2017.
 */

public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.ContactsViewHolder> {

    private List<Contact> mDataContacts;

    private final OnItemClickListener mActivityListener;

    private final OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(Contact contact) {
            mActivityListener.onItemClick(contact);
            contact.setSelected(!contact.isSelected());
            notifyItemChanged(mDataContacts.indexOf(contact));
        }
    };

    public ArrayList<Contact> getSelectedContacts() {
        ArrayList<Contact> list = new ArrayList<>();
        for (Contact c : mDataContacts) {
            if (c.isSelected()) {
                list.add(c);
            }
        }
        return list;
    }


    public AdapterContacts(@Nullable final List<Contact> data, OnItemClickListener mActivityListener) {
        if (data != null) {
            if (mDataContacts == null) {
                mDataContacts = new ArrayList<>();
            } else {
                mDataContacts.clear();
            }
            mDataContacts.addAll(data);
        }
        this.mActivityListener = mActivityListener;
    }


    @Override
    public AdapterContacts.ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactsViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(AdapterContacts.ContactsViewHolder holder, int position) {
        holder.bind(mDataContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataContacts == null ? 0 : mDataContacts.size();
    }


    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContactName, mTvContactPhone, mTvContactEmail;
        private ImageView mIvContactImage;
        private CardView mCvContact;
        private OnItemClickListener mListener;


        public ContactsViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTvContactEmail = itemView.findViewById(R.id.tv_contact_email);
            mTvContactName = itemView.findViewById(R.id.tv_contact_name);
            mTvContactPhone = itemView.findViewById(R.id.tv_contact_phone);
            mIvContactImage = itemView.findViewById(R.id.iv_contact_image);

            mCvContact = itemView.findViewById(R.id.cv_contact_card);

            mListener = listener;
        }

        public void bind(final Contact contact) {
            mTvContactName.setText(contact.getmName());
            mTvContactPhone.setText(contact.getmPhone());
            mTvContactEmail.setText(contact.getmEmail());
            mIvContactImage.setImageResource(contact.getmImage());

            if (contact.isSelected()) {
                mCvContact.setCardBackgroundColor(mCvContact.getContext().getResources().getColor(R.color.oceanbue));
            } else {
                mCvContact.setCardBackgroundColor(mCvContact.getContext().getResources().getColor(R.color.white));
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(contact);

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

}
