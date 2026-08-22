package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzik implements zzii {
    volatile zzii zza;
    volatile boolean zzb;
    Object zzc;

    public zzik(zzii zziiVar) {
        zziiVar.getClass();
        this.zza = zziiVar;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzii
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                try {
                    if (!this.zzb) {
                        zzii zziiVar = this.zza;
                        zziiVar.getClass();
                        Object objZza = zziiVar.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        this.zza = null;
                        return objZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzc;
    }
}
