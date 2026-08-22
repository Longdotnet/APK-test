package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzhbo extends zzhbt {
    public zzhbo() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry entryZzg = zzg(i);
                if (((zzgyv) ((zzhbp) entryZzg).zza()).zze()) {
                    entryZzg.setValue(Collections.unmodifiableList((List) entryZzg.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzgyv) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
