package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import kotlin.ExceptionsKt;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzk extends RemoteCreator {
    public zzbup zza;

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzby ? (zzby) iInterfaceQueryLocalInterface : new zzby(iBinder);
    }

    public final zzbx zza(Context context, zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        zzby zzbyVar;
        zzbx zzbvVar;
        zzbx zzbvVar2;
        zzbde.zza(context);
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue()) {
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(context);
                try {
                    IBinder iBinderInstantiate = ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.ChimeraAdManagerCreatorImpl");
                    if (iBinderInstantiate == null) {
                        zzbyVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface(ygoi.gqimacnj);
                        if (iInterfaceQueryLocalInterface instanceof zzby) {
                            zzbyVar = (zzby) iInterfaceQueryLocalInterface;
                        } else {
                            zzbyVar = new zzby(iBinderInstantiate);
                        }
                    }
                    IBinder iBinderZze = zzbyVar.zze(objectWrapper, zzrVar, str, zzbpqVar, i);
                    if (iBinderZze == null) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface2 = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (iInterfaceQueryLocalInterface2 instanceof zzbx) {
                        zzbvVar = (zzbx) iInterfaceQueryLocalInterface2;
                    } else {
                        zzbvVar = new zzbv(iBinderZze);
                    }
                    return zzbvVar;
                } catch (Exception e) {
                    throw new com.google.android.gms.ads.internal.util.client.zzr(e);
                }
            } catch (RemoteException e2) {
                e = e2;
                zzbup zzbupVarZza = zzbun.zza(context);
                this.zza = zzbupVarZza;
                zzbupVarZza.zzh(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzo.zzl("#007 Could not call remote method.", e);
                return null;
            } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
                e = e3;
                zzbup zzbupVarZza2 = zzbun.zza(context);
                this.zza = zzbupVarZza2;
                zzbupVarZza2.zzh(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzo.zzl("#007 Could not call remote method.", e);
                return null;
            } catch (NullPointerException e4) {
                e = e4;
                zzbup zzbupVarZza3 = zzbun.zza(context);
                this.zza = zzbupVarZza3;
                zzbupVarZza3.zzh(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzo.zzl("#007 Could not call remote method.", e);
                return null;
            }
        }
        try {
            IBinder iBinderZze2 = ((zzby) getRemoteCreatorInstance(context)).zze(new ObjectWrapper(context), zzrVar, str, zzbpqVar, i);
            if (iBinderZze2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface3 = iBinderZze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface3 instanceof zzbx) {
                zzbvVar2 = (zzbx) iInterfaceQueryLocalInterface3;
            } else {
                zzbvVar2 = new zzbv(iBinderZze2);
            }
            return zzbvVar2;
        } catch (RemoteException e5) {
            e = e5;
            zzo.zzf("Could not create remote AdManager.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e6) {
            e = e6;
            zzo.zzf("Could not create remote AdManager.", e);
            return null;
        }
    }
}
