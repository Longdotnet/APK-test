package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzq implements Serializable {
    private final Pattern zza;

    public zzt(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzq
    public final zzp zza(CharSequence charSequence) {
        return new zzs(this.zza.matcher(charSequence));
    }
}
