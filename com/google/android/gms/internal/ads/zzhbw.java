package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhbw extends RuntimeException {
    public zzhbw(zzhas zzhasVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgzw zza() {
        return new zzgzw(getMessage());
    }
}
