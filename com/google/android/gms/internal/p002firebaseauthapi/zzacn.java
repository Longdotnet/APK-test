package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzacn extends zzabs {
    private static final Logger zza = Logger.getLogger(zzacn.class.getName());
    private static final boolean zzb = zzafx.zzx();
    zzaco zze;

    private zzacn() {
    }

    public static int zzA(zzaek zzaekVar, zzaew zzaewVar) {
        int iZzn = ((zzabm) zzaekVar).zzn(zzaewVar);
        return zzE(iZzn) + iZzn;
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
            length = zzagc.zzc(str);
        } catch (zzagb unused) {
            length = str.getBytes(zzadl.zzb).length;
        }
        return zzE(length) + length;
    }

    public static int zzD(int i) {
        return zzE(i << 3);
    }

    public static int zzE(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzF(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzacn zzG(byte[] bArr) {
        return new zzacj(bArr, 0, bArr.length);
    }

    public static zzacn zzH(OutputStream outputStream, int i) {
        return new zzacl(outputStream, i);
    }

    public static int zzw(zzacc zzaccVar) {
        int iZzd = zzaccVar.zzd();
        return zzE(iZzd) + iZzd;
    }

    @Deprecated
    public static int zzx(int i, zzaek zzaekVar, zzaew zzaewVar) {
        int iZzE = zzE(i << 3);
        return ((zzabm) zzaekVar).zzn(zzaewVar) + iZzE + iZzE;
    }

    public static int zzy(int i) {
        if (i >= 0) {
            return zzE(i);
        }
        return 10;
    }

    public static int zzz(zzadq zzadqVar) {
        int iZza = zzadqVar.zza();
        return zzE(iZza) + iZza;
    }

    public final void zzJ(String str, zzagb zzagbVar) throws zzack {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzagbVar);
        byte[] bytes = str.getBytes(zzadl.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzack(e);
        }
    }

    public abstract void zzN();

    public abstract void zzO(byte b);

    public abstract void zzP(int i, boolean z);

    public abstract void zzQ(int i, zzacc zzaccVar);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public abstract void zza(byte[] bArr, int i, int i2);

    public abstract int zzb();

    public abstract void zzh(int i, int i2);

    public abstract void zzi(int i);

    public abstract void zzj(int i, long j);

    public abstract void zzk(long j);

    public abstract void zzl(int i, int i2);

    public abstract void zzm(int i);

    public abstract void zzn(int i, zzaek zzaekVar, zzaew zzaewVar);

    public abstract void zzo(int i, String str);

    public abstract void zzq(int i, int i2);

    public abstract void zzr(int i, int i2);

    public abstract void zzs(int i);

    public abstract void zzt(int i, long j);

    public abstract void zzu(long j);

    public /* synthetic */ zzacn(zzacm zzacmVar) {
    }

    public final void zzI() {
        if (zzb() == 0) {
        } else {
            throw new IllegalStateException(TSDAbK.nLcsWYJqd);
        }
    }
}
