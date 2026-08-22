package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcj extends zzgc {
    public zzcj() {
        super(zzjw.class, new zzch(zzap.class));
    }

    public static /* bridge */ /* synthetic */ zzga zzg(int i, int i2, int i3, int i4, int i5, int i6) {
        zzke zzkeVarZzb = zzkf.zzb();
        zzkh zzkhVarZzb = zzki.zzb();
        zzkhVarZzb.zza(16);
        zzkeVarZzb.zzb((zzki) zzkhVarZzb.zzi());
        zzkeVarZzb.zza(i);
        zzkf zzkfVar = (zzkf) zzkeVarZzb.zzi();
        zzmv zzmvVarZzb = zzmw.zzb();
        zzmy zzmyVarZzb = zzmz.zzb();
        zzmyVarZzb.zzb(5);
        zzmyVarZzb.zza(i4);
        zzmvVarZzb.zzb((zzmz) zzmyVarZzb.zzi());
        zzmvVarZzb.zza(32);
        zzmw zzmwVar = (zzmw) zzmvVarZzb.zzi();
        zzjy zzjyVarZza = zzjz.zza();
        zzjyVarZza.zza(zzkfVar);
        zzjyVarZza.zzb(zzmwVar);
        return new zzga((zzjz) zzjyVarZza.zzi(), i6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zzgb zza() {
        return new zzci(this, zzjz.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final zznr zzb() {
        return zznr.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* synthetic */ zzaek zzc(zzacc zzaccVar) {
        return zzjw.zzd(zzaccVar, zzacs.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final /* bridge */ /* synthetic */ void zze(zzaek zzaekVar) throws GeneralSecurityException {
        zzjw zzjwVar = (zzjw) zzaekVar;
        zzqs.zzc(zzjwVar.zza(), 0);
        new zzcm();
        zzcm.zzh(zzjwVar.zze());
        new zzih();
        zzih.zzh(zzjwVar.zzf());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgc
    public final int zzf() {
        return 2;
    }
}
