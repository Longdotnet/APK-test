package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzbim extends RemoteCreator {
    public zzbim() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzbhc ? (zzbhc) iInterfaceQueryLocalInterface : new zzbha(iBinder);
    }

    public final zzbgz zza(View view, HashMap map, HashMap map2) {
        try {
            IBinder iBinderZze = ((zzbhc) getRemoteCreatorInstance(view.getContext())).zze(new ObjectWrapper(view), new ObjectWrapper(map), new ObjectWrapper(map2));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return iInterfaceQueryLocalInterface instanceof zzbgz ? (zzbgz) iInterfaceQueryLocalInterface : new zzbgx(iBinderZze);
        } catch (RemoteException e) {
            e = e;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            e = e2;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }
}
