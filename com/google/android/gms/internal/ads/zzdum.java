package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdum extends zzbmg {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfhj zzd;
    final /* synthetic */ zzcak zze;
    final /* synthetic */ zzdun zzf;

    public zzdum(zzdun zzdunVar, Object obj, String str, long j, zzfhj zzfhjVar, zzcak zzcakVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfhjVar;
        this.zze = zzcakVar;
        Objects.requireNonNull(zzdunVar);
        this.zzf = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zze(String str) {
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str2 = this.zzb;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdunVar.zzv(str2, false, str, (int) (SystemClock.elapsedRealtime() - this.zzc));
            zzdunVar.zzl.zzb(str2, "error");
            zzdunVar.zzo.zzb(str2, "error");
            zzfhx zzfhxVar = zzdunVar.zzp;
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzc(str);
            zzfhjVar.zzg(false);
            zzfhxVar.zzc(zzfhjVar.zzm());
            this.zze.zzc(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzf() {
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str = this.zzb;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdunVar.zzv(str, true, "", (int) (SystemClock.elapsedRealtime() - this.zzc));
            zzdunVar.zzl.zzd(str);
            zzdunVar.zzo.zzd(str);
            zzfhx zzfhxVar = zzdunVar.zzp;
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzg(true);
            zzfhxVar.zzc(zzfhjVar.zzm());
            this.zze.zzc(Boolean.TRUE);
        }
    }
}
