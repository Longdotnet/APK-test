package com.google.android.gms.measurement.internal;

import com.facebook.AccessTokenCache;
import com.google.firebase.auth.zzz;

/* JADX INFO: loaded from: classes.dex */
public final class zzju implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkc zzb;

    public /* synthetic */ zzju(zzkc zzkcVar, long j, int i) {
        this.$r8$classId = i;
        this.zzb = zzkcVar;
        this.zza = j;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x008a  */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzkc zzkcVar = this.zzb;
                zzkcVar.zzg();
                zzkcVar.zzm$2();
                zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                long j = this.zza;
                zzehVar.zzl.zzb(Long.valueOf(j), "Activity resumed, time");
                if (zzfrVar.zzk.zzu()) {
                    zzka zzkaVar = zzkcVar.zzb;
                    zzkaVar.zzc.zzg();
                    zzkaVar.zzd.zzb();
                    zzkaVar.zza = j;
                    zzkaVar.zzb = j;
                } else {
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    if (zzewVar.zzm.zzb()) {
                        zzka zzkaVar2 = zzkcVar.zzb;
                        zzkaVar2.zzc.zzg();
                        zzkaVar2.zzd.zzb();
                        zzkaVar2.zza = j;
                        zzkaVar2.zzb = j;
                    }
                }
                zzz zzzVar = zzkcVar.zzc;
                zzkc zzkcVar2 = (zzkc) zzzVar.zzb;
                zzkcVar2.zzg();
                zzjx zzjxVar = (zzjx) zzzVar.zza;
                if (zzjxVar != null) {
                    zzkcVar2.zzd.removeCallbacks(zzjxVar);
                }
                zzew zzewVar2 = ((zzfr) zzkcVar2.mBuilder).zzl;
                zzfr.zzP(zzewVar2);
                zzewVar2.zzm.zza(false);
                AccessTokenCache accessTokenCache = zzkcVar.zza;
                ((zzkc) accessTokenCache.sharedPreferences).zzg();
                zzkc zzkcVar3 = (zzkc) accessTokenCache.sharedPreferences;
                if (((zzfr) zzkcVar3.mBuilder).zzJ()) {
                    ((zzfr) zzkcVar3.mBuilder).zzr.getClass();
                    accessTokenCache.zzb(System.currentTimeMillis(), false);
                    break;
                }
                break;
            default:
                zzkc zzkcVar4 = this.zzb;
                zzkcVar4.zzg();
                zzkcVar4.zzm$2();
                zzfr zzfrVar2 = (zzfr) zzkcVar4.mBuilder;
                zzeh zzehVar2 = zzfrVar2.zzm;
                zzfr.zzR(zzehVar2);
                long j2 = this.zza;
                zzehVar2.zzl.zzb(Long.valueOf(j2), "Activity paused, time");
                zzz zzzVar2 = zzkcVar4.zzc;
                zzkc zzkcVar5 = (zzkc) zzzVar2.zzb;
                ((zzfr) zzkcVar5.mBuilder).zzr.getClass();
                zzjx zzjxVar2 = new zzjx(zzzVar2, System.currentTimeMillis(), j2);
                zzzVar2.zza = zzjxVar2;
                zzkcVar5.zzd.postDelayed(zzjxVar2, 2000L);
                if (zzfrVar2.zzk.zzu()) {
                    zzkcVar4.zzb.zzd.zzb();
                }
                break;
        }
    }
}
