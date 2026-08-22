package com.google.firebase.auth.internal;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.internal.p002firebaseauthapi.zzaaj;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: loaded from: classes2.dex */
public final class zzo implements ActionCodeResult {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final ActionCodeInfo zzd;

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    public zzo(zzaaj zzaajVar) {
        String strZzc;
        byte b;
        if (zzaajVar.zzh()) {
            strZzc = zzaajVar.zzd();
        } else {
            strZzc = zzaajVar.zzc();
        }
        this.zzb = strZzc;
        this.zzc = zzaajVar.zzc();
        ActionCodeInfo zzmVar = null;
        if (!zzaajVar.zzi()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String strZze = zzaajVar.zze();
        int i = 0;
        switch (strZze.hashCode()) {
            case -1874510116:
                if (strZze.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    b = 5;
                } else {
                    b = -1;
                }
                break;
            case -1452371317:
                if (strZze.equals(nYVxXTZQ.uRExcyTUs)) {
                    b = 0;
                } else {
                    b = -1;
                }
                break;
            case -1341836234:
                if (strZze.equals("VERIFY_EMAIL")) {
                    b = 1;
                } else {
                    b = -1;
                }
                break;
            case -1099157829:
                if (strZze.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    b = 3;
                } else {
                    b = -1;
                }
                break;
            case 870738373:
                if (strZze.equals("EMAIL_SIGNIN")) {
                    b = 2;
                } else {
                    b = -1;
                }
                break;
            case 970484929:
                if (strZze.equals("RECOVER_EMAIL")) {
                    b = 4;
                } else {
                    b = -1;
                }
                break;
            default:
                b = -1;
                break;
        }
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        if (b != 4) {
                            if (b != 5) {
                                i = 3;
                            } else {
                                i = 6;
                            }
                        } else {
                            i = 2;
                        }
                    } else {
                        i = 5;
                    }
                } else {
                    i = 4;
                }
            } else {
                i = 1;
            }
        }
        this.zza = i;
        if (i != 4 && i != 3) {
            if (zzaajVar.zzg()) {
                zzmVar = new zzn(zzaajVar.zzc(), zzba.zza(zzaajVar.zzb()));
            } else if (zzaajVar.zzh()) {
                zzmVar = new zzl(zzaajVar.zzd(), zzaajVar.zzc());
            } else if (zzaajVar.zzf()) {
                zzmVar = new zzm(zzaajVar.zzc());
            }
            this.zzd = zzmVar;
            return;
        }
        this.zzd = null;
    }
}
