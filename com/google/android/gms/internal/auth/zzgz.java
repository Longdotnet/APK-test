package com.google.android.gms.internal.auth;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class zzgz {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzgy zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Code duplicated, block: B:11:0x0041  */
    static {
        Unsafe unsafe;
        boolean z;
        Unsafe unsafe2;
        boolean z2;
        zzgy zzgyVar;
        Unsafe unsafeZzg = zzg();
        zzb = unsafeZzg;
        zzc = zzdo.zza();
        Class<?> cls = Long.TYPE;
        boolean zZzs = zzs(cls);
        zzd = zZzs;
        boolean zZzs2 = zzs(Integer.TYPE);
        zze = zZzs2;
        zzgy zzgwVar = null;
        if (unsafeZzg != null) {
            if (zZzs) {
                zzgwVar = new zzgx(unsafeZzg);
            } else if (zZzs2) {
                zzgwVar = new zzgw(unsafeZzg);
            }
        }
        zzf = zzgwVar;
        if (zzgwVar == null || (unsafe = zzgwVar.zza) == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = unsafe.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (zzy() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                zzh(th);
            }
        }
        zzg = z;
        zzgy zzgyVar2 = zzf;
        if (zzgyVar2 == null || (unsafe2 = zzgyVar2.zza) == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzh(th2);
                z2 = false;
            }
        }
        zzh = z2;
        zzw(byte[].class);
        zzw(boolean[].class);
        zzx(boolean[].class);
        zzw(int[].class);
        zzx(int[].class);
        zzw(long[].class);
        zzx(long[].class);
        zzw(float[].class);
        zzx(float[].class);
        zzw(double[].class);
        zzx(double[].class);
        zzw(Object[].class);
        zzx(Object[].class);
        Field fieldZzy = zzy();
        if (fieldZzy != null && (zzgyVar = zzf) != null) {
            zzgyVar.zzk(fieldZzy);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzgz() {
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zzf.zzi(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    public static <T> T zze(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zzl(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgv());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzgz.class.getName());
        Level level = Level.WARNING;
        String strValueOf = String.valueOf(th);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(strValueOf.length() + 71), "platform method missing - proto runtime falling back to safer methods: ", strValueOf));
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzgy zzgyVar = zzf;
        int iZzi = zzgyVar.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzgyVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & iZzi));
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzgy zzgyVar = zzf;
        int i = (((int) j) & 3) << 3;
        zzgyVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzgyVar.zzi(obj, j2)));
    }

    public static void zzk(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzl(Object obj, long j, double d) {
        zzf.zzd(obj, j, d);
    }

    public static void zzm(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    public static void zzn(Object obj, long j, int i) {
        zzf.zzm(obj, j, i);
    }

    public static void zzo(Object obj, long j, long j2) {
        zzf.zzn(obj, j, j2);
    }

    public static void zzp(Object obj, long j, Object obj2) {
        zzf.zzo(obj, j, obj2);
    }

    public static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzs(Class<?> cls) {
        int i = zzdo.zza;
        try {
            Class<?> cls2 = zzc;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod(FKidOcdAYt.WFYwjqNfOSABrSa, cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static boolean zzu() {
        return zzh;
    }

    public static boolean zzv() {
        return zzg;
    }

    private static int zzw(Class<?> cls) {
        if (zzh) {
            return zzf.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class<?> cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdo.zza;
        Field fieldZzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (fieldZzz != null) {
            return fieldZzz;
        }
        Field fieldZzz2 = zzz(Buffer.class, "address");
        if (fieldZzz2 == null || fieldZzz2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzz2;
    }

    private static Field zzz(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
