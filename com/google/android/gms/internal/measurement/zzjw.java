package com.google.android.gms.internal.measurement;

import androidx.work.impl.constraints.controllers.pST.ehgOP;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzjw {
    private static final zzjw zzb = new zzjw(true);
    final zzmk zza = new zzma(16);
    private boolean zzc;
    private boolean zzd;

    private zzjw() {
    }

    public static zzjw zza() {
        throw null;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzjw zzjwVar = new zzjw();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzjwVar.zzc((zzjv) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjwVar.zzc((zzjv) entry.getKey(), entry.getValue());
        }
        zzjwVar.zzd = this.zzd;
        return zzjwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjw) {
            return this.zza.equals(((zzjw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzkf) {
                ((zzkf) entryZzg.getValue()).zzbJ();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzjv zzjvVar, Object obj) {
        if (!zzjvVar.zzc()) {
            zzd(zzjvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzjvVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzkr) {
            this.zzd = true;
        }
        this.zza.put(zzjvVar, obj);
    }

    private zzjw(boolean z) {
        zzb();
        zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzd(zzjv zzjvVar, Object obj) {
        boolean z;
        zzjvVar.zzb();
        zzkn.zze(obj);
        zzne zzneVar = zzne.zza;
        zznf zznfVar = zznf.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzje) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzkh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzlm) || (obj instanceof zzkr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format(ehgOP.ajiwirH, Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
        }
    }
}
