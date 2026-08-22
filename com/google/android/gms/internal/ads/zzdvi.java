package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdvi implements zzdwk, zzdut {
    private final zzdvt zza;
    private final zzdwl zzb;
    private final zzduu zzc;
    private final zzdvd zzd;
    private final zzdus zze;
    private final zzdwf zzf;
    private final zzdvp zzg;
    private final zzdvp zzh;
    private final String zzi;
    private final Context zzj;
    private final String zzk;
    private JSONObject zzp;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = "{}";
    private long zzq = Long.MAX_VALUE;
    private zzdve zzr = zzdve.NONE;
    private zzdvh zzv = zzdvh.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    public zzdvi(zzdvt zzdvtVar, zzdwl zzdwlVar, zzduu zzduuVar, Context context, VersionInfoParcel versionInfoParcel, zzdvd zzdvdVar, zzdwf zzdwfVar, zzdvp zzdvpVar, zzdvp zzdvpVar2, String str) {
        this.zza = zzdvtVar;
        this.zzb = zzdwlVar;
        this.zzc = zzduuVar;
        this.zze = new zzdus(context);
        this.zzi = versionInfoParcel.afmaVersion;
        this.zzk = str;
        this.zzd = zzdvdVar;
        this.zzf = zzdwfVar;
        this.zzg = zzdvpVar;
        this.zzh = zzdvpVar2;
        this.zzj = context;
        com.google.android.gms.ads.internal.zzv.zza.zzp.zzg = this;
    }

    private final synchronized void zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzx(jSONObject.optBoolean("isTestMode", false), false);
            zzw((zzdve) Enum.valueOf(zzdve.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzo = jSONObject.optString("networkExtras", "{}");
            this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    private final synchronized JSONObject zzt() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.zzl.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (zzduw zzduwVar : (List) entry.getValue()) {
                    if (zzduwVar.zzg()) {
                        jSONArray.put(zzduwVar.zzd());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put((String) entry.getKey(), jSONArray);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    private final void zzu() {
        String str;
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzi(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        zzbcv zzbcvVar = zzbde.zzjT;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!TextUtils.isEmpty((CharSequence) zzbdVar.zzd.zzb(zzbcvVar))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) zzbdVar.zzd.zzb(zzbcvVar)).split(",")));
        }
        zzbcv zzbcvVar2 = zzbde.zzjU;
        if (!TextUtils.isEmpty((CharSequence) zzbdVar.zzd.zzb(zzbcvVar2))) {
            this.zzh.zzb(this.zzj.getSharedPreferences("admob", 0), Arrays.asList(((String) zzbdVar.zzd.zzb(zzbcvVar2)).split(DaWYVMJ.NwXwjGD)));
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzA(((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzk());
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi();
        zzjVar.zzR();
        synchronized (zzjVar.zza) {
            str = zzjVar.zzA;
        }
        this.zzx = str;
    }

    private final void zzv() {
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();
        String strZzd = zzd();
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzgVarZzi;
        zzjVar.getClass();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue()) {
            zzjVar.zzR();
            synchronized (zzjVar.zza) {
                try {
                    if (zzjVar.zzx.equals(strZzd)) {
                        return;
                    }
                    zzjVar.zzx = strZzd;
                    SharedPreferences.Editor editor = zzjVar.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", strZzd);
                        zzjVar.zzg.apply();
                    }
                    zzjVar.zzS();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final synchronized void zzw(zzdve zzdveVar, boolean z) {
        try {
            if (this.zzr != zzdveVar) {
                if (zzq()) {
                    zzy();
                }
                this.zzr = zzdveVar;
                if (zzq()) {
                    zzz();
                }
                if (z) {
                    zzv();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0033 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    private final synchronized void zzx(boolean z, boolean z2) {
        try {
            if (this.zzs != z) {
                this.zzs = z;
                if (z) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue() || !com.google.android.gms.ads.internal.zzv.zza.zzp.zzl()) {
                        zzz();
                    } else if (!zzq()) {
                        zzy();
                    }
                } else if (!zzq()) {
                    zzy();
                }
                if (z2) {
                    zzv();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzy() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzc();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    public final zzdve zza() {
        return this.zzr;
    }

    public final synchronized ListenableFuture zzb(String str) {
        zzcak zzcakVar;
        try {
            zzcakVar = new zzcak();
            Map map = this.zzm;
            if (map.containsKey(str)) {
                zzcakVar.zzc((zzduw) map.get(str));
            } else {
                Map map2 = this.zzn;
                if (!map2.containsKey(str)) {
                    map2.put(str, new ArrayList());
                }
                ((List) map2.get(str)).add(zzcakVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzcakVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue() && zzq()) {
            long j = this.zzq;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            if (j < System.currentTimeMillis() / 1000) {
                this.zzo = "{}";
                this.zzq = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzo.equals("{}")) {
                return this.zzo;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            long j = this.zzq;
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            if (j > System.currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("platform", "ANDROID");
                String str = this.zzk;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("sdkVersion", "afma-sdk-a-v" + str);
                }
                jSONObject.put("internalSdkVersion", this.zzi);
                jSONObject.put("osVersion", Build.VERSION.RELEASE);
                jSONObject.put("adapters", this.zzd.zza());
                zzbcv zzbcvVar = zzbde.zzjQ;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    String strZzn = com.google.android.gms.ads.internal.zzv.zza.zzi.zzn();
                    if (!TextUtils.isEmpty(strZzn)) {
                        jSONObject.put("plugin", strZzn);
                    }
                }
                long j = this.zzq;
                com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                zzvVar.zzl.getClass();
                if (j < System.currentTimeMillis() / 1000) {
                    this.zzo = "{}";
                }
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("adSlots", zzt());
                jSONObject.put("appInfo", this.zze.zza());
                String strZzc = ((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzg().zzc();
                if (!TextUtils.isEmpty(strZzc)) {
                    jSONObject.put("cld", new JSONObject(strZzc));
                }
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjF)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                    String str2 = "Server data: " + jSONObject2.toString();
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze(str2);
                    jSONObject.put("serverData", this.zzp);
                }
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjE)).booleanValue()) {
                    jSONObject.put("openAction", this.zzv);
                    jSONObject.put("gesture", this.zzr);
                }
                jSONObject.put("isGamRegisteredTestDevice", zzvVar.zzp.zzl());
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
                jSONObject.put("isSimulator", com.google.android.gms.ads.internal.util.client.zzf.zzw());
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjS)).booleanValue()) {
                    jSONObject.put("uiStorage", new JSONObject(this.zzx));
                }
                if (!TextUtils.isEmpty((CharSequence) zzbdVar.zzd.zzb(zzbde.zzjU))) {
                    jSONObject.put("gmaDisk", this.zzh.zza());
                }
                if (!TextUtils.isEmpty((CharSequence) zzbdVar.zzd.zzb(zzbde.zzjT))) {
                    jSONObject.put("userDisk", this.zzg.zza());
                }
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "Inspector.toJson");
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Ad inspector encountered an error", e);
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzduw zzduwVar) {
        zzbcv zzbcvVar = zzbde.zzjp;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzq()) {
            if (this.zzt >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzjr)).intValue()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            Map map = this.zzl;
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }
            this.zzt++;
            ((List) map.get(str)).add(zzduwVar);
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjN)).booleanValue()) {
                String strZzc = zzduwVar.zzc();
                this.zzm.put(strZzc, zzduwVar);
                Map map2 = this.zzn;
                if (map2.containsKey(strZzc)) {
                    List list = (List) map2.get(strZzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzcak) it.next()).zzc(zzduwVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        zzbcv zzbcvVar = zzbde.zzjp;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjE)).booleanValue() && ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzM()) {
                zzu();
                return;
            }
            String strZzk = ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzk();
            if (TextUtils.isEmpty(strZzk)) {
                return;
            }
            try {
                if (new JSONObject(strZzk).optBoolean("isTestMode", false)) {
                    zzu();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzdvh zzdvhVar) {
        if (!zzq()) {
            try {
                zzdnVar.zze(zzfdx.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue()) {
            this.zzv = zzdvhVar;
            this.zza.zzj(zzdnVar, new zzbkz(this), new zzbks(this.zzf), new zzbkg(this));
            return;
        } else {
            try {
                zzdnVar.zze(zzfdx.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(iafHZUfOuHNwvy.yOKczuaQwBfY);
                return;
            }
        }
        throw th;
    }

    public final synchronized void zzi(String str, long j) {
        this.zzo = str;
        this.zzq = j;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzC(this.zzx);
    }

    public final synchronized void zzk(long j) {
        this.zzw += j;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public final void zzl(boolean z) {
        if (this.zzu) {
            if (z) {
                if (!this.zzs) {
                    zzz();
                    return;
                }
            }
        } else if (z) {
            zzu();
            if (!this.zzs) {
                zzz();
                return;
            }
        }
        if (zzq()) {
            return;
        }
        zzy();
    }

    public final void zzm(zzdve zzdveVar) {
        zzw(zzdveVar, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z) {
        if (!this.zzu && z) {
            zzu();
        }
        zzx(z, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    public final synchronized boolean zzq() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue()) {
            return this.zzs || com.google.android.gms.ads.internal.zzv.zza.zzp.zzl();
        }
        return this.zzs;
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjK)).longValue();
    }
}
