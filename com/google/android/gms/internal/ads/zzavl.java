package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzavl implements Runnable {
    final /* synthetic */ zzavm zza;

    public zzavl(zzavm zzavmVar) {
        this.zza = zzavmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzavm zzavmVar = this.zza;
        synchronized (zzavmVar.zzo) {
            if (zzavmVar.zzp) {
                return;
            }
            zzavmVar.zzp = true;
            try {
                zzavm.zzj(zzavmVar);
            } catch (Exception e) {
                this.zza.zzh.zzc(2023, -1L, e);
            }
            zzavm zzavmVar2 = this.zza;
            synchronized (zzavmVar2.zzo) {
                zzavmVar2.zzp = false;
            }
        }
    }
}
