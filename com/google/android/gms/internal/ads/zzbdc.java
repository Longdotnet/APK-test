package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbdc implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbdg.zza(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzbcz
                    @Override // com.google.android.gms.internal.ads.zzfwh
                    public final Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    public final Object zzb(final zzbcv zzbcvVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                try {
                    if (!this.zza) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbcvVar.zzl();
            }
        }
        if (zzbcvVar.zze() != 2) {
            return (zzbcvVar.zze() == 1 && this.zzh.has(zzbcvVar.zzm())) ? zzbcvVar.zza(this.zzh) : zzbdg.zza(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzbda
                @Override // com.google.android.gms.internal.ads.zzfwh
                public final Object zza() {
                    return zzbcvVar.zzc(this.zza.zze);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbcvVar.zzl() : zzbcvVar.zzb(bundle);
    }

    public final Object zzc(zzbcv zzbcvVar) {
        return (this.zzd || this.zza) ? zzb(zzbcvVar) : zzbcvVar.zzl();
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0127 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #2 {all -> 0x000e, blocks: (B:7:0x0008, B:9:0x000c, B:13:0x0011, B:15:0x0016, B:16:0x0018, B:18:0x002a, B:19:0x002e, B:20:0x0030, B:45:0x00a5, B:46:0x00ac, B:55:0x00db, B:56:0x00e2, B:70:0x0127, B:71:0x012e, B:79:0x0156, B:80:0x015d, B:82:0x015f, B:83:0x0166, B:22:0x0045, B:24:0x004a, B:29:0x0057, B:35:0x0064, B:37:0x006e, B:38:0x0076, B:40:0x007c, B:42:0x008c, B:44:0x00a1, B:48:0x00ae, B:50:0x00b2, B:52:0x00c2, B:54:0x00d7, B:58:0x00e4, B:68:0x0123, B:73:0x0130, B:75:0x0148, B:77:0x014c, B:78:0x014f, B:61:0x00f5, B:63:0x0103, B:65:0x010b, B:66:0x0116), top: B:92:0x0008, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0130 A[Catch: all -> 0x005f, TRY_ENTER, TryCatch #3 {all -> 0x005f, blocks: (B:22:0x0045, B:24:0x004a, B:29:0x0057, B:35:0x0064, B:37:0x006e, B:38:0x0076, B:40:0x007c, B:42:0x008c, B:44:0x00a1, B:48:0x00ae, B:50:0x00b2, B:52:0x00c2, B:54:0x00d7, B:58:0x00e4, B:68:0x0123, B:73:0x0130, B:75:0x0148, B:77:0x014c, B:78:0x014f, B:61:0x00f5, B:63:0x0103, B:65:0x010b, B:66:0x0116), top: B:93:0x0045, outer: #2 }] */
    public final void zzd(Context context) {
        Context applicationContext;
        final SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            try {
                if (this.zzd) {
                    return;
                }
                if (!this.zza) {
                    this.zza = true;
                }
                this.zzi = TextUtils.equals(context.getPackageName(), "com.google.android.gms");
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzg = context;
                try {
                    this.zzf = Wrappers.packageManager(context).getApplicationInfo(128, this.zzg.getPackageName()).metaData;
                } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                }
                try {
                    Context context2 = this.zzg;
                    int i = GooglePlayServicesUtil.$r8$clinit;
                    SharedPreferences sharedPreferencesZza = null;
                    try {
                        applicationContext = context2.createPackageContext("com.google.android.gms", 3);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        applicationContext = null;
                    }
                    if (applicationContext != null || context2 == null || (applicationContext = context2.getApplicationContext()) != null) {
                        context2 = applicationContext;
                    }
                    if (context2 != null) {
                        zzbcx zzbcxVar = com.google.android.gms.ads.internal.client.zzbd.zza.zzc;
                        sharedPreferencesZza = zzbcx.zza(context2);
                    }
                    if (sharedPreferencesZza != null) {
                        zzbfv.zzc(new zzbdb(this, sharedPreferencesZza));
                    }
                    if (!this.zzi) {
                        zzbeo zzbeoVar = zzbew.zzd;
                        if (((Long) zzbeoVar.zze()).longValue() > 0 && zzbco.zza(this.zzg) >= ((Long) zzbeoVar.zze()).longValue()) {
                            this.zzj = true;
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                    }
                    if (!this.zzi) {
                        zzbeo zzbeoVar2 = zzbew.zzf;
                        if (((Long) zzbeoVar2.zze()).longValue() > 0 && zzbco.zzb(this.zzg) >= ((Long) zzbeoVar2.zze()).longValue()) {
                            this.zzj = true;
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                    }
                    Context context3 = this.zzg;
                    if (!((Boolean) zzbfe.zzg.zze()).booleanValue()) {
                        if (((Boolean) zzbfe.zzh.zze()).booleanValue() && (sharedPreferences = context3.getSharedPreferences("admob", 0)) != null) {
                            try {
                                if (new JSONObject((String) zzbdg.zza(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzbcy
                                    @Override // com.google.android.gms.internal.ads.zzfwh
                                    public final Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            } catch (JSONException unused3) {
                            }
                        }
                        if (context2 == null) {
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        zzbcx zzbcxVar2 = com.google.android.gms.ads.internal.client.zzbd.zza.zzc;
                        this.zze = zzbcx.zza(context2);
                        if (!((Boolean) zzbfe.zza.zze()).booleanValue() && (sharedPreferences2 = this.zze) != null) {
                            sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                        }
                        zzg(this.zze);
                        this.zzd = true;
                        this.zza = false;
                        this.zzc.open();
                    }
                    context2 = this.zzg;
                    if (context2 == null) {
                        this.zza = false;
                        this.zzc.open();
                        return;
                    }
                    zzbcx zzbcxVar3 = com.google.android.gms.ads.internal.client.zzbd.zza.zzc;
                    this.zze = zzbcx.zza(context2);
                    if (!((Boolean) zzbfe.zza.zze()).booleanValue()) {
                        sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                    }
                    zzg(this.zze);
                    this.zzd = true;
                    this.zza = false;
                    this.zzc.open();
                } catch (Throwable th) {
                    this.zza = false;
                    this.zzc.open();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (FKidOcdAYt.dfHPd.equals(str)) {
            zzg(sharedPreferences);
        }
    }
}
