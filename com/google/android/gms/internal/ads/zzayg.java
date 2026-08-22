package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzayg extends zzayk {
    public zzayg(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "1BnW1+pN8ACAA5SCwHeu4aDyUa+GdAsZQaTQjOE/fWA7hyCouT0ju5bDmhkUNXUI", "kp4jwXczzGPw0lGC8OB8RleYASbnnNEZzgNaMBT0Bfw=", zzastVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        zzast zzastVar = this.zzd;
        zzastVar.zzad(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (zzastVar) {
            try {
                if (zBooleanValue) {
                    zzastVar.zzad(2);
                } else {
                    zzastVar.zzad(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
