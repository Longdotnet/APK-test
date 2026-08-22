package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzhfz extends zzhgc implements zzarq {
    protected final String zza = "moov";

    public zzhfz(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final void zzb(zzhgd zzhgdVar, ByteBuffer byteBuffer, long j, zzarn zzarnVar) {
        zzhgdVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzhgdVar;
        this.zze = zzhgdVar.zzb();
        zzhgdVar.zze(zzhgdVar.zzb() + j);
        this.zzf = zzhgdVar.zzb();
        this.zzb = zzarnVar;
    }
}
