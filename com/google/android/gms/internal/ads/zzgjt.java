package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.Objects;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgjt extends zzgga {
    private final zzgjs zza;
    private final int zzb;

    private zzgjt(zzgjs zzgjsVar, int i) {
        this.zza = zzgjsVar;
        this.zzb = i;
    }

    public static zzgjt zzd(zzgjs zzgjsVar, int i) throws GeneralSecurityException {
        if (i < 8 || i > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzgjt(zzgjsVar, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjt)) {
            return false;
        }
        zzgjt zzgjtVar = (zzgjt) obj;
        return zzgjtVar.zza == this.zza && zzgjtVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzgjt.class, this.zza, Integer.valueOf(this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza != zzgjs.zzb;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzgjs zzc() {
        return this.zza;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m(ygoi.HXSznPTZmgI, this.zza.toString(), "salt_size_bytes: "), this.zzb, ")");
    }
}
