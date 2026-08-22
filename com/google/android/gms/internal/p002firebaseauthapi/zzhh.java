package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzhh {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzhh(zzhb zzhbVar, zzhg zzhgVar) {
        this.zza = new HashMap(zzhbVar.zza);
        this.zzb = new HashMap(zzhbVar.zzb);
        this.zzc = new HashMap(zzhbVar.zzc);
        this.zzd = new HashMap(zzhbVar.zzd);
    }

    public final zzaw zza(zzha zzhaVar, zzca zzcaVar) throws GeneralSecurityException {
        zzhd zzhdVar = new zzhd(zzhaVar.getClass(), zzhaVar.zzd(), null);
        if (this.zzb.containsKey(zzhdVar)) {
            return ((zzfv) this.zzb.get(zzhdVar)).zza(zzhaVar, zzcaVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No Key Parser for requested key type ", zzhdVar.toString(), " available"));
    }
}
