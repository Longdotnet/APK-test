package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzdy {
    public final Object zza;
    private zzt zzb = new zzt();
    private boolean zzc;
    private boolean zzd;

    public zzdy(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdy.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzdy) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzdw zzdwVar) {
        if (this.zzd) {
            return;
        }
        if (i != -1) {
            this.zzb.zza(i);
        }
        this.zzc = true;
        zzdwVar.zza(this.zza);
    }

    public final void zzb(zzdx zzdxVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzv zzvVarZzb = this.zzb.zzb();
        this.zzb = new zzt();
        this.zzc = false;
        zzdxVar.zza(this.zza, zzvVarZzb);
    }

    public final void zzc(zzdx zzdxVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzdxVar.zza(this.zza, this.zzb.zzb());
        }
    }
}
