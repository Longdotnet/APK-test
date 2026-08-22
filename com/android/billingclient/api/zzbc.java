package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;
import androidx.work.Worker;
import com.android.installreferrer.api.InstallReferrerClientImpl;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.facebook.AccessTokenCache;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.zza;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.android.gms.internal.play_billing.zzhl;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzs;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.yoyogames.runner.RunnerJNILib;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbc implements ServiceConnection {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final Object zzb;

    public /* synthetic */ zzbc(BillingClientImpl billingClientImpl, InputMergerFactory$1 inputMergerFactory$1) {
        this.$r8$classId = 0;
        this.zza = billingClientImpl;
        this.zzb = new Object();
    }

    private final void onServiceDisconnected$com$facebook$internal$AttributionIdentifiers$GoogleAdServiceConnection(ComponentName componentName) {
    }

    public IBinder getBinder() throws InterruptedException {
        if (((AtomicBoolean) this.zzb).compareAndSet(true, true)) {
            throw new IllegalStateException("Binder already consumed");
        }
        Object objTake = ((LinkedBlockingDeque) this.zza).take();
        Intrinsics.checkNotNullExpressionValue(objTake, "queue.take()");
        return (IBinder) objTake;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGetInstallReferrerService iGetInstallReferrerService;
        switch (this.$r8$classId) {
            case 0:
                zzb.zzj("BillingClient", "Billing service connected.");
                ((BillingClientImpl) this.zza).zzg = com.google.android.gms.internal.play_billing.zzr.zzu(iBinder);
                zzaz zzazVar = new zzaz(this, 0);
                Worker.AnonymousClass1 anonymousClass1 = new Worker.AnonymousClass1(this, 16);
                BillingClientImpl billingClientImpl = (BillingClientImpl) this.zza;
                if (billingClientImpl.zzao(zzazVar, 30000L, anonymousClass1, billingClientImpl.zzaj()) == null) {
                    BillingClientImpl billingClientImpl2 = (BillingClientImpl) this.zza;
                    BillingResult billingResultZzal = billingClientImpl2.zzal();
                    billingClientImpl2.zzap(zzcb.zza(25, 6, billingResultZzal));
                    zzd(billingResultZzal);
                }
                break;
            case 1:
                Okio.logVerbose("Install Referrer service connected.");
                int i = IGetInstallReferrerService.Stub.$r8$clinit;
                if (iBinder == null) {
                    iGetInstallReferrerService = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService)) {
                        IGetInstallReferrerService.Stub.Proxy proxy = new IGetInstallReferrerService.Stub.Proxy();
                        proxy.mRemote = iBinder;
                        iGetInstallReferrerService = proxy;
                    } else {
                        iGetInstallReferrerService = (IGetInstallReferrerService) iInterfaceQueryLocalInterface;
                    }
                }
                InstallReferrerClientImpl installReferrerClientImpl = (InstallReferrerClientImpl) this.zza;
                installReferrerClientImpl.mService = iGetInstallReferrerService;
                installReferrerClientImpl.mClientState = 2;
                ((AccessTokenCache) this.zzb).onInstallReferrerSetupFinished(0);
                break;
            case 2:
                if (iBinder != null) {
                    try {
                        ((LinkedBlockingDeque) this.zza).put(iBinder);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
                break;
            default:
                zzs zzsVar = (zzs) this.zza;
                if (iBinder == null) {
                    zzeh zzehVar = zzsVar.zza.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zza(UUFMQdNK.gsVcQoCy);
                } else {
                    try {
                        zzbr zzbrVarZzb = zzbq.zzb(iBinder);
                        if (zzbrVarZzb == null) {
                            zzeh zzehVar2 = zzsVar.zza.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzg.zza("Install Referrer Service implementation was not found");
                        } else {
                            zzeh zzehVar3 = zzsVar.zza.zzm;
                            zzfr.zzR(zzehVar3);
                            zzehVar3.zzl.zza(PZmDzEagKNdW.wMAxRrwVXmv);
                            zzfo zzfoVar = zzsVar.zza.zzn;
                            zzfr.zzR(zzfoVar);
                            zzfoVar.zzp(new zza(this, zzbrVarZzb, this));
                        }
                    } catch (RuntimeException e) {
                        zzeh zzehVar4 = zzsVar.zza.zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzg.zzb(e, "Exception occurred while calling Install Referrer API");
                        return;
                    }
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.$r8$classId) {
            case 0:
                zzb.zzk("BillingClient", "Billing service disconnected.");
                RoomOpenHelper roomOpenHelper = ((BillingClientImpl) this.zza).zzf;
                zzhl zzhlVarZzz = zzhl.zzz();
                roomOpenHelper.getClass();
                if (zzhlVarZzz != null) {
                    try {
                        zzhd zzhdVarZzy = zzhe.zzy();
                        zzhdVarZzy.zzn((zzgu) roomOpenHelper.mConfiguration);
                        zzhdVarZzy.zzo(zzhlVarZzz);
                        ((zzcj) roomOpenHelper.mDelegate).zza((zzhe) zzhdVarZzy.zzf());
                    } catch (Throwable th) {
                        zzb.zzl("BillingLogger", "Unable to log.", th);
                    }
                    break;
                }
                ((BillingClientImpl) this.zza).zzg = null;
                ((BillingClientImpl) this.zza).zza = 0;
                synchronized (this.zzb) {
                    boolean unused = GooglePlayBillingService.m_isStoreConnected = false;
                    RunnerJNILib.CreateAsynEventWithDSMap(RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12006.0d}), 66);
                    break;
                }
                return;
            case 1:
                Okio.logWarn("Install Referrer service disconnected.");
                InstallReferrerClientImpl installReferrerClientImpl = (InstallReferrerClientImpl) this.zza;
                installReferrerClientImpl.mService = null;
                installReferrerClientImpl.mClientState = 0;
                return;
            case 2:
                return;
            default:
                zzeh zzehVar = ((zzs) this.zza).zza.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza(JrbhsraGtto.APusJFIRTVbZQU);
                return;
        }
    }

    public void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            InputMergerFactory$1.onBillingSetupFinished(billingResult);
        }
    }

    public /* synthetic */ zzbc(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    public zzbc() {
        this.$r8$classId = 2;
        this.zzb = new AtomicBoolean(false);
        this.zza = new LinkedBlockingDeque();
    }
}
