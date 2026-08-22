package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzfyw {
    public static Object zza(Iterable iterable, Object obj) {
        zzgaw it = ((zzgam) iterable).iterator();
        return it.hasNext() ? it.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfvq zzfvqVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzfvqVar.getClass();
            return zzd((List) iterable, zzfvqVar);
        }
        Iterator it = iterable.iterator();
        zzfvqVar.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (zzfvqVar.zza(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    private static void zzc(List list, zzfvq zzfvqVar, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfvqVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }

    private static boolean zzd(List list, zzfvq zzfvqVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfvqVar.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        zzc(list, zzfvqVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzc(list, zzfvqVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}
