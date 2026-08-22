package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiu {
    private zzgiw zza;
    private String zzb;
    private zzgiv zzc;
    private zzgga zzd;

    private zzgiu() {
        throw null;
    }

    public final zzgiu zza(zzgga zzggaVar) {
        this.zzd = zzggaVar;
        return this;
    }

    public final zzgiu zzb(zzgiv zzgivVar) {
        this.zzc = zzgivVar;
        return this;
    }

    public final zzgiu zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzgiu zzd(zzgiw zzgiwVar) {
        this.zza = zzgiwVar;
        return this;
    }

    public final zzgiy zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgiw.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzgiv zzgivVar = this.zzc;
        if (zzgivVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzgga zzggaVar = this.zzd;
        if (zzggaVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzggaVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzgivVar.equals(zzgiv.zza) && (zzggaVar instanceof zzghm)) || ((zzgivVar.equals(zzgiv.zzc) && (zzggaVar instanceof zzgid)) || ((zzgivVar.equals(zzgiv.zzb) && (zzggaVar instanceof zzgka)) || ((zzgivVar.equals(zzgiv.zzd) && (zzggaVar instanceof zzggr)) || ((zzgivVar.equals(zzgiv.zze) && (zzggaVar instanceof zzghb)) || (zzgivVar.equals(zzgiv.zzf) && (zzggaVar instanceof zzghx))))))) {
            return new zzgiy(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Cannot use parsing strategy ", this.zzc.toString(), " when new keys are picked according to ", String.valueOf(this.zzd), "."));
    }

    public /* synthetic */ zzgiu(zzgix zzgixVar) {
    }
}
