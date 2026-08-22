package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbk extends zzaw {
    public zzbk() {
        this.zza.add(zzbl.ASSIGN);
        this.zza.add(zzbl.CONST);
        this.zza.add(zzbl.CREATE_ARRAY);
        this.zza.add(zzbl.CREATE_OBJECT);
        this.zza.add(zzbl.EXPRESSION_LIST);
        this.zza.add(zzbl.GET);
        this.zza.add(zzbl.GET_INDEX);
        this.zza.add(zzbl.GET_PROPERTY);
        this.zza.add(zzbl.NULL);
        this.zza.add(zzbl.SET_PROPERTY);
        this.zza.add(zzbl.TYPEOF);
        this.zza.add(zzbl.UNDEFINED);
        this.zza.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        String str2;
        int i = 0;
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        if (iOrdinal == 3) {
            zzap zzapVarZzb = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.ASSIGN, 2, list, 0));
            if (!(zzapVarZzb instanceof zzat)) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected string for assign var. got ", zzapVarZzb.getClass().getCanonicalName()));
            }
            if (!zzgVar.zzh(zzapVarZzb.zzi())) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Attempting to assign undefined value ", zzapVarZzb.zzi()));
            }
            zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(1));
            zzgVar.zzg(zzapVarZzb.zzi(), zzapVarZzb2);
            return zzapVarZzb2;
        }
        if (iOrdinal == 14) {
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(list.size(), "CONST requires an even number of arguments, found "));
            }
            while (i < list.size() - 1) {
                zzap zzapVarZzb3 = zzgVar.zzb((zzap) list.get(i));
                if (!(zzapVarZzb3 instanceof zzat)) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected string for const name. got ", zzapVarZzb3.getClass().getCanonicalName()));
                }
                zzgVar.zzf(zzapVarZzb3.zzi(), zzgVar.zzb((zzap) list.get(i + 1)));
                i += 2;
            }
            return zzap.zzf;
        }
        if (iOrdinal == 24) {
            zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
            zzap zzapVarZzb4 = zzap.zzf;
            while (i < list.size()) {
                zzapVarZzb4 = zzgVar.zzb((zzap) list.get(i));
                if (zzapVarZzb4 instanceof zzag) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return zzapVarZzb4;
        }
        if (iOrdinal == 33) {
            zzap zzapVarZzb5 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.GET, 1, list, 0));
            if (zzapVarZzb5 instanceof zzat) {
                return zzgVar.zzd(zzapVarZzb5.zzi());
            }
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected string for get var. got ", zzapVarZzb5.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            zzh.zzh(zzbl.NULL.name(), 0, list);
            return zzap.zzg;
        }
        if (iOrdinal == 58) {
            zzap zzapVarZzb6 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.SET_PROPERTY, 3, list, 0));
            zzap zzapVarZzb7 = zzgVar.zzb((zzap) list.get(1));
            zzap zzapVarZzb8 = zzgVar.zzb((zzap) list.get(2));
            if (zzapVarZzb6 == zzap.zzf || zzapVarZzb6 == zzap.zzg) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Can't set property ", zzapVarZzb7.zzi(), " of ", zzapVarZzb6.zzi()));
            }
            if ((zzapVarZzb6 instanceof zzae) && (zzapVarZzb7 instanceof zzah)) {
                ((zzae) zzapVarZzb6).zzq(zzapVarZzb7.zzh().intValue(), zzapVarZzb8);
            } else if (zzapVarZzb6 instanceof zzal) {
                ((zzal) zzapVarZzb6).zzr(zzapVarZzb7.zzi(), zzapVarZzb8);
            }
            return zzapVarZzb8;
        }
        if (iOrdinal == 17) {
            if (list.isEmpty()) {
                return new zzae();
            }
            zzae zzaeVar = new zzae();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzap zzapVarZzb9 = zzgVar.zzb((zzap) it.next());
                if (zzapVarZzb9 instanceof zzag) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                zzaeVar.zzq(i, zzapVarZzb9);
                i++;
            }
            return zzaeVar;
        }
        if (iOrdinal == 18) {
            if (list.isEmpty()) {
                return new zzam();
            }
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(list.size(), "CREATE_OBJECT requires an even number of arguments, found "));
            }
            zzam zzamVar = new zzam();
            while (i < list.size() - 1) {
                zzap zzapVarZzb10 = zzgVar.zzb((zzap) list.get(i));
                zzap zzapVarZzb11 = zzgVar.zzb((zzap) list.get(i + 1));
                if ((zzapVarZzb10 instanceof zzag) || (zzapVarZzb11 instanceof zzag)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                zzamVar.zzr(zzapVarZzb10.zzi(), zzapVarZzb11);
                i += 2;
            }
            return zzamVar;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            zzap zzapVarZzb12 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.GET_PROPERTY, 2, list, 0));
            zzap zzapVarZzb13 = zzgVar.zzb((zzap) list.get(1));
            if ((zzapVarZzb12 instanceof zzae) && zzh.zzk(zzapVarZzb13)) {
                return ((zzae) zzapVarZzb12).zze(zzapVarZzb13.zzh().intValue());
            }
            if (zzapVarZzb12 instanceof zzal) {
                return ((zzal) zzapVarZzb12).zzf(zzapVarZzb13.zzi());
            }
            if (zzapVarZzb12 instanceof zzat) {
                if ("length".equals(zzapVarZzb13.zzi())) {
                    return new zzah(Double.valueOf(zzapVarZzb12.zzi().length()));
                }
                if (zzh.zzk(zzapVarZzb13) && zzapVarZzb13.zzh().doubleValue() < zzapVarZzb12.zzi().length()) {
                    return new zzat(String.valueOf(zzapVarZzb12.zzi().charAt(zzapVarZzb13.zzh().intValue())));
                }
            }
            return zzap.zzf;
        }
        switch (iOrdinal) {
            case 62:
                zzap zzapVarZzb14 = zzgVar.zzb((zzap) BarcodeFormat$EnumUnboxingLocalUtility.m(zzbl.TYPEOF, 1, list, 0));
                if (zzapVarZzb14 instanceof zzau) {
                    str2 = "undefined";
                } else if (zzapVarZzb14 instanceof zzaf) {
                    str2 = "boolean";
                } else if (zzapVarZzb14 instanceof zzah) {
                    str2 = "number";
                } else if (zzapVarZzb14 instanceof zzat) {
                    str2 = "string";
                } else if (zzapVarZzb14 instanceof zzao) {
                    str2 = "function";
                } else {
                    if ((zzapVarZzb14 instanceof zzaq) || (zzapVarZzb14 instanceof zzag)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzapVarZzb14));
                    }
                    str2 = "object";
                }
                return new zzat(str2);
            case 63:
                zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                return zzap.zzf;
            case 64:
                zzh.zzi(zzbl.VAR.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzap zzapVarZzb15 = zzgVar.zzb((zzap) it2.next());
                    if (!(zzapVarZzb15 instanceof zzat)) {
                        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected string for var name. got ", zzapVarZzb15.getClass().getCanonicalName()));
                    }
                    zzgVar.zze(zzapVarZzb15.zzi(), zzap.zzf);
                }
                return zzap.zzf;
            default:
                return zzb(str);
        }
    }
}
