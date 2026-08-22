package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.Ko.TSDAbK;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbub extends zzayu implements zzbuc {
    public static zzbuc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(TSDAbK.olC);
        return iInterfaceQueryLocalInterface instanceof zzbuc ? (zzbuc) iInterfaceQueryLocalInterface : new zzbua(iBinder);
    }
}
