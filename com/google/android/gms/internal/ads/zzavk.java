package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzavk implements zzfqb {
    final /* synthetic */ zzfod zza;

    public zzavk(zzavm zzavmVar, zzfod zzfodVar) {
        this.zza = zzfodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqb
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
