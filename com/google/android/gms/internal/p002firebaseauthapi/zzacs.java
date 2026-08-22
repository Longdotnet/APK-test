package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzacs {
    static final zzacs zza = new zzacs(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzacs() {
        this.zzd = new HashMap();
    }

    public static zzacs zza() {
        return zza;
    }

    public final zzadd zzb(zzaek zzaekVar, int i) {
        return (zzadd) this.zzd.get(new zzacr(zzaekVar, i));
    }

    public zzacs(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
