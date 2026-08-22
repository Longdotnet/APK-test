package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgql extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgqj zzc;
    private final zzgqi zzd;

    public /* synthetic */ zzgql(int i, int i2, zzgqj zzgqjVar, zzgqi zzgqiVar, zzgqk zzgqkVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgqjVar;
        this.zzd = zzgqiVar;
    }

    public static zzgqh zze() {
        return new zzgqh(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgql)) {
            return false;
        }
        zzgql zzgqlVar = (zzgql) obj;
        return zzgqlVar.zza == this.zza && zzgqlVar.zzd() == zzd() && zzgqlVar.zzc == this.zzc && zzgqlVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgql.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("HMAC Parameters (variant: ", String.valueOf(this.zzc), ", hashType: ", String.valueOf(this.zzd), ", ");
        sbM22m.append(this.zzb);
        sbM22m.append("-byte tags, and ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM22m, this.zza, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzc != zzgqj.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgqi zzf() {
        return this.zzd;
    }

    public final zzgqj zzg() {
        return this.zzc;
    }

    public final int zzd() {
        zzgqj zzgqjVar = this.zzc;
        if (zzgqjVar == zzgqj.zzd) {
            return this.zzb;
        }
        if (zzgqjVar == zzgqj.zza || zzgqjVar == zzgqj.zzb || zzgqjVar == zzgqj.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException(JuorMn.aRUQOkqJN);
    }
}
