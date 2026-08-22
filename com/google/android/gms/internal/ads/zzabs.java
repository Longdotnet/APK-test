package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzabs {
    private final zzabr zza;
    private final zzabw zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;
    private zzdj zzk = zzdj.zza;

    public zzabs(Context context, zzabr zzabrVar, long j) {
        this.zza = zzabrVar;
        this.zzb = new zzabw(context);
    }

    private final void zzo(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ba, code lost:
    
        if (r17 > 100000) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c5, code lost:
    
        if (r22 >= r26) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ca, code lost:
    
        if (r19.zzc != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(long r20, long r22, long r24, long r26, boolean r28, boolean r29, com.google.android.gms.internal.ads.zzabq r30) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabs.zza(long, long, long, long, boolean, boolean, com.google.android.gms.internal.ads.zzabq):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    public final void zzd() {
        this.zzc = true;
        this.zzf = zzex.zzs(this.zzk.zzb());
        this.zzb.zzg();
    }

    public final void zze() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzf(int i) {
        if (i == 0) {
            this.zzd = 1;
        } else if (i != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
    }

    public final void zzg() {
        this.zzb.zzf();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzo(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzh(int i) {
        this.zzb.zzj(i);
    }

    public final void zzi(zzdj zzdjVar) {
        this.zzk = zzdjVar;
    }

    public final void zzj(float f) {
        this.zzb.zzc(f);
    }

    public final void zzk(Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzi(surface);
        zzo(1);
    }

    public final void zzl(float f) {
        zzdd.zzd(f > 0.0f);
        if (f == this.zzj) {
            return;
        }
        this.zzj = f;
        this.zzb.zze(f);
    }

    public final boolean zzm(boolean z) {
        if (z && (this.zzd == 3 || (!this.zzl && this.zzm))) {
            this.zzh = -9223372036854775807L;
            return true;
        }
        if (this.zzh == -9223372036854775807L) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = -9223372036854775807L;
        return false;
    }

    public final boolean zzn() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzex.zzs(this.zzk.zzb());
        return i != 3;
    }
}
