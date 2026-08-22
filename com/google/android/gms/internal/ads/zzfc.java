package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzfc extends zzff {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzfc(int i, long j) {
        super(i, null);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzff
    public final String toString() {
        List list = this.zzb;
        return zzff.zze(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    public final zzfc zza(int i) {
        List list = this.zzc;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzfc zzfcVar = (zzfc) list.get(i2);
            if (zzfcVar.zzd == i) {
                return zzfcVar;
            }
        }
        return null;
    }

    public final zzfd zzb(int i) {
        List list = this.zzb;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzfd zzfdVar = (zzfd) list.get(i2);
            if (zzfdVar.zzd == i) {
                return zzfdVar;
            }
        }
        return null;
    }

    public final void zzc(zzfc zzfcVar) {
        this.zzc.add(zzfcVar);
    }

    public final void zzd(zzfd zzfdVar) {
        this.zzb.add(zzfdVar);
    }
}
