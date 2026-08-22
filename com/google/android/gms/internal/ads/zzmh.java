package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzmh {
    public static final zzmh zza = new zzmh(new zzmg());
    public final zzfyv zzb;
    public final Double zzc = null;
    public final Double zzd = null;
    public final boolean zze = true;
    public final boolean zzf = false;
    public final boolean zzg = true;
    public final boolean zzh = true;

    private zzmh(zzmg zzmgVar) {
        this.zzb = zzmgVar.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzmh) && this.zzb.equals(((zzmh) obj).zzb);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.zzb, null, null, bool, Boolean.FALSE, bool, bool);
    }
}
