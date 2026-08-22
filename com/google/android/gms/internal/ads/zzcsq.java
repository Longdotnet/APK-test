package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzcsq implements zzcxm, com.google.android.gms.ads.internal.client.zza, zzcza, zzcws, zzcvy, zzdbm {
    private final Clock zza;
    private final zzbzl zzb;

    public zzcsq(Clock clock, zzbzl zzbzlVar) {
        this.zza = clock;
        this.zzb = zzbzlVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        Clock clock = this.zza;
        zzbzl zzbzlVar = this.zzb;
        ((DefaultClock) clock).getClass();
        zzbzlVar.zzk(SystemClock.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(zzbwc zzbwcVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzi(zzbcj.zzb zzbVar) {
        this.zzb.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzj(zzbcj.zzb zzbVar) {
    }

    public final void zzk(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zzj(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzl(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzm(zzbcj.zzb zzbVar) {
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzn(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        this.zzb.zzh(true);
    }
}
