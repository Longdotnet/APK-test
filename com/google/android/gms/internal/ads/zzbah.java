package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzbah {
    private final int zza;
    private final zzbae zzb = new zzbaj();

    public zzbah(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(((String) arrayList.get(i)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzbag zzbagVar = new zzbag();
        int i2 = this.zza;
        PriorityQueue priorityQueue = new PriorityQueue(i2, new zzbaf(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzbai.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzbam.zzc(strArrZzb, i2, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbagVar.zzb.write(this.zzb.zzb(((zzbal) it.next()).zzb));
            } catch (IOException e) {
                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error while writing hash to byteStream", e);
            }
        }
        return zzbagVar.toString();
    }
}
