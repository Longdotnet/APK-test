package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zaao extends zaav {
    public final /* synthetic */ zaaw zaa;
    public final Map zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaawVar, Map map) {
        super(zaawVar);
        this.zaa = zaawVar;
        this.zac = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void zaa() {
        com.google.android.gms.signin.zae zaeVar;
        zaaw zaawVar = this.zaa;
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(zaawVar.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map map = this.zac;
        for (Api.Client client : map.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaal) map.get(client)).zac) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        Context context = zaawVar.zac;
        int i = 0;
        int iZab = -1;
        if (!zIsEmpty) {
            int size = arrayList.size();
            while (i < size) {
                iZab = zalVar.zab(context, (Api.Client) arrayList.get(i));
                i++;
                if (iZab != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                iZab = zalVar.zab(context, (Api.Client) arrayList2.get(i));
                i++;
                if (iZab == 0) {
                    break;
                }
            }
        }
        zabi zabiVar = zaawVar.zaa;
        if (iZab != 0) {
            zaam zaamVar = new zaam(this, zaawVar, new ConnectionResult(iZab, null));
            zabh zabhVar = zabiVar.zam;
            zabhVar.sendMessage(zabhVar.obtainMessage(1, zaamVar));
            return;
        }
        if (zaawVar.zam && (zaeVar = zaawVar.zak) != null) {
            zaeVar.zab();
        }
        for (Api.Client client2 : map.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) map.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.zab(context, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaan zaanVar = new zaan(zaawVar, connectionProgressReportCallbacks);
                zabh zabhVar2 = zabiVar.zam;
                zabhVar2.sendMessage(zabhVar2.obtainMessage(1, zaanVar));
            }
        }
    }
}
