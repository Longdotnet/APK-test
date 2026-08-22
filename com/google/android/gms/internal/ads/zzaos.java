package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
final class zzaos implements zzaot {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, TossType.TOSS_SPOTLIGHT_VALUE, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzady zzc;
    private final zzafb zzd;
    private final zzaow zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzen zzh;
    private final int zzi;
    private final zzz zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long jZzu = this.zzl + zzex.zzu(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZze = zze(i);
        this.zzd.zzt(jZzu, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zza(int i, long j) {
        zzaoz zzaozVar = new zzaoz(this.zze, this.zzf, i, j);
        this.zzc.zzP(zzaozVar);
        zzafb zzafbVar = this.zzd;
        zzafbVar.zzm(this.zzj);
        zzafbVar.zzl(zzaozVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040 A[LOOP:0: B:6:0x0025->B:12:0x0040, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    /* JADX WARN: Code duplicated, block: B:9:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003d -> B:4:0x0022). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.android.gms.internal.ads.zzaot
    public final boolean zzc(com.google.android.gms.internal.ads.zzadw r27, long r28) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaos.zzc(com.google.android.gms.internal.ads.zzadw, long):boolean");
    }

    public zzaos(zzady zzadyVar, zzafb zzafbVar, zzaow zzaowVar) throws zzaz {
        this.zzc = zzadyVar;
        this.zzd = zzafbVar;
        this.zze = zzaowVar;
        int iMax = Math.max(1, zzaowVar.zzc / 10);
        this.zzi = iMax;
        zzen zzenVar = new zzen(zzaowVar.zzf);
        zzenVar.zzk();
        int iZzk = zzenVar.zzk();
        this.zzf = iZzk;
        int i = zzaowVar.zzb;
        int i2 = zzaowVar.zzd;
        int iM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(i2 - (i * 4), 8, zzaowVar.zze * i, 1);
        if (iZzk == iM$1) {
            String str = zzex.zza;
            int i3 = ((iMax + iZzk) - 1) / iZzk;
            this.zzg = new byte[i2 * i3];
            this.zzh = new zzen((iZzk + iZzk) * i * i3);
            int i4 = ((zzaowVar.zzc * zzaowVar.zzd) * 8) / iZzk;
            zzx zzxVar = new zzx();
            zzxVar.zzah("audio/raw");
            zzxVar.zzC(i4);
            zzxVar.zzac(i4);
            zzxVar.zzX((iMax + iMax) * i);
            zzxVar.zzD(zzaowVar.zzb);
            zzxVar.zzai(zzaowVar.zzc);
            zzxVar.zzab(2);
            this.zzj = zzxVar.zzan();
            return;
        }
        throw zzaz.zza("Expected frames per block: " + iM$1 + iafHZUfOuHNwvy.bdbaBNXWkIkMca + iZzk, null);
    }
}
