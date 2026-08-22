package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzin extends zziv {
    private final int zza;
    private final int zzb;
    private final zzil zzc;
    private final zzik zzd;

    public /* synthetic */ zzin(int i, int i2, zzil zzilVar, zzik zzikVar, zzim zzimVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzilVar;
        this.zzd = zzikVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzin)) {
            return false;
        }
        zzin zzinVar = (zzin) obj;
        return zzinVar.zza == this.zza && zzinVar.zzb() == zzb() && zzinVar.zzc == this.zzc && zzinVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(this.zzd);
        int i = this.zzb;
        int i2 = this.zza;
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("HMAC Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2, ", ");
        sbM22m.append(i);
        sbM22m.append("-byte tags, and ");
        sbM22m.append(i2);
        sbM22m.append("-byte key)");
        return sbM22m.toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzil zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzc != zzil.zzd;
    }

    public final int zzb() {
        zzil zzilVar = this.zzc;
        if (zzilVar == zzil.zzd) {
            return this.zzb;
        }
        if (zzilVar == zzil.zza || zzilVar == zzil.zzb || zzilVar == zzil.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException(ygoi.XdWgJlNkUS);
    }
}
