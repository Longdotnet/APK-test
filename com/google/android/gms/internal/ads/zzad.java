package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzad {
    private String zza;
    private Uri zzb;
    private final zzae zzc = new zzae();
    private final List zzd;
    private final zzfyq zze;
    private final zzai zzf;
    private final zzam zzg;

    public zzad() {
        zzfyq.zzn();
        this.zzd = Collections.emptyList();
        this.zze = zzfyq.zzn();
        this.zzf = new zzai();
        this.zzg = zzam.zza;
    }

    public final zzad zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzad zzb(Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzap zzc() {
        Uri uri = this.zzb;
        zzak zzakVar = uri != null ? new zzak(uri, null, null, null, this.zzd, null, this.zze, null, -9223372036854775807L, null) : null;
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzap(str, new zzag(this.zzc, null), zzakVar, new zzaj(this.zzf, null), zzat.zza, this.zzg, null);
    }
}
