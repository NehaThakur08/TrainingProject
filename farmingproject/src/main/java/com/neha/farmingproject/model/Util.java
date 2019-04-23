package com.neha.farmingproject.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public class Util {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Users.db";

    public static final String TAB_NAME = "Users";


    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_EMAIL = "email";

    public static final String CREATE_TAB_QUERY = "create table Users("+
            "_ID Integer primary key autoincrement,"+
            "name varchar(256),"+
            "email varchar(50),"+
            "age varchar(15)"+
            ")";

    public static final Uri Users_URI = Uri.parse("content://cpp/"+TAB_NAME);

    public static boolean isInternetConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }

}
