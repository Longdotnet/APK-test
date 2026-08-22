package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzye extends zzyp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzyi zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;

    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a9  */
    public zzye(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, boolean z, zzfvq zzfvqVar, int i4) {
        int i5;
        int iZzc;
        byte b;
        boolean z2;
        int iZzc2;
        boolean z3;
        super(i, zzbmVar, i2);
        this.zzh = zzyiVar;
        int i6 = 1;
        int i7 = true != zzyiVar.zzP ? 16 : 24;
        this.zzg = zzyu.zzh(this.zzd.zzd);
        this.zzi = zzmb.zza(i3, false);
        int i8 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i8 >= zzyiVar.zzp.size()) {
                iZzc = 0;
                i8 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc = zzyu.zzc(this.zzd, (String) zzyiVar.zzp.get(i8), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.zzk = i8;
        this.zzj = iZzc;
        this.zzl = zzyu.zzb(this.zzd.zzf, 0);
        zzz zzzVar = this.zzd;
        int i9 = zzzVar.zzf;
        this.zzm = i9 == 0 || (i9 & 1) != 0;
        this.zzp = 1 == (zzzVar.zze & 1);
        String str = zzzVar.zzo;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2123537834) {
                if (iHashCode != 187078297) {
                    if (iHashCode == 1504698186 && str.equals("audio/iamf")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("audio/ac4")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("audio/eac3-joc")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0 || b == 1 || b == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.zzw = z2;
        int i10 = zzzVar.zzG;
        this.zzq = i10;
        this.zzr = zzzVar.zzH;
        int i11 = zzzVar.zzj;
        this.zzs = i11;
        this.zzf = (i11 == -1 || i11 <= zzyiVar.zzs) && (i10 == -1 || i10 <= zzyiVar.zzr) && zzfvqVar.zza(zzzVar);
        String str2 = zzex.zza;
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().toLanguageTags().split(FETmZwrVHuasmL.adwDwMdGsxTkM, -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i12 = 0; i12 < strArrSplit.length; i12++) {
            strArrSplit[i12] = zzex.zzE(strArrSplit[i12]);
        }
        int i13 = 0;
        while (true) {
            if (i13 >= strArrSplit.length) {
                iZzc2 = 0;
                i13 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc2 = zzyu.zzc(this.zzd, strArrSplit[i13], false);
                if (iZzc2 > 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        this.zzn = i13;
        this.zzo = iZzc2;
        for (int i14 = 0; i14 < zzyiVar.zzt.size(); i14++) {
            String str3 = this.zzd.zzo;
            if (str3 != null && str3.equals(zzyiVar.zzt.get(i14))) {
                i5 = i14;
                break;
            }
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzyi zzyiVar2 = this.zzh;
        if (zzmb.zza(i3, zzyiVar2.zzR) && ((z3 = this.zzf) || zzyiVar2.zzK)) {
            int i15 = zzyiVar2.zzu.zzb;
            if (zzmb.zza(i3, false) && z3 && this.zzd.zzj != -1 && ((zzyiVar2.zzT || !z) && (i3 & i7) != 0)) {
                i6 = 2;
            }
        } else {
            i6 = 0;
        }
        this.zze = i6;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzye zzyeVar) {
        boolean z = this.zzf;
        zzgab zzgabVarZza = (z && this.zzi) ? zzyu.zzc : zzyu.zzc.zza();
        zzfyf zzfyfVarZzc = zzfyf.zzj().zzd(this.zzi, zzyeVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzyeVar.zzk), zzgab.zzc().zza()).zzb(this.zzj, zzyeVar.zzj).zzb(this.zzl, zzyeVar.zzl).zzd(this.zzp, zzyeVar.zzp).zzd(this.zzm, zzyeVar.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzyeVar.zzn), zzgab.zzc().zza()).zzb(this.zzo, zzyeVar.zzo).zzd(z, zzyeVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzyeVar.zzt), zzgab.zzc().zza());
        boolean z2 = this.zzh.zzB;
        zzfyf zzfyfVarZzc2 = zzfyfVarZzc.zzd(this.zzu, zzyeVar.zzu).zzd(this.zzv, zzyeVar.zzv).zzd(this.zzw, zzyeVar.zzw).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzyeVar.zzq), zzgabVarZza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzyeVar.zzr), zzgabVarZza);
        if (Objects.equals(this.zzg, zzyeVar.zzg)) {
            zzfyfVarZzc2 = zzfyfVarZzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzyeVar.zzs), zzgabVarZza);
        }
        return zzfyfVarZzc2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        String str;
        int i;
        zzye zzyeVar = (zzye) zzypVar;
        boolean z = this.zzh.zzN;
        zzz zzzVar = this.zzd;
        int i2 = zzzVar.zzG;
        if (i2 == -1) {
            return false;
        }
        zzz zzzVar2 = zzyeVar.zzd;
        return i2 == zzzVar2.zzG && (str = zzzVar.zzo) != null && TextUtils.equals(str, zzzVar2.zzo) && (i = zzzVar.zzH) != -1 && i == zzzVar2.zzH && this.zzu == zzyeVar.zzu && this.zzv == zzyeVar.zzv;
    }
}
