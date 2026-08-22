package com.google.android.gms.internal.games_v2;

/* JADX INFO: loaded from: classes.dex */
final class zzha extends zzfy {
    private final zzhd zza;

    public zzha(zzhd zzhdVar, int i) {
        super(zzhdVar.size(), i);
        this.zza = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzfy
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
