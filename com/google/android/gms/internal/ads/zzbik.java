package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbik {
    private final zzbij zza;
    private final zzbgq zzc;
    private final List zzb = new ArrayList();
    private final VideoController zzd = new VideoController();
    private final List zze = new ArrayList();

    public zzbik(zzbij zzbijVar) {
        zzbgp zzbgnVar;
        IBinder iBinder;
        this.zza = zzbijVar;
        zzbgq zzbgqVar = null;
        try {
            List listZzv = zzbijVar.zzv();
            if (listZzv != null) {
                for (Object obj : listZzv) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzbgnVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzbgnVar = iInterfaceQueryLocalInterface instanceof zzbgp ? (zzbgp) iInterfaceQueryLocalInterface : new zzbgn(iBinder);
                    }
                    if (zzbgnVar != null) {
                        this.zzb.add(new zzbgq(zzbgnVar));
                    }
                }
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        try {
            List listZzw = this.zza.zzw();
            if (listZzw != null) {
                for (Object obj2 : listZzw) {
                    com.google.android.gms.ads.internal.client.zzdj zzdjVarZzb = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzfa.zzb((IBinder) obj2) : null;
                    if (zzdjVarZzb != null) {
                        this.zze.add(new com.google.android.gms.ads.internal.client.zzdk(zzdjVarZzb));
                    }
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
        try {
            zzbgp zzbgpVarZzl = this.zza.zzl();
            if (zzbgpVarZzl != null) {
                zzbgqVar = new zzbgq(zzbgpVarZzl);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e3);
        }
        this.zzc = zzbgqVar;
        try {
            if (this.zza.zzj() != null) {
                new zzbgj(this.zza.zzj());
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e4);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzA(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzL(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzD(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final VideoController zza() {
        try {
            zzbij zzbijVar = this.zza;
            if (zzbijVar.zzi() != null) {
                this.zzd.zzb(zzbijVar.zzi());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzd;
    }

    public final NativeAd$Image zzb() {
        return this.zzc;
    }

    public final Double zzc() {
        try {
            double dZze = this.zza.zze();
            if (dZze == -1.0d) {
                return null;
            }
            return Double.valueOf(dZze);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final Object zzd() {
        try {
            IObjectWrapper iObjectWrapperZzm = this.zza.zzm();
            if (iObjectWrapperZzm != null) {
                return ObjectWrapper.unwrap(iObjectWrapperZzm);
            }
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zze() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zzf() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zzg() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zzh() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zzi() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String zzj() {
        try {
            return this.zza.zzu();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final List zzk() {
        return this.zzb;
    }
}
