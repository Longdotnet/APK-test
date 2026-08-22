package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaj extends zzah {
    private final zzal zza;

    public zzaj(zzal zzalVar, int i) {
        super(zzalVar.size(), i);
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzah
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
