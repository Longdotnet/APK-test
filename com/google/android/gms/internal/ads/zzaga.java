package com.google.android.gms.internal.ads;

import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaga implements zzadv {
    private final byte[] zza;
    private final zzen zzb;
    private final zzaeb zzc;
    private zzady zzd;
    private zzafb zze;
    private int zzf;
    private zzav zzg;
    private zzaeg zzh;
    private int zzi;
    private int zzj;
    private zzafz zzk;
    private int zzl;
    private long zzm;

    public zzaga() {
        throw null;
    }

    private final long zza(zzen zzenVar, boolean z) {
        boolean zZzc;
        this.zzh.getClass();
        int iZzc = zzenVar.zzc();
        while (iZzc <= zzenVar.zzd() - 16) {
            zzenVar.zzL(iZzc);
            zzaeg zzaegVar = this.zzh;
            int i = this.zzj;
            zzaeb zzaebVar = this.zzc;
            if (zzaec.zzc(zzenVar, zzaegVar, i, zzaebVar)) {
                zzenVar.zzL(iZzc);
                return zzaebVar.zza;
            }
            iZzc++;
        }
        if (!z) {
            zzenVar.zzL(iZzc);
            return -1L;
        }
        while (iZzc <= zzenVar.zzd() - this.zzi) {
            zzenVar.zzL(iZzc);
            try {
                zZzc = zzaec.zzc(zzenVar, this.zzh, this.zzj, this.zzc);
            } catch (IndexOutOfBoundsException unused) {
                zZzc = false;
            }
            if (zzenVar.zzc() <= zzenVar.zzd() && zZzc) {
                zzenVar.zzL(iZzc);
                return this.zzc.zza;
            }
            iZzc++;
        }
        zzenVar.zzL(zzenVar.zzd());
        return -1L;
    }

    private final void zzg() {
        long j = this.zzm * 1000000;
        zzaeg zzaegVar = this.zzh;
        String str = zzex.zza;
        this.zze.zzt(j / ((long) zzaegVar.zze), 1, this.zzl, 0, null);
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
        this.zzd = zzadyVar;
        this.zze = zzadyVar.zzw(0, 1);
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzafz zzafzVar = this.zzk;
            if (zzafzVar != null) {
                zzafzVar.zzd(j2);
            }
        }
        this.zzm = j2 != 0 ? -1L : 0L;
        this.zzl = 0;
        this.zzb.zzI(0);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        zzaed.zza(zzadwVar, false);
        zzen zzenVar = new zzen(4);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, 4, false);
        return zzenVar.zzu() == 1716281667;
    }

    public zzaga(int i) {
        this.zza = new byte[42];
        this.zzb = new zzen(new byte[32768], 0);
        this.zzc = new zzaeb();
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        boolean zZzp;
        zzaeu zzaetVar;
        boolean z;
        int i = this.zzf;
        if (i == 0) {
            zzadwVar.zzj();
            long jZze = zzadwVar.zze();
            zzav zzavVarZza = zzaed.zza(zzadwVar, true);
            zzadwVar.zzk((int) (zzadwVar.zze() - jZze));
            this.zzg = zzavVarZza;
            this.zzf = 1;
            return 0;
        }
        if (i == 1) {
            zzadwVar.zzh(this.zza, 0, 42);
            zzadwVar.zzj();
            this.zzf = 2;
            return 0;
        }
        if (i == 2) {
            zzen zzenVar = new zzen(4);
            zzadwVar.zzi(zzenVar.zzN(), 0, 4);
            if (zzenVar.zzu() != 1716281667) {
                throw zzaz.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzf = 3;
            return 0;
        }
        if (i == 3) {
            zzaeg zzaegVarZze = this.zzh;
            do {
                zzadwVar.zzj();
                zzem zzemVar = new zzem(new byte[4], 4);
                zzadwVar.zzh(zzemVar.zza, 0, 4);
                zZzp = zzemVar.zzp();
                int iZzd = zzemVar.zzd(7);
                int iZzd2 = zzemVar.zzd(24) + 4;
                if (iZzd == 0) {
                    byte[] bArr = new byte[38];
                    zzadwVar.zzi(bArr, 0, 38);
                    zzaegVarZze = new zzaeg(bArr, 4);
                } else {
                    if (zzaegVarZze == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iZzd == 3) {
                        zzen zzenVar2 = new zzen(iZzd2);
                        zzadwVar.zzi(zzenVar2.zzN(), 0, iZzd2);
                        zzaegVarZze = zzaegVarZze.zzf(zzaed.zzb(zzenVar2));
                    } else if (iZzd == 4) {
                        zzen zzenVar3 = new zzen(iZzd2);
                        zzadwVar.zzi(zzenVar3.zzN(), 0, iZzd2);
                        zzenVar3.zzM(4);
                        zzaegVarZze = zzaegVarZze.zzg(Arrays.asList(zzafh.zzc(zzenVar3, false, false).zza));
                    } else if (iZzd == 6) {
                        zzen zzenVar4 = new zzen(iZzd2);
                        zzadwVar.zzi(zzenVar4.zzN(), 0, iZzd2);
                        zzenVar4.zzM(4);
                        zzaegVarZze = zzaegVarZze.zze(zzfyq.zzo(zzagt.zzb(zzenVar4)));
                    } else {
                        zzadwVar.zzk(iZzd2);
                    }
                }
                String str = zzex.zza;
                this.zzh = zzaegVarZze;
            } while (!zZzp);
            zzaegVarZze.getClass();
            this.zzi = Math.max(zzaegVarZze.zzc, 6);
            zzz zzzVarZzc = this.zzh.zzc(this.zza, this.zzg);
            zzafb zzafbVar = this.zze;
            zzx zzxVarZzb = zzzVarZzc.zzb();
            zzxVarZzb.zzG("audio/flac");
            zzafbVar.zzm(zzxVarZzb.zzan());
            this.zze.zzl(this.zzh.zza());
            this.zzf = 4;
            return 0;
        }
        if (i == 4) {
            zzadwVar.zzj();
            zzen zzenVar5 = new zzen(2);
            zzadwVar.zzh(zzenVar5.zzN(), 0, 2);
            int iZzq = zzenVar5.zzq();
            if ((iZzq >> 2) != 16382) {
                zzadwVar.zzj();
                throw zzaz.zza(FETmZwrVHuasmL.yAYaPGyDByrt, null);
            }
            zzadwVar.zzj();
            this.zzj = iZzq;
            zzady zzadyVar = this.zzd;
            String str2 = zzex.zza;
            long jZzf = zzadwVar.zzf();
            long jZzd = zzadwVar.zzd();
            zzaeg zzaegVar = this.zzh;
            zzaegVar.getClass();
            zzaef zzaefVar = zzaegVar.zzk;
            if (zzaefVar != null && zzaefVar.zza.length > 0) {
                zzaetVar = new zzaee(zzaegVar, jZzf);
            } else if (jZzd == -1 || zzaegVar.zzj <= 0) {
                zzaetVar = new zzaet(zzaegVar.zza(), 0L);
            } else {
                zzafz zzafzVar = new zzafz(zzaegVar, this.zzj, jZzf, jZzd);
                this.zzk = zzafzVar;
                zzaetVar = zzafzVar.zzb();
            }
            zzadyVar.zzP(zzaetVar);
            this.zzf = 5;
            return 0;
        }
        this.zze.getClass();
        zzaeg zzaegVar2 = this.zzh;
        zzaegVar2.getClass();
        zzafz zzafzVar2 = this.zzk;
        if (zzafzVar2 != null && zzafzVar2.zze()) {
            return zzafzVar2.zza(zzadwVar, zzaerVar);
        }
        if (this.zzm == -1) {
            this.zzm = zzaec.zzb(zzadwVar, zzaegVar2);
            return 0;
        }
        zzen zzenVar6 = this.zzb;
        int iZzd3 = zzenVar6.zzd();
        if (iZzd3 < 32768) {
            int iZza = zzadwVar.zza(zzenVar6.zzN(), iZzd3, 32768 - iZzd3);
            z = iZza == -1;
            if (!z) {
                zzenVar6.zzK(iZzd3 + iZza);
            } else if (zzenVar6.zza() == 0) {
                zzg();
                return -1;
            }
        } else {
            z = false;
        }
        int iZzc = zzenVar6.zzc();
        int i2 = this.zzl;
        int i3 = this.zzi;
        if (i2 < i3) {
            zzenVar6.zzM(Math.min(i3 - i2, zzenVar6.zza()));
        }
        long jZza = zza(zzenVar6, z);
        int iZzc2 = zzenVar6.zzc() - iZzc;
        zzenVar6.zzL(iZzc);
        this.zze.zzr(zzenVar6, iZzc2);
        this.zzl += iZzc2;
        if (jZza != -1) {
            zzg();
            this.zzl = 0;
            this.zzm = jZza;
        }
        int length = zzenVar6.zzN().length - zzenVar6.zzd();
        if (zzenVar6.zza() >= 16 || length >= 16) {
            return 0;
        }
        int iZza2 = zzenVar6.zza();
        System.arraycopy(zzenVar6.zzN(), zzenVar6.zzc(), zzenVar6.zzN(), 0, iZza2);
        zzenVar6.zzL(0);
        zzenVar6.zzK(iZza2);
        return 0;
    }
}
