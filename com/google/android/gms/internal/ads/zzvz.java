package com.google.android.gms.internal.ads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzvz extends zzup {
    private static final zzap zza;
    private final zzvj[] zzb;
    private final List zzc;
    private final zzbl[] zzd;
    private final ArrayList zze;
    private int zzf = -1;
    private long[][] zzg;
    private zzvw zzh;
    private final zzus zzi;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zza("MergingMediaSource");
        zza = zzadVar.zzc();
    }

    public zzvz(boolean z, boolean z2, zzus zzusVar, zzvj... zzvjVarArr) {
        this.zzb = zzvjVarArr;
        this.zzi = zzusVar;
        this.zze = new ArrayList(Arrays.asList(zzvjVarArr));
        this.zzc = new ArrayList(zzvjVarArr.length);
        int i = 0;
        while (true) {
            int length = zzvjVarArr.length;
            if (i >= length) {
                this.zzd = new zzbl[length];
                this.zzg = new long[0][];
                new HashMap();
                zzfzw.zzb(8).zzb(2).zza();
                return;
            }
            this.zzc.add(new ArrayList());
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzvj zzvjVar, zzbl zzblVar) {
        int iZzb;
        Integer num = (Integer) obj;
        if (this.zzh != null) {
            return;
        }
        if (this.zzf == -1) {
            iZzb = zzblVar.zzb();
            this.zzf = iZzb;
        } else {
            int iZzb2 = zzblVar.zzb();
            int i = this.zzf;
            if (iZzb2 != i) {
                this.zzh = new zzvw(0);
                return;
            }
            iZzb = i;
        }
        if (this.zzg.length == 0) {
            this.zzg = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iZzb, this.zzd.length);
        }
        ArrayList arrayList = this.zze;
        arrayList.remove(zzvjVar);
        zzbl[] zzblVarArr = this.zzd;
        zzblVarArr[num.intValue()] = zzblVar;
        if (arrayList.isEmpty()) {
            zzo(zzblVarArr[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzG(zzvf zzvfVar) {
        zzvv zzvvVar = (zzvv) zzvfVar;
        int i = 0;
        while (true) {
            zzvj[] zzvjVarArr = this.zzb;
            if (i >= zzvjVarArr.length) {
                return;
            }
            List list = (List) this.zzc.get(i);
            zzvf zzvfVarZzn = zzvvVar.zzn(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((zzvx) list.get(i2)).zzb.equals(zzvfVarZzn)) {
                    list.remove(i2);
                    break;
                }
            }
            zzvjVarArr[i].zzG(zzvvVar.zzn(i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final zzvf zzI(zzvh zzvhVar, zzzm zzzmVar, long j) {
        zzbl[] zzblVarArr = this.zzd;
        zzvj[] zzvjVarArr = this.zzb;
        int length = zzvjVarArr.length;
        zzvf[] zzvfVarArr = new zzvf[length];
        int iZza = zzblVarArr[0].zza(zzvhVar.zza);
        for (int i = 0; i < length; i++) {
            zzvh zzvhVarZza = zzvhVar.zza(zzblVarArr[i].zzf(iZza));
            zzvfVarArr[i] = zzvjVarArr[i].zzI(zzvhVarZza, zzzmVar, j - this.zzg[iZza][i]);
            ((List) this.zzc.get(i)).add(new zzvx(zzvhVarZza, zzvfVarArr[i], null));
        }
        return new zzvv(this.zzi, this.zzg[iZza], zzvfVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final zzap zzJ() {
        zzvj[] zzvjVarArr = this.zzb;
        return zzvjVarArr.length > 0 ? zzvjVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    public final void zzn(zzhj zzhjVar) {
        super.zzn(zzhjVar);
        int i = 0;
        while (true) {
            zzvj[] zzvjVarArr = this.zzb;
            if (i >= zzvjVarArr.length) {
                return;
            }
            zzB(Integer.valueOf(i), zzvjVarArr[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzd, (Object) null);
        this.zzf = -1;
        this.zzh = null;
        ArrayList arrayList = this.zze;
        arrayList.clear();
        Collections.addAll(arrayList, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvj
    public final void zzt(zzap zzapVar) {
        this.zzb[0].zzt(zzapVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final /* bridge */ /* synthetic */ zzvh zzy(Object obj, zzvh zzvhVar) {
        int iIntValue = ((Integer) obj).intValue();
        List list = this.zzc;
        List list2 = (List) list.get(iIntValue);
        for (int i = 0; i < list2.size(); i++) {
            if (((zzvx) list2.get(i)).zza.equals(zzvhVar)) {
                return ((zzvx) ((List) list.get(0)).get(i)).zza;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzvj
    public final void zzz() throws zzvw {
        zzvw zzvwVar = this.zzh;
        if (zzvwVar != null) {
            throw zzvwVar;
        }
        super.zzz();
    }
}
