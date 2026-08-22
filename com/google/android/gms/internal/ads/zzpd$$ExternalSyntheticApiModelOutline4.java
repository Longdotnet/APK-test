package com.google.android.gms.internal.ads;

import android.media.AudioProfile;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zzpd$$ExternalSyntheticApiModelOutline4 {
    public static /* bridge */ /* synthetic */ AudioProfile m(Object obj) {
        return (AudioProfile) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ NetworkEvent.Builder m81m() {
        return new NetworkEvent.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackErrorEvent.Builder m82m() {
        return new PlaybackErrorEvent.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackMetrics.Builder m83m() {
        return new PlaybackMetrics.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackStateEvent.Builder m84m() {
        return new PlaybackStateEvent.Builder();
    }

    public static /* synthetic */ TrackChangeEvent.Builder m(int i) {
        return new TrackChangeEvent.Builder(i);
    }
}
