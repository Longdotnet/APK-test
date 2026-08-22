package com.google.android.gms.internal.auth;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
final class zzdf<T> extends zzde<T> {
    private final T zza;

    public zzdf(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdf) {
            return this.zza.equals(((zzdf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf.length() + 13), "Optional.of(", strValueOf, ")");
    }

    @Override // com.google.android.gms.internal.auth.zzde
    public final T zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.auth.zzde
    public final boolean zzb() {
        return true;
    }
}
