package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzamq implements zzadv {
    private final zzamr zza = new zzamr(null, 0, "audio/ac3");
    private final zzen zzb = new zzen(2786);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) {
        zzen zzenVar = this.zzb;
        int iZza = zzadwVar.zza(zzenVar.zzN(), 0, 2786);
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
        zzen zzenVar = new zzen(10);
        int i = 0;
        while (true) {
            zzadl zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 10, false);
            zzenVar.zzL(0);
            if (zzenVar.zzo() != 4801587) {
                break;
            }
            zzenVar.zzM(3);
            int iZzl = zzenVar.zzl();
            i += iZzl + 10;
            zzadlVar.zzl(iZzl, false);
        }
        zzadwVar.zzj();
        zzadl zzadlVar2 = (zzadl) zzadwVar;
        zzadlVar2.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzadlVar2.zzm(zzenVar.zzN(), 0, 6, false);
            zzenVar.zzL(0);
            if (zzenVar.zzq() != 2935) {
                zzadwVar.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzadlVar2.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iZzb = zzacu.zzb(zzenVar.zzN());
                if (iZzb == -1) {
                    return false;
                }
                zzadlVar2.zzl(iZzb - 6, false);
            }
        }
    }
}
