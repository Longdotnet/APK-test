package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt {
    public static final zzbt zza = new zzbt(zzfyq.zzn());
    private final zzfyq zzb;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
    }

    public zzbt(List list) {
        this.zzb = zzfyq.zzl(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbt.class != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzbt) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzfyq zza() {
        return this.zzb;
    }

    public final boolean zzb(int i) {
        int i2 = 0;
        while (true) {
            zzfyq zzfyqVar = this.zzb;
            if (i2 >= zzfyqVar.size()) {
                return false;
            }
            zzbs zzbsVar = (zzbs) zzfyqVar.get(i2);
            if (zzbsVar.zzc() && zzbsVar.zza() == i) {
                return true;
            }
            i2++;
        }
    }
}
