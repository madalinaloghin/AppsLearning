package com.madalinaloghin.contactlistrv;

import java.io.Serializable;

/**
 * Created by madalina.loghin on 8/30/2017.
 */

public class Contact implements Serializable {

    private String mName, mPhone, mEmail;
    private int mImage;
    private boolean isSelected;

    public Contact(String mName, String mPhone, String mEmail, int mImage) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mEmail = mEmail;
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public int getmImage() {
        return mImage;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
