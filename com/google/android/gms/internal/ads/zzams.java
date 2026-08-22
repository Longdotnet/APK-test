package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzams implements zzadv {
    private final zzamt zza = new zzamt(null, 0, "audio/ac4");
    private final zzen zzb = new zzen(16384);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        zzen zzenVar = this.zzb;
        int iZza = zzadwVar.zza(zzenVar.zzN(), 0, 16384);
        if (iZza == -1) {
            return -1;
        }
        zzenVar.zzL(0);
        zzenVar.zzK(iZza);
        if (!this.zzc) {
            this.zza.zzd(0L, 4);
            this.zzc = true;
        }
        this.zza.zza(zzenVar);
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
        this.zza.zzb(zzadyVar, new zzaon(Integer.MIN_VALUE, 0, 1));
        zzadyVar.zzG();
        zzadyVar.zzP(new zzaet(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        int i;
        zzen zzenVar = new zzen(10);
        int i2 = 0;
        while (true) {
            zzadl zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 10, false);
            zzenVar.zzL(0);
            if (zzenVar.zzo() != 4801587) {
                break;
            }
            zzenVar.zzM(3);
            int iZzl = zzenVar.zzl();
            i2 += iZzl + 10;
            zzadlVar.zzl(iZzl, false);
        }
        zzadwVar.zzj();
        zzadl zzadlVar2 = (zzadl) zzadwVar;
        zzadlVar2.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzadlVar2.zzm(zzenVar.zzN(), 0, 7, false);
            zzenVar.zzL(0);
            int iZzq = zzenVar.zzq();
            if (iZzq == 44096 || iZzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArrZzN = zzenVar.zzN();
                if (bArrZzN.length < 7) {
                    i = -1;
                } else {
                    int i6 = ((bArrZzN[2] & 255) << 8) | (bArrZzN[3] & 255);
                    if (i6 == 65535) {
                        i6 = ((bArrZzN[4] & 255) << 16) | ((bArrZzN[5] & 255) << 8) | (bArrZzN[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iZzq == 44097) {
                        i5 += 2;
                    }
                    i = i6 + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzadlVar2.zzl(i - 7, false);
            } else {
                zzadwVar.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzadlVar2.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
