package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzamm implements zzakt {
    private final zzen zza = new zzen();
    private final zzamc zzb = new zzamc();

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        try {
            int iZzc = zzenVar.zzc();
            Charset charset = StandardCharsets.UTF_8;
            String strZzz = zzenVar.zzz(charset);
            if (strZzz == null || !strZzz.startsWith("WEBVTT")) {
                zzenVar.zzL(iZzc);
                throw zzaz.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzenVar.zzz(charset))), null);
            }
            while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                byte b = -1;
                int iZzc2 = 0;
                while (b == -1) {
                    iZzc2 = zzenVar.zzc();
                    String strZzz2 = zzenVar.zzz(StandardCharsets.UTF_8);
                    if (strZzz2 == null) {
                        b = 0;
                    } else if ("STYLE".equals(strZzz2)) {
                        b = 2;
                    } else {
                        b = strZzz2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                zzenVar.zzL(iZzc2);
                if (b == 0) {
                    zzakn.zza(new zzamp(arrayList2), zzaksVar, zzdnVar);
                    return;
                }
                if (b == 1) {
                    while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
                    }
                } else if (b != 2) {
                    zzame zzameVarZzc = zzaml.zzc(zzenVar, arrayList);
                    if (zzameVarZzc != null) {
                        arrayList2.add(zzameVarZzc);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    zzenVar.zzz(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zzb(zzenVar));
                }
            }
        } catch (zzaz e) {
            throw new IllegalArgumentException(e);
        }
    }
}
