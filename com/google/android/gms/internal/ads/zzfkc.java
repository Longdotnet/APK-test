package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkc {
    private final Map zza;
    private final zzfle zzb;
    private final zzfkl zzc;
    private final Clock zzd;

    public zzfkc(zzfle zzfleVar, zzfkl zzfklVar, Context context, Clock clock) {
        HashMap map = new HashMap();
        this.zza = map;
        map.put(AdFormat.APP_OPEN_AD, new HashMap());
        map.put(AdFormat.INTERSTITIAL, new HashMap());
        map.put(AdFormat.REWARDED, new HashMap());
        this.zzb = zzfleVar;
        this.zzc = zzfklVar;
        this.zzd = clock;
    }

    private final synchronized Object zzk(Class cls, AdFormat adFormat, String str) {
        zzfkl zzfklVar = this.zzc;
        ((DefaultClock) this.zzd).getClass();
        zzfklVar.zzg(System.currentTimeMillis(), "2");
        Map map = this.zza;
        if (!map.containsKey(adFormat)) {
            return null;
        }
        zzfld zzfldVar = (zzfld) ((Map) map.get(adFormat)).get(str);
        if (zzfldVar != null && adFormat.equals(zzfldVar.zze())) {
            zzfkr zzfkrVar = new zzfkr(zzfldVar.zze.zza, zzfldVar.zze());
            zzfkrVar.zzb(str);
            zzfkt zzfktVar = new zzfkt(zzfkrVar, null);
            zzfklVar.zzl(System.currentTimeMillis(), zzfktVar, zzfldVar.zze.zzd, zzfldVar.zzd(), "2");
            try {
                String strZzo = zzfldVar.zzo();
                Object objZzk = zzfldVar.zzk();
                Object objCast = objZzk == null ? null : cls.cast(objZzk);
                if (objCast != null) {
                    zzfklVar.zzm(System.currentTimeMillis(), zzfldVar.zze.zzd, zzfldVar.zzd(), strZzo, zzfktVar, "2");
                }
                return objCast;
            } catch (ClassCastException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "PreloadAdManager.pollAd");
                com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(cls.getName()), e);
                return null;
            }
        }
        return null;
    }

    private final synchronized boolean zzl(AdFormat adFormat) {
        int size;
        int iMax;
        try {
            Map map = this.zza;
            size = map.containsKey(adFormat) ? ((Map) map.get(adFormat)).size() : 0;
            int iOrdinal = adFormat.ordinal();
            if (iOrdinal == 1) {
                iMax = Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeM)).intValue(), 1);
            } else if (iOrdinal == 2) {
                iMax = Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeN)).intValue(), 1);
            } else if (iOrdinal != 5) {
                iMax = 0;
            } else {
                iMax = Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeO)).intValue(), 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return size < iMax;
    }

    public final synchronized int zza(AdFormat adFormat, String str) {
        Map map = this.zza;
        int iZzd = 0;
        if (!map.containsKey(adFormat)) {
            return 0;
        }
        zzfld zzfldVar = (zzfld) ((Map) map.get(adFormat)).get(str);
        if (zzfldVar != null) {
            iZzd = zzfldVar.zzd();
        }
        zzfkl zzfklVar = this.zzc;
        ((DefaultClock) this.zzd).getClass();
        zzfklVar.zzf(iZzd, System.currentTimeMillis(), str, zzfldVar == null ? null : zzfldVar.zze.zza, adFormat, zzfldVar == null ? -1 : zzfldVar.zze.zzd);
        return iZzd;
    }

    public final synchronized zzbaw zzb(String str) {
        return (zzbaw) zzk(zzbaw.class, AdFormat.APP_OPEN_AD, str);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbx zzc(String str) {
        return (com.google.android.gms.ads.internal.client.zzbx) zzk(com.google.android.gms.ads.internal.client.zzbx.class, AdFormat.INTERSTITIAL, str);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzfv zzd(AdFormat adFormat, String str) {
        Map map = this.zza;
        if (map.containsKey(adFormat)) {
            zzfld zzfldVar = (zzfld) ((Map) map.get(adFormat)).get(str);
            zzfkl zzfklVar = this.zzc;
            ((DefaultClock) this.zzd).getClass();
            zzfklVar.zzd(System.currentTimeMillis(), str, zzfldVar == null ? null : zzfldVar.zze.zza, adFormat, zzfldVar == null ? -1 : zzfldVar.zze.zzd, zzfldVar != null ? zzfldVar.zzd() : -1);
            if (zzfldVar != null) {
                return zzfldVar.zze;
            }
        }
        return null;
    }

    public final synchronized zzbwv zze(String str) {
        return (zzbwv) zzk(zzbwv.class, AdFormat.REWARDED, str);
    }

    public final synchronized Map zzf(int i) {
        try {
            HashMap map = new HashMap();
            AdFormat adFormat = AdFormat.getAdFormat(i);
            if (adFormat != null) {
                Map map2 = this.zza;
                if (map2.containsKey(adFormat)) {
                    for (zzfld zzfldVar : ((Map) map2.get(adFormat)).values()) {
                        map.put(zzfldVar.zzn(), zzfldVar.zze);
                    }
                    zzfkl zzfklVar = this.zzc;
                    ((DefaultClock) this.zzd).getClass();
                    zzfklVar.zze(adFormat, System.currentTimeMillis(), map.size());
                    return map;
                }
            }
            return map;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzg(int i) {
        try {
            AdFormat adFormat = AdFormat.getAdFormat(i);
            if (adFormat != null) {
                Map map = this.zza;
                if (map.containsKey(adFormat)) {
                    Map map2 = (Map) map.get(adFormat);
                    int size = map2.size();
                    for (String str : map2.keySet()) {
                        zzfld zzfldVar = (zzfld) map2.get(str);
                        if (zzfldVar != null) {
                            zzfldVar.zzA();
                            zzfldVar.zzv();
                            String strValueOf = String.valueOf(str);
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Destroyed ad preloader for preloadId: ".concat(strValueOf));
                        }
                    }
                    map2.clear();
                    String strConcat = "Destroyed all ad preloaders for ad format: ".concat(adFormat.toString());
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
                    zzfkl zzfklVar = this.zzc;
                    ((DefaultClock) this.zzd).getClass();
                    zzfklVar.zzc(System.currentTimeMillis(), adFormat, size);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzh(AdFormat adFormat, String str) {
        zzfld zzfldVar;
        Map map = this.zza;
        if (map.containsKey(adFormat) && (zzfldVar = (zzfld) ((Map) map.get(adFormat)).get(str)) != null) {
            ((Map) map.get(adFormat)).remove(str);
            zzfldVar.zzA();
            zzfldVar.zzv();
            zzfkl zzfklVar = this.zzc;
            ((DefaultClock) this.zzd).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = zzfldVar.zze;
            zzfklVar.zzb(jCurrentTimeMillis, str, zzfvVar.zza, adFormat, zzfvVar.zzd, zzfldVar.zzd());
            return true;
        }
        return false;
    }

    public final synchronized boolean zzi(AdFormat adFormat, String str) {
        zzfkt zzfktVar;
        try {
            ((DefaultClock) this.zzd).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Map map = this.zza;
            if (!map.containsKey(adFormat)) {
                return false;
            }
            zzfld zzfldVar = (zzfld) ((Map) map.get(adFormat)).get(str);
            String strZzo = zzfldVar == null ? null : zzfldVar.zzo();
            boolean z = strZzo != null && adFormat.equals(zzfldVar.zze());
            Long lValueOf = z ? Long.valueOf(System.currentTimeMillis()) : null;
            if (zzfldVar == null) {
                zzfktVar = null;
            } else {
                zzfkr zzfkrVar = new zzfkr(zzfldVar.zze.zza, adFormat);
                zzfkrVar.zzb(str);
                zzfktVar = new zzfkt(zzfkrVar, null);
            }
            this.zzc.zzh(zzfldVar == null ? 0 : zzfldVar.zze.zzd, zzfldVar == null ? 0 : zzfldVar.zzd(), jCurrentTimeMillis, lValueOf, strZzo, zzfktVar, "2");
            return z;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzj(String str, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        zzfld zzfldVarZzb;
        AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
        if (adFormat != null) {
            Map map = this.zza;
            if (map.containsKey(adFormat) && !((Map) map.get(adFormat)).containsKey(str) && zzl(adFormat) && (zzfldVarZzb = this.zzb.zzb(str, zzfvVar, zzchVar)) != null) {
                zzfkl zzfklVar = this.zzc;
                zzfldVarZzb.zzz(zzfklVar);
                zzfldVarZzb.zzh();
                ((Map) map.get(adFormat)).put(str, zzfldVarZzb);
                zzfkr zzfkrVar = new zzfkr(zzfvVar.zza, adFormat);
                zzfkrVar.zzb(str);
                zzfkt zzfktVar = new zzfkt(zzfkrVar, null);
                int i = zzfvVar.zzd;
                ((DefaultClock) this.zzd).getClass();
                zzfklVar.zzp(i, System.currentTimeMillis(), zzfktVar, "2");
                return true;
            }
        }
        return false;
    }
}
