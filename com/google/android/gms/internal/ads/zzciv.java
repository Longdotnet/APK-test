package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzciv implements zzcpw {
    private final zzcio zza;
    private zzezv zzb;
    private zzeyy zzc;
    private zzdbw zzd;
    private zzcvh zze;
    private zzejh zzf;
    private zzcqs zzg;
    private zzehk zzh;
    private zzcop zzi;
    private zzdgw zzj;

    public /* synthetic */ zzciv(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    public final /* synthetic */ zzcvd zza(zzeyy zzeyyVar) {
        this.zzc = zzeyyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    public final /* synthetic */ zzcvd zzb(zzezv zzezvVar) {
        this.zzb = zzezvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzc(zzcop zzcopVar) {
        this.zzi = zzcopVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzd(zzdgw zzdgwVar) {
        this.zzj = zzdgwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zze(zzejh zzejhVar) {
        this.zzf = zzejhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzf(zzdbw zzdbwVar) {
        this.zzd = zzdbwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzg(zzcqs zzcqsVar) {
        this.zzg = zzcqsVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzi(zzcvh zzcvhVar) {
        this.zze = zzcvhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpw
    public final /* bridge */ /* synthetic */ zzcpw zzj(zzehk zzehkVar) {
        this.zzh = zzehkVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzcpx zzh() {
        zzhgz.zzc(this.zzd, zzdbw.class);
        zzhgz.zzc(this.zze, zzcvh.class);
        zzhgz.zzc(this.zzf, zzejh.class);
        zzhgz.zzc(this.zzg, zzcqs.class);
        if (this.zzh == null) {
            this.zzh = zzehm.zza();
        }
        zzhgz.zzc(this.zzi, zzcop.class);
        zzhgz.zzc(this.zzj, zzdgw.class);
        return new zzciw(this.zza, this.zzi, this.zzj, new zzcsg(), new zzfeb(), new zzcuh(), new zzdsy(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc);
    }
}
