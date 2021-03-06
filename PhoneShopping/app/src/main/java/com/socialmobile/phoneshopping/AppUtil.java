package com.socialmobile.phoneshopping;

import android.app.Activity;
import android.content.SharedPreferences;

import com.socialmobile.phoneshopping.activities.MainActivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */


public final class AppUtil {
    public static final String PREFS_STORE = "csm.phoneshopping.prefs";
    public static final String TNC_ACCEPTANCE_KEY = "tnc.accepted";
    public static final String FIRST_TIME_LAUNCH_KEY = "never.launched.before";
    public static final String USER_REGISTERED_KEY = "registered.user";

    public static boolean isAcceptedTNC(final Activity pCurrentActivity) {
        SharedPreferences settings = pCurrentActivity.getSharedPreferences(PREFS_STORE, 0);
        return settings.getBoolean(TNC_ACCEPTANCE_KEY, false);
    }

    public static void storeAcceptanceOfTNC(final boolean pAccept, final Activity pActivity) {
        SharedPreferences settings = pActivity.getSharedPreferences(PREFS_STORE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(TNC_ACCEPTANCE_KEY, pAccept);
        editor.commit();
    }

    public static boolean isLaunchedForTheFirstTime(final Activity activity) {
        SharedPreferences settings = activity.getSharedPreferences(PREFS_STORE, 0);
        if (settings.contains(TNC_ACCEPTANCE_KEY)) {
            return false;
        }
        return true;
    }

    public static boolean isUserAlreadyRegistered(final Activity activity) {

        SharedPreferences settings = activity.getSharedPreferences(PREFS_STORE, 0);
        if (settings.contains(USER_REGISTERED_KEY)) {
            return true;
        }
        return false;
    }

    public static String getPreferenceAsString(final Activity pActivity, final String pKey) {
        SharedPreferences settings = pActivity.getSharedPreferences(PREFS_STORE, 0);
        return settings.getString(pKey, "");
    }

    public static void setStringPreference(final Activity pActivity, final String pKey, final String pValue) {
        SharedPreferences settings = pActivity.getSharedPreferences(PREFS_STORE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(pKey, pValue);
        editor.commit();
    }
}
