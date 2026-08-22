package com.google.android.gms.internal.p002firebaseauthapi;

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
public final class zzado {
    public static final zzado zza;
    public static final zzado zzb;
    public static final zzado zzc;
    public static final zzado zzd;
    public static final zzado zze;
    public static final zzado zzf;
    public static final zzado zzg;
    public static final zzado zzh;
    public static final zzado zzi;
    public static final zzado zzj;
    private static final /* synthetic */ zzado[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzado zzadoVar = new zzado("VOID", 0, Void.class, Void.class, null);
        zza = zzadoVar;
        Class cls = Integer.TYPE;
        zzado zzadoVar2 = new zzado("INT", 1, cls, Integer.class, 0);
        zzb = zzadoVar2;
        zzado zzadoVar3 = new zzado("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzadoVar3;
        zzado zzadoVar4 = new zzado("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzadoVar4;
        zzado zzadoVar5 = new zzado("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzadoVar5;
        zzado zzadoVar6 = new zzado("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzadoVar6;
        zzado zzadoVar7 = new zzado("STRING", 6, String.class, String.class, "");
        zzg = zzadoVar7;
        zzado zzadoVar8 = new zzado("BYTE_STRING", 7, zzacc.class, zzacc.class, zzacc.zzb);
        zzh = zzadoVar8;
        zzado zzadoVar9 = new zzado("ENUM", 8, cls, Integer.class, null);
        zzi = zzadoVar9;
        zzado zzadoVar10 = new zzado("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzadoVar10;
        zzk = new zzado[]{zzadoVar, zzadoVar2, zzadoVar3, zzadoVar4, zzadoVar5, zzadoVar6, zzadoVar7, zzadoVar8, zzadoVar9, zzadoVar10};
    }

    private zzado(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzado[] values() {
        return (zzado[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
