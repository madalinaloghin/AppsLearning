package com.madalinaloghin.masterwidgets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ProgrammaticViewsActivity extends AppCompatActivity {
    
    private LinearLayout llContainer;
    private EditText etNewViewLabel;
    private Button btnGenerateNewView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatic_views);
        
        initViews();
        setViewsActions();
        setInitialData();
    }
    
    private void initViews() {
        llContainer = (LinearLayout) findViewById(R.id.ll_programmatic_views);
        etNewViewLabel = (EditText) findViewById(R.id.et_programmatic_views_label);
        btnGenerateNewView = (Button) findViewById(R.id.btn_programmatic_views_generate);
    }
    
    private void setViewsActions() {
        btnGenerateNewView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String viewLabel = getViewLabel();
                addNewView(viewLabel);
            }
        });
    }
    
    private void setInitialData() {
        etNewViewLabel.setText(getString(R.string.sample_text_short));
        etNewViewLabel.setSelection(etNewViewLabel.getText().length());
    }
    
    @NonNull
    private String getViewLabel() {
        String viewLabel = etNewViewLabel.getText().toString();
        
        // if user inserted and empty text (or rather did not insert any text), display a default one.
        if (TextUtils.isEmpty(viewLabel)) {
            viewLabel = getString(R.string.default_view_label);
        }
        return viewLabel;
    }
    
    private void addNewView(@NonNull final String label) {
        final int viewType = generateRandomViewType();
        final View newChildView = createView(viewType, label);
        
        llContainer.addView(newChildView);
    }
    
    // Generates a new View depending on viewType param (accepts these values: 0, 1, 2, 3) and sets viewLabel text on it.
    @NonNull
    private View createView(final int viewType, @NonNull final String viewLabel) {
        TextView view;
        
        switch (viewType) {
            case 0:
                view = createTextView();
                break;
            case 1:
                view = createButton();
                break;
            case 2:
                view = createCheckBox();
                break;
            case 3:
                view = createRadioButton();
                break;
            default:
                throw new IllegalArgumentException("Unknown widget type.");
        }
        
        setLabel(view, viewLabel);
        setTextColorTo(view);
        applyLayoutParamsTo(view);
        
        return view;
    }
    
    private TextView createTextView() {
        return new TextView(this);
    }
    
    private Button createButton() {
        return new Button(this);
    }
    
    private CheckBox createCheckBox() {
        return new CheckBox(this);
    }
    
    private RadioButton createRadioButton() {
        return new RadioButton(this);
    }
    
    private void setLabel(@NonNull TextView view, @NonNull String label) {
        view.setText(label);
    }
    
    // Sets a random generated color to view's text
    private void setTextColorTo(@NonNull TextView view) {
        final int textColor = Utils.generateRandomColor();
        view.setTextColor(textColor);
    }
    
    private void applyLayoutParamsTo(@NonNull View view) {
        // We need LinearLayout LayoutParams because our parent view is a LinearLayout.
        final LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
    }
    
    // Simple method that generates a Random integer in the range: [0, 3] -- inclusive.
    private static int generateRandomViewType() {
        return Utils.generateRandomIntegerBetween(0, 3);
    }
    
}
