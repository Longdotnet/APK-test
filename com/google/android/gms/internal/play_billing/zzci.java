package com.google.android.gms.internal.play_billing;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzci {
    private static final zzci zzb = new zzci(true);
    final zzfb zza = new zzer(16);
    private boolean zzc;
    private boolean zzd;

    private zzci() {
    }

    public static int zza(zzfv zzfvVar, int i, Object obj) {
        zzby.zzw(i << 3);
        if (zzfv.zzj == null) {
            byte[] bArr = zzda.zzd;
            if (((zzec) obj) instanceof zzaz) {
                throw null;
            }
        }
        zzfw zzfwVar = zzfw.INT;
        throw null;
    }

    public static int zzb(zzch zzchVar, Object obj) {
        zzfv zzfvVarZzd = zzchVar.zzd();
        int iZza = zzchVar.zza();
        if (!zzchVar.zzg()) {
            return zza(zzfvVarZzd, iZza, obj);
        }
        List list = (List) obj;
        int iZza2 = 0;
        if (!zzchVar.zzf()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iZza2 += zza(zzfvVarZzd, iZza, it.next());
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            return zzby.zzw(0) + zzby.zzw(iZza << 3);
        }
        it2.next();
        zzfv zzfvVar = zzfv.zza;
        zzfw zzfwVar = zzfw.INT;
        throw null;
    }

    public static zzci zzd() {
        return zzb;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzl(Map.Entry entry) {
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzdh;
        if (zzchVar.zzg()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZze = zze(zzchVar);
            if (objZze == null) {
                objZze = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZze).add(zzk(it.next()));
            }
            this.zza.put(zzchVar, objZze);
            return;
        }
        if (zzchVar.zze() != zzfw.zzi) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzchVar, zzk(value));
            return;
        }
        Object objZze2 = zze(zzchVar);
        if (objZze2 != null) {
            if (z) {
                throw null;
            }
            this.zza.put(zzchVar, objZze2 instanceof zzeh ? zzchVar.zzc((zzeh) objZze2, (zzeh) value) : zzchVar.zzb(((zzec) objZze2).zzF(), (zzec) value).zzf());
        } else {
            this.zza.put(zzchVar, zzk(value));
            if (z) {
                this.zzd = true;
            }
        }
    }

    private static boolean zzm(Map.Entry entry) {
        zzch zzchVar = (zzch) entry.getKey();
        if (zzchVar.zze() != zzfw.zzi) {
            return true;
        }
        if (!zzchVar.zzg()) {
            return zzn(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzn(Object obj) {
        if (obj instanceof zzed) {
            return ((zzed) obj).zzk();
        }
        if (obj instanceof zzdh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i;
        int iZzw;
        int iM$3;
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        if (zzchVar.zze() != zzfw.zzi || zzchVar.zzg() || zzchVar.zzf()) {
            return zzb(zzchVar, value);
        }
        if (value instanceof zzdh) {
            int iZza = ((zzch) entry.getKey()).zza();
            int iZzw2 = zzby.zzw(8);
            i = iZzw2 + iZzw2;
            iZzw = zzby.zzw(iZza) + zzby.zzw(16);
            int iZzw3 = zzby.zzw(24);
            int iZza2 = ((zzdh) value).zza();
            iM$3 = BarcodeFormat$EnumUnboxingLocalUtility.m$3(iZza2, iZza2, iZzw3);
        } else {
            int iZza3 = ((zzch) entry.getKey()).zza();
            int iZzw4 = zzby.zzw(8);
            i = iZzw4 + iZzw4;
            iZzw = zzby.zzw(iZza3) + zzby.zzw(16);
            int iZzw5 = zzby.zzw(24);
            int iZzf = ((zzec) value).zzf();
            iM$3 = BarcodeFormat$EnumUnboxingLocalUtility.m$3(iZzf, iZzf, iZzw5);
        }
        return i + iZzw + iM$3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzp(zzch zzchVar, Object obj) {
        boolean z;
        zzchVar.zzd();
        byte[] bArr = zzda.zzd;
        obj.getClass();
        zzfv zzfvVar = zzfv.zza;
        zzfw zzfwVar = zzfw.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzbq) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzcu)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case zzi:
                if ((obj instanceof zzec) || (obj instanceof zzdh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzci zzciVar = new zzci();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzciVar.zzi((zzch) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzciVar.zzi((zzch) entry.getKey(), entry.getValue());
        }
        zzciVar.zzd = this.zzd;
        return zzciVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzci) {
            return this.zza.equals(((zzci) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzo = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzo += zzo(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzo += zzo((Map.Entry) it.next());
        }
        return iZzo;
    }

    public final Object zze(zzch zzchVar) {
        Object obj = this.zza.get(zzchVar);
        if (obj instanceof zzdh) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzdg(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzcs) {
                ((zzcs) entryZzg.getValue()).zzr();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzci zzciVar) {
        for (int i = 0; i < zzciVar.zza.zzb(); i++) {
            zzl(zzciVar.zza.zzg(i));
        }
        Iterator it = zzciVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzl((Map.Entry) it.next());
        }
    }

    public final void zzi(zzch zzchVar, Object obj) {
        if (!zzchVar.zzg()) {
            zzp(zzchVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzp(zzchVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzdh) {
            this.zzd = true;
        }
        this.zza.put(zzchVar, obj);
    }

    public final boolean zzj() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzm(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzm((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzci(boolean z) {
        zzg();
        zzg();
    }
}
