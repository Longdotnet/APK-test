package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiy extends zzgga {
    private final zzgiw zza;
    private final String zzb;
    private final zzgiv zzc;
    private final zzgga zzd;

    public /* synthetic */ zzgiy(zzgiw zzgiwVar, String str, zzgiv zzgivVar, zzgga zzggaVar, zzgix zzgixVar) {
        this.zza = zzgiwVar;
        this.zzb = str;
        this.zzc = zzgivVar;
        this.zzd = zzggaVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgiy)) {
            return false;
        }
        zzgiy zzgiyVar = (zzgiy) obj;
        return zzgiyVar.zzc.equals(this.zzc) && zzgiyVar.zzd.equals(this.zzd) && zzgiyVar.zzb.equals(this.zzb) && zzgiyVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzgiy.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzgiw zzgiwVar = this.zza;
        zzgga zzggaVar = this.zzd;
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + String.valueOf(this.zzc) + ", dekParametersForNewKeys: " + String.valueOf(zzggaVar) + ", variant: " + String.valueOf(zzgiwVar) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza != zzgiw.zzb;
    }

    public final zzgga zzb() {
        return this.zzd;
    }

    public final zzgiw zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }
}
