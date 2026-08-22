package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsu {
    private final String zze;
    private final zzdso zzf;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final com.google.android.gms.ads.internal.util.zzg zza = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();

    public zzdsu(String str, zzdso zzdsoVar) {
        this.zze = str;
        this.zzf = zzdsoVar;
    }

    private final Map zzg() {
        Map mapZza = this.zzf.zza();
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        mapZza.put("tms", Long.toString(SystemClock.elapsedRealtime(), 10));
        mapZza.put("tid", ((com.google.android.gms.ads.internal.util.zzj) this.zza).zzN() ? "" : this.zze);
        return mapZza;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "aaia");
            mapZzg.put("aair", "MalformedJson");
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_finished");
            mapZzg.put("ancn", str);
            mapZzg.put("rqe", str2);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_started");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_finished");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zze() {
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue() && !this.zzd) {
                Map mapZzg = zzg();
                mapZzg.put("action", "init_finished");
                List list = this.zzb;
                list.add(mapZzg);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.zzf.zzg((Map) it.next());
                }
                this.zzd = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcl)).booleanValue() && !this.zzc) {
            Map mapZzg = zzg();
            mapZzg.put("action", "init_started");
            this.zzb.add(mapZzg);
            this.zzc = true;
        }
    }
}
