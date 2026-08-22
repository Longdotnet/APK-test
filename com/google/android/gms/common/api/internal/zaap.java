package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zaap extends zaav {
    public final /* synthetic */ zaaw zaa;
    public final ArrayList zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar);
        this.zaa = zaawVar;
        this.zac = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void zaa() {
        Set setEmptySet;
        zaaw zaawVar = this.zaa;
        zabe zabeVar = zaawVar.zaa.zag;
        zabi zabiVar = zaawVar.zaa;
        ClientSettings clientSettings = zaawVar.zar;
        if (clientSettings == null) {
            setEmptySet = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(clientSettings.zab);
            Map map = clientSettings.zad;
            for (Api api : map.keySet()) {
                if (!zabiVar.zab.containsKey(api.zab())) {
                    hashSet.addAll(((com.google.android.gms.common.internal.zab) map.get(api)).zaa);
                }
            }
            setEmptySet = hashSet;
        }
        zabeVar.zad = setEmptySet;
        ArrayList arrayList = this.zac;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Api.Client) arrayList.get(i)).getRemoteService(zaawVar.zao, zabiVar.zag.zad);
        }
    }
}
