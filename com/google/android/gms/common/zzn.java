package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzc;
import com.google.gson.yWTz.kBfGXgdfpo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzn {
    public static final zzf zzc;
    public static final zzf zzd;
    public static volatile zzag zze;
    public static final Object zzf;
    public static Context zzg;

    static {
        new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 0);
        new zzf(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 1);
        zzc = new zzf(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 2);
        zzd = new zzf(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 3);
        zzf = new Object();
    }

    public static synchronized void zze(Context context) {
        if (zzg != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            zzg = context.getApplicationContext();
        }
    }

    public static zzx zzh(String str, zzk zzkVar, boolean z, boolean z2) {
        try {
            zzj();
            zzah.checkNotNull(zzg);
            zzs zzsVar = new zzs(str, zzkVar, z, z2);
            try {
                zzag zzagVar = zze;
                ObjectWrapper objectWrapper = new ObjectWrapper(zzg.getPackageManager());
                zzae zzaeVar = (zzae) zzagVar;
                Parcel parcelZza = zzaeVar.zza();
                zzc.zzc(parcelZza, zzsVar);
                zzc.zze(parcelZza, objectWrapper);
                Parcel parcelZzB = zzaeVar.zzB(5, parcelZza);
                boolean zZzf = zzc.zzf(parcelZzB);
                parcelZzB.recycle();
                return zZzf ? zzx.zze : new zzv(new zze(z, str, zzkVar));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return new zzx(false, "module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return new zzx(false, "module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    public static void zzj() {
        zzag zzaeVar;
        if (zze != null) {
            return;
        }
        zzah.checkNotNull(zzg);
        synchronized (zzf) {
            try {
                if (zze == null) {
                    IBinder iBinderInstantiate = DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, kBfGXgdfpo.aTSsItvFqfSCh).instantiate("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = zzaf.$r8$clinit;
                    if (iBinderInstantiate == null) {
                        zzaeVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        zzaeVar = iInterfaceQueryLocalInterface instanceof zzag ? (zzag) iInterfaceQueryLocalInterface : new zzae(iBinderInstantiate, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    }
                    zze = zzaeVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
