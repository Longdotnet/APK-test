package com.google.android.gms.internal.ads;

import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes.dex */
final class zzapg extends zzaph {
    private final byte[] zza;

    public zzapg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaph, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.zza;
    }
}
