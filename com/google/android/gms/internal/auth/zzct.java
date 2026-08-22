package com.google.android.gms.internal.auth;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzct extends zzcz<Long> {
    public zzct(zzcx zzcxVar, String str, Long l, boolean z) {
        super(zzcxVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzcz
    public final /* bridge */ /* synthetic */ Long zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String strZzc = zzc();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 25 + str.length());
            sb.append("Invalid long value for ");
            sb.append(strZzc);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
