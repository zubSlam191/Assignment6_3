package com.emailprocessing.email.services.emails.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Zubair on 5/12/2016.
 */
public class ConfirmSortingBusinessService extends IntentService {


    private static final String TAG =
            "Impl";

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Business entries sorted");
    }

    public ConfirmSortingBusinessService() {
        super("ConfirmSortingBusinessService");
    }
}
