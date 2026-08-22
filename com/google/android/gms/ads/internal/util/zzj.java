package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.work.Worker;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zza;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzj implements zzg {
    public boolean zzb;
    public ListenableFuture zzd;
    public SharedPreferences zzf;
    public SharedPreferences.Editor zzg;
    public String zzi;
    public String zzj;
    public final Object zza = new Object();
    public final ArrayList zzc = new ArrayList();
    public zzbac zze = null;
    public boolean zzh = true;
    public boolean zzk = true;
    public String zzl = "-1";
    public int zzm = -1;
    public zzbzm zzn = new zzbzm("", 0);
    public long zzo = 0;
    public long zzp = 0;
    public int zzq = -1;
    public int zzr = 0;
    public Set zzs = Collections.emptySet();
    public JSONObject zzt = new JSONObject();
    public boolean zzu = true;
    public boolean zzv = true;
    public String zzw = null;
    public String zzx = "";
    public boolean zzy = false;
    public String zzz = "";
    public String zzA = "{}";
    public int zzB = -1;
    public int zzC = -1;
    public long zzD = 0;

    public final void zzA(int i) {
        zzR();
        synchronized (this.zza) {
            try {
                this.zzm = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    if (i == -1) {
                        editor.remove("gad_has_consent_for_cookies");
                    } else {
                        editor.putInt("gad_has_consent_for_cookies", i);
                    }
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzC(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjS)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                try {
                    if (this.zzA.equals(str)) {
                        return;
                    }
                    this.zzA = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.zzg.apply();
                    }
                    zzS();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzD(boolean z) {
        zzR();
        synchronized (this.zza) {
            try {
                if (z == this.zzk) {
                    return;
                }
                this.zzk = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzE(boolean z) {
        zzR();
        synchronized (this.zza) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkT)).longValue();
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("is_topics_ad_personalization_allowed", z);
                    this.zzg.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzG(int i) {
        zzR();
        synchronized (this.zza) {
            try {
                if (this.zzq == i) {
                    return;
                }
                this.zzq = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzH(int i) {
        zzR();
        synchronized (this.zza) {
            try {
                if (this.zzC == i) {
                    return;
                }
                this.zzC = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzI(long j) {
        zzR();
        synchronized (this.zza) {
            try {
                if (this.zzD == j) {
                    return;
                }
                this.zzD = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzJ(String str) {
        zzR();
        synchronized (this.zza) {
            try {
                this.zzl = str;
                if (this.zzg != null) {
                    if (str.equals("-1")) {
                        this.zzg.remove("IABTCF_TCString");
                    } else {
                        this.zzg.putString("IABTCF_TCString", str);
                    }
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzK() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzL() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzv;
        }
        return z;
    }

    public final boolean zzM() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzy;
        }
        return z;
    }

    public final boolean zzN() {
        boolean z;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaL)).booleanValue()) {
            return false;
        }
        zzR();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    public final void zzR() {
        ListenableFuture listenableFuture = this.zzd;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return;
        }
        try {
            this.zzd.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            int i = zze.$r8$clinit;
            zzo.zzk("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException e2) {
            e = e2;
            int i2 = zze.$r8$clinit;
            zzo.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e3) {
            e = e3;
            int i3 = zze.$r8$clinit;
            zzo.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e4) {
            e = e4;
            int i4 = zze.$r8$clinit;
            zzo.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    public final void zzS() {
        zzcaf.zza.execute(new Worker.AnonymousClass1(this, 28));
    }

    public final int zzc() {
        int i;
        zzR();
        synchronized (this.zza) {
            i = this.zzq;
        }
        return i;
    }

    public final long zzd() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzo;
        }
        return j;
    }

    public final long zze() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzp;
        }
        return j;
    }

    public final zzbzm zzg() {
        zzbzm zzbzmVar;
        zzR();
        synchronized (this.zza) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmd)).booleanValue() && this.zzn.zzj()) {
                    Iterator it = this.zzc.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
                zzbzmVar = this.zzn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbzmVar;
    }

    public final String zzj() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzw;
        }
        return str;
    }

    public final String zzk() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzx;
        }
        return str;
    }

    public final JSONObject zzn() {
        JSONObject jSONObject;
        zzR();
        synchronized (this.zza) {
            jSONObject = this.zzt;
        }
        return jSONObject;
    }

    public final void zzp(Context context) {
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    return;
                }
                this.zzd = zzcaf.zza.zza(new zza(this, context, 21));
                this.zzb = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzq() {
        zzR();
        synchronized (this.zza) {
            try {
                this.zzt = new JSONObject();
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.remove("native_advanced_settings");
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzt(int i) {
        zzR();
        synchronized (this.zza) {
            try {
                if (this.zzr == i) {
                    return;
                }
                this.zzr = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzw(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                try {
                    if (this.zzz.equals(str)) {
                        return;
                    }
                    this.zzz = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzS();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzx(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                try {
                    if (this.zzy == z) {
                        return;
                    }
                    this.zzy = z;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.zzg.apply();
                    }
                    zzS();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzy(String str) {
        zzR();
        synchronized (this.zza) {
            try {
                if (TextUtils.equals(this.zzw, str)) {
                    return;
                }
                this.zzw = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzz(long j) {
        zzR();
        synchronized (this.zza) {
            try {
                if (this.zzp == j) {
                    return;
                }
                this.zzp = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzF(String str, String str2, boolean z) {
        zzR();
        synchronized (this.zza) {
            try {
                JSONArray jSONArrayOptJSONArray = this.zzt.optJSONArray(str);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null) {
                        return;
                    }
                    if (str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                        if (z && jSONObjectOptJSONObject.optBoolean("uses_media_view", false)) {
                            return;
                        }
                        length = i;
                        break;
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("template_id", str2);
                    jSONObject.put("uses_media_view", z);
                    String str3 = TSDAbK.oQRiHhiGU;
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    jSONObject.put(str3, System.currentTimeMillis());
                    jSONArrayOptJSONArray.put(length, jSONObject);
                    this.zzt.put(str, jSONArrayOptJSONArray);
                } catch (JSONException e) {
                    int i2 = zze.$r8$clinit;
                    zzo.zzk("Could not update native advanced settings", e);
                }
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("native_advanced_settings", this.zzt.toString());
                    this.zzg.apply();
                }
                zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
