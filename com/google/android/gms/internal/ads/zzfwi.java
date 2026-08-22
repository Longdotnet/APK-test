package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class zzfwi implements Serializable, zzfwh {
    final zzfwh zza;
    volatile transient boolean zzb;
    transient Object zzc;
    private final transient zzfwo zzd = new zzfwo();

    public zzfwi(zzfwh zzfwhVar) {
        this.zza = zzfwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwh
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this.zzd) {
                try {
                    if (!this.zzb) {
                        Object objZza = this.zza.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        return objZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzc;
    }

    public final String toString() {
        Object objM$1;
        if (this.zzb) {
            objM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(eoBKjVuj.mDzUxznn, String.valueOf(this.zzc), ">");
        } else {
            objM$1 = this.zza;
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Suppliers.memoize(", objM$1.toString(), ")");
    }
}
