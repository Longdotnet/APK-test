package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeij extends zzbwm {
    final /* synthetic */ zzcye zza;
    final /* synthetic */ zzcvw zzb;
    final /* synthetic */ zzcxf zzc;
    final /* synthetic */ zzdem zzd;

    public zzeij(zzeik zzeikVar, zzcye zzcyeVar, zzcvw zzcvwVar, zzcxf zzcxfVar, zzdem zzdemVar) {
        this.zza = zzcyeVar;
        this.zzb = zzcvwVar;
        this.zzc = zzcxfVar;
        this.zzd = zzdemVar;
        Objects.requireNonNull(zzeikVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zza.zzdw(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzdt();
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzk(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzl(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzm(IObjectWrapper iObjectWrapper, zzbwo zzbwoVar) {
        this.zzd.zza(zzbwoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzd.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzp(IObjectWrapper iObjectWrapper) {
        this.zzd.zzc();
    }
}
