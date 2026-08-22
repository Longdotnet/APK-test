package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Object zza = new Object();
    public boolean zzb = false;

    public static boolean canUnparcelSafely(String str) {
        synchronized (zza) {
        }
        return true;
    }

    public static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    public void setShouldDowngrade(boolean z) {
        this.zzb = z;
    }

    public boolean shouldDowngrade() {
        return this.zzb;
    }
}
