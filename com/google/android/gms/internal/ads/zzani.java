package com.google.android.gms.internal.ads;

import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class zzani implements zzamz {
    private final zzaod zza;
    private String zzb;
    private zzafb zzc;
    private zzanh zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzanr zzg = new zzanr(32, 128);
    private final zzanr zzh = new zzanr(33, 128);
    private final zzanr zzi = new zzanr(34, 128);
    private final zzanr zzj = new zzanr(39, 128);
    private final zzanr zzk = new zzanr(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzen zzn = new zzen();

    public zzani(zzaod zzaodVar, String str) {
        this.zza = zzaodVar;
    }

    private final void zzg(byte[] bArr, int i, int i2) {
        this.zzd.zzb(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    private final void zzh(long j, int i, int i2, long j2) {
        this.zzd.zzd(j, i, i2, j2, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i2);
            this.zzh.zzc(i2);
            this.zzi.zzc(i2);
        }
        this.zzj.zzc(i2);
        this.zzk.zzc(i2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        int i;
        int i2;
        zzdd.zzb(this.zzc);
        String str = zzex.zza;
        while (zzenVar.zza() > 0) {
            int iZzc = zzenVar.zzc();
            int iZzd = zzenVar.zzd();
            byte[] bArrZzN = zzenVar.zzN();
            this.zzl += (long) zzenVar.zza();
            this.zzc.zzr(zzenVar, zzenVar.zza());
            while (iZzc < iZzd) {
                int iZza = zzfv.zza(bArrZzN, iZzc, iZzd, this.zzf);
                if (iZza == iZzd) {
                    zzg(bArrZzN, iZzc, iZzd);
                    return;
                }
                int i3 = bArrZzN[iZza + 3] & 126;
                if (iZza > 0) {
                    int i4 = iZza - 1;
                    if (bArrZzN[i4] == 0) {
                        i2 = 4;
                        i = i4;
                    } else {
                        i = iZza;
                        i2 = 3;
                    }
                } else {
                    i = iZza;
                    i2 = 3;
                }
                int i5 = i - iZzc;
                if (i5 > 0) {
                    zzg(bArrZzN, iZzc, i);
                }
                int i6 = iZzd - i;
                long j = this.zzl - ((long) i6);
                zzf(j, i6, i5 < 0 ? -i5 : 0, this.zzm);
                zzh(j, i6, i3 >> 1, this.zzm);
                iZzc = i + i2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzb = zzaonVar.zzb();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 2);
        this.zzc = zzafbVarZzw;
        this.zzd = new zzanh(zzafbVarZzw);
        this.zza.zzd(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzc);
        String str = zzex.zza;
        if (z) {
            this.zza.zze();
            zzf(this.zzl, 0, 0, this.zzm);
            zzh(this.zzl, 0, 48, this.zzm);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfv.zzi(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        this.zza.zzb();
        zzanh zzanhVar = this.zzd;
        if (zzanhVar != null) {
            zzanhVar.zzc();
        }
    }

    private final void zzf(long j, int i, int i2, long j2) {
        this.zzd.zza(j, i, this.zze);
        if (!this.zze) {
            zzanr zzanrVar = this.zzg;
            zzanrVar.zzd(i2);
            zzanr zzanrVar2 = this.zzh;
            zzanrVar2.zzd(i2);
            zzanr zzanrVar3 = this.zzi;
            zzanrVar3.zzd(i2);
            if (zzanrVar.zze() && zzanrVar2.zze() && zzanrVar3.zze()) {
                String str = this.zzb;
                int i3 = zzanrVar.zzb;
                byte[] bArr = new byte[zzanrVar2.zzb + i3 + zzanrVar3.zzb];
                System.arraycopy(zzanrVar.zza, 0, bArr, 0, i3);
                System.arraycopy(zzanrVar2.zza, 0, bArr, zzanrVar.zzb, zzanrVar2.zzb);
                System.arraycopy(zzanrVar3.zza, 0, bArr, zzanrVar.zzb + zzanrVar2.zzb, zzanrVar3.zzb);
                String strZzd = null;
                zzfp zzfpVarZzd = zzfv.zzd(zzanrVar2.zza, 3, zzanrVar2.zzb, null);
                zzfk zzfkVar = zzfpVarZzd.zzb;
                if (zzfkVar != null) {
                    int i4 = zzfkVar.zzf;
                    int[] iArr = zzfkVar.zze;
                    int i5 = zzfkVar.zzd;
                    strZzd = zzdk.zzd(zzfkVar.zza, zzfkVar.zzb, zzfkVar.zzc, i5, iArr, i4);
                }
                zzx zzxVar = new zzx();
                zzxVar.zzS(str);
                zzxVar.zzG("video/mp2t");
                zzxVar.zzah(JrbhsraGtto.eUYiHITzVqcQ);
                zzxVar.zzE(strZzd);
                zzxVar.zzam(zzfpVarZzd.zze);
                zzxVar.zzQ(zzfpVarZzd.zzf);
                zzxVar.zzK(zzfpVarZzd.zzg);
                zzxVar.zzJ(zzfpVarZzd.zzh);
                zzi zziVar = new zzi();
                zziVar.zzc(zzfpVarZzd.zzk);
                zziVar.zzb(zzfpVarZzd.zzl);
                zziVar.zzd(zzfpVarZzd.zzm);
                zziVar.zzf(zzfpVarZzd.zzc + 8);
                zziVar.zza(zzfpVarZzd.zzd + 8);
                zzxVar.zzF(zziVar.zzg());
                zzxVar.zzad(zzfpVarZzd.zzi);
                zzxVar.zzY(zzfpVarZzd.zzj);
                zzxVar.zzZ(zzfpVarZzd.zza + 1);
                zzxVar.zzT(Collections.singletonList(bArr));
                zzz zzzVarZzan = zzxVar.zzan();
                this.zzc.zzm(zzzVarZzan);
                int i6 = zzzVarZzan.zzq;
                zzfvp.zzl(i6 != -1);
                this.zza.zzf(i6);
                this.zze = true;
            }
        }
        zzanr zzanrVar4 = this.zzj;
        if (zzanrVar4.zzd(i2)) {
            int iZzc = zzfv.zzc(zzanrVar4.zza, zzanrVar4.zzb);
            zzen zzenVar = this.zzn;
            zzenVar.zzJ(zzanrVar4.zza, iZzc);
            zzenVar.zzM(5);
            this.zza.zzc(j2, zzenVar);
        }
        zzanr zzanrVar5 = this.zzk;
        if (zzanrVar5.zzd(i2)) {
            int iZzc2 = zzfv.zzc(zzanrVar5.zza, zzanrVar5.zzb);
            zzen zzenVar2 = this.zzn;
            zzenVar2.zzJ(zzanrVar5.zza, iZzc2);
            zzenVar2.zzM(5);
            this.zza.zzc(j2, zzenVar2);
        }
    }
}
