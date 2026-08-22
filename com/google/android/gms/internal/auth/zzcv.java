package com.google.android.gms.internal.auth;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzcv extends zzcz<Double> {
    public zzcv(zzcx zzcxVar, String str, Double d, boolean z) {
        super(zzcxVar, str, d, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzcz
    public final /* bridge */ /* synthetic */ Double zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String strZzc = zzc();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 27 + str.length());
            sb.append("Invalid double value for ");
            sb.append(strZzc);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
