package com.google.android.gms.internal.auth;

import com.google.protobuf.GeneratedMessage;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgd {
    private static final Class<?> zza = GeneratedMessage.class;
    private static final zzgp<?, ?> zzb = zzj(false);
    private static final zzgp<?, ?> zzc = zzj(true);
    private static final zzgp<?, ?> zzd = new zzgr();

    public static zzgp<?, ?> zza() {
        return zzb;
    }

    public static zzgp<?, ?> zzb() {
        return zzc;
    }

    public static zzgp<?, ?> zzc() {
        return zzd;
    }

    public static <UT, UB> UB zzd(int i, List<Integer> list, zzet zzetVar, UB ub, zzgp<UT, UB> zzgpVar) {
        if (zzetVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (zzetVar.zza()) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zze(i, iIntValue, ub, zzgpVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzetVar.zza()) {
                    ub = (UB) zze(i, iIntValue2, ub, zzgpVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB zze(int i, int i2, UB ub, zzgp<UT, UB> zzgpVar) {
        if (ub == null) {
            ub = zzgpVar.zzc();
        }
        zzgpVar.zzd(ub, i, i2);
        return ub;
    }

    public static <T, UT, UB> void zzf(zzgp<UT, UB> zzgpVar, T t, T t2) {
        zzgpVar.zzf(t, zzgpVar.zzb(zzgpVar.zza(t), zzgpVar.zza(t2)));
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzeq.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> void zzi(zzfl zzflVar, T t, T t2, long j) {
        zzgz.zzp(t, j, zzfl.zza(zzgz.zzf(t, j), zzgz.zzf(t2, j)));
    }

    private static zzgp<?, ?> zzj(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgp) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }
}
