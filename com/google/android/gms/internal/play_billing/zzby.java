package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzby extends zzbf {
    private static final Logger zzb = Logger.getLogger(zzby.class.getName());
    private static final boolean zzc = zzfp.zzx();
    zzbz zza;

    private zzby() {
        throw null;
    }

    @Deprecated
    public static int zzt(int i, zzec zzecVar, zzeo zzeoVar) {
        int iZzw = zzw(i << 3);
        return ((zzay) zzecVar).zza(zzeoVar) + iZzw + iZzw;
    }

    public static int zzu(zzec zzecVar, zzeo zzeoVar) {
        int iZza = ((zzay) zzecVar).zza(zzeoVar);
        return zzw(iZza) + iZza;
    }

    public static int zzv(String str) {
        int length;
        try {
            length = zzfu.zzc(str);
        } catch (zzft unused) {
            length = str.getBytes(zzda.zzb).length;
        }
        return zzw(length) + length;
    }

    public static int zzw(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzx(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzby zzy(byte[] bArr, int i, int i2) {
        return new zzbv(bArr, 0, i2);
    }

    public final void zzA(String str, zzft zzftVar) throws zzbw {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzftVar);
        byte[] bytes = str.getBytes(zzda.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbw(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i, boolean z);

    public abstract void zze(int i, zzbq zzbqVar);

    public abstract void zzf(int i, int i2);

    public abstract void zzg(int i);

    public abstract void zzh(int i, long j);

    public abstract void zzi(long j);

    public abstract void zzj(int i, int i2);

    public abstract void zzk(int i);

    public abstract void zzl(byte[] bArr, int i, int i2);

    public abstract void zzm(int i, String str);

    public abstract void zzo(int i, int i2);

    public abstract void zzp(int i, int i2);

    public abstract void zzq(int i);

    public abstract void zzr(int i, long j);

    public abstract void zzs(long j);

    public final void zzz() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public /* synthetic */ zzby(zzbx zzbxVar) {
    }
}
