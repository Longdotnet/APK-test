package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgym extends zzgxq {
    private static final Logger zza = Logger.getLogger(zzgym.class.getName());
    private static final boolean zzb = zzhce.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgyn zze;

    private zzgym() {
        throw null;
    }

    public static int zzA(zzhas zzhasVar, zzhbl zzhblVar) {
        int iZzaM = ((zzgxi) zzhasVar).zzaM(zzhblVar);
        return zzD(iZzaM) + iZzaM;
    }

    public static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzhcj.zze(str);
        } catch (zzhci unused) {
            length = str.getBytes(zzgzu.zza).length;
        }
        return zzD(length) + length;
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzy(int i, zzhas zzhasVar, zzhbl zzhblVar) {
        int iZzD = zzD(i << 3);
        return ((zzgxi) zzhasVar).zzaM(zzhblVar) + iZzD + iZzD;
    }

    public static int zzz(zzhas zzhasVar) {
        int iZzaY = zzhasVar.zzaY();
        return zzD(iZzaY) + iZzaY;
    }

    public final void zzF() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzG(String str, zzhci zzhciVar) throws zzgyj {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhciVar);
        byte[] bytes = str.getBytes(zzgzu.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyj(e);
        }
    }

    public abstract void zzK();

    public abstract void zzL(byte b);

    public abstract void zzM(int i, boolean z);

    public abstract void zzN(int i, zzgxz zzgxzVar);

    @Override // com.google.android.gms.internal.ads.zzgxq
    public abstract void zza(byte[] bArr, int i, int i2);

    public abstract int zzb();

    public abstract void zzh(int i, int i2);

    public abstract void zzi(int i);

    public abstract void zzj(int i, long j);

    public abstract void zzk(long j);

    public abstract void zzl(int i, int i2);

    public abstract void zzm(int i);

    public abstract void zzn(int i, zzhas zzhasVar, zzhbl zzhblVar);

    public abstract void zzo(int i, zzhas zzhasVar);

    public abstract void zzp(int i, zzgxz zzgxzVar);

    public abstract void zzq(int i, String str);

    public abstract void zzs(int i, int i2);

    public abstract void zzt(int i, int i2);

    public abstract void zzu(int i);

    public abstract void zzv(int i, long j);

    public abstract void zzw(long j);

    public /* synthetic */ zzgym(zzgyl zzgylVar) {
    }
}
