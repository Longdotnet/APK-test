package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfys {
    Object[] zza;
    int zzb;
    zzfyr zzc;

    public zzfys() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfyk.zze(length, i2));
        }
    }

    public final zzfys zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfxn.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzfys zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(((Collection) iterable).size() + this.zzb);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfyt zzc() {
        zzfyr zzfyrVar = this.zzc;
        if (zzfyrVar != null) {
            throw zzfyrVar.zza();
        }
        zzgah zzgahVarZzj = zzgah.zzj(this.zzb, this.zza, this);
        zzfyr zzfyrVar2 = this.zzc;
        if (zzfyrVar2 == null) {
            return zzgahVarZzj;
        }
        throw zzfyrVar2.zza();
    }

    public zzfys(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
