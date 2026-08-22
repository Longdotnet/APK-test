package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgyn implements zzhcm {
    private final zzgym zza;

    private zzgyn(zzgym zzgymVar) {
        zzgzu.zzc(zzgymVar, "output");
        this.zza = zzgymVar;
        zzgymVar.zze = this;
    }

    public static zzgyn zza(zzgym zzgymVar) {
        zzgyn zzgynVar = zzgymVar.zze;
        return zzgynVar != null ? zzgynVar : new zzgyn(zzgymVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzA(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzj(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            zzhahVar.zza(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzk(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzB(int i, int i2) {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzC(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgym zzgymVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzgymVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar2 = this.zza;
            zzgymVar2.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzD += zzgym.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzgymVar2.zzu(iZzD);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzgymVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                zzgym zzgymVar3 = this.zza;
                int iZzd = zzgziVar.zzd(i2);
                zzgymVar3.zzt(i, (iZzd >> 31) ^ (iZzd + iZzd));
                i2++;
            }
            return;
        }
        zzgym zzgymVar4 = this.zza;
        zzgymVar4.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgziVar.size(); i4++) {
            int iZzd2 = zzgziVar.zzd(i4);
            iZzD2 += zzgym.zzD((iZzd2 >> 31) ^ (iZzd2 + iZzd2));
        }
        zzgymVar4.zzu(iZzD2);
        while (i2 < zzgziVar.size()) {
            int iZzd3 = zzgziVar.zzd(i2);
            zzgymVar4.zzu((iZzd3 >> 31) ^ (iZzd3 + iZzd3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzD(int i, long j) {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzE(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgym zzgymVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzgymVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar2 = this.zza;
            zzgymVar2.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzE += zzgym.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzgymVar2.zzu(iZzE);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzgymVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                zzgym zzgymVar3 = this.zza;
                long jZza = zzhahVar.zza(i2);
                zzgymVar3.zzv(i, (jZza >> 63) ^ (jZza + jZza));
                i2++;
            }
            return;
        }
        zzgym zzgymVar4 = this.zza;
        zzgymVar4.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzhahVar.size(); i4++) {
            long jZza2 = zzhahVar.zza(i4);
            iZzE2 += zzgym.zzE((jZza2 >> 63) ^ (jZza2 + jZza2));
        }
        zzgymVar4.zzu(iZzE2);
        while (i2 < zzhahVar.size()) {
            long jZza3 = zzhahVar.zza(i2);
            zzgymVar4.zzw((jZza3 >> 63) ^ (jZza3 + jZza3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    @Deprecated
    public final void zzF(int i) {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzG(int i, String str) {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzH(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzhae)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzhae zzhaeVar = (zzhae) list;
        while (i2 < list.size()) {
            Object objZzc = zzhaeVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzq(i, (String) objZzc);
            } else {
                this.zza.zzN(i, (zzgxz) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzI(int i, int i2) {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzgym.zzD(((Integer) list.get(i3)).intValue());
            }
            zzgymVar.zzu(iZzD);
            while (i2 < list.size()) {
                zzgymVar.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzt(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgziVar.size(); i4++) {
            iZzD2 += zzgym.zzD(zzgziVar.zzd(i4));
        }
        zzgymVar2.zzu(iZzD2);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzu(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzK(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzL(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgym.zzE(((Long) list.get(i3)).longValue());
            }
            zzgymVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgymVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzv(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzhahVar.size(); i4++) {
            iZzE2 += zzgym.zzE(zzhahVar.zza(i4));
        }
        zzgymVar2.zzu(iZzE2);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzw(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzb(int i, boolean z) {
        this.zza.zzM(i, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzc(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzM(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).getClass();
                i3++;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzL(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzgxp zzgxpVar = (zzgxp) list;
        if (!z) {
            while (i2 < zzgxpVar.size()) {
                this.zza.zzM(i, zzgxpVar.zzh(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxpVar.size(); i6++) {
            zzgxpVar.zzh(i6);
            i5++;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgxpVar.size()) {
            zzgymVar2.zzL(zzgxpVar.zzh(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzd(int i, zzgxz zzgxzVar) {
        this.zza.zzN(i, zzgxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzN(i, (zzgxz) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzf(int i, double d) {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzg(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).getClass();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzgyo zzgyoVar = (zzgyo) list;
        if (!z) {
            while (i2 < zzgyoVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgyoVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyoVar.size(); i6++) {
            zzgyoVar.zzd(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgyoVar.size()) {
            zzgymVar2.zzk(Double.doubleToRawLongBits(zzgyoVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    @Deprecated
    public final void zzh(int i) {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzi(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzj(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgym.zzE(((Integer) list.get(i3)).intValue());
            }
            zzgymVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgymVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzl(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgziVar.size(); i4++) {
            iZzE2 += zzgym.zzE(zzgziVar.zzd(i4));
        }
        zzgymVar2.zzu(iZzE2);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzm(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzk(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzl(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzh(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            zzgziVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzi(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzm(int i, long j) {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzn(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzj(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            zzhahVar.zza(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzk(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzo(int i, float f) {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzp(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgyyVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyyVar.size(); i6++) {
            zzgyyVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgyyVar.size()) {
            zzgymVar2.zzi(Float.floatToRawIntBits(zzgyyVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzq(int i, Object obj, zzhbl zzhblVar) {
        zzgym zzgymVar = this.zza;
        zzgymVar.zzs(i, 3);
        zzhblVar.zzj((zzhas) obj, zzgymVar.zze);
        zzgymVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzr(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzs(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgym.zzE(((Integer) list.get(i3)).intValue());
            }
            zzgymVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgymVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzl(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgziVar.size(); i4++) {
            iZzE2 += zzgym.zzE(zzgziVar.zzd(i4));
        }
        zzgymVar2.zzu(iZzE2);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzm(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzt(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzu(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgym.zzE(((Long) list.get(i3)).longValue());
            }
            zzgymVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgymVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzv(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzhahVar.size(); i4++) {
            iZzE2 += zzgym.zzE(zzhahVar.zza(i4));
        }
        zzgymVar2.zzu(iZzE2);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzw(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzv(int i, Object obj, zzhbl zzhblVar) {
        this.zza.zzn(i, (zzhas) obj, zzhblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzw(int i, Object obj) {
        if (obj instanceof zzgxz) {
            this.zza.zzp(i, (zzgxz) obj);
        } else {
            this.zza.zzo(i, (zzhas) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzx(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzh(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            zzgziVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzi(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzz(int i, long j) {
        this.zza.zzj(i, j);
    }
}
