package okhttp3.internal.http1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbow;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcai;
import com.google.android.gms.internal.ads.zzckd;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhx;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal.http1.HeadersReader;
import okio.RealBufferedSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class HeadersReader {
    public long headerLimit;
    public Object source;

    public HeadersReader(DefaultClock defaultClock) {
        zzah.checkNotNull(defaultClock);
        this.source = defaultClock;
    }

    public static final void zzf(zzdsj zzdsjVar, String str, long j) {
        if (zzdsjVar != null) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zznb)).booleanValue()) {
                zzdsi zzdsiVarZza = zzdsjVar.zza();
                zzdsiVarZza.zzb("action", "lat_init");
                zzdsiVarZza.zzb(str, Long.toString(j));
                zzdsiVarZza.zzj();
            }
        }
    }

    public Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String utf8LineStrict = ((RealBufferedSource) this.source).readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= (long) utf8LineStrict.length();
            if (utf8LineStrict.length() == 0) {
                return builder.build();
            }
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) utf8LineStrict, ':', 1, false, 4);
            if (iIndexOf$default != -1) {
                String strSubstring = utf8LineStrict.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = utf8LineStrict.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                builder.addLenient$okhttp(strSubstring, strSubstring2);
            } else if (utf8LineStrict.charAt(0) == ':') {
                String strSubstring3 = utf8LineStrict.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                builder.addLenient$okhttp("", strSubstring3);
            } else {
                builder.addLenient$okhttp("", utf8LineStrict);
            }
        }
    }

    public void zzd(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzbzm zzbzmVar, String str, String str2, zzckd zzckdVar, final zzfhx zzfhxVar, final zzdsj zzdsjVar, final Long l, boolean z2) {
        PackageInfo packageInfo;
        zzv zzvVar = zzv.zza;
        zzvVar.zzl.getClass();
        if (SystemClock.elapsedRealtime() - this.headerLimit < 5000) {
            int i = zze.$r8$clinit;
            zzo.zzj("Not retrying to fetch app settings");
            return;
        }
        DefaultClock defaultClock = zzvVar.zzl;
        defaultClock.getClass();
        this.headerLimit = SystemClock.elapsedRealtime();
        if (zzbzmVar != null && !TextUtils.isEmpty(zzbzmVar.zzc())) {
            long jZza = zzbzmVar.zza();
            defaultClock.getClass();
            if (System.currentTimeMillis() - jZza <= ((Long) zzbd.zza.zzd.zzb(zzbde.zzew)).longValue() && zzbzmVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            int i2 = zze.$r8$clinit;
            zzo.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i3 = zze.$r8$clinit;
            zzo.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.source = applicationContext;
        final zzfhj zzfhjVarZza = zzfhi.zza(context, 4);
        zzfhjVarZza.zzi();
        zzbow zzbowVarZza = zzvVar.zzs.zza((Context) this.source, versionInfoParcel, zzfhxVar);
        String str3 = sgtsHsWT.YCPUB;
        zzboq zzboqVar = zzbot.zza;
        zzbom zzbomVarZza = zzbowVarZza.zza(str3, zzboqVar, zzboqVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbcv zzbcvVar = zzbde.zza;
            zzbd zzbdVar = zzbd.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzbdVar.zzb.zza()));
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjV)).booleanValue()) {
                jSONObject.put("inspector_enabled", z2);
            }
            try {
                ApplicationInfo applicationInfo = ((Context) this.source).getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(0, applicationInfo.packageName)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                zze.zza("Error fetching PackageInfo.");
            }
            ListenableFuture listenableFutureZzb = zzbomVarZza.zzb(jSONObject);
            zzgcu zzgcuVar = new zzgcu(this) { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    Long l2 = l;
                    zzdsj zzdsjVar2 = zzdsjVar;
                    zzfhj zzfhjVar = zzfhjVarZza;
                    zzfhx zzfhxVar2 = zzfhxVar;
                    JSONObject jSONObject2 = (JSONObject) obj;
                    boolean zOptBoolean = jSONObject2.optBoolean("isSuccessful", false);
                    if (zOptBoolean) {
                        String string = jSONObject2.getString("appSettingsJson");
                        zzv zzvVar2 = zzv.zza;
                        zzj zzjVar = (zzj) zzvVar2.zzi.zzi();
                        zzjVar.zzR();
                        synchronized (zzjVar.zza) {
                            try {
                                zzvVar2.zzl.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (string == null || string.equals(zzjVar.zzn.zzc())) {
                                    zzjVar.zzn.zzg(jCurrentTimeMillis);
                                } else {
                                    zzjVar.zzn = new zzbzm(string, jCurrentTimeMillis);
                                    SharedPreferences.Editor editor = zzjVar.zzg;
                                    if (editor != null) {
                                        editor.putString("app_settings_json", string);
                                        zzjVar.zzg.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                                        zzjVar.zzg.apply();
                                    }
                                    zzjVar.zzS();
                                    Iterator it = zzjVar.zzc.iterator();
                                    while (it.hasNext()) {
                                        ((Runnable) it.next()).run();
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (l2 != null) {
                            zzv.zza.zzl.getClass();
                            HeadersReader.zzf(zzdsjVar2, "cld_s", SystemClock.elapsedRealtime() - l2.longValue());
                        }
                    }
                    String strOptString = jSONObject2.optString("errorReason", "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        zzfhjVar.zzc(strOptString);
                    }
                    zzfhjVar.zzg(zOptBoolean);
                    zzfhxVar2.zzc(zzfhjVar.zzm());
                    return zzgdn.zzh(null);
                }
            };
            zzgdy zzgdyVar = zzcaf.zzg;
            ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzb, zzgcuVar, zzgdyVar);
            if (zzckdVar != null) {
                listenableFutureZzb.addListener(zzckdVar, zzgdyVar);
            }
            if (l != null) {
                listenableFutureZzb.addListener(new zza(this, zzdsjVar, l, 22), zzgdyVar);
            }
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzia)).booleanValue()) {
                zzcai.zzb(listenableFutureZzn, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzcai.zza(listenableFutureZzn, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e) {
            int i4 = zze.$r8$clinit;
            zzo.zzh("Error requesting application settings", e);
            zzfhjVarZza.zzh(e);
            zzfhjVarZza.zzg(false);
            zzfhxVar.zzc(zzfhjVarZza.zzm());
        }
    }
}
