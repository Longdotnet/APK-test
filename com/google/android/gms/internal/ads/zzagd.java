package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzagd extends zzagf {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzagd() {
        super(new zzadr());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzen zzenVar) {
        return Double.valueOf(Double.longBitsToDouble(zzenVar.zzt()));
    }

    private static Object zzh(zzen zzenVar, int i) {
        if (i == 0) {
            return zzg(zzenVar);
        }
        if (i == 1) {
            return Boolean.valueOf(zzenVar.zzm() == 1);
        }
        if (i == 2) {
            return zzi(zzenVar);
        }
        if (i != 3) {
            if (i == 8) {
                return zzj(zzenVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzenVar).doubleValue());
                zzenVar.zzM(2);
                return date;
            }
            int iZzp = zzenVar.zzp();
            ArrayList arrayList = new ArrayList(iZzp);
            for (int i2 = 0; i2 < iZzp; i2++) {
                Object objZzh = zzh(zzenVar, zzenVar.zzm());
                if (objZzh != null) {
                    arrayList.add(objZzh);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzi = zzi(zzenVar);
            int iZzm = zzenVar.zzm();
            if (iZzm == 9) {
                return map;
            }
            Object objZzh2 = zzh(zzenVar, iZzm);
            if (objZzh2 != null) {
                map.put(strZzi, objZzh2);
            }
        }
    }

    private static String zzi(zzen zzenVar) {
        int iZzq = zzenVar.zzq();
        int iZzc = zzenVar.zzc();
        zzenVar.zzM(iZzq);
        return new String(zzenVar.zzN(), iZzc, iZzq);
    }

    private static HashMap zzj(zzen zzenVar) {
        int iZzp = zzenVar.zzp();
        HashMap map = new HashMap(iZzp);
        for (int i = 0; i < iZzp; i++) {
            String strZzi = zzi(zzenVar);
            Object objZzh = zzh(zzenVar, zzenVar.zzm());
            if (objZzh != null) {
                map.put(strZzi, objZzh);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zza(zzen zzenVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zzb(zzen zzenVar, long j) {
        if (zzenVar.zzm() == 2 && "onMetaData".equals(zzi(zzenVar)) && zzenVar.zza() != 0 && zzenVar.zzm() == 8) {
            HashMap mapZzj = zzj(zzenVar);
            Object obj = mapZzj.get("duration");
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzj.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i = 0; i < size; i++) {
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }
}
