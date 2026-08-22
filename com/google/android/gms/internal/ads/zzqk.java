package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzqk extends Exception {
    public final int zza;
    public final boolean zzb;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzqk(int i, int i2, int i3, int i4, int i5, zzz zzzVar, boolean z, Exception exc) {
        String strValueOf = String.valueOf(zzzVar);
        StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("AudioTrack init failed ", i, " Config(", i2, ", ");
        sbM.append(i3);
        sbM.append(", ");
        sbM.append(i4);
        sbM.append(", ");
        sbM.append(i5);
        sbM.append(") ");
        sbM.append(strValueOf);
        sbM.append(true != z ? "" : " (recoverable)");
        super(sbM.toString(), exc);
        this.zza = i;
        this.zzb = z;
    }
}
