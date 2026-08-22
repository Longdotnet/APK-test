package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvt {
    public static final zzbya zza(Context context, VersionInfoParcel versionInfoParcel, zzfca zzfcaVar, zzbxw zzbxwVar) {
        zzbxx zzbxxVar = zzfcaVar.zzA;
        if (zzbxxVar == null) {
            return null;
        }
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return new zzbxv(context, versionInfoParcel, zzbxxVar, zzfcfVar == null ? null : zzfcfVar.zzb, zzbxwVar);
    }
}
