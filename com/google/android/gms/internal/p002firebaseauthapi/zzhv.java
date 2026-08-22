package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzhv extends zziv {
    private final int zza;
    private final int zzb;
    private final zzht zzc;

    public /* synthetic */ zzhv(int i, int i2, zzht zzhtVar, zzhu zzhuVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzhtVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhv)) {
            return false;
        }
        zzhv zzhvVar = (zzhv) obj;
        return zzhvVar.zza == this.zza && zzhvVar.zzb() == zzb() && zzhvVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int i = this.zzb;
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte tags, and ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, i2, "-byte key)");
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        zzht zzhtVar = this.zzc;
        if (zzhtVar == zzht.zzd) {
            return this.zzb;
        }
        if (zzhtVar == zzht.zza || zzhtVar == zzht.zzb || zzhtVar == zzht.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzht zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzc != zzht.zzd;
    }
}
