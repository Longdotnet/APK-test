package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbun;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzae extends zzba {
    public final /* synthetic */ OutOfContextTestingActivity zza;
    public final /* synthetic */ zzbpm zzb;

    public zzae(TooltipPopup tooltipPopup, OutOfContextTestingActivity outOfContextTestingActivity, zzbpm zzbpmVar) {
        this.zza = outOfContextTestingActivity;
        this.zzb = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zza() {
        TooltipPopup.zzv(this.zza, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        OutOfContextTestingActivity outOfContextTestingActivity = this.zza;
        ObjectWrapper objectWrapper = new ObjectWrapper(outOfContextTestingActivity);
        zzbde.zza(outOfContextTestingActivity);
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzjO)).booleanValue()) {
            return zzcrVar.zzi(objectWrapper, this.zzb, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        zzdx zzdxVar;
        OutOfContextTestingActivity outOfContextTestingActivity = this.zza;
        ObjectWrapper objectWrapper = new ObjectWrapper(outOfContextTestingActivity);
        zzbde.zza(outOfContextTestingActivity);
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzjO)).booleanValue()) {
            return null;
        }
        try {
            try {
                IBinder iBinderInstantiate = ExceptionsKt.zzc(outOfContextTestingActivity).instantiate("com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl");
                if (iBinderInstantiate == null) {
                    zzdxVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                    zzdxVar = iInterfaceQueryLocalInterface instanceof zzdx ? (zzdx) iInterfaceQueryLocalInterface : new zzdx(iBinderInstantiate, "com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                }
                return zzdxVar.zze(objectWrapper, this.zzb);
            } catch (Exception e) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbun.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
            e = e3;
            zzbun.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        } catch (NullPointerException e4) {
            e = e4;
            zzbun.zza(outOfContextTestingActivity).zzh(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
