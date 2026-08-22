package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzayc extends zzayk {
    private final StackTraceElement[] zzh;

    public zzayc(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzawxVar, "UtW7g7feJqOHsjIRMP7TbkL8M4VYsmVrsaULCIKJGwvBOELKcxTQZfT6AHg6wl4V", "3s4OpKjyDjUzqtut1o8wCVCKFRdtRePXWRu+sqk/xG8=", zzastVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzawo zzawoVar = new zzawo((String) this.zze.invoke(null, stackTraceElementArr));
            zzast zzastVar = this.zzd;
            synchronized (zzastVar) {
                try {
                    zzastVar.zzD(zzawoVar.zza.longValue());
                    if (zzawoVar.zzb.booleanValue()) {
                        zzastVar.zzZ(true != zzawoVar.zzc.booleanValue() ? 2 : 1);
                    } else {
                        zzastVar.zzZ(3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
