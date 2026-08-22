package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzazx {
    private final Object zza = new Object();
    private zzazv zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            try {
                zzazv zzazvVar = this.zzb;
                if (zzazvVar == null) {
                    return null;
                }
                return zzazvVar.zza();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            try {
                zzazv zzazvVar = this.zzb;
                if (zzazvVar == null) {
                    return null;
                }
                return zzazvVar.zzb();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zzazw zzazwVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new zzazv();
                }
                this.zzb.zzf(zzazwVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            try {
                if (!this.zzc) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Can not cast Context to Application");
                    } else {
                        if (this.zzb == null) {
                            this.zzb = new zzazv();
                        }
                        this.zzb.zzg(application, context);
                        this.zzc = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze(zzazw zzazwVar) {
        synchronized (this.zza) {
            try {
                zzazv zzazvVar = this.zzb;
                if (zzazvVar == null) {
                    return;
                }
                zzazvVar.zzh(zzazwVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
