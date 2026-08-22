package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* JADX INFO: loaded from: classes.dex */
public final class zzael {
    private final zzen zza = new zzen(10);

    public final zzav zza(zzadw zzadwVar, zzahc zzahcVar) {
        zzav zzavVarZza = null;
        int i = 0;
        while (true) {
            try {
                zzen zzenVar = this.zza;
                zzadwVar.zzh(zzenVar.zzN(), 0, 10);
                zzenVar.zzL(0);
                if (zzenVar.zzo() != 4801587) {
                    break;
                }
                zzenVar.zzM(3);
                int iZzl = zzenVar.zzl();
                int i2 = iZzl + 10;
                if (zzavVarZza == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(zzenVar.zzN(), 0, bArr, 0, 10);
                    zzadwVar.zzh(bArr, 10, iZzl);
                    zzavVarZza = zzahe.zza(bArr, i2, zzahcVar, new zzagq());
                } else {
                    zzadwVar.zzg(iZzl);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzadwVar.zzj();
        zzadwVar.zzg(i);
        return zzavVarZza;
    }
}
