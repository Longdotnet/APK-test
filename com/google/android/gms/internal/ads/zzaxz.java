package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxz extends zzayk {
    public zzaxz(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "4HRSTLOwWZkuNJXWodn1qJJgWaIIvv19EC2kc5Tc35PPh8H51LV3J7XsfwYf6N8B", "x59qZ2C8s/H9o8A43vx+gBO6K2fFzzXR0hkzA9nrVNs=", zzastVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        int i = 1;
        try {
            boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzast zzastVar = this.zzd;
            if (true == zBooleanValue) {
                i = 2;
            }
            zzastVar.zzac(i);
        } catch (InvocationTargetException unused) {
            this.zzd.zzac(3);
        }
    }
}
