package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgot {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgot(Class cls, Class cls2, zzgou zzgouVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgot)) {
            return false;
        }
        zzgot zzgotVar = (zzgot) obj;
        return zzgotVar.zza.equals(this.zza) && zzgotVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zza.getSimpleName(), " with primitive type: ", this.zzb.getSimpleName());
    }
}
