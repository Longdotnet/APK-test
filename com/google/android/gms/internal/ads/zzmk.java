package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzmk extends zzg implements zziy {
    private final zzkh zzb;
    private final zzdm zzc;

    public zzmk(zziw zziwVar) {
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zzc = zzdmVar;
        try {
            this.zzb = new zzkh(zziwVar, this);
            zzdmVar.zzf();
        } catch (Throwable th) {
            this.zzc.zzf();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzA() {
        this.zzc.zzb();
        this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzB(zzmr zzmrVar) {
        this.zzc.zzb();
        this.zzb.zzB(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzC(zzvj zzvjVar) {
        this.zzc.zzb();
        this.zzb.zzC(zzvjVar);
    }

    public final zzin zzD() {
        this.zzc.zzb();
        return this.zzb.zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzg
    public final void zzb(int i, long j, int i2, boolean z) {
        this.zzc.zzb();
        this.zzb.zzb(i, j, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzc() {
        this.zzc.zzb();
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzd() {
        this.zzc.zzb();
        return this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zze() {
        this.zzc.zzb();
        return this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzf() {
        this.zzc.zzb();
        return this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzg() {
        this.zzc.zzb();
        return this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzh() {
        this.zzc.zzb();
        return this.zzb.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzi() {
        this.zzc.zzb();
        this.zzb.zzi();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzj() {
        this.zzc.zzb();
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzk() {
        this.zzc.zzb();
        return this.zzb.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzl() {
        this.zzc.zzb();
        return this.zzb.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzm() {
        this.zzc.zzb();
        return this.zzb.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzn() {
        this.zzc.zzb();
        return this.zzb.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbl zzo() {
        this.zzc.zzb();
        return this.zzb.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbt zzp() {
        this.zzc.zzb();
        return this.zzb.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzq() {
        this.zzc.zzb();
        this.zzb.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzr(boolean z) {
        this.zzc.zzb();
        this.zzb.zzr(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzs(Surface surface) {
        this.zzc.zzb();
        this.zzb.zzs(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzt(float f) {
        this.zzc.zzb();
        this.zzb.zzt(f);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzu() {
        this.zzc.zzb();
        this.zzb.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzv() {
        this.zzc.zzb();
        return this.zzb.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzw() {
        this.zzc.zzb();
        this.zzb.zzw();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzx() {
        this.zzc.zzb();
        return this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final int zzy() {
        this.zzc.zzb();
        this.zzb.zzy();
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzz(zzmr zzmrVar) {
        this.zzc.zzb();
        this.zzb.zzz(zzmrVar);
    }
}
