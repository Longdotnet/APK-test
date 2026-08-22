package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzevv implements zzeuc {
    private final JSONObject zza;

    public zzevv(Context context) {
        this.zza = zzbvm.zzc(context, VersionInfoParcel.forPackage());
    }

    public static /* synthetic */ void zzc(zzevv zzevvVar, JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", zzevvVar.zza);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed putting version constants.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 46;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzms)).booleanValue() ? zzgdn.zzh(new zzeub() { // from class: com.google.android.gms.internal.ads.zzevt
            @Override // com.google.android.gms.internal.ads.zzeub
            public final /* synthetic */ void zza(Object obj) {
            }

            @Override // com.google.android.gms.internal.ads.zzeub
            public final void zzb(Object obj) {
            }
        }) : zzgdn.zzh(new zzeub() { // from class: com.google.android.gms.internal.ads.zzevu
            @Override // com.google.android.gms.internal.ads.zzeub
            public final /* synthetic */ void zza(Object obj) {
            }

            @Override // com.google.android.gms.internal.ads.zzeub
            public final void zzb(Object obj) {
                zzevv.zzc(this.zza, (JSONObject) obj);
            }
        });
    }
}
