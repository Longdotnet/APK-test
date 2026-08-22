package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzavn implements Runnable {
    final /* synthetic */ zzavo zza;

    public zzavn(zzavo zzavoVar) {
        this.zza = zzavoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzavo zzavoVar = this.zza;
        if (zzavoVar.zzb != null) {
            return;
        }
        synchronized (zzavo.zzc) {
            if (zzavoVar.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzbde.zzcO.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzavo.zza = zzfqi.zzb(this.zza.zze.zza, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z = zBooleanValue;
            this.zza.zzb = Boolean.valueOf(z);
            zzavo.zzc.open();
        }
    }
}
