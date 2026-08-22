package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzwg implements zzzv, zzuw {
    final /* synthetic */ zzwl zza;
    private final long zzb;
    private final Uri zzc;
    private final zzhi zzd;
    private final zzwa zze;
    private final zzady zzf;
    private final zzdm zzg;
    private final zzaer zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzgo zzl;
    private zzafb zzm;
    private boolean zzn;

    public zzwg(zzwl zzwlVar, Uri uri, zzgj zzgjVar, zzwa zzwaVar, zzady zzadyVar, zzdm zzdmVar) {
        Objects.requireNonNull(zzwlVar);
        this.zza = zzwlVar;
        this.zzc = uri;
        this.zzd = new zzhi(zzgjVar);
        this.zze = zzwaVar;
        this.zzf = zzadyVar;
        this.zzg = zzdmVar;
        this.zzh = new zzaer();
        this.zzj = true;
        this.zzb = zzuy.zza();
        this.zzl = zzi(0L);
    }

    public static /* bridge */ /* synthetic */ void zzf(zzwg zzwgVar, long j, long j2) {
        zzwgVar.zzh.zza = j;
        zzwgVar.zzk = j2;
        zzwgVar.zzj = true;
        zzwgVar.zzn = false;
    }

    private final zzgo zzi(long j) {
        zzgm zzgmVar = new zzgm();
        zzgmVar.zzd(this.zzc);
        zzgmVar.zzc(j);
        zzgmVar.zza(6);
        zzgmVar.zzb(zzwl.zzb);
        return zzgmVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zza(zzen zzenVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzwl.zzr(this.zza, true), this.zzk);
        int iZza = zzenVar.zza();
        zzafb zzafbVar = this.zzm;
        zzafbVar.getClass();
        zzafbVar.zzr(zzenVar, iZza);
        zzafbVar.zzt(jMax, 1, iZza, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01ce */
    @Override // com.google.android.gms.internal.ads.zzzv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwg.zzh():void");
    }
}
