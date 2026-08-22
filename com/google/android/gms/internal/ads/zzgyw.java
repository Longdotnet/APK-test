package com.google.android.gms.internal.ads;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgyw {
    private static final zzgyw zzb = new zzgyw(true);
    final zzhbt zza = new zzhbo();
    private boolean zzc;
    private boolean zzd;

    private zzgyw() {
    }

    public static int zza(zzhck zzhckVar, int i, Object obj) {
        int iZzD = zzgym.zzD(i << 3);
        if (zzhckVar == zzhck.zzj) {
            byte[] bArr = zzgzu.zzb;
            if (((zzhas) obj) instanceof zzgxj) {
                throw null;
            }
            iZzD += iZzD;
        }
        return iZzD + zzb(zzhckVar, obj);
    }

    public static int zzb(zzhck zzhckVar, Object obj) {
        int iZzd;
        int iZzD;
        zzhck zzhckVar2 = zzhck.zza;
        zzhcl zzhclVar = zzhcl.INT;
        switch (zzhckVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzgym.zzf;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzgym.zzf;
                return 4;
            case 2:
                return zzgym.zzE(((Long) obj).longValue());
            case 3:
                return zzgym.zzE(((Long) obj).longValue());
            case 4:
                return zzgym.zzE(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzgym.zzf;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzgym.zzf;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzgym.zzf;
                return 1;
            case 8:
                if (!(obj instanceof zzgxz)) {
                    return zzgym.zzC((String) obj);
                }
                int i6 = zzgym.zzf;
                iZzd = ((zzgxz) obj).zzd();
                iZzD = zzgym.zzD(iZzd);
                break;
                break;
            case 9:
                return ((zzhas) obj).zzaY();
            case 10:
                if (!(obj instanceof zzhac)) {
                    return zzgym.zzz((zzhas) obj);
                }
                int i7 = zzgym.zzf;
                iZzd = ((zzhac) obj).zza();
                iZzD = zzgym.zzD(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzgxz)) {
                    int i8 = zzgym.zzf;
                    iZzd = ((byte[]) obj).length;
                    iZzD = zzgym.zzD(iZzd);
                } else {
                    int i9 = zzgym.zzf;
                    iZzd = ((zzgxz) obj).zzd();
                    iZzD = zzgym.zzD(iZzd);
                }
                break;
            case 12:
                return zzgym.zzD(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzgzl ? zzgym.zzE(((zzgzl) obj).zza()) : zzgym.zzE(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i10 = zzgym.zzf;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i11 = zzgym.zzf;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzgym.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzgym.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzD + iZzd;
    }

    public static int zzc(zzgyv zzgyvVar, Object obj) {
        zzhck zzhckVarZzb = zzgyvVar.zzb();
        int iZza = zzgyvVar.zza();
        if (!zzgyvVar.zze()) {
            return zza(zzhckVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzgyvVar.zzd()) {
            int iZza2 = 0;
            while (i < size) {
                iZza2 += zza(zzhckVarZzb, iZza, list.get(i));
                i++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i < size) {
            iZzb += zzb(zzhckVarZzb, list.get(i));
            i++;
        }
        return zzgym.zzD(iZzb) + zzgym.zzD(iZza << 3) + iZzb;
    }

    public static zzgyw zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgyv zzgyvVar = (zzgyv) entry.getKey();
        if (zzgyvVar.zzc() != zzhcl.MESSAGE) {
            return true;
        }
        if (!zzgyvVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzhat) {
            return ((zzhat) obj).zzbw();
        }
        if (obj instanceof zzhac) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int iZzD;
        int iZzz;
        zzgyv zzgyvVar = (zzgyv) entry.getKey();
        Object value = entry.getValue();
        if (zzgyvVar.zzc() != zzhcl.MESSAGE || zzgyvVar.zze() || zzgyvVar.zzd()) {
            return zzc(zzgyvVar, value);
        }
        if (value instanceof zzhac) {
            int iZza = ((zzgyv) entry.getKey()).zza();
            int iZzD2 = zzgym.zzD(8);
            i = iZzD2 + iZzD2;
            iZzD = zzgym.zzD(iZza) + zzgym.zzD(16);
            int iZzD3 = zzgym.zzD(24);
            int iZza2 = ((zzhac) value).zza();
            iZzz = BarcodeFormat$EnumUnboxingLocalUtility.m(iZza2, iZza2, iZzD3);
        } else {
            int iZza3 = ((zzgyv) entry.getKey()).zza();
            int iZzD4 = zzgym.zzD(8);
            i = iZzD4 + iZzD4;
            iZzD = zzgym.zzD(iZza3) + zzgym.zzD(16);
            iZzz = zzgym.zzz((zzhas) value) + zzgym.zzD(24);
        }
        return i + iZzD + iZzz;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzm(zzgyv zzgyvVar, Object obj) {
        boolean z;
        zzgyvVar.zzb();
        byte[] bArr = zzgzu.zzb;
        obj.getClass();
        zzhck zzhckVar = zzhck.zza;
        zzhcl zzhclVar = zzhcl.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzgxz) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzgzl)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzhas) || (obj instanceof zzhac)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzgyw zzgywVar = new zzgyw();
        zzhbt zzhbtVar = this.zza;
        int iZzc = zzhbtVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzhbtVar.zzg(i);
            zzgywVar.zzh((zzgyv) ((zzhbp) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzhbtVar.zzd()) {
            zzgywVar.zzh((zzgyv) entry.getKey(), entry.getValue());
        }
        zzgywVar.zzd = this.zzd;
        return zzgywVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgyw) {
            return this.zza.equals(((zzgyw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhbt zzhbtVar = this.zza;
        int iZzc = zzhbtVar.zzc();
        int iZzl = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzl += zzl(zzhbtVar.zzg(i));
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        zzhbt zzhbtVar = this.zza;
        if (zzhbtVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzhaa(zzhbtVar.entrySet().iterator()) : zzhbtVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhbt zzhbtVar = this.zza;
        int iZzc = zzhbtVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzhbtVar.zzg(i).getValue();
            if (value instanceof zzgzh) {
                ((zzgzh) value).zzbU();
            }
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzgzh) {
                ((zzgzh) value2).zzbU();
            }
        }
        zzhbtVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzgyv zzgyvVar, Object obj) {
        if (!zzgyvVar.zze()) {
            zzm(zzgyvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzgyvVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzhac) {
            this.zzd = true;
        }
        this.zza.put(zzgyvVar, obj);
    }

    public final boolean zzi() {
        zzhbt zzhbtVar = this.zza;
        int iZzc = zzhbtVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzj(zzhbtVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgyw(boolean z) {
        zzg();
        zzg();
    }
}
