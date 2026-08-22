package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhu implements Runnable {
    private final zzfhx zzb;
    private String zzc;
    private String zze;
    private zzfcm zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private Future zzh;
    private final List zza = new ArrayList();
    private int zzi = 2;
    private zzfhz zzd = zzfhz.SCAR_REQUEST_TYPE_UNSPECIFIED;

    public zzfhu(zzfhx zzfhxVar) {
        this.zzb = zzfhxVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfhu zza(zzfhj zzfhjVar) {
        try {
            if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
                List list = this.zza;
                zzfhjVar.zzj();
                list.add(zzfhjVar);
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                this.zzh = zzcaf.zzd.schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjh)).intValue(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfhu zzb(String str) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue() && zzfht.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfhu zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            this.zzg = zzeVar;
        }
        return this;
    }

    public final synchronized zzfhu zzd(ArrayList arrayList) {
        try {
            if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
                if (arrayList.contains("banner") || arrayList.contains("BANNER")) {
                    this.zzi = 3;
                } else if (arrayList.contains("interstitial") || arrayList.contains("INTERSTITIAL")) {
                    this.zzi = 4;
                } else if (arrayList.contains("native") || arrayList.contains("NATIVE")) {
                    this.zzi = 8;
                } else if (arrayList.contains("rewarded") || arrayList.contains("REWARDED")) {
                    this.zzi = 5;
                } else if (arrayList.contains("app_open_ad")) {
                    this.zzi = 7;
                } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains("REWARDED_INTERSTITIAL")) {
                    this.zzi = 6;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfhu zze(String str) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzfhu zzf(Bundle bundle) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            this.zzd = MediaType.Companion.zza(bundle);
        }
        return this;
    }

    public final synchronized zzfhu zzg(zzfcm zzfcmVar) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            this.zzf = zzfcmVar;
        }
        return this;
    }

    public final synchronized void zzh() {
        try {
            if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                List<zzfhj> list = this.zza;
                for (zzfhj zzfhjVar : list) {
                    int i = this.zzi;
                    if (i != 2) {
                        zzfhjVar.zzn(i);
                    }
                    if (!TextUtils.isEmpty(this.zzc)) {
                        zzfhjVar.zze(this.zzc);
                    }
                    if (!TextUtils.isEmpty(this.zze) && !zzfhjVar.zzl()) {
                        zzfhjVar.zzd(this.zze);
                    }
                    zzfcm zzfcmVar = this.zzf;
                    if (zzfcmVar != null) {
                        zzfhjVar.zzb(zzfcmVar);
                    } else {
                        com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
                        if (zzeVar != null) {
                            zzfhjVar.zza(zzeVar);
                        }
                    }
                    zzfhjVar.zzf(this.zzd);
                    this.zzb.zzc(zzfhjVar.zzm());
                }
                list.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzfhu zzi(int i) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
