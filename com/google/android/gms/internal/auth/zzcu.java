package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;

/* JADX INFO: loaded from: classes2.dex */
final class zzcu extends zzcz<Boolean> {
    public zzcu(zzcx zzcxVar, String str, Boolean bool, boolean z) {
        super(zzcxVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzcz
    public final /* bridge */ /* synthetic */ Boolean zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzcb.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        String strZzc = zzc();
        String str = (String) obj;
        StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 28 + str.length());
        sb.append("Invalid boolean value for ");
        sb.append(strZzc);
        sb.append(RDFWIi.PDHBsGHf);
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
