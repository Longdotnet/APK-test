package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends zzaw {
    public zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzgVar, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzapVarZzb2 instanceof zzae)) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("FN requires an ArrayValue of parameter names found ", zzapVarZzb2.getClass().getCanonicalName()));
        }
        List listZzm = ((zzae) zzapVarZzb2).zzm();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzao(zzapVarZzb.zzi(), listZzm, arrayList, zzgVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x011a, code lost:
    
        if (r8.equals("continue") == false) goto L64;
     */
    @Override // com.google.android.gms.internal.measurement.zzaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaz.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
