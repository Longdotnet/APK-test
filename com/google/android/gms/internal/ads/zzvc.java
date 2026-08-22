package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class zzvc extends zzxm {
    private final boolean zzb;
    private final zzbk zzc;
    private final zzbj zzd;
    private zzva zze;
    private zzuz zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzvc(zzvj zzvjVar, boolean z) {
        boolean z2;
        super(zzvjVar);
        if (z) {
            zzvjVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        zzvjVar.zzM();
        this.zze = zzva.zzq(zzvjVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zze == null || !obj.equals(zzva.zzc)) ? obj : this.zze.zze;
    }

    private final boolean zzL(long j) {
        zzuz zzuzVar = this.zzf;
        int iZza = this.zze.zza(zzuzVar.zza.zza);
        if (iZza == -1) {
            return false;
        }
        zzva zzvaVar = this.zze;
        zzbj zzbjVar = this.zzd;
        zzvaVar.zzd(iZza, zzbjVar, false);
        long j2 = zzbjVar.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzuzVar.zzs(j);
        return true;
    }

    public final zzbl zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzvh zzD(zzvh zzvhVar) {
        Object obj = this.zze.zze;
        Object obj2 = zzvhVar.zza;
        if (obj != null && this.zze.zze.equals(obj2)) {
            obj2 = zzva.zzc;
        }
        return zzvhVar.zza(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzE(zzbl zzblVar) {
        long jZzq;
        zzvh zzvhVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzblVar);
            zzuz zzuzVar = this.zzf;
            if (zzuzVar != null) {
                zzL(zzuzVar.zzn());
            }
        } else if (zzblVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzva.zzr(zzblVar, zzbk.zza, zzva.zzc);
        } else {
            zzbk zzbkVar = this.zzc;
            zzblVar.zze(0, zzbkVar, 0L);
            Object obj = zzbkVar.zzb;
            zzuz zzuzVar2 = this.zzf;
            if (zzuzVar2 != null) {
                jZzq = zzuzVar2.zzq();
                this.zze.zzn(zzuzVar2.zza.zza, this.zzd);
                this.zze.zze(0, zzbkVar, 0L);
                if (jZzq == 0) {
                    jZzq = 0;
                }
            } else {
                jZzq = 0;
            }
            Pair pairZzl = zzblVar.zzl(zzbkVar, this.zzd, 0, jZzq);
            Object obj2 = pairZzl.first;
            long jLongValue = ((Long) pairZzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzva.zzr(zzblVar, obj, obj2);
            zzuz zzuzVar3 = this.zzf;
            if (zzuzVar3 != null && zzL(jLongValue)) {
                zzvh zzvhVar = zzuzVar3.zza;
                zzvhVarZza = zzvhVar.zza(zzK(zzvhVar.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zzvhVarZza != null) {
            zzuz zzuzVar4 = this.zzf;
            zzuzVar4.getClass();
            zzuzVar4.zzr(zzvhVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzxm) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzxm, com.google.android.gms.internal.ads.zzvj
    public final void zzG(zzvf zzvfVar) {
        ((zzuz) zzvfVar).zzt();
        if (zzvfVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm, com.google.android.gms.internal.ads.zzvj
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuz zzI(zzvh zzvhVar, zzzm zzzmVar, long j) {
        zzuz zzuzVar = new zzuz(zzvhVar, zzzmVar, j);
        zzuzVar.zzu(((zzxm) this).zza);
        if (this.zzh) {
            zzuzVar.zzr(zzvhVar.zza(zzK(zzvhVar.zza)));
        } else {
            this.zzf = zzuzVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzxm) this).zza);
            }
        }
        return zzuzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvj
    public final void zzt(zzap zzapVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzxi(this.zze.zzb, zzapVar));
        } else {
            this.zze = zzva.zzq(zzapVar);
        }
        ((zzxm) this).zza.zzt(zzapVar);
    }
}
