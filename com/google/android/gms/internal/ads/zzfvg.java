package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzfvg extends zzfvc implements Serializable {
    private final Pattern zza;

    public zzfvg(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfvc
    public final zzfvb zza(CharSequence charSequence) {
        return new zzfvf(this.zza.matcher(charSequence));
    }
}
