package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgff {
    private final List zza = new ArrayList();
    private final zzgnh zzb = zzgnh.zza;
    private boolean zzc = false;

    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgfd) it.next()).zza = false;
        }
    }

    public final zzgff zza(zzgfd zzgfdVar) {
        if (zzgfdVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgfdVar.zza) {
            zzd();
        }
        zzgfdVar.zzf = this;
        this.zza.add(zzgfdVar);
        return this;
    }

    public final zzgfi zzb() throws GeneralSecurityException {
        int i;
        int i2;
        char c = 1;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List<zzgfd> list = this.zza;
        zzguj zzgujVarZzc = zzgun.zzc();
        ArrayList arrayList = new ArrayList(list.size());
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size() - 1) {
            int i5 = i4 + 1;
            if (((zzgfd) list.get(i4)).zze == zzgfe.zza && ((zzgfd) list.get(i5)).zze != zzgfe.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i4 = i5;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzgfd zzgfdVar : list) {
            zzgfb unused = zzgfdVar.zzb;
            if (zzgfdVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzgfdVar.zze == zzgfe.zza) {
                i = i3;
                while (true) {
                    if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                        break;
                    }
                    int i6 = zzgpj.zza;
                    i = i3;
                    while (i == 0) {
                        byte[] bArrZzb = zzgpa.zzb(4);
                        i = (bArrZzb[3] & 255) | ((bArrZzb[i3] & 255) << 24) | ((bArrZzb[c] & 255) << 16) | ((bArrZzb[2] & 255) << 8);
                    }
                }
            } else {
                zzgfe unused2 = zzgfdVar.zze;
                i = i3;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Id ", " is used twice in the keyset"));
            }
            hashSet.add(numValueOf);
            zzgfd.zza(zzgfdVar);
            zzgez zzgezVarZza = zzgno.zzb().zza(zzgfdVar.zzd, c != zzgfdVar.zzd.zza() ? null : numValueOf);
            zzgfg zzgfgVar = new zzgfg(zzgezVarZza, zzgfdVar.zzb, i, zzgfdVar.zza, null);
            zzgfb zzgfbVar = zzgfdVar.zzb;
            zzgox zzgoxVar = (zzgox) zzgny.zzc().zzd(zzgezVarZza, zzgox.class, zzgfn.zza());
            Integer numZzf = zzgoxVar.zzf();
            if (numZzf != null && numZzf.intValue() != i) {
                throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
            }
            zzgfb zzgfbVar2 = zzgfb.zza;
            if (zzgfbVar2.equals(zzgfbVar)) {
                i2 = 3;
            } else if (zzgfb.zzb.equals(zzgfbVar)) {
                i2 = 4;
            } else {
                if (!zzgfb.zzc.equals(zzgfbVar)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i2 = 5;
            }
            zzguk zzgukVarZzc = zzgul.zzc();
            zzgty zzgtyVarZza = zzgub.zza();
            zzgtyVarZza.zzb(zzgoxVar.zzg());
            zzgtyVarZza.zzc(zzgoxVar.zze());
            zzgtyVarZza.zza(zzgoxVar.zzb());
            zzgukVarZzc.zza(zzgtyVarZza);
            zzgukVarZzc.zzd(i2);
            zzgukVarZzc.zzb(i);
            zzgukVarZzc.zzc(zzgoxVar.zzc());
            zzgujVarZzc.zza((zzgul) zzgukVarZzc.zzbr());
            if (zzgfdVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgfdVar.zzb != zzgfbVar2) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgfgVar);
            c = 1;
            i3 = 0;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgujVarZzc.zzb(num.intValue());
        zzgun zzgunVar = (zzgun) zzgujVarZzc.zzbr();
        zzgfi.zzj(zzgunVar);
        return new zzgfi(zzgunVar, arrayList, this.zzb);
    }
}
