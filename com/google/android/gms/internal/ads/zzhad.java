package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzhad {
    protected volatile zzhas zza;
    private volatile zzgxz zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhad)) {
            return false;
        }
        zzhad zzhadVar = (zzhad) obj;
        zzhas zzhasVar = this.zza;
        zzhas zzhasVar2 = zzhadVar.zza;
        if (zzhasVar == null && zzhasVar2 == null) {
            return zzb().equals(zzhadVar.zzb());
        }
        if (zzhasVar != null && zzhasVar2 != null) {
            return zzhasVar.equals(zzhasVar2);
        }
        if (zzhasVar != null) {
            zzhadVar.zzd(zzhasVar.zzbt());
            return zzhasVar.equals(zzhadVar.zza);
        }
        zzd(zzhasVar2.zzbt());
        return this.zza.equals(zzhasVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzgxw) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaY();
        }
        return 0;
    }

    public final zzgxz zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    return this.zzb;
                }
                if (this.zza == null) {
                    this.zzb = zzgxz.zzb;
                } else {
                    this.zzb = this.zza.zzaN();
                }
                return this.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzhas zzc(zzhas zzhasVar) {
        zzhas zzhasVar2 = this.zza;
        this.zzb = null;
        this.zza = zzhasVar;
        return zzhasVar2;
    }

    public final void zzd(zzhas zzhasVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzhasVar;
                this.zzb = zzgxz.zzb;
            } catch (zzgzw unused) {
                this.zzc = true;
                this.zza = zzhasVar;
                this.zzb = zzgxz.zzb;
            }
        }
    }
}
