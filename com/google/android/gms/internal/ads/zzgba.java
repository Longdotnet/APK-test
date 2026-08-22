package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzgba extends zzgbc {
    private zzgba(zzgay zzgayVar, Character ch) {
        super(zzgayVar, ch);
        zzfvp.zze(zzgayVar.zzf.length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    public final int zza(byte[] bArr, CharSequence charSequence) throws zzgbb {
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgay zzgayVar = this.zzb;
        if (!zzgayVar.zzd(length)) {
            throw new zzgbb(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(charSequenceZzg.length(), "Invalid input length "));
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzg.length()) {
            int i3 = i2 + 1;
            int iZzb = (zzgayVar.zzb(charSequenceZzg.charAt(i + 1)) << 12) | (zzgayVar.zzb(charSequenceZzg.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzb >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZzg.length()) {
                int i5 = i + 3;
                int iZzb2 = iZzb | (zzgayVar.zzb(charSequenceZzg.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzb2 >>> 8) & 255);
                if (i5 < charSequenceZzg.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzb2 | zzgayVar.zzb(charSequenceZzg.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    public final zzgbd zzb(zzgay zzgayVar, Character ch) {
        return new zzgba(zzgayVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    public final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzfvp.zzk(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzgay zzgayVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzgayVar.zza(i8 >>> 18));
            appendable.append(zzgayVar.zza((i8 >>> 12) & 63));
            appendable.append(zzgayVar.zza((i8 >>> 6) & 63));
            appendable.append(zzgayVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzh(appendable, bArr, i3, i2 - i3);
        }
    }

    public zzgba(String str, String str2, Character ch) {
        this(new zzgay(str, str2.toCharArray()), ch);
    }
}
