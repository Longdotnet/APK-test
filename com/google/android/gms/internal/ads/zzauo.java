package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import androidx.core.view.ContentInfoCompat$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzauo implements PackageManager$OnChecksumsReadyListener {
    final zzgeh zza = zzgeh.zze();

    public final void onChecksumsReady(List list) {
        if (list == null) {
            this.zza.zzc("");
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksumM = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(list.get(i));
                if (apkChecksumM.getType() == 8) {
                    zzgeh zzgehVar = this.zza;
                    zzgbd zzgbdVarZzf = zzgbd.zzi().zzf();
                    byte[] value = apkChecksumM.getValue();
                    zzgehVar.zzc(zzgbdVarZzf.zzj(value, 0, value.length));
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.zza.zzc("");
    }
}
