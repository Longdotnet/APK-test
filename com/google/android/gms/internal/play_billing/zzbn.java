package com.google.android.gms.internal.play_billing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzbn extends zzbm {
    protected final byte[] zza;

    public zzbn(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbq) || zzd() != ((zzbq) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzbn)) {
            return obj.equals(this);
        }
        zzbn zzbnVar = (zzbn) obj;
        int iZzk = zzk();
        int iZzk2 = zzbnVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzbnVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzbnVar.zzd()) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZzd, zzbnVar.zzd(), "Ran off end of other: 0, ", ", "));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzbnVar.zza;
        zzbnVar.zzc();
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

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zze(int i, int i2, int i3) {
        return zzda.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final zzbq zzf(int i, int i2) {
        int iZzj = zzbq.zzj(0, i2, zzd());
        return iZzj == 0 ? zzbq.zzb : new zzbj(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final void zzh(zzbf zzbfVar) {
        ((zzbv) zzbfVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzi() {
        return zzfu.zze(this.zza, 0, zzd());
    }
}
