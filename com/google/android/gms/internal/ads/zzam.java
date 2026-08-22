package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzam {
    public static final zzam zza = new zzam(new zzal());
    public final Uri zzb = null;
    public final String zzc = null;
    public final Bundle zzd = null;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    private zzam(zzal zzalVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        Uri uri = ((zzam) obj).zzb;
        return true;
    }

    public final int hashCode() {
        return 0;
    }
}
