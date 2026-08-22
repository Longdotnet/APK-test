package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjc {
    zzbhq zza;
    zzbhn zzb;
    zzbid zzc;
    zzbia zzd;
    zzbmy zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdjc zza(zzbhn zzbhnVar) {
        this.zzb = zzbhnVar;
        return this;
    }

    public final zzdjc zzb(zzbhq zzbhqVar) {
        this.zza = zzbhqVar;
        return this;
    }

    public final zzdjc zzc(String str, zzbhw zzbhwVar, zzbht zzbhtVar) {
        this.zzf.put(str, zzbhwVar);
        if (zzbhtVar != null) {
            this.zzg.put(str, zzbhtVar);
        }
        return this;
    }

    public final zzdjc zzd(zzbmy zzbmyVar) {
        this.zze = zzbmyVar;
        return this;
    }

    public final zzdjc zze(zzbia zzbiaVar) {
        this.zzd = zzbiaVar;
        return this;
    }

    public final zzdjc zzf(zzbid zzbidVar) {
        this.zzc = zzbidVar;
        return this;
    }

    public final zzdje zzg() {
        return new zzdje(this);
    }
}
