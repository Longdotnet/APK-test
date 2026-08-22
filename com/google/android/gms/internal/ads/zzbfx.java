package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbfx {
    private final Context zza;

    public zzbfx(Context context) {
        this.zza = context;
    }

    public final void zza(zzbuu zzbuuVar) {
        try {
            ((zzbfy) ExceptionsKt.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.internal.ads.zzbfw
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    IBinder iBinder = (IBinder) obj;
                    if (iBinder == null) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
                    return iInterfaceQueryLocalInterface instanceof zzbfy ? (zzbfy) iInterfaceQueryLocalInterface : new zzbfy(iBinder);
                }
            })).zze(zzbuuVar);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(FETmZwrVHuasmL.TswXcDGAmgk.concat(String.valueOf(e.getMessage())));
        } catch (com.google.android.gms.ads.internal.util.client.zzr e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e2.getMessage())));
        }
    }
}
