package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzamy implements zzamz {
    private final List zza;
    private final zzafb[] zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private final String zzb = "video/mp2t";
    private long zzg = -9223372036854775807L;

    public zzamy(List list, String str) {
        this.zza = list;
        this.zzc = new zzafb[list.size()];
    }

    private final boolean zzf(zzen zzenVar, int i) {
        if (zzenVar.zza() == 0) {
            return false;
        }
        if (zzenVar.zzm() != i) {
            this.zzd = false;
        }
        this.zze--;
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        if (this.zzd) {
            if (this.zze != 2 || zzf(zzenVar, 32)) {
                if (this.zze != 1 || zzf(zzenVar, 0)) {
                    int iZzc = zzenVar.zzc();
                    int iZza = zzenVar.zza();
                    for (zzafb zzafbVar : this.zzc) {
                        zzenVar.zzL(iZzc);
                        zzafbVar.zzr(zzenVar, iZza);
                    }
                    this.zzf += iZza;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        int i = 0;
        while (true) {
            zzafb[] zzafbVarArr = this.zzc;
            if (i >= zzafbVarArr.length) {
                return;
            }
            zzaok zzaokVar = (zzaok) this.zza.get(i);
            zzaonVar.zzc();
            zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 3);
            zzx zzxVar = new zzx();
            zzxVar.zzS(zzaonVar.zzb());
            zzxVar.zzG(this.zzb);
            zzxVar.zzah("application/dvbsubs");
            zzxVar.zzT(Collections.singletonList(zzaokVar.zzb));
            zzxVar.zzW(zzaokVar.zza);
            zzafbVarZzw.zzm(zzxVar.zzan());
            zzafbVarArr[i] = zzafbVarZzw;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        if (this.zzd) {
            zzdd.zzf(this.zzg != -9223372036854775807L);
            for (zzafb zzafbVar : this.zzc) {
                zzafbVar.zzt(this.zzg, 1, this.zzf, 0, null);
            }
            this.zzd = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zzg = j;
        this.zzf = 0;
        this.zze = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzd = false;
        this.zzg = -9223372036854775807L;
    }
}
