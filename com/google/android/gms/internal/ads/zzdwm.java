package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzdwm extends Exception {
    private final int zza;

    public zzdwm(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdwm(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdwm(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
