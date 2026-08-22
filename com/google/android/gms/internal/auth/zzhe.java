package com.google.android.gms.internal.auth;

import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;

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
public final class zzhe {
    public static final zzhe zza;
    public static final zzhe zzb;
    public static final zzhe zzc;
    public static final zzhe zzd;
    public static final zzhe zze;
    public static final zzhe zzf;
    public static final zzhe zzg;
    public static final zzhe zzh;
    public static final zzhe zzi;
    public static final zzhe zzj;
    public static final zzhe zzk;
    public static final zzhe zzl;
    public static final zzhe zzm;
    public static final zzhe zzn;
    public static final zzhe zzo;
    public static final zzhe zzp;
    public static final zzhe zzq;
    public static final zzhe zzr;
    private static final /* synthetic */ zzhe[] zzs;
    private final zzhf zzt;

    private zzhe(String str, int i, zzhf zzhfVar, int i2) {
        super(str, i);
        this.zzt = zzhfVar;
    }

    public static zzhe[] values() {
        return (zzhe[]) zzs.clone();
    }

    public final zzhf zza() {
        return this.zzt;
    }

    static {
        zzhe zzheVar = new zzhe("DOUBLE", 0, zzhf.DOUBLE, 1);
        zza = zzheVar;
        zzhe zzheVar2 = new zzhe("FLOAT", 1, zzhf.FLOAT, 5);
        zzb = zzheVar2;
        zzhf zzhfVar = zzhf.zzb;
        zzhe zzheVar3 = new zzhe("INT64", 2, zzhfVar, 0);
        zzc = zzheVar3;
        zzhe zzheVar4 = new zzhe("UINT64", 3, zzhfVar, 0);
        zzd = zzheVar4;
        zzhf zzhfVar2 = zzhf.INT;
        zzhe zzheVar5 = new zzhe("INT32", 4, zzhfVar2, 0);
        zze = zzheVar5;
        zzhe zzheVar6 = new zzhe("FIXED64", 5, zzhfVar, 1);
        zzf = zzheVar6;
        zzhe zzheVar7 = new zzhe(eoBKjVuj.xzClbz, 6, zzhfVar2, 5);
        zzg = zzheVar7;
        zzhe zzheVar8 = new zzhe("BOOL", 7, zzhf.BOOLEAN, 0);
        zzh = zzheVar8;
        zzhe zzheVar9 = new zzhe("STRING", 8, zzhf.STRING, 2);
        zzi = zzheVar9;
        zzhf zzhfVar3 = zzhf.MESSAGE;
        zzhe zzheVar10 = new zzhe("GROUP", 9, zzhfVar3, 3);
        zzj = zzheVar10;
        zzhe zzheVar11 = new zzhe("MESSAGE", 10, zzhfVar3, 2);
        zzk = zzheVar11;
        zzhe zzheVar12 = new zzhe("BYTES", 11, zzhf.BYTE_STRING, 2);
        zzl = zzheVar12;
        zzhe zzheVar13 = new zzhe("UINT32", 12, zzhfVar2, 0);
        zzm = zzheVar13;
        zzhe zzheVar14 = new zzhe("ENUM", 13, zzhf.ENUM, 0);
        zzn = zzheVar14;
        zzhe zzheVar15 = new zzhe("SFIXED32", 14, zzhfVar2, 5);
        zzo = zzheVar15;
        zzhe zzheVar16 = new zzhe("SFIXED64", 15, zzhfVar, 1);
        zzp = zzheVar16;
        zzhe zzheVar17 = new zzhe("SINT32", 16, zzhfVar2, 0);
        zzq = zzheVar17;
        zzhe zzheVar18 = new zzhe("SINT64", 17, zzhfVar, 0);
        zzr = zzheVar18;
        zzs = new zzhe[]{zzheVar, zzheVar2, zzheVar3, zzheVar4, zzheVar5, zzheVar6, zzheVar7, zzheVar8, zzheVar9, zzheVar10, zzheVar11, zzheVar12, zzheVar13, zzheVar14, zzheVar15, zzheVar16, zzheVar17, zzheVar18};
    }
}
