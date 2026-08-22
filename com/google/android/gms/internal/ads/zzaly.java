package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaly implements zzakt {
    private final zzen zza = new zzen();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaly(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = "sans-serif";
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzex.zzC(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.zzg = i;
        boolean z = (bArr[0] & 32) != 0;
        this.zzb = z;
        if (z) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            int i7 = i & 1;
            int i8 = i & 2;
            boolean z = true;
            if (i7 != 0) {
                if (i8 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                    z = false;
                }
            } else if (i8 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            } else {
                z = false;
            }
            if ((i & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            } else {
                if (i7 != 0 || z) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        String strZzB;
        int i3;
        int i4;
        int length;
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i + i2);
        zzenVar.zzL(i);
        int i5 = 1;
        int i6 = 0;
        int i7 = 2;
        zzdd.zzd(zzenVar.zza() >= 2);
        int iZzq = zzenVar.zzq();
        if (iZzq == 0) {
            strZzB = "";
        } else {
            int iZzc = zzenVar.zzc();
            Charset charsetZzC = zzenVar.zzC();
            int iZzc2 = zzenVar.zzc() - iZzc;
            if (charsetZzC == null) {
                charsetZzC = StandardCharsets.UTF_8;
            }
            strZzB = zzenVar.zzB(iZzq - iZzc2, charsetZzC);
        }
        if (strZzB.isEmpty()) {
            zzdnVar.zza(new zzakl(zzfyq.zzn(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strZzB);
        int i8 = this.zzc;
        zzc(spannableStringBuilder, i8, 0, 0, spannableStringBuilder.length(), 16711680);
        int i9 = this.zzd;
        zzb(spannableStringBuilder, i9, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.zze;
        int length2 = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fMax = this.zzf;
        while (zzenVar.zza() >= 8) {
            int iZzc3 = zzenVar.zzc();
            int iZzg = zzenVar.zzg();
            int iZzg2 = zzenVar.zzg();
            if (iZzg2 == 1937013100) {
                zzdd.zzd(zzenVar.zza() >= i7 ? i5 : i6);
                int iZzq2 = zzenVar.zzq();
                int i10 = i6;
                while (i10 < iZzq2) {
                    zzdd.zzd(zzenVar.zza() >= 12 ? i5 : i6);
                    int iZzq3 = zzenVar.zzq();
                    int iZzq4 = zzenVar.zzq();
                    zzenVar.zzM(i7);
                    int iZzm = zzenVar.zzm();
                    zzenVar.zzM(i5);
                    int iZzg3 = zzenVar.zzg();
                    if (iZzq4 > spannableStringBuilder.length()) {
                        zzea.zzf("Tx3gParser", "Truncating styl end (" + iZzq4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                        length = spannableStringBuilder.length();
                    } else {
                        length = iZzq4;
                    }
                    if (iZzq3 >= length) {
                        zzea.zzf("Tx3gParser", "Ignoring styl with start (" + iZzq3 + ") >= end (" + length + ").");
                    } else {
                        int i11 = length;
                        zzc(spannableStringBuilder, iZzm, i8, iZzq3, i11, 0);
                        zzb(spannableStringBuilder, iZzg3, i9, iZzq3, i11, 0);
                    }
                    i10++;
                    iZzq2 = iZzq2;
                    i5 = 1;
                    i6 = 0;
                    i7 = 2;
                }
                i3 = i5;
                i4 = i7;
            } else {
                i3 = i5;
                if (iZzg2 == 1952608120 && this.zzb) {
                    i4 = 2;
                    zzdd.zzd(zzenVar.zza() >= 2 ? i3 : 0);
                    float fZzq = zzenVar.zzq();
                    int i12 = this.zzg;
                    String str2 = zzex.zza;
                    fMax = Math.max(0.0f, Math.min(fZzq / i12, 0.95f));
                } else {
                    i4 = 2;
                }
            }
            zzenVar.zzL(iZzc3 + iZzg);
            i5 = i3;
            i7 = i4;
            i6 = 0;
        }
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzl(spannableStringBuilder);
        zzcsVar.zze(fMax, 0);
        zzcsVar.zzf(0);
        zzdnVar.zza(new zzakl(zzfyq.zzo(zzcsVar.zzq()), -9223372036854775807L, -9223372036854775807L));
    }
}
