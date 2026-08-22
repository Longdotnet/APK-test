package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzell {
    private final zzdje zza;
    private final zzeky zzb;
    private final zzcwb zzc;

    public zzell(zzdje zzdjeVar, zzdsj zzdsjVar) {
        this.zza = zzdjeVar;
        final zzeky zzekyVar = new zzeky(zzdsjVar);
        this.zzb = zzekyVar;
        final zzbmy zzbmyVarZzg = zzdjeVar.zzg();
        this.zzc = new zzcwb() { // from class: com.google.android.gms.internal.ads.zzelk
            @Override // com.google.android.gms.internal.ads.zzcwb
            public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzekyVar.zzdD(zzeVar);
                zzbmy zzbmyVar = zzbmyVarZzg;
                if (zzbmyVar != null) {
                    try {
                        zzbmyVar.zzf(zzeVar);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (zzbmyVar != null) {
                    try {
                        zzbmyVar.zze(zzeVar.zza);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzcwb zza() {
        return this.zzc;
    }

    public final zzcxm zzb() {
        return this.zzb;
    }

    public final zzdgw zzc() {
        return new zzdgw(this.zza, this.zzb.zzg());
    }

    public final zzeky zzd() {
        return this.zzb;
    }

    public final void zze(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzb.zzj(zzbkVar);
    }
}
