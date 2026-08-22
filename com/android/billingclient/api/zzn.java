package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.room.RoomOpenHelper;
import androidx.work.Worker;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzcd;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzkt;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends BroadcastReceiver {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object zza;
    public boolean zzb;
    public boolean zzc;

    public zzn(zzo zzoVar, boolean z) {
        this.zza = zzoVar;
        this.zzc = z;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.$r8$classId) {
            case 0:
                Bundle extras = intent.getExtras();
                zzo zzoVar = (zzo) this.zza;
                if (extras != null) {
                    BillingResult billingResultZze = zzb.zze(intent, "BillingBroadcastManager");
                    String action = intent.getAction();
                    int i = true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
                    if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                        List listZzi = zzb.zzi(extras);
                        if (billingResultZze.zza == 0) {
                            ((RoomOpenHelper) zzoVar.zze).zzc(zzcb.zzc(i));
                        } else {
                            zzd(extras, billingResultZze, i);
                        }
                        ((GooglePlayBillingService.YYPurchasesUpdatedListener) zzoVar.zzb).onPurchasesUpdated(billingResultZze, listZzi);
                    } else if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                        if (billingResultZze.zza == 0) {
                            zzoVar.getClass();
                            zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                            BillingResult billingResult = zzce.zzj;
                            ((RoomOpenHelper) zzoVar.zze).zza(zzcb.zza(77, i, billingResult));
                            ((GooglePlayBillingService.YYPurchasesUpdatedListener) zzoVar.zzb).onPurchasesUpdated(billingResult, zzai.zzk());
                        } else {
                            zzd(extras, billingResultZze, i);
                            ((GooglePlayBillingService.YYPurchasesUpdatedListener) zzoVar.zzb).onPurchasesUpdated(billingResultZze, zzai.zzk());
                        }
                    }
                } else {
                    zzb.zzk("BillingBroadcastManager", "Bundle is null.");
                    RoomOpenHelper roomOpenHelper = (RoomOpenHelper) zzoVar.zze;
                    BillingResult billingResult2 = zzce.zzj;
                    roomOpenHelper.zza(zzcb.zza(11, 1, billingResult2));
                    GooglePlayBillingService.YYPurchasesUpdatedListener yYPurchasesUpdatedListener = (GooglePlayBillingService.YYPurchasesUpdatedListener) zzoVar.zzb;
                    if (yYPurchasesUpdatedListener != null) {
                        yYPurchasesUpdatedListener.onPurchasesUpdated(billingResult2, null);
                    }
                }
                break;
            default:
                zzkt zzktVar = (zzkt) this.zza;
                zzktVar.zzB$1();
                String action2 = intent.getAction();
                zzktVar.zzay().zzl.zzb(action2, "NetworkBroadcastReceiver received action");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action2)) {
                    zzktVar.zzay().zzg.zzb(action2, "NetworkBroadcastReceiver received unknown action");
                } else {
                    zzen zzenVar = zzktVar.zzd;
                    zzkt.zzal(zzenVar);
                    boolean zZza = zzenVar.zza();
                    if (this.zzc != zZza) {
                        this.zzc = zZza;
                        zzktVar.zzaz().zzp(new Worker.AnonymousClass1(this, zZza));
                    }
                }
                break;
        }
    }

    public synchronized void zza(Context context, IntentFilter intentFilter) {
        try {
            if (this.zzb) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.zzb = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void zzc() {
        zzkt zzktVar = (zzkt) this.zza;
        zzktVar.zzB$1();
        zzktVar.zzaz().zzg();
        zzktVar.zzaz().zzg();
        if (this.zzb) {
            zzktVar.zzay().zzl.zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                zzktVar.zzn.zze.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzktVar.zzay().zzd.zzb(e, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    public void zzd(Bundle bundle, BillingResult billingResult, int i) {
        byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
        zzo zzoVar = (zzo) this.zza;
        if (byteArray == null) {
            ((RoomOpenHelper) zzoVar.zze).zza(zzcb.zza(23, i, billingResult));
            return;
        }
        try {
            ((RoomOpenHelper) zzoVar.zze).zza(zzga.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzcd.zza()));
        } catch (Throwable unused) {
            zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    public zzn(zzkt zzktVar) {
        zzah.checkNotNull(zzktVar);
        this.zza = zzktVar;
    }
}
