package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfbq implements zzeln {
    final /* synthetic */ zzfbr zza;

    public zzfbq(zzfbr zzfbrVar) {
        Objects.requireNonNull(zzfbrVar);
        this.zza = zzfbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzfbr zzfbrVar = this.zza;
        synchronized (zzfbrVar) {
            zzfbrVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zzb(Object obj) {
        zzfbr zzfbrVar = this.zza;
        zzdon zzdonVar = (zzdon) obj;
        synchronized (zzfbrVar) {
            try {
                zzfbrVar.zzi = zzdonVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdP)).booleanValue()) {
                    zzdonVar.zzd().zza = zzfbrVar.zzd;
                }
                zzfbrVar.zzi.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
