package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdil implements zzazd {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdio zzb;

    public zzdil(zzdio zzdioVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdioVar);
        this.zzb = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbV)).booleanValue()) {
            if (zzazcVar.zzj) {
                zzdio zzdioVar = this.zzb;
                if (zzdioVar.zzo != null) {
                    zzdioVar.zzz.put(this.zza, Boolean.TRUE);
                    if (zzdioVar.zzo == null) {
                        return;
                    }
                    zzdioVar.zzC(zzdioVar.zzo.zzf(), zzdioVar.zzo.zzl(), zzdioVar.zzo.zzm(), true);
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this) {
            try {
                if (zzazcVar.zzj) {
                    zzdio zzdioVar2 = this.zzb;
                    if (zzdioVar2.zzo != null) {
                        zzdioVar2.zzz.put(this.zza, Boolean.TRUE);
                        if (zzdioVar2.zzo == null) {
                        } else {
                            zzdioVar2.zzC(zzdioVar2.zzo.zzf(), zzdioVar2.zzo.zzl(), zzdioVar2.zzo.zzm(), true);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
