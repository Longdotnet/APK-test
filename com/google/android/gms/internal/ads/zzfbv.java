package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfbv implements zzeln {
    final /* synthetic */ zzfbx zza;

    public zzfbv(zzfbx zzfbxVar) {
        Objects.requireNonNull(zzfbxVar);
        this.zza = zzfbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzfbx zzfbxVar = this.zza;
        synchronized (zzfbxVar) {
            zzfbxVar.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zzb(Object obj) {
        zzfbx zzfbxVar = this.zza;
        zzdon zzdonVar = (zzdon) obj;
        synchronized (zzfbxVar) {
            try {
                zzfbxVar.zzd = zzdonVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdP)).booleanValue()) {
                    zzdonVar.zzd().zza = zzfbxVar.zzc;
                }
                zzfbxVar.zzd.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
