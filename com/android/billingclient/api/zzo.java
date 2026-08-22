package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkerWrapper;
import com.facebook.ProfileCache;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzfte;
import com.google.android.gms.internal.ads.zzftf;
import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzfuc;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzfuq;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzo {
    public Object zza;
    public Object zzb;
    public Object zze;
    public Object zzf;
    public Object zzg;
    public boolean zzh;

    public void zzg(String str, String str2) {
        zze.zza(str);
        if (((zzcfg) this.zze) != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(this, "onError", map, 10, false));
        }
    }

    public void zzj(zzcfg zzcfgVar, zzfty zzftyVar) {
        if (zzcfgVar == null) {
            zzg("adWebview missing", "onLMDShow");
            return;
        }
        this.zze = zzcfgVar;
        if (!this.zzh && !zzk(zzcfgVar.getContext())) {
            zzg("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlU)).booleanValue()) {
            this.zzb = zzftyVar.zzh();
        }
        if (((ProfileCache) this.zzg) == null) {
            this.zzg = new ProfileCache(this);
        }
        zzfte zzfteVar = (zzfte) this.zzf;
        if (zzfteVar != null) {
            zzfteVar.zzd(zzftyVar, (ProfileCache) this.zzg);
        }
    }

    public synchronized boolean zzk(Context context) {
        if (!zzfuq.zza(context)) {
            return false;
        }
        try {
            this.zzf = zzftf.zza(context);
        } catch (NullPointerException e) {
            zze.zza(dLDI.JzsuCNroe);
            zzv.zza.zzi.zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (((zzfte) this.zzf) == null) {
            this.zzh = false;
            return false;
        }
        if (((ProfileCache) this.zzg) == null) {
            this.zzg = new ProfileCache(this);
        }
        this.zzh = true;
        return true;
    }

    public zzfud zzl() {
        zzfuc zzfucVarZzc = zzfud.zzc();
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlU)).booleanValue() || TextUtils.isEmpty((String) this.zzb)) {
            String str = (String) this.zza;
            if (str != null) {
                zzfucVarZzc.zzb(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfucVarZzc.zza((String) this.zzb);
        }
        return zzfucVarZzc.zzc();
    }

    public void zzg(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        ((zzn) this.zzg).zza((Context) this.zza, intentFilter2);
        if (this.zzh) {
            zzn zznVar = (zzn) this.zzf;
            Context context = (Context) this.zza;
            synchronized (zznVar) {
                try {
                    if (!zznVar.zzb) {
                        if (Build.VERSION.SDK_INT < 33) {
                            context.registerReceiver(zznVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                        } else {
                            context.registerReceiver(zznVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != zznVar.zzc ? 4 : 2);
                        }
                        zznVar.zzb = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        ((zzn) this.zzf).zza((Context) this.zza, intentFilter);
    }
}
