package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzyh extends zzbq {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    public zzyh() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final zzyh zzw(zzbr zzbrVar) {
        zzj(zzbrVar);
        return this;
    }

    public final zzyh zzx(int i, boolean z) {
        SparseBooleanArray sparseBooleanArray = this.zzi;
        if (sparseBooleanArray.get(i) != z) {
            if (z) {
                sparseBooleanArray.put(i, true);
            } else {
                sparseBooleanArray.delete(i);
            }
        }
        return this;
    }

    public /* synthetic */ zzyh(zzyi zzyiVar, zzyt zzytVar) {
        super(zzyiVar);
        this.zza = zzyiVar.zzG;
        this.zzb = zzyiVar.zzI;
        this.zzc = zzyiVar.zzK;
        this.zzd = zzyiVar.zzP;
        this.zze = zzyiVar.zzQ;
        this.zzf = zzyiVar.zzR;
        this.zzg = zzyiVar.zzT;
        SparseArray sparseArray = zzyiVar.zzV;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzyiVar.zzW.clone();
    }
}
