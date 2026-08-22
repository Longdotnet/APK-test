package com.google.android.gms.internal.measurement;

import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi extends zzaw {
    public zzbi() {
        this.zza.add(zzbl.ADD);
        this.zza.add(zzbl.DIVIDE);
        this.zza.add(zzbl.MODULUS);
        this.zza.add(zzbl.MULTIPLY);
        this.zza.add(zzbl.NEGATE);
        this.zza.add(zzbl.POST_DECREMENT);
        this.zza.add(zzbl.POST_INCREMENT);
        this.zza.add(zzbl.PRE_DECREMENT);
        this.zza.add(zzbl.PRE_INCREMENT);
        this.zza.add(zzbl.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        if (iOrdinal == 0) {
            zzap zzapVarZzb = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.ADD, 2, list, 0));
            zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(1));
            if ((zzapVarZzb instanceof zzal) || (zzapVarZzb instanceof zzat) || (zzapVarZzb2 instanceof zzal) || (zzapVarZzb2 instanceof zzat)) {
                return new zzat(String.valueOf(zzapVarZzb.zzi()).concat(String.valueOf(zzapVarZzb2.zzi())));
            }
            return new zzah(Double.valueOf(zzapVarZzb2.zzh().doubleValue() + zzapVarZzb.zzh().doubleValue()));
        }
        if (iOrdinal == 21) {
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.DIVIDE, 2, list, 0)).zzh().doubleValue() / zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
        }
        if (iOrdinal == 59) {
            zzap zzapVarZzb3 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.SUBTRACT, 2, list, 0));
            zzah zzahVar = new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
            return new zzah(Double.valueOf(zzahVar.zzh().doubleValue() + zzapVarZzb3.zzh().doubleValue()));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            zzh.zzh(str, 2, list);
            zzap zzapVarZzb4 = zzgVar.zzb((zzap) list.get(0));
            zzgVar.zzb((zzap) list.get(1));
            return zzapVarZzb4;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            zzh.zzh(str, 1, list);
            return zzgVar.zzb((zzap) list.get(0));
        }
        switch (iOrdinal) {
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                return new zzah(Double.valueOf(zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.MODULUS, 2, list, 0)).zzh().doubleValue() % zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                return new zzah(Double.valueOf(zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.MULTIPLY, 2, list, 0)).zzh().doubleValue() * zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
            case 46:
                return new zzah(Double.valueOf(-zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.NEGATE, 1, list, 0)).zzh().doubleValue()));
            default:
                return zzb(str);
        }
    }
}
