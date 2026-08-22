package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.Iterator;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends zze {
    public final ArrayMap zza;
    public final ArrayMap zzb;
    public long zzc;

    public zzd(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    public final void zzd(String str, long j) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str == null || str.length() == 0) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Ad unit id must be a non-empty string");
        } else {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zza(this, str, j, 0));
        }
    }

    public final void zze(String str, long j) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str == null || str.length() == 0) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Ad unit id must be a non-empty string");
        } else {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zza(this, str, j, 1));
        }
    }

    public final void zzf(long j) {
        zzim zzimVar = ((zzfr) this.mBuilder).zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVarZzj = zzimVar.zzj(false);
        ArrayMap arrayMap = this.zza;
        for (String str : (MapCollections$KeySet) arrayMap.keySet()) {
            zzi(str, j - ((Long) arrayMap.getOrDefault(str, null)).longValue(), zzieVarZzj);
        }
        if (!arrayMap.isEmpty()) {
            zzh(j - this.zzc, zzieVarZzj);
        }
        zzj(j);
    }

    public final void zzj(long j) {
        ArrayMap arrayMap = this.zza;
        Iterator it = ((MapCollections$KeySet) arrayMap.keySet()).iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j));
        }
        if (arrayMap.isEmpty()) {
            return;
        }
        this.zzc = j;
    }

    public final void zzh(long j, zzie zzieVar) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzieVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Not logging ad exposure. No active activity");
        } else {
            if (j < 1000) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzb(Long.valueOf(j), "Not logging ad exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzlb.zzK(zzieVar, bundle, true);
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("am", wsbWxekY.PsfcjNGFbgjPVy, bundle);
        }
    }

    public final void zzi(String str, long j, zzie zzieVar) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzieVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Not logging ad unit exposure. No active activity");
        } else {
            if (j < 1000) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzb(Long.valueOf(j), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong(mnwSv.yDs, j);
            zzlb.zzK(zzieVar, bundle, true);
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("am", "_xu", bundle);
        }
    }
}
