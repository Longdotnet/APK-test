package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzang implements zzamz {
    private final zzaod zza;
    private long zzf;
    private String zzh;
    private zzafb zzi;
    private zzanf zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzanr zzc = new zzanr(7, 128);
    private final zzanr zzd = new zzanr(8, 128);
    private final zzanr zze = new zzanr(6, 128);
    private long zzl = -9223372036854775807L;
    private final zzen zzn = new zzen();

    public zzang(zzaod zzaodVar, boolean z, boolean z2, String str) {
        this.zza = zzaodVar;
    }

    private final void zzf(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzanr zzanrVar = this.zzc;
            zzanrVar.zzd(i2);
            zzanr zzanrVar2 = this.zzd;
            zzanrVar2.zzd(i2);
            if (this.zzk) {
                if (zzanrVar.zze()) {
                    zzfu zzfuVarZzg = zzfv.zzg(zzanrVar.zza, 4, zzanrVar.zzb);
                    this.zza.zzf(zzfuVarZzg.zzm);
                    this.zzj.zzb(zzfuVarZzg);
                    zzanrVar.zzb();
                } else if (zzanrVar2.zze()) {
                    this.zzj.zza(zzfv.zzf(zzanrVar2.zza, 4, zzanrVar2.zzb));
                    zzanrVar2.zzb();
                }
            } else if (zzanrVar.zze() && zzanrVar2.zze()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzanrVar.zza, zzanrVar.zzb));
                arrayList.add(Arrays.copyOf(zzanrVar2.zza, zzanrVar2.zzb));
                zzfu zzfuVarZzg2 = zzfv.zzg(zzanrVar.zza, 4, zzanrVar.zzb);
                zzft zzftVarZzf = zzfv.zzf(zzanrVar2.zza, 4, zzanrVar2.zzb);
                String strZzc = zzdk.zzc(zzfuVarZzg2.zza, zzfuVarZzg2.zzb, zzfuVarZzg2.zzc);
                zzafb zzafbVar = this.zzi;
                zzx zzxVar = new zzx();
                zzxVar.zzS(this.zzh);
                zzxVar.zzG(this.zzb);
                zzxVar.zzah("video/avc");
                zzxVar.zzE(strZzc);
                zzxVar.zzam(zzfuVarZzg2.zze);
                zzxVar.zzQ(zzfuVarZzg2.zzf);
                zzi zziVar = new zzi();
                zziVar.zzc(zzfuVarZzg2.zzj);
                zziVar.zzb(zzfuVarZzg2.zzk);
                zziVar.zzd(zzfuVarZzg2.zzl);
                zziVar.zzf(zzfuVarZzg2.zzh + 8);
                zziVar.zza(zzfuVarZzg2.zzi + 8);
                zzxVar.zzF(zziVar.zzg());
                zzxVar.zzad(zzfuVarZzg2.zzg);
                zzxVar.zzT(arrayList);
                int i3 = zzfuVarZzg2.zzm;
                zzxVar.zzY(i3);
                zzafbVar.zzm(zzxVar.zzan());
                this.zzk = true;
                this.zza.zzf(i3);
                this.zzj.zzb(zzfuVarZzg2);
                this.zzj.zza(zzftVarZzf);
                zzanrVar.zzb();
                zzanrVar2.zzb();
            }
        }
        zzanr zzanrVar3 = this.zze;
        if (zzanrVar3.zzd(i2)) {
            int iZzc = zzfv.zzc(zzanrVar3.zza, zzanrVar3.zzb);
            zzen zzenVar = this.zzn;
            zzenVar.zzJ(zzanrVar3.zza, iZzc);
            zzenVar.zzL(4);
            this.zza.zzc(j2, zzenVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }

    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zza(bArr, i, i2);
            this.zzd.zza(bArr, i, i2);
        }
        this.zze.zza(bArr, i, i2);
    }

    private final void zzh(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0045  */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        int i;
        int i2;
        zzdd.zzb(this.zzi);
        String str = zzex.zza;
        int iZzc = zzenVar.zzc();
        int iZzd = zzenVar.zzd();
        byte[] bArrZzN = zzenVar.zzN();
        this.zzf += (long) zzenVar.zza();
        this.zzi.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int iZza = zzfv.zza(bArrZzN, iZzc, iZzd, this.zzg);
            if (iZza == iZzd) {
                zzg(bArrZzN, iZzc, iZzd);
                return;
            }
            int i3 = bArrZzN[iZza + 3] & 31;
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
            long j = this.zzf - ((long) i6);
            zzf(j, i6, i5 < 0 ? -i5 : 0, this.zzl);
            zzh(j, i3, this.zzl);
            iZzc = i + i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzh = zzaonVar.zzb();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 2);
        this.zzi = zzafbVarZzw;
        this.zzj = new zzanf(zzafbVarZzw, false, false);
        this.zza.zzd(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzi);
        String str = zzex.zza;
        if (z) {
            this.zza.zze();
            zzf(this.zzf, 0, 0, this.zzl);
            zzh(this.zzf, 9, this.zzl);
            zzf(this.zzf, 0, 0, this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzfv.zzi(this.zzg);
        this.zzc.zzb();
        this.zzd.zzb();
        this.zze.zzb();
        this.zza.zzb();
        zzanf zzanfVar = this.zzj;
        if (zzanfVar != null) {
            zzanfVar.zzc();
        }
    }
}
