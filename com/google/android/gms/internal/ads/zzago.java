package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzago implements zzady {
    private final long zzb;
    private final zzady zzc;

    public zzago(long j, zzady zzadyVar) {
        this.zzb = j;
        this.zzc = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzG() {
        this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzP(zzaeu zzaeuVar) {
        this.zzc.zzP(new zzagn(this, zzaeuVar, zzaeuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final zzafb zzw(int i, int i2) {
        return this.zzc.zzw(i, i2);
    }
}
