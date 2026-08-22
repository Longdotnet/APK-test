package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends zzgl {
    public long zza;
    public String zzb;
    public AccountManager zzc;
    public Boolean zzd;
    public long zze;

    public final long zza() {
        zzg();
        return this.zze;
    }

    public final long zzb() {
        zzu();
        return this.zza;
    }

    public final String zzc() {
        zzu();
        return this.zzb;
    }

    public final boolean zze() {
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.zzr.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.zze > 86400000) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context context = zzfrVar.zze;
        int iCheckSelfPermission = ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS");
        zzeh zzehVar = zzfrVar.zzm;
        if (iCheckSelfPermission != 0) {
            zzfr.zzR(zzehVar);
            zzehVar.zzh.zza("Permission error checking for dasher/unicorn accounts");
            this.zze = jCurrentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(context);
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.zzd = Boolean.TRUE;
                this.zze = jCurrentTimeMillis;
                return true;
            }
            Account[] result2 = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.zzd = Boolean.TRUE;
                this.zze = jCurrentTimeMillis;
                return true;
            }
            this.zze = jCurrentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException e) {
            e = e;
            zzfr.zzR(zzehVar);
            zzehVar.zze.zzb(e, "Exception checking account types");
        } catch (OperationCanceledException e2) {
            e = e2;
            zzfr.zzR(zzehVar);
            zzehVar.zze.zzb(e, "Exception checking account types");
        } catch (IOException e3) {
            e = e3;
            zzfr.zzR(zzehVar);
            zzehVar.zze.zzb(e, "Exception checking account types");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.zzb = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(language.toLowerCase(locale2), "-", locale.getCountry().toLowerCase(locale2));
        return false;
    }
}
