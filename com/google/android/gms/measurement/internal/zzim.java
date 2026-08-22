package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzim extends zzf {
    public zzie zza;
    public volatile zzie zzb;
    public volatile zzie zzc;
    public final ConcurrentHashMap zzd;
    public Activity zze;
    public volatile boolean zzf;
    public volatile zzie zzg;
    public zzie zzh;
    public boolean zzi;
    public final Object zzj;

    public zzim(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    public final void zzA(zzie zzieVar, zzie zzieVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        boolean z3;
        long j2;
        zzg();
        boolean z4 = false;
        if (zzieVar2 != null) {
            if (zzieVar2.zzc == zzieVar.zzc && zzg.zza$1(zzieVar2.zzb, zzieVar.zzb) && zzg.zza$1(zzieVar2.zza, zzieVar.zza)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (z && this.zza != null) {
            z4 = true;
        }
        boolean z5 = zzieVar.zze;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (z2) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzlb.zzK(zzieVar, bundle2, true);
            if (zzieVar2 != null) {
                String str = zzieVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzieVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzieVar2.zzc);
            }
            if (z4) {
                zzkc zzkcVar = zzfrVar.zzo;
                zzfr.zzQ(zzkcVar);
                zzka zzkaVar = zzkcVar.zzb;
                long j3 = j - zzkaVar.zzb;
                zzkaVar.zzb = j;
                if (j3 > 0) {
                    zzlb zzlbVar = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar);
                    zzlbVar.zzI(bundle2, j3);
                }
            }
            if (!zzfrVar.zzk.zzu()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != z5 ? "auto" : "app";
            zzfrVar.zzr.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z5) {
                z3 = z4;
                long j4 = zzieVar.zzf;
                if (j4 != 0) {
                    j2 = j4;
                }
                zzhx zzhxVar = zzfrVar.zzt;
                zzfr.zzQ(zzhxVar);
                zzhxVar.zzH(str3, "_vs", bundle2, j2);
            } else {
                z3 = z4;
            }
            j2 = jCurrentTimeMillis;
            zzhx zzhxVar2 = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzH(str3, "_vs", bundle2, j2);
        } else {
            z3 = z4;
        }
        if (z3) {
            zzB(this.zza, true, j);
        }
        this.zza = zzieVar;
        if (z5) {
            this.zzh = zzieVar;
        }
        zzjm zzjmVarZzt = zzfrVar.zzt();
        zzjmVarZzt.zzg();
        zzjmVarZzt.zza();
        zzjmVarZzt.zzR(new com.google.android.gms.tasks.zzc(zzjmVarZzt, zzieVar, 5));
    }

    public final void zzB(zzie zzieVar, boolean z, long j) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzd zzdVarZzd = zzfrVar.zzd();
        zzfrVar.zzr.getClass();
        zzdVarZzd.zzf(SystemClock.elapsedRealtime());
        boolean z2 = zzieVar != null && zzieVar.zzd;
        zzkc zzkcVar = zzfrVar.zzo;
        zzfr.zzQ(zzkcVar);
        if (!zzkcVar.zzb.zzd(j, z2, z) || zzieVar == null) {
            return;
        }
        zzieVar.zzd = false;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final zzie zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzie zzieVar = this.zza;
        return zzieVar != null ? zzieVar : this.zzh;
    }

    public final String zzl(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str.length();
        ((zzfr) this.mBuilder).getClass();
        return length2 > 100 ? str.substring(0, 100) : str;
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!((zzfr) this.mBuilder).zzk.zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final zzie zzy(Activity activity) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        zzie zzieVar = (zzie) this.zzd.get(activity);
        if (zzieVar == null) {
            String strZzl = zzl(activity.getClass());
            zzlb zzlbVar = ((zzfr) this.mBuilder).zzp;
            zzfr.zzP(zzlbVar);
            zzie zzieVar2 = new zzie(null, strZzl, zzlbVar.zzq());
            this.zzd.put(activity, zzieVar2);
            zzieVar = zzieVar2;
        }
        return this.zzg != null ? this.zzg : zzieVar;
    }

    public final void zzz(Activity activity, zzie zzieVar, boolean z) {
        zzie zzieVar2;
        zzie zzieVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzieVar.zzb == null) {
            zzieVar2 = new zzie(zzieVar.zza, activity != null ? zzl(activity.getClass()) : null, zzieVar.zzc, zzieVar.zze, zzieVar.zzf);
        } else {
            zzieVar2 = zzieVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzieVar2;
        ((zzfr) this.mBuilder).zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        zzfo zzfoVar = ((zzfr) this.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzih(this, zzieVar2, zzieVar3, jElapsedRealtime, z));
    }
}
