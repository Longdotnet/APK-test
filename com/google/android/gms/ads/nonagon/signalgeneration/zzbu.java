package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbeo;
import com.google.android.gms.internal.ads.zzbfj;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbu extends QueryInfoGenerationCallback {
    public final /* synthetic */ String zza;
    public final /* synthetic */ TaggingLibraryJsInterface zzb;

    public zzbu(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        Objects.requireNonNull(taggingLibraryJsInterface);
        this.zzb = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        int i = 0;
        int i2 = zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        boolean zBooleanValue = ((Boolean) zzbfj.zzc.zze()).booleanValue();
        TaggingLibraryJsInterface taggingLibraryJsInterface = this.zzb;
        String strConcat = zBooleanValue ? ",\"as\":".concat(taggingLibraryJsInterface.zzk.zza().toString()) : "";
        Locale locale = Locale.getDefault();
        zzbeo zzbeoVar = zzbfj.zze;
        String str2 = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", this.zza, str, Long.valueOf(((Boolean) zzbeoVar.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L), strConcat);
        if (((Boolean) zzbeoVar.zze()).booleanValue()) {
            try {
                taggingLibraryJsInterface.zzh.execute(new zzbs(this, str2, i));
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            taggingLibraryJsInterface.zzb.evaluateJavascript(str2, null);
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue() && ((Boolean) zzbfj.zzd.zze()).booleanValue()) {
            zzj zzjVar = taggingLibraryJsInterface.zzl;
            zzjVar.getClass();
            zzjVar.zzc.execute(new zzh(zzjVar, i));
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        int i = 0;
        int i2 = 1;
        String str2 = this.zza;
        TaggingLibraryJsInterface taggingLibraryJsInterface = this.zzb;
        String str3 = queryInfo.zza.symbol;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", str2);
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                jSONObject.put("as", taggingLibraryJsInterface.zzk.zza());
            }
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
            jSONObject.put("signal", str3);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String strConcat = ((Boolean) zzbfj.zzc.zze()).booleanValue() ? ",\"as\":".concat(taggingLibraryJsInterface.zzk.zza().toString()) : "";
            str = String.format(Locale.getDefault(), "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", str2, queryInfo.zza.symbol, Long.valueOf(((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L), strConcat);
        }
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            try {
                taggingLibraryJsInterface.zzh.execute(new zzbs(this, str, i2));
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            taggingLibraryJsInterface.zzb.evaluateJavascript(str, null);
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue() && ((Boolean) zzbfj.zzd.zze()).booleanValue()) {
            zzj zzjVar = taggingLibraryJsInterface.zzl;
            zzjVar.getClass();
            zzjVar.zzc.execute(new zzh(zzjVar, i));
        }
    }
}
