package com.madalinaloghin.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    public static final int ACTIVITY_B_CODE = 1;
    TextView tvMessage;
    Button btnOpenActivityB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        tvMessage = (TextView) findViewById(R.id.tv_message_from_b);
        btnOpenActivityB = (Button) findViewById(R.id.btn_for_b);

        btnOpenActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityBIntent = new Intent(ActivityA.this, ActivityB.class);
                startActivityForResult(activityBIntent, ACTIVITY_B_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_B_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String message = data.getStringExtra("message");
                if(message.isEmpty()){
                    tvMessage.setText(R.string.null_message);
                } else {
                    tvMessage.setText(message);
                }
            }
        }

    }
}
