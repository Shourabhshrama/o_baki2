package com.kuberkings.obaki.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceConnector {

    public static final String USER_DATA = "user_data";
    public static final String USER_ID = "user_id";
    public static final String CART_COUNT = "cart_count";
    public static final String DEVICE_HEIGHT = "height";
    public static final String DEVICE_WIDTH = "width";
    public static final String IS_LOGIN = "is_login";
    public static final String USER_TYPE = "user_type";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_MOBILE = "user_mobile";
    public static final String USER_STATUS = "user_status";
    public static final String LOGIN_TYPE = "login_type";
    public static final String USER_PROFILE = "user_profile";
    public static final String DEVICE_TOKEN = "device_token";
    public static final String Language = "language";
    public static final String LanguageID = "language_id";
    public static final String NOTIFICATION_SOUND = "notification_sound";
    public static final String ORDER_UPDATES = "order_updates";
    public static final String MESSAGE_RECEIVE = "message_receive";
    public static final String DEALS_OFFERS = "deals_offers";
    public static final String TURN_EMAIL = "turn_emails";
    private static final int MODE = Context.MODE_PRIVATE;
    private static final String PREF_NAME = "MyCar_app";

    public static void writeBoolean(Context context, String key, boolean value) {
        if (context == null) {
            return;
        }
        getEditor(context).putBoolean(key, value).commit();
    }

    public static boolean readBoolean(Context context, String key, boolean defValue) {
        if (context == null) {
            return defValue;
        }
        return getPreferences(context).getBoolean(key, defValue);
    }

    public static void writeInteger(Context context, String key, int value) {
        if (context == null) {
            return;
        }
        getEditor(context).putInt(key, value).commit();

    }

    public static int readInteger(Context context, String key, int defValue) {
        if (context == null) {
            return defValue;
        }
        return getPreferences(context).getInt(key, defValue);
    }

    public static void writeString(Context context, String key, String value) {
        if (context == null) {
            return;
        }
        getEditor(context).putString(key, value).commit();
    }

    public static String readString(Context context, String key, String defValue) {
        if (context == null) {
            return defValue;
        }
        return getPreferences(context).getString(key, defValue);
    }

    public static void writeFloat(Context context, String key, float value) {
        if (context == null) {
            return;
        }
        getEditor(context).putFloat(key, value).commit();
    }

    public static float readFloat(Context context, String key, float defValue) {
        if (context == null) {
            return defValue;
        }
        return getPreferences(context).getFloat(key, defValue);
    }

    public static void writeLong(Context context, String key, long value) {
        if (context == null) {
            return;
        }
        getEditor(context).putLong(key, value).commit();
    }

    public static long readLong(Context context, String key, long defValue) {
        if (context == null) {
            return defValue;
        }
        return getPreferences(context).getLong(key, defValue);

    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static void remove(Context context, String key) {
        getEditor(context).remove(key);
    }

    public static void clear(Context context) {
        if (context == null) {
            return;
        }
        getEditor(context).clear().commit();
        getEditor(context).clear().commit();
    }
}
