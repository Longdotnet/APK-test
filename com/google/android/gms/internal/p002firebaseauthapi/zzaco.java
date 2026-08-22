package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaco {
    private final zzacn zza;

    private zzaco(zzacn zzacnVar) {
        zzadl.zzf(zzacnVar, "output");
        this.zza = zzacnVar;
        zzacnVar.zze = this;
    }

    public static zzaco zza(zzacn zzacnVar) {
        zzaco zzacoVar = zzacnVar.zze;
        return zzacoVar != null ? zzacoVar : new zzaco(zzacnVar);
    }

    public final void zzA(int i, int i2) {
        this.zza.zzr(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzB(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzacn zzacnVar = this.zza;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                zzacnVar.zzr(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzE = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iZzE += zzacn.zzE((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzs(iZzE);
        while (i2 < list.size()) {
            zzacn zzacnVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            zzacnVar2.zzs((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public final void zzC(int i, long j) {
        this.zza.zzt(i, (j >> 63) ^ (j + j));
    }

    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzacn zzacnVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzacnVar.zzt(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzF += zzacn.zzF((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzs(iZzF);
        while (i2 < list.size()) {
            zzacn zzacnVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzacnVar2.zzu((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Deprecated
    public final void zzE(int i) {
        this.zza.zzq(i, 3);
    }

    public final void zzF(int i, String str) {
        this.zza.zzo(i, str);
    }

    public final void zzG(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzads)) {
            while (i2 < list.size()) {
                this.zza.zzo(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzads zzadsVar = (zzads) list;
        while (i2 < list.size()) {
            Object objZzf = zzadsVar.zzf(i2);
            if (objZzf instanceof String) {
                this.zza.zzo(i, (String) objZzf);
            } else {
                this.zza.zzQ(i, (zzacc) objZzf);
            }
            i2++;
        }
    }

    public final void zzH(int i, int i2) {
        this.zza.zzr(i, i2);
    }

    public final void zzI(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzE = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzE += zzacn.zzE(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzE);
        while (i2 < list.size()) {
            this.zza.zzs(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzJ(int i, long j) {
        this.zza.zzt(i, j);
    }

    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzF += zzacn.zzF(((Long) list.get(i3)).longValue());
        }
        this.zza.zzs(iZzF);
        while (i2 < list.size()) {
            this.zza.zzu(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzb(int i, boolean z) {
        this.zza.zzP(i, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzc(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzP(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzO(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzd(int i, zzacc zzaccVar) {
        this.zza.zzQ(i, zzaccVar);
    }

    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzQ(i, (zzacc) list.get(i2));
        }
    }

    public final void zzf(int i, double d) {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Deprecated
    public final void zzh(int i) {
        this.zza.zzq(i, 4);
    }

    public final void zzi(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    public final void zzj(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzy = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzy += zzacn.zzy(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzy);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    public final void zzl(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzm(int i, long j) {
        this.zza.zzj(i, j);
    }

    public final void zzn(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzo(int i, float f) {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzp(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public final void zzq(int i, Object obj, zzaew zzaewVar) {
        zzacn zzacnVar = this.zza;
        zzacnVar.zzq(i, 3);
        zzaewVar.zzn((zzaek) obj, zzacnVar.zze);
        zzacnVar.zzq(i, 4);
    }

    public final void zzr(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    public final void zzs(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzy = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzy += zzacn.zzy(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzy);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzt(int i, long j) {
        this.zza.zzt(i, j);
    }

    public final void zzu(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzF += zzacn.zzF(((Long) list.get(i3)).longValue());
        }
        this.zza.zzs(iZzF);
        while (i2 < list.size()) {
            this.zza.zzu(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzv(int i, Object obj, zzaew zzaewVar) {
        this.zza.zzn(i, (zzaek) obj, zzaewVar);
    }

    public final void zzw(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    public final void zzx(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzy(int i, long j) {
        this.zza.zzj(i, j);
    }

    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
