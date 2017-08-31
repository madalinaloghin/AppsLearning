package com.madalinaloghin.masterwidgets.recyclerview;

/**
 * Created by dorunechifor.
 */
public class Contact {
    private String mName, mPhone, mEmail;
    
    public Contact(String name, String phone, String email) {
        this.mName = name;
        this.mPhone = phone;
        this.mEmail = email;
    }
    
    public String getName() {
        return mName;
    }
    
    public String getEmail() {
        return mEmail;
    }
    
    public String getPhone() {
        return mPhone;
    }
}
