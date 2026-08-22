package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzhaw implements zzhbl {
    private final zzhas zza;
    private final zzhbx zzb;
    private final boolean zzc;
    private final zzgys zzd;

    private zzhaw(zzhbx zzhbxVar, zzgys zzgysVar, zzhas zzhasVar) {
        this.zzb = zzhbxVar;
        this.zzc = zzhasVar instanceof zzgzd;
        this.zzd = zzgysVar;
        this.zza = zzhasVar;
    }

    public static zzhaw zzc(zzhbx zzhbxVar, zzgys zzgysVar, zzhas zzhasVar) {
        return new zzhaw(zzhbxVar, zzgysVar, zzhasVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zza(Object obj) {
        int iZzb = ((zzgzh) obj).zzt.zzb();
        return this.zzc ? iZzb + ((zzgzd) obj).zza.zzd() : iZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zzb(Object obj) {
        int iHashCode = ((zzgzh) obj).zzt.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzgzd) obj).zza.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final Object zze() {
        zzhas zzhasVar = this.zza;
        return zzhasVar instanceof zzgzh ? ((zzgzh) zzhasVar).zzbj() : zzhasVar.zzcY().zzbs();
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzg(Object obj, Object obj2) {
        zzhbn.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhbn.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzh(Object obj, zzhbf zzhbfVar, zzgyr zzgyrVar) {
        this.zzb.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxn zzgxnVar) {
        zzgzh zzgzhVar = (zzgzh) obj;
        if (zzgzhVar.zzt == zzhby.zzc()) {
            zzgzhVar.zzt = zzhby.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzj(Object obj, zzhcm zzhcmVar) {
        Iterator itZzf = ((zzgzd) obj).zza.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzgyv zzgyvVar = (zzgyv) entry.getKey();
            if (zzgyvVar.zzc() != zzhcl.MESSAGE || zzgyvVar.zze() || zzgyvVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgzz) {
                zzhcmVar.zzw(zzgyvVar.zza(), ((zzgzz) entry).zza().zzb());
            } else {
                zzhcmVar.zzw(zzgyvVar.zza(), entry.getValue());
            }
        }
        ((zzgzh) obj).zzt.zzk(zzhcmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzgzh) obj).zzt.equals(((zzgzh) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgzd) obj).zza.equals(((zzgzd) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzl(Object obj) {
        return ((zzgzd) obj).zza.zzi();
    }
}
