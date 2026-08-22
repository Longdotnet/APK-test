package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgyf {
    private static volatile int zza = 100;
    public static final /* synthetic */ int zze = 0;
    int zzb;
    final int zzc = zza;
    zzgyg zzd;

    private zzgyf() {
    }

    public static int zzD(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static int zzE(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw new zzgzw("CodedInputStream encountered a malformed varint.");
    }

    public static long zzF(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzgyf zzG(InputStream inputStream, int i) {
        if (inputStream != null) {
            return new zzgyc(inputStream, 4096, null);
        }
        byte[] bArr = zzgzu.zzb;
        int length = bArr.length;
        return zzH(bArr, 0, 0, false);
    }

    public static zzgyf zzH(byte[] bArr, int i, int i2, boolean z) {
        zzgya zzgyaVar = new zzgya(bArr, i, i2, z, null);
        try {
            zzgyaVar.zzd(i2);
            return zzgyaVar;
        } catch (zzgzw e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract boolean zzA();

    public abstract boolean zzB();

    public abstract double zza();

    public abstract float zzb();

    public abstract int zzc();

    public abstract int zzd(int i);

    public abstract int zze();

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzj();

    public abstract int zzk();

    public abstract int zzl();

    public abstract int zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract long zzs();

    public abstract long zzt();

    public abstract long zzu();

    public abstract zzgxz zzv();

    public abstract String zzw();

    public abstract String zzx();

    public abstract void zzy(int i);

    public abstract void zzz(int i);

    public /* synthetic */ zzgyf(zzgye zzgyeVar) {
    }
}
