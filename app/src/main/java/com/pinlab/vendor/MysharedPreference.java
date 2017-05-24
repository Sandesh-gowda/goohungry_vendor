package com.pinlab.vendor;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by linuxy on 5/2/17.
 */

public class MysharedPreference {


    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;
    public static final String Login_Preferences = "Login_Preferences";
    public static final String User_Id = "User_Id";
    public static final String User_Name = "User_Name";

    public MysharedPreference(Context context, String pref_key_value) {
        this._context = context;
        pref = _context.getSharedPreferences(pref_key_value, PRIVATE_MODE);
        editor = pref.edit();
    }





    public void storeUser(User user) {
        editor.putString(User_Id, user.getUuid());
        editor.putString(User_Name, user.getUuidName());
//        editor.putString(User_EmailId, user.getEmail());


        editor.commit();

        Log.e("MYShare", "User is stored in shared preferences. " + user.getUuid() + ", " + user.getUuidName());
    }


    public User getUser() {
        if (pref.getString(User_Id, null) != null) {

            String user_id = pref.getString(User_Id, null);
//            String user_name = pref.getString(User_Name, null);
//            String user_email = pref.getString(User_EmailId, null);
            Log.e("MYSH", "Get User Data " + user_id);
            return new User(user_id);
        }
        return null;
    }


    public void logoutUser() {
        editor.clear();
        editor.commit();
    }
}
