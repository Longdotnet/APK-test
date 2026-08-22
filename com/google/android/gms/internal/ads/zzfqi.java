package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqi {
    final zzfql zza;
    final boolean zzb;

    private zzfqi(zzfql zzfqlVar) {
        this.zza = zzfqlVar;
        this.zzb = zzfqlVar != null;
    }

    public static zzfqi zzb(Context context, String str, String str2) {
        zzfql zzfqjVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderInstantiate == null) {
                        zzfqjVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfqjVar = iInterfaceQueryLocalInterface instanceof zzfql ? (zzfql) iInterfaceQueryLocalInterface : new zzfqj(iBinderInstantiate);
                    }
                    zzfqjVar.zze(new ObjectWrapper(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfqi(zzfqjVar);
                } catch (Exception e) {
                    throw new zzfpk(e);
                }
            } catch (Exception e2) {
                throw new zzfpk(e2);
            }
        } catch (RemoteException | zzfpk | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new zzfqi(new zzfqm());
        }
    }

    public static zzfqi zzc() {
        zzfqm zzfqmVar = new zzfqm();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfqi(zzfqmVar);
    }

    public final zzfqg zza(byte[] bArr) {
        return new zzfqg(this, bArr, null);
    }
}
