package com.google.android.gms.internal.auth;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
final class zzdi<T> implements zzdg<T> {
    volatile zzdg<T> zza;
    volatile boolean zzb;
    T zzc;

    public zzdi(zzdg<T> zzdgVar) {
        zzdgVar.getClass();
        this.zza = zzdgVar;
    }

    public final String toString() {
        Object objM = this.zza;
        if (objM == null) {
            String strValueOf = String.valueOf(this.zzc);
            objM = Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
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
                        zzdg<T> zzdgVar = this.zza;
                        zzdgVar.getClass();
                        T tZza = zzdgVar.zza();
                        this.zzc = tZza;
                        this.zzb = true;
                        this.zza = null;
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
