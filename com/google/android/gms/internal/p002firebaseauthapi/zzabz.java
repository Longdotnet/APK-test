package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzabz extends zzaby {
    protected final byte[] zza;

    public zzabz(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacc) || zzd() != ((zzacc) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzabz)) {
            return obj.equals(this);
        }
        zzabz zzabzVar = (zzabz) obj;
        int iZzm = zzm();
        int iZzm2 = zzabzVar.zzm();
        if (iZzm != 0 && iZzm2 != 0 && iZzm != iZzm2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzabzVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzabzVar.zzd()) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZzd, zzabzVar.zzd(), "Ran off end of other: 0, ", ", "));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzabzVar.zza;
        zzabzVar.zzc();
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final int zzf(int i, int i2, int i3) {
        return zzadl.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final zzacc zzg(int i, int i2) {
        int iZzl = zzacc.zzl(0, i2, zzd());
        return iZzl == 0 ? zzacc.zzb : new zzabw(this.zza, 0, iZzl);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final zzacg zzh() {
        return zzacg.zzu(this.zza, 0, zzd(), true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final void zzj(zzabs zzabsVar) {
        zzabsVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final boolean zzk() {
        return zzagc.zzf(this.zza, 0, zzd());
    }
}
