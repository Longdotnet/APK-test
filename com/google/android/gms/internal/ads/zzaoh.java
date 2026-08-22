package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaoh implements zzaoa {
    final /* synthetic */ zzaoj zza;
    private final zzem zzb;

    public zzaoh(zzaoj zzaojVar) {
        Objects.requireNonNull(zzaojVar);
        this.zza = zzaojVar;
        this.zzb = new zzem(new byte[4], 4);
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        if (zzenVar.zzm() == 0 && (zzenVar.zzm() & 128) != 0) {
            zzenVar.zzM(6);
            int iZza = zzenVar.zza() / 4;
            for (int i = 0; i < iZza; i++) {
                zzem zzemVar = this.zzb;
                zzenVar.zzG(zzemVar, 4);
                int iZzd = zzemVar.zzd(16);
                zzemVar.zzn(3);
                if (iZzd == 0) {
                    zzemVar.zzn(13);
                } else {
                    int iZzd2 = zzemVar.zzd(13);
                    zzaoj zzaojVar = this.zza;
                    if (zzaojVar.zzg.get(iZzd2) == null) {
                        zzaojVar.zzg.put(iZzd2, new zzaob(new zzaoi(zzaojVar, iZzd2)));
                        zzaojVar.zzm++;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
    }
}
