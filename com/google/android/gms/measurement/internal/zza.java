package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public /* synthetic */ zza(zzd zzdVar, String str, long j, int i) {
        this.$r8$classId = i;
        this.zzc = zzdVar;
        this.zza = str;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzd zzdVar = this.zzc;
                zzdVar.zzg();
                String str = this.zza;
                com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                ArrayMap arrayMap = zzdVar.zzb;
                boolean zIsEmpty = arrayMap.isEmpty();
                long j = this.zzb;
                if (zIsEmpty) {
                    zzdVar.zzc = j;
                }
                Integer num = (Integer) arrayMap.getOrDefault(str, null);
                if (num != null) {
                    arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
                } else if (arrayMap.mSize < 100) {
                    arrayMap.put(str, 1);
                    zzdVar.zza.put(str, Long.valueOf(j));
                } else {
                    zzeh zzehVar = ((zzfr) zzdVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zza("Too many ads visible");
                }
                break;
            default:
                zzd zzdVar2 = this.zzc;
                zzdVar2.zzg();
                String str2 = this.zza;
                com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
                ArrayMap arrayMap2 = zzdVar2.zzb;
                Integer num2 = (Integer) arrayMap2.getOrDefault(str2, null);
                zzfr zzfrVar = (zzfr) zzdVar2.mBuilder;
                if (num2 == null) {
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzb(str2, "Call to endAdUnitExposure for unknown ad unit id");
                } else {
                    zzim zzimVar = zzfrVar.zzs;
                    zzfr.zzQ(zzimVar);
                    zzie zzieVarZzj = zzimVar.zzj(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        arrayMap2.put(str2, Integer.valueOf(iIntValue));
                    } else {
                        arrayMap2.remove(str2);
                        ArrayMap arrayMap3 = zzdVar2.zza;
                        Long l = (Long) arrayMap3.getOrDefault(str2, null);
                        long j2 = this.zzb;
                        zzeh zzehVar3 = zzfrVar.zzm;
                        if (l == null) {
                            zzfr.zzR(zzehVar3);
                            zzehVar3.zzd.zza("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = l.longValue();
                            arrayMap3.remove(str2);
                            zzdVar2.zzi(str2, j2 - jLongValue, zzieVarZzj);
                        }
                        if (arrayMap2.isEmpty()) {
                            long j3 = zzdVar2.zzc;
                            if (j3 != 0) {
                                zzdVar2.zzh(j2 - j3, zzieVarZzj);
                                zzdVar2.zzc = 0L;
                            } else {
                                zzfr.zzR(zzehVar3);
                                zzehVar3.zzd.zza("First ad exposure time was never set");
                            }
                        }
                    }
                }
                break;
        }
    }
}
