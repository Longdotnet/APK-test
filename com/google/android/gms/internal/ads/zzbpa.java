package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpa implements zzbom {
    private final zzboo zza;
    private final zzbop zzb;
    private final zzboi zzc;
    private final String zzd;

    public zzbpa(zzboi zzboiVar, String str, zzbop zzbopVar, zzboo zzbooVar) {
        this.zzc = zzboiVar;
        this.zzd = str;
        this.zzb = zzbopVar;
        this.zza = zzbooVar;
    }

    public static void zzd(zzbpa zzbpaVar, zzboc zzbocVar, zzboj zzbojVar, Object obj, zzcak zzcakVar) {
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            String string = UUID.randomUUID().toString();
            zzbke.zzo.zzc(string, new zzboz(zzbpaVar, zzbocVar, zzcakVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzbpaVar.zzb.zzb(obj));
            zzbojVar.zzp(zzbpaVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzcakVar.zzd(e);
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to invokeJavascript", e);
            } finally {
                zzbocVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final ListenableFuture zza(Object obj) {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final ListenableFuture zzb(Object obj) {
        zzcak zzcakVar = new zzcak();
        zzboc zzbocVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzbocVarZzb.zzj(new zzbox(this, zzbocVarZzb, obj, zzcakVar), new zzboy(this, zzcakVar, zzbocVarZzb));
        return zzcakVar;
    }
}
