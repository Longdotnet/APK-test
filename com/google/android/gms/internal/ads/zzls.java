package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzls {
    private static final zzvh zzu = new zzvh(new Object(), -1);
    public final zzbl zza;
    public final zzvh zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzin zzf;
    public final boolean zzg;
    public final zzxk zzh;
    public final zzze zzi;
    public final List zzj;
    public final zzvh zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzbb zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzls(zzbl zzblVar, zzvh zzvhVar, long j, long j2, int i, zzin zzinVar, boolean z, zzxk zzxkVar, zzze zzzeVar, List list, zzvh zzvhVar2, boolean z2, int i2, int i3, zzbb zzbbVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzblVar;
        this.zzb = zzvhVar;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzinVar;
        this.zzg = z;
        this.zzh = zzxkVar;
        this.zzi = zzzeVar;
        this.zzj = list;
        this.zzk = zzvhVar2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = i3;
        this.zzo = zzbbVar;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzt = j6;
    }

    public static zzls zzh(zzze zzzeVar) {
        zzbl zzblVar = zzbl.zza;
        zzvh zzvhVar = zzu;
        return new zzls(zzblVar, zzvhVar, -9223372036854775807L, 0L, 1, null, false, zzxk.zza, zzzeVar, zzfyq.zzn(), zzvhVar, false, 1, 0, zzbb.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzvh zzi() {
        return zzu;
    }

    public final zzls zza(boolean z) {
        return new zzls(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzls zzb(zzvh zzvhVar) {
        return new zzls(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzvhVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzls zzc(zzvh zzvhVar, long j, long j2, long j3, long j4, zzxk zzxkVar, zzze zzzeVar, List list) {
        zzvh zzvhVar2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzbb zzbbVar = this.zzo;
        long j5 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzls(this.zza, zzvhVar, j2, j3, this.zze, this.zzf, this.zzg, zzxkVar, zzzeVar, list, zzvhVar2, z, i, i2, zzbbVar, j5, j4, j, jElapsedRealtime, false);
    }

    public final zzls zzd(boolean z, int i, int i2) {
        return new zzls(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, i2, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzls zze(zzin zzinVar) {
        return new zzls(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzinVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzls zzf(int i) {
        return new zzls(this.zza, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzls zzg(zzbl zzblVar) {
        return new zzls(zzblVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
