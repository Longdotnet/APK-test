package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.ads.zzgzb;
import com.google.android.gms.internal.ads.zzgzh;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgzh<MessageType extends zzgzh<MessageType, BuilderType>, BuilderType extends zzgzb<MessageType, BuilderType>> extends zzgxi<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zzgzh<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhby zzt = zzhby.zzc();

    public static zzgzj zzbA() {
        return zzgxp.zzd();
    }

    public static zzgzj zzbB(zzgzj zzgzjVar) {
        int size = zzgzjVar.size();
        return zzgzjVar.zzf(size + size);
    }

    public static zzgzk zzbC() {
        return zzgyo.zze();
    }

    public static zzgzk zzbD(zzgzk zzgzkVar) {
        int size = zzgzkVar.size();
        return zzgzkVar.zzf(size + size);
    }

    public static zzgzo zzbE() {
        return zzgyy.zze();
    }

    public static zzgzo zzbF(zzgzo zzgzoVar) {
        int size = zzgzoVar.size();
        return zzgzoVar.zzf(size + size);
    }

    public static zzgzp zzbG() {
        return zzgzi.zzg();
    }

    public static zzgzp zzbH(zzgzp zzgzpVar) {
        int size = zzgzpVar.size();
        return zzgzpVar.zzf(size + size);
    }

    public static zzgzs zzbI() {
        return zzhah.zzh();
    }

    public static zzgzs zzbJ(zzgzs zzgzsVar) {
        int size = zzgzsVar.size();
        return zzgzsVar.zzf(size + size);
    }

    public static <E> zzgzt<E> zzbK() {
        return zzhbd.zzd();
    }

    public static <E> zzgzt<E> zzbL(zzgzt<E> zzgztVar) {
        int size = zzgztVar.size();
        return zzgztVar.zzf(size + size);
    }

    public static Object zzbP(Method method, Object obj, Object... objArr) {
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

    public static Object zzbQ(zzhas zzhasVar, String str, Object[] objArr) {
        return new zzhbe(zzhasVar, str, objArr);
    }

    public static <T extends zzgzh> void zzbZ(Class<T> cls, T t) {
        t.zzbV();
        zzc.put(cls, t);
    }

    public static <ContainingType extends zzhas, Type> zzgzf<ContainingType, Type> zzbe(ContainingType containingtype, zzhas zzhasVar, zzgzm zzgzmVar, int i, zzhck zzhckVar, boolean z, Class cls) {
        return new zzgzf<>(containingtype, zzhbd.zzd(), zzhasVar, new zzgze(zzgzmVar, i, zzhckVar, true, z), cls);
    }

    public static <ContainingType extends zzhas, Type> zzgzf<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzhas zzhasVar, zzgzm zzgzmVar, int i, zzhck zzhckVar, Class cls) {
        return new zzgzf<>(containingtype, type, zzhasVar, new zzgze(zzgzmVar, i, zzhckVar, false, false), cls);
    }

    public static <T extends zzgzh> T zzbh(Class<T> cls) {
        zzgzh<?, ?> zzgzhVarZzbt = zzc.get(cls);
        if (zzgzhVarZzbt == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgzhVarZzbt = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgzhVarZzbt == null) {
            zzgzhVarZzbt = ((zzgzh) zzhce.zzg(cls)).zzbt();
            if (zzgzhVarZzbt == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzgzhVarZzbt);
        }
        return zzgzhVarZzbt;
    }

    public static <T extends zzgzh<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzg(t, inputStream, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbl(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzg(t, inputStream, zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbm(T t, zzgxz zzgxzVar) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzbr(t, zzgxzVar, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbn(T t, zzgyf zzgyfVar) {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbs(t, zzgyfVar, zzgyr.zza);
    }

    public static <T extends zzgzh<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgzw {
        zzgyf zzgyfVarZzG = zzgyf.zzG(inputStream, 4096);
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzbz(t, zzgyfVarZzG, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbv(t, byteBuffer, zzgyr.zza);
    }

    public static <T extends zzgzh<T, ?>> T zzbq(T t, byte[] bArr) throws zzgzw {
        int length = bArr.length;
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzi(t, bArr, 0, length, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbr(T t, zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzh(t, zzgxzVar, zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbs(T t, zzgyf zzgyfVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzbz(t, zzgyfVar, zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbu(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzbz(t, zzgyf.zzG(inputStream, 4096), zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgyr zzgyrVar) throws zzgzw {
        zzgyf zzgyfVarZzH;
        boolean z = false;
        if (byteBuffer.hasArray()) {
            zzgyfVarZzH = zzgyf.zzH(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect() && zzhce.zzB()) {
            zzgyfVarZzH = new zzgyd(byteBuffer, z, null);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            zzgyfVarZzH = zzgyf.zzH(bArr, 0, iRemaining, true);
        }
        T t2 = (T) zzbs(t, zzgyfVarZzH, zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzbx(T t, byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzi(t, bArr, 0, bArr.length, zzgyrVar);
        zzf(t2);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzby(T t, zzgyf zzgyfVar) {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbz(t, zzgyfVar, zzgyr.zza);
    }

    public static <T extends zzgzh<T, ?>> T zzbz(T t, zzgyf zzgyfVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) t.zzbj();
        try {
            zzhbl zzhblVarZzb = zzhbc.zza().zzb(t2.getClass());
            zzhblVarZzb.zzh(t2, zzgyg.zzq(zzgyfVar), zzgyrVar);
            zzhblVarZzb.zzf(t2);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (zzhbw e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgzw) {
                throw ((zzgzw) e3.getCause());
            }
            throw new zzgzw(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgzw) {
                throw ((zzgzw) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhbl<?> zzhblVar) {
        if (zzhblVar != null) {
            return zzhblVar.zza(this);
        }
        return zzhbc.zza().zzb(getClass()).zza(this);
    }

    public static <MessageType extends zzgzd<MessageType, BuilderType>, BuilderType, T> zzgzf<MessageType, T> zzd(zzgyp<MessageType, T> zzgypVar) {
        return (zzgzf) zzgypVar;
    }

    private static <T extends zzgzh<T, ?>> T zzf(T t) throws zzgzw {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgzh<T, ?>> T zzg(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            zzgyf zzgyfVarZzG = zzgyf.zzG(new zzgxg(inputStream, zzgyf.zzE(i, inputStream)), 4096);
            T t2 = (T) zzbz(t, zzgyfVarZzG, zzgyrVar);
            zzgyfVarZzG.zzy(0);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzgzw(e2);
        }
    }

    private static <T extends zzgzh<T, ?>> T zzh(T t, zzgxz zzgxzVar, zzgyr zzgyrVar) {
        zzgyf zzgyfVarZzl = zzgxzVar.zzl();
        T t2 = (T) zzbz(t, zzgyfVarZzl, zzgyrVar);
        zzgyfVarZzl.zzy(0);
        return t2;
    }

    public static <T extends zzgzh<T, ?>> T zzi(T t, byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbj();
        try {
            zzhbl zzhblVarZzb = zzhbc.zza().zzb(t2.getClass());
            zzhblVarZzb.zzi(t2, bArr, i, i + i2, new zzgxn(zzgyrVar));
            zzhblVarZzb.zzf(t2);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (zzhbw e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgzw) {
                throw ((zzgzw) e3.getCause());
            }
            throw new zzgzw(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private void zzj() {
        if (this.zzt == zzhby.zzc()) {
            this.zzt = zzhby.zzf();
        }
    }

    public static final <T extends zzgzh<T, ?>> boolean zzk(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzdd(zzgzg.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzhbc.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzdd(zzgzg.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t, null);
        }
        return zZzl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhbc.zza().zzb(getClass()).zzk(this, (zzgzh) obj);
    }

    public int hashCode() {
        if (zzcd()) {
            return zzaW();
        }
        if (zzcc()) {
            zzca(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzhau.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    public int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    public int zzaM(zzhbl zzhblVar) {
        if (zzcd()) {
            int iZzc = zzc(zzhblVar);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZzc, "serialized size must be non-negative, was "));
        }
        if (zzaL() != Integer.MAX_VALUE) {
            return zzaL();
        }
        int iZzc2 = zzc(zzhblVar);
        zzaS(iZzc2);
        return iZzc2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    public zzhax zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    public void zzaS(int i) {
        if (i < 0) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "serialized size must be non-negative, was "));
        }
        this.zzd = i | (this.zzd & zza);
    }

    public int zzaW() {
        return zzhbc.zza().zzb(getClass()).zzb(this);
    }

    public int zzaX() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public int zzaY() {
        return zzaM(null);
    }

    public final <MessageType2 extends zzgzh<MessageType2, BuilderType2>, BuilderType2 extends zzgzb<MessageType2, BuilderType2>> BuilderType2 zzaZ() {
        return (BuilderType2) zzdd(zzgzg.NEW_BUILDER, null, null);
    }

    public final zzhba<MessageType> zzbN() {
        return (zzhba) zzdd(zzgzg.GET_PARSER, null, null);
    }

    public Object zzbO() {
        return zzdd(zzgzg.BUILD_MESSAGE_INFO, null, null);
    }

    public void zzbS() {
        this.zzq = 0;
    }

    public void zzbT() {
        zzaS(Integer.MAX_VALUE);
    }

    public void zzbU() {
        zzhbc.zza().zzb(getClass()).zzf(this);
        zzbV();
    }

    public void zzbV() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public void zzbW(int i, zzgxz zzgxzVar) {
        zzj();
        zzhby zzhbyVar = this.zzt;
        zzhbyVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhbyVar.zzj((i << 3) | 2, zzgxzVar);
    }

    public final void zzbX(zzhby zzhbyVar) {
        this.zzt = zzhby.zze(this.zzt, zzhbyVar);
    }

    public void zzbY(int i, int i2) {
        zzj();
        zzhby zzhbyVar = this.zzt;
        zzhbyVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhbyVar.zzj(i << 3, Long.valueOf(i2));
    }

    public final <MessageType2 extends zzgzh<MessageType2, BuilderType2>, BuilderType2 extends zzgzb<MessageType2, BuilderType2>> BuilderType2 zzba(MessageType2 messagetype2) {
        BuilderType2 buildertype2 = (BuilderType2) zzaZ();
        buildertype2.zzbj(messagetype2);
        return buildertype2;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    /* JADX INFO: renamed from: zzbb */
    public final BuilderType zzcY() {
        return (BuilderType) zzdd(zzgzg.NEW_BUILDER, null, null);
    }

    /* JADX INFO: renamed from: zzbc */
    public final BuilderType zzbM() {
        BuilderType buildertype = (BuilderType) zzdd(zzgzg.NEW_BUILDER, null, null);
        buildertype.zzbj(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    /* JADX INFO: renamed from: zzbi */
    public final MessageType zzbt() {
        return (MessageType) zzdd(zzgzg.GET_DEFAULT_INSTANCE, null, null);
    }

    public MessageType zzbj() {
        return (MessageType) zzdd(zzgzg.NEW_MUTABLE_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    public final boolean zzbw() {
        return zzk(this, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public void zzcZ(zzgym zzgymVar) {
        zzhbc.zza().zzb(getClass()).zzj(this, zzgyn.zza(zzgymVar));
    }

    public void zzca(int i) {
        this.zzq = i;
    }

    public boolean zzcc() {
        return zzaX() == 0;
    }

    public boolean zzcd() {
        return (this.zzd & zza) != 0;
    }

    public boolean zzce(int i, zzgyf zzgyfVar) {
        if ((i & 7) == 4) {
            return false;
        }
        zzj();
        return this.zzt.zzm(i, zzgyfVar);
    }

    public abstract Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2);

    public static Method zzbR(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(JuorMn.rRpxakJ, cls.getName(), "\" missing method \"", str, "\"."), e);
        }
    }
}
