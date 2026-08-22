package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;
import java.util.HashSet;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
final class zzy {
    private final zzz zza;
    private final zzcl zzb;
    private int zzc = 0;
    private ConsentInformation.PrivacyOptionsRequirementStatus zzd = ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN;

    public zzy(zzz zzzVar, zzcl zzclVar) {
        this.zza = zzzVar;
        this.zzb = zzclVar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    public final zzab zza() {
        String str;
        zzcl zzclVar = this.zzb;
        int i = zzclVar.zzf;
        boolean z = i == 8;
        zzz zzzVar = this.zza;
        zzzVar.zzc.zzh(z);
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                this.zzc = 3;
                break;
            case 4:
                this.zzc = 2;
                break;
            case 5:
                this.zzc = 1;
                break;
            case 6:
                throw new zzg(1, mnwSv.stvYvIKLl.concat(String.valueOf(zzclVar.zzc)));
            case 7:
                throw new zzg(3, "Publisher misconfiguration: ".concat(String.valueOf(zzclVar.zzc)));
            default:
                throw new zzg(1, "Invalid response from server.");
        }
        int i3 = zzclVar.zzg;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        if (i4 == 1) {
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
        } else {
            if (i4 != 2) {
                throw new zzg(1, "Invalid response from server.");
            }
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED;
        }
        String str2 = zzclVar.zza;
        zzbq zzbqVar = str2 == null ? null : new zzbq(zzclVar.zzb, str2);
        zzzVar.zzc.zzj(new HashSet(zzclVar.zzd));
        for (zzck zzckVar : zzclVar.zze) {
            int i5 = zzckVar.zzb;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            if (i6 == 0) {
                str = null;
            } else if (i6 == 1) {
                str = "write";
            } else if (i6 != 2) {
                str = null;
            } else {
                str = "clear";
            }
            if (str != null) {
                zzzVar.zza.zzb(str, zzckVar.zza, zzzVar.zzb);
            }
        }
        return new zzab(this.zzc, this.zzd, zzbqVar, null);
    }
}
