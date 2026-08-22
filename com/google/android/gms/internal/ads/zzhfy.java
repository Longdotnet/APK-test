package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhfy implements zzarq {
    private static final zzhgj zzg = zzhgj.zzb(zzhfy.class);
    protected final String zza;
    long zzd;
    zzhgd zzf;
    private ByteBuffer zzh;
    long zze = -1;
    boolean zzc = true;
    boolean zzb = true;

    public zzhfy(String str) {
        this.zza = str;
    }

    private final synchronized void zzc() {
        try {
            if (this.zzc) {
                return;
            }
            try {
                zzhgj zzhgjVar = zzg;
                String str = this.zza;
                zzhgjVar.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
                this.zzh = this.zzf.zzd(this.zzd, this.zze);
                this.zzc = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final void zzb(zzhgd zzhgdVar, ByteBuffer byteBuffer, long j, zzarn zzarnVar) {
        this.zzd = zzhgdVar.zzb();
        byteBuffer.remaining();
        this.zze = j;
        this.zzf = zzhgdVar;
        zzhgdVar.zze(zzhgdVar.zzb() + j);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    public abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        try {
            zzc();
            zzhgj zzhgjVar = zzg;
            String str = this.zza;
            zzhgjVar.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
            ByteBuffer byteBuffer = this.zzh;
            if (byteBuffer != null) {
                this.zzb = true;
                byteBuffer.rewind();
                zze(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    byteBuffer.slice();
                }
                this.zzh = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
