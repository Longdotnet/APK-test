package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxv implements zzbya {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhdk zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxx zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxv(Context context, VersionInfoParcel versionInfoParcel, zzbxx zzbxxVar, String str, zzbxw zzbxwVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzbxxVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbxxVar;
        Iterator it = zzbxxVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhdk zzhdkVarZzc = zzhfm.zzc();
        zzhdkVarZzc.zzn(9);
        if (str != null) {
            zzhdkVarZzc.zzj(str);
            zzhdkVarZzc.zzh(str);
        }
        zzhdl zzhdlVarZzc = zzhdm.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzhdlVarZzc.zza(str2);
        }
        zzhdkVarZzc.zzg((zzhdm) zzhdlVarZzc.zzbr());
        zzhfa zzhfaVarZzc = zzhfb.zzc();
        zzhfaVarZzc.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzhfaVarZzc.zza(str3);
        }
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
        Context context2 = this.zzh;
        googleApiAvailabilityLight.getClass();
        long apkVersion = GoogleApiAvailabilityLight.getApkVersion(context2);
        if (apkVersion > 0) {
            zzhfaVarZzc.zzb(apkVersion);
        }
        zzhdkVarZzc.zzf((zzhfb) zzhfaVarZzc.zzbr());
        this.zzd = zzhdkVarZzc;
    }

    public static /* synthetic */ ListenableFuture zzb(zzbxv zzbxvVar, Map map) {
        int length;
        zzhey zzheyVar;
        ListenableFuture listenableFutureZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        Object obj = zzbxvVar.zzj;
                        synchronized (obj) {
                            try {
                                length = jSONArrayOptJSONArray.length();
                                synchronized (obj) {
                                    try {
                                        zzheyVar = (zzhey) zzbxvVar.zze.get(str);
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (zzheyVar == null) {
                            zzbxz.zza("Cannot find the corresponding resource object for " + str);
                        } else {
                            for (int i = 0; i < length; i++) {
                                zzheyVar.zza(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                            }
                            zzbxvVar.zza = (length > 0) | zzbxvVar.zza;
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbfm.zza.zze()).booleanValue()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzgdn.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (zzbxvVar.zza) {
            synchronized (zzbxvVar.zzj) {
                zzbxvVar.zzd.zzn(10);
            }
        }
        boolean z = zzbxvVar.zza;
        if (!(z && zzbxvVar.zzi.zzg) && (!(zzbxvVar.zzm && zzbxvVar.zzi.zzf) && (z || !zzbxvVar.zzi.zzd))) {
            return zzgdn.zzh(null);
        }
        synchronized (zzbxvVar.zzj) {
            try {
                Iterator it = zzbxvVar.zze.values().iterator();
                while (it.hasNext()) {
                    zzbxvVar.zzd.zzc((zzhez) ((zzhey) it.next()).zzbr());
                }
                zzhdk zzhdkVar = zzbxvVar.zzd;
                zzhdkVar.zza(zzbxvVar.zzf);
                zzhdkVar.zzb(zzbxvVar.zzg);
                if (zzbxz.zzb()) {
                    StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + zzhdkVar.zzl() + "\n  clickUrl: " + zzhdkVar.zzk() + "\n  resources: \n");
                    for (zzhez zzhezVar : zzhdkVar.zzm()) {
                        sb.append("    [");
                        sb.append(zzhezVar.zzc());
                        sb.append("] ");
                        sb.append(zzhezVar.zzg());
                    }
                    zzbxz.zza(sb.toString());
                }
                com.google.android.gms.ads.internal.util.zzbk zzbkVarZzb = new com.google.android.gms.ads.internal.util.zzbo(zzbxvVar.zzh).zzb(1, zzbxvVar.zzi.zzb, null, ((zzhfm) zzhdkVar.zzbr()).zzaV());
                if (zzbxz.zzb()) {
                    zzbkVarZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxs
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = zzbxv.zzb;
                            zzbxz.zza("Pinged SB successfully.");
                        }
                    }, zzcaf.zza);
                }
                listenableFutureZzm = zzgdn.zzm(zzbkVarZzb, new zzfve() { // from class: com.google.android.gms.internal.ads.zzbxt
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj2) {
                        int i3 = zzbxv.zzb;
                        return null;
                    }
                }, zzcaf.zzg);
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return listenableFutureZzm;
    }

    public static /* synthetic */ void zzd(zzbxv zzbxvVar, Bitmap bitmap) {
        zzgxx zzgxxVarZzt = zzgxz.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgxxVarZzt);
        synchronized (zzbxvVar.zzj) {
            zzhdk zzhdkVar = zzbxvVar.zzd;
            zzhes zzhesVarZzc = zzheu.zzc();
            zzhesVarZzc.zza(zzgxxVarZzt.zzb());
            zzhesVarZzc.zzb("image/png");
            zzhesVarZzc.zzc(2);
            zzhdkVar.zzi((zzheu) zzhesVarZzc.zzbr());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final zzbxx zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zze(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                try {
                    this.zzm = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            LinkedHashMap linkedHashMap = this.zze;
            if (linkedHashMap.containsKey(str)) {
                if (i == 3) {
                    ((zzhey) linkedHashMap.get(str)).zze(4);
                }
                return;
            }
            zzhey zzheyVarZzd = zzhez.zzd();
            int iZza = zzhex.zza(i);
            if (iZza != 0) {
                zzheyVarZzd.zze(iZza);
            }
            zzheyVarZzd.zzb(linkedHashMap.size());
            zzheyVarZzd.zzd(str);
            zzhdx zzhdxVarZzc = zzhea.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhdv zzhdvVarZzc = zzhdw.zzc();
                        zzhdvVarZzc.zza(zzgxz.zzw(str2));
                        zzhdvVarZzc.zzb(zzgxz.zzw(str3));
                        zzhdxVarZzc.zza((zzhdw) zzhdvVarZzc.zzbr());
                    }
                }
            }
            zzheyVarZzd.zzc((zzhea) zzhdxVarZzc.zzbr());
            linkedHashMap.put(str, zzheyVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zzf() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture listenableFutureZzh = zzgdn.zzh(Collections.emptyMap());
            zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzbxq
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzbxv.zzb(this.zza, (Map) obj);
                }
            };
            zzgdy zzgdyVar = zzcaf.zzg;
            ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzh, zzgcuVar, zzgdyVar);
            ListenableFuture listenableFutureZzo = zzgdn.zzo(listenableFutureZzn, 10L, TimeUnit.SECONDS, zzcaf.zzd);
            zzgdn.zzr(listenableFutureZzn, new zzbxu(this, listenableFutureZzo), zzgdyVar);
            zzc.add(listenableFutureZzo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                    try {
                        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                    } catch (RuntimeException e) {
                        e = e;
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the web view", e);
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the webview", e3);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzbxz.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxr
                @Override // java.lang.Runnable
                public final void run() {
                    zzbxv.zzd(this.zza, bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzcaf.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zzh(String str) {
        synchronized (this.zzj) {
            try {
                if (str == null) {
                    this.zzd.zzd();
                } else {
                    this.zzd.zze(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final boolean zzi() {
        return this.zzi.zzc && !this.zzl;
    }
}
