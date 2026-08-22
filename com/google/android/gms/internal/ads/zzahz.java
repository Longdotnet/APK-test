package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
final class zzahz {
    private final zzen zza = new zzen(8);
    private int zzb;

    private final long zzb(zzadw zzadwVar) {
        int i;
        zzen zzenVar = this.zza;
        zzadl zzadlVar = (zzadl) zzadwVar;
        int i2 = 0;
        zzadlVar.zzm(zzenVar.zzN(), 0, 1, false);
        int i3 = zzenVar.zzN()[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while (true) {
            i = i5 + 1;
            if ((i3 & i4) != 0) {
                break;
            }
            i4 >>= 1;
            i5 = i;
        }
        int i6 = i3 & (~i4);
        zzadlVar.zzm(zzenVar.zzN(), 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (zzenVar.zzN()[i2] & 255) + (i6 << 8);
        }
        this.zzb += i;
        return i6;
    }

    public final boolean zza(zzadw zzadwVar) throws EOFException, InterruptedIOException {
        long jZzd = zzadwVar.zzd();
        long j = 1024;
        if (jZzd != -1 && jZzd <= 1024) {
            j = jZzd;
        }
        zzen zzenVar = this.zza;
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
        this.zzb = 4;
        for (long jZzu = zzenVar.zzu(); jZzu != 440786851; jZzu = ((jZzu << 8) & (-256)) | ((long) (zzenVar.zzN()[0] & 255))) {
            int i = (int) j;
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzadlVar.zzm(zzenVar.zzN(), 0, 1, false);
        }
        long jZzb = zzb(zzadwVar);
        long j2 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j3 = j2 + jZzb;
            if (jZzd == -1 || j3 < jZzd) {
                while (true) {
                    long j4 = this.zzb;
                    if (j4 < j3) {
                        if (zzb(zzadwVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzadwVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i3 = (int) jZzb2;
                            zzadlVar.zzl(i3, false);
                            this.zzb += i3;
                        }
                    } else if (j4 == j3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
