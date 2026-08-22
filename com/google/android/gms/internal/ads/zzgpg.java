package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgpg {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzgpg(zzgpc zzgpcVar, zzgpf zzgpfVar) {
        this.zza = new HashMap(zzgpcVar.zza);
        this.zzb = new HashMap(zzgpcVar.zzb);
        this.zzc = new HashMap(zzgpcVar.zzc);
        this.zzd = new HashMap(zzgpcVar.zzd);
    }

    public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgpbVar.getClass(), zzgpbVar.zzd(), null);
        Map map = this.zzb;
        if (map.containsKey(zzgpdVar)) {
            return ((zzgmt) map.get(zzgpdVar)).zza(zzgpbVar, zzgfnVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No Key Parser for requested key type ", zzgpdVar.toString(), " available"));
    }

    public final zzgfm zzb(zzgpb zzgpbVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgpbVar.getClass(), zzgpbVar.zzd(), null);
        Map map = this.zzd;
        if (map.containsKey(zzgpdVar)) {
            return ((zzgod) map.get(zzgpdVar)).zza(zzgpbVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No Parameters Parser for requested key type ", zzgpdVar.toString(), " available"));
    }

    public final zzgpb zzc(zzgez zzgezVar, Class cls, zzgfn zzgfnVar) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgezVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzgpeVar)) {
            return ((zzgmx) map.get(zzgpeVar)).zza(zzgezVar, zzgfnVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No Key serializer for ", zzgpeVar.toString(), " available"));
    }

    public final boolean zzi(zzgpb zzgpbVar) {
        return this.zzb.containsKey(new zzgpd(zzgpbVar.getClass(), zzgpbVar.zzd(), null));
    }

    public final boolean zzj(zzgpb zzgpbVar) {
        return this.zzd.containsKey(new zzgpd(zzgpbVar.getClass(), zzgpbVar.zzd(), null));
    }

    public final zzgpb zzd(zzgfm zzgfmVar, Class cls) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgfmVar.getClass(), cls, null);
        Map map = this.zzc;
        if (map.containsKey(zzgpeVar)) {
            return ((zzgoh) map.get(zzgpeVar)).zza(zzgfmVar);
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No Key Format serializer for ", zzgpeVar.toString(), oKjScaD.NwcH));
    }
}
