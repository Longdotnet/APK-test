package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdr extends zzcdn {
    public zzcdr(zzccb zzccbVar) {
        super(zzccbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(String str) {
        String strZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(str, "MD5");
        zzccb zzccbVar = (zzccb) this.zzc.get();
        if (zzccbVar != null && strZzE != null) {
            zzccbVar.zzt(strZzE, this);
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, strZzE, "noop", "Noop cache is a noop.");
        return false;
    }
}
