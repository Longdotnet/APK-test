package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgoj {
    private final Map zza = new HashMap();

    public final zzgoj zza(zzgxe zzgxeVar, Object obj) throws GeneralSecurityException {
        List list;
        if (zzgxeVar.zza() != 0 && zzgxeVar.zza() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        Map map = this.zza;
        if (map.containsKey(zzgxeVar)) {
            list = (List) map.get(zzgxeVar);
        } else {
            ArrayList arrayList = new ArrayList();
            map.put(zzgxeVar, arrayList);
            list = arrayList;
        }
        list.add(obj);
        return this;
    }

    public final zzgom zzb() {
        return new zzgom(this.zza, null);
    }
}
