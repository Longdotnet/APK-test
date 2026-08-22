package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfvj {
    private final String zza;
    private final zzfvi zzb;
    private zzfvi zzc;

    public /* synthetic */ zzfvj(String str, zzfvk zzfvkVar) {
        zzfvi zzfviVar = new zzfvi();
        this.zzb = zzfviVar;
        this.zzc = zzfviVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfvi zzfviVar = this.zzb.zzb;
        String str = "";
        while (zzfviVar != null) {
            Object obj = zzfviVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzfviVar = zzfviVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfvj zza(Object obj) {
        zzfvi zzfviVar = new zzfvi();
        this.zzc.zzb = zzfviVar;
        this.zzc = zzfviVar;
        zzfviVar.zza = obj;
        return this;
    }
}
