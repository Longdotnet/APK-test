package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeim implements zzedo {
    private final zzejq zza;
    private final zzdpz zzb;

    public zzeim(zzejq zzejqVar, zzdpz zzdpzVar) {
        this.zza = zzejqVar;
        this.zzb = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) {
        zzbrp zzbrpVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbQ)).booleanValue()) {
            try {
                zzbrpVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Coundn't create RTB adapter: ", e);
                zzbrpVarZzb = null;
            }
        } else {
            zzbrpVarZzb = this.zza.zza(str);
        }
        if (zzbrpVarZzb == null) {
            return null;
        }
        return new zzedp(zzbrpVarZzb, new zzefd(), str);
    }
}
