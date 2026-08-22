package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.EOFException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzuj implements zzwa {
    private final zzaea zza;
    private zzadv zzb;
    private zzadw zzc;

    public zzuj(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final int zza(zzaer zzaerVar) {
        zzadv zzadvVar = this.zzb;
        zzadvVar.getClass();
        zzadw zzadwVar = this.zzc;
        zzadwVar.getClass();
        return zzadvVar.zzb(zzadwVar, zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final long zzb() {
        zzadw zzadwVar = this.zzc;
        if (zzadwVar != null) {
            return zzadwVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zzc() {
        zzadv zzadvVar = this.zzb;
        if (zzadvVar != null && (zzadvVar instanceof zzaie)) {
            ((zzaie) zzadvVar).zza();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zzd(zzl zzlVar, Uri uri, Map map, long j, long j2, zzady zzadyVar) throws zzxl {
        zzadl zzadlVar = new zzadl(zzlVar, j, j2);
        this.zzc = zzadlVar;
        if (this.zzb != null) {
            return;
        }
        zzadv[] zzadvVarArrZza = this.zza.zza(uri, map);
        int length = zzadvVarArrZza.length;
        zzfyn zzfynVarZzi = zzfyq.zzi(length);
        boolean z = true;
        if (length == 1) {
            this.zzb = zzadvVarArrZza[0];
        } else {
            for (zzadv zzadvVar : zzadvVarArrZza) {
                try {
                    if (zzadvVar.zzi(zzadlVar)) {
                        this.zzb = zzadvVar;
                        zzdd.zzf(true);
                        zzadlVar.zzj();
                        break;
                    } else {
                        zzfynVarZzi.zzh(zzadvVar.zzd());
                        boolean z2 = this.zzb != null || zzadlVar.zzf() == j;
                        zzdd.zzf(z2);
                        zzadlVar.zzj();
                    }
                } catch (EOFException unused) {
                    if (this.zzb != null || zzadlVar.zzf() == j) {
                    }
                } catch (Throwable th) {
                    if (this.zzb == null && zzadlVar.zzf() != j) {
                        z = false;
                    }
                    zzdd.zzf(z);
                    zzadlVar.zzj();
                    throw th;
                }
                zzdd.zzf(z2);
                zzadlVar.zzj();
            }
            if (this.zzb == null) {
                Iterator it = zzfzg.zzc(zzfyq.zzm(zzadvVarArrZza), new zzfve() { // from class: com.google.android.gms.internal.ads.zzui
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        zzadv zzadvVar2 = (zzadv) obj;
                        zzadvVar2.zzc();
                        return zzadvVar2.getClass().getSimpleName();
                    }
                }).iterator();
                StringBuilder sb = new StringBuilder();
                zzfvh.zzc(sb, it, ", ");
                throw new zzxl(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("None of the available extractors (", sb.toString(), ") could read the stream."), uri, zzfynVarZzi.zzi());
            }
        }
        this.zzb.zze(zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zzf(long j, long j2) {
        zzadv zzadvVar = this.zzb;
        zzadvVar.getClass();
        zzadvVar.zzf(j, j2);
    }
}
