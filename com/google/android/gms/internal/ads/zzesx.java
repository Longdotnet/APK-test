package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesx implements zzeub {
    private zzfsa zza;
    private zzfsa zzb;
    private boolean zzc;
    private boolean zzd;
    private final boolean zze = false;
    private final boolean zzf;

    public zzesx(zzfsa zzfsaVar, zzfsa zzfsaVar2, boolean z, boolean z2, boolean z3) {
        this.zza = zzfsaVar;
        this.zzb = zzfsaVar2;
        this.zzc = z;
        this.zzd = z2;
        this.zzf = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0042  */
    /* JADX WARN: Code duplicated, block: B:18:0x006c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:23:0x0088  */
    /* JADX WARN: Code duplicated, block: B:9:0x0026 A[DONT_INVERT] */
    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        if (this.zze) {
            return;
        }
        Bundle bundleZza = zzfdk.zza(bundle, "pii");
        boolean z = this.zzf;
        if (!z) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdo)).booleanValue()) {
                if (this.zza.zzc()) {
                    bundleZza.putString("paidv1_id_android", this.zza.zzb());
                    bundleZza.putLong("paidv1_creation_time_android", this.zza.zza());
                }
            } else if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdq)).booleanValue()) {
                    if (this.zza.zzc()) {
                        bundleZza.putString("paidv1_id_android", this.zza.zzb());
                        bundleZza.putLong("paidv1_creation_time_android", this.zza.zza());
                    }
                }
            }
        } else if (z) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdq)).booleanValue()) {
                if (this.zza.zzc()) {
                    bundleZza.putString("paidv1_id_android", this.zza.zzb());
                    bundleZza.putLong("paidv1_creation_time_android", this.zza.zza());
                }
            }
        }
        if (!z) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdp)).booleanValue()) {
                if (this.zzb.zzc()) {
                    bundleZza.putString("paidv2_id_android", this.zzb.zzb());
                    bundleZza.putLong("paidv2_creation_time_android", this.zzb.zza());
                }
                bundleZza.putBoolean("paidv2_pub_option_android", this.zzc);
                bundleZza.putBoolean("paidv2_user_option_android", this.zzd);
            } else if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdr)).booleanValue()) {
                    if (this.zzb.zzc()) {
                        bundleZza.putString("paidv2_id_android", this.zzb.zzb());
                        bundleZza.putLong("paidv2_creation_time_android", this.zzb.zza());
                    }
                    bundleZza.putBoolean("paidv2_pub_option_android", this.zzc);
                    bundleZza.putBoolean("paidv2_user_option_android", this.zzd);
                }
            }
        } else if (z) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdr)).booleanValue()) {
                if (this.zzb.zzc()) {
                    bundleZza.putString("paidv2_id_android", this.zzb.zzb());
                    bundleZza.putLong("paidv2_creation_time_android", this.zzb.zza());
                }
                bundleZza.putBoolean("paidv2_pub_option_android", this.zzc);
                bundleZza.putBoolean("paidv2_user_option_android", this.zzd);
            }
        }
        if (bundleZza.isEmpty()) {
            return;
        }
        bundle.putBundle("pii", bundleZza);
    }

    public zzesx(boolean z) {
        this.zzf = z;
    }
}
