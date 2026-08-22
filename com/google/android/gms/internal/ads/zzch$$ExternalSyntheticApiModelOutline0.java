package com.google.android.gms.internal.ads;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zzch$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(int i) {
        return new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", i);
    }

    public static /* synthetic */ NotificationChannel m(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ AudioFocusRequest.Builder m() {
        return new AudioFocusRequest.Builder(1);
    }

    public static /* bridge */ /* synthetic */ AudioFocusRequest m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m74m() {
    }
}
