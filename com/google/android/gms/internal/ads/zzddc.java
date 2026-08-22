package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzddc extends zzdbt implements zzdde {
    public zzddc(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zza(String str) {
        final String str2 = "MalformedJson";
        zzq(new zzdbs(str2) { // from class: com.google.android.gms.internal.ads.zzdcw
            public final /* synthetic */ String zza = "MalformedJson";

            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zzb(final String str, final String str2) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdcz
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zzb(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zzc(final String str) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdcy
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zzc(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zzd(final String str) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdda
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zzd(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zze() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzddb
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdde
    public final void zzf() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdcx
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdde) obj).zzf();
            }
        });
    }
}
