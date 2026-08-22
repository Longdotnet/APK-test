package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzflm {
    private final zzflx zza;
    private final zzflx zzb;
    private final boolean zzc;
    private final zzflq zzd;
    private final zzflt zze;

    private zzflm(zzflq zzflqVar, zzflt zzfltVar, zzflx zzflxVar, zzflx zzflxVar2, boolean z) {
        this.zzd = zzflqVar;
        this.zze = zzfltVar;
        this.zza = zzflxVar;
        if (zzflxVar2 == null) {
            this.zzb = zzflx.NONE;
        } else {
            this.zzb = zzflxVar2;
        }
        this.zzc = z;
    }

    public static zzflm zza(zzflq zzflqVar, zzflt zzfltVar, zzflx zzflxVar, zzflx zzflxVar2, boolean z) {
        zzfni.zzc(zzflqVar, "CreativeType is null");
        zzfni.zzc(zzfltVar, "ImpressionType is null");
        zzfni.zzc(zzflxVar, "Impression owner is null");
        if (zzflxVar == zzflx.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (zzflqVar == zzflq.DEFINED_BY_JAVASCRIPT && zzflxVar == zzflx.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzfltVar == zzflt.DEFINED_BY_JAVASCRIPT && zzflxVar == zzflx.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new zzflm(zzflqVar, zzfltVar, zzflxVar, zzflxVar2, z);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfne.zze(jSONObject, "impressionOwner", this.zza);
        zzfne.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfne.zze(jSONObject, "creativeType", this.zzd);
        zzfne.zze(jSONObject, "impressionType", this.zze);
        zzfne.zze(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.zzc));
        return jSONObject;
    }
}
