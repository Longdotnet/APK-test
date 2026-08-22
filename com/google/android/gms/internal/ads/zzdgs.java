package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgs implements zzcvy, zzddi {
    private final zzbyk zza;
    private final Context zzb;
    private final zzbyo zzc;
    private final View zzd;
    private String zze;
    private final zzbcj.zza.EnumC0001zza zzf;

    public zzdgs(zzbyk zzbykVar, Context context, zzbyo zzbyoVar, View view, zzbcj.zza.EnumC0001zza enumC0001zza) {
        this.zza = zzbykVar;
        this.zzb = context;
        this.zzc = zzbyoVar;
        this.zzd = view;
        this.zzf = enumC0001zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        this.zza.zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(zzbwc zzbwcVar, String str, String str2) {
        zzbyo zzbyoVar = this.zzc;
        Context context = this.zzb;
        if (zzbyoVar.zzp(context)) {
            try {
                zzbyoVar.zzl(context, zzbyoVar.zzb(context), this.zza.zza(), zzbwcVar.zzc(), zzbwcVar.zzb());
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzj() {
        zzbcj.zza.EnumC0001zza enumC0001zza = this.zzf;
        if (enumC0001zza == zzbcj.zza.EnumC0001zza.APP_OPEN) {
            return;
        }
        String strZzd = this.zzc.zzd(this.zzb);
        this.zze = strZzd;
        this.zze = String.valueOf(strZzd).concat(enumC0001zza == zzbcj.zza.EnumC0001zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }
}
