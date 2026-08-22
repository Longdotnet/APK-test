package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzevd implements zzeub {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;
    private final zzfsa zzc;

    public zzevd(AdvertisingIdClient.Info info, String str, zzfsa zzfsaVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfsaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        try {
            JSONObject jSONObjectZzg = AsyncTimeout.Companion.zzg("pii", (JSONObject) obj);
            AdvertisingIdClient.Info info = this.zza;
            if (info != null) {
                String str = info.zza;
                if (!TextUtils.isEmpty(str)) {
                    jSONObjectZzg.put("rdid", str);
                    jSONObjectZzg.put("is_lat", info.zzb);
                    jSONObjectZzg.put("idtype", "adid");
                    zzfsa zzfsaVar = this.zzc;
                    if (zzfsaVar.zzc()) {
                        jSONObjectZzg.put("paidv1_id_android_3p", zzfsaVar.zzb());
                        jSONObjectZzg.put("paidv1_creation_time_android_3p", zzfsaVar.zza());
                        return;
                    }
                    return;
                }
            }
            String str2 = this.zzb;
            if (str2 != null) {
                jSONObjectZzg.put("pdid", str2);
                jSONObjectZzg.put("pdidtype", "ssaid");
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e);
        }
    }
}
