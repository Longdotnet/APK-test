package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaod {
    private final List zza;
    private final zzafb[] zzc;
    private final String zzb = "video/mp2t";
    private final zzfz zzd = new zzfz(new zzfy() { // from class: com.google.android.gms.internal.ads.zzaoc
        @Override // com.google.android.gms.internal.ads.zzfy
        public final void zza(long j, zzen zzenVar) {
            zzadh.zza(j, zzenVar, this.zza.zzc);
        }
    });

    public zzaod(List list, String str) {
        this.zza = list;
        this.zzc = new zzafb[list.size()];
    }

    public final void zzb() {
        this.zzd.zzd();
    }

    public final void zzc(long j, zzen zzenVar) {
        this.zzd.zzb(j, zzenVar);
    }

    public final void zzd(zzady zzadyVar, zzaon zzaonVar) {
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
            String strZzb = zzzVar.zza;
            if (strZzb == null) {
                strZzb = zzaonVar.zzb();
            }
            zzx zzxVar = new zzx();
            zzxVar.zzS(strZzb);
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

    public final void zze() {
        this.zzd.zzd();
    }

    public final void zzf(int i) {
        this.zzd.zze(i);
    }
}
