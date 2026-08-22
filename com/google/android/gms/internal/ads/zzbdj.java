package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzbdj {
    String zzd;
    Context zze;
    String zzf;
    private AtomicBoolean zzh;
    private File zzi;
    final BlockingQueue zza = new ArrayBlockingQueue(100);
    final LinkedHashMap zzb = new LinkedHashMap();
    final Map zzc = new HashMap();
    private final HashSet zzg = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public static /* synthetic */ void zzc(zzbdj zzbdjVar) throws Throwable {
        while (true) {
            try {
                zzbdt zzbdtVar = (zzbdt) zzbdjVar.zza.take();
                zzbds zzbdsVarZza = zzbdtVar.zza();
                if (!TextUtils.isEmpty(zzbdsVarZza.zzb())) {
                    zzbdjVar.zzg(zzbdjVar.zzb(zzbdjVar.zzb, zzbdtVar.zzb()), zzbdsVarZza);
                }
            } catch (InterruptedException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public final zzbdp zza(String str) {
        zzbdp zzbdpVar = (zzbdp) this.zzc.get(str);
        return zzbdpVar != null ? zzbdpVar : zzbdp.zza;
    }

    public final Map zzb(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zza(str).zza((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public final void zzd(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzh = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbez.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(zzfqt.zza(zzfqs.zza(), externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdi
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzbdj.zzc(this.zza);
            }
        });
        Map map2 = this.zzc;
        zzbdp zzbdpVar = zzbdp.zzb;
        map2.put("action", zzbdpVar);
        map2.put(FirebaseAnalytics.Param.AD_FORMAT, zzbdpVar);
        map2.put("e", zzbdp.zzc);
    }

    public final void zze(String str) throws Throwable {
        if (this.zzg.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzf);
        linkedHashMap.put("ue", str);
        zzg(zzb(this.zzb, linkedHashMap), null);
    }

    public final boolean zzf(zzbdt zzbdtVar) {
        return this.zza.offer(zzbdtVar);
    }

    private final void zzg(Map map, zzbds zzbdsVar) throws Throwable {
        Uri.Builder builderBuildUpon = Uri.parse(this.zzd).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbdsVar != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!TextUtils.isEmpty(zzbdsVar.zzb())) {
                sb.append("&it=");
                sb.append(zzbdsVar.zzb());
            }
            if (!TextUtils.isEmpty(zzbdsVar.zza())) {
                sb.append(xPQrbOSWiEdU.VLcggVrdpWAqHWV);
                sb.append(zzbdsVar.zza());
            }
            string = sb.toString();
        }
        FileOutputStream fileOutputStream = null;
        if (!this.zzh.get()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            new com.google.android.gms.ads.internal.util.zzbw(this.zze, this.zzf, string, null).zzb();
            return;
        }
        File file = this.zzi;
        try {
            if (file == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
                return;
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(string.getBytes());
                    fileOutputStream2.write(10);
                    try {
                        fileOutputStream2.close();
                        return;
                    } catch (IOException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                        return;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e3) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
            }
        }
        throw th;
    }
}
