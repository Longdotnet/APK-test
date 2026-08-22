package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfwa extends zzfwc {
    public zzfwa(zzfwe zzfweVar, CharSequence charSequence, int i) {
        super(zzfweVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzc(int i) {
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzd(int i) {
        int i2 = i + 4000;
        if (i2 < ((zzfwc) this).zzb.length()) {
            return i2;
        }
        return -1;
    }
}
