package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa {
    private String zza;
    private final long zzb;
    private final Map zzc;

    public zzaa(String str, long j, Map map) {
        this.zza = str;
        this.zzb = j;
        HashMap map2 = new HashMap();
        this.zzc = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaaVar = (zzaa) obj;
        if (this.zzb == zzaaVar.zzb && this.zza.equals(zzaaVar.zza)) {
            return this.zzc.equals(zzaaVar.zzc);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode();
        long j = this.zzb;
        return this.zzc.hashCode() + (((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.zza;
        long j = this.zzb;
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder("Event{name='");
        sb.append(str);
        sb.append("', timestamp=");
        sb.append(j);
        return Fragment$$ExternalSyntheticOutline0.m(sb, ", params=", string, "}");
    }

    public final long zza() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaa clone() {
        return new zzaa(this.zza, this.zzb, new HashMap(this.zzc));
    }

    public final Object zzc(String str) {
        if (this.zzc.containsKey(str)) {
            return this.zzc.get(str);
        }
        return null;
    }

    public final String zzd() {
        return this.zza;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final void zzf(String str) {
        this.zza = str;
    }

    public final void zzg(String str, Object obj) {
        if (obj == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, obj);
        }
    }
}
