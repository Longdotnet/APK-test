package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdh extends zzgb {
    final /* synthetic */ zzdi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdh(zzdi zzdiVar, Class cls) {
        super(cls);
        this.zza = zzdiVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ zzaek zza(zzaek zzaekVar) {
        zzpd zzpdVarZzb = zzpe.zzb();
        zzpdVarZzb.zzb(0);
        zzpdVarZzb.zza(zzacc.zzn(zzqq.zza(32)));
        return (zzpe) zzpdVarZzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzaek zzb(zzacc zzaccVar) {
        return zzph.zzc(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final Map zzc() {
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", new zzga(zzph.zzb(), 1));
        map.put("XCHACHA20_POLY1305_RAW", new zzga(zzph.zzb(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zzd(zzaek zzaekVar) {
    }
}
