package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbzc extends zzayu implements zzbzd {
    public static zzbzd zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(yzwzcWHcnH.ltXh);
        return iInterfaceQueryLocalInterface instanceof zzbzd ? (zzbzd) iInterfaceQueryLocalInterface : new zzbzb(iBinder);
    }
}
