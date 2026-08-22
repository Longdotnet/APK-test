package com.google.android.gms.internal.ads;

import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class zzane implements zzamz {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaor zzb;
    private zzand zzg;
    private long zzh;
    private String zzi;
    private zzafb zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzanc zze = new zzanc(128);
    private long zzl = -9223372036854775807L;
    private final zzanr zzf = new zzanr(178, 128);
    private final zzen zzc = new zzen();

    public zzane(zzaor zzaorVar, String str) {
        this.zzb = zzaorVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzi = zzaonVar.zzb();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 2);
        this.zzj = zzafbVarZzw;
        this.zzg = new zzand(zzafbVarZzw);
        this.zzb.zzc(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        zzfv.zzi(this.zzd);
        this.zze.zzb();
        zzand zzandVar = this.zzg;
        if (zzandVar != null) {
            zzandVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        int i;
        int i2 = 3;
        zzdd.zzb(this.zzg);
        zzdd.zzb(this.zzj);
        int iZzc = zzenVar.zzc();
        int iZzd = zzenVar.zzd();
        byte[] bArrZzN = zzenVar.zzN();
        this.zzh += (long) zzenVar.zza();
        this.zzj.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int iZza = zzfv.zza(bArrZzN, iZzc, iZzd, this.zzd);
            if (iZza == iZzd) {
                break;
            }
            int i3 = iZza + 3;
            int i4 = zzenVar.zzN()[i3] & 255;
            int i5 = iZza - iZzc;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zza(bArrZzN, iZzc, iZza);
                }
                int i6 = i5 < 0 ? -i5 : 0;
                zzanc zzancVar = this.zze;
                if (zzancVar.zzc(i4, i6)) {
                    zzafb zzafbVar = this.zzj;
                    int i7 = zzancVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzancVar.zzc, zzancVar.zza);
                    zzem zzemVar = new zzem(bArrCopyOf, bArrCopyOf.length);
                    zzemVar.zzo(i7);
                    zzemVar.zzo(4);
                    zzemVar.zzm();
                    zzemVar.zzn(8);
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(4);
                        zzemVar.zzn(i2);
                    }
                    int iZzd2 = zzemVar.zzd(4);
                    float f = 1.0f;
                    if (iZzd2 == 15) {
                        int iZzd3 = zzemVar.zzd(8);
                        int iZzd4 = zzemVar.zzd(8);
                        if (iZzd4 == 0) {
                            zzea.zzf("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzd3 / iZzd4;
                        }
                    } else if (iZzd2 < 7) {
                        f = zza[iZzd2];
                    } else {
                        zzea.zzf("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(2);
                        zzemVar.zzn(1);
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(3);
                            zzemVar.zzn(11);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                        }
                    }
                    if (zzemVar.zzd(2) != 0) {
                        zzea.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzemVar.zzm();
                    int iZzd5 = zzemVar.zzd(16);
                    zzemVar.zzm();
                    if (zzemVar.zzp()) {
                        if (iZzd5 == 0) {
                            zzea.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i8 = iZzd5 - 1;
                            int i9 = 0;
                            while (i8 > 0) {
                                i8 >>= 1;
                                i9++;
                            }
                            zzemVar.zzn(i9);
                        }
                    }
                    zzemVar.zzm();
                    int iZzd6 = zzemVar.zzd(13);
                    zzemVar.zzm();
                    int iZzd7 = zzemVar.zzd(13);
                    zzemVar.zzm();
                    zzemVar.zzm();
                    zzx zzxVar = new zzx();
                    zzxVar.zzS(str);
                    zzxVar.zzG("video/mp2t");
                    zzxVar.zzah(kBfGXgdfpo.jMKqNvsYBY);
                    zzxVar.zzam(iZzd6);
                    zzxVar.zzQ(iZzd7);
                    zzxVar.zzad(f2);
                    zzxVar.zzT(Collections.singletonList(bArrCopyOf));
                    zzafbVar.zzm(zzxVar.zzan());
                    this.zzk = true;
                }
            }
            this.zzg.zza(bArrZzN, iZzc, iZza);
            zzanr zzanrVar = this.zzf;
            if (i5 > 0) {
                zzanrVar.zza(bArrZzN, iZzc, iZza);
                i = 0;
            } else {
                i = -i5;
            }
            if (zzanrVar.zzd(i)) {
                int iZzc2 = zzfv.zzc(zzanrVar.zza, zzanrVar.zzb);
                zzen zzenVar2 = this.zzc;
                String str2 = zzex.zza;
                zzenVar2.zzJ(zzanrVar.zza, iZzc2);
                this.zzb.zzb(this.zzl, zzenVar2);
            }
            if (i4 == 178) {
                if (zzenVar.zzN()[iZza + 2] == 1) {
                    zzanrVar.zzc(178);
                }
                i4 = 178;
            }
            int i10 = iZzd - iZza;
            this.zzg.zzb(this.zzh - ((long) i10), i10, this.zzk);
            this.zzg.zzc(i4, this.zzl);
            iZzc = i3;
            i2 = 3;
        }
        if (!this.zzk) {
            this.zze.zza(bArrZzN, iZzc, iZzd);
        }
        this.zzg.zza(bArrZzN, iZzc, iZzd);
        this.zzf.zza(bArrZzN, iZzc, iZzd);
    }
}
