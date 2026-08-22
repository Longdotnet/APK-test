package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: loaded from: classes.dex */
public final class zzxb {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzvf zzb;
    private final zzyv zzc;

    public zzxb(FirebaseApp firebaseApp) {
        zzah.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        zzah.checkNotNull(applicationContext);
        this.zzb = new zzvf(new zzxp(firebaseApp, zzxo.zza(), null, null, null));
        this.zzc = new zzyv(applicationContext);
    }

    private static boolean zzG(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzsy zzsyVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsyVar);
        zzah.checkNotNull(zzwzVar);
        String phoneNumber = zzsyVar.zzb().getPhoneNumber();
        zzxa zzxaVar = new zzxa(zzwzVar, zza);
        if (this.zzc.zzl(phoneNumber)) {
            if (!zzsyVar.zzg()) {
                this.zzc.zzi(zzxaVar, phoneNumber);
                return;
            }
            this.zzc.zzj(phoneNumber);
        }
        long jZza = zzsyVar.zza();
        boolean zZzh = zzsyVar.zzh();
        zzaau zzaauVarZzb = zzaau.zzb(zzsyVar.zzd(), zzsyVar.zzb().getUid(), zzsyVar.zzb().getPhoneNumber(), zzsyVar.zzc(), zzsyVar.zze(), zzsyVar.zzf());
        if (zzG(jZza, zZzh)) {
            zzaauVarZzb.zzd(new zzza(this.zzc.zzc()));
        }
        this.zzc.zzk(phoneNumber, zzxaVar, jZza, zZzh);
        this.zzb.zzG(zzaauVarZzb, new zzys(this.zzc, zzxaVar, phoneNumber));
    }

    public final void zzB(zzta zztaVar, zzwz zzwzVar) {
        zzah.checkNotNull(zztaVar);
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzH(zztaVar.zza(), zztaVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzC(zztc zztcVar, zzwz zzwzVar) {
        zzah.checkNotNull(zztcVar);
        zzah.checkNotEmpty(zztcVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzI(zztcVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzD(zzte zzteVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzteVar);
        zzah.checkNotEmpty(zzteVar.zzb());
        zzah.checkNotEmpty(zzteVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzJ(zzteVar.zzb(), zzteVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzE(zztg zztgVar, zzwz zzwzVar) {
        zzah.checkNotNull(zztgVar);
        zzah.checkNotEmpty(zztgVar.zzb());
        zzah.checkNotNull(zztgVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzK(zztgVar.zzb(), zztgVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzF(zzti zztiVar, zzwz zzwzVar) {
        zzah.checkNotNull(zztiVar);
        this.zzb.zzL(zzzv.zzc(zztiVar.zza(), zztiVar.zzb(), zztiVar.zzc()), new zzxa(zzwzVar, zza));
    }

    public final void zza(zzqy zzqyVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzqyVar);
        zzah.checkNotEmpty(zzqyVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzg(zzqyVar.zza(), zzqyVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzb(zzra zzraVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzraVar);
        zzah.checkNotEmpty(zzraVar.zza());
        zzah.checkNotEmpty(zzraVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzh(zzraVar.zza(), zzraVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzc(zzrc zzrcVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrcVar);
        zzah.checkNotEmpty(zzrcVar.zza());
        zzah.checkNotEmpty(zzrcVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzi(zzrcVar.zza(), zzrcVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzd(zzre zzreVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzreVar);
        zzah.checkNotEmpty(zzreVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzj(zzreVar.zza(), zzreVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zze(zzrg zzrgVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrgVar);
        zzah.checkNotEmpty(zzrgVar.zza());
        zzah.checkNotEmpty(zzrgVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzk(zzrgVar.zza(), zzrgVar.zzb(), zzrgVar.zzc(), new zzxa(zzwzVar, zza));
    }

    public final void zzf(zzri zzriVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzriVar);
        zzah.checkNotEmpty(zzriVar.zza());
        zzah.checkNotEmpty(zzriVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzl(zzriVar.zza(), zzriVar.zzb(), zzriVar.zzc(), new zzxa(zzwzVar, zza));
    }

    public final void zzg(zzrk zzrkVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrkVar);
        zzah.checkNotEmpty(zzrkVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzm(zzrkVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzh(zzrm zzrmVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrmVar);
        zzah.checkNotNull(zzwzVar);
        zzvf zzvfVar = this.zzb;
        String strZzb = zzrmVar.zzb();
        String strZzg = zzrmVar.zza().zzg();
        zzah.checkNotNull(strZzg);
        String smsCode = zzrmVar.zza().getSmsCode();
        zzah.checkNotNull(smsCode);
        zzvfVar.zzn(zzzi.zzb(strZzb, strZzg, smsCode, zzrmVar.zzc()), zzrmVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzi(zzro zzroVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzroVar);
        zzah.checkNotNull(zzwzVar);
        zzvf zzvfVar = this.zzb;
        String strZzb = zzroVar.zzb();
        String strZzg = zzroVar.zza().zzg();
        zzah.checkNotNull(strZzg);
        String smsCode = zzroVar.zza().getSmsCode();
        zzah.checkNotNull(smsCode);
        zzvfVar.zzo(zzzk.zzb(strZzb, strZzg, smsCode), new zzxa(zzwzVar, zza));
    }

    public final void zzj(zzrq zzrqVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrqVar);
        zzah.checkNotNull(zzwzVar);
        zzah.checkNotEmpty(zzrqVar.zza());
        this.zzb.zzp(zzrqVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzk(zzrs zzrsVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrsVar);
        zzah.checkNotEmpty(zzrsVar.zza());
        this.zzb.zzq(zzrsVar.zza(), zzrsVar.zzb(), new zzxa(zzwzVar, zza));
    }

    public final void zzl(zzru zzruVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzruVar);
        zzah.checkNotEmpty(zzruVar.zzb());
        zzah.checkNotEmpty(zzruVar.zzc());
        zzah.checkNotEmpty(zzruVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzr(zzruVar.zzb(), zzruVar.zzc(), zzruVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzm(zzrw zzrwVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzrwVar);
        zzah.checkNotEmpty(zzrwVar.zzb());
        zzah.checkNotNull(zzrwVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzs(zzrwVar.zzb(), zzrwVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzn(zzry zzryVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzwzVar);
        zzah.checkNotNull(zzryVar);
        PhoneAuthCredential phoneAuthCredentialZza = zzryVar.zza();
        zzah.checkNotNull(phoneAuthCredentialZza);
        String strZzb = zzryVar.zzb();
        zzah.checkNotEmpty(strZzb);
        this.zzb.zzt(strZzb, zzyl.zza(phoneAuthCredentialZza), new zzxa(zzwzVar, zza));
    }

    public final void zzo(zzsa zzsaVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsaVar);
        zzah.checkNotEmpty(zzsaVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzu(zzsaVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzp(zzsc zzscVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzscVar);
        zzah.checkNotEmpty(zzscVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzv(zzscVar.zzb(), zzscVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzq(zzse zzseVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzseVar);
        zzah.checkNotEmpty(zzseVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzw(zzseVar.zzb(), zzseVar.zza(), zzseVar.zzc(), new zzxa(zzwzVar, zza));
    }

    public final void zzr(zzsg zzsgVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzwzVar);
        zzah.checkNotNull(zzsgVar);
        zzaal zzaalVarZza = zzsgVar.zza();
        zzah.checkNotNull(zzaalVarZza);
        String strZzd = zzaalVarZza.zzd();
        zzxa zzxaVar = new zzxa(zzwzVar, zza);
        if (this.zzc.zzl(strZzd)) {
            if (!zzaalVarZza.zzf()) {
                this.zzc.zzi(zzxaVar, strZzd);
                return;
            }
            this.zzc.zzj(strZzd);
        }
        long jZzb = zzaalVarZza.zzb();
        boolean zZzg = zzaalVarZza.zzg();
        if (zzG(jZzb, zZzg)) {
            zzaalVarZza.zze(new zzza(this.zzc.zzc()));
        }
        this.zzc.zzk(strZzd, zzxaVar, jZzb, zZzg);
        this.zzb.zzx(zzaalVarZza, new zzys(this.zzc, zzxaVar, strZzd));
    }

    public final void zzs(zzsi zzsiVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsiVar);
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzy(zzsiVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzt(zzsk zzskVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzskVar);
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzz(zzskVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzu(zzsm zzsmVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsmVar);
        zzah.checkNotNull(zzsmVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzA(zzsmVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzv(zzso zzsoVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsoVar);
        zzah.checkNotEmpty(zzsoVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzB(new zzabb(zzsoVar.zzb(), zzsoVar.zza()), new zzxa(zzwzVar, zza));
    }

    public final void zzw(zzsq zzsqVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzsqVar);
        zzah.checkNotEmpty(zzsqVar.zza());
        zzah.checkNotEmpty(zzsqVar.zzb());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzC(zzsqVar.zza(), zzsqVar.zzb(), zzsqVar.zzc(), new zzxa(zzwzVar, zza));
    }

    public final void zzx(zzss zzssVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzssVar);
        zzah.checkNotNull(zzssVar.zza());
        zzah.checkNotNull(zzwzVar);
        this.zzb.zzD(zzssVar.zza(), new zzxa(zzwzVar, zza));
    }

    public final void zzy(zzsu zzsuVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzwzVar);
        zzah.checkNotNull(zzsuVar);
        PhoneAuthCredential phoneAuthCredentialZza = zzsuVar.zza();
        zzah.checkNotNull(phoneAuthCredentialZza);
        this.zzb.zzE(zzyl.zza(phoneAuthCredentialZza), new zzxa(zzwzVar, zza));
    }

    public final void zzz(zzsw zzswVar, zzwz zzwzVar) {
        zzah.checkNotNull(zzswVar);
        zzah.checkNotNull(zzwzVar);
        String strZzd = zzswVar.zzd();
        zzxa zzxaVar = new zzxa(zzwzVar, zza);
        if (this.zzc.zzl(strZzd)) {
            if (!zzswVar.zzg()) {
                this.zzc.zzi(zzxaVar, strZzd);
                return;
            }
            this.zzc.zzj(strZzd);
        }
        long jZza = zzswVar.zza();
        boolean zZzh = zzswVar.zzh();
        zzaas zzaasVarZzb = zzaas.zzb(zzswVar.zzb(), zzswVar.zzd(), zzswVar.zzc(), zzswVar.zze(), zzswVar.zzf());
        if (zzG(jZza, zZzh)) {
            zzaasVarZzb.zzd(new zzza(this.zzc.zzc()));
        }
        this.zzc.zzk(strZzd, zzxaVar, jZza, zZzh);
        this.zzb.zzF(zzaasVarZzb, new zzys(this.zzc, zzxaVar, strZzd));
    }
}
