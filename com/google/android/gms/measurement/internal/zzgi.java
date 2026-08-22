package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public final class zzgi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ Object zze;

    public /* synthetic */ zzgi(Object obj, Object obj2, Object obj3, Object obj4, long j, int i) {
        this.$r8$classId = i;
        this.zze = obj;
        this.zza = obj2;
        this.zzb = obj3;
        this.zzc = obj4;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.zzb;
                zzgj zzgjVar = (zzgj) this.zze;
                String str2 = (String) this.zza;
                if (str2 != null) {
                    zzie zzieVar = new zzie((String) this.zzc, str2, this.zzd);
                    zzkt zzktVar = zzgjVar.zza;
                    zzktVar.zzaz().zzg();
                    String str3 = zzktVar.zzE;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    zzktVar.zzE = str;
                    zzktVar.zzD = zzieVar;
                } else {
                    zzkt zzktVar2 = zzgjVar.zza;
                    zzktVar2.zzaz().zzg();
                    String str4 = zzktVar2.zzE;
                    if (str4 == null || str4.equals(str)) {
                        zzktVar2.zzE = str;
                        zzktVar2.zzD = null;
                    }
                }
                break;
            case 1:
                Object obj = this.zzc;
                ((zzhx) this.zze).zzY(this.zzd, obj, (String) this.zza, (String) this.zzb);
                break;
            default:
                Bundle bundle = (Bundle) this.zza;
                bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
                bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
                zzim zzimVar = (zzim) this.zze;
                zzlb zzlbVar = ((zzfr) zzimVar.mBuilder).zzp;
                zzfr.zzP(zzlbVar);
                zzimVar.zzA((zzie) this.zzb, (zzie) this.zzc, this.zzd, true, zzlbVar.zzy(FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
                break;
        }
    }
}
