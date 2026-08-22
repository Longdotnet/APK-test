package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzarh extends ByteArrayOutputStream {
    private final zzaqu zza;

    public zzarh(zzaqu zzaquVar, int i) {
        this.zza = zzaquVar;
        ((ByteArrayOutputStream) this).buf = zzaquVar.zzb(Math.max(i, 256));
    }

    private final void zza(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        zzaqu zzaquVar = this.zza;
        int i3 = i2 + i;
        byte[] bArrZzb = zzaquVar.zzb(i3 + i3);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrZzb, 0, ((ByteArrayOutputStream) this).count);
        zzaquVar.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrZzb;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zza(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zza(i2);
        super.write(bArr, i, i2);
    }
}
