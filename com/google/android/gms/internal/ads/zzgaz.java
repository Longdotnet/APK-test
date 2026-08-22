package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzgaz extends zzgbc {
    final char[] zza;

    private zzgaz(zzgay zzgayVar) {
        super(zzgayVar, null);
        this.zza = new char[512];
        zzfvp.zze(zzgayVar.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzgayVar.zza(i >>> 4);
            this.zza[i | 256] = zzgayVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    public final int zza(byte[] bArr, CharSequence charSequence) throws zzgbb {
        if (charSequence.length() % 2 == 1) {
            throw new zzgbb(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(charSequence.length(), "Invalid input length "));
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zzgay zzgayVar = this.zzb;
            bArr[i2] = (byte) (zzgayVar.zzb(charSequence.charAt(i + 1)) | (zzgayVar.zzb(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    public final zzgbd zzb(zzgay zzgayVar, Character ch) {
        return new zzgaz(zzgayVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    public final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzfvp.zzk(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    public zzgaz(String str, String str2) {
        this(new zzgay("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
