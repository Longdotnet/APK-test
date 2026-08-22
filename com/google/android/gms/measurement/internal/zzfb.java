package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import com.google.firebase.auth.zzz;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzfb implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfb(zzfi zzfiVar, String str, int i) {
        this.$r8$classId = i;
        this.zza = zzfiVar;
        this.zzb = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                zzfi zzfiVar = this.zza;
                zzam zzamVar = zzfiVar.zzf.zze;
                zzkt.zzal(zzamVar);
                String str = this.zzb;
                zzh zzhVarZzj = zzamVar.zzj(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put("package_name", str);
                ((zzfr) zzfiVar.mBuilder).zzk.zzh();
                map.put("gmp_version", 74029L);
                if (zzhVarZzj != null) {
                    String strZzw = zzhVarZzj.zzw();
                    if (strZzw != null) {
                        map.put("app_version", strZzw);
                    }
                    map.put("app_version_int", Long.valueOf(zzhVarZzj.zzb()));
                    map.put("dynamite_version", Long.valueOf(zzhVarZzj.zzk()));
                }
                return map;
            case 1:
                return new zzn("internal.remoteConfig", new zzz(this.zza, this.zzb, 4));
            default:
                return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new zzfb(this.zza, this.zzb, 0));
        }
    }
}
