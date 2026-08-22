package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzad extends zzh {
    final CharSequence zzb;
    final zzn zzc;
    int zzd = 0;
    int zze = Integer.MAX_VALUE;

    public zzad(zzaf zzafVar, CharSequence charSequence) {
        this.zzc = zzafVar.zza;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzh
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i2);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zzd = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzd = iZzc;
            }
            if (iZzc != i) {
                if (i < iZzd) {
                    this.zzb.charAt(i);
                }
                if (i < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                int i3 = this.zze;
                if (i3 == 1) {
                    iZzd = this.zzb.length();
                    this.zzd = -1;
                    if (iZzd > i) {
                        this.zzb.charAt(iZzd - 1);
                    }
                } else {
                    this.zze = i3 - 1;
                }
                return this.zzb.subSequence(i, iZzd).toString();
            }
            int i4 = iZzc + 1;
            this.zzd = i4;
            if (i4 > this.zzb.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
