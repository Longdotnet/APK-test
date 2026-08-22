package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzly extends zzht {
    public static final /* synthetic */ int zzb = 0;
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzbl[] zzg;
    private final Object[] zzh;
    private final HashMap zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzly(Collection collection, zzxc zzxcVar) {
        zzbl[] zzblVarArr = new zzbl[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            zzblVarArr[i2] = ((zzlg) it.next()).zza();
            i2++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i] = ((zzlg) it2.next()).zzb();
            i++;
        }
        this(zzblVarArr, objArr, zzxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final int zzq(int i) {
        return zzex.zzc(this.zze, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final int zzr(int i) {
        return zzex.zzc(this.zzf, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final int zzs(int i) {
        return this.zze[i];
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final int zzt(int i) {
        return this.zzf[i];
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final zzbl zzu(int i) {
        return this.zzg[i];
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final Object zzv(int i) {
        return this.zzh[i];
    }

    public final List zzw() {
        return Arrays.asList(this.zzg);
    }

    public final zzly zzx(zzxc zzxcVar) {
        zzbl[] zzblVarArr = this.zzg;
        zzbl[] zzblVarArr2 = new zzbl[zzblVarArr.length];
        for (int i = 0; i < zzblVarArr.length; i++) {
            zzblVarArr2[i] = new zzlx(this, zzblVarArr[i]);
        }
        return new zzly(zzblVarArr2, this.zzh, zzxcVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzly(zzbl[] zzblVarArr, Object[] objArr, zzxc zzxcVar) {
        super(false, zzxcVar);
        int i = 0;
        this.zzg = zzblVarArr;
        int length = zzblVarArr.length;
        this.zze = new int[length];
        this.zzf = new int[length];
        this.zzh = objArr;
        this.zzi = new HashMap();
        int iZzc = 0;
        int iZzb = 0;
        int i2 = 0;
        while (i < zzblVarArr.length) {
            zzbl zzblVar = zzblVarArr[i];
            this.zzg[i2] = zzblVar;
            this.zzf[i2] = iZzc;
            this.zze[i2] = iZzb;
            iZzc += zzblVar.zzc();
            iZzb += this.zzg[i2].zzb();
            this.zzi.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.zzc = iZzc;
        this.zzd = iZzb;
    }
}
