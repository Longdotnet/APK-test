package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzaar implements zzaco {
    private final zzabs zza;
    private final zzabx zzb;
    private final Queue zzc;
    private Surface zzd;
    private zzz zze;
    private long zzf;
    private zzacl zzg;
    private Executor zzh;
    private zzabp zzi;

    public zzaar(zzabs zzabsVar, zzdj zzdjVar) {
        this.zza = zzabsVar;
        zzabsVar.zzi(zzdjVar);
        this.zzb = new zzabx(new zzaap(this, null), zzabsVar);
        this.zzc = new ArrayDeque();
        this.zze = new zzx().zzan();
        this.zzf = -9223372036854775807L;
        this.zzg = zzacl.zzb;
        this.zzh = new Executor() { // from class: com.google.android.gms.internal.ads.zzaaj
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
            }
        };
        this.zzi = new zzabp() { // from class: com.google.android.gms.internal.ads.zzaak
            @Override // com.google.android.gms.internal.ads.zzabp
            public final void zzcT(long j, long j2, zzz zzzVar, MediaFormat mediaFormat) {
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzA(zzz zzzVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzB() {
        return this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzC() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzD(boolean z) {
        return this.zza.zzm(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final Surface zzb() {
        Surface surface = this.zzd;
        zzdd.zzb(surface);
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzh() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzi() {
        this.zzd = null;
        this.zza.zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzj(boolean z) {
        if (z) {
            this.zza.zzg();
        }
        this.zzb.zza();
        this.zzc.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzk(boolean z) {
        this.zza.zzc(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzl(int i, zzz zzzVar, long j, int i2, List list) {
        zzdd.zzf(list.isEmpty());
        int i3 = zzzVar.zzv;
        zzz zzzVar2 = this.zze;
        if (i3 != zzzVar2.zzv || zzzVar.zzw != zzzVar2.zzw) {
            this.zzb.zzd(i3, zzzVar.zzw);
        }
        float f = zzzVar.zzz;
        if (f != this.zze.zzz) {
            this.zza.zzj(f);
        }
        this.zze = zzzVar;
        if (j != this.zzf) {
            this.zzb.zzc(i2, j);
            this.zzf = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzm() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzn() {
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzo(long j, long j2) throws zzacn {
        try {
            this.zzb.zze(j, j2);
        } catch (zzin e) {
            throw new zzacn(e, this.zze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzp(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzq(int i) {
        this.zza.zzh(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzr(zzacl zzaclVar, Executor executor) {
        this.zzg = zzaclVar;
        this.zzh = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzs(Surface surface, zzeo zzeoVar) {
        this.zzd = surface;
        this.zza.zzk(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzt(float f) {
        this.zza.zzl(f);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzu(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzv(zzabp zzabpVar) {
        this.zzi = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzw() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzx() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzy() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzz(long j, zzacm zzacmVar) {
        this.zzc.add(zzacmVar);
        this.zzb.zzb(j);
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaal
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg.zzb();
            }
        });
        return true;
    }
}
