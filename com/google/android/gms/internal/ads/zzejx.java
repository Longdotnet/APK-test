package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.os.SystemClock;
import androidx.loader.app.gv.DYYbQc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzejx extends zzbrr {
    private final String zza;
    private final zzbrp zzb;
    private final zzcak zzc;
    private final JSONObject zzd;
    private final long zze;
    private boolean zzf;

    public zzejx(String str, zzbrp zzbrpVar, zzcak zzcakVar, long j) {
        JSONObject jSONObject = new JSONObject();
        this.zzd = jSONObject;
        this.zzf = false;
        this.zzc = zzcakVar;
        this.zza = str;
        this.zzb = zzbrpVar;
        this.zze = j;
        try {
            jSONObject.put("adapter_version", zzbrpVar.zzf().toString());
            jSONObject.put("sdk_version", zzbrpVar.zzg().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public static synchronized void zzb(String str, zzcak zzcakVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbM)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzcakVar.zzc(jSONObject);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzh(String str, int i) {
        try {
            if (this.zzf) {
                return;
            }
            try {
                JSONObject jSONObject = this.zzd;
                jSONObject.put("signal_error", str);
                zzbcv zzbcvVar = zzbde.zzbN;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    jSONObject.put("latency", SystemClock.elapsedRealtime() - this.zze);
                }
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzbM)).booleanValue()) {
                    jSONObject.put("signal_error_code", i);
                }
            } catch (JSONException unused) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        zzh(DYYbQc.aORBgPNzWzZEfz, 3);
    }

    public final synchronized void zzd() {
        if (this.zzf) {
            return;
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbM)).booleanValue()) {
                this.zzd.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final synchronized void zze(String str) {
        if (this.zzf) {
            return;
        }
        if (str == null) {
            zzf("Adapter returned null signals");
            return;
        }
        try {
            JSONObject jSONObject = this.zzd;
            jSONObject.put("signals", str);
            zzbcv zzbcvVar = zzbde.zzbN;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                jSONObject.put("latency", SystemClock.elapsedRealtime() - this.zze);
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzbM)).booleanValue()) {
                jSONObject.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final synchronized void zzf(String str) {
        zzh(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final synchronized void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzh(zzeVar.zzb, 2);
    }
}
