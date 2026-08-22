package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.login.vu.dLDI;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
class zzaz implements zzax {
    private final zzgc zza;
    private final Class zzb;

    public zzaz(zzgc zzgcVar, Class cls) {
        if (!zzgcVar.zzm().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Given internalKeyMananger ", zzgcVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.zza = zzgcVar;
        this.zzb = cls;
    }

    private final zzay zzf() {
        return new zzay(this.zza.zza());
    }

    private final Object zzg(zzaek zzaekVar) throws GeneralSecurityException {
        if (Void.class.equals(this.zzb)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zza.zze(zzaekVar);
        return this.zza.zzl(zzaekVar, this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final zzns zza(zzacc zzaccVar) throws GeneralSecurityException {
        try {
            zzaek zzaekVarZza = zzf().zza(zzaccVar);
            zznp zznpVarZza = zzns.zza();
            zznpVarZza.zzb(this.zza.zzd());
            zznpVarZza.zzc(zzaekVarZza.zzo());
            zznpVarZza.zza(this.zza.zzb());
            return (zzns) zznpVarZza.zzi();
        } catch (zzadn e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final Object zzc(zzacc zzaccVar) throws GeneralSecurityException {
        try {
            return zzg(this.zza.zzc(zzaccVar));
        } catch (zzadn e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzk().getName()), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final Object zzd(zzaek zzaekVar) throws GeneralSecurityException {
        String strConcat = "Expected proto of type ".concat(this.zza.zzk().getName());
        if (this.zza.zzk().isInstance(zzaekVar)) {
            return zzg(zzaekVar);
        }
        throw new GeneralSecurityException(strConcat);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final String zze() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final zzaek zzb(zzacc zzaccVar) throws GeneralSecurityException {
        try {
            return zzf().zza(zzaccVar);
        } catch (zzadn e) {
            throw new GeneralSecurityException(dLDI.YCnp.concat(this.zza.zza().zzg().getName()), e);
        }
    }
}
