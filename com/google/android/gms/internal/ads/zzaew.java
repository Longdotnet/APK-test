package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaew implements zzadv {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzady zzf;
    private zzafb zzg;

    public zzaew(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        int i = this.zze;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzafb zzafbVar = this.zzg;
        zzafbVar.getClass();
        int iZzf = zzafbVar.zzf(zzadwVar, 1024, true);
        if (iZzf == -1) {
            this.zze = 2;
            this.zzg.zzt(0L, 1, this.zzd, 0, null);
            this.zzd = 0;
        } else {
            this.zzd += iZzf;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        this.zzf = zzadyVar;
        zzafb zzafbVarZzw = zzadyVar.zzw(1024, 4);
        this.zzg = zzafbVarZzw;
        zzx zzxVar = new zzx();
        String str = this.zzc;
        zzxVar.zzG(str);
        zzxVar.zzah(str);
        zzafbVarZzw.zzm(zzxVar.zzan());
        this.zzf.zzG();
        this.zzf.zzP(new zzaex(-9223372036854775807L));
        this.zze = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        int i = this.zza;
        zzdd.zzf((i == -1 || this.zzb == -1) ? false : true);
        int i2 = this.zzb;
        zzen zzenVar = new zzen(i2);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, i2, false);
        return zzenVar.zzq() == i;
    }
}
