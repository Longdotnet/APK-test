package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.login.vu.dLDI;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagd {
    public static final zzagd zza;
    public static final zzagd zzb;
    public static final zzagd zzc;
    public static final zzagd zzd;
    public static final zzagd zze;
    public static final zzagd zzf;
    public static final zzagd zzg;
    public static final zzagd zzh;
    public static final zzagd zzi;
    public static final zzagd zzj;
    public static final zzagd zzk;
    public static final zzagd zzl;
    public static final zzagd zzm;
    public static final zzagd zzn;
    public static final zzagd zzo;
    public static final zzagd zzp;
    public static final zzagd zzq;
    public static final zzagd zzr;
    private static final /* synthetic */ zzagd[] zzs;
    private final zzage zzt;

    private zzagd(String str, int i, zzage zzageVar, int i2) {
        super(str, i);
        this.zzt = zzageVar;
    }

    public static zzagd[] values() {
        return (zzagd[]) zzs.clone();
    }

    public final zzage zza() {
        return this.zzt;
    }

    static {
        zzagd zzagdVar = new zzagd("DOUBLE", 0, zzage.DOUBLE, 1);
        zza = zzagdVar;
        zzagd zzagdVar2 = new zzagd("FLOAT", 1, zzage.FLOAT, 5);
        zzb = zzagdVar2;
        zzage zzageVar = zzage.LONG;
        zzagd zzagdVar3 = new zzagd("INT64", 2, zzageVar, 0);
        zzc = zzagdVar3;
        zzagd zzagdVar4 = new zzagd("UINT64", 3, zzageVar, 0);
        zzd = zzagdVar4;
        zzage zzageVar2 = zzage.INT;
        zzagd zzagdVar5 = new zzagd("INT32", 4, zzageVar2, 0);
        zze = zzagdVar5;
        zzagd zzagdVar6 = new zzagd("FIXED64", 5, zzageVar, 1);
        zzf = zzagdVar6;
        zzagd zzagdVar7 = new zzagd("FIXED32", 6, zzageVar2, 5);
        zzg = zzagdVar7;
        zzagd zzagdVar8 = new zzagd("BOOL", 7, zzage.BOOLEAN, 0);
        zzh = zzagdVar8;
        zzagd zzagdVar9 = new zzagd("STRING", 8, zzage.STRING, 2);
        zzi = zzagdVar9;
        zzage zzageVar3 = zzage.MESSAGE;
        zzagd zzagdVar10 = new zzagd(dLDI.gOeSFex, 9, zzageVar3, 3);
        zzj = zzagdVar10;
        zzagd zzagdVar11 = new zzagd("MESSAGE", 10, zzageVar3, 2);
        zzk = zzagdVar11;
        zzagd zzagdVar12 = new zzagd("BYTES", 11, zzage.BYTE_STRING, 2);
        zzl = zzagdVar12;
        zzagd zzagdVar13 = new zzagd("UINT32", 12, zzageVar2, 0);
        zzm = zzagdVar13;
        zzagd zzagdVar14 = new zzagd("ENUM", 13, zzage.ENUM, 0);
        zzn = zzagdVar14;
        zzagd zzagdVar15 = new zzagd("SFIXED32", 14, zzageVar2, 5);
        zzo = zzagdVar15;
        zzagd zzagdVar16 = new zzagd("SFIXED64", 15, zzageVar, 1);
        zzp = zzagdVar16;
        zzagd zzagdVar17 = new zzagd("SINT32", 16, zzageVar2, 0);
        zzq = zzagdVar17;
        zzagd zzagdVar18 = new zzagd("SINT64", 17, zzageVar, 0);
        zzr = zzagdVar18;
        zzs = new zzagd[]{zzagdVar, zzagdVar2, zzagdVar3, zzagdVar4, zzagdVar5, zzagdVar6, zzagdVar7, zzagdVar8, zzagdVar9, zzagdVar10, zzagdVar11, zzagdVar12, zzagdVar13, zzagdVar14, zzagdVar15, zzagdVar16, zzagdVar17, zzagdVar18};
    }
}
