package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaov implements zzadv {
    private zzady zza;
    private zzafb zzb;
    private zzaot zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    /* JADX WARN: Code duplicated, block: B:47:0x00f2  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        int i;
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        int i2 = this.zzc;
        int iZzn = 4;
        if (i2 == 0) {
            zzdd.zzf(zzadwVar.zzf() == 0);
            int i3 = this.zzf;
            if (i3 != -1) {
                zzadwVar.zzk(i3);
                this.zzc = 4;
            } else {
                if (!zzaoy.zzc(zzadwVar)) {
                    throw zzaz.zza("Unsupported or unrecognized wav file type.", null);
                }
                zzadwVar.zzk((int) (zzadwVar.zze() - zzadwVar.zzf()));
                this.zzc = 1;
            }
            return 0;
        }
        long jZzr = -1;
        if (i2 == 1) {
            zzen zzenVar = new zzen(8);
            zzaox zzaoxVarZza = zzaox.zza(zzadwVar, zzenVar);
            if (zzaoxVarZza.zza != 1685272116) {
                zzadwVar.zzj();
            } else {
                zzadwVar.zzg(8);
                zzenVar.zzL(0);
                zzadwVar.zzh(zzenVar.zzN(), 0, 8);
                jZzr = zzenVar.zzr();
                zzadwVar.zzk(((int) zzaoxVarZza.zzb) + 8);
            }
            this.zzd = jZzr;
            this.zzc = 2;
            return 0;
        }
        if (i2 == 2) {
            zzaow zzaowVarZzb = zzaoy.zzb(zzadwVar);
            int i4 = zzaowVarZzb.zza;
            if (i4 == 17) {
                this.zze = new zzaos(this.zza, this.zzb, zzaowVarZzb);
            } else if (i4 == 6) {
                this.zze = new zzaou(this.zza, this.zzb, zzaowVarZzb, "audio/g711-alaw", -1);
            } else if (i4 == 7) {
                this.zze = new zzaou(this.zza, this.zzb, zzaowVarZzb, "audio/g711-mlaw", -1);
            } else {
                int i5 = zzaowVarZzb.zze;
                if (i4 == 1) {
                    iZzn = zzex.zzn(i5, ByteOrder.LITTLE_ENDIAN);
                    i = iZzn;
                } else {
                    if (i4 != 3) {
                        if (i4 == 65534) {
                            iZzn = zzex.zzn(i5, ByteOrder.LITTLE_ENDIAN);
                            i = iZzn;
                        }
                    } else if (i5 == 32) {
                        i = iZzn;
                    }
                    i = 0;
                }
                if (i == 0) {
                    throw zzaz.zzc("Unsupported WAV format type: " + i4);
                }
                this.zze = new zzaou(this.zza, this.zzb, zzaowVarZzb, "audio/raw", i);
            }
            this.zzc = 3;
            return 0;
        }
        if (i2 != 3) {
            zzdd.zzf(this.zzg != -1);
            long jZzf = this.zzg - zzadwVar.zzf();
            zzaot zzaotVar = this.zze;
            zzaotVar.getClass();
            return zzaotVar.zzc(zzadwVar, jZzf) ? -1 : 0;
        }
        Pair pairZza = zzaoy.zza(zzadwVar);
        this.zzf = ((Long) pairZza.first).intValue();
        long jLongValue = ((Long) pairZza.second).longValue();
        long j = this.zzd;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzf) + jLongValue;
        this.zzg = j2;
        long jZzd = zzadwVar.zzd();
        if (jZzd != -1 && j2 > jZzd) {
            zzea.zzf("WavExtractor", "Data exceeds input length: " + j2 + ", " + jZzd);
            this.zzg = jZzd;
            j2 = jZzd;
        }
        zzaot zzaotVar2 = this.zze;
        zzaotVar2.getClass();
        zzaotVar2.zza(this.zzf, j2);
        this.zzc = 4;
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
        this.zza = zzadyVar;
        this.zzb = zzadyVar.zzw(0, 1);
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzaot zzaotVar = this.zze;
        if (zzaotVar != null) {
            zzaotVar.zzb(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        return zzaoy.zzc(zzadwVar);
    }
}
