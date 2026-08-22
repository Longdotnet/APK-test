package com.google.android.gms.internal.measurement;

import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh extends zzaw {
    public zzbh() {
        this.zza.add(zzbl.FOR_IN);
        this.zza.add(zzbl.FOR_IN_CONST);
        this.zza.add(zzbl.FOR_IN_LET);
        this.zza.add(zzbl.FOR_LET);
        this.zza.add(zzbl.FOR_OF);
        this.zza.add(zzbl.FOR_OF_CONST);
        this.zza.add(zzbl.FOR_OF_LET);
        this.zza.add(zzbl.WHILE);
    }

    private static zzap zzc(zzbf zzbfVar, Iterator it, zzap zzapVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzapVarZzc = zzbfVar.zza((zzap) it.next()).zzc((zzae) zzapVar);
                if (zzapVarZzc instanceof zzag) {
                    zzag zzagVar = (zzag) zzapVarZzc;
                    if ("break".equals(zzagVar.zzc())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar.zzc())) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    private static zzap zzd(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        return zzc(zzbfVar, zzapVar.zzl(), zzapVar2);
    }

    private static zzap zze(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof Iterable) {
            return zzc(zzbfVar, ((Iterable) zzapVar).iterator(), zzapVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        if (iOrdinal == 65) {
            zzap zzapVar = (zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.WHILE, 4, list, 0);
            zzap zzapVar2 = (zzap) list.get(1);
            zzap zzapVar3 = (zzap) list.get(2);
            zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(3));
            if (zzgVar.zzb(zzapVar3).zzg().booleanValue()) {
                zzap zzapVarZzc = zzgVar.zzc((zzae) zzapVarZzb);
                if (zzapVarZzc instanceof zzag) {
                    zzag zzagVar = (zzag) zzapVarZzc;
                    if ("break".equals(zzagVar.zzc())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar.zzc())) {
                        return zzagVar;
                    }
                }
            }
            while (zzgVar.zzb(zzapVar).zzg().booleanValue()) {
                zzap zzapVarZzc2 = zzgVar.zzc((zzae) zzapVarZzb);
                if (zzapVarZzc2 instanceof zzag) {
                    zzag zzagVar2 = (zzag) zzapVarZzc2;
                    if ("break".equals(zzagVar2.zzc())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar2.zzc())) {
                        return zzagVar2;
                    }
                }
                zzgVar.zzb(zzapVar2);
            }
            return zzap.zzf;
        }
        switch (iOrdinal) {
            case 26:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_IN, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                return zzd(new zzbg(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_IN_CONST, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                return zzd(new zzbd(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            case 28:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_IN_LET, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                return zzd(new zzbe(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            case 29:
                zzap zzapVarZzb2 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_LET, 4, list, 0));
                if (!(zzapVarZzb2 instanceof zzae)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                zzae zzaeVar = (zzae) zzapVarZzb2;
                zzap zzapVar4 = (zzap) list.get(1);
                zzap zzapVar5 = (zzap) list.get(2);
                zzap zzapVarZzb3 = zzgVar.zzb((zzap) list.get(3));
                zzg zzgVarZza = zzgVar.zza();
                for (int i = 0; i < zzaeVar.zzc(); i++) {
                    String strZzi = zzaeVar.zze(i).zzi();
                    zzgVarZza.zzg(strZzi, zzgVar.zzd(strZzi));
                }
                while (zzgVar.zzb(zzapVar4).zzg().booleanValue()) {
                    zzap zzapVarZzc3 = zzgVar.zzc((zzae) zzapVarZzb3);
                    if (zzapVarZzc3 instanceof zzag) {
                        zzag zzagVar3 = (zzag) zzapVarZzc3;
                        if ("break".equals(zzagVar3.zzc())) {
                            return zzap.zzf;
                        }
                        if ("return".equals(zzagVar3.zzc())) {
                            return zzagVar3;
                        }
                    }
                    zzg zzgVarZza2 = zzgVar.zza();
                    for (int i2 = 0; i2 < zzaeVar.zzc(); i2++) {
                        String strZzi2 = zzaeVar.zze(i2).zzi();
                        zzgVarZza2.zzg(strZzi2, zzgVarZza.zzd(strZzi2));
                    }
                    zzgVarZza2.zzb(zzapVar5);
                    zzgVarZza = zzgVarZza2;
                }
                return zzap.zzf;
            case 30:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_OF, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                return zze(new zzbg(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_OF_CONST, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                return zze(new zzbd(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            case 32:
                if (!(BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.FOR_OF_LET, 3, list, 0) instanceof zzat)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                return zze(new zzbe(zzgVar, ((zzap) list.get(0)).zzi()), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
            default:
                return zzb(str);
        }
    }
}
