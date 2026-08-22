package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgpd {
    private final Class zza;
    private final zzgxe zzb;

    public /* synthetic */ zzgpd(Class cls, zzgxe zzgxeVar, zzgpf zzgpfVar) {
        this.zza = cls;
        this.zzb = zzgxeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpd)) {
            return false;
        }
        zzgpd zzgpdVar = (zzgpd) obj;
        return zzgpdVar.zza.equals(this.zza) && zzgpdVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zza.getSimpleName(), ", object identifier: ", String.valueOf(this.zzb));
    }
}
