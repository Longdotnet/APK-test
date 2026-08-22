package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkf<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmp zzc = zzmp.zzc();

    private final int zza(zzlx zzlxVar) {
        return zzlxVar == null ? zzlu.zza().zzb(getClass()).zza(this) : zzlxVar.zza(this);
    }

    public static zzkk zzbB() {
        return zzkg.zzf();
    }

    public static zzkl zzbC() {
        return zzlb.zzf();
    }

    public static zzkl zzbD(zzkl zzklVar) {
        int size = zzklVar.size();
        return zzklVar.zzd(size == 0 ? 10 : size + size);
    }

    public static zzkm zzbE() {
        return zzlv.zze();
    }

    public static zzkm zzbF(zzkm zzkmVar) {
        int size = zzkmVar.size();
        return zzkmVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzbH(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzbI(zzlm zzlmVar, String str, Object[] objArr) {
        return new zzlw(zzlmVar, str, objArr);
    }

    public static void zzbL(Class cls, zzkf zzkfVar) {
        zza.put(cls, zzkfVar);
        zzkfVar.zzbJ();
    }

    public static zzkf zzbz(Class cls) {
        Map map = zza;
        zzkf zzkfVar = (zzkf) map.get(cls);
        if (zzkfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkfVar = (zzkf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkfVar == null) {
            zzkfVar = (zzkf) ((zzkf) zzmy.zze(cls)).zzl(6, null, null);
            if (zzkfVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzkfVar);
        }
        return zzkfVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlu.zza().zzb(getClass()).zzj(this, (zzkf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzbO()) {
            return zzbv();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iZzbv = zzbv();
        this.zzb = iZzbv;
        return iZzbv;
    }

    public final String toString() {
        return zzlo.zza(this, super.toString());
    }

    public final zzkf zzbA() {
        return (zzkf) zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzll zzbG() {
        return (zzkb) zzl(5, null, null);
    }

    public final void zzbJ() {
        zzlu.zza().zzb(getClass()).zzf(this);
        zzbK();
    }

    public final void zzbK() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzbM(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzbN(zzjm zzjmVar) {
        zzlu.zza().zzb(getClass()).zzi(this, zzjn.zza(zzjmVar));
    }

    public final boolean zzbO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final /* synthetic */ zzlm zzbS() {
        return (zzkf) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzbr(zzlx zzlxVar) {
        if (zzbO()) {
            int iZza = zza(zzlxVar);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(zzlxVar);
        if (iZza2 < 0) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzbv() {
        return zzlu.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzbw() {
        int iZza;
        if (zzbO()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza, "serialized size must be non-negative, was "));
            }
        } else {
            iZza = this.zzd & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza, "serialized size must be non-negative, was "));
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }

    public final zzkb zzbx() {
        return (zzkb) zzl(5, null, null);
    }

    public final zzkb zzby() {
        zzkb zzkbVar = (zzkb) zzl(5, null, null);
        zzkbVar.zzaA(this);
        return zzkbVar;
    }

    public abstract Object zzl(int i, Object obj, Object obj2);
}
