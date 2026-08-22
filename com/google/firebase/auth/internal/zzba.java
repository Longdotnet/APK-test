package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzaac;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzba {
    public static MultiFactorInfo zza(zzaac zzaacVar) {
        if (zzaacVar == null || TextUtils.isEmpty(zzaacVar.zze())) {
            return null;
        }
        String strZzd = zzaacVar.zzd();
        String strZzc = zzaacVar.zzc();
        long jZza = zzaacVar.zza();
        String strZze = zzaacVar.zze();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZze);
        return new PhoneMultiFactorInfo(strZzd, strZzc, jZza, strZze);
    }

    public static List zzb(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfoZza = zza((zzaac) it.next());
            if (multiFactorInfoZza != null) {
                arrayList.add(multiFactorInfoZza);
            }
        }
        return arrayList;
    }
}
