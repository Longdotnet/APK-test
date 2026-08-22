package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpi implements zzgcu {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzb;

    public zzbpi(ListenableFuture listenableFuture, String str, zzbop zzbopVar, zzboo zzbooVar) {
        this.zzb = listenableFuture;
    }

    public static ListenableFuture zzb(zzbpi zzbpiVar, Object obj, zzboj zzbojVar) {
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        String string = UUID.randomUUID().toString();
        zzbke.zzo.zzc(string, new zzbph(zzbpiVar, zzcakVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbojVar.zzp(zzbpiVar.zza, jSONObject);
        return zzcakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final ListenableFuture zza(Object obj) {
        return zzc(obj);
    }

    public final ListenableFuture zzc(final Object obj) {
        return zzgdn.zzn(this.zzb, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzbpg
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj2) {
                return zzbpi.zzb(this.zza, obj, (zzboj) obj2);
            }
        }, zzcaf.zzg);
    }
}
