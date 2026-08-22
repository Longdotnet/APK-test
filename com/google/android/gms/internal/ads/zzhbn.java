package com.google.android.gms.internal.ads;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzhbn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhbx zzb;

    static {
        int i = zzhbc.zza;
        zzb = new zzhbz();
    }

    public static void zzA(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzhcm zzhcmVar, zzhbl zzhblVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgyn) zzhcmVar).zzv(i, list.get(i2), zzhblVar);
        }
    }

    public static void zzC(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzy(i, list, z);
    }

    public static void zzD(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzA(i, list, z);
    }

    public static void zzE(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzC(i, list, z);
    }

    public static void zzF(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzE(i, list, z);
    }

    public static void zzG(int i, List list, zzhcm zzhcmVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzH(i, list);
    }

    public static void zzH(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzJ(i, list, z);
    }

    public static void zzI(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzL(i, list, z);
    }

    public static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(zzgziVar.zzd(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzE;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgym.zzD(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgym.zzD(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(zzgziVar.zzd(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzE;
    }

    public static int zzg(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(zzhahVar.zza(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzE;
    }

    public static int zzh(int i, Object obj, zzhbl zzhblVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzhad)) {
            return zzgym.zzA((zzhas) obj, zzhblVar) + zzgym.zzD(i2);
        }
        int iZzD = zzgym.zzD(i2);
        int iZza = ((zzhad) obj).zza();
        return BarcodeFormat$EnumUnboxingLocalUtility.m(iZza, iZza, iZzD);
    }

    public static int zzi(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            iZzD = 0;
            while (i < size) {
                int iZzd = zzgziVar.zzd(i);
                iZzD += zzgym.zzD((iZzd >> 31) ^ (iZzd + iZzd));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzD += zzgym.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzD;
    }

    public static int zzj(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            iZzE = 0;
            while (i < size) {
                long jZza = zzhahVar.zza(i);
                iZzE += zzgym.zzE((jZza >> 63) ^ (jZza + jZza));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzE += zzgym.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzE;
    }

    public static int zzk(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzgym.zzD(zzgziVar.zzd(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzgym.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    public static int zzl(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(zzhahVar.zza(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgym.zzE(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzE;
    }

    public static zzhbx zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, List list, zzgzn zzgznVar, Object obj2, zzhbx zzhbxVar) {
        if (zzgznVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzgznVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzhbxVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzgznVar.zza(iIntValue2)) {
                    obj2 = zzo(obj, i, iIntValue2, obj2, zzhbxVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i, int i2, Object obj2, zzhbx zzhbxVar) {
        if (obj2 == null) {
            obj2 = zzhbxVar.zza(obj);
        }
        zzhbxVar.zzh(obj2, i, i2);
        return obj2;
    }

    public static void zzp(zzgys zzgysVar, Object obj, Object obj2) {
        if (((zzgzd) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzq(zzhbx zzhbxVar, Object obj, Object obj2) {
        zzgzh zzgzhVar = (zzgzh) obj;
        zzhby zzhbyVarZze = zzgzhVar.zzt;
        zzhby zzhbyVar = ((zzgzh) obj2).zzt;
        if (!zzhby.zzc().equals(zzhbyVar)) {
            if (zzhby.zzc().equals(zzhbyVarZze)) {
                zzhbyVarZze = zzhby.zze(zzhbyVarZze, zzhbyVar);
            } else {
                zzhbyVarZze.zzd(zzhbyVar);
            }
        }
        zzgzhVar.zzt = zzhbyVarZze;
    }

    public static void zzr(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzhcm zzhcmVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zze(i, list);
    }

    public static void zzt(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzg(i, list, z);
    }

    public static void zzu(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzj(i, list, z);
    }

    public static void zzv(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzl(i, list, z);
    }

    public static void zzw(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzn(i, list, z);
    }

    public static void zzx(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzp(i, list, z);
    }

    public static void zzy(int i, List list, zzhcm zzhcmVar, zzhbl zzhblVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgyn) zzhcmVar).zzq(i, list.get(i2), zzhblVar);
        }
    }

    public static void zzz(int i, List list, zzhcm zzhcmVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzs(i, list, z);
    }
}
