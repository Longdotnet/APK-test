package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzez {
    public final String zza;

    private zzez(int i, int i2, String str) {
        this.zza = str;
    }

    public static zzez zza(zzen zzenVar) {
        String str;
        zzenVar.zzM(2);
        int iZzm = zzenVar.zzm();
        int i = iZzm >> 1;
        int i2 = iZzm & 1;
        int iZzm2 = zzenVar.zzm() >> 3;
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        int i3 = iZzm2 | (i2 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i < 10 ? ".0" : ".");
        sb.append(i);
        sb.append(i3 < 10 ? ".0" : ".");
        sb.append(i3);
        return new zzez(i, i3, sb.toString());
    }
}
