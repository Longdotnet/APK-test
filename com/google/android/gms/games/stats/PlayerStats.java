package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface PlayerStats extends Parcelable {
    public static final float UNSET_VALUE = -1.0f;

    /* synthetic */ Object freeze();

    float getAverageSessionLength();

    @Deprecated
    float getChurnProbability();

    int getDaysSinceLastPlayed();

    @Deprecated
    float getHighSpenderProbability();

    int getNumberOfPurchases();

    int getNumberOfSessions();

    float getSessionPercentile();

    float getSpendPercentile();

    @Deprecated
    float getSpendProbability();

    @Deprecated
    float getTotalSpendNext28Days();

    /* synthetic */ boolean isDataValid();

    Bundle zza();
}
