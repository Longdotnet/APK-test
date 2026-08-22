package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzar {
    private CharSequence zza;
    private CharSequence zzb;
    private CharSequence zzc;
    private CharSequence zzd;
    private CharSequence zze;
    private byte[] zzf;
    private Integer zzg;
    private Integer zzh;
    private Integer zzi;
    private Integer zzj;
    private Boolean zzk;
    private Integer zzl;
    private Integer zzm;
    private Integer zzn;
    private Integer zzo;
    private Integer zzp;
    private Integer zzq;
    private CharSequence zzr;
    private CharSequence zzs;
    private CharSequence zzt;
    private Integer zzu;
    private Integer zzv;
    private CharSequence zzw;
    private CharSequence zzx;
    private Integer zzy;
    private zzfyq zzz;

    public /* synthetic */ zzar(zzat zzatVar, zzas zzasVar) {
        this.zza = zzatVar.zzb;
        this.zzb = zzatVar.zzc;
        this.zzc = zzatVar.zzd;
        this.zzd = zzatVar.zze;
        this.zze = zzatVar.zzf;
        this.zzf = zzatVar.zzg;
        this.zzg = zzatVar.zzh;
        this.zzh = zzatVar.zzi;
        this.zzi = zzatVar.zzj;
        this.zzj = zzatVar.zzk;
        this.zzk = zzatVar.zzl;
        this.zzl = zzatVar.zzn;
        this.zzm = zzatVar.zzo;
        this.zzn = zzatVar.zzp;
        this.zzo = zzatVar.zzq;
        this.zzp = zzatVar.zzr;
        this.zzq = zzatVar.zzs;
        this.zzr = zzatVar.zzt;
        this.zzs = zzatVar.zzu;
        this.zzt = zzatVar.zzv;
        this.zzu = zzatVar.zzw;
        this.zzv = zzatVar.zzx;
        this.zzw = zzatVar.zzy;
        this.zzx = zzatVar.zzz;
        this.zzy = zzatVar.zzA;
        this.zzz = zzatVar.zzB;
    }

    public final zzar zza(byte[] bArr, int i) {
        if (this.zzf == null || i == 3 || !Objects.equals(this.zzg, 3)) {
            this.zzf = (byte[]) bArr.clone();
            this.zzg = Integer.valueOf(i);
        }
        return this;
    }

    public final zzar zzb(zzat zzatVar) {
        if (zzatVar != null) {
            CharSequence charSequence = zzatVar.zzb;
            if (charSequence != null) {
                this.zza = charSequence;
            }
            CharSequence charSequence2 = zzatVar.zzc;
            if (charSequence2 != null) {
                this.zzb = charSequence2;
            }
            CharSequence charSequence3 = zzatVar.zzd;
            if (charSequence3 != null) {
                this.zzc = charSequence3;
            }
            CharSequence charSequence4 = zzatVar.zze;
            if (charSequence4 != null) {
                this.zzd = charSequence4;
            }
            CharSequence charSequence5 = zzatVar.zzf;
            if (charSequence5 != null) {
                this.zze = charSequence5;
            }
            byte[] bArr = zzatVar.zzg;
            if (bArr != null) {
                Integer num = zzatVar.zzh;
                this.zzf = (byte[]) bArr.clone();
                this.zzg = num;
            }
            Integer num2 = zzatVar.zzi;
            if (num2 != null) {
                this.zzh = num2;
            }
            Integer num3 = zzatVar.zzj;
            if (num3 != null) {
                this.zzi = num3;
            }
            Integer num4 = zzatVar.zzk;
            if (num4 != null) {
                this.zzj = num4;
            }
            Boolean bool = zzatVar.zzl;
            if (bool != null) {
                this.zzk = bool;
            }
            Integer num5 = zzatVar.zzm;
            if (num5 != null) {
                this.zzl = num5;
            }
            Integer num6 = zzatVar.zzn;
            if (num6 != null) {
                this.zzl = num6;
            }
            Integer num7 = zzatVar.zzo;
            if (num7 != null) {
                this.zzm = num7;
            }
            Integer num8 = zzatVar.zzp;
            if (num8 != null) {
                this.zzn = num8;
            }
            Integer num9 = zzatVar.zzq;
            if (num9 != null) {
                this.zzo = num9;
            }
            Integer num10 = zzatVar.zzr;
            if (num10 != null) {
                this.zzp = num10;
            }
            Integer num11 = zzatVar.zzs;
            if (num11 != null) {
                this.zzq = num11;
            }
            CharSequence charSequence6 = zzatVar.zzt;
            if (charSequence6 != null) {
                this.zzr = charSequence6;
            }
            CharSequence charSequence7 = zzatVar.zzu;
            if (charSequence7 != null) {
                this.zzs = charSequence7;
            }
            CharSequence charSequence8 = zzatVar.zzv;
            if (charSequence8 != null) {
                this.zzt = charSequence8;
            }
            Integer num12 = zzatVar.zzw;
            if (num12 != null) {
                this.zzu = num12;
            }
            Integer num13 = zzatVar.zzx;
            if (num13 != null) {
                this.zzv = num13;
            }
            CharSequence charSequence9 = zzatVar.zzy;
            if (charSequence9 != null) {
                this.zzw = charSequence9;
            }
            CharSequence charSequence10 = zzatVar.zzz;
            if (charSequence10 != null) {
                this.zzx = charSequence10;
            }
            Integer num14 = zzatVar.zzA;
            if (num14 != null) {
                this.zzy = num14;
            }
            zzfyq zzfyqVar = zzatVar.zzB;
            if (!zzfyqVar.isEmpty()) {
                this.zzz = zzfyq.zzl(zzfyqVar);
            }
        }
        return this;
    }

    public final zzar zzc(CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzar zzd(CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzar zze(CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzar zzf(CharSequence charSequence) {
        this.zzs = charSequence;
        return this;
    }

    public final zzar zzg(CharSequence charSequence) {
        this.zzt = charSequence;
        return this;
    }

    public final zzar zzh(CharSequence charSequence) {
        this.zze = charSequence;
        return this;
    }

    public final zzar zzi(Integer num) {
        this.zzu = num;
        return this;
    }

    public final zzar zzj(CharSequence charSequence) {
        this.zzw = charSequence;
        return this;
    }

    public final zzar zzk(Integer num) {
        this.zzn = num;
        return this;
    }

    public final zzar zzl(Integer num) {
        this.zzm = num;
        return this;
    }

    public final zzar zzm(Integer num) {
        this.zzl = num;
        return this;
    }

    public final zzar zzn(Integer num) {
        this.zzq = num;
        return this;
    }

    public final zzar zzo(Integer num) {
        this.zzp = num;
        return this;
    }

    public final zzar zzp(Integer num) {
        this.zzo = num;
        return this;
    }

    public final zzar zzq(CharSequence charSequence) {
        this.zzx = charSequence;
        return this;
    }

    public final zzar zzr(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzar zzs(Integer num) {
        this.zzv = num;
        return this;
    }

    public final zzar zzt(Integer num) {
        this.zzi = num;
        return this;
    }

    public final zzar zzu(Integer num) {
        this.zzh = num;
        return this;
    }

    public final zzar zzv(CharSequence charSequence) {
        this.zzr = charSequence;
        return this;
    }

    public final zzat zzw() {
        return new zzat(this);
    }

    public zzar() {
        this.zzz = zzfyq.zzn();
    }
}
