package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzze {
    public final int zza;
    public final zzme[] zzb;
    public final zzyw[] zzc;
    public final zzbt zzd;
    public final Object zze;

    public zzze(zzme[] zzmeVarArr, zzyw[] zzywVarArr, zzbt zzbtVar, Object obj) {
        int length = zzmeVarArr.length;
        zzdd.zzd(length == zzywVarArr.length);
        this.zzb = zzmeVarArr;
        this.zzc = (zzyw[]) zzywVarArr.clone();
        this.zzd = zzbtVar;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(zzze zzzeVar, int i) {
        return zzzeVar != null && Objects.equals(this.zzb[i], zzzeVar.zzb[i]) && Objects.equals(this.zzc[i], zzzeVar.zzc[i]);
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
