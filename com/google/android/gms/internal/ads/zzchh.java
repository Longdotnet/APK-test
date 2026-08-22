package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzchh {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    public /* synthetic */ zzchh(zzchf zzchfVar, zzchg zzchgVar) {
        this.zza = zzchfVar.zza;
        this.zzb = zzchfVar.zzb;
        this.zzd = zzchfVar.zzd;
        this.zzc = zzchfVar.zzc;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final com.google.android.gms.ads.internal.zzk zzc() {
        return new com.google.android.gms.ads.internal.zzk(this.zzb, this.zza);
    }

    public final zzbfx zzd() {
        return new zzbfx(this.zzb);
    }

    public final VersionInfoParcel zze() {
        return this.zza;
    }

    public final String zzf() {
        return com.google.android.gms.ads.internal.zzv.zza.zzd.zzc(this.zzb, this.zza.afmaVersion);
    }

    public final WeakReference zzg() {
        return this.zzd;
    }
}
