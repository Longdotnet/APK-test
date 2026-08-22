package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzh implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzh(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        SharedPreferences sharedPreferences;
        boolean z = false;
        Object obj = this.zzb;
        Object obj2 = this.zza;
        switch (this.$r8$classId) {
            case 0:
                return ((zzk) obj2).zzb((Context) obj);
            case 1:
                Context context = (Context) obj;
                Context context2 = (Context) obj2;
                if (context != null) {
                    zze.zza("Attempting to read user agent from Google Play Services.");
                    sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
                } else {
                    zze.zza("Attempting to read user agent from local cache.");
                    sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                    z = true;
                }
                String string = sharedPreferences.getString("user_agent", "");
                if (TextUtils.isEmpty(string)) {
                    zze.zza("Reading user agent from WebSettings");
                    string = WebSettings.getDefaultUserAgent(context2);
                    if (z) {
                        sharedPreferences.edit().putString("user_agent", string).apply();
                        zze.zza("Persisting user agent.");
                    }
                }
                return string;
            case 2:
                zzf zzfVar = zzs.zza;
                WebSettings webSettings = (WebSettings) obj2;
                webSettings.setDatabasePath(((Context) obj).getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzaZ)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return Boolean.TRUE;
            case 3:
                return ((TaggingLibraryJsInterface) obj2).getClickSignals((String) obj);
            case 4:
                zzgj zzgjVar = (zzgj) obj;
                zzgjVar.zza.zzA$1();
                zzam zzamVar = zzgjVar.zza.zze;
                zzkt.zzal(zzamVar);
                return zzamVar.zzu((String) obj2);
            default:
                zzq zzqVar = (zzq) obj2;
                String str = zzqVar.zza;
                zzah.checkNotNull(str);
                zzkt zzktVar = (zzkt) obj;
                zzai zzaiVarZzh = zzktVar.zzh(str);
                com.google.android.gms.measurement.internal.zzah zzahVar = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE;
                if (zzaiVarZzh.zzi(zzahVar) && zzai.zzb(zzqVar.zzv).zzi(zzahVar)) {
                    return zzktVar.zzd(zzqVar).zzu();
                }
                zzktVar.zzay().zzl.zza("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }

    public /* synthetic */ zzh(Object obj, Object obj2, int i, boolean z) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }
}
