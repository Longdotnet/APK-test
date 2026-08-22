package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzapv {
    private final String zza;
    private final String zzb;

    public zzapv(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzapv.class == obj.getClass()) {
            zzapv zzapvVar = (zzapv) obj;
            if (TextUtils.equals(this.zza, zzapvVar.zza) && TextUtils.equals(this.zzb, zzapvVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.zza);
        sb.append(",value=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.zzb, "]");
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
