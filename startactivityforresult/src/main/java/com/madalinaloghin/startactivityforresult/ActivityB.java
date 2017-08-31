package com.madalinaloghin.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityB extends AppCompatActivity {

    EditText etMessage;
    Button btnOpenActivityA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        etMessage = (EditText) findViewById(R.id.et_message_from_b);
        btnOpenActivityA = (Button) findViewById(R.id.btn_for_a);

        btnOpenActivityA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", message);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
