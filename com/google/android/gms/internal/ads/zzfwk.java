package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzfwk implements zzfwh {
    private static final zzfwh zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfwj
        @Override // com.google.android.gms.internal.ads.zzfwh
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private final zzfwo zzb = new zzfwo();
    private volatile zzfwh zzc;
    private Object zzd;

    public zzfwk(zzfwh zzfwhVar) {
        this.zzc = zzfwhVar;
    }

    public final String toString() {
        Object objM$1 = this.zzc;
        if (objM$1 == zza) {
            objM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("<supplier that returned ", String.valueOf(this.zzd), ">");
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Suppliers.memoize(", String.valueOf(objM$1), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzfwh
    public final Object zza() {
        zzfwh zzfwhVar = this.zzc;
        zzfwh zzfwhVar2 = zza;
        if (zzfwhVar != zzfwhVar2) {
            synchronized (this.zzb) {
                try {
                    if (this.zzc != zzfwhVar2) {
                        Object objZza = this.zzc.zza();
                        this.zzd = objZza;
                        this.zzc = zzfwhVar2;
                        return objZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzd;
    }
}
