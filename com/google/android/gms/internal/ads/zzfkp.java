package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfkp {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final zzfle zzc;
    private final zzfkl zzd;
    private final Context zze;
    private volatile ConnectivityManager zzf;
    private final Clock zzg;
    private AtomicInteger zzh;

    public zzfkp(zzfle zzfleVar, zzfkl zzfklVar, Context context, Clock clock) {
        this.zzc = zzfleVar;
        this.zzd = zzfklVar;
        this.zze = context;
        this.zzg = clock;
    }

    public static String zzd(String str, AdFormat adFormat) {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, "#", adFormat == null ? "NULL" : adFormat.name());
    }

    private final synchronized zzfld zzm(String str, AdFormat adFormat) {
        return (zzfld) this.zza.get(zzd(str, adFormat));
    }

    private final synchronized Object zzn(Class cls, String str, AdFormat adFormat) {
        zzfkt zzfktVar = new zzfkt(new zzfkr(str, adFormat), null);
        zzfkl zzfklVar = this.zzd;
        ((DefaultClock) this.zzg).getClass();
        zzfklVar.zzl(System.currentTimeMillis(), zzfktVar, -1, -1, "1");
        zzfld zzfldVarZzm = zzm(str, adFormat);
        if (zzfldVarZzm == null) {
            return null;
        }
        try {
            String strZzo = zzfldVarZzm.zzo();
            Object objZzk = zzfldVarZzm.zzk();
            Object objCast = objZzk == null ? null : cls.cast(objZzk);
            if (objCast != null) {
                zzfklVar.zzm(System.currentTimeMillis(), zzfldVarZzm.zze.zzd, zzfldVarZzm.zzd(), strZzo, zzfktVar, "1");
            }
            return objCast;
        } catch (ClassCastException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "PreloadAdManager.pollAd");
            com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(cls.getName()), e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f6 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0015, B:8:0x0034, B:10:0x003c, B:13:0x004b, B:14:0x0051, B:16:0x0059, B:18:0x0067, B:19:0x0076, B:20:0x007a, B:21:0x007e, B:22:0x0088, B:24:0x008e, B:26:0x00a0, B:27:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00e6, B:35:0x00f9, B:37:0x00ff, B:34:0x00f6), top: B:43:0x0001 }] */
    private final synchronized List zzo(List list) {
        ArrayList arrayList;
        try {
            HashSet hashSet = new HashSet();
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.ads.internal.client.zzfv zzfvVar = (com.google.android.gms.ads.internal.client.zzfv) it.next();
                String strZzd = zzd(zzfvVar.zza, AdFormat.getAdFormat(zzfvVar.zzb));
                hashSet.add(strZzd);
                ConcurrentMap concurrentMap = this.zza;
                zzfld zzfldVar = (zzfld) concurrentMap.get(strZzd);
                if (zzfldVar == null) {
                    ConcurrentMap concurrentMap2 = this.zzb;
                    if (concurrentMap2.containsKey(strZzd)) {
                        zzfld zzfldVar2 = (zzfld) concurrentMap2.get(strZzd);
                        if (zzfldVar2.zze.equals(zzfvVar)) {
                            zzfldVar2.zzB(zzfvVar.zzd);
                            zzfldVar2.zzy();
                            concurrentMap.put(strZzd, zzfldVar2);
                            concurrentMap2.remove(strZzd);
                        } else {
                            arrayList.add(zzfvVar);
                        }
                    } else {
                        arrayList.add(zzfvVar);
                    }
                } else if (zzfldVar.zze.equals(zzfvVar)) {
                    zzfldVar.zzB(zzfvVar.zzd);
                } else {
                    this.zzb.put(strZzd, zzfldVar);
                    concurrentMap.remove(strZzd);
                    arrayList.add(zzfvVar);
                }
            }
            Iterator it2 = this.zza.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains((String) entry.getKey())) {
                    this.zzb.put((String) entry.getKey(), (zzfld) entry.getValue());
                    it2.remove();
                }
            }
            Iterator it3 = this.zzb.entrySet().iterator();
            while (it3.hasNext()) {
                zzfld zzfldVar3 = (zzfld) ((Map.Entry) it3.next()).getValue();
                zzfldVar3.zzA();
                zzbcv zzbcvVar = zzbde.zzy;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzfldVar3.zzv();
                } else {
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzz)).booleanValue()) {
                        zzfldVar3.zzv();
                    }
                }
                if (!zzfldVar3.zzC()) {
                    it3.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    private final synchronized void zzp(String str, zzfld zzfldVar) {
        zzfldVar.zzh();
        this.zza.put(str, zzfldVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzq(boolean z) {
        try {
            if (z) {
                Iterator it = this.zza.values().iterator();
                while (it.hasNext()) {
                    ((zzfld) it.next()).zzy();
                }
            } else {
                Iterator it2 = this.zza.values().iterator();
                while (it2.hasNext()) {
                    ((zzfld) it2.next()).zzf.set(false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzw)).booleanValue()) {
            zzq(z);
        }
    }

    private final synchronized boolean zzs(String str, AdFormat adFormat) {
        boolean z;
        try {
            ((DefaultClock) this.zzg).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzfld zzfldVarZzm = zzm(str, adFormat);
            z = zzfldVarZzm != null && zzfldVarZzm.zzC();
            this.zzd.zzh(zzfldVarZzm == null ? 0 : zzfldVarZzm.zze.zzd, zzfldVarZzm != null ? zzfldVarZzm.zzd() : 0, jCurrentTimeMillis, z ? Long.valueOf(System.currentTimeMillis()) : null, zzfldVarZzm == null ? null : zzfldVarZzm.zzo(), new zzfkt(new zzfkr(str, adFormat), null), "1");
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final synchronized zzbaw zza(String str) {
        return (zzbaw) zzn(zzbaw.class, str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbx zzb(String str) {
        return (com.google.android.gms.ads.internal.client.zzbx) zzn(com.google.android.gms.ads.internal.client.zzbx.class, str, AdFormat.INTERSTITIAL);
    }

    public final synchronized zzbwv zzc(String str) {
        return (zzbwv) zzn(zzbwv.class, str, AdFormat.REWARDED);
    }

    public final void zzg(zzbpq zzbpqVar) {
        this.zzc.zzc(zzbpqVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final synchronized void zzh(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        try {
            List<com.google.android.gms.ads.internal.client.zzfv> listZzo = zzo(list);
            EnumMap enumMap = new EnumMap(AdFormat.class);
            for (com.google.android.gms.ads.internal.client.zzfv zzfvVar : listZzo) {
                String str = zzfvVar.zza;
                AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
                zzfld zzfldVarZza = this.zzc.zza(zzfvVar, zzceVar);
                if (adFormat != null && zzfldVarZza != null) {
                    AtomicInteger atomicInteger = this.zzh;
                    if (atomicInteger != null) {
                        zzfldVarZza.zzx(atomicInteger.get());
                    }
                    zzfkl zzfklVar = this.zzd;
                    zzfldVarZza.zzz(zzfklVar);
                    zzp(zzd(str, adFormat), zzfldVarZza);
                    zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.client.zzf.zza;
                    enumMap.put(adFormat, Integer.valueOf(((Integer) (enumMap.containsKey(adFormat) ? enumMap.get(adFormat) : 0)).intValue() + 1));
                    zzfkt zzfktVar = new zzfkt(new zzfkr(str, adFormat), null);
                    int i = zzfvVar.zzd;
                    ((DefaultClock) this.zzg).getClass();
                    zzfklVar.zzp(i, System.currentTimeMillis(), zzfktVar, "1");
                }
            }
            zzfkl zzfklVar2 = this.zzd;
            ((DefaultClock) this.zzg).getClass();
            zzfklVar2.zzo(enumMap, System.currentTimeMillis(), FKidOcdAYt.AASJoOPJFLpW);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void zzi() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    try {
                        this.zzf = (ConnectivityManager) this.zze.getSystemService("connectivity");
                    } catch (ClassCastException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get connectivity manager", e);
                    }
                }
            }
        }
        if (!Hex.isAtLeastO() || this.zzf == null) {
            this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzD)).intValue());
        } else {
            try {
                this.zzf.registerDefaultNetworkCallback(new zzfko(this));
            } catch (RuntimeException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to register network callback", e2);
                this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzD)).intValue());
            }
        }
        com.google.android.gms.ads.internal.zzv.zza.zzh.zzc(new zzfkn(this));
    }

    public final synchronized boolean zzj(String str) {
        return zzs(str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzk(String str) {
        return zzs(str, AdFormat.INTERSTITIAL);
    }

    public final synchronized boolean zzl(String str) {
        return zzs(str, AdFormat.REWARDED);
    }
}
