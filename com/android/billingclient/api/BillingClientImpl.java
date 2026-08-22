package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.RunnerActivity;
import com.google.android.gms.ads.zza;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzgz;
import com.google.android.gms.internal.play_billing.zzhb;
import com.google.android.gms.internal.play_billing.zzs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingClientImpl extends BillingClient {
    public final boolean zzA;
    public ExecutorService zzB;
    public volatile int zza;
    public final String zzb;
    public final Handler zzc;
    public volatile zzo zzd;
    public final Context zze;
    public final RoomOpenHelper zzf;
    public volatile zzs zzg;
    public volatile zzbc zzh;
    public boolean zzi;
    public boolean zzj;
    public int zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public boolean zzr;
    public boolean zzs;
    public boolean zzt;
    public boolean zzu;
    public boolean zzv;
    public boolean zzw;
    public boolean zzx;
    public boolean zzy;
    public final InputMergerFactory$1 zzz;

    public BillingClientImpl(InputMergerFactory$1 inputMergerFactory$1, Context context, GooglePlayBillingService.YYPurchasesUpdatedListener yYPurchasesUpdatedListener) {
        String str;
        try {
            str = (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            str = wsbWxekY.ctbhQeXLPtYLbY;
        }
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        this.zze = context.getApplicationContext();
        zzgt zzgtVarZzy = zzgu.zzy();
        zzgtVarZzy.zzn(str);
        zzgtVarZzy.zzm(this.zze.getPackageName());
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this.zze, (zzgu) zzgtVarZzy.zzf());
        this.zzf = roomOpenHelper;
        Context context2 = this.zze;
        zzo zzoVar = new zzo();
        zzoVar.zza = context2;
        zzoVar.zzb = yYPurchasesUpdatedListener;
        zzoVar.zze = roomOpenHelper;
        zzoVar.zzf = new zzn(zzoVar, true);
        zzoVar.zzg = new zzn(zzoVar, false);
        this.zzd = zzoVar;
        this.zzz = inputMergerFactory$1;
        this.zzA = false;
        this.zze.getPackageName();
    }

    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(RoomOpenHelper roomOpenHelper, SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzce.zzm;
            zzap(zzcb.zza(2, 8, billingResult));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult, null);
            return;
        }
        String str = (String) roomOpenHelper.mConfiguration;
        ArrayList arrayList = (ArrayList) roomOpenHelper.mDelegate;
        if (TextUtils.isEmpty(str)) {
            zzb.zzk("BillingClient", "Please fix the input params. SKU type can't be empty.");
            BillingResult billingResult2 = zzce.zzf;
            zzap(zzcb.zza(49, 8, billingResult2));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult2, null);
            return;
        }
        if (zzao(new zzac(this, str, arrayList, skuDetailsResponseListener), 30000L, new zza(this, skuDetailsResponseListener, 12), zzaj()) == null) {
            BillingResult billingResultZzal = zzal();
            zzap(zzcb.zza(25, 8, billingResultZzal));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResultZzal, null);
        }
    }

    public final Handler zzaj() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    public final void zzak(BillingResult billingResult) {
        if (Thread.interrupted()) {
            return;
        }
        this.zzc.post(new zza(this, billingResult, 14));
    }

    public final BillingResult zzal() {
        return (this.zza == 0 || this.zza == 3) ? zzce.zzm : zzce.zzj;
    }

    public final Future zzao(Callable callable, long j, Runnable runnable, Handler handler) {
        if (this.zzB == null) {
            this.zzB = Executors.newFixedThreadPool(zzb.zza, new zzat());
        }
        try {
            Future futureSubmit = this.zzB.submit(callable);
            handler.postDelayed(new zza(futureSubmit, runnable, 16), (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            zzb.zzl("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public final void zzap(zzga zzgaVar) {
        RoomOpenHelper roomOpenHelper = this.zzf;
        int i = this.zzk;
        roomOpenHelper.getClass();
        try {
            zzgt zzgtVar = (zzgt) ((zzgu) roomOpenHelper.mConfiguration).zzi();
            zzgtVar.zzl(i);
            roomOpenHelper.mConfiguration = (zzgu) zzgtVar.zzf();
            roomOpenHelper.zza(zzgaVar);
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    public final void zzaq(zzge zzgeVar) {
        RoomOpenHelper roomOpenHelper = this.zzf;
        int i = this.zzk;
        roomOpenHelper.getClass();
        try {
            zzgt zzgtVar = (zzgt) ((zzgu) roomOpenHelper.mConfiguration).zzi();
            zzgtVar.zzl(i);
            roomOpenHelper.mConfiguration = (zzgu) zzgtVar.zzf();
            roomOpenHelper.zzc(zzgeVar);
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    public final void zzau(int i, int i2, BillingResult billingResult) {
        zzge zzgeVar = null;
        zzga zzgaVar = null;
        if (billingResult.zza == 0) {
            int i3 = zzcb.$r8$clinit;
            try {
                zzgd zzgdVarZzy = zzge.zzy();
                zzgdVarZzy.zzm(5);
                zzgz zzgzVarZzy = zzhb.zzy();
                zzgzVarZzy.zzl(i2);
                zzgdVarZzy.zzl((zzhb) zzgzVarZzy.zzf());
                zzgeVar = (zzge) zzgdVarZzy.zzf();
            } catch (Exception e) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", e);
            }
            zzaq(zzgeVar);
            return;
        }
        int i4 = zzcb.$r8$clinit;
        try {
            zzfz zzfzVarZzy = zzga.zzy();
            zzgg zzggVarZzy = zzgk.zzy();
            zzggVarZzy.zzn(billingResult.zza);
            zzggVarZzy.zzm(billingResult.zzb);
            zzggVarZzy.zzo(i);
            zzfzVarZzy.zzl(zzggVarZzy);
            zzfzVarZzy.zzn(5);
            zzgz zzgzVarZzy2 = zzhb.zzy();
            zzgzVarZzy2.zzl(i2);
            zzfzVarZzy.zzm((zzhb) zzgzVarZzy2.zzf());
            zzgaVar = (zzga) zzfzVarZzy.zzf();
        } catch (Exception e2) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e2);
        }
        zzap(zzgaVar);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(RunnerActivity runnerActivity, final BillingFlowParams billingFlowParams) {
        String str;
        Future futureZzao;
        int i;
        boolean z;
        String str2;
        zzai zzaiVar;
        SkuDetails skuDetails;
        String str3;
        String str4;
        String str5;
        boolean z2;
        String str6;
        String str7;
        int i2;
        final int i3;
        BillingClientImpl billingClientImpl = this;
        if (billingClientImpl.zzd == null || ((GooglePlayBillingService.YYPurchasesUpdatedListener) billingClientImpl.zzd.zzb) == null) {
            BillingResult billingResult = zzce.zzF;
            billingClientImpl.zzap(zzcb.zza(12, 2, billingResult));
            return billingResult;
        }
        if (!isReady()) {
            BillingResult billingResult2 = zzce.zzm;
            billingClientImpl.zzap(zzcb.zza(2, 2, billingResult2));
            billingClientImpl.zzak(billingResult2);
            return billingResult2;
        }
        ArrayList<SkuDetails> arrayList = new ArrayList();
        arrayList.addAll((ArrayList) billingFlowParams.zzf);
        zzai zzaiVar2 = (zzai) billingFlowParams.zze;
        SkuDetails skuDetails2 = (SkuDetails) zzan.zza(arrayList, null);
        if (zzan.zza(zzaiVar2, null) != null) {
            throw new ClassCastException();
        }
        skuDetails2.getClass();
        String sku = skuDetails2.getSku();
        String type = skuDetails2.getType();
        String str8 = "BillingClient";
        if (type.equals(mnwSv.anHd) && !billingClientImpl.zzi) {
            zzb.zzk("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult3 = zzce.zzo;
            billingClientImpl.zzap(zzcb.zza(9, 2, billingResult3));
            billingClientImpl.zzak(billingResult3);
            return billingResult3;
        }
        BillingResult.Builder builder = (BillingResult.Builder) billingFlowParams.zzd;
        builder.getClass();
        if ((builder.zza != 0 || billingFlowParams.zza) && !billingClientImpl.zzl) {
            zzb.zzk("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult4 = zzce.zzh;
            billingClientImpl.zzap(zzcb.zza(18, 2, billingResult4));
            billingClientImpl.zzak(billingResult4);
            return billingResult4;
        }
        if (arrayList.size() > 1 && !billingClientImpl.zzs) {
            zzb.zzk("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult5 = zzce.zzt;
            billingClientImpl.zzap(zzcb.zza(19, 2, billingResult5));
            billingClientImpl.zzak(billingResult5);
            return billingResult5;
        }
        if (!zzaiVar2.isEmpty() && !billingClientImpl.zzt) {
            zzb.zzk("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            BillingResult billingResult6 = zzce.zzv;
            billingClientImpl.zzap(zzcb.zza(20, 2, billingResult6));
            billingClientImpl.zzak(billingResult6);
            return billingResult6;
        }
        if (billingClientImpl.zzl) {
            boolean z3 = billingClientImpl.zzn;
            billingClientImpl.zzz.getClass();
            billingClientImpl.zzz.getClass();
            boolean z4 = billingClientImpl.zzA;
            String str9 = billingClientImpl.zzb;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str9);
            int i4 = ((BillingResult.Builder) billingFlowParams.zzd).zza;
            if (i4 != 0) {
                bundle.putInt("prorationMode", i4);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("obfuscatedProfileId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(((BillingResult.Builder) billingFlowParams.zzd).zzb)) {
                bundle.putString("oldSkuPurchaseToken", ((BillingResult.Builder) billingFlowParams.zzd).zzb);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            ((BillingResult.Builder) billingFlowParams.zzd).getClass();
            if (!TextUtils.isEmpty(null)) {
                ((BillingResult.Builder) billingFlowParams.zzd).getClass();
                bundle.putString("originalExternalTransactionId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("paymentsPurchaseParams", null);
            }
            if (z3) {
                z = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z = true;
            }
            if (z4) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            String str10 = "additionalSkuTypes";
            if (arrayList.isEmpty()) {
                str2 = "proxyPackageVersion";
                zzaiVar = zzaiVar2;
                skuDetails = skuDetails2;
                str3 = sku;
                str4 = type;
                str5 = "BillingClient";
                z2 = true;
                ArrayList<String> arrayList2 = new ArrayList<>(zzaiVar.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(zzaiVar.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                if (zzaiVar.size() > 0) {
                    zzaiVar.get(0).getClass();
                    throw new ClassCastException();
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                ArrayList<String> arrayList8 = new ArrayList<>();
                str4 = type;
                ArrayList<String> arrayList9 = new ArrayList<>();
                str3 = sku;
                ArrayList<Integer> arrayList10 = new ArrayList<>();
                str2 = "proxyPackageVersion";
                ArrayList<String> arrayList11 = new ArrayList<>();
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                for (SkuDetails skuDetails3 : arrayList) {
                    String str11 = str8;
                    SkuDetails skuDetails4 = skuDetails2;
                    if (!skuDetails3.zzb.optString("skuDetailsToken").isEmpty()) {
                        arrayList7.add(skuDetails3.zzb.optString("skuDetailsToken"));
                    }
                    JSONObject jSONObject = skuDetails3.zzb;
                    String strOptString = jSONObject.optString("offerIdToken");
                    if (strOptString.isEmpty()) {
                        strOptString = jSONObject.optString("offer_id_token");
                    }
                    zzai zzaiVar3 = zzaiVar2;
                    String strOptString2 = skuDetails3.zzb.optString("offer_id");
                    String str12 = str10;
                    int iOptInt = skuDetails3.zzb.optInt("offer_type");
                    String strOptString3 = skuDetails3.zzb.optString("serializedDocid");
                    arrayList8.add(strOptString);
                    z5 |= !TextUtils.isEmpty(strOptString);
                    arrayList9.add(strOptString2);
                    z6 |= !TextUtils.isEmpty(strOptString2);
                    arrayList10.add(Integer.valueOf(iOptInt));
                    z7 |= iOptInt != 0;
                    z8 |= !TextUtils.isEmpty(strOptString3);
                    arrayList11.add(strOptString3);
                    skuDetails2 = skuDetails4;
                    str8 = str11;
                    zzaiVar2 = zzaiVar3;
                    str10 = str12;
                }
                zzaiVar = zzaiVar2;
                skuDetails = skuDetails2;
                String str13 = str10;
                str5 = str8;
                if (!arrayList7.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (z5) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList8);
                }
                if (z6) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList9);
                }
                if (z7) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList10);
                }
                if (z8) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList11);
                }
                z2 = true;
                if (arrayList.size() > 1) {
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayList.size() - 1);
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayList.size() - 1);
                    for (int i5 = 1; i5 < arrayList.size(); i5++) {
                        arrayList12.add(((SkuDetails) arrayList.get(i5)).getSku());
                        arrayList13.add(((SkuDetails) arrayList.get(i5)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList12);
                    bundle.putStringArrayList(str13, arrayList13);
                }
            }
            billingClientImpl = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !billingClientImpl.zzq) {
                BillingResult billingResult7 = zzce.zzu;
                billingClientImpl.zzap(zzcb.zza(21, 2, billingResult7));
                billingClientImpl.zzak(billingResult7);
                return billingResult7;
            }
            SkuDetails skuDetails5 = skuDetails;
            if (TextUtils.isEmpty(skuDetails5.zzb.optString("packageName"))) {
                str6 = null;
                z2 = false;
            } else {
                bundle.putString("skuPackageName", skuDetails5.zzb.optString("packageName"));
                str6 = null;
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("accountName", str6);
            }
            Intent intent = runnerActivity.getIntent();
            if (intent == null) {
                str = str5;
                zzb.zzk(str, "Activity's intent is null.");
            } else {
                str = str5;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        str7 = str2;
                        try {
                            bundle.putString(str7, billingClientImpl.zze.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                        } catch (PackageManager.NameNotFoundException unused) {
                            bundle.putString(str7, "package not found");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str7 = str2;
                    }
                }
            }
            if (billingClientImpl.zzt && !zzaiVar.isEmpty()) {
                i2 = 17;
            } else if (billingClientImpl.zzr && z2) {
                i2 = 15;
            } else {
                if (billingClientImpl.zzn) {
                    i3 = 9;
                } else {
                    i2 = 6;
                }
                final String str14 = str3;
                final String str15 = str4;
                futureZzao = zzao(new Callable(i3, str14, str15, billingFlowParams, bundle) { // from class: com.android.billingclient.api.zzas
                    public final /* synthetic */ int zzb;
                    public final /* synthetic */ String zzc;
                    public final /* synthetic */ String zzd;
                    public final /* synthetic */ Bundle zzf;

                    {
                        this.zzf = bundle;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        BillingClientImpl billingClientImpl2 = this.zza;
                        return billingClientImpl2.zzg.zzg(this.zzb, billingClientImpl2.zze.getPackageName(), this.zzc, this.zzd, null, this.zzf);
                    }
                }, 5000L, null, billingClientImpl.zzc);
                i = 78;
            }
            i3 = i2;
            final String str16 = str3;
            final String str17 = str4;
            futureZzao = zzao(new Callable(i3, str16, str17, billingFlowParams, bundle) { // from class: com.android.billingclient.api.zzas
                public final /* synthetic */ int zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ String zzd;
                public final /* synthetic */ Bundle zzf;

                {
                    this.zzf = bundle;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl billingClientImpl2 = this.zza;
                    return billingClientImpl2.zzg.zzg(this.zzb, billingClientImpl2.zze.getPackageName(), this.zzc, this.zzd, null, this.zzf);
                }
            }, 5000L, null, billingClientImpl.zzc);
            i = 78;
        } else {
            str = "BillingClient";
            futureZzao = zzao(new zzr(billingClientImpl, sku, type, 0), 5000L, null, billingClientImpl.zzc);
            i = 80;
        }
        try {
            if (futureZzao == null) {
                BillingResult billingResult8 = zzce.zzm;
                billingClientImpl.zzap(zzcb.zza(25, 2, billingResult8));
                billingClientImpl.zzak(billingResult8);
                return billingResult8;
            }
            Bundle bundle2 = (Bundle) futureZzao.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = zzb.zzb(bundle2, str);
            String strZzg = zzb.zzg(bundle2, str);
            if (iZzb == 0) {
                Intent intent2 = new Intent(runnerActivity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                runnerActivity.startActivity(intent2);
                return zzce.zzl;
            }
            zzb.zzk(str, "Unable to buy item, Error response code: " + iZzb);
            BillingResult billingResultZza = zzce.zza(iZzb, strZzg);
            if (bundle2 != null) {
                i = 23;
            }
            billingClientImpl.zzap(zzcb.zza(i, 2, billingResultZza));
            billingClientImpl.zzak(billingResultZza);
            return billingResultZza;
        } catch (CancellationException e) {
            e = e;
            zzb.zzl(str, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult9 = zzce.zzn;
            billingClientImpl.zzap(zzcb.zza(4, 2, billingResult9));
            billingClientImpl.zzak(billingResult9);
            return billingResult9;
        } catch (TimeoutException e2) {
            e = e2;
            zzb.zzl(str, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult10 = zzce.zzn;
            billingClientImpl.zzap(zzcb.zza(4, 2, billingResult10));
            billingClientImpl.zzak(billingResult10);
            return billingResult10;
        } catch (Exception e3) {
            zzb.zzl(str, "Exception while launching billing flow. Try to reconnect", e3);
            BillingResult billingResult11 = zzce.zzm;
            billingClientImpl.zzap(zzcb.zza(5, 2, billingResult11));
            billingClientImpl.zzak(billingResult11);
            return billingResult11;
        }
    }
}
