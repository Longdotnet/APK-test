package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxw extends zzfxj {
    final /* synthetic */ zzfxz zza;
    private final Object zzb;
    private int zzc;

    public zzfxw(zzfxz zzfxzVar, int i) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
        this.zzb = zzfxz.zzg(zzfxzVar, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i != -1) {
            zzfxz zzfxzVar = this.zza;
            if (i < zzfxzVar.size() && zzfvm.zza(this.zzb, zzfxz.zzg(zzfxzVar, this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzw(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object getValue() {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfxz.zzj(zzfxzVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzfxzVar.put(this.zzb, obj);
            return null;
        }
        Object objZzj = zzfxz.zzj(zzfxzVar, i);
        zzfxz.zzn(zzfxzVar, this.zzc, obj);
        return objZzj;
    }
}
