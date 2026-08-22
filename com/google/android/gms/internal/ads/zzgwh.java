package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgwh implements zzgwk {
    private final zzgwu zza;

    @Override // com.google.android.gms.internal.ads.zzgwk
    public final Object zza(String str) {
        Iterator it = zzgwm.zzb("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, null);
    }
}
