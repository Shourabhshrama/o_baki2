package com.kuberkings.obaki.util;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;


import com.kuberkings.obaki.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;



public class Utility {

    /**
     * Set language
     */
    public static void setLanguage(Activity activity, String str) {
        PreferenceConnector.writeString(activity, PreferenceConnector.Language, str);
    }

    /**
     * Get user name
     */
    public static String getLanguage(Activity activity) {
        return PreferenceConnector.readString(activity, PreferenceConnector.Language, "en");
    }

    // get device token
    public static String getDeviceToken(Activity activity) {
        return Settings.Secure.ANDROID_ID;
    }

    // start activity class
    public static void startActivityClass(Activity currentActivity, Class newActivity) {
        Intent intent = new Intent(currentActivity, newActivity);
        currentActivity.startActivity(intent);
    }

    // start activity or clear previous activity
    public static void startActivity(Activity currentActivity, Class newActivity) {
        Intent intent = new Intent(currentActivity, newActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        currentActivity.startActivity(intent);
    }

    public static String getTime(String createdTime) {
        String calculatedTime = "";
        Date currentTime = Calendar.getInstance().getTime();

        String dtStart = createdTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(dtStart);
            String currentDate = format.format(currentTime.getTime());

            Date date2 = format.parse(currentDate);
            long diffInMillisec = date2.getTime() - date.getTime();

            long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillisec);
            long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillisec);
            long diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMillisec);
            long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
            Log.d("diffInDays", "" + diffInDays);
            Log.d("diffInHours", "" + diffInHours);
            Log.d("diffInMin", "" + diffInMin);
            Log.d("diffInSec", "" + diffInSec);
            Log.d("createdTime", "" + createdTime);
            Log.d("currentDate", "" + currentDate);
            if (diffInDays != 0) {
                return calculatedTime = diffInDays + " Days ago";
            } else if (diffInHours != 0) {
                return calculatedTime = "" + diffInHours + " Hours ago";
            } else if (diffInMin != 0) {
                return calculatedTime = "" + diffInMin + " Min ago";
            } else if (diffInSec != 0) {
                return calculatedTime = "" + diffInSec + " Sec ago";
            } else {
                return calculatedTime = "";
            }


        } catch (ParseException e) {
            e.printStackTrace();

            Log.e("date error", e.getMessage());
            return "";
        }

    }

    // set status bar color
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // finally change the color
            window.setStatusBarColor(ContextCompat.getColor(activity, color));
        }
    }

    // check valid email
    public static boolean isValidEmailId(String email) {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|" +
                "([a-zA-Z]{1}|[\\w-]{2,}))@" + "((([0-1]?[0-9]" +
                "{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|" +
                "25[0-5]|2[0-4][0-9])\\." + "([0-1]?[0-9]{1,2}|25[0-5]|" +
                "2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|" +
                "2[0-4][0-9])){1}|" + "([a-zA-Z]+[\\w-]+\\.)+" +
                "[a-zA-Z]{2,4})$").
                matcher(email).matches();
    }

    // check internet connection
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    // get Device height width
    public static DisplayMetrics getHeightWidth() {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;

        DisplayMetrics metrics = new DisplayMetrics();
        metrics.widthPixels = width;
        metrics.heightPixels = height;
        return metrics;
    }

    // show toast
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    // convert to date format
    public static Date convertDateFormat(String dateTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // show popup menu
    public static void showPopupMenu(final Context activity, View view) {
        final PopupMenu popup = new PopupMenu(activity, view);

        popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                int i = item.getItemId();
                if (i == R.id.profile) {
                    return true;
                } else if (i == R.id.newTour) {
                    return true;
                } else {
                    return onMenuItemClick(item);
                }
            }
        });

        popup.show();
    }

    // show dialog for logout
    public static void showLogoutDialog(final Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.logout_alert_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout((int) (activity.getWindow().peekDecorView().getWidth() * 0.75), ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.show();

        CardView cardViewLogout = dialog.findViewById(R.id.cardViewLogout);
        TextView cancelTxt = dialog.findViewById(R.id.cancelTxt);

        cancelTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        cardViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                QBUsers.signOut().performAsync(new QBEntityCallback<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid, Bundle bundle) {
//
//
//                    }
//
//                    @Override
//                    public void onError(QBResponseException e) {
//                        Log.d("logout error", e.getMessage());
//                    }
//                });

                PreferenceConnector.clear(activity);
              //  activity.startActivity(new Intent(activity, WelcomeScreen.class));
                dialog.dismiss();
                activity.finish();

            }
        });

        dialog.show();
    }


    public static Bitmap stringToBitmap(String encodedString) {
        byte[] encodedByte = Base64.decode(encodedString, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(encodedByte, 0, encodedByte.length);
        return bitmap;
    }

    // show dialog for logout

    // show dialog for delete story
    // show dialog for logout




}