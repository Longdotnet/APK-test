package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.loader.app.gv.DYYbQc;
import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class zzba implements zzbc {
    final /* synthetic */ zzgc zza;

    public zzba(zzgc zzgcVar) {
        this.zza = zzgcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbc
    public final zzax zzb() {
        zzgc zzgcVar = this.zza;
        return new zzaz(zzgcVar, zzgcVar.zzj());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbc
    public final Class zzc() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbc
    public final Class zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbc
    public final Set zze() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbc
    public final zzax zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzaz(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException(DYYbQc.PGNKW, e);
        }
    }
}
