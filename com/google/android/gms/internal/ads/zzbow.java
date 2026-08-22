package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbow {
    static final com.google.android.gms.ads.internal.util.zzbd zza = new zzbou();
    static final com.google.android.gms.ads.internal.util.zzbd zzb = new zzbov();
    private final zzboi zzc;

    public zzbow(Context context, VersionInfoParcel versionInfoParcel, String str, zzfhx zzfhxVar) {
        this.zzc = new zzboi(context, versionInfoParcel, str, zza, zzb, zzfhxVar);
    }

    public final zzbom zza(String str, zzbop zzbopVar, zzboo zzbooVar) {
        return new zzbpa(this.zzc, str, zzbopVar, zzbooVar);
    }

    public final zzbpf zzb() {
        return new zzbpf(this.zzc);
    }
}
