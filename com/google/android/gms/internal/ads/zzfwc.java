package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfwc extends zzfuu {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    public zzfwc(zzfwe zzfweVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzfuu
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i = this.zzc;
        while (true) {
            int i2 = this.zzc;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i2);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zzc = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzc = iZzc;
            }
            if (iZzc != i) {
                if (i < iZzd) {
                    this.zzb.charAt(i);
                }
                if (i < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                int i3 = this.zzd;
                if (i3 == 1) {
                    CharSequence charSequence = this.zzb;
                    int length = charSequence.length();
                    this.zzc = -1;
                    if (length > i) {
                        charSequence.charAt(length - 1);
                    }
                    iZzd = length;
                } else {
                    this.zzd = i3 - 1;
                }
                return this.zzb.subSequence(i, iZzd).toString();
            }
            int i4 = iZzc + 1;
            this.zzc = i4;
            if (i4 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
