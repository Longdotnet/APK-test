package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgin extends zzgga {
    private final String zza;
    private final zzgim zzb;

    private zzgin(String str, zzgim zzgimVar) {
        this.zza = str;
        this.zzb = zzgimVar;
    }

    public static zzgin zzc(String str, zzgim zzgimVar) {
        return new zzgin(str, zzgimVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgin)) {
            return false;
        }
        zzgin zzginVar = (zzgin) obj;
        return zzginVar.zza.equals(this.zza) && zzginVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzgin.class, this.zza, this.zzb);
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + this.zzb.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzb != zzgim.zzb;
    }

    public final zzgim zzb() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }
}
