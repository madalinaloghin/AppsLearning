package com.madalinaloghin.masterwidgets.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.madalinaloghin.masterwidgets.R;

import java.util.List;

/**
 * Created by dorunechifor.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactVH> {
    
    private List<Contact> mDataSet;
    
    public ContactsAdapter(@NonNull List<Contact> dataSet) {
        mDataSet = dataSet;
    }
    
    // Create new views (invoked by the layout manager)
    @Override
    public ContactVH onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ContactVH(itemView);
    }
    
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ContactVH holder, int position) {
        holder.bind(mDataSet.get(position));
    }
    
    // Return the size of the dataSet (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
    
    // Provide a reference to the views for each data item
    static class ContactVH extends RecyclerView.ViewHolder {
        TextView tvPrefix, tvName, tvPhone, tvEmail;
        
        ContactVH(View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.tv_item_contact_prefix);
            tvName =  itemView.findViewById(R.id.tv_item_contact_name);
            tvPhone =  itemView.findViewById(R.id.tv_item_contact_phone);
            tvEmail =  itemView.findViewById(R.id.tv_item_contact_email);
        }
        
        void bind(@NonNull Contact contact) {
            tvPrefix.setText(String.valueOf(contact.getName().charAt(0))); // This needs to be String, because a char will value will throw an Exception
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhone());
            tvEmail.setText(contact.getEmail());
        }
    }
    
}
