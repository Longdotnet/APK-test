package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzu {
    public final /* synthetic */ zzaa zza;
    public final String zzb;
    public final boolean zzc;
    public final com.google.android.gms.internal.measurement.zzgi zzd;
    public final BitSet zze;
    public final BitSet zzf;
    public final ArrayMap zzg;
    public final ArrayMap zzh;

    public zzu(zzaa zzaaVar, String str) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    public final zzfp zza(int i) {
        ArrayList arrayList;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzfo zzfoVarZzb = zzfp.zzb();
        zzfoVarZzb.zza(i);
        zzfoVarZzb.zzc(this.zzc);
        com.google.android.gms.internal.measurement.zzgi zzgiVar = this.zzd;
        if (zzgiVar != null) {
            zzfoVarZzb.zzd(zzgiVar);
        }
        zzgh zzghVarZzf = com.google.android.gms.internal.measurement.zzgi.zzf();
        zzghVarZzf.zzb(zzen.zzr(this.zze));
        zzghVarZzf.zzd(zzen.zzr(this.zzf));
        ArrayMap arrayMap = this.zzg;
        if (arrayMap == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(arrayMap.mSize);
            for (Integer num : (MapCollections$KeySet) arrayMap.keySet()) {
                int iIntValue = num.intValue();
                Long l = (Long) arrayMap.getOrDefault(num, null);
                if (l != null) {
                    zzfq zzfqVarZzc = com.google.android.gms.internal.measurement.zzfr.zzc();
                    zzfqVarZzc.zzb(iIntValue);
                    zzfqVarZzc.zza(l.longValue());
                    arrayList.add((com.google.android.gms.internal.measurement.zzfr) zzfqVarZzc.zzaC());
                }
            }
        }
        if (arrayList != null) {
            zzghVarZzf.zza(arrayList);
        }
        ArrayMap arrayMap2 = this.zzh;
        if (arrayMap2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap2.mSize);
            for (Integer num2 : (MapCollections$KeySet) arrayMap2.keySet()) {
                com.google.android.gms.internal.measurement.zzgj zzgjVarZzd = zzgk.zzd();
                zzgjVarZzd.zzb(num2.intValue());
                List list = (List) arrayMap2.getOrDefault(num2, null);
                if (list != null) {
                    Collections.sort(list);
                    zzgjVarZzd.zza(list);
                }
                arrayList2.add((zzgk) zzgjVarZzd.zzaC());
            }
            listEmptyList = arrayList2;
        }
        zzghVarZzf.zzc(listEmptyList);
        zzfoVarZzb.zzb(zzghVarZzf);
        return (zzfp) zzfoVarZzb.zzaC();
    }

    public final void zzc(zzx zzxVar) {
        int iZzb;
        boolean z;
        boolean zZzo;
        switch (zzxVar.$r8$classId) {
            case 0:
                iZzb = ((zzek) zzxVar.zzh).zzb();
                break;
            default:
                iZzb = ((zzet) zzxVar.zzh).zza();
                break;
        }
        Boolean bool = zzxVar.zzd;
        if (bool != null) {
            this.zzf.set(iZzb, bool.booleanValue());
        }
        Boolean bool2 = zzxVar.zze;
        if (bool2 != null) {
            this.zze.set(iZzb, bool2.booleanValue());
        }
        if (zzxVar.zzf != null) {
            Integer numValueOf = Integer.valueOf(iZzb);
            ArrayMap arrayMap = this.zzg;
            Long l = (Long) arrayMap.getOrDefault(numValueOf, null);
            long jLongValue = zzxVar.zzf.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                arrayMap.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (zzxVar.zzg != null) {
            ArrayMap arrayMap2 = this.zzh;
            Integer numValueOf2 = Integer.valueOf(iZzb);
            List arrayList = (List) arrayMap2.getOrDefault(numValueOf2, null);
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayMap2.put(numValueOf2, arrayList);
            }
            switch (zzxVar.$r8$classId) {
                case 0:
                    z = false;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                arrayList.clear();
            }
            zznz.zzc();
            zzaa zzaaVar = this.zza;
            zzag zzagVar = ((zzfr) zzaaVar.mBuilder).zzk;
            zzdt zzdtVar = zzdu.zzW;
            String str = this.zzb;
            if (zzagVar.zzs(str, zzdtVar)) {
                switch (zzxVar.$r8$classId) {
                    case 0:
                        zZzo = ((zzek) zzxVar.zzh).zzo();
                        break;
                    default:
                        zZzo = false;
                        break;
                }
                if (zZzo) {
                    arrayList.clear();
                }
            }
            zznz.zzc();
            if (!((zzfr) zzaaVar.mBuilder).zzk.zzs(str, zzdtVar)) {
                arrayList.add(Long.valueOf(zzxVar.zzg.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(zzxVar.zzg.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = arrayMap;
        this.zzh = new ArrayMap();
        for (Integer num : (MapCollections$KeySet) arrayMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.getOrDefault(num, null));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgiVar;
    }
}
