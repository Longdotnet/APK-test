package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzgk extends IOException {
    public final int zza;

    public zzgk(int i) {
        this.zza = i;
    }

    public zzgk(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzgk(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzgk(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
