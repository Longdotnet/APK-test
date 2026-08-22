package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzaz extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzaz(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzaz zza(String str, Throwable th) {
        return new zzaz(str, th, true, 1);
    }

    public static zzaz zzb(String str, Throwable th) {
        return new zzaz(str, th, true, 0);
    }

    public static zzaz zzc(String str) {
        return new zzaz(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        return (message != null ? message.concat(" ") : "") + "{contentIsMalformed=" + this.zza + ", dataType=" + this.zzb + "}";
    }
}
