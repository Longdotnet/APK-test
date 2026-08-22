package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class zzwq extends zzug implements zzwh {
    private final zzgi zza;
    private final zzsh zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzhj zzh;
    private zzap zzi;
    private final zzwn zzj;
    private final zzzq zzk;

    public /* synthetic */ zzwq(zzap zzapVar, zzgi zzgiVar, zzwn zzwnVar, zzsh zzshVar, zzzq zzzqVar, int i, int i2, zzz zzzVar, zzfwh zzfwhVar, zzwp zzwpVar) {
        this.zzi = zzapVar;
        this.zza = zzgiVar;
        this.zzj = zzwnVar;
        this.zzb = zzshVar;
        this.zzk = zzzqVar;
        this.zzc = i;
    }

    private final void zzw() {
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzap zzapVarZzJ = zzJ();
        zzxd zzxdVar = new zzxd(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, z, false, false, null, zzapVarZzJ, z2 ? zzapVarZzJ.zzc : null);
        zzo(this.zzd ? new zzwm(this, zzxdVar) : zzxdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzG(zzvf zzvfVar) {
        ((zzwl) zzvfVar).zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final zzvf zzI(zzvh zzvhVar, zzzm zzzmVar, long j) {
        zzgj zzgjVarZza = this.zza.zza();
        zzhj zzhjVar = this.zzh;
        if (zzhjVar != null) {
            zzgjVarZza.zzf(zzhjVar);
        }
        zzak zzakVar = zzJ().zzb;
        zzakVar.getClass();
        Uri uri = zzakVar.zza;
        zzwn zzwnVar = this.zzj;
        zzb();
        return new zzwl(uri, zzgjVarZza, new zzuj(zzwnVar.zza), this.zzb, zzc(zzvhVar), this.zzk, zze(zzvhVar), this, zzzmVar, null, this.zzc, 0, null, zzex.zzs(-9223372036854775807L), null);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final synchronized zzap zzJ() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zza(long j, zzaeu zzaeuVar, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        boolean zZzh = zzaeuVar.zzh();
        if (!this.zzd && this.zze == j && this.zzf == zZzh && this.zzg == z) {
            return;
        }
        this.zze = j;
        this.zzf = zZzh;
        this.zzg = z;
        this.zzd = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzn(zzhj zzhjVar) {
        this.zzh = zzhjVar;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvj
    public final synchronized void zzt(zzap zzapVar) {
        this.zzi = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzz() {
    }
}
