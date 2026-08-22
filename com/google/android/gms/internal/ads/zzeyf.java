package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeyf implements zzeln {
    final /* synthetic */ zzeyg zza;

    public zzeyf(zzeyg zzeygVar) {
        Objects.requireNonNull(zzeygVar);
        this.zza = zzeygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzeyg zzeygVar = this.zza;
        synchronized (zzeygVar) {
            zzeygVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcom zzcomVar = (zzcom) obj;
        zzeyg zzeygVar = this.zza;
        synchronized (zzeygVar) {
            try {
                zzcom zzcomVar2 = zzeygVar.zza;
                if (zzcomVar2 != null) {
                    zzcomVar2.zzb();
                }
                zzeygVar.zza = zzcomVar;
                zzcomVar.zzc(zzeygVar);
                zzeygVar.zzg.zzk(new zzcon(zzcomVar, zzeygVar, zzeygVar.zzg, zzeygVar.zzi));
                zzcomVar.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
