package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh {
    public final String[] zza;
    public final double[] zzb;
    public final double[] zzc;
    public final int[] zzd;
    public int zze;

    public zzbh(zzbf zzbfVar) {
        ArrayList arrayList = zzbfVar.zzb;
        int size = arrayList.size();
        this.zza = (String[]) zzbfVar.zza.toArray(new String[size]);
        int size2 = arrayList.size();
        double[] dArr = new double[size2];
        for (int i = 0; i < size2; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        this.zzb = dArr;
        ArrayList arrayList2 = zzbfVar.zzc;
        int size3 = arrayList2.size();
        double[] dArr2 = new double[size3];
        for (int i2 = 0; i2 < size3; i2++) {
            dArr2[i2] = ((Double) arrayList2.get(i2)).doubleValue();
        }
        this.zzc = dArr2;
        this.zzd = new int[size];
        this.zze = 0;
    }
}
