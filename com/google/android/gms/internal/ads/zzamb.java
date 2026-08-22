package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzamb implements zzakt {
    private final zzen zza = new zzen();

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzcu zzcuVarZzq;
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        ArrayList arrayList = new ArrayList();
        while (zzenVar.zza() > 0) {
            zzdd.zze(zzenVar.zza() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZzg = zzenVar.zzg() - 8;
            if (zzenVar.zzg() == 1987343459) {
                CharSequence charSequenceZza = null;
                zzcs zzcsVarZzb = null;
                while (iZzg > 0) {
                    zzdd.zze(iZzg >= 8, "Incomplete vtt cue box header found.");
                    int iZzg2 = zzenVar.zzg();
                    int iZzg3 = zzenVar.zzg();
                    int i3 = iZzg - 8;
                    int i4 = iZzg2 - 8;
                    String strZzC = zzex.zzC(zzenVar.zzN(), zzenVar.zzc(), i4);
                    zzenVar.zzM(i4);
                    if (iZzg3 == 1937011815) {
                        zzcsVarZzb = zzaml.zzb(strZzC);
                    } else if (iZzg3 == 1885436268) {
                        charSequenceZza = zzaml.zza(null, strZzC.trim(), Collections.emptyList());
                    }
                    iZzg = i3 - i4;
                }
                if (charSequenceZza == null) {
                    charSequenceZza = "";
                }
                if (zzcsVarZzb != null) {
                    zzcsVarZzb.zzl(charSequenceZza);
                    zzcuVarZzq = zzcsVarZzb.zzq();
                } else {
                    Pattern pattern = zzaml.zza;
                    zzamj zzamjVar = new zzamj();
                    zzamjVar.zzc = charSequenceZza;
                    zzcuVarZzq = zzamjVar.zza().zzq();
                }
                arrayList.add(zzcuVarZzq);
            } else {
                zzenVar.zzM(iZzg);
            }
        }
        zzdnVar.zza(new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
