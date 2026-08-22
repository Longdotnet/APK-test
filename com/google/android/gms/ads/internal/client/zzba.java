package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbez;
import com.google.android.gms.internal.ads.zzbfn;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzba {
    public static final zzcr zza;

    public abstract Object zza();

    public abstract Object zzb(zzcr zzcrVar);

    public abstract Object zzc();

    public final Object zzd(Context context, boolean z) {
        boolean z2;
        Object objZzc;
        Object objZzb;
        if (!z) {
            zzf zzfVar = zzbb.zzb.zzc;
            if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 12451000) != 0) {
                zzo.zze("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z3 = false;
        boolean z4 = !(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.zza(context, ModuleDescriptor.MODULE_ID, false));
        zzbde.zza(context);
        if (((Boolean) zzbez.zza.zze()).booleanValue()) {
            z2 = false;
        } else if (((Boolean) zzbez.zzb.zze()).booleanValue()) {
            z2 = true;
            z3 = true;
        } else {
            z3 = z | z4;
            z2 = false;
        }
        zzcr zzcrVar = zza;
        Object objZzb2 = null;
        if (z3) {
            if (zzcrVar != null) {
                try {
                    objZzb = zzb(zzcrVar);
                } catch (RemoteException e) {
                    zzo.zzk("Cannot invoke local loader using ClientApi class.", e);
                    objZzb = null;
                }
                if (objZzb == null && !z2) {
                    try {
                        objZzb2 = zzc();
                    } catch (RemoteException e2) {
                        zzo.zzk("Cannot invoke remote loader.", e2);
                    }
                    objZzb = objZzb2;
                }
            } else {
                zzo.zzj("ClientApi class cannot be loaded.");
            }
            objZzb = null;
            if (objZzb == null) {
                objZzb2 = zzc();
                objZzb = objZzb2;
            }
        } else {
            try {
                objZzc = zzc();
            } catch (RemoteException e3) {
                zzo.zzk("Cannot invoke remote loader.", e3);
                objZzc = null;
            }
            if (objZzc == null) {
                int iIntValue = ((Long) zzbfn.zza.zze()).intValue();
                zzbb zzbbVar = zzbb.zzb;
                if (zzbbVar.zzg.nextInt(iIntValue) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    String str = zzbbVar.zzf.afmaVersion;
                    zzf zzfVar2 = zzbbVar.zzc;
                    zzfVar2.getClass();
                    zzf.zzB(context, str, bundle, new RoomOpenHelper(zzfVar2, context, 27, false));
                }
            }
            if (objZzc == null) {
                if (zzcrVar != null) {
                    try {
                        objZzb2 = zzb(zzcrVar);
                    } catch (RemoteException e4) {
                        zzo.zzk("Cannot invoke local loader using ClientApi class.", e4);
                    }
                } else {
                    zzo.zzj("ClientApi class cannot be loaded.");
                }
                objZzb = objZzb2;
            } else {
                objZzb = objZzc;
            }
        }
        return objZzb == null ? zza() : objZzb;
    }

    static {
        String str = YcVWhnLsj.VPAPjOI;
        zzcr zzcpVar = null;
        try {
            Object objNewInstance = TooltipPopup.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
                    zzcpVar = iInterfaceQueryLocalInterface instanceof zzcr ? (zzcr) iInterfaceQueryLocalInterface : new zzcp(iBinder, str);
                }
            } else {
                zzo.zzj("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            zzo.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzcpVar;
    }
}
