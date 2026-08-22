package com.google.android.gms.internal.ads;

import android.Manifest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.login.vu.dLDI;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.internal.ads.zzgxh;
import com.google.android.gms.internal.ads.zzgxi;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgxh<MessageType extends zzgxi<MessageType, BuilderType>, BuilderType extends zzgxh<MessageType, BuilderType>> implements zzhar {
    private String zza(String str) {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Reading ", getClass().getName(), " from a ", str, " threw an IOException (should never happen).");
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zzhbd) {
                ((zzhbd) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    zzc(list, size2);
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            Manifest manifest = (Object) list2.get(i);
            if (manifest == null) {
                zzc(list, size2);
            }
            list.add(manifest);
        }
    }

    public static zzhbw zzbb(zzhas zzhasVar) {
        return new zzhbw(zzhasVar);
    }

    @Deprecated
    public static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    public static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgzu.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzhae)) {
            if (iterable instanceof zzhbb) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List listZza = ((zzhae) iterable).zza();
        zzhae zzhaeVar = (zzhae) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzhaeVar.size() - size, "Element at index ", " is null.");
                int size2 = zzhaeVar.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(strM);
                    }
                    zzhaeVar.remove(size2);
                }
            } else if (obj instanceof zzgxz) {
                zzhaeVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzgxz.zzv(bArr2, 0, bArr2.length);
                zzhaeVar.zzb();
            } else {
                zzhaeVar.add((String) obj);
            }
        }
    }

    private static void zzc(List<?> list, int i) {
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(list.size() - i, "Element at index ", " is null.");
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(strM);
            }
            list.remove(size);
        }
    }

    @Override // 
    public abstract BuilderType zzaC();

    public abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgxz zzgxzVar) throws zzgzw {
        try {
            zzgyf zzgyfVarZzl = zzgxzVar.zzl();
            zzaR(zzgyfVarZzl);
            zzgyfVarZzl.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* JADX INFO: renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaR(zzgyf zzgyfVar) {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (BuilderType) zzaW(zzgyfVar, zzgyr.zza);
    }

    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaS(zzhas zzhasVar) {
        if (zzbt().getClass().isInstance(zzhasVar)) {
            return (BuilderType) zzaD((zzgxi) zzhasVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) {
        zzgyf zzgyfVarZzG = zzgyf.zzG(inputStream, 4096);
        zzaR(zzgyfVarZzG);
        zzgyfVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaI, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaU(byte[] bArr) {
        return (BuilderType) zzaZ(bArr, 0, bArr.length);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzaW(zzgyf zzgyfVar, zzgyr zzgyrVar);

    public BuilderType zzaL(InputStream inputStream, zzgyr zzgyrVar) {
        zzgyf zzgyfVarZzG = zzgyf.zzG(inputStream, 4096);
        zzaW(zzgyfVarZzG, zzgyrVar);
        zzgyfVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaM, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaY(byte[] bArr, zzgyr zzgyrVar) {
        return (BuilderType) zzba(bArr, 0, bArr.length, zzgyrVar);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaN, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgzw {
        try {
            zzgyf zzgyfVarZzH = zzgyf.zzH(bArr, i, i2, false);
            zzaR(zzgyfVarZzH);
            zzgyfVarZzH.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza(dLDI.NwfxaRHhol), e2);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaO, reason: merged with bridge method [inline-methods] */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        try {
            zzgyf zzgyfVarZzH = zzgyf.zzH(bArr, i, i2, false);
            zzaW(zzgyfVarZzH, zzgyrVar);
            zzgyfVarZzH.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzhar zzaQ(zzgxz zzgxzVar) throws zzgzw {
        zzaE(zzgxzVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaT(InputStream inputStream) {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaV(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        zzaJ(zzgxzVar, zzgyrVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaX(InputStream inputStream, zzgyr zzgyrVar) {
        zzaL(inputStream, zzgyrVar);
        return this;
    }

    public boolean zzbe(InputStream inputStream) {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return zzbf(inputStream, zzgyr.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgyr zzgyrVar) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        zzaL(new zzgxg(inputStream, zzgyf.zzE(i, inputStream)), zzgyrVar);
        return true;
    }

    public BuilderType zzaJ(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        try {
            zzgyf zzgyfVarZzl = zzgxzVar.zzl();
            zzaW(zzgyfVarZzl, zzgyrVar);
            zzgyfVarZzl.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza(RDFWIi.omqQMTTXT), e2);
        }
    }
}
