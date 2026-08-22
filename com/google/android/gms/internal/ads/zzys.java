package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzys extends zzyp {
    private final boolean zze;
    private final zzyi zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final boolean zzs;
    private final boolean zzt;
    private final int zzu;

    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    /* JADX WARN: Code duplicated, block: B:33:0x004d  */
    /* JADX WARN: Code duplicated, block: B:88:0x011a  */
    public zzys(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, String str, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        int iZzc;
        int i6;
        byte b;
        boolean z4;
        zzz zzzVar;
        int i7;
        int i8;
        int i9;
        zzz zzzVar2;
        int i10;
        int i11;
        int i12;
        super(i, zzbmVar, i2);
        this.zzf = zzyiVar;
        int i13 = 1;
        int i14 = true != zzyiVar.zzI ? 16 : 24;
        if (!z || (((i10 = (zzzVar2 = this.zzd).zzv) != -1 && i10 > zzyiVar.zza) || ((i11 = zzzVar2.zzw) != -1 && i11 > zzyiVar.zzb))) {
            z2 = false;
        } else {
            float f = zzzVar2.zzz;
            if ((f == -1.0f || f <= zzyiVar.zzc) && ((i12 = zzzVar2.zzj) == -1 || i12 <= zzyiVar.zzd)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.zze = z2;
        if (!z || (((i7 = (zzzVar = this.zzd).zzv) != -1 && i7 < 0) || ((i8 = zzzVar.zzw) != -1 && i8 < 0))) {
            z3 = false;
        } else {
            float f2 = zzzVar.zzz;
            if ((f2 == -1.0f || f2 >= 0.0f) && ((i9 = zzzVar.zzj) == -1 || i9 >= 0)) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        this.zzg = z3;
        this.zzh = zzmb.zza(i3, false);
        zzz zzzVar3 = this.zzd;
        float f3 = zzzVar3.zzz;
        this.zzi = f3 != -1.0f && f3 >= 10.0f;
        this.zzj = zzzVar3.zzj;
        this.zzk = zzzVar3.zza();
        int i15 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i15 >= zzyiVar.zzn.size()) {
                iZzc = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc = zzyu.zzc(this.zzd, (String) zzyiVar.zzn.get(i15), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzm = i15;
        this.zzn = iZzc;
        this.zzo = zzyu.zzb(this.zzd.zzf, 0);
        int i16 = this.zzd.zzf;
        this.zzp = i16 == 0 || (i16 & 1) != 0;
        this.zzq = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
        for (int i17 = 0; i17 < zzyiVar.zzm.size(); i17++) {
            String str2 = this.zzd.zzo;
            if (str2 != null && str2.equals(zzyiVar.zzm.get(i17))) {
                i5 = i17;
                break;
            }
        }
        this.zzl = i5;
        this.zzs = (i3 & 384) == 128;
        this.zzt = (i3 & 64) == 64;
        zzz zzzVar4 = this.zzd;
        String str3 = zzzVar4.zzo;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = 4;
            switch (str3) {
                case "video/dolby-vision":
                    b = 0;
                    break;
                case "video/av01":
                    b = 1;
                    break;
                case "video/hevc":
                    b = 2;
                    break;
                case "video/avc":
                    b = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i6 = 5;
            } else if (b != 1) {
                if (b == 2) {
                    i6 = 3;
                } else if (b == 3) {
                    i6 = 2;
                } else if (b != 4) {
                    i6 = 0;
                } else {
                    i6 = 1;
                }
            }
        }
        this.zzu = i6;
        if ((zzzVar4.zzf & 16384) != 0) {
            i13 = 0;
        } else {
            zzyi zzyiVar2 = this.zzf;
            if (!zzmb.zza(i3, zzyiVar2.zzR) || (!(z4 = this.zze) && !zzyiVar2.zzG)) {
                i13 = 0;
            } else if (zzmb.zza(i3, false) && this.zzg && z4 && zzzVar4.zzj != -1 && (i14 & i3) != 0) {
                i13 = 2;
            }
        }
        this.zzr = i13;
    }

    public static /* synthetic */ int zza(zzys zzysVar, zzys zzysVar2) {
        zzgab zzgabVarZza = (zzysVar.zze && zzysVar.zzh) ? zzyu.zzc : zzyu.zzc.zza();
        zzfyf zzfyfVarZzj = zzfyf.zzj();
        boolean z = zzysVar.zzf.zzB;
        return zzfyfVarZzj.zzc(Integer.valueOf(zzysVar.zzk), Integer.valueOf(zzysVar2.zzk), zzgabVarZza).zzc(Integer.valueOf(zzysVar.zzj), Integer.valueOf(zzysVar2.zzj), zzgabVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzys zzysVar, zzys zzysVar2) {
        zzfyf zzfyfVarZzc = zzfyf.zzj().zzd(zzysVar.zzh, zzysVar2.zzh).zzc(Integer.valueOf(zzysVar.zzm), Integer.valueOf(zzysVar2.zzm), zzgab.zzc().zza()).zzb(zzysVar.zzn, zzysVar2.zzn).zzb(zzysVar.zzo, zzysVar2.zzo).zzd(zzysVar.zzp, zzysVar2.zzp).zzb(zzysVar.zzq, zzysVar2.zzq).zzd(zzysVar.zzi, zzysVar2.zzi).zzd(zzysVar.zze, zzysVar2.zze).zzd(zzysVar.zzg, zzysVar2.zzg).zzc(Integer.valueOf(zzysVar.zzl), Integer.valueOf(zzysVar2.zzl), zzgab.zzc().zza());
        boolean z = zzysVar.zzs;
        zzfyf zzfyfVarZzd = zzfyfVarZzc.zzd(z, zzysVar2.zzs);
        boolean z2 = zzysVar.zzt;
        zzfyf zzfyfVarZzd2 = zzfyfVarZzd.zzd(z2, zzysVar2.zzt);
        if (z && z2) {
            zzfyfVarZzd2 = zzfyfVarZzd2.zzb(zzysVar.zzu, zzysVar2.zzu);
        }
        return zzfyfVarZzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        zzys zzysVar = (zzys) zzypVar;
        if (!Objects.equals(this.zzd.zzo, zzysVar.zzd.zzo)) {
            return false;
        }
        boolean z = this.zzf.zzJ;
        return this.zzs == zzysVar.zzs && this.zzt == zzysVar.zzt;
    }
}
