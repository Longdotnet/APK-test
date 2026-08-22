package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxq extends zzayk {
    private final zzawy zzh;

    public zzaxq(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, zzawy zzawyVar) {
        super(zzawxVar, "L3kNtlg7QY6D9Xl7pPswVVS/MCBOYXcB4vflYd8GjH187tfdUwj4wLKq5xN70kha", "7KShiw4CrXn9e1sAZ1bf68KLoTIikFllvC3ALPO42ag=", zzastVar, i, 85);
        this.zzh = zzawyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        Method method = this.zze;
        zzawy zzawyVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzawyVar.zzd()), Long.valueOf(zzawyVar.zzh()), Long.valueOf(zzawyVar.zzb()), Long.valueOf(zzawyVar.zzf()));
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzt(jArr[0]);
            zzastVar.zzs(jArr[1]);
        }
    }
}
