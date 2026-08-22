package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvm extends zzbvk {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbom zzd;
    private final VersionInfoParcel zze;

    public zzbvm(Context context, zzbom zzbomVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbomVar;
    }

    public static Void zzb(zzbvm zzbvmVar, JSONObject jSONObject) {
        zzbcv zzbcvVar = zzbde.zza;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        zzbcx zzbcxVar = zzbdVar.zzc;
        SharedPreferences sharedPreferencesZza = zzbcx.zza(zzbvmVar.zzb);
        if (sharedPreferencesZza == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesZza.edit();
        zzbcw zzbcwVar = zzbdVar.zzb;
        Objects.requireNonNull(zzbcwVar);
        int i = zzbeu.zza;
        zzbcwVar.zzf(editorEdit, 1, jSONObject);
        editorEdit.commit();
        SharedPreferences sharedPreferences = zzbvmVar.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        editorEdit2.putLong("js_last_update", System.currentTimeMillis()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvk
    public final ListenableFuture zza() {
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        long j = sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        if (System.currentTimeMillis() - j < ((Long) zzbfe.zzd.zze()).longValue()) {
            return zzgdn.zzh(null);
        }
        return zzgdn.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzfve() { // from class: com.google.android.gms.internal.ads.zzbvl
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzbvm.zzb(this.zza, (JSONObject) obj);
                return null;
            }
        }, zzcaf.zzg);
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbfe.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbfe.zzc.zze());
            jSONObject.put("cl", "785558560");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put(gZrKCJ.IlXdaCOAWkbuV, 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.zza(context, ModuleDescriptor.MODULE_ID, false));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
