package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzfxm extends zzgab implements Serializable {
    final zzfve zza;
    final zzgab zzb;

    public zzfxm(zzfve zzfveVar, zzgab zzgabVar) {
        this.zza = zzfveVar;
        this.zzb = zzgabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgab, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzfve zzfveVar = this.zza;
        return this.zzb.compare(zzfveVar.apply(obj), zzfveVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxm) {
            zzfxm zzfxmVar = (zzfxm) obj;
            if (this.zza.equals(zzfxmVar.zza) && this.zzb.equals(zzfxmVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzfve zzfveVar = this.zza;
        return this.zzb.toString() + ".onResultOf(" + zzfveVar.toString() + ")";
    }
}
