package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzcar {
    private final zzcak zza;
    private final AtomicInteger zzb;

    public zzcar() {
        zzcak zzcakVar = new zzcak();
        this.zza = zzcakVar;
        this.zzb = new AtomicInteger(0);
        zzgdn.zzr(zzcakVar, new zzcap(this), zzcaf.zzg);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhZ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzcao zzcaoVar, zzcam zzcamVar) {
        zzgdn.zzr(this.zza, new zzcaq(this, zzcaoVar, zzcamVar), zzcaf.zzg);
    }
}
