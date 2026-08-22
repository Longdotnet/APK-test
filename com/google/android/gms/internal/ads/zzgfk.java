package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfk {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgfj zza(String str) throws GeneralSecurityException {
        for (zzgfj zzgfjVar : zza) {
            if (zzgfjVar.zza()) {
                return zzgfjVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
