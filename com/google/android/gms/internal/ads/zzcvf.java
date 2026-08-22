package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvf {
    private Context zza;
    private zzfcw zzb;
    private Bundle zzc;
    private zzfco zzd;
    private zzcuy zze;
    private zzedr zzf;
    private int zzg = 0;

    public final zzcvf zze(zzedr zzedrVar) {
        this.zzf = zzedrVar;
        return this;
    }

    public final zzcvf zzf(Context context) {
        this.zza = context;
        return this;
    }

    public final zzcvf zzg(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzcvf zzh(zzcuy zzcuyVar) {
        this.zze = zzcuyVar;
        return this;
    }

    public final zzcvf zzi(int i) {
        this.zzg = i;
        return this;
    }

    public final zzcvf zzj(zzfco zzfcoVar) {
        this.zzd = zzfcoVar;
        return this;
    }

    public final zzcvf zzk(zzfcw zzfcwVar) {
        this.zzb = zzfcwVar;
        return this;
    }

    public final zzcvh zzl() {
        return new zzcvh(this, null);
    }
}
