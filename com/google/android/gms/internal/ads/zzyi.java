package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzyi extends zzbr {
    public static final zzyi zzF = new zzyi(new zzyh());
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final boolean zzU;
    private final SparseArray zzV;
    private final SparseBooleanArray zzW;

    static {
        String str = zzex.zza;
        Integer.toString(1000, 36);
        Integer.toString(1001, 36);
        Integer.toString(1002, 36);
        Integer.toString(1003, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
        Integer.toString(1007, 36);
        Integer.toString(1008, 36);
        Integer.toString(1009, 36);
        Integer.toString(1010, 36);
        Integer.toString(1011, 36);
        Integer.toString(1012, 36);
        Integer.toString(1013, 36);
        Integer.toString(1014, 36);
        Integer.toString(1015, 36);
        Integer.toString(1016, 36);
        Integer.toString(1017, 36);
        Integer.toString(1018, 36);
    }

    public /* synthetic */ zzyi(zzyh zzyhVar) {
        this(zzyhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbr
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyi.class == obj.getClass()) {
            zzyi zzyiVar = (zzyi) obj;
            if (super.equals(zzyiVar) && this.zzG == zzyiVar.zzG && this.zzI == zzyiVar.zzI && this.zzK == zzyiVar.zzK && this.zzP == zzyiVar.zzP && this.zzQ == zzyiVar.zzQ && this.zzR == zzyiVar.zzR && this.zzT == zzyiVar.zzT) {
                SparseBooleanArray sparseBooleanArray = this.zzW;
                SparseBooleanArray sparseBooleanArray2 = zzyiVar.zzW;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                        }
                    }
                    SparseArray sparseArray = this.zzV;
                    SparseArray sparseArray2 = zzyiVar.zzV;
                    int size2 = sparseArray.size();
                    if (sparseArray2.size() == size2) {
                        for (int i2 = 0; i2 < size2; i2++) {
                            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                            if (iIndexOfKey >= 0) {
                                Map map = (Map) sparseArray.valueAt(i2);
                                Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                if (map2.size() == map.size()) {
                                    for (Map.Entry entry : map.entrySet()) {
                                        zzxk zzxkVar = (zzxk) entry.getKey();
                                        if (!map2.containsKey(zzxkVar) || !Objects.equals(entry.getValue(), map2.get(zzxkVar))) {
                                        }
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbr
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzG ? 1 : 0)) * 961) + (this.zzI ? 1 : 0)) * 961) + (this.zzK ? 1 : 0)) * 28629151) + (this.zzP ? 1 : 0)) * 31) + (this.zzQ ? 1 : 0)) * 31) + (this.zzR ? 1 : 0)) * 961) + (this.zzT ? 1 : 0)) * 31;
    }

    public final zzyh zzc() {
        return new zzyh(this, null);
    }

    @Deprecated
    public final zzyj zzd(int i, zzxk zzxkVar) {
        Map map = (Map) this.zzV.get(i);
        if (map != null) {
            return (zzyj) map.get(zzxkVar);
        }
        return null;
    }

    public final boolean zze(int i) {
        return this.zzW.get(i);
    }

    @Deprecated
    public final boolean zzf(int i, zzxk zzxkVar) {
        Map map = (Map) this.zzV.get(i);
        return map != null && map.containsKey(zzxkVar);
    }

    zzyi(zzyh zzyhVar) {
        super(zzyhVar);
        this.zzG = zzyhVar.zza;
        this.zzH = false;
        this.zzI = zzyhVar.zzb;
        this.zzJ = false;
        this.zzK = zzyhVar.zzc;
        this.zzL = false;
        this.zzM = false;
        this.zzN = false;
        this.zzO = false;
        this.zzP = zzyhVar.zzd;
        this.zzQ = zzyhVar.zze;
        this.zzR = zzyhVar.zzf;
        this.zzS = false;
        this.zzT = zzyhVar.zzg;
        this.zzU = false;
        this.zzV = zzyhVar.zzh;
        this.zzW = zzyhVar.zzi;
    }
}
