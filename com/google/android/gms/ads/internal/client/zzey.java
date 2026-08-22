package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzey {
    public static zzey zzb;
    public zzdb zzl;
    public final Object zzf = new Object();
    public boolean zzi = false;
    public boolean zzj = false;
    public final Object zzk = new Object();
    public RequestConfiguration zzn = new RequestConfiguration(-1, -1, null, new ArrayList(), 1);
    public final ArrayList zzh = new ArrayList();

    static {
        new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    }

    public static zzbmm zzA(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbmd zzbmdVar = (zzbmd) it.next();
            map.put(zzbmdVar.zza, new zzbml(zzbmdVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbmdVar.zzd, zzbmdVar.zzc));
        }
        return new zzbmm(map);
    }

    public static zzey zzf() {
        zzey zzeyVar;
        synchronized (zzey.class) {
            try {
                if (zzb == null) {
                    zzb = new zzey();
                }
                zzeyVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeyVar;
    }

    public final void zzB() {
        try {
            this.zzl.zzk();
            this.zzl.zzl(null, new ObjectWrapper(null));
        } catch (RemoteException e) {
            zzo.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    public final void zzC(Activity activity) {
        if (this.zzl == null) {
            this.zzl = (zzdb) new zzau(zzbb.zzb.zzd, activity).zzd(activity, false);
        }
    }

    public final InitializationStatus zze() {
        zzbmm zzbmmVarZzA;
        synchronized (this.zzk) {
            try {
                zzah.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting initialization status.");
                try {
                    zzbmmVarZzA = zzA(this.zzl.zzg());
                } catch (RemoteException unused) {
                    zzo.zzg("Unable to get Initialization status.");
                    return new ProfileCache(this, 21);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmmVarZzA;
    }
}
