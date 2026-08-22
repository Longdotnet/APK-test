package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public class zzdss {
    protected final Map zza;
    protected final Context zzb;
    protected final Executor zzc;
    protected final com.google.android.gms.ads.internal.util.client.zzu zzd;
    protected final boolean zze;
    private final CsiUrlBuilder zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final AtomicBoolean zzi;
    private final AtomicReference zzj;

    public zzdss(Executor executor, com.google.android.gms.ads.internal.util.client.zzu zzuVar, CsiUrlBuilder csiUrlBuilder, Context context) {
        this.zza = new HashMap();
        this.zzi = new AtomicBoolean();
        this.zzj = new AtomicReference(new Bundle());
        this.zzc = executor;
        this.zzd = zzuVar;
        zzbcv zzbcvVar = zzbde.zzcj;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        this.zze = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        this.zzf = csiUrlBuilder;
        this.zzg = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzco)).booleanValue();
        this.zzh = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzhh)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map) {
        Bundle bundleZzb;
        if (map == null || map.isEmpty()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Empty or null paramMap.");
            return;
        }
        if (!this.zzi.getAndSet(true)) {
            final String str = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkW);
            Context context = this.zzb;
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.ads.zzdsq
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                    zzdss zzdssVar = this.zza;
                    zzdssVar.zzj.set(StringsKt__IndentKt.zzb(zzdssVar.zzb, str));
                }
            };
            if (TextUtils.isEmpty(str)) {
                bundleZzb = Bundle.EMPTY;
            } else {
                PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                bundleZzb = StringsKt__IndentKt.zzb(context, str);
            }
            this.zzj.set(bundleZzb);
        }
        Bundle bundle = (Bundle) this.zzj.get();
        for (String str2 : bundle.keySet()) {
            map.put(str2, String.valueOf(bundle.get(str2)));
        }
    }

    private final void zzh(Map map, boolean z) {
        if (map.isEmpty()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Empty paramMap.");
            return;
        }
        zza(map);
        final String strGenerateUrl = this.zzf.generateUrl(map);
        com.google.android.gms.ads.internal.util.zze.zza(strGenerateUrl);
        boolean z2 = Boolean.parseBoolean((String) map.get("scar"));
        if (this.zze) {
            if (!z || this.zzg) {
                if (!z2 || this.zzh) {
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsp
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd.zza(strGenerateUrl);
                        }
                    });
                }
            }
        }
    }

    public final String zzb(Map map) {
        return this.zzf.generateUrl(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zza);
    }

    public final void zze(Map map) {
        if (map.isEmpty()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Empty paramMap.");
            return;
        }
        zza(map);
        final String strGenerateUrl = this.zzf.generateUrl(map);
        com.google.android.gms.ads.internal.util.zze.zza(strGenerateUrl);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznA)).booleanValue() || this.zze) {
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zza(strGenerateUrl);
                }
            });
        }
    }

    public final void zzf(Map map) {
        zzh(map, true);
    }

    public final void zzg(Map map) {
        zzh(map, false);
    }
}
