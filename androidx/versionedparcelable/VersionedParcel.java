package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class VersionedParcel {
    public final ArrayMap mParcelizerCache;
    public final ArrayMap mReadCache;
    public final ArrayMap mWriteCache;

    public VersionedParcel(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    public abstract VersionedParcelParcel createSubParcel();

    public final Class findParcelClass(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ArrayMap arrayMap = this.mParcelizerCache;
        Class cls2 = (Class) arrayMap.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        arrayMap.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method getReadMethod(String str) throws NoSuchMethodException {
        ArrayMap arrayMap = this.mReadCache;
        Method method = (Method) arrayMap.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        arrayMap.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method getWriteMethod(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ArrayMap arrayMap = this.mWriteCache;
        Method method = (Method) arrayMap.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class clsFindParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsFindParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        arrayMap.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean readField(int i);

    public final int readInt(int i, int i2) {
        return !readField(i2) ? i : ((VersionedParcelParcel) this).mParcel.readInt();
    }

    public final Parcelable readParcelable(Parcelable parcelable, int i) {
        if (!readField(i)) {
            return parcelable;
        }
        return ((VersionedParcelParcel) this).mParcel.readParcelable(VersionedParcelParcel.class.getClassLoader());
    }

    public final VersionedParcelable readVersionedParcelable() {
        String string = ((VersionedParcelParcel) this).mParcel.readString();
        if (string == null) {
            return null;
        }
        try {
            return (VersionedParcelable) getReadMethod(string).invoke(null, createSubParcel());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(FKidOcdAYt.OWcgrL, e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void setOutputField(int i);

    public final void writeInt(int i, int i2) {
        setOutputField(i2);
        ((VersionedParcelParcel) this).mParcel.writeInt(i);
    }

    public final void writeVersionedParcelable$1(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            ((VersionedParcelParcel) this).mParcel.writeString(null);
            return;
        }
        try {
            ((VersionedParcelParcel) this).mParcel.writeString(findParcelClass(versionedParcelable.getClass()).getName());
            VersionedParcelParcel versionedParcelParcelCreateSubParcel = createSubParcel();
            try {
                getWriteMethod(versionedParcelable.getClass()).invoke(null, versionedParcelable, versionedParcelParcelCreateSubParcel);
                int i = versionedParcelParcelCreateSubParcel.mCurrentField;
                if (i >= 0) {
                    int i2 = versionedParcelParcelCreateSubParcel.mPositionLookup.get(i);
                    Parcel parcel = versionedParcelParcelCreateSubParcel.mParcel;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(RDFWIi.GjaKOkuGpeiiMEY, e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
