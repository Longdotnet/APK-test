package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeis implements zzcxh {
    boolean zza;
    final /* synthetic */ zzedp zzb;
    final /* synthetic */ zzcak zzc;

    public zzeis(zzeit zzeitVar, zzedp zzedpVar, zzcak zzcakVar) {
        this.zzb = zzedpVar;
        this.zzc = zzcakVar;
        Objects.requireNonNull(zzeitVar);
        this.zza = false;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfO)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzedq(i, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcxh
    public final synchronized void zza(int i) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i, zzeit.zze(this.zzb.zza, i), "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcxh
    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcxh
    public final synchronized void zzc(int i, String str) {
        try {
            if (this.zza) {
                return;
            }
            this.zza = true;
            if (str == null) {
                str = zzeit.zze(this.zzb.zza, i);
            }
            zze(new com.google.android.gms.ads.internal.client.zze(i, str, "undefined", null, null));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxh
    public final synchronized void zzd() {
        this.zzc.zzc(null);
    }
}
