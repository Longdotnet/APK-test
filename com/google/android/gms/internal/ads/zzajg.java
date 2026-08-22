package com.google.android.gms.internal.ads;

import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzajg {
    public static String zza(List list) {
        Iterator it = list.iterator();
        String str = null;
        boolean z = false;
        while (it.hasNext()) {
            String str2 = ((zzajs) it.next()).zza.zzg.zzo;
            if (zzay.zzj(str2)) {
                return "video/mp4";
            }
            if (zzay.zzh(str2)) {
                z = true;
            } else if (zzay.zzi(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = DaWYVMJ.oVXfJBJ;
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        if (z) {
            return "audio/mp4";
        }
        if (str != null) {
            return str;
        }
        return "application/mp4";
    }
}
