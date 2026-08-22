package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzas {
    private static final AtomicReference zza = new AtomicReference();
    private final zzar zzb;
    private final zzaw zzc;

    public zzas(Application application, zzaw zzawVar) {
        this.zzb = new zzar(this, application, null);
        this.zzc = zzawVar;
    }

    public static zzas zza(Application application) {
        AtomicReference atomicReference = zza;
        zzas zzasVar = (zzas) atomicReference.get();
        if (zzasVar != null) {
            return zzasVar;
        }
        zzas zzasVar2 = new zzas(application, zzay.zza(application));
        while (!atomicReference.compareAndSet(null, zzasVar2) && atomicReference.get() == null) {
        }
        zzas zzasVar3 = (zzas) atomicReference.get();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzasVar3);
        return zzasVar3;
    }

    public final /* synthetic */ zzaw zzc() {
        return this.zzc;
    }

    public final void zzb() {
        zzfn.zza(wsbWxekY.sadFBODcmXLtlV, "startWatching()");
        this.zzb.zza();
    }
}
