package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzajz implements zzadv {
    private zzady zza;
    private zzakh zzb;
    private boolean zzc;

    private final boolean zza(zzadw zzadwVar) {
        zzakb zzakbVar = new zzakb();
        if (zzakbVar.zzb(zzadwVar, true) && (zzakbVar.zza & 2) == 2) {
            int iMin = Math.min(zzakbVar.zze, 8);
            zzen zzenVar = new zzen(iMin);
            zzadwVar.zzh(zzenVar.zzN(), 0, iMin);
            zzenVar.zzL(0);
            if (zzenVar.zza() >= 5 && zzenVar.zzm() == 127 && zzenVar.zzu() == 1179402563) {
                this.zzb = new zzajy();
            } else {
                zzenVar.zzL(0);
                try {
                    if (zzafh.zzd(1, zzenVar, true)) {
                        this.zzb = new zzakj();
                    } else {
                        zzenVar.zzL(0);
                        if (zzakd.zzd(zzenVar)) {
                            this.zzb = new zzakd();
                        }
                    }
                } catch (zzaz unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        zzdd.zzb(this.zza);
        if (this.zzb == null) {
            if (!zza(zzadwVar)) {
                throw zzaz.zza("Failed to determine bitstream type", null);
            }
            zzadwVar.zzj();
        }
        if (!this.zzc) {
            zzafb zzafbVarZzw = this.zza.zzw(0, 1);
            this.zza.zzG();
            this.zzb.zzh(this.zza, zzafbVarZzw);
            this.zzc = true;
        }
        return this.zzb.zze(zzadwVar, zzaerVar);
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
        this.zza = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        zzakh zzakhVar = this.zzb;
        if (zzakhVar != null) {
            zzakhVar.zzj(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        try {
            return zza(zzadwVar);
        } catch (zzaz unused) {
            return false;
        }
    }
}
