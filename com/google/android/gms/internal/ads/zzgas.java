package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzgas {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static zzgaq zzb(Set set, Set set2) {
        zzfvp.zzc(set, "set1");
        zzfvp.zzc(set2, "set2");
        return new zzgam(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set zzc(Set set, zzfvq zzfvqVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzgan)) {
                set.getClass();
                return new zzgan(set, zzfvqVar);
            }
            zzgan zzganVar = (zzgan) set;
            return new zzgan((Set) zzganVar.zza, zzfvt.zza(zzganVar.zzb, zzfvqVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzgan)) {
            sortedSet.getClass();
            return new zzgao(sortedSet, zzfvqVar);
        }
        zzgan zzganVar2 = (zzgan) sortedSet;
        return new zzgao((SortedSet) zzganVar2.zza, zzfvt.zza(zzganVar2.zzb, zzfvqVar));
    }

    public static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfzy) {
            collection = ((zzfzy) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean zzf(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
