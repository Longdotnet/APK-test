package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzhge extends zzhgj {
    final String zza;

    public zzhge(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzhgj
    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(str2).length() + 1);
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
