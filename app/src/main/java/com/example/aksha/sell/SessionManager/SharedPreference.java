package com.example.aksha.sell.SessionManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    private static SharedPreference preference;
    private static Context mContext;

    private static final String PREF_NAME = "Sell";
    private static final String KEY_USER_ID = "cust_id";
    private static final String KEY_USER_NAME = "cust_name";
    private static final String KEY_EMAIL = "cust_email";
    private static final String KEY_PASSWORD = "cust_password";


    private SharedPreference(Context context){
        mContext = context;
    }

    public synchronized SharedPreference getPreference(Context context){
        if (preference == null){
            preference = new SharedPreference(context);
        }
        return preference;
    }

    public boolean userLogin(int cust_id,String cust_name,String cust_email,String cust_password){

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID,cust_id);
        editor.putString(KEY_USER_NAME,cust_name);
        editor.putString(KEY_EMAIL,cust_email);
        editor.putString(KEY_PASSWORD,cust_password);

        editor.apply();
        return true;
    }

    public boolean isUserLoggedIn(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USER_NAME,null)!= null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        return true;
    }



}
