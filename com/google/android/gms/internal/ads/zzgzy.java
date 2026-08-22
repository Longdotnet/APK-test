package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class zzgzy {
    public static final zzgzy zza;
    public static final zzgzy zzb;
    public static final zzgzy zzc;
    public static final zzgzy zzd;
    public static final zzgzy zze;
    public static final zzgzy zzf;
    public static final zzgzy zzg;
    public static final zzgzy zzh;
    public static final zzgzy zzi;
    public static final zzgzy zzj;
    private static final /* synthetic */ zzgzy[] zzk;
    private final Class zzl;

    static {
        zzgzy zzgzyVar = new zzgzy("VOID", 0, Void.class, Void.class, null);
        zza = zzgzyVar;
        Class cls = Integer.TYPE;
        zzgzy zzgzyVar2 = new zzgzy("INT", 1, cls, Integer.class, 0);
        zzb = zzgzyVar2;
        zzgzy zzgzyVar3 = new zzgzy("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzgzyVar3;
        zzgzy zzgzyVar4 = new zzgzy("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzgzyVar4;
        zzgzy zzgzyVar5 = new zzgzy("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzgzyVar5;
        zzgzy zzgzyVar6 = new zzgzy("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzgzyVar6;
        zzgzy zzgzyVar7 = new zzgzy("STRING", 6, String.class, String.class, "");
        zzg = zzgzyVar7;
        zzgzy zzgzyVar8 = new zzgzy("BYTE_STRING", 7, zzgxz.class, zzgxz.class, zzgxz.zzb);
        zzh = zzgzyVar8;
        zzgzy zzgzyVar9 = new zzgzy("ENUM", 8, cls, Integer.class, null);
        zzi = zzgzyVar9;
        zzgzy zzgzyVar10 = new zzgzy("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzgzyVar10;
        zzk = new zzgzy[]{zzgzyVar, zzgzyVar2, zzgzyVar3, zzgzyVar4, zzgzyVar5, zzgzyVar6, zzgzyVar7, zzgzyVar8, zzgzyVar9, zzgzyVar10};
    }

    private zzgzy(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzl = cls2;
    }

    public static zzgzy[] values() {
        return (zzgzy[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
