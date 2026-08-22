package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzduw implements zzcwb, zzcza, zzcxq {
    private final zzdvi zza;
    private final String zzb;
    private final String zzc;
    private zzcvr zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private int zzd = 0;
    private zzduv zze = zzduv.AD_REQUESTED;

    public zzduw(zzdvi zzdviVar, zzfcw zzfcwVar, String str) {
        this.zza = zzdviVar;
        this.zzc = str;
        this.zzb = zzfcwVar.zzf;
    }

    private static JSONObject zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zzeVar.zzc);
        jSONObject.put("errorCode", zzeVar.zza);
        jSONObject.put("errorDescription", zzeVar.zzb);
        com.google.android.gms.ads.internal.client.zze zzeVar2 = zzeVar.zzd;
        jSONObject.put("underlyingError", zzeVar2 == null ? null : zzh(zzeVar2));
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcxq
    public final void zza(zzcra zzcraVar) {
        zzdvi zzdviVar = this.zza;
        if (zzdviVar.zzq()) {
            this.zzf = zzcraVar.zzm();
            this.zze = zzduv.AD_LOADED;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjN)).booleanValue()) {
                zzdviVar.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() {
        JSONObject jSONObjectZzi;
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.zze);
        jSONObject.put("format", zzfca.zza(this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjN)).booleanValue()) {
            jSONObject.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject.put("shown", this.zzn);
            }
        }
        zzcvr zzcvrVar = this.zzf;
        if (zzcvrVar != null) {
            jSONObjectZzi = zzi(zzcvrVar);
        } else {
            com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
            JSONObject jSONObjectZzi2 = null;
            if (zzeVar != null && (iBinder = zzeVar.zze) != null) {
                zzcvr zzcvrVar2 = (zzcvr) iBinder;
                jSONObjectZzi2 = zzi(zzcvrVar2);
                if (zzcvrVar2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObjectZzi2.put("errors", jSONArray);
                }
            }
            jSONObjectZzi = jSONObjectZzi2;
        }
        jSONObject.put("responseInfo", jSONObjectZzi);
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdvi zzdviVar = this.zza;
        if (zzdviVar.zzq()) {
            this.zze = zzduv.AD_LOAD_FAILED;
            this.zzg = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjN)).booleanValue()) {
                zzdviVar.zzf(this.zzb, this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjN)).booleanValue()) {
            return;
        }
        zzdvi zzdviVar = this.zza;
        if (zzdviVar.zzq()) {
            zzdviVar.zzf(this.zzb, this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        zzdvi zzdviVar = this.zza;
        if (zzdviVar.zzq()) {
            zzfcm zzfcmVar = zzfcnVar.zzb;
            List list = zzfcmVar.zza;
            if (!list.isEmpty()) {
                this.zzd = ((zzfca) list.get(0)).zzb;
            }
            zzfcd zzfcdVar = zzfcmVar.zzb;
            String str = zzfcdVar.zzl;
            if (!TextUtils.isEmpty(str)) {
                this.zzh = str;
            }
            String str2 = zzfcdVar.zzm;
            if (!TextUtils.isEmpty(str2)) {
                this.zzi = str2;
            }
            JSONObject jSONObject = zzfcdVar.zzp;
            if (jSONObject.length() > 0) {
                this.zzl = jSONObject;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjJ)).booleanValue()) {
                if (!zzdviVar.zzs()) {
                    this.zzo = true;
                    return;
                }
                String str3 = zzfcdVar.zzn;
                if (!TextUtils.isEmpty(str3)) {
                    this.zzj = str3;
                }
                JSONObject jSONObject2 = zzfcdVar.zzo;
                if (jSONObject2.length() > 0) {
                    this.zzk = jSONObject2;
                }
                JSONObject jSONObject3 = this.zzk;
                int length = jSONObject3 != null ? jSONObject3.toString().length() : 0;
                if (!TextUtils.isEmpty(this.zzj)) {
                    length += this.zzj.length();
                }
                zzdviVar.zzk(length);
            }
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        return this.zze != zzduv.AD_REQUESTED;
    }

    private final JSONObject zzi(zzcvr zzcvrVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("winningAdapterClassName", zzcvrVar.zzg());
        jSONObject.put("responseSecsSinceEpoch", zzcvrVar.zzd());
        jSONObject.put("responseId", zzcvrVar.zzi());
        zzbcv zzbcvVar = zzbde.zzjG;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            String strZzk = zzcvrVar.zzk();
            if (!TextUtils.isEmpty(strZzk)) {
                String strValueOf = String.valueOf(strZzk);
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze(bUqMCsuPSX.RMGINEaN.concat(strValueOf));
                jSONObject.put("biddingData", new JSONObject(strZzk));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject.put("adResponseBody", this.zzj);
        }
        Object obj = this.zzk;
        if (obj != null) {
            jSONObject.put("adResponseHeaders", obj);
        }
        Object obj2 = this.zzl;
        if (obj2 != null) {
            jSONObject.put("transactionExtras", obj2);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjJ)).booleanValue()) {
            jSONObject.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (com.google.android.gms.ads.internal.client.zzv zzvVar : zzcvrVar.zzj()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adapterClassName", zzvVar.zza);
            jSONObject2.put("latencyMillis", zzvVar.zzb);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjH)).booleanValue()) {
                jSONObject2.put("credentials", com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn(zzvVar.zzd));
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = zzvVar.zzc;
            jSONObject2.put("error", zzeVar == null ? null : zzh(zzeVar));
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("adNetworks", jSONArray);
        return jSONObject;
    }
}
