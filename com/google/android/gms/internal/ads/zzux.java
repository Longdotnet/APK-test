package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzux implements zzgj {
    private final zzgj zza;
    private final int zzb;
    private final zzuw zzc;
    private final byte[] zzd;
    private int zze;

    public zzux(zzgj zzgjVar, int i, zzuw zzuwVar) {
        zzdd.zzd(i > 0);
        this.zza = zzgjVar;
        this.zzb = i;
        this.zzc = zzuwVar;
        this.zzd = new byte[1];
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        int i3 = this.zze;
        if (i3 == 0) {
            zzgj zzgjVar = this.zza;
            byte[] bArr2 = this.zzd;
            int i4 = 0;
            if (zzgjVar.zza(bArr2, 0, 1) != -1) {
                int i5 = (bArr2[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr3 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int iZza = zzgjVar.zza(bArr3, i4, i6);
                        if (iZza != -1) {
                            i4 += iZza;
                            i6 -= iZza;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr3[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.zzc.zza(new zzen(bArr3, i5));
                    }
                }
                i3 = this.zzb;
                this.zze = i3;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i, Math.min(i3, i2));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
        zzhjVar.getClass();
        this.zza.zzf(zzhjVar);
    }
}
