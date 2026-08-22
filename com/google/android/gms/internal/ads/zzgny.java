package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzgny {
    private static final zzgny zza = (zzgny) zzgpi.zza(new zzgph() { // from class: com.google.android.gms.internal.ads.zzgnw
        @Override // com.google.android.gms.internal.ads.zzgph
        public final Object zza() {
            zzgny zzgnyVar = new zzgny();
            zzgnyVar.zzg(new zzgmu(zzgnd.class, zzgox.class, new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgnx
                @Override // com.google.android.gms.internal.ads.zzgmv
                public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                    return ((zzgnd) zzgezVar).zzb(zzgfnVar);
                }
            }));
            return zzgnyVar;
        }
    });
    private final AtomicReference zzb = new AtomicReference(new zzgpg(new zzgpc(), null));

    public static zzgny zzc() {
        return zza;
    }

    public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
        return ((zzgpg) this.zzb.get()).zza(zzgpbVar, zzgfnVar);
    }

    public final zzgfm zzb(zzgpb zzgpbVar) {
        return ((zzgpg) this.zzb.get()).zzb(zzgpbVar);
    }

    public final zzgpb zzd(zzgez zzgezVar, Class cls, zzgfn zzgfnVar) {
        return ((zzgpg) this.zzb.get()).zzc(zzgezVar, cls, zzgfnVar);
    }

    public final zzgpb zze(zzgfm zzgfmVar, Class cls) {
        return ((zzgpg) this.zzb.get()).zzd(zzgfmVar, cls);
    }

    public final synchronized void zzf(zzgmt zzgmtVar) {
        AtomicReference atomicReference = this.zzb;
        zzgpc zzgpcVar = new zzgpc((zzgpg) atomicReference.get());
        zzgpcVar.zza(zzgmtVar);
        atomicReference.set(new zzgpg(zzgpcVar, null));
    }

    public final synchronized void zzg(zzgmx zzgmxVar) {
        AtomicReference atomicReference = this.zzb;
        zzgpc zzgpcVar = new zzgpc((zzgpg) atomicReference.get());
        zzgpcVar.zzb(zzgmxVar);
        atomicReference.set(new zzgpg(zzgpcVar, null));
    }

    public final synchronized void zzh(zzgod zzgodVar) {
        AtomicReference atomicReference = this.zzb;
        zzgpc zzgpcVar = new zzgpc((zzgpg) atomicReference.get());
        zzgpcVar.zzc(zzgodVar);
        atomicReference.set(new zzgpg(zzgpcVar, null));
    }

    public final synchronized void zzi(zzgoh zzgohVar) {
        AtomicReference atomicReference = this.zzb;
        zzgpc zzgpcVar = new zzgpc((zzgpg) atomicReference.get());
        zzgpcVar.zzd(zzgohVar);
        atomicReference.set(new zzgpg(zzgpcVar, null));
    }

    public final boolean zzj(zzgpb zzgpbVar) {
        return ((zzgpg) this.zzb.get()).zzi(zzgpbVar);
    }

    public final boolean zzk(zzgpb zzgpbVar) {
        return ((zzgpg) this.zzb.get()).zzj(zzgpbVar);
    }
}
