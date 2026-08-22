package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.p002firebaseauthapi.zzadb;
import com.google.android.gms.internal.p002firebaseauthapi.zzadf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzadf<MessageType extends zzadf<MessageType, BuilderType>, BuilderType extends zzadb<MessageType, BuilderType>> extends zzabm<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzafo zzc = zzafo.zzc();

    public static zzadk zzA(zzadk zzadkVar) {
        int size = zzadkVar.size();
        return zzadkVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzC(Method method, Object obj, Object... objArr) {
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

    public static Object zzD(zzaek zzaekVar, String str, Object[] objArr) {
        return new zzaeu(zzaekVar, str, objArr);
    }

    public static void zzG(Class cls, zzadf zzadfVar) {
        zzb.put(cls, zzadfVar);
        zzadfVar.zzE();
    }

    private final int zza(zzaew zzaewVar) {
        return zzaewVar == null ? zzaes.zza().zzb(getClass()).zza(this) : zzaewVar.zza(this);
    }

    private static zzadf zzb(zzadf zzadfVar) throws zzadn {
        if (zzadfVar == null || zzadfVar.zzJ()) {
            return zzadfVar;
        }
        zzadn zzadnVarZza = new zzafm(zzadfVar).zza();
        zzadnVarZza.zzh(zzadfVar);
        throw zzadnVarZza;
    }

    private static zzadf zzc(zzadf zzadfVar, byte[] bArr, int i, int i2, zzacs zzacsVar) throws zzadn {
        zzadf zzadfVarZzw = zzadfVar.zzw();
        try {
            zzaew zzaewVarZzb = zzaes.zza().zzb(zzadfVarZzw.getClass());
            zzaewVarZzb.zzi(zzadfVarZzw, bArr, 0, i2, new zzabp(zzacsVar));
            zzaewVarZzb.zzf(zzadfVarZzw);
            return zzadfVarZzw;
        } catch (zzadn e) {
            e.zzh(zzadfVarZzw);
            throw e;
        } catch (zzafm e2) {
            zzadn zzadnVarZza = e2.zza();
            zzadnVarZza.zzh(zzadfVarZzw);
            throw zzadnVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzadn) {
                throw ((zzadn) e3.getCause());
            }
            zzadn zzadnVar = new zzadn(e3);
            zzadnVar.zzh(zzadfVarZzw);
            throw zzadnVar;
        } catch (IndexOutOfBoundsException unused) {
            zzadn zzadnVarZzi = zzadn.zzi();
            zzadnVarZzi.zzh(zzadfVarZzw);
            throw zzadnVarZzi;
        }
    }

    public static zzadf zzv(Class cls) {
        Map map = zzb;
        zzadf zzadfVar = (zzadf) map.get(cls);
        if (zzadfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzadfVar = (zzadf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzadfVar == null) {
            zzadfVar = (zzadf) ((zzadf) zzafx.zze(cls)).zzj(6, null, null);
            if (zzadfVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzadfVar);
        }
        return zzadfVar;
    }

    public static zzadf zzx(zzadf zzadfVar, zzacc zzaccVar, zzacs zzacsVar) throws zzadn {
        zzacg zzacgVarZzh = zzaccVar.zzh();
        zzadf zzadfVarZzw = zzadfVar.zzw();
        try {
            zzaew zzaewVarZzb = zzaes.zza().zzb(zzadfVarZzw.getClass());
            zzaewVarZzb.zzh(zzadfVarZzw, zzach.zzq(zzacgVarZzh), zzacsVar);
            zzaewVarZzb.zzf(zzadfVarZzw);
            try {
                zzacgVarZzh.zzm(0);
                zzb(zzadfVarZzw);
                return zzadfVarZzw;
            } catch (zzadn e) {
                e.zzh(zzadfVarZzw);
                throw e;
            }
        } catch (zzadn e2) {
            e2.zzh(zzadfVarZzw);
            throw e2;
        } catch (zzafm e3) {
            zzadn zzadnVarZza = e3.zza();
            zzadnVarZza.zzh(zzadfVarZzw);
            throw zzadnVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzadn) {
                throw ((zzadn) e4.getCause());
            }
            zzadn zzadnVar = new zzadn(e4);
            zzadnVar.zzh(zzadfVarZzw);
            throw zzadnVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzadn) {
                throw ((zzadn) e5.getCause());
            }
            throw e5;
        }
    }

    public static zzadf zzy(zzadf zzadfVar, byte[] bArr, zzacs zzacsVar) throws zzadn {
        zzadf zzadfVarZzc = zzc(zzadfVar, bArr, 0, bArr.length, zzacsVar);
        zzb(zzadfVarZzc);
        return zzadfVarZzc;
    }

    public static zzadk zzz() {
        return zzaet.zze();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaes.zza().zzb(getClass()).zzj(this, (zzadf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzK()) {
            return zzr();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzr = zzr();
        this.zza = iZzr;
        return iZzr;
    }

    public final String toString() {
        return zzaem.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaek
    public final /* synthetic */ zzaej zzB() {
        return (zzadb) zzj(5, null, null);
    }

    public final void zzE() {
        zzaes.zza().zzb(getClass()).zzf(this);
        zzF();
    }

    public final void zzF() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzH(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaek
    public final void zzI(zzacn zzacnVar) {
        zzaes.zza().zzb(getClass()).zzn(this, zzaco.zza(zzacnVar));
    }

    public final boolean zzJ() {
        byte bByteValue = ((Byte) zzj(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzaes.zza().zzb(getClass()).zzk(this);
        zzj(2, true != zZzk ? null : this, null);
        return zZzk;
    }

    public final boolean zzK() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael
    public final /* synthetic */ zzaek zzL() {
        return (zzadf) zzj(6, null, null);
    }

    public abstract Object zzj(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabm
    public final int zzn(zzaew zzaewVar) {
        if (zzK()) {
            int iZza = zza(zzaewVar);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(zzaewVar);
        if (iZza2 < 0) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzr() {
        return zzaes.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaek
    public final int zzs() {
        int iZza;
        if (zzK()) {
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

    public final zzadb zzt() {
        return (zzadb) zzj(5, null, null);
    }

    public final zzadb zzu() {
        zzadb zzadbVar = (zzadb) zzj(5, null, null);
        zzadbVar.zzh(this);
        return zzadbVar;
    }

    public final zzadf zzw() {
        return (zzadf) zzj(4, null, null);
    }
}
