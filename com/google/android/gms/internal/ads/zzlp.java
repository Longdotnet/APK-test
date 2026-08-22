package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzlp implements zzlg {
    public final zzvc zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzlp(zzvj zzvjVar, boolean z) {
        this.zza = new zzvc(zzvjVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final zzbl zza() {
        return this.zza.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
