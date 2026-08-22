package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzhi implements zzgj {
    private final zzgj zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.emptyMap();

    public zzhi(zzgj zzgjVar) {
        this.zza = zzgjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        int iZza = this.zza.zza(bArr, i, i2);
        if (iZza != -1) {
            this.zzb += (long) iZza;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) {
        this.zzc = zzgoVar.zza;
        this.zzd = Collections.emptyMap();
        try {
            long jZzb = this.zza.zzb(zzgoVar);
            if (zzc() != null) {
            }
            return jZzb;
        } finally {
            Uri uriZzc = zzc();
            if (uriZzc != null) {
                this.zzc = uriZzc;
            }
            this.zzd = zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
        zzhjVar.getClass();
        this.zza.zzf(zzhjVar);
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }
}
