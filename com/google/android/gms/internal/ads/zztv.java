package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zztv {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zztv(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zztv.class) {
            zztv zztvVar = (zztv) obj;
            if (TextUtils.equals(this.zza, zztvVar.zza) && this.zzb == zztvVar.zzb && this.zzc == zztvVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zza.hashCode() + 31, 31, true != this.zzb ? 1237 : 1231, 31) + (true != this.zzc ? 1237 : 1231);
    }
}
