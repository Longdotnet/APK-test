package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxg implements zzhgr {
    private final zzhha zza;

    private zzdxg(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdxg zza(zzhha zzhhaVar) {
        return new zzdxg(zzhhaVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004d  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        String strValueOf;
        com.google.android.gms.ads.internal.client.zzc zzcVar;
        zzfcw zzfcwVarZzc = ((zzcvp) this.zza).zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhy)).booleanValue()) {
            String str = zzfcwVarZzc.zzd.zzx;
            if (TextUtils.isEmpty(str)) {
                zzcVar = zzfcwVarZzc.zzd.zzs;
                if (zzcVar != null) {
                    strValueOf = new JSONObject(zzcVar.zza).getString("request_id");
                    if (TextUtils.isEmpty(strValueOf)) {
                        strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt() & Integer.MAX_VALUE);
                    }
                } else {
                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt() & Integer.MAX_VALUE);
                }
            } else {
                try {
                    strValueOf = new JSONObject(str).getString("request_id");
                    if (TextUtils.isEmpty(strValueOf)) {
                        zzcVar = zzfcwVarZzc.zzd.zzs;
                        if (zzcVar != null) {
                            try {
                                strValueOf = new JSONObject(zzcVar.zza).getString("request_id");
                                if (TextUtils.isEmpty(strValueOf)) {
                                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt() & Integer.MAX_VALUE);
                                }
                            } catch (JSONException unused) {
                            }
                        } else {
                            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt() & Integer.MAX_VALUE);
                        }
                    }
                } catch (JSONException unused2) {
                }
            }
        } else {
            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt() & Integer.MAX_VALUE);
        }
        zzhgz.zzb(strValueOf);
        return strValueOf;
    }
}
