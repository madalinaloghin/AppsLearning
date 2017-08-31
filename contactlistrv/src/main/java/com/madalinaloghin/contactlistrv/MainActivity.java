package com.madalinaloghin.contactlistrv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvContacts;
    private FloatingActionButton fabListContacts;
    private AdapterContacts adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = (RecyclerView) findViewById(R.id.rv_contact_list);
        fabListContacts = (FloatingActionButton) findViewById(R.id.fab_action_button);
        fabListContacts.hide();
        setupRecycleView();


        fabListContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectedContactsActivity.class);
                Bundle b = new Bundle();
                ArrayList<Contact> contactSelectedList = adapter.getSelectedContacts();

                b.putSerializable("name", contactSelectedList);

                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }


    private void setupRecycleView() {
        rvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Contact> data = getDummyData();

        adapter = new AdapterContacts(data, new AdapterContacts.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                fabListContacts.show();
            }
        });
        rvContacts.setAdapter(adapter);
    }


    private List<Contact> getDummyData() {
        List<Contact> mListContact = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            mListContact.add(new Contact("Name Surname #" + i, "Phone #" + i, "emailadress#" + i + ".@gmail.com", R.drawable.ic_send_black));
        }

        return mListContact;
    }
}
