package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzgn {
    private static final zzgn zza = new zzgn();
    private final AtomicReference zzb = new AtomicReference(new zzhh(new zzhb(), null));

    public static zzgn zzb() {
        return zza;
    }

    public final zzaw zza(zzgy zzgyVar, zzca zzcaVar) {
        try {
            try {
                return ((zzhh) this.zzb.get()).zza(zzgyVar, zzcaVar);
            } catch (GeneralSecurityException unused) {
                return new zzgg(zzgyVar, zzcaVar);
            }
        } catch (GeneralSecurityException e) {
            throw new zzhi("Creating a LegacyProtoKey failed", e);
        }
    }

    public final synchronized void zzc(zzfv zzfvVar) {
        zzhb zzhbVar = new zzhb((zzhh) this.zzb.get());
        zzhbVar.zza(zzfvVar);
        this.zzb.set(new zzhh(zzhbVar, null));
    }

    public final synchronized void zzd(zzfz zzfzVar) {
        zzhb zzhbVar = new zzhb((zzhh) this.zzb.get());
        zzhbVar.zzb(zzfzVar);
        this.zzb.set(new zzhh(zzhbVar, null));
    }

    public final synchronized void zze(zzgr zzgrVar) {
        zzhb zzhbVar = new zzhb((zzhh) this.zzb.get());
        zzhbVar.zzc(zzgrVar);
        this.zzb.set(new zzhh(zzhbVar, null));
    }

    public final synchronized void zzf(zzgv zzgvVar) {
        zzhb zzhbVar = new zzhb((zzhh) this.zzb.get());
        zzhbVar.zzd(zzgvVar);
        this.zzb.set(new zzhh(zzhbVar, null));
    }
}
