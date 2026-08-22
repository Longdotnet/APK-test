package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzfjp;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw extends zzb {
    public final com.google.android.gms.ads.internal.util.client.zzu zza;
    public final String zzb;
    public final com.google.android.gms.ads.internal.util.client.zzv zzc;

    public zzbw(Context context, String str, String str2, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = new com.google.android.gms.ads.internal.util.client.zzu(context, com.google.android.gms.ads.internal.zzv.zza.zzd.zzc(context, str));
        this.zzb = str2;
        this.zzc = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        String str = this.zzb;
        com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        if (zzvVar == null) {
            zzuVar.zza(str);
        } else {
            new zzfjp(zzvVar.zza, zzuVar, zzcaf.zze, null).zzd(str);
        }
    }
}
