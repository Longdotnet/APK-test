package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class zzjb extends zzja {
    protected final byte[] zza;

    public zzjb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzje) || zzd() != ((zzje) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return obj.equals(this);
        }
        zzjb zzjbVar = (zzjb) obj;
        int iZzk = zzk();
        int iZzk2 = zzjbVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzjbVar.zzd()) {
            throw new IllegalArgumentException(MnHfHMYQDPUO.juHOElxtjdrc + iZzd + zzd());
        }
        if (iZzd > zzjbVar.zzd()) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZzd, zzjbVar.zzd(), "Ran off end of other: 0, ", ", "));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzjbVar.zza;
        zzjbVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final int zze(int i, int i2, int i3) {
        return zzkn.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final zzje zzf(int i, int i2) {
        int iZzj = zzje.zzj(0, i2, zzd());
        return iZzj == 0 ? zzje.zzb : new zziy(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final void zzh(zziu zziuVar) {
        ((zzjj) zziuVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean zzi() {
        return zznd.zzf(this.zza, 0, zzd());
    }
}
