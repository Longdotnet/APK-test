package com.google.android.gms.internal.ads;

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
/* JADX INFO: loaded from: classes.dex */
public final class zzhck {
    public static final zzhck zza;
    public static final zzhck zzb;
    public static final zzhck zzc;
    public static final zzhck zzd;
    public static final zzhck zze;
    public static final zzhck zzf;
    public static final zzhck zzg;
    public static final zzhck zzh;
    public static final zzhck zzi;
    public static final zzhck zzj;
    public static final zzhck zzk;
    public static final zzhck zzl;
    public static final zzhck zzm;
    public static final zzhck zzn;
    public static final zzhck zzo;
    public static final zzhck zzp;
    public static final zzhck zzq;
    public static final zzhck zzr;
    private static final /* synthetic */ zzhck[] zzs;
    private final zzhcl zzt;

    static {
        zzhck zzhckVar = new zzhck("DOUBLE", 0, zzhcl.DOUBLE, 1);
        zza = zzhckVar;
        zzhck zzhckVar2 = new zzhck("FLOAT", 1, zzhcl.FLOAT, 5);
        zzb = zzhckVar2;
        zzhcl zzhclVar = zzhcl.LONG;
        zzhck zzhckVar3 = new zzhck("INT64", 2, zzhclVar, 0);
        zzc = zzhckVar3;
        zzhck zzhckVar4 = new zzhck("UINT64", 3, zzhclVar, 0);
        zzd = zzhckVar4;
        zzhcl zzhclVar2 = zzhcl.INT;
        zzhck zzhckVar5 = new zzhck("INT32", 4, zzhclVar2, 0);
        zze = zzhckVar5;
        zzhck zzhckVar6 = new zzhck("FIXED64", 5, zzhclVar, 1);
        zzf = zzhckVar6;
        zzhck zzhckVar7 = new zzhck("FIXED32", 6, zzhclVar2, 5);
        zzg = zzhckVar7;
        zzhck zzhckVar8 = new zzhck("BOOL", 7, zzhcl.BOOLEAN, 0);
        zzh = zzhckVar8;
        zzhck zzhckVar9 = new zzhck("STRING", 8, zzhcl.STRING, 2);
        zzi = zzhckVar9;
        zzhcl zzhclVar3 = zzhcl.MESSAGE;
        zzhck zzhckVar10 = new zzhck("GROUP", 9, zzhclVar3, 3);
        zzj = zzhckVar10;
        zzhck zzhckVar11 = new zzhck("MESSAGE", 10, zzhclVar3, 2);
        zzk = zzhckVar11;
        zzhck zzhckVar12 = new zzhck("BYTES", 11, zzhcl.BYTE_STRING, 2);
        zzl = zzhckVar12;
        zzhck zzhckVar13 = new zzhck("UINT32", 12, zzhclVar2, 0);
        zzm = zzhckVar13;
        zzhck zzhckVar14 = new zzhck("ENUM", 13, zzhcl.ENUM, 0);
        zzn = zzhckVar14;
        zzhck zzhckVar15 = new zzhck("SFIXED32", 14, zzhclVar2, 5);
        zzo = zzhckVar15;
        zzhck zzhckVar16 = new zzhck("SFIXED64", 15, zzhclVar, 1);
        zzp = zzhckVar16;
        zzhck zzhckVar17 = new zzhck("SINT32", 16, zzhclVar2, 0);
        zzq = zzhckVar17;
        zzhck zzhckVar18 = new zzhck("SINT64", 17, zzhclVar, 0);
        zzr = zzhckVar18;
        zzs = new zzhck[]{zzhckVar, zzhckVar2, zzhckVar3, zzhckVar4, zzhckVar5, zzhckVar6, zzhckVar7, zzhckVar8, zzhckVar9, zzhckVar10, zzhckVar11, zzhckVar12, zzhckVar13, zzhckVar14, zzhckVar15, zzhckVar16, zzhckVar17, zzhckVar18};
    }

    private zzhck(String str, int i, zzhcl zzhclVar, int i2) {
        super(str, i);
        this.zzt = zzhclVar;
    }

    public static zzhck[] values() {
        return (zzhck[]) zzs.clone();
    }

    public final zzhcl zza() {
        return this.zzt;
    }
}
