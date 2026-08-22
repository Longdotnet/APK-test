package com.google.android.gms.ads.nonagon.signalgeneration;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzbs implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzbu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbs(zzbu zzbuVar, String str, int i) {
        this.$r8$classId = i;
        this.zza = zzbuVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.zza.zzb.zzb.evaluateJavascript(this.zzb, null);
                break;
            default:
                this.zza.zzb.zzb.evaluateJavascript(this.zzb, null);
                break;
        }
    }
}
