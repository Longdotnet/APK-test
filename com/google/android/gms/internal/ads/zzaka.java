package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzaka {
    private final zzakb zza = new zzakb();
    private final zzen zzb = new zzen(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzakb zzakbVar = this.zza;
            if (i5 >= zzakbVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzakbVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzen zza() {
        return this.zzb;
    }

    public final zzakb zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzI(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzen zzenVar = this.zzb;
        if (zzenVar.zzN().length == 65025) {
            return;
        }
        zzenVar.zzJ(Arrays.copyOf(zzenVar.zzN(), Math.max(65025, zzenVar.zzd())), zzenVar.zzd());
    }

    public final boolean zze(zzadw zzadwVar) {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzI(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                zzakb zzakbVar = this.zza;
                if (!zzakbVar.zzc(zzadwVar, -1L) || !zzakbVar.zzb(zzadwVar, true)) {
                    return false;
                }
                int iZzf = zzakbVar.zzd;
                if ((zzakbVar.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    iZzf += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzadz.zzf(zzadwVar, iZzf)) {
                    return false;
                }
                this.zzc = i;
            }
            int iZzf2 = zzf(i);
            int i2 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzen zzenVar = this.zzb;
                zzenVar.zzF(zzenVar.zzd() + iZzf2);
                if (!zzadz.zze(zzadwVar, zzenVar.zzN(), zzenVar.zzd(), iZzf2)) {
                    return false;
                }
                zzenVar.zzK(zzenVar.zzd() + iZzf2);
                this.zze = this.zza.zzf[i2 + (-1)] != 255;
            }
            if (i2 == this.zza.zzc) {
                i2 = -1;
            }
            this.zzc = i2;
        }
    }
}
