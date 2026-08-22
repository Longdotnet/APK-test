package com.google.firebase.auth;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.GenericGFPoly;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: classes.dex */
public final class zzz implements com.google.android.gms.internal.measurement.zzo, zzgr, Continuation, FidListenerHandle {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public Object zzb;

    public /* synthetic */ zzz() {
        this.$r8$classId = 1;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static zzz acquire(Context context) {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), "generatefid.lock"), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new zzz((Object) channel, (AutoCloseable) fileLockLock, 7);
                } catch (IOException e) {
                    e = e;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Error e2) {
                    e = e2;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                } catch (OverlappingFileLockException e3) {
                    e = e3;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException e4) {
                e = e4;
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e5) {
            e = e5;
            channel = null;
            fileLockLock = null;
        }
    }

    public void add(Object obj, String str) {
        ((ArrayList) this.zza).add(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, "=", String.valueOf(obj)));
    }

    public void encode(int i, int[] iArr) {
        GenericGFPoly genericGFPoly;
        int i2;
        GenericGFPoly genericGFPoly2;
        GenericGFPoly genericGFPoly3;
        GenericGFPoly genericGFPoly4;
        int i3;
        int i4 = 0;
        int i5 = 2;
        int i6 = 1;
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        ArrayList arrayList = (ArrayList) this.zzb;
        int size = arrayList.size();
        GenericGF genericGF = (GenericGF) this.zza;
        if (i >= size) {
            GenericGFPoly genericGFPoly5 = (GenericGFPoly) arrayList.get(arrayList.size() - 1);
            int size2 = arrayList.size();
            while (size2 <= i) {
                int[] iArr2 = {i6, genericGF.expTable[(size2 - 1) + genericGF.generatorBase]};
                if (iArr2[i4] == 0) {
                    int i7 = i6;
                    while (i7 < i5 && iArr2[i7] == 0) {
                        i7 += i6;
                    }
                    if (i7 == i5) {
                        iArr2 = new int[]{i4};
                    } else {
                        int i8 = 2 - i7;
                        int[] iArr3 = new int[i8];
                        System.arraycopy(iArr2, i7, iArr3, i4, i8);
                        iArr2 = iArr3;
                    }
                }
                genericGFPoly5.getClass();
                GenericGF genericGF2 = genericGFPoly5.field;
                if (!genericGF2.equals(genericGF)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                }
                int[] iArr4 = genericGFPoly5.coefficients;
                if (iArr4[i4] == 0 || iArr2[i4] == 0) {
                    genericGFPoly4 = genericGF2.zero;
                    i3 = i6;
                } else {
                    int length2 = iArr4.length;
                    int length3 = iArr2.length;
                    int[] iArr5 = new int[(length2 + length3) - 1];
                    while (i4 < length2) {
                        int i9 = iArr4[i4];
                        int i10 = 0;
                        while (i10 < length3) {
                            int i11 = i4 + i10;
                            iArr5[i11] = iArr5[i11] ^ genericGF2.multiply(i9, iArr2[i10]);
                            i10++;
                            iArr4 = iArr4;
                        }
                        i4++;
                        i6 = 1;
                        iArr4 = iArr4;
                    }
                    i3 = i6;
                    genericGFPoly4 = new GenericGFPoly(genericGF2, iArr5);
                }
                arrayList.add(genericGFPoly4);
                size2 += i3;
                i6 = i3;
                i4 = 0;
                i5 = 2;
                genericGFPoly5 = genericGFPoly4;
            }
        }
        GenericGFPoly genericGFPoly6 = (GenericGFPoly) arrayList.get(i);
        int[] iArr6 = new int[length];
        System.arraycopy(iArr, 0, iArr6, 0, length);
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        if (length > 1 && iArr6[0] == 0) {
            int i12 = 1;
            while (i12 < length && iArr6[i12] == 0) {
                i12++;
            }
            if (i12 == length) {
                iArr6 = new int[]{0};
            } else {
                int i13 = length - i12;
                int[] iArr7 = new int[i13];
                System.arraycopy(iArr6, i12, iArr7, 0, i13);
                iArr6 = iArr7;
            }
        }
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length4 = iArr6.length;
        int[] iArr8 = new int[length4 + i];
        for (int i14 = 0; i14 < length4; i14++) {
            iArr8[i14] = genericGF.multiply(iArr6[i14], 1);
        }
        GenericGFPoly genericGFPoly7 = new GenericGFPoly(genericGF, iArr8);
        if (!genericGF.equals(genericGFPoly6.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        int[] iArr9 = genericGFPoly6.coefficients;
        if (iArr9[0] == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        int i15 = iArr9[(iArr9.length - 1) - genericGFPoly6.getDegree()];
        if (i15 == 0) {
            throw new ArithmeticException();
        }
        int i16 = genericGF.expTable[(genericGF.size - genericGF.logTable[i15]) - 1];
        GenericGFPoly genericGFPoly8 = genericGF.zero;
        GenericGFPoly genericGFPolyAddOrSubtract = genericGFPoly8;
        while (genericGFPoly7.getDegree() >= genericGFPoly6.getDegree()) {
            int[] iArr10 = genericGFPoly7.coefficients;
            if (iArr10[0] == 0) {
                break;
            }
            int degree = genericGFPoly7.getDegree() - genericGFPoly6.getDegree();
            int iMultiply = genericGF.multiply(iArr10[(iArr10.length - 1) - genericGFPoly7.getDegree()], i16);
            if (degree < 0) {
                throw new IllegalArgumentException();
            }
            GenericGF genericGF3 = genericGFPoly6.field;
            if (iMultiply == 0) {
                genericGFPoly2 = genericGF3.zero;
                genericGFPoly = genericGFPoly6;
                i2 = 1;
            } else {
                int length5 = iArr9.length;
                int[] iArr11 = new int[length5 + degree];
                int i17 = 0;
                while (i17 < length5) {
                    iArr11[i17] = genericGF3.multiply(iArr9[i17], iMultiply);
                    i17++;
                    genericGFPoly6 = genericGFPoly6;
                }
                genericGFPoly = genericGFPoly6;
                i2 = 1;
                genericGFPoly2 = new GenericGFPoly(genericGF3, iArr11);
            }
            if (degree < 0) {
                throw new IllegalArgumentException();
            }
            if (iMultiply == 0) {
                genericGFPoly3 = genericGFPoly8;
            } else {
                int[] iArr12 = new int[degree + i2];
                iArr12[0] = iMultiply;
                genericGFPoly3 = new GenericGFPoly(genericGF, iArr12);
            }
            genericGFPolyAddOrSubtract = genericGFPolyAddOrSubtract.addOrSubtract(genericGFPoly3);
            genericGFPoly7 = genericGFPoly7.addOrSubtract(genericGFPoly2);
            genericGFPoly6 = genericGFPoly;
        }
        int[] iArr13 = new GenericGFPoly[]{genericGFPolyAddOrSubtract, genericGFPoly7}[1].coefficients;
        int length6 = i - iArr13.length;
        for (int i18 = 0; i18 < length6; i18++) {
            iArr[length + i18] = 0;
        }
        System.arraycopy(iArr13, 0, iArr, length + length6, iArr13.length);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    public ObjectConstructor get(TypeToken typeToken) {
        zzy zzyVar;
        HashMap map = (HashMap) this.zza;
        Type type = typeToken.type;
        if (map.get(type) != null) {
            throw new ClassCastException();
        }
        Class cls = typeToken.rawType;
        if (map.get(cls) != null) {
            throw new ClassCastException();
        }
        ObjectConstructor zzrVar = null;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                ((ReflectionAccessor) this.zzb).makeAccessible(declaredConstructor);
            }
            zzyVar = new zzy(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            zzyVar = null;
        }
        if (zzyVar != null) {
            return zzyVar;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                zzrVar = new zzr(12);
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                zzrVar = new ConnectionPool(type);
            } else if (Set.class.isAssignableFrom(cls)) {
                zzrVar = new zzr(13);
            } else {
                zzrVar = Queue.class.isAssignableFrom(cls) ? new zzr(14) : new zzr(15);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                zzrVar = new zzr(16);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                zzrVar = new zzr(8);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                zzrVar = new zzr(9);
            } else if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                type2.getClass();
                Type typeCanonicalize = Streams.canonicalize(type2);
                Class rawType = Streams.getRawType(typeCanonicalize);
                typeCanonicalize.hashCode();
                if (String.class.isAssignableFrom(rawType)) {
                    zzrVar = new zzr(11);
                } else {
                    zzrVar = new zzr(10);
                }
            } else {
                zzrVar = new zzr(11);
            }
        }
        return zzrVar != null ? zzrVar : new zzaa(cls, type);
    }

    public String getString(String str) {
        String str2 = (String) this.zzb;
        Resources resources = (Resources) this.zza;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            ((zzci) this.zza).zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzfr zzfrVar = ((AppMeasurementDynamiteService) this.zzb).zza;
            if (zzfrVar != null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, "Event interceptor threw exception");
            }
        }
    }

    public void releaseAndClose() {
        try {
            ((FileLock) this.zzb).release();
            ((FileChannel) this.zza).close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(((FirebaseUser) this.zzb).zza());
        String token = getTokenResult.getToken();
        com.google.android.gms.common.internal.zzah.checkNotNull(token);
        return firebaseAuth.zzi((ActionCodeSettings) this.zza, token);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.zzb.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.zza;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            case 9:
                return ((HashMap) this.zza).toString();
            default:
                return super.toString();
        }
    }

    @Override // com.google.firebase.installations.internal.FidListenerHandle
    public void unregister() {
        synchronized (((FirebaseInstallations) this.zzb)) {
            ((FirebaseInstallations) this.zzb).fidListeners.remove((FidListener) this.zza);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public String zza(String str) {
        Map map = (Map) ((zzfi) this.zzb).zzg.getOrDefault((String) this.zza, null);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }

    public zzz(zzkc zzkcVar) {
        this.$r8$classId = 5;
        this.zzb = zzkcVar;
    }

    public /* synthetic */ zzz(Object obj, AutoCloseable autoCloseable, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = autoCloseable;
    }

    public /* synthetic */ zzz(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    public zzz(Context context) {
        this.$r8$classId = 3;
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(com.daerisoft.thespikerm.R.string.common_google_play_services_unknown_issue);
    }

    public /* synthetic */ zzz(Object obj) {
        this.$r8$classId = 2;
        com.google.android.gms.common.internal.zzah.checkNotNull(obj);
        this.zzb = obj;
        this.zza = new ArrayList();
    }

    public zzz(GenericGF genericGF) {
        this.$r8$classId = 10;
        this.zza = genericGF;
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    public zzz(HashMap map) {
        this.$r8$classId = 9;
        this.zzb = ReflectionAccessor.instance;
        this.zza = map;
    }
}
