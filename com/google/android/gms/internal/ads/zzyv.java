package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzyv {
    public final zzbm zza;
    public final int[] zzb;

    public zzyv(zzbm zzbmVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzea.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbmVar;
        this.zzb = iArr;
    }
}
