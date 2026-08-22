package com.google.android.gms.internal.auth;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzdj<T> implements Serializable, zzdg {
    final T zza;

    public zzdj(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdj)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzdj) obj).zza;
        return t == t2 || t.equals(t2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf.length() + 22), "Suppliers.ofInstance(", strValueOf, ")");
    }

    @Override // com.google.android.gms.internal.auth.zzdg
    public final T zza() {
        return this.zza;
    }
}
