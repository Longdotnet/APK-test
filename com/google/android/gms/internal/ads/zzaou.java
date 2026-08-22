package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzaou implements zzaot {
    private final zzady zza;
    private final zzafb zzb;
    private final zzaow zzc;
    private final zzz zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaou(zzady zzadyVar, zzafb zzafbVar, zzaow zzaowVar, String str, int i) throws zzaz {
        this.zza = zzadyVar;
        this.zzb = zzafbVar;
        this.zzc = zzaowVar;
        int i2 = zzaowVar.zzb * zzaowVar.zze;
        int i3 = zzaowVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzaz.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzaowVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzx zzxVar = new zzx();
        zzxVar.zzG("audio/wav");
        zzxVar.zzah(str);
        zzxVar.zzC(i6);
        zzxVar.zzac(i6);
        zzxVar.zzX(iMax);
        zzxVar.zzD(zzaowVar.zzb);
        zzxVar.zzai(zzaowVar.zzc);
        zzxVar.zzab(i);
        this.zzd = zzxVar.zzan();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zza(int i, long j) {
        zzaoz zzaozVar = new zzaoz(this.zzc, 1, i, j);
        this.zza.zzP(zzaozVar);
        zzafb zzafbVar = this.zzb;
        zzafbVar.zzm(this.zzd);
        zzafbVar.zzl(zzaozVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final boolean zzc(zzadw zzadwVar, long j) {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZzf = this.zzb.zzf(zzadwVar, (int) Math.min(i2 - i, j2), true);
            if (iZzf == -1) {
                j2 = 0;
            } else {
                this.zzg += iZzf;
                j2 -= (long) iZzf;
            }
        }
        zzaow zzaowVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzaowVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzu = this.zzf + zzex.zzu(this.zzh, 1000000L, zzaowVar.zzc, RoundingMode.DOWN);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzt(jZzu, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
