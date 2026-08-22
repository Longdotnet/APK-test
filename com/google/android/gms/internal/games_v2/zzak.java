package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.IInterface;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzak extends zzb implements zzal {
    public static zzal zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(mnwSv.QXJmIESQ);
        return iInterfaceQueryLocalInterface instanceof zzal ? (zzal) iInterfaceQueryLocalInterface : new zzaj(iBinder);
    }
}
