package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdul implements zzgdj {
    final /* synthetic */ zzdun zza;

    public zzdul(zzdun zzdunVar) {
        Objects.requireNonNull(zzdunVar);
        this.zza = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        synchronized (this) {
            zzdun zzdunVar = this.zza;
            zzdunVar.zzc = true;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (SystemClock.elapsedRealtime() - zzdunVar.zzd));
            zzdunVar.zze.zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            zzdun zzdunVar = this.zza;
            zzdunVar.zzc = true;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (SystemClock.elapsedRealtime() - zzdunVar.zzd));
            zzdunVar.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduk
                @Override // java.lang.Runnable
                public final void run() {
                    zzdun.zzo(this.zza.zza, str);
                }
            });
        }
    }
}
