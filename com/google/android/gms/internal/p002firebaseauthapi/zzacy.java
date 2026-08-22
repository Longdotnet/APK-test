package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacy {
    public static final zzacy zzA;
    public static final zzacy zzB;
    public static final zzacy zzC;
    public static final zzacy zzD;
    public static final zzacy zzE;
    public static final zzacy zzF;
    public static final zzacy zzG;
    public static final zzacy zzH;
    public static final zzacy zzI;
    public static final zzacy zzJ;
    public static final zzacy zzK;
    public static final zzacy zzL;
    public static final zzacy zzM;
    public static final zzacy zzN;
    public static final zzacy zzO;
    public static final zzacy zzP;
    public static final zzacy zzQ;
    public static final zzacy zzR;
    public static final zzacy zzS;
    public static final zzacy zzT;
    public static final zzacy zzU;
    public static final zzacy zzV;
    public static final zzacy zzW;
    public static final zzacy zzX;
    public static final zzacy zzY;
    private static final zzacy[] zzZ;
    public static final zzacy zza;
    private static final /* synthetic */ zzacy[] zzaa;
    public static final zzacy zzb;
    public static final zzacy zzc;
    public static final zzacy zzd;
    public static final zzacy zze;
    public static final zzacy zzf;
    public static final zzacy zzg;
    public static final zzacy zzh;
    public static final zzacy zzi;
    public static final zzacy zzj;
    public static final zzacy zzk;
    public static final zzacy zzl;
    public static final zzacy zzm;
    public static final zzacy zzn;
    public static final zzacy zzo;
    public static final zzacy zzp;
    public static final zzacy zzq;
    public static final zzacy zzr;
    public static final zzacy zzs;
    public static final zzacy zzt;
    public static final zzacy zzu;
    public static final zzacy zzv;
    public static final zzacy zzw;
    public static final zzacy zzx;
    public static final zzacy zzy;
    public static final zzacy zzz;
    private final zzado zzab;
    private final int zzac;
    private final Class zzad;

    private zzacy(String str, int i, int i2, int i3, zzado zzadoVar) {
        super(str, i);
        this.zzac = i2;
        this.zzab = zzadoVar;
        zzado zzadoVar2 = zzado.zza;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            this.zzad = zzadoVar.zza();
        } else {
            this.zzad = null;
        }
        if (i3 == 1) {
            zzadoVar.ordinal();
        }
    }

    public static zzacy[] values() {
        return (zzacy[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }

    static {
        zzado zzadoVar = zzado.zze;
        zzacy zzacyVar = new zzacy("DOUBLE", 0, 0, 1, zzadoVar);
        zza = zzacyVar;
        zzado zzadoVar2 = zzado.zzd;
        zzacy zzacyVar2 = new zzacy("FLOAT", 1, 1, 1, zzadoVar2);
        zzb = zzacyVar2;
        zzado zzadoVar3 = zzado.zzc;
        zzacy zzacyVar3 = new zzacy("INT64", 2, 2, 1, zzadoVar3);
        zzc = zzacyVar3;
        zzacy zzacyVar4 = new zzacy("UINT64", 3, 3, 1, zzadoVar3);
        zzd = zzacyVar4;
        zzado zzadoVar4 = zzado.zzb;
        zzacy zzacyVar5 = new zzacy("INT32", 4, 4, 1, zzadoVar4);
        zze = zzacyVar5;
        zzacy zzacyVar6 = new zzacy("FIXED64", 5, 5, 1, zzadoVar3);
        zzf = zzacyVar6;
        zzacy zzacyVar7 = new zzacy("FIXED32", 6, 6, 1, zzadoVar4);
        zzg = zzacyVar7;
        zzado zzadoVar5 = zzado.zzf;
        zzacy zzacyVar8 = new zzacy("BOOL", 7, 7, 1, zzadoVar5);
        zzh = zzacyVar8;
        zzado zzadoVar6 = zzado.zzg;
        zzacy zzacyVar9 = new zzacy("STRING", 8, 8, 1, zzadoVar6);
        zzi = zzacyVar9;
        zzado zzadoVar7 = zzado.zzj;
        zzacy zzacyVar10 = new zzacy("MESSAGE", 9, 9, 1, zzadoVar7);
        zzj = zzacyVar10;
        zzado zzadoVar8 = zzado.zzh;
        zzacy zzacyVar11 = new zzacy("BYTES", 10, 10, 1, zzadoVar8);
        zzk = zzacyVar11;
        zzacy zzacyVar12 = new zzacy("UINT32", 11, 11, 1, zzadoVar4);
        zzl = zzacyVar12;
        zzado zzadoVar9 = zzado.zzi;
        zzacy zzacyVar13 = new zzacy("ENUM", 12, 12, 1, zzadoVar9);
        zzm = zzacyVar13;
        zzacy zzacyVar14 = new zzacy("SFIXED32", 13, 13, 1, zzadoVar4);
        zzn = zzacyVar14;
        zzacy zzacyVar15 = new zzacy("SFIXED64", 14, 14, 1, zzadoVar3);
        zzo = zzacyVar15;
        zzacy zzacyVar16 = new zzacy("SINT32", 15, 15, 1, zzadoVar4);
        zzp = zzacyVar16;
        zzacy zzacyVar17 = new zzacy("SINT64", 16, 16, 1, zzadoVar3);
        zzq = zzacyVar17;
        zzacy zzacyVar18 = new zzacy("GROUP", 17, 17, 1, zzadoVar7);
        zzr = zzacyVar18;
        zzacy zzacyVar19 = new zzacy("DOUBLE_LIST", 18, 18, 2, zzadoVar);
        zzs = zzacyVar19;
        zzacy zzacyVar20 = new zzacy("FLOAT_LIST", 19, 19, 2, zzadoVar2);
        zzt = zzacyVar20;
        zzacy zzacyVar21 = new zzacy("INT64_LIST", 20, 20, 2, zzadoVar3);
        zzu = zzacyVar21;
        zzacy zzacyVar22 = new zzacy("UINT64_LIST", 21, 21, 2, zzadoVar3);
        zzv = zzacyVar22;
        zzacy zzacyVar23 = new zzacy("INT32_LIST", 22, 22, 2, zzadoVar4);
        zzw = zzacyVar23;
        zzacy zzacyVar24 = new zzacy("FIXED64_LIST", 23, 23, 2, zzadoVar3);
        zzx = zzacyVar24;
        zzacy zzacyVar25 = new zzacy("FIXED32_LIST", 24, 24, 2, zzadoVar4);
        zzy = zzacyVar25;
        zzacy zzacyVar26 = new zzacy("BOOL_LIST", 25, 25, 2, zzadoVar5);
        zzz = zzacyVar26;
        zzacy zzacyVar27 = new zzacy("STRING_LIST", 26, 26, 2, zzadoVar6);
        zzA = zzacyVar27;
        zzacy zzacyVar28 = new zzacy(bUqMCsuPSX.BLojNVNITfZv, 27, 27, 2, zzadoVar7);
        zzB = zzacyVar28;
        zzacy zzacyVar29 = new zzacy("BYTES_LIST", 28, 28, 2, zzadoVar8);
        zzC = zzacyVar29;
        zzacy zzacyVar30 = new zzacy("UINT32_LIST", 29, 29, 2, zzadoVar4);
        zzD = zzacyVar30;
        zzacy zzacyVar31 = new zzacy("ENUM_LIST", 30, 30, 2, zzadoVar9);
        zzE = zzacyVar31;
        zzacy zzacyVar32 = new zzacy("SFIXED32_LIST", 31, 31, 2, zzadoVar4);
        zzF = zzacyVar32;
        zzacy zzacyVar33 = new zzacy("SFIXED64_LIST", 32, 32, 2, zzadoVar3);
        zzG = zzacyVar33;
        zzacy zzacyVar34 = new zzacy("SINT32_LIST", 33, 33, 2, zzadoVar4);
        zzH = zzacyVar34;
        zzacy zzacyVar35 = new zzacy("SINT64_LIST", 34, 34, 2, zzadoVar3);
        zzI = zzacyVar35;
        zzacy zzacyVar36 = new zzacy("DOUBLE_LIST_PACKED", 35, 35, 3, zzadoVar);
        zzJ = zzacyVar36;
        zzacy zzacyVar37 = new zzacy("FLOAT_LIST_PACKED", 36, 36, 3, zzadoVar2);
        zzK = zzacyVar37;
        zzacy zzacyVar38 = new zzacy("INT64_LIST_PACKED", 37, 37, 3, zzadoVar3);
        zzL = zzacyVar38;
        zzacy zzacyVar39 = new zzacy("UINT64_LIST_PACKED", 38, 38, 3, zzadoVar3);
        zzM = zzacyVar39;
        zzacy zzacyVar40 = new zzacy("INT32_LIST_PACKED", 39, 39, 3, zzadoVar4);
        zzN = zzacyVar40;
        zzacy zzacyVar41 = new zzacy("FIXED64_LIST_PACKED", 40, 40, 3, zzadoVar3);
        zzO = zzacyVar41;
        zzacy zzacyVar42 = new zzacy("FIXED32_LIST_PACKED", 41, 41, 3, zzadoVar4);
        zzP = zzacyVar42;
        zzacy zzacyVar43 = new zzacy("BOOL_LIST_PACKED", 42, 42, 3, zzadoVar5);
        zzQ = zzacyVar43;
        zzacy zzacyVar44 = new zzacy("UINT32_LIST_PACKED", 43, 43, 3, zzadoVar4);
        zzR = zzacyVar44;
        zzacy zzacyVar45 = new zzacy("ENUM_LIST_PACKED", 44, 44, 3, zzadoVar9);
        zzS = zzacyVar45;
        zzacy zzacyVar46 = new zzacy("SFIXED32_LIST_PACKED", 45, 45, 3, zzadoVar4);
        zzT = zzacyVar46;
        zzacy zzacyVar47 = new zzacy("SFIXED64_LIST_PACKED", 46, 46, 3, zzadoVar3);
        zzU = zzacyVar47;
        zzacy zzacyVar48 = new zzacy("SINT32_LIST_PACKED", 47, 47, 3, zzadoVar4);
        zzV = zzacyVar48;
        zzacy zzacyVar49 = new zzacy("SINT64_LIST_PACKED", 48, 48, 3, zzadoVar3);
        zzW = zzacyVar49;
        zzacy zzacyVar50 = new zzacy("GROUP_LIST", 49, 49, 2, zzadoVar7);
        zzX = zzacyVar50;
        zzacy zzacyVar51 = new zzacy("MAP", 50, 50, 4, zzado.zza);
        zzY = zzacyVar51;
        zzaa = new zzacy[]{zzacyVar, zzacyVar2, zzacyVar3, zzacyVar4, zzacyVar5, zzacyVar6, zzacyVar7, zzacyVar8, zzacyVar9, zzacyVar10, zzacyVar11, zzacyVar12, zzacyVar13, zzacyVar14, zzacyVar15, zzacyVar16, zzacyVar17, zzacyVar18, zzacyVar19, zzacyVar20, zzacyVar21, zzacyVar22, zzacyVar23, zzacyVar24, zzacyVar25, zzacyVar26, zzacyVar27, zzacyVar28, zzacyVar29, zzacyVar30, zzacyVar31, zzacyVar32, zzacyVar33, zzacyVar34, zzacyVar35, zzacyVar36, zzacyVar37, zzacyVar38, zzacyVar39, zzacyVar40, zzacyVar41, zzacyVar42, zzacyVar43, zzacyVar44, zzacyVar45, zzacyVar46, zzacyVar47, zzacyVar48, zzacyVar49, zzacyVar50, zzacyVar51};
        zzacy[] zzacyVarArrValues = values();
        zzZ = new zzacy[zzacyVarArrValues.length];
        for (zzacy zzacyVar52 : zzacyVarArrValues) {
            zzZ[zzacyVar52.zzac] = zzacyVar52;
        }
    }
}
