package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzciz {
    private zzchh zza;
    private zzcjt zzb;
    private zzfhe zzc;
    private zzckg zzd;
    private zzfdy zze;

    private zzciz() {
        throw null;
    }

    public final zzche zza() {
        zzhgz.zzc(this.zza, zzchh.class);
        zzhgz.zzc(this.zzb, zzcjt.class);
        if (this.zzc == null) {
            this.zzc = new zzfhe();
        }
        if (this.zzd == null) {
            this.zzd = new zzckg();
        }
        if (this.zze == null) {
            this.zze = new zzfdy();
        }
        return new zzcio(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final zzciz zzb(zzchh zzchhVar) {
        this.zza = zzchhVar;
        return this;
    }

    public final zzciz zzc(zzcjt zzcjtVar) {
        this.zzb = zzcjtVar;
        return this;
    }

    public /* synthetic */ zzciz(zzcjs zzcjsVar) {
    }
}
