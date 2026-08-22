package com.google.android.ump;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public interface ConsentForm {

    public interface OnConsentFormDismissedListener {
    }

    void show(Activity activity, OnConsentFormDismissedListener onConsentFormDismissedListener);
}
