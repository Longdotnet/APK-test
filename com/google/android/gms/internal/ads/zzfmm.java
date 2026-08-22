package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmm {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzfls zzflsVar, String str) {
        zzfml zzfmlVar;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (!zza.matcher("Ad overlay").matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
        List list = this.zzb;
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                zzfmlVar = null;
                break;
            }
            zzfmlVar = (zzfml) it.next();
        } while (zzfmlVar.zzb().get() != view);
        if (zzfmlVar == null) {
            list.add(new zzfml(view, zzflsVar, "Ad overlay"));
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
