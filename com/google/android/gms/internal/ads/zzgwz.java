package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
final class zzgwz extends ThreadLocal {
    final /* synthetic */ zzgxa zza;

    public zzgwz(zzgxa zzgxaVar) {
        Objects.requireNonNull(zzgxaVar);
        this.zza = zzgxaVar;
    }

    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            zzgwm zzgwmVar = zzgwm.zzb;
            zzgxa zzgxaVar = this.zza;
            Mac mac = (Mac) zzgwmVar.zza(zzgxaVar.zzb);
            mac.init(zzgxaVar.zzc);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
