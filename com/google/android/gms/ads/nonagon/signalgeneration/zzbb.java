package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhgz;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb implements zzhgr {
    public final /* synthetic */ int $r8$classId;
    public final zzaz zza;

    public /* synthetic */ zzbb(zzaz zzazVar, int i) {
        this.$r8$classId = i;
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        switch (this.$r8$classId) {
            case 0:
                String lowerCase = this.zza.zza.toLowerCase(Locale.ROOT);
                zzhgz.zzb(lowerCase);
                return lowerCase;
            case 1:
                zzaz zzazVar = this.zza;
                zzazVar.getClass();
                HashSet hashSet = new HashSet();
                hashSet.add(zzazVar.zza.toLowerCase(Locale.ROOT));
                return hashSet;
            case 2:
                return this.zza.zzb;
            default:
                return this.zza.zzc;
        }
    }
}
