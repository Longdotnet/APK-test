package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwk extends zzdbt implements zzcwc {
    public zzcwk(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzc(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwj
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwo) obj).zzs(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzd() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwi
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwo) obj).zzs(zzfdx.zzd(11, null, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zze(final zzdgm zzdgmVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwh
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                zzcwo zzcwoVar = (zzcwo) obj;
                String message = zzdgmVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzcwoVar.zzs(zzfdx.zzd(12, message, null));
            }
        });
    }
}
