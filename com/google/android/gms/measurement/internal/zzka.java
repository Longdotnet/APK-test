package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.zzof;

/* JADX INFO: loaded from: classes.dex */
public final class zzka {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzkc zzc;
    public final zzjz zzd;

    public zzka(zzkc zzkcVar) {
        this.zzc = zzkcVar;
        this.zzd = new zzjz(this, (zzfr) zzkcVar.mBuilder, 0);
        ((zzfr) zzkcVar.mBuilder).zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    public final boolean zzd(long j, boolean z, boolean z2) {
        zzkc zzkcVar = this.zzc;
        zzkcVar.zzg();
        zzkcVar.zza();
        zzof.zzc();
        zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
        if (!zzfrVar.zzk.zzs(null, zzdu.zzad)) {
            zzew zzewVar = zzfrVar.zzl;
            zzfr.zzP(zzewVar);
            zzfrVar.zzr.getClass();
            zzewVar.zzj.zzb(System.currentTimeMillis());
        } else if (zzfrVar.zzJ()) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzfrVar.zzr.getClass();
            zzewVar2.zzj.zzb(System.currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (!z && j2 < 1000) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(Long.valueOf(j2), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z2) {
            j2 = j - this.zzb;
            this.zzb = j;
        }
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar2);
        zzehVar2.zzl.zzb(Long.valueOf(j2), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        boolean zZzu = zzfrVar.zzk.zzu();
        zzim zzimVar = zzfrVar.zzs;
        zzfr.zzQ(zzimVar);
        zzlb.zzK(zzimVar.zzj(!zZzu), bundle, true);
        if (!z2) {
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("auto", "_e", bundle);
        }
        this.zza = j;
        zzjz zzjzVar = this.zzd;
        zzjzVar.zzb();
        zzjzVar.zzd(3600000L);
        return true;
    }
}
