package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzdt {
    public static final Object zza = new Object();
    public final String zzb;
    public final zzdq zzc;
    public final Object zzd;
    public final Object zze;
    public final Object zzf = new Object();
    public volatile Object zzh = null;

    public /* synthetic */ zzdt(String str, Object obj, Object obj2, zzdq zzdqVar) {
        this.zzb = str;
        this.zzd = obj;
        this.zze = obj2;
        this.zzc = zzdqVar;
    }

    public final Object zza(Object obj) {
        synchronized (this.zzf) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzg.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            try {
                if (zzdg.zza()) {
                    return this.zzh == null ? this.zzd : this.zzh;
                }
                try {
                    for (zzdt zzdtVar : zzdu.zzav) {
                        if (zzdg.zza()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objMo95zza = null;
                        try {
                            zzdq zzdqVar = zzdtVar.zzc;
                            if (zzdqVar != null) {
                                objMo95zza = zzdqVar.mo95zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zza) {
                            zzdtVar.zzh = objMo95zza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzdq zzdqVar2 = this.zzc;
                if (zzdqVar2 == null) {
                    return this.zzd;
                }
                try {
                    return zzdqVar2.mo95zza();
                } catch (IllegalStateException unused3) {
                    return this.zzd;
                } catch (SecurityException unused4) {
                    return this.zzd;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
