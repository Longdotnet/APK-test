package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzabi implements zzaco {
    final /* synthetic */ zzabo zza;
    private zzfyq zzb;
    private zzz zzc;
    private long zzd;
    private long zze;

    public zzabi(zzabo zzaboVar, Context context, int i) {
        Objects.requireNonNull(zzaboVar);
        this.zza = zzaboVar;
        zzex.zzL(context);
        this.zzb = zzfyq.zzn();
        this.zze = -9223372036854775807L;
    }

    private final void zza(zzz zzzVar) {
        zzabo zzaboVar = this.zza;
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzF(zzabo.zzA(zzzVar.zzE));
        zzxVarZzb.zzan();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzA(zzz zzzVar) {
        return zzabo.zzy(this.zza, zzzVar, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzB() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzC() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzD(boolean z) {
        return this.zza.zze.zzD(false);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final Surface zzb() {
        zzdd.zzf(false);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzh() {
        zzabo zzaboVar = this.zza;
        if (zzaboVar.zzh.zza() == 0) {
            zzaboVar.zze.zzh();
            return;
        }
        zzet zzetVar = new zzet(10);
        boolean z = true;
        while (zzaboVar.zzh.zza() > 0) {
            zzabm zzabmVar = (zzabm) zzaboVar.zzh.zzb();
            zzabmVar.getClass();
            if (z) {
                int i = zzabmVar.zzb;
                if (i == 0 || i == 1) {
                    zzabmVar = new zzabm(zzabmVar.zza, 0, zzabmVar.zzc);
                } else {
                    zzaboVar.zze.zzh();
                }
            }
            zzetVar.zzd(zzabmVar.zzc, zzabmVar);
            z = false;
        }
        zzaboVar.zzh = zzetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzi() {
        this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzj(boolean z) {
        this.zze = -9223372036854775807L;
        zzabo.zzj(this.zza, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzk(boolean z) {
        zzabo zzaboVar = this.zza;
        if (zzaboVar.zzd) {
            zzaboVar.zze.zzk(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzl(int i, zzz zzzVar, long j, int i2, List list) {
        zzdd.zzf(false);
        this.zzb = zzfyq.zzl(list);
        this.zzc = zzzVar;
        zzabo zzaboVar = this.zza;
        zzaboVar.zzq = -9223372036854775807L;
        zza(zzzVar);
        long j2 = this.zze;
        long j3 = -4611686018427387904L;
        if (zzaboVar.zzd) {
            if (j2 != -9223372036854775807L) {
                j3 = j2 + 1;
            }
        } else if (j2 != -9223372036854775807L) {
            return;
        }
        zzaboVar.zzh.zzd(j3, new zzabm(j + this.zzd, i2, j3));
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzn() {
        this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzo(long j, long j2) {
        this.zza.zze.zzo(j + this.zzd, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzp(long j) {
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzq(int i) {
        this.zza.zze.zzq(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzr(zzacl zzaclVar, Executor executor) {
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzs(Surface surface, zzeo zzeoVar) {
        this.zza.zzs(surface, zzeoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzt(float f) {
        this.zza.zze.zzt(f);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzu(List list) {
        if (this.zzb.equals(list)) {
            return;
        }
        this.zzb = zzfyq.zzl(list);
        zzz zzzVar = this.zzc;
        if (zzzVar != null) {
            zza(zzzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzv(zzabp zzabpVar) {
        this.zza.zze.zzv(zzabpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzw() {
        zzabo zzaboVar = this.zza;
        zzaboVar.zzq = this.zze;
        if (zzaboVar.zzp >= zzaboVar.zzq) {
            zzaboVar.zze.zzw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzx() {
        zzabo zzaboVar = this.zza;
        if (zzaboVar.zzd) {
            zzaboVar.zzu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzy() {
        zzabo zzaboVar = this.zza;
        if (zzaboVar.zzd) {
            zzaboVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final boolean zzz(long j, zzacm zzacmVar) {
        zzdd.zzf(false);
        if (zzabo.zzz(this.zza)) {
            throw null;
        }
        return false;
    }
}
