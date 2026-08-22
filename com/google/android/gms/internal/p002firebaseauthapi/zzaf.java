package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaf {
    private final zzn zza;
    private final zzae zzb;

    private zzaf(zzae zzaeVar) {
        zzm zzmVar = zzm.zza;
        this.zzb = zzaeVar;
        this.zza = zzmVar;
    }

    public static zzaf zzb(char c) {
        return new zzaf(new zzaa(new zzk('.')));
    }

    public final List zzd(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itZza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZza.hasNext()) {
            arrayList.add((String) itZza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static zzaf zzc(String str) {
        zzq zzqVarZza = zzx.zza("[.-]");
        if (((zzs) zzqVarZza.zza("")).zza.matches()) {
            throw new IllegalArgumentException(zzag.zzb(PZmDzEagKNdW.klMhtK, zzqVarZza));
        }
        return new zzaf(new zzac(zzqVarZza));
    }
}
