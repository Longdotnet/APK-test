package com.google.android.gms.internal.ads;

import android.text.Layout;

/* JADX INFO: loaded from: classes.dex */
final class zzalw {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private float zzk;
    private String zzl;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private zzalp zzr;
    private String zzt;
    private String zzu;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private int zzm = -1;
    private int zzn = -1;
    private int zzq = -1;
    private float zzs = Float.MAX_VALUE;

    public final zzalw zzA(float f) {
        this.zzs = f;
        return this;
    }

    public final zzalw zzB(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }

    public final zzalw zzC(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzalw zzD(zzalp zzalpVar) {
        this.zzr = zzalpVar;
        return this;
    }

    public final zzalw zzE(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final String zzF() {
        return this.zzu;
    }

    public final String zzG() {
        return this.zza;
    }

    public final String zzH() {
        return this.zzl;
    }

    public final String zzI() {
        return this.zzt;
    }

    public final boolean zzJ() {
        return this.zzq == 1;
    }

    public final boolean zzK() {
        return this.zze;
    }

    public final boolean zzL() {
        return this.zzc;
    }

    public final boolean zzM() {
        return this.zzf == 1;
    }

    public final boolean zzN() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.zzi == 1 ? 2 : 0);
    }

    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    public final zzalp zzk() {
        return this.zzr;
    }

    public final zzalw zzl(zzalw zzalwVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzalwVar != null) {
            if (!this.zzc && zzalwVar.zzc) {
                zzp(zzalwVar.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzalwVar.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzalwVar.zzi;
            }
            if (this.zza == null && (str = zzalwVar.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzalwVar.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzalwVar.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzalwVar.zzn;
            }
            if (this.zzo == null && (alignment2 = zzalwVar.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzalwVar.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzalwVar.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzalwVar.zzj;
                this.zzk = zzalwVar.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzalwVar.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzalwVar.zzs;
            }
            if (this.zzt == null) {
                this.zzt = zzalwVar.zzt;
            }
            if (this.zzu == null) {
                this.zzu = zzalwVar.zzu;
            }
            if (!this.zze && zzalwVar.zze) {
                zzm(zzalwVar.zzd);
            }
            if (this.zzm == -1 && (i = zzalwVar.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzalw zzm(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final zzalw zzn(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzalw zzo(String str) {
        this.zzu = str;
        return this;
    }

    public final zzalw zzp(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final zzalw zzq(String str) {
        this.zza = str;
        return this;
    }

    public final zzalw zzr(float f) {
        this.zzk = f;
        return this;
    }

    public final zzalw zzs(int i) {
        this.zzj = i;
        return this;
    }

    public final zzalw zzt(String str) {
        this.zzl = str;
        return this;
    }

    public final zzalw zzu(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final zzalw zzv(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final zzalw zzw(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzalw zzx(String str) {
        this.zzt = str;
        return this;
    }

    public final zzalw zzy(int i) {
        this.zzn = i;
        return this;
    }

    public final zzalw zzz(int i) {
        this.zzm = i;
        return this;
    }
}
