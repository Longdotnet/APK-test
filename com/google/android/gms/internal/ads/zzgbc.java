package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class zzgbc extends zzgbd {
    private volatile zzgbd zza;
    final zzgay zzb;
    final Character zzc;

    public zzgbc(zzgay zzgayVar, Character ch) {
        this.zzb = zzgayVar;
        boolean z = true;
        if (ch != null && zzgayVar.zze('=')) {
            z = false;
        }
        zzfvp.zzi(z, DaWYVMJ.GwwzjQeGQ, ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgbc) {
            zzgbc zzgbcVar = (zzgbc) obj;
            if (this.zzb.equals(zzgbcVar.zzb) && Objects.equals(this.zzc, zzgbcVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgay zzgayVar = this.zzb;
        sb.append(zzgayVar);
        if (8 % zzgayVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public int zza(byte[] bArr, CharSequence charSequence) throws zzgbb {
        int i;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgay zzgayVar = this.zzb;
        if (!zzgayVar.zzd(length)) {
            throw new zzgbb(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(charSequenceZzg.length(), "Invalid input length "));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzg.length()) {
            long jZzb = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzgayVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzb <<= zzgayVar.zzb;
                if (i2 + i4 < charSequenceZzg.length()) {
                    jZzb |= (long) zzgayVar.zzb(charSequenceZzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzgayVar.zzd;
            int i7 = i5 * zzgayVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzb >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    public zzgbd zzb(zzgay zzgayVar, Character ch) {
        return new zzgbc(zzgayVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public void zzc(Appendable appendable, byte[] bArr, int i, int i2) {
        int i3 = 0;
        zzfvp.zzk(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zzh(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public final int zzd(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public final int zze(int i) {
        zzgay zzgayVar = this.zzb;
        return zzgayVar.zzc * zzgbm.zzb(i, zzgayVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public final zzgbd zzf() {
        zzgbd zzgbdVarZzb = this.zza;
        if (zzgbdVarZzb == null) {
            zzgay zzgayVar = this.zzb;
            zzgay zzgayVarZzc = zzgayVar.zzc();
            zzgbdVarZzb = zzgayVarZzc == zzgayVar ? this : zzb(zzgayVarZzc, this.zzc);
            this.zza = zzgbdVarZzb;
        }
        return zzgbdVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzc == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzh(Appendable appendable, byte[] bArr, int i, int i2) {
        zzfvp.zzk(i, i + i2, bArr.length);
        zzgay zzgayVar = this.zzb;
        int i3 = zzgayVar.zzd;
        int i4 = 0;
        zzfvp.zze(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & 255))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzgayVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzgayVar.zza(zzgayVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        if (this.zzc != null) {
            while (i4 < i3 * 8) {
                appendable.append('=');
                i4 += i7;
            }
        }
    }

    public zzgbc(String str, String str2, Character ch) {
        this(new zzgay(str, str2.toCharArray()), ch);
    }
}
