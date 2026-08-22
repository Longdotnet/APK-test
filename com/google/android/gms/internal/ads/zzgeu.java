package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzgeu {
    private final InputStream zza;

    private zzgeu(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgeu zzb(byte[] bArr) {
        return new zzgeu(new ByteArrayInputStream(bArr));
    }

    public final zzgun zza() throws IOException {
        try {
            return zzgun.zzg(this.zza, zzgyr.zza());
        } finally {
            this.zza.close();
        }
    }
}
