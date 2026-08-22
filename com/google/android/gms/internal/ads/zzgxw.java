package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzgxw extends zzgxv {
    protected final byte[] zza;

    public zzgxw(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgxz) || zzd() != ((zzgxz) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgxw)) {
            return obj.equals(this);
        }
        zzgxw zzgxwVar = (zzgxw) obj;
        int iZzr = zzr();
        int iZzr2 = zzgxwVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgxwVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    public final boolean zzg(zzgxz zzgxzVar, int i, int i2) {
        if (i2 > zzgxzVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzgxzVar.zzd()) {
            int iZzd = zzgxzVar.zzd();
            StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Ran off end of other: ", i, ", ", i2, ", ");
            sbM.append(iZzd);
            throw new IllegalArgumentException(sbM.toString());
        }
        if (!(zzgxzVar instanceof zzgxw)) {
            return zzgxzVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzgxw zzgxwVar = (zzgxw) zzgxzVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgxwVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzgxwVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzi(int i, int i2, int i3) {
        return zzgzu.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        return zzhcj.zzf(i, this.zza, iZzc, i3 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgxz zzk(int i, int i2) {
        int iZzq = zzgxz.zzq(i, i2, zzd());
        return iZzq == 0 ? zzgxz.zzb : new zzgxt(this.zza, zzc() + i, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgyf zzl() {
        return zzgyf.zzH(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final void zzo(zzgxq zzgxqVar) {
        zzgxqVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean zzp() {
        int iZzc = zzc();
        return zzhcj.zzi(this.zza, iZzc, zzd() + iZzc);
    }
}
