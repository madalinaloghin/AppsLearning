package com.madalinaloghin.contactlistrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectedContactsActivity extends AppCompatActivity {


    Bundle bundle;
    List<Contact> selectedContacts;
    TextView tvSelectedContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_contacts);
        selectedContacts = new ArrayList<>();

        bundle = getIntent().getExtras();
        selectedContacts = (List<Contact>) bundle.getSerializable("name");

        tvSelectedContacts = (TextView) findViewById(R.id.tv_selectedContacts);
        tvSelectedContacts.setText("");
        for (Contact c : selectedContacts) {
            tvSelectedContacts.append(c.getmName() + "\n");
        }

    }
}
