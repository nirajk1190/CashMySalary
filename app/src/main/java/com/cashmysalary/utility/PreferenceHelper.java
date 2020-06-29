package com.cashmysalary.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    /**
     * Declaring SharedPreferences variable
     **/
    private final SharedPreferences PREFERNCE;
    /**
     * Editor for Shared Preferences
     **/
    private final SharedPreferences.Editor EDITOR;

    /**
     * Constructer
     *
     * @param context - Application context
     **/
    public PreferenceHelper(Context context) {
        String MY_PREF = "mine_perference";
        PREFERNCE = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        EDITOR = this.PREFERNCE.edit();

    }

    /**
     * Stores String key and their values
     */
    public void saveStringPreference(String key, String value) {
        this.EDITOR.putString(key, value);
        this.EDITOR.apply();
    }

    /**
     * Return value of specified key
     */
    public String getStringPreference(String key) {
        return this.PREFERNCE.getString(key, "");
    }

    /**
     * Stores int key and their values
     */
    public void saveIntegerValue(String key, int value) {
        this.EDITOR.putInt(key, value);
        this.EDITOR.apply();
    }

    /**
     * Return value of specified key
     */
    public int getIntPreference(String key) {
        return this.PREFERNCE.getInt(key, 1);
    }

    public void clear(String name) {
        this.EDITOR.remove(name);
        this.EDITOR.commit();
    }
}
