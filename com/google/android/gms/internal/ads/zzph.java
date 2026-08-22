package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzph {
    public final String zza;
    private final zzpg zzb;
    private final Object zzc;

    static {
        new zzph("");
    }

    public zzph(String str) {
        this.zza = str;
        this.zzb = Build.VERSION.SDK_INT >= 31 ? new zzpg() : null;
        this.zzc = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzph)) {
            return false;
        }
        zzph zzphVar = (zzph) obj;
        return Objects.equals(this.zza, zzphVar.zza) && Objects.equals(this.zzb, zzphVar.zzb) && Objects.equals(this.zzc, zzphVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    public final synchronized LogSessionId zza() {
        zzpg zzpgVar;
        zzpgVar = this.zzb;
        if (zzpgVar == null) {
            throw null;
        }
        return zzpgVar.zza;
    }

    public final synchronized void zzb(LogSessionId logSessionId) {
        zzpg zzpgVar = this.zzb;
        if (zzpgVar == null) {
            throw null;
        }
        zzdd.zzf(zzpgVar.zza.equals(LogSessionId.LOG_SESSION_ID_NONE));
        zzpgVar.zza = logSessionId;
    }
}
