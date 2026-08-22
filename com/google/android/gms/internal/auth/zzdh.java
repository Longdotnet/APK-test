package com.google.android.gms.internal.auth;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class zzdh<T> implements Serializable, zzdg {
    final zzdg<T> zza;
    volatile transient boolean zzb;
    transient T zzc;

    public zzdh(zzdg<T> zzdgVar) {
        zzdgVar.getClass();
        this.zza = zzdgVar;
    }

    public final String toString() {
        Object objM;
        if (this.zzb) {
            String strValueOf = String.valueOf(this.zzc);
            objM = Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        } else {
            objM = this.zza;
        }
        String strValueOf2 = String.valueOf(objM);
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf2.length() + 19), "Suppliers.memoize(", strValueOf2, ")");
    }

    @Override // com.google.android.gms.internal.auth.zzdg
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                try {
                    if (!this.zzb) {
                        T tZza = this.zza.zza();
                        this.zzc = tZza;
                        this.zzb = true;
                        return tZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzc;
    }
}
