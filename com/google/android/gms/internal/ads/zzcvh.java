package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvh {
    private final Context zza;
    private final zzfcw zzb;
    private final Bundle zzc;
    private final zzfco zzd;
    private final zzcuy zze;
    private final zzedr zzf;
    private final int zzg;

    public /* synthetic */ zzcvh(zzcvf zzcvfVar, zzcvg zzcvgVar) {
        this.zza = zzcvfVar.zza;
        this.zzb = zzcvfVar.zzb;
        this.zzc = zzcvfVar.zzc;
        this.zzd = zzcvfVar.zzd;
        this.zze = zzcvfVar.zze;
        this.zzf = zzcvfVar.zzf;
        this.zzg = zzcvfVar.zzg;
    }

    public final int zza() {
        return this.zzg;
    }

    public final Context zzb(Context context) {
        return this.zza;
    }

    public final Bundle zzc() {
        return this.zzc;
    }

    public final zzcuy zzd() {
        return this.zze;
    }

    public final zzcvf zze() {
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(this.zza);
        zzcvfVar.zzk(this.zzb);
        zzcvfVar.zzg(this.zzc);
        zzcvfVar.zzh(this.zze);
        zzcvfVar.zze(this.zzf);
        return zzcvfVar;
    }

    public final zzedr zzf(String str) {
        zzedr zzedrVar = this.zzf;
        return zzedrVar != null ? zzedrVar : new zzedr(str);
    }

    public final zzfco zzg() {
        return this.zzd;
    }

    public final zzfcw zzh() {
        return this.zzb;
    }
}
