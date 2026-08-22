package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzchz implements zzhgr {
    private final zzchh zza;

    private zzchz(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static VersionInfoParcel zzc(zzchh zzchhVar) {
        VersionInfoParcel versionInfoParcelZze = zzchhVar.zze();
        zzhgz.zzb(versionInfoParcelZze);
        return versionInfoParcelZze;
    }

    public static zzchz zzd(zzchh zzchhVar) {
        return new zzchz(zzchhVar);
    }

    public final VersionInfoParcel zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
