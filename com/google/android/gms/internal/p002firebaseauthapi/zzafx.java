package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.loader.app.gv.DYYbQc;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class zzafx {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzafw zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Code duplicated, block: B:11:0x003f  */
    static {
        boolean z;
        boolean z2;
        zzafw zzafwVar;
        Unsafe unsafeZzg = zzg();
        zzc = unsafeZzg;
        zzd = zzabo.zza();
        Class<?> cls = Long.TYPE;
        boolean zZzv = zzv(cls);
        zze = zZzv;
        boolean zZzv2 = zzv(Integer.TYPE);
        zzafw zzafuVar = null;
        if (unsafeZzg != null) {
            if (zZzv) {
                zzafuVar = new zzafv(unsafeZzg);
            } else if (zZzv2) {
                zzafuVar = new zzafu(unsafeZzg);
            }
        }
        zzf = zzafuVar;
        if (zzafuVar == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = zzafuVar.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (zzB() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                zzh(th);
            }
        }
        zzg = z;
        zzafw zzafwVar2 = zzf;
        if (zzafwVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = zzafwVar2.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod(DYYbQc.qSzSSiMvvl, Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzh(th2);
                z2 = false;
            }
        }
        zzh = z2;
        zza = zzz(byte[].class);
        zzz(boolean[].class);
        zzA(boolean[].class);
        zzz(int[].class);
        zzA(int[].class);
        zzz(long[].class);
        zzA(long[].class);
        zzz(float[].class);
        zzA(float[].class);
        zzz(double[].class);
        zzA(double[].class);
        zzz(Object[].class);
        zzA(Object[].class);
        Field fieldZzB = zzB();
        if (fieldZzB != null && (zzafwVar = zzf) != null) {
            zzafwVar.zzl(fieldZzB);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzafx() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzabo.zza;
        Field fieldZzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (fieldZzC != null) {
            return fieldZzC;
        }
        Field fieldZzC2 = zzC(Buffer.class, "address");
        if (fieldZzC2 == null || fieldZzC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzafw zzafwVar = zzf;
        int iZzj = zzafwVar.zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzafwVar.zzn(obj, j2, ((255 & b) << i) | (iZzj & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzafw zzafwVar = zzf;
        int i = (((int) j) & 3) << 3;
        zzafwVar.zzn(obj, j2, ((255 & b) << i) | (zzafwVar.zzj(obj, j2) & (~(255 << i))));
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zzf.zzk(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zzm(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzaft());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzafx.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void zzm(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzn(byte[] bArr, long j, byte b) {
        zzf.zzd(bArr, zza + j, b);
    }

    public static void zzo(Object obj, long j, double d) {
        zzf.zze(obj, j, d);
    }

    public static void zzp(Object obj, long j, float f) {
        zzf.zzf(obj, j, f);
    }

    public static void zzq(Object obj, long j, int i) {
        zzf.zzn(obj, j, i);
    }

    public static void zzr(Object obj, long j, long j2) {
        zzf.zzo(obj, j, j2);
    }

    public static void zzs(Object obj, long j, Object obj2) {
        zzf.zzp(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzv(Class cls) {
        int i = zzabo.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
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

    public static boolean zzw(Object obj, long j) {
        return zzf.zzg(obj, j);
    }

    public static boolean zzx() {
        return zzh;
    }

    public static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }
}
