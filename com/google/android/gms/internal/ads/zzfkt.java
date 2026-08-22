package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfkt {
    private final String zza;
    private final AdFormat zzb;
    private final String zzc;

    public /* synthetic */ zzfkt(zzfkr zzfkrVar, zzfks zzfksVar) {
        this.zza = zzfkrVar.zza;
        this.zzb = zzfkrVar.zzb;
        this.zzc = zzfkrVar.zzc;
    }

    public final boolean equals(Object obj) {
        AdFormat adFormat;
        AdFormat adFormat2;
        if (obj instanceof zzfkt) {
            zzfkt zzfktVar = (zzfkt) obj;
            if (this.zza.equals(zzfktVar.zza) && (adFormat = this.zzb) != null && (adFormat2 = zzfktVar.zzb) != null && adFormat.equals(adFormat2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String zza() {
        AdFormat adFormat = this.zzb;
        return adFormat == null ? "unknown" : adFormat.name().toLowerCase(Locale.ENGLISH);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }
}
