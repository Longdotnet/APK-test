package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.crypto.KeyGenerator;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfl {
    private zzbi zze;
    private zzfq zzf = null;
    private zzbj zza = null;
    private String zzb = null;
    private zzap zzc = null;
    private zzbf zzd = null;

    private final zzbi zzi() {
        zzap zzapVar = this.zzc;
        if (zzapVar != null) {
            try {
                return zzbi.zzf(zzbh.zzh(this.zzf, zzapVar));
            } catch (zzadn | GeneralSecurityException e) {
                Log.w(zzfn.zzb, "cannot decrypt keyset: ", e);
            }
        }
        return zzbi.zzf(zzar.zzb(this.zzf));
    }

    @Deprecated
    public final zzfl zzd(zznx zznxVar) {
        String strZzf = zznxVar.zzf();
        byte[] bArrZzt = zznxVar.zze().zzt();
        zzoy zzoyVarZzd = zznxVar.zzd();
        zzoy zzoyVar = zzoy.UNKNOWN_PREFIX;
        int iOrdinal = zzoyVarZzd.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 4;
                    if (iOrdinal != 4) {
                        throw new IllegalArgumentException("Unknown output prefix type");
                    }
                }
            }
        }
        this.zzd = zzbf.zze(strZzf, bArrZzt, i);
        return this;
    }

    public final zzfl zze(String str) {
        if (!str.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        this.zzb = str;
        return this;
    }

    public final zzfl zzf(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        this.zzf = new zzfq(context, "GenericIdpKeyset", str2);
        this.zza = new zzfr(context, "GenericIdpKeyset", str2);
        return this;
    }

    public final synchronized zzfn zzg() {
        zzbi zzbiVarZze;
        if (this.zzb != null) {
            this.zzc = zzh();
        }
        try {
            zzbiVarZze = zzi();
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(zzfn.zzb, 4)) {
                Log.i(zzfn.zzb, "keyset not found, will generate a new one. " + e.getMessage());
            }
            if (this.zzd == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            zzbiVarZze = zzbi.zze();
            zzbiVarZze.zzc(this.zzd);
            zzbiVarZze.zzd(zzbiVarZze.zzb().zzd().zzb(0).zza());
            if (this.zzc != null) {
                zzbiVarZze.zzb().zzf(this.zza, this.zzc);
            } else {
                zzar.zza(zzbiVarZze.zzb(), this.zza);
            }
        }
        this.zze = zzbiVarZze;
        return new zzfn(this, null);
    }

    private final zzap zzh() throws KeyStoreException {
        zzfp zzfpVar = new zzfp();
        boolean zZzc = zzfpVar.zzc(this.zzb);
        if (!zZzc) {
            try {
                String str = this.zzb;
                if (new zzfp().zzc(str)) {
                    throw new IllegalArgumentException("cannot generate a new key " + str + " because it already exists; please delete it with deleteKey() and try again");
                }
                String strZza = zzqs.zza(mnwSv.baexvxkwbKtYAcQ, str);
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(strZza, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
                keyGenerator.generateKey();
            } catch (GeneralSecurityException e) {
                e = e;
                Log.w(zzfn.zzb, "cannot use Android Keystore, it'll be disabled", e);
                return null;
            } catch (ProviderException e2) {
                e = e2;
                Log.w(zzfn.zzb, "cannot use Android Keystore, it'll be disabled", e);
                return null;
            }
        }
        try {
            return zzfpVar.zza(this.zzb);
        } catch (GeneralSecurityException | ProviderException e3) {
            if (zZzc) {
                throw new KeyStoreException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(wsbWxekY.GcbMLswhXG, this.zzb, " exists but is unusable"), e3);
            }
            Log.w(zzfn.zzb, "cannot use Android Keystore, it'll be disabled", e3);
            return null;
        }
    }
}
