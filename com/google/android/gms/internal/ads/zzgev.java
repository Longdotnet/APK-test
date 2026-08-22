package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzgev {
    private final OutputStream zza;

    private zzgev(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgev zzb(OutputStream outputStream) {
        return new zzgev(outputStream);
    }

    public final void zza(zzgun zzgunVar) throws IOException {
        try {
            zzgunVar.zzaU(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
