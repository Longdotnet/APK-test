package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnk {
    private final zzfml zza;
    private final ArrayList zzb;

    public zzfnk(zzfml zzfmlVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = zzfmlVar;
        arrayList.add(str);
    }

    public final zzfml zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
