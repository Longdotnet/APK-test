package com.google.android.gms.internal.ads;

import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;

/* JADX INFO: loaded from: classes2.dex */
public final class zzans implements zzaoa {
    private zzz zza;
    private zzeu zzb;
    private zzafb zzc;

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        long jZze = this.zzb.zze();
        long jZzf = this.zzb.zzf();
        if (jZze == -9223372036854775807L || jZzf == -9223372036854775807L) {
            return;
        }
        zzz zzzVar = this.zza;
        if (jZzf != zzzVar.zzt) {
            zzx zzxVarZzb = zzzVar.zzb();
            zzxVarZzb.zzal(jZzf);
            zzz zzzVarZzan = zzxVarZzb.zzan();
            this.zza = zzzVarZzan;
            this.zzc.zzm(zzzVarZzan);
        }
        int iZza = zzenVar.zza();
        this.zzc.zzr(zzenVar, iZza);
        this.zzc.zzt(jZze, 1, iZza, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zzb = zzeuVar;
        zzaonVar.zzc();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 5);
        this.zzc = zzafbVarZzw;
        zzafbVarZzw.zzm(this.zza);
    }

    public zzans(String str, String str2) {
        zzx zzxVar = new zzx();
        zzxVar.zzG(FETmZwrVHuasmL.QashofalJJX);
        zzxVar.zzah(str);
        this.zza = zzxVar.zzan();
    }
}
