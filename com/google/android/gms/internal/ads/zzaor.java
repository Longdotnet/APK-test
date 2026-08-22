package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaor {
    private final List zza;
    private final String zzb = "video/mp2t";
    private final zzafb[] zzc;
    private final zzfz zzd;

    public zzaor(List list, String str) {
        this.zza = list;
        this.zzc = new zzafb[list.size()];
        zzfz zzfzVar = new zzfz(new zzfy() { // from class: com.google.android.gms.internal.ads.zzaoq
            @Override // com.google.android.gms.internal.ads.zzfy
            public final void zza(long j, zzen zzenVar) {
                zzadh.zzb(j, zzenVar, this.zza.zzc);
            }
        });
        this.zzd = zzfzVar;
        zzfzVar.zze(3);
    }

    public final void zzb(long j, zzen zzenVar) {
        if (zzenVar.zza() < 9) {
            return;
        }
        int iZzg = zzenVar.zzg();
        int iZzg2 = zzenVar.zzg();
        int iZzm = zzenVar.zzm();
        if (iZzg == 434 && iZzg2 == 1195456820 && iZzm == 3) {
            this.zzd.zzb(j, zzenVar);
        }
    }

    public final void zzc(zzady zzadyVar, zzaon zzaonVar) {
        int i = 0;
        while (true) {
            zzafb[] zzafbVarArr = this.zzc;
            if (i >= zzafbVarArr.length) {
                return;
            }
            zzaonVar.zzc();
            zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 3);
            zzz zzzVar = (zzz) this.zza.get(i);
            String str = zzzVar.zzo;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzdd.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzx zzxVar = new zzx();
            zzxVar.zzS(zzaonVar.zzb());
            zzxVar.zzG(this.zzb);
            zzxVar.zzah(str);
            zzxVar.zzaj(zzzVar.zze);
            zzxVar.zzW(zzzVar.zzd);
            zzxVar.zzB(zzzVar.zzL);
            zzxVar.zzT(zzzVar.zzr);
            zzafbVarZzw.zzm(zzxVar.zzan());
            zzafbVarArr[i] = zzafbVarZzw;
            i++;
        }
    }
}
