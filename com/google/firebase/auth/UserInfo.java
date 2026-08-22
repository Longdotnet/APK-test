package com.google.firebase.auth;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public interface UserInfo {
    String getDisplayName();

    String getEmail();

    String getPhoneNumber();

    Uri getPhotoUrl();

    String getProviderId();

    String getUid();

    boolean isEmailVerified();
}
