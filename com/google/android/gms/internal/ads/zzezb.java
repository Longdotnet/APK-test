package com.google.android.gms.internal.ads;

import com.facebook.login.vu.dLDI;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes2.dex */
final class zzezb implements zzgdj {
    public zzezb(zzezd zzezdVar) {
        Objects.requireNonNull(zzezdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* synthetic */ void zzb(@NullableDecl Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Notification of cache hit successful.");
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.util.zze.zza(dLDI.HbUebjNlB);
    }
}
