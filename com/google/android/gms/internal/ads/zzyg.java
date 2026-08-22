package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzyg implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzyg(zzz zzzVar, int i) {
        this.zza = 1 == (zzzVar.zze & 1);
        this.zzb = zzmb.zza(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyg zzygVar) {
        return zzfyf.zzj().zzd(this.zzb, zzygVar.zzb).zzd(this.zza, zzygVar.zza).zza();
    }
}
