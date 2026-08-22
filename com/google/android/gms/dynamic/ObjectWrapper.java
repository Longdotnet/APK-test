package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzah;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectWrapper extends com.google.android.gms.internal.common.zzb implements IObjectWrapper {
    public final Object zza;

    public ObjectWrapper(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.zza = obj;
    }

    public static IObjectWrapper asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) iInterfaceQueryLocalInterface : new zzb(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static Object unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).zza;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        zzah.checkNotNull(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
