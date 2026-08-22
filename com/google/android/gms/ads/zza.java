package com.google.android.gms.ads;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbsActionBarView$VisibilityAnimListener;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.app.ActivityRecreator;
import androidx.core.provider.FontRequestWorker;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransitionCompat21;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.android.billingclient.api.zzbc;
import com.android.billingclient.api.zzcb;
import com.android.billingclient.api.zzce;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.RunnerActivity;
import com.daerisoft.thespikerm.RunnerKeyboardController;
import com.daerisoft.thespikerm.RunnerKeyboardController.KeyboardInputEditText;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zzc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbk;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbm;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzdny;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzdg;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzea;
import com.google.android.gms.measurement.internal.zzef;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzg;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.measurement.internal.zzs;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.inject.PVS.jIKWv;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.CloseableKt;
import okhttp3.internal.http1.HeadersReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final Object zzb;

    public zza(zzbc zzbcVar, zzbr zzbrVar, zzbc zzbcVar2) {
        this.$r8$classId = 28;
        this.zzb = zzbcVar;
        this.zza = zzbrVar;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:104:0x02e6 A[Catch: NotFoundException -> 0x02eb, TRY_LEAVE, TryCatch #5 {NotFoundException -> 0x02eb, blocks: (B:101:0x02d4, B:104:0x02e6), top: B:400:0x02d4 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:112:0x0302  */
    /* JADX WARN: Code duplicated, block: B:113:0x030d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0317  */
    /* JADX WARN: Code duplicated, block: B:119:0x032b  */
    /* JADX WARN: Code duplicated, block: B:121:0x032f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0336  */
    /* JADX WARN: Code duplicated, block: B:125:0x0369  */
    /* JADX WARN: Code duplicated, block: B:127:0x036f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0371  */
    /* JADX WARN: Code duplicated, block: B:130:0x0381  */
    /* JADX WARN: Code duplicated, block: B:131:0x038a  */
    /* JADX WARN: Code duplicated, block: B:134:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:138:0x0403  */
    /* JADX WARN: Code duplicated, block: B:142:0x040f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0416 A[PHI: r3
  0x0416: PHI (r3v66 com.google.android.gms.measurement.internal.zzew) = (r3v64 com.google.android.gms.measurement.internal.zzew), (r3v67 com.google.android.gms.measurement.internal.zzew) binds: [B:141:0x040d, B:139:0x0406] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:145:0x0426 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x043e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0440  */
    /* JADX WARN: Code duplicated, block: B:157:0x044e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:166:0x046b  */
    /* JADX WARN: Code duplicated, block: B:169:0x0484  */
    /* JADX WARN: Code duplicated, block: B:172:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:177:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:179:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:181:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:184:0x04df  */
    /* JADX WARN: Code duplicated, block: B:187:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:191:0x0501  */
    /* JADX WARN: Code duplicated, block: B:194:0x0511  */
    /* JADX WARN: Code duplicated, block: B:196:0x0527  */
    /* JADX WARN: Code duplicated, block: B:198:0x0539  */
    /* JADX WARN: Code duplicated, block: B:201:0x0549  */
    /* JADX WARN: Code duplicated, block: B:202:0x054d  */
    /* JADX WARN: Code duplicated, block: B:204:0x0582  */
    /* JADX WARN: Code duplicated, block: B:206:0x059e  */
    /* JADX WARN: Code duplicated, block: B:207:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:210:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:215:0x0629  */
    /* JADX WARN: Code duplicated, block: B:218:0x0645  */
    /* JADX WARN: Code duplicated, block: B:226:0x0682  */
    /* JADX WARN: Code duplicated, block: B:228:0x0691  */
    /* JADX WARN: Code duplicated, block: B:230:0x0699  */
    /* JADX WARN: Code duplicated, block: B:231:0x069b  */
    /* JADX WARN: Code duplicated, block: B:233:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:237:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:35:0x0163 A[Catch: NameNotFoundException -> 0x0182, TryCatch #12 {NameNotFoundException -> 0x0182, blocks: (B:33:0x0158, B:35:0x0163, B:37:0x016f), top: B:412:0x0158 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x016f A[Catch: NameNotFoundException -> 0x0182, TRY_LEAVE, TryCatch #12 {NameNotFoundException -> 0x0182, blocks: (B:33:0x0158, B:35:0x0163, B:37:0x016f), top: B:412:0x0158 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0174  */
    /* JADX WARN: Code duplicated, block: B:400:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:424:0x032b A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        zzfda zzfdaVar;
        zzew zzewVar;
        zzgu zzguVar;
        zzlb zzlbVar;
        String string;
        PackageInfo packageInfo;
        CharSequence applicationLabel;
        String str;
        Integer numValueOf;
        String[] stringArray;
        List listAsList;
        zzeh zzehVar;
        zzef zzefVar;
        String strZzl;
        int i;
        AtomicInteger atomicInteger;
        zzai zzaiVarZzc;
        int i2;
        Boolean boolZzk;
        Boolean boolZzk2;
        long j;
        zzhx zzhxVar;
        zzew zzewVar2;
        zzai zzaiVar;
        zzes zzesVar;
        zzs zzsVar;
        zzlb zzlbVar2;
        boolean zIsEmpty;
        BillingFlowParams billingFlowParams;
        String strZzm;
        String string2;
        String str2;
        Boolean boolValueOf;
        boolean zZzJ;
        SharedPreferences sharedPreferences;
        boolean zContains;
        zzdy zzdyVarZzh;
        zzdy zzdyVarZzh2;
        zzlb zzlbVar3;
        Context context;
        boolean zEquals;
        Iterator it;
        String str3;
        zzlb zzlbVar4;
        String string3;
        switch (this.$r8$classId) {
            case 0:
                AdLoader adLoader = (AdLoader) this.zza;
                try {
                    adLoader.zzc.zzg(zzq.zza(adLoader.zzb, (zzek) this.zzb));
                    return;
                } catch (RemoteException e) {
                    zzo.zzh("Failed to load ad.", e);
                    return;
                }
            case 1:
                ((ActivityRecreator.LifecycleCheckCallbacks) this.zza).currentlyRecreatingToken = this.zzb;
                return;
            case 2:
                ((Application) this.zza).unregisterActivityLifecycleCallbacks((ActivityRecreator.LifecycleCheckCallbacks) this.zzb);
                return;
            case 3:
                try {
                    Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                    Object obj = this.zzb;
                    Object obj2 = this.zza;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e2) {
                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                        throw e2;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 4:
                AppCompatTextHelper.AnonymousClass1 anonymousClass1 = (AppCompatTextHelper.AnonymousClass1) ((AccessTokenCache) this.zza).sharedPreferences;
                if (anonymousClass1 != null) {
                    anonymousClass1.onFontRetrieved((Typeface) this.zzb);
                    return;
                }
                return;
            case 5:
                ((FontRequestWorker.AnonymousClass2) this.zza).accept(this.zzb);
                return;
            case 6:
                FragmentTransitionCompat21.getBoundsOnScreen((View) this.zza, (Rect) this.zzb);
                return;
            case 7:
                ((DefaultSpecialEffectsController.TransitionInfo) this.zza).completeSpecialEffect();
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((SpecialEffectsController$FragmentStateManagerOperation) this.zzb) + "has completed");
                    return;
                }
                return;
            case 8:
                Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                String str4 = DelayedWorkTracker.TAG;
                WorkSpec workSpec = (WorkSpec) this.zza;
                logger$LogcatLogger.debug(str4, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Scheduling work ", workSpec.id), new Throwable[0]);
                ((DelayedWorkTracker) this.zzb).mGreedyScheduler.schedule(workSpec);
                return;
            case 9:
                for (ConstraintController constraintController : (ArrayList) this.zza) {
                    Object obj3 = ((ConstraintTracker) this.zzb).mCurrentState;
                    constraintController.mCurrentValue = obj3;
                    constraintController.updateCallback(constraintController.mCallback, obj3);
                }
                return;
            case 10:
                SerialExecutor serialExecutor = (SerialExecutor) this.zza;
                try {
                    ((Runnable) this.zzb).run();
                    return;
                } finally {
                    serialExecutor.scheduleNext();
                }
            case 11:
                synchronized (((ConstraintTrackingWorker) this.zzb).mLock) {
                    if (((ConstraintTrackingWorker) this.zzb).mAreConstraintsUnmet) {
                        ((ConstraintTrackingWorker) this.zzb).mFuture.set(new ListenableWorker.Result.Retry());
                    } else {
                        ((ConstraintTrackingWorker) this.zzb).mFuture.setFuture((ListenableFuture) this.zza);
                    }
                    break;
                }
                return;
            case 12:
                BillingClientImpl billingClientImpl = (BillingClientImpl) this.zza;
                billingClientImpl.getClass();
                BillingResult billingResult = zzce.zzn;
                billingClientImpl.zzap(zzcb.zza(24, 8, billingResult));
                ((SkuDetailsResponseListener) this.zzb).onSkuDetailsResponse(billingResult, null);
                return;
            case 13:
                BillingClientImpl billingClientImpl2 = (BillingClientImpl) this.zza;
                billingClientImpl2.getClass();
                billingClientImpl2.zzap(zzcb.zza(24, 9, zzce.zzn));
                ((RoomOpenHelper) this.zzb).onQueryPurchasesResponse(com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            case 14:
                BillingClientImpl billingClientImpl3 = (BillingClientImpl) this.zza;
                BillingResult billingResult2 = (BillingResult) this.zzb;
                if (((GooglePlayBillingService.YYPurchasesUpdatedListener) billingClientImpl3.zzd.zzb) != null) {
                    ((GooglePlayBillingService.YYPurchasesUpdatedListener) billingClientImpl3.zzd.zzb).onPurchasesUpdated(billingResult2, null);
                    return;
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
                    return;
                }
            case 15:
                BillingClientImpl billingClientImpl4 = (BillingClientImpl) this.zza;
                billingClientImpl4.getClass();
                BillingResult billingResult3 = zzce.zzn;
                billingClientImpl4.zzap(zzcb.zza(24, 3, billingResult3));
                ((ProfileCache) this.zzb).onAcknowledgePurchaseResponse(billingResult3);
                return;
            case 16:
                Future future = (Future) this.zza;
                if (future.isDone() || future.isCancelled()) {
                    return;
                }
                future.cancel(true);
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                Runnable runnable = (Runnable) this.zzb;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 17:
                RoomOpenHelper roomOpenHelper = new RoomOpenHelper(17);
                AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener = new AbsActionBarView$VisibilityAnimListener();
                absActionBarView$VisibilityAnimListener.mFinalVisibility = 0;
                absActionBarView$VisibilityAnimListener.mCanceled = true;
                roomOpenHelper.mDelegate = absActionBarView$VisibilityAnimListener;
                SkuDetails skuDetails = (SkuDetails) this.zza;
                ArrayList arrayList = new ArrayList();
                arrayList.add(skuDetails);
                roomOpenHelper.mConfiguration = arrayList;
                ((GooglePlayBillingService) this.zzb).m_billingClient.launchBillingFlow(RunnerActivity.CurrentActivity, roomOpenHelper.build());
                return;
            case 18:
                RunnerKeyboardController runnerKeyboardController = (RunnerKeyboardController) this.zzb;
                RunnerKeyboardController.KeyboardInputEditText keyboardInputEditText = runnerKeyboardController.new KeyboardInputEditText(runnerKeyboardController.m_context, (RunnerKeyboardController) this.zza);
                runnerKeyboardController.m_editText = keyboardInputEditText;
                keyboardInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.daerisoft.thespikerm.RunnerKeyboardController$1$1
                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable editable) {
                    }

                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                        zza zzaVar = this.this$1;
                        RunnerKeyboardController runnerKeyboardController2 = (RunnerKeyboardController) zzaVar.zzb;
                        if (runnerKeyboardController2.m_setTextHandlerEnabled) {
                            if (runnerKeyboardController2.m_bufferedTextInput) {
                                String string4 = charSequence.toString();
                                if (string4.length() == 0) {
                                    RunnerJNILib.OnVirtualKeyboardTextInserted(new int[]{0}, 0);
                                    return;
                                } else {
                                    int[] iArrGetStringCodepoints = RunnerKeyboardController.GetStringCodepoints(string4);
                                    RunnerJNILib.OnVirtualKeyboardTextInserted(iArrGetStringCodepoints, iArrGetStringCodepoints.length);
                                    return;
                                }
                            }
                            int[] iArrGetStringCodepoints2 = RunnerKeyboardController.GetStringCodepoints(charSequence.toString());
                            for (int i6 = 0; i6 < iArrGetStringCodepoints2.length; i6++) {
                                RunnerJNILib.KeyEvent(0, 0, iArrGetStringCodepoints2[i6], 4355, 0);
                                RunnerJNILib.KeyEvent(1, 0, iArrGetStringCodepoints2[i6], 4355, 0);
                            }
                            ((RunnerKeyboardController) zzaVar.zzb).SetInputString("");
                        }
                    }
                });
                runnerKeyboardController.m_editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.daerisoft.thespikerm.RunnerKeyboardController$1$2
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                        RunnerJNILib.KeyEvent(0, 66, 13, 4355, 0);
                        RunnerJNILib.KeyEvent(1, 66, 13, 4355, 0);
                        zza zzaVar = this.this$1;
                        if (((RunnerKeyboardController) zzaVar.zzb).m_bufferedTextInput) {
                            StringBuilder sb = new StringBuilder();
                            RunnerKeyboardController runnerKeyboardController2 = (RunnerKeyboardController) zzaVar.zzb;
                            sb.append(runnerKeyboardController2.m_editText.getText().toString());
                            sb.append("\n");
                            String string4 = sb.toString();
                            runnerKeyboardController2.m_editText.setText(string4);
                            runnerKeyboardController2.m_editText.setSelection(string4.length());
                            int[] iArrGetStringCodepoints = RunnerKeyboardController.GetStringCodepoints(string4);
                            RunnerJNILib.OnVirtualKeyboardTextInserted(iArrGetStringCodepoints, iArrGetStringCodepoints.length);
                        }
                        return true;
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                layoutParams.leftMargin = -1;
                layoutParams.topMargin = -1;
                runnerKeyboardController.m_editText.setLayoutParams(layoutParams);
                runnerKeyboardController.m_editText.setFocusable(true);
                runnerKeyboardController.m_editText.setFocusableInTouchMode(true);
                runnerKeyboardController.m_editText.setSingleLine(true);
                runnerKeyboardController.m_editText.setBackgroundColor(0);
                runnerKeyboardController.m_editText.setTextColor(0);
                runnerKeyboardController.m_editText.setCursorVisible(false);
                ViewGroup viewGroup = (ViewGroup) runnerKeyboardController.m_activityView;
                viewGroup.setDescendantFocusability(131072);
                viewGroup.setFocusableInTouchMode(true);
                viewGroup.addView(runnerKeyboardController.m_editText);
                runnerKeyboardController.SetInputString(new int[]{0});
                return;
            case 19:
                ((zzen) this.zza).zzm.addView((View) ObjectWrapper.unwrap((IObjectWrapper) this.zzb));
                return;
            case 20:
                ((zzm) ((zzc) this.zza).zza).zzb.getWindow().setBackgroundDrawable((BitmapDrawable) this.zzb);
                return;
            case 21:
                run$com$google$android$gms$ads$internal$util$zzi();
                return;
            case 22:
                zzv.zza.zzl.getClass();
                HeadersReader.zzf((zzdsj) this.zza, "cld_r", SystemClock.elapsedRealtime() - ((Long) this.zzb).longValue());
                return;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                zzdny zzdnyVar = ((zzdny[]) this.zzb)[0];
                if (zzdnyVar != null) {
                    ((zzau) this.zza).zzj.zzb(zzgdn.zzh(zzdnyVar));
                    return;
                }
                return;
            case 24:
                run$com$google$android$gms$ads$nonagon$signalgeneration$zzbl();
                return;
            case 25:
                TaggingLibraryJsInterface taggingLibraryJsInterface = (TaggingLibraryJsInterface) this.zza;
                Uri uriZza = Uri.parse((String) this.zzb);
                try {
                    uriZza = (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzmu)).booleanValue() || (zzfdaVar = taggingLibraryJsInterface.zzd) == null) ? taggingLibraryJsInterface.zzc.zza(uriZza, taggingLibraryJsInterface.zza, taggingLibraryJsInterface.zzb, null) : zzfdaVar.zza(uriZza, taggingLibraryJsInterface.zza, taggingLibraryJsInterface.zzb, null);
                    break;
                } catch (zzavv e3) {
                    int i3 = zze.$r8$clinit;
                    zzo.zzf("Failed to append the click signal to URL: ", e3);
                    zzv.zza.zzi.zzw(e3, "TaggingLibraryJsInterface.recordClick");
                }
                taggingLibraryJsInterface.zzi.zzd(uriZza.toString(), null, null, null);
                return;
            case 26:
                BaseAdView baseAdView = (BaseAdView) this.zza;
                try {
                    baseAdView.zza.zzn(((AdRequest) this.zzb).zza);
                    return;
                } catch (IllegalStateException e4) {
                    zzbun.zza(baseAdView.getContext()).zzh(e4, "BaseAdView.loadAd");
                    return;
                }
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                ((zzgm) this.zza).zzaw();
                if (zzdg.zza()) {
                    ((zzgm) this.zza).zzaz().zzp(this);
                    return;
                }
                boolean z = ((zzap) this.zzb).zzd != 0;
                ((zzap) this.zzb).zzd = 0L;
                if (z) {
                    ((zzap) this.zzb).zzc();
                    return;
                }
                return;
            case 28:
                zzbc zzbcVar = (zzbc) this.zzb;
                zzs zzsVar2 = (zzs) zzbcVar.zza;
                zzbr zzbrVar = (zzbr) this.zza;
                zzfr zzfrVar = zzsVar2.zza;
                zzfo zzfoVar = zzfrVar.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzg();
                Bundle bundle = new Bundle();
                bundle.putString("package_name", (String) zzbcVar.zzb);
                try {
                    if (zzbrVar.zzd(bundle) == null) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zza(oKjScaD.gPr);
                    }
                    break;
                } catch (Exception e5) {
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(e5.getMessage(), "Exception occurred while retrieving the Install Referrer");
                }
                zzfo zzfoVar2 = zzfrVar.zzn;
                zzfr.zzR(zzfoVar2);
                zzfoVar2.zzg();
                throw new IllegalStateException("Unexpected call on client side");
            default:
                zzfr zzfrVar2 = (zzfr) this.zzb;
                zzfo zzfoVar3 = zzfrVar2.zzn;
                zzfr.zzR(zzfoVar3);
                zzfoVar3.zzg();
                zzag zzagVar = zzfrVar2.zzk;
                ((zzfr) zzagVar.mBuilder).getClass();
                zzaq zzaqVar = new zzaq(zzfrVar2);
                zzaqVar.zzv();
                zzfrVar2.zzz = zzaqVar;
                zzgu zzguVar2 = (zzgu) this.zza;
                zzdy zzdyVar = new zzdy(zzfrVar2, zzguVar2.zzf);
                zzdyVar.zzb$1();
                zzfrVar2.zzA = zzdyVar;
                zzea zzeaVar = new zzea(zzfrVar2);
                zzeaVar.zzb$1();
                zzfrVar2.zzx = zzeaVar;
                zzjm zzjmVar = new zzjm(zzfrVar2);
                zzjmVar.zzb$1();
                zzfrVar2.zzy = zzjmVar;
                zzlb zzlbVar5 = zzfrVar2.zzp;
                if (zzlbVar5.zza) {
                    throw new IllegalStateException("Can't initialize twice");
                }
                zzlbVar5.zzg();
                SecureRandom secureRandom = new SecureRandom();
                long jNextLong = secureRandom.nextLong();
                if (jNextLong == 0) {
                    jNextLong = secureRandom.nextLong();
                    if (jNextLong == 0) {
                        zzeh zzehVar4 = ((zzfr) zzlbVar5.mBuilder).zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzg.zza("Utils falling back to Random for random id");
                    }
                }
                zzlbVar5.zzd.set(jNextLong);
                zzfr zzfrVar3 = (zzfr) zzlbVar5.mBuilder;
                zzfrVar3.zzB$1();
                zzlbVar5.zza = true;
                zzew zzewVar3 = zzfrVar2.zzl;
                if (zzewVar3.zza) {
                    throw new IllegalStateException("Can't initialize twice");
                }
                SharedPreferences sharedPreferences2 = ((zzfr) zzewVar3.mBuilder).zze.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzewVar3.zzu = sharedPreferences2;
                boolean z2 = sharedPreferences2.getBoolean("has_been_opened", false);
                zzewVar3.zzl = z2;
                if (!z2) {
                    SharedPreferences.Editor editorEdit = zzewVar3.zzu.edit();
                    editorEdit.putBoolean("has_been_opened", true);
                    editorEdit.apply();
                }
                zzewVar3.zzb = new zzeu(zzewVar3, Math.max(0L, ((Long) zzdu.zzb.zza(null)).longValue()));
                ((zzfr) zzewVar3.mBuilder).zzB$1();
                zzewVar3.zza = true;
                zzdy zzdyVar2 = zzfrVar2.zzA;
                if (((zzf) zzdyVar2).zza) {
                    throw new IllegalStateException("Can't initialize twice");
                }
                zzfr zzfrVar4 = (zzfr) zzdyVar2.mBuilder;
                Context context2 = zzfrVar4.zze;
                String strZza = zzfrVar4.zzw;
                String packageName = context2.getPackageName();
                Context context3 = zzfrVar4.zze;
                PackageManager packageManager = context3.getPackageManager();
                zzeh zzehVar5 = zzfrVar4.zzm;
                int i4 = Integer.MIN_VALUE;
                String str5 = "Unknown";
                String installerPackageName = "unknown";
                if (packageManager != null) {
                    zzewVar = zzewVar3;
                    zzguVar = zzguVar2;
                    zzlbVar = zzlbVar5;
                    try {
                        installerPackageName = packageManager.getInstallerPackageName(packageName);
                    } catch (IllegalArgumentException unused) {
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzd.zzb(zzeh.zzn(packageName), "Error retrieving app installer package name. appId");
                    }
                    String str6 = installerPackageName;
                    try {
                        if (str6 == null) {
                            str6 = "manual_install";
                        } else {
                            if ("com.android.vending".equals(str6)) {
                                installerPackageName = "";
                            }
                            packageInfo = packageManager.getPackageInfo(context3.getPackageName(), 0);
                            if (packageInfo != null) {
                                applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                                if (!TextUtils.isEmpty(applicationLabel)) {
                                    string = applicationLabel.toString();
                                } else {
                                    string = str5;
                                }
                                try {
                                    str = packageInfo.versionName;
                                    try {
                                        i4 = packageInfo.versionCode;
                                        str5 = str;
                                    } catch (PackageManager.NameNotFoundException unused2) {
                                        str5 = str;
                                        zzfr.zzR(zzehVar5);
                                        zzehVar5.zzd.zzc(zzeh.zzn(packageName), "Error retrieving package info. appId, appName", string);
                                    }
                                } catch (PackageManager.NameNotFoundException unused3) {
                                }
                            }
                        }
                        packageInfo = packageManager.getPackageInfo(context3.getPackageName(), 0);
                        if (packageInfo != null) {
                            applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                string = applicationLabel.toString();
                            } else {
                                string = str5;
                            }
                            str = packageInfo.versionName;
                            i4 = packageInfo.versionCode;
                            str5 = str;
                        }
                    } catch (PackageManager.NameNotFoundException unused4) {
                        string = str5;
                    }
                    installerPackageName = str6;
                    break;
                } else {
                    zzfr.zzR(zzehVar5);
                    zzlbVar = zzlbVar5;
                    zzewVar = zzewVar3;
                    zzguVar = zzguVar2;
                    zzehVar5.zzd.zzb(zzeh.zzn(packageName), "PackageManager is null, app identity information might be inaccurate. appId");
                }
                int i5 = i4;
                String str7 = str5;
                String str8 = installerPackageName;
                zzdyVar2.zza = packageName;
                zzdyVar2.zzd = str8;
                zzdyVar2.zzb = str7;
                zzdyVar2.zzc = i5;
                zzdyVar2.zzf = 0L;
                String str9 = zzfrVar4.zzf;
                boolean z3 = !TextUtils.isEmpty(str9) && "am".equals(zzfrVar4.zzg);
                int iZza = zzfrVar4.zza();
                switch (iZza) {
                    case 0:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzl.zza("App measurement collection enabled");
                        break;
                    case 1:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzj.zza("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzl.zza("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzj.zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzj.zza("App measurement disabled via the manifest");
                        break;
                    case 5:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzl.zza("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzi.zza(jIKWv.eWGRMbaFUYffUX);
                        break;
                    case 7:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzj.zza("App measurement disabled via the global data collection setting");
                        break;
                    default:
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzj.zza("App measurement disabled due to denied storage consent");
                        break;
                }
                zzdyVar2.zzk = "";
                zzdyVar2.zzl = "";
                if (z3) {
                    zzdyVar2.zzl = str9;
                }
                try {
                    String strZzc = zzg.zzc(context3, strZza);
                    zzdyVar2.zzk = true != TextUtils.isEmpty(strZzc) ? strZzc : "";
                    if (!TextUtils.isEmpty(strZzc)) {
                        Resources resources = context3.getResources();
                        if (TextUtils.isEmpty(strZza)) {
                            strZza = zzg.zza(context3);
                        }
                        int identifier = resources.getIdentifier("admob_app_id", "string", strZza);
                        if (identifier == 0) {
                            string3 = null;
                        } else {
                            try {
                                string3 = resources.getString(identifier);
                            } catch (Resources.NotFoundException unused5) {
                                string3 = null;
                            }
                        }
                        zzdyVar2.zzl = string3;
                    }
                    if (iZza == 0) {
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzl.zzc(zzdyVar2.zza, "App measurement enabled for app package, google app id", TextUtils.isEmpty(zzdyVar2.zzk) ? zzdyVar2.zzl : zzdyVar2.zzk);
                    }
                    break;
                } catch (IllegalStateException e6) {
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzd.zzc(zzeh.zzn(packageName), "Fetching Google App Id failed with exception. appId", e6);
                }
                zzdyVar2.zzh = null;
                zzag zzagVar2 = zzfrVar4.zzk;
                zzagVar2.getClass();
                zzah.checkNotEmpty("analytics.safelisted_events");
                Bundle bundleZzj = zzagVar2.zzj();
                zzfr zzfrVar5 = (zzfr) zzagVar2.mBuilder;
                if (bundleZzj != null) {
                    if (bundleZzj.containsKey("analytics.safelisted_events")) {
                        numValueOf = Integer.valueOf(bundleZzj.getInt("analytics.safelisted_events"));
                    }
                    if (numValueOf != null) {
                        try {
                            stringArray = zzfrVar5.zze.getResources().getStringArray(numValueOf.intValue());
                            if (stringArray == null) {
                                listAsList = Arrays.asList(stringArray);
                            } else {
                                listAsList = null;
                            }
                        } catch (Resources.NotFoundException e7) {
                            zzeh zzehVar6 = zzfrVar5.zzm;
                            zzfr.zzR(zzehVar6);
                            zzehVar6.zzd.zzb(e7, "Failed to load string array from metadata: resource not found");
                        }
                        break;
                    } else {
                        listAsList = null;
                    }
                    if (listAsList != null) {
                        zzdyVar2.zzh = listAsList;
                    } else if (listAsList.isEmpty()) {
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzi.zza("Safelisted event list is empty. Ignoring");
                    } else {
                        it = listAsList.iterator();
                        do {
                            if (it.hasNext()) {
                                str3 = (String) it.next();
                                zzlbVar4 = zzfrVar4.zzp;
                                zzfr.zzP(zzlbVar4);
                            } else {
                                zzdyVar2.zzh = listAsList;
                            }
                        } while (zzlbVar4.zzab("safelisted event", str3));
                    }
                    if (packageManager != null) {
                        zzdyVar2.zzj = CloseableKt.isInstantApp(context3) ? 1 : 0;
                    } else {
                        zzdyVar2.zzj = 0;
                    }
                    zzfrVar4.zzB$1();
                    ((zzf) zzdyVar2).zza = true;
                    zzehVar = zzfrVar2.zzm;
                    zzfr.zzR(zzehVar);
                    zzagVar.zzh();
                    zzefVar = zzehVar.zzj;
                    zzefVar.zzb(74029L, "App measurement initialized, version");
                    zzfr.zzR(zzehVar);
                    zzefVar.zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
                    strZzl = zzdyVar.zzl();
                    if (TextUtils.isEmpty(zzfrVar2.zzf)) {
                        if (TextUtils.isEmpty(strZzl)) {
                            zEquals = false;
                        } else {
                            zEquals = zzfrVar3.zzk.zzB("debug.firebase.analytics.app").equals(strZzl);
                        }
                        if (zEquals) {
                            zzfr.zzR(zzehVar);
                            zzefVar.zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
                        } else {
                            zzfr.zzR(zzehVar);
                            zzefVar.zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strZzl)));
                        }
                    }
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Debug-level message logging enabled");
                    i = zzfrVar2.zzG;
                    atomicInteger = zzfrVar2.zzH;
                    if (i != atomicInteger.get()) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzc(Integer.valueOf(zzfrVar2.zzG), "Not all components initialized", Integer.valueOf(atomicInteger.get()));
                    }
                    zzfrVar2.zzB = true;
                    zzcl zzclVar = zzguVar.zzg;
                    zzfo zzfoVar4 = zzfrVar2.zzn;
                    zzfr.zzR(zzfoVar4);
                    zzfoVar4.zzg();
                    zzfr.zzP(zzewVar);
                    zzaiVarZzc = zzewVar.zzc();
                    zzewVar.zzg();
                    i2 = 100;
                    int i6 = zzewVar.zza().getInt("consent_source", 100);
                    Object obj4 = zzagVar.mBuilder;
                    boolZzk = zzagVar.zzk("google_analytics_default_allow_ad_storage");
                    boolZzk2 = zzagVar.zzk("google_analytics_default_allow_analytics_storage");
                    j = zzfrVar2.zzc;
                    zzhxVar = zzfrVar2.zzt;
                    if (boolZzk == null || boolZzk2 != null) {
                        zzewVar2 = zzewVar;
                        if (zzewVar2.zzl(-10)) {
                            zzaiVar = new zzai(boolZzk, boolZzk2);
                            i2 = -10;
                        }
                        if (zzaiVar != null) {
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzS(zzaiVar, i2, j);
                            zzaiVarZzc = zzaiVar;
                        }
                        zzfr.zzQ(zzhxVar);
                        zzhxVar.zzV(zzaiVarZzc);
                        zzesVar = zzewVar2.zzc;
                        if (zzesVar.zza() == 0) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzl.zzb(Long.valueOf(j), "Persisting first open");
                            zzesVar.zzb(j);
                        }
                        zzfr.zzQ(zzhxVar);
                        zzsVar = zzhxVar.zzb;
                        if (zzsVar.zzd() && zzsVar.zze()) {
                            zzew zzewVar4 = zzsVar.zza.zzl;
                            zzfr.zzP(zzewVar4);
                            zzewVar4.zzq.zzb(null);
                        }
                        if (!zzfrVar2.zzM()) {
                            zzlbVar2 = zzlbVar;
                            zIsEmpty = TextUtils.isEmpty(zzfrVar2.zzh().zzm());
                            billingFlowParams = zzewVar2.zze;
                            if (zIsEmpty) {
                                zzdyVarZzh2 = zzfrVar2.zzh();
                                zzdyVarZzh2.zza();
                                if (!TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                                    zzfr.zzP(zzlbVar2);
                                    strZzm = zzfrVar2.zzh().zzm();
                                    zzewVar2.zzg();
                                    string2 = zzewVar2.zza().getString("gmp_app_id", null);
                                    zzdy zzdyVarZzh3 = zzfrVar2.zzh();
                                    zzdyVarZzh3.zza();
                                    str2 = zzdyVarZzh3.zzl;
                                    zzewVar2.zzg();
                                    if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                        zzewVar2.zzg();
                                        zzewVar2.zzg();
                                        if (zzewVar2.zza().contains("measurement_enabled")) {
                                            boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                        } else {
                                            boolValueOf = null;
                                        }
                                        SharedPreferences.Editor editorEdit2 = zzewVar2.zza().edit();
                                        editorEdit2.clear();
                                        editorEdit2.apply();
                                        if (boolValueOf != null) {
                                            zzewVar2.zzg();
                                            SharedPreferences.Editor editorEdit3 = zzewVar2.zza().edit();
                                            editorEdit3.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                            editorEdit3.apply();
                                        }
                                        zzfrVar2.zzi().zzj();
                                        zzfrVar2.zzy.zzs$1();
                                        zzfrVar2.zzy.zzr();
                                        zzesVar.zzb(j);
                                        billingFlowParams.zzb(null);
                                    }
                                    String strZzm2 = zzfrVar2.zzh().zzm();
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit4 = zzewVar2.zza().edit();
                                    editorEdit4.putString("gmp_app_id", strZzm2);
                                    editorEdit4.apply();
                                    zzdy zzdyVarZzh4 = zzfrVar2.zzh();
                                    zzdyVarZzh4.zza();
                                    String str10 = zzdyVarZzh4.zzl;
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit5 = zzewVar2.zza().edit();
                                    editorEdit5.putString("admob_app_id", str10);
                                    editorEdit5.apply();
                                }
                            } else {
                                zzfr.zzP(zzlbVar2);
                                strZzm = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                string2 = zzewVar2.zza().getString("gmp_app_id", null);
                                zzdy zzdyVarZzh5 = zzfrVar2.zzh();
                                zzdyVarZzh5.zza();
                                str2 = zzdyVarZzh5.zzl;
                                zzewVar2.zzg();
                                if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                    zzewVar2.zzg();
                                    zzewVar2.zzg();
                                    if (zzewVar2.zza().contains("measurement_enabled")) {
                                        boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                    } else {
                                        boolValueOf = null;
                                    }
                                    SharedPreferences.Editor editorEdit6 = zzewVar2.zza().edit();
                                    editorEdit6.clear();
                                    editorEdit6.apply();
                                    if (boolValueOf != null) {
                                        zzewVar2.zzg();
                                        SharedPreferences.Editor editorEdit7 = zzewVar2.zza().edit();
                                        editorEdit7.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                        editorEdit7.apply();
                                    }
                                    zzfrVar2.zzi().zzj();
                                    zzfrVar2.zzy.zzs$1();
                                    zzfrVar2.zzy.zzr();
                                    zzesVar.zzb(j);
                                    billingFlowParams.zzb(null);
                                }
                                String strZzm3 = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit8 = zzewVar2.zza().edit();
                                editorEdit8.putString("gmp_app_id", strZzm3);
                                editorEdit8.apply();
                                zzdy zzdyVarZzh6 = zzfrVar2.zzh();
                                zzdyVarZzh6.zza();
                                String str11 = zzdyVarZzh6.zzl;
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit9 = zzewVar2.zza().edit();
                                editorEdit9.putString("admob_app_id", str11);
                                editorEdit9.apply();
                            }
                            if (!zzewVar2.zzc().zzi(com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE)) {
                                billingFlowParams.zzb(null);
                            }
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzg.set(billingFlowParams.zza());
                            zznw.zzc();
                            if (zzagVar.zzs(null, zzdu.zzac)) {
                                zzfr.zzP(zzlbVar2);
                                try {
                                    ((zzfr) zzlbVar2.mBuilder).zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                                } catch (ClassNotFoundException unused6) {
                                    BillingFlowParams billingFlowParams2 = zzewVar2.zzp;
                                    if (!TextUtils.isEmpty(billingFlowParams2.zza())) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzg.zza("Remote config removed with active feature rollouts");
                                        billingFlowParams2.zzb(null);
                                    }
                                }
                            }
                            if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                                zzdyVarZzh = zzfrVar2.zzh();
                                zzdyVarZzh.zza();
                                if (!TextUtils.isEmpty(zzdyVarZzh.zzl)) {
                                    zZzJ = zzfrVar2.zzJ();
                                    sharedPreferences = zzewVar2.zzu;
                                    if (sharedPreferences == null) {
                                        zContains = false;
                                    } else {
                                        zContains = sharedPreferences.contains("deferred_analytics_collection");
                                    }
                                    if (!zContains && !zzagVar.zzv()) {
                                        zzewVar2.zzi(!zZzJ);
                                    }
                                    if (zZzJ) {
                                        zzfr.zzQ(zzhxVar);
                                        zzhxVar.zzz();
                                    }
                                    zzkc zzkcVar = zzfrVar2.zzo;
                                    zzfr.zzQ(zzkcVar);
                                    zzkcVar.zza.zza();
                                    zzfrVar2.zzt().zzu(new AtomicReference());
                                    zzjm zzjmVarZzt = zzfrVar2.zzt();
                                    Bundle bundleZza = zzewVar2.zzs.zza();
                                    zzjmVarZzt.zzg();
                                    zzjmVarZzt.zza();
                                    zzjmVarZzt.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt, zzjmVarZzt.zzO(false), bundleZza, 24));
                                }
                            } else {
                                zZzJ = zzfrVar2.zzJ();
                                sharedPreferences = zzewVar2.zzu;
                                if (sharedPreferences == null) {
                                    zContains = false;
                                } else {
                                    zContains = sharedPreferences.contains("deferred_analytics_collection");
                                }
                                if (!zContains) {
                                    zzewVar2.zzi(!zZzJ);
                                }
                                if (zZzJ) {
                                    zzfr.zzQ(zzhxVar);
                                    zzhxVar.zzz();
                                }
                                zzkc zzkcVar2 = zzfrVar2.zzo;
                                zzfr.zzQ(zzkcVar2);
                                zzkcVar2.zza.zza();
                                zzfrVar2.zzt().zzu(new AtomicReference());
                                zzjm zzjmVarZzt2 = zzfrVar2.zzt();
                                Bundle bundleZza2 = zzewVar2.zzs.zza();
                                zzjmVarZzt2.zzg();
                                zzjmVarZzt2.zza();
                                zzjmVarZzt2.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt2, zzjmVarZzt2.zzO(false), bundleZza2, 24));
                            }
                            break;
                        } else if (zzfrVar2.zzJ()) {
                            zzfr.zzP(zzlbVar);
                            zzlbVar3 = zzlbVar;
                            if (!zzlbVar3.zzad("android.permission.INTERNET")) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("App is missing INTERNET permission");
                            }
                            if (!zzlbVar3.zzad("android.permission.ACCESS_NETWORK_STATE")) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("App is missing ACCESS_NETWORK_STATE permission");
                            }
                            context = zzfrVar2.zze;
                            if (!Wrappers.packageManager(context).isCallerInstantApp() && !zzagVar.zzx()) {
                                if (!zzlb.zzaj(context)) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzd.zza("AppMeasurementReceiver not registered/enabled");
                                }
                                if (!zzlb.zzak(context)) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzd.zza("AppMeasurementService not registered/enabled");
                                }
                            }
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("Uploading is not possible. App measurement disabled");
                        }
                        zzewVar2.zzi.zza(true);
                        return;
                    }
                    zzewVar2 = zzewVar;
                    if (!TextUtils.isEmpty(zzfrVar2.zzh().zzm()) || (i6 != 0 && i6 != 30 && i6 != 10 && i6 != 30 && i6 != 30 && i6 != 40)) {
                        if (TextUtils.isEmpty(zzfrVar2.zzh().zzm()) && zzclVar != null && zzclVar.zzg != null && zzewVar2.zzl(30)) {
                            zzaiVar = zzai.zza(zzclVar.zzg);
                            if (!zzaiVar.equals(zzai.zza)) {
                                i2 = 30;
                            }
                        }
                        if (zzaiVar != null) {
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzS(zzaiVar, i2, j);
                            zzaiVarZzc = zzaiVar;
                        }
                        zzfr.zzQ(zzhxVar);
                        zzhxVar.zzV(zzaiVarZzc);
                        zzesVar = zzewVar2.zzc;
                        if (zzesVar.zza() == 0) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzl.zzb(Long.valueOf(j), "Persisting first open");
                            zzesVar.zzb(j);
                        }
                        zzfr.zzQ(zzhxVar);
                        zzsVar = zzhxVar.zzb;
                        if (zzsVar.zzd()) {
                            zzew zzewVar5 = zzsVar.zza.zzl;
                            zzfr.zzP(zzewVar5);
                            zzewVar5.zzq.zzb(null);
                        }
                        if (!zzfrVar2.zzM()) {
                            zzlbVar2 = zzlbVar;
                            zIsEmpty = TextUtils.isEmpty(zzfrVar2.zzh().zzm());
                            billingFlowParams = zzewVar2.zze;
                            if (zIsEmpty) {
                                zzdyVarZzh2 = zzfrVar2.zzh();
                                zzdyVarZzh2.zza();
                                if (!TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                                    zzfr.zzP(zzlbVar2);
                                    strZzm = zzfrVar2.zzh().zzm();
                                    zzewVar2.zzg();
                                    string2 = zzewVar2.zza().getString("gmp_app_id", null);
                                    zzdy zzdyVarZzh7 = zzfrVar2.zzh();
                                    zzdyVarZzh7.zza();
                                    str2 = zzdyVarZzh7.zzl;
                                    zzewVar2.zzg();
                                    if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                        zzewVar2.zzg();
                                        zzewVar2.zzg();
                                        if (zzewVar2.zza().contains("measurement_enabled")) {
                                            boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                        } else {
                                            boolValueOf = null;
                                        }
                                        SharedPreferences.Editor editorEdit10 = zzewVar2.zza().edit();
                                        editorEdit10.clear();
                                        editorEdit10.apply();
                                        if (boolValueOf != null) {
                                            zzewVar2.zzg();
                                            SharedPreferences.Editor editorEdit11 = zzewVar2.zza().edit();
                                            editorEdit11.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                            editorEdit11.apply();
                                        }
                                        zzfrVar2.zzi().zzj();
                                        zzfrVar2.zzy.zzs$1();
                                        zzfrVar2.zzy.zzr();
                                        zzesVar.zzb(j);
                                        billingFlowParams.zzb(null);
                                    }
                                    String strZzm4 = zzfrVar2.zzh().zzm();
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit12 = zzewVar2.zza().edit();
                                    editorEdit12.putString("gmp_app_id", strZzm4);
                                    editorEdit12.apply();
                                    zzdy zzdyVarZzh8 = zzfrVar2.zzh();
                                    zzdyVarZzh8.zza();
                                    String str12 = zzdyVarZzh8.zzl;
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit13 = zzewVar2.zza().edit();
                                    editorEdit13.putString("admob_app_id", str12);
                                    editorEdit13.apply();
                                }
                            } else {
                                zzfr.zzP(zzlbVar2);
                                strZzm = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                string2 = zzewVar2.zza().getString("gmp_app_id", null);
                                zzdy zzdyVarZzh9 = zzfrVar2.zzh();
                                zzdyVarZzh9.zza();
                                str2 = zzdyVarZzh9.zzl;
                                zzewVar2.zzg();
                                if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                    zzewVar2.zzg();
                                    zzewVar2.zzg();
                                    if (zzewVar2.zza().contains("measurement_enabled")) {
                                        boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                    } else {
                                        boolValueOf = null;
                                    }
                                    SharedPreferences.Editor editorEdit14 = zzewVar2.zza().edit();
                                    editorEdit14.clear();
                                    editorEdit14.apply();
                                    if (boolValueOf != null) {
                                        zzewVar2.zzg();
                                        SharedPreferences.Editor editorEdit15 = zzewVar2.zza().edit();
                                        editorEdit15.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                        editorEdit15.apply();
                                    }
                                    zzfrVar2.zzi().zzj();
                                    zzfrVar2.zzy.zzs$1();
                                    zzfrVar2.zzy.zzr();
                                    zzesVar.zzb(j);
                                    billingFlowParams.zzb(null);
                                }
                                String strZzm5 = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit16 = zzewVar2.zza().edit();
                                editorEdit16.putString("gmp_app_id", strZzm5);
                                editorEdit16.apply();
                                zzdy zzdyVarZzh10 = zzfrVar2.zzh();
                                zzdyVarZzh10.zza();
                                String str13 = zzdyVarZzh10.zzl;
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit17 = zzewVar2.zza().edit();
                                editorEdit17.putString("admob_app_id", str13);
                                editorEdit17.apply();
                            }
                            if (!zzewVar2.zzc().zzi(com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE)) {
                                billingFlowParams.zzb(null);
                            }
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzg.set(billingFlowParams.zza());
                            zznw.zzc();
                            if (zzagVar.zzs(null, zzdu.zzac)) {
                                zzfr.zzP(zzlbVar2);
                                ((zzfr) zzlbVar2.mBuilder).zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                            }
                            if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                                zzdyVarZzh = zzfrVar2.zzh();
                                zzdyVarZzh.zza();
                                if (!TextUtils.isEmpty(zzdyVarZzh.zzl)) {
                                    zZzJ = zzfrVar2.zzJ();
                                    sharedPreferences = zzewVar2.zzu;
                                    if (sharedPreferences == null) {
                                        zContains = false;
                                    } else {
                                        zContains = sharedPreferences.contains("deferred_analytics_collection");
                                    }
                                    if (!zContains) {
                                        zzewVar2.zzi(!zZzJ);
                                    }
                                    if (zZzJ) {
                                        zzfr.zzQ(zzhxVar);
                                        zzhxVar.zzz();
                                    }
                                    zzkc zzkcVar3 = zzfrVar2.zzo;
                                    zzfr.zzQ(zzkcVar3);
                                    zzkcVar3.zza.zza();
                                    zzfrVar2.zzt().zzu(new AtomicReference());
                                    zzjm zzjmVarZzt3 = zzfrVar2.zzt();
                                    Bundle bundleZza3 = zzewVar2.zzs.zza();
                                    zzjmVarZzt3.zzg();
                                    zzjmVarZzt3.zza();
                                    zzjmVarZzt3.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt3, zzjmVarZzt3.zzO(false), bundleZza3, 24));
                                }
                            } else {
                                zZzJ = zzfrVar2.zzJ();
                                sharedPreferences = zzewVar2.zzu;
                                if (sharedPreferences == null) {
                                    zContains = false;
                                } else {
                                    zContains = sharedPreferences.contains("deferred_analytics_collection");
                                }
                                if (!zContains) {
                                    zzewVar2.zzi(!zZzJ);
                                }
                                if (zZzJ) {
                                    zzfr.zzQ(zzhxVar);
                                    zzhxVar.zzz();
                                }
                                zzkc zzkcVar4 = zzfrVar2.zzo;
                                zzfr.zzQ(zzkcVar4);
                                zzkcVar4.zza.zza();
                                zzfrVar2.zzt().zzu(new AtomicReference());
                                zzjm zzjmVarZzt4 = zzfrVar2.zzt();
                                Bundle bundleZza4 = zzewVar2.zzs.zza();
                                zzjmVarZzt4.zzg();
                                zzjmVarZzt4.zza();
                                zzjmVarZzt4.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt4, zzjmVarZzt4.zzO(false), bundleZza4, 24));
                            }
                            break;
                        } else if (zzfrVar2.zzJ()) {
                            zzfr.zzP(zzlbVar);
                            zzlbVar3 = zzlbVar;
                            if (!zzlbVar3.zzad("android.permission.INTERNET")) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("App is missing INTERNET permission");
                            }
                            if (!zzlbVar3.zzad("android.permission.ACCESS_NETWORK_STATE")) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("App is missing ACCESS_NETWORK_STATE permission");
                            }
                            context = zzfrVar2.zze;
                            if (!Wrappers.packageManager(context).isCallerInstantApp()) {
                                if (!zzlb.zzaj(context)) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzd.zza("AppMeasurementReceiver not registered/enabled");
                                }
                                if (!zzlb.zzak(context)) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzd.zza("AppMeasurementService not registered/enabled");
                                }
                            }
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("Uploading is not possible. App measurement disabled");
                        }
                        zzewVar2.zzi.zza(true);
                        return;
                    }
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzS(zzai.zza, -10, j);
                    zzaiVar = null;
                    if (zzaiVar != null) {
                        zzfr.zzQ(zzhxVar);
                        zzhxVar.zzS(zzaiVar, i2, j);
                        zzaiVarZzc = zzaiVar;
                    }
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzV(zzaiVarZzc);
                    zzesVar = zzewVar2.zzc;
                    if (zzesVar.zza() == 0) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzl.zzb(Long.valueOf(j), "Persisting first open");
                        zzesVar.zzb(j);
                    }
                    zzfr.zzQ(zzhxVar);
                    zzsVar = zzhxVar.zzb;
                    if (zzsVar.zzd()) {
                        zzew zzewVar6 = zzsVar.zza.zzl;
                        zzfr.zzP(zzewVar6);
                        zzewVar6.zzq.zzb(null);
                    }
                    if (!zzfrVar2.zzM()) {
                        zzlbVar2 = zzlbVar;
                        zIsEmpty = TextUtils.isEmpty(zzfrVar2.zzh().zzm());
                        billingFlowParams = zzewVar2.zze;
                        if (zIsEmpty) {
                            zzdyVarZzh2 = zzfrVar2.zzh();
                            zzdyVarZzh2.zza();
                            if (!TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                                zzfr.zzP(zzlbVar2);
                                strZzm = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                string2 = zzewVar2.zza().getString("gmp_app_id", null);
                                zzdy zzdyVarZzh11 = zzfrVar2.zzh();
                                zzdyVarZzh11.zza();
                                str2 = zzdyVarZzh11.zzl;
                                zzewVar2.zzg();
                                if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                    zzewVar2.zzg();
                                    zzewVar2.zzg();
                                    if (zzewVar2.zza().contains("measurement_enabled")) {
                                        boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                    } else {
                                        boolValueOf = null;
                                    }
                                    SharedPreferences.Editor editorEdit18 = zzewVar2.zza().edit();
                                    editorEdit18.clear();
                                    editorEdit18.apply();
                                    if (boolValueOf != null) {
                                        zzewVar2.zzg();
                                        SharedPreferences.Editor editorEdit19 = zzewVar2.zza().edit();
                                        editorEdit19.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                        editorEdit19.apply();
                                    }
                                    zzfrVar2.zzi().zzj();
                                    zzfrVar2.zzy.zzs$1();
                                    zzfrVar2.zzy.zzr();
                                    zzesVar.zzb(j);
                                    billingFlowParams.zzb(null);
                                }
                                String strZzm6 = zzfrVar2.zzh().zzm();
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit110 = zzewVar2.zza().edit();
                                editorEdit110.putString("gmp_app_id", strZzm6);
                                editorEdit110.apply();
                                zzdy zzdyVarZzh12 = zzfrVar2.zzh();
                                zzdyVarZzh12.zza();
                                String str14 = zzdyVarZzh12.zzl;
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit111 = zzewVar2.zza().edit();
                                editorEdit111.putString("admob_app_id", str14);
                                editorEdit111.apply();
                            }
                        } else {
                            zzfr.zzP(zzlbVar2);
                            strZzm = zzfrVar2.zzh().zzm();
                            zzewVar2.zzg();
                            string2 = zzewVar2.zza().getString("gmp_app_id", null);
                            zzdy zzdyVarZzh13 = zzfrVar2.zzh();
                            zzdyVarZzh13.zza();
                            str2 = zzdyVarZzh13.zzl;
                            zzewVar2.zzg();
                            if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                zzewVar2.zzg();
                                zzewVar2.zzg();
                                if (zzewVar2.zza().contains("measurement_enabled")) {
                                    boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                } else {
                                    boolValueOf = null;
                                }
                                SharedPreferences.Editor editorEdit112 = zzewVar2.zza().edit();
                                editorEdit112.clear();
                                editorEdit112.apply();
                                if (boolValueOf != null) {
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit113 = zzewVar2.zza().edit();
                                    editorEdit113.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                    editorEdit113.apply();
                                }
                                zzfrVar2.zzi().zzj();
                                zzfrVar2.zzy.zzs$1();
                                zzfrVar2.zzy.zzr();
                                zzesVar.zzb(j);
                                billingFlowParams.zzb(null);
                            }
                            String strZzm7 = zzfrVar2.zzh().zzm();
                            zzewVar2.zzg();
                            SharedPreferences.Editor editorEdit114 = zzewVar2.zza().edit();
                            editorEdit114.putString("gmp_app_id", strZzm7);
                            editorEdit114.apply();
                            zzdy zzdyVarZzh14 = zzfrVar2.zzh();
                            zzdyVarZzh14.zza();
                            String str15 = zzdyVarZzh14.zzl;
                            zzewVar2.zzg();
                            SharedPreferences.Editor editorEdit115 = zzewVar2.zza().edit();
                            editorEdit115.putString("admob_app_id", str15);
                            editorEdit115.apply();
                        }
                        if (!zzewVar2.zzc().zzi(com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE)) {
                            billingFlowParams.zzb(null);
                        }
                        zzfr.zzQ(zzhxVar);
                        zzhxVar.zzg.set(billingFlowParams.zza());
                        zznw.zzc();
                        if (zzagVar.zzs(null, zzdu.zzac)) {
                            zzfr.zzP(zzlbVar2);
                            ((zzfr) zzlbVar2.mBuilder).zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                        }
                        if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                            zzdyVarZzh = zzfrVar2.zzh();
                            zzdyVarZzh.zza();
                            if (!TextUtils.isEmpty(zzdyVarZzh.zzl)) {
                                zZzJ = zzfrVar2.zzJ();
                                sharedPreferences = zzewVar2.zzu;
                                if (sharedPreferences == null) {
                                    zContains = false;
                                } else {
                                    zContains = sharedPreferences.contains("deferred_analytics_collection");
                                }
                                if (!zContains) {
                                    zzewVar2.zzi(!zZzJ);
                                }
                                if (zZzJ) {
                                    zzfr.zzQ(zzhxVar);
                                    zzhxVar.zzz();
                                }
                                zzkc zzkcVar5 = zzfrVar2.zzo;
                                zzfr.zzQ(zzkcVar5);
                                zzkcVar5.zza.zza();
                                zzfrVar2.zzt().zzu(new AtomicReference());
                                zzjm zzjmVarZzt5 = zzfrVar2.zzt();
                                Bundle bundleZza5 = zzewVar2.zzs.zza();
                                zzjmVarZzt5.zzg();
                                zzjmVarZzt5.zza();
                                zzjmVarZzt5.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt5, zzjmVarZzt5.zzO(false), bundleZza5, 24));
                            }
                        } else {
                            zZzJ = zzfrVar2.zzJ();
                            sharedPreferences = zzewVar2.zzu;
                            if (sharedPreferences == null) {
                                zContains = false;
                            } else {
                                zContains = sharedPreferences.contains("deferred_analytics_collection");
                            }
                            if (!zContains) {
                                zzewVar2.zzi(!zZzJ);
                            }
                            if (zZzJ) {
                                zzfr.zzQ(zzhxVar);
                                zzhxVar.zzz();
                            }
                            zzkc zzkcVar6 = zzfrVar2.zzo;
                            zzfr.zzQ(zzkcVar6);
                            zzkcVar6.zza.zza();
                            zzfrVar2.zzt().zzu(new AtomicReference());
                            zzjm zzjmVarZzt6 = zzfrVar2.zzt();
                            Bundle bundleZza6 = zzewVar2.zzs.zza();
                            zzjmVarZzt6.zzg();
                            zzjmVarZzt6.zza();
                            zzjmVarZzt6.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt6, zzjmVarZzt6.zzO(false), bundleZza6, 24));
                        }
                        break;
                    } else if (zzfrVar2.zzJ()) {
                        zzfr.zzP(zzlbVar);
                        zzlbVar3 = zzlbVar;
                        if (!zzlbVar3.zzad("android.permission.INTERNET")) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("App is missing INTERNET permission");
                        }
                        if (!zzlbVar3.zzad("android.permission.ACCESS_NETWORK_STATE")) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("App is missing ACCESS_NETWORK_STATE permission");
                        }
                        context = zzfrVar2.zze;
                        if (!Wrappers.packageManager(context).isCallerInstantApp()) {
                            if (!zzlb.zzaj(context)) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("AppMeasurementReceiver not registered/enabled");
                            }
                            if (!zzlb.zzak(context)) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("AppMeasurementService not registered/enabled");
                            }
                        }
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("Uploading is not possible. App measurement disabled");
                    }
                    zzewVar2.zzi.zza(true);
                    return;
                }
                zzeh zzehVar7 = zzfrVar5.zzm;
                zzfr.zzR(zzehVar7);
                zzehVar7.zzd.zza("Failed to load metadata: Metadata bundle is null");
                numValueOf = null;
                if (numValueOf != null) {
                    stringArray = zzfrVar5.zze.getResources().getStringArray(numValueOf.intValue());
                    if (stringArray == null) {
                        listAsList = Arrays.asList(stringArray);
                    } else {
                        listAsList = null;
                    }
                    break;
                } else {
                    listAsList = null;
                }
                if (listAsList != null) {
                    zzdyVar2.zzh = listAsList;
                } else if (listAsList.isEmpty()) {
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzi.zza("Safelisted event list is empty. Ignoring");
                } else {
                    it = listAsList.iterator();
                    do {
                        if (it.hasNext()) {
                            str3 = (String) it.next();
                            zzlbVar4 = zzfrVar4.zzp;
                            zzfr.zzP(zzlbVar4);
                        } else {
                            zzdyVar2.zzh = listAsList;
                        }
                    } while (zzlbVar4.zzab("safelisted event", str3));
                }
                if (packageManager != null) {
                    zzdyVar2.zzj = CloseableKt.isInstantApp(context3) ? 1 : 0;
                } else {
                    zzdyVar2.zzj = 0;
                }
                zzfrVar4.zzB$1();
                ((zzf) zzdyVar2).zza = true;
                zzehVar = zzfrVar2.zzm;
                zzfr.zzR(zzehVar);
                zzagVar.zzh();
                zzefVar = zzehVar.zzj;
                zzefVar.zzb(74029L, "App measurement initialized, version");
                zzfr.zzR(zzehVar);
                zzefVar.zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
                strZzl = zzdyVar.zzl();
                if (TextUtils.isEmpty(zzfrVar2.zzf)) {
                    if (TextUtils.isEmpty(strZzl)) {
                        zEquals = false;
                    } else {
                        zEquals = zzfrVar3.zzk.zzB("debug.firebase.analytics.app").equals(strZzl);
                    }
                    if (zEquals) {
                        zzfr.zzR(zzehVar);
                        zzefVar.zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
                    } else {
                        zzfr.zzR(zzehVar);
                        zzefVar.zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strZzl)));
                    }
                }
                zzfr.zzR(zzehVar);
                zzehVar.zzk.zza("Debug-level message logging enabled");
                i = zzfrVar2.zzG;
                atomicInteger = zzfrVar2.zzH;
                if (i != atomicInteger.get()) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzc(Integer.valueOf(zzfrVar2.zzG), "Not all components initialized", Integer.valueOf(atomicInteger.get()));
                }
                zzfrVar2.zzB = true;
                zzcl zzclVar2 = zzguVar.zzg;
                zzfo zzfoVar5 = zzfrVar2.zzn;
                zzfr.zzR(zzfoVar5);
                zzfoVar5.zzg();
                zzfr.zzP(zzewVar);
                zzaiVarZzc = zzewVar.zzc();
                zzewVar.zzg();
                i2 = 100;
                int i7 = zzewVar.zza().getInt("consent_source", 100);
                Object obj5 = zzagVar.mBuilder;
                boolZzk = zzagVar.zzk("google_analytics_default_allow_ad_storage");
                boolZzk2 = zzagVar.zzk("google_analytics_default_allow_analytics_storage");
                j = zzfrVar2.zzc;
                zzhxVar = zzfrVar2.zzt;
                if (boolZzk == null) {
                    zzewVar2 = zzewVar;
                    if (zzewVar2.zzl(-10)) {
                        zzaiVar = new zzai(boolZzk, boolZzk2);
                        i2 = -10;
                    } else if (!TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                        if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                            zzaiVar = null;
                        } else {
                            zzaiVar = null;
                        }
                    } else if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                        zzaiVar = null;
                    } else {
                        zzaiVar = null;
                    }
                } else {
                    zzewVar2 = zzewVar;
                    if (zzewVar2.zzl(-10)) {
                        zzaiVar = new zzai(boolZzk, boolZzk2);
                        i2 = -10;
                    } else if (!TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                        if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                            zzaiVar = null;
                        } else {
                            zzaiVar = null;
                        }
                    } else if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                        zzaiVar = null;
                    } else {
                        zzaiVar = null;
                    }
                }
                if (zzaiVar != null) {
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzS(zzaiVar, i2, j);
                    zzaiVarZzc = zzaiVar;
                }
                zzfr.zzQ(zzhxVar);
                zzhxVar.zzV(zzaiVarZzc);
                zzesVar = zzewVar2.zzc;
                if (zzesVar.zza() == 0) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zzb(Long.valueOf(j), "Persisting first open");
                    zzesVar.zzb(j);
                }
                zzfr.zzQ(zzhxVar);
                zzsVar = zzhxVar.zzb;
                if (zzsVar.zzd()) {
                    zzew zzewVar7 = zzsVar.zza.zzl;
                    zzfr.zzP(zzewVar7);
                    zzewVar7.zzq.zzb(null);
                }
                if (!zzfrVar2.zzM()) {
                    zzlbVar2 = zzlbVar;
                    zIsEmpty = TextUtils.isEmpty(zzfrVar2.zzh().zzm());
                    billingFlowParams = zzewVar2.zze;
                    if (zIsEmpty) {
                        zzdyVarZzh2 = zzfrVar2.zzh();
                        zzdyVarZzh2.zza();
                        if (!TextUtils.isEmpty(zzdyVarZzh2.zzl)) {
                            zzfr.zzP(zzlbVar2);
                            strZzm = zzfrVar2.zzh().zzm();
                            zzewVar2.zzg();
                            string2 = zzewVar2.zza().getString("gmp_app_id", null);
                            zzdy zzdyVarZzh15 = zzfrVar2.zzh();
                            zzdyVarZzh15.zza();
                            str2 = zzdyVarZzh15.zzl;
                            zzewVar2.zzg();
                            if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                                zzewVar2.zzg();
                                zzewVar2.zzg();
                                if (zzewVar2.zza().contains("measurement_enabled")) {
                                    boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                                } else {
                                    boolValueOf = null;
                                }
                                SharedPreferences.Editor editorEdit116 = zzewVar2.zza().edit();
                                editorEdit116.clear();
                                editorEdit116.apply();
                                if (boolValueOf != null) {
                                    zzewVar2.zzg();
                                    SharedPreferences.Editor editorEdit117 = zzewVar2.zza().edit();
                                    editorEdit117.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                    editorEdit117.apply();
                                }
                                zzfrVar2.zzi().zzj();
                                zzfrVar2.zzy.zzs$1();
                                zzfrVar2.zzy.zzr();
                                zzesVar.zzb(j);
                                billingFlowParams.zzb(null);
                            }
                            String strZzm8 = zzfrVar2.zzh().zzm();
                            zzewVar2.zzg();
                            SharedPreferences.Editor editorEdit118 = zzewVar2.zza().edit();
                            editorEdit118.putString("gmp_app_id", strZzm8);
                            editorEdit118.apply();
                            zzdy zzdyVarZzh16 = zzfrVar2.zzh();
                            zzdyVarZzh16.zza();
                            String str16 = zzdyVarZzh16.zzl;
                            zzewVar2.zzg();
                            SharedPreferences.Editor editorEdit119 = zzewVar2.zza().edit();
                            editorEdit119.putString("admob_app_id", str16);
                            editorEdit119.apply();
                        }
                    } else {
                        zzfr.zzP(zzlbVar2);
                        strZzm = zzfrVar2.zzh().zzm();
                        zzewVar2.zzg();
                        string2 = zzewVar2.zza().getString("gmp_app_id", null);
                        zzdy zzdyVarZzh17 = zzfrVar2.zzh();
                        zzdyVarZzh17.zza();
                        str2 = zzdyVarZzh17.zzl;
                        zzewVar2.zzg();
                        if (zzlb.zzam(strZzm, string2, str2, zzewVar2.zza().getString("admob_app_id", null))) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzj.zza("Rechecking which service to use due to a GMP App Id change");
                            zzewVar2.zzg();
                            zzewVar2.zzg();
                            if (zzewVar2.zza().contains("measurement_enabled")) {
                                boolValueOf = Boolean.valueOf(zzewVar2.zza().getBoolean("measurement_enabled", true));
                            } else {
                                boolValueOf = null;
                            }
                            SharedPreferences.Editor editorEdit1110 = zzewVar2.zza().edit();
                            editorEdit1110.clear();
                            editorEdit1110.apply();
                            if (boolValueOf != null) {
                                zzewVar2.zzg();
                                SharedPreferences.Editor editorEdit1111 = zzewVar2.zza().edit();
                                editorEdit1111.putBoolean("measurement_enabled", boolValueOf.booleanValue());
                                editorEdit1111.apply();
                            }
                            zzfrVar2.zzi().zzj();
                            zzfrVar2.zzy.zzs$1();
                            zzfrVar2.zzy.zzr();
                            zzesVar.zzb(j);
                            billingFlowParams.zzb(null);
                        }
                        String strZzm9 = zzfrVar2.zzh().zzm();
                        zzewVar2.zzg();
                        SharedPreferences.Editor editorEdit1112 = zzewVar2.zza().edit();
                        editorEdit1112.putString("gmp_app_id", strZzm9);
                        editorEdit1112.apply();
                        zzdy zzdyVarZzh18 = zzfrVar2.zzh();
                        zzdyVarZzh18.zza();
                        String str17 = zzdyVarZzh18.zzl;
                        zzewVar2.zzg();
                        SharedPreferences.Editor editorEdit1113 = zzewVar2.zza().edit();
                        editorEdit1113.putString("admob_app_id", str17);
                        editorEdit1113.apply();
                    }
                    if (!zzewVar2.zzc().zzi(com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE)) {
                        billingFlowParams.zzb(null);
                    }
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzg.set(billingFlowParams.zza());
                    zznw.zzc();
                    if (zzagVar.zzs(null, zzdu.zzac)) {
                        zzfr.zzP(zzlbVar2);
                        ((zzfr) zzlbVar2.mBuilder).zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                    }
                    if (TextUtils.isEmpty(zzfrVar2.zzh().zzm())) {
                        zzdyVarZzh = zzfrVar2.zzh();
                        zzdyVarZzh.zza();
                        if (!TextUtils.isEmpty(zzdyVarZzh.zzl)) {
                            zZzJ = zzfrVar2.zzJ();
                            sharedPreferences = zzewVar2.zzu;
                            if (sharedPreferences == null) {
                                zContains = false;
                            } else {
                                zContains = sharedPreferences.contains("deferred_analytics_collection");
                            }
                            if (!zContains) {
                                zzewVar2.zzi(!zZzJ);
                            }
                            if (zZzJ) {
                                zzfr.zzQ(zzhxVar);
                                zzhxVar.zzz();
                            }
                            zzkc zzkcVar7 = zzfrVar2.zzo;
                            zzfr.zzQ(zzkcVar7);
                            zzkcVar7.zza.zza();
                            zzfrVar2.zzt().zzu(new AtomicReference());
                            zzjm zzjmVarZzt7 = zzfrVar2.zzt();
                            Bundle bundleZza7 = zzewVar2.zzs.zza();
                            zzjmVarZzt7.zzg();
                            zzjmVarZzt7.zza();
                            zzjmVarZzt7.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt7, zzjmVarZzt7.zzO(false), bundleZza7, 24));
                        }
                    } else {
                        zZzJ = zzfrVar2.zzJ();
                        sharedPreferences = zzewVar2.zzu;
                        if (sharedPreferences == null) {
                            zContains = false;
                        } else {
                            zContains = sharedPreferences.contains("deferred_analytics_collection");
                        }
                        if (!zContains) {
                            zzewVar2.zzi(!zZzJ);
                        }
                        if (zZzJ) {
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzz();
                        }
                        zzkc zzkcVar8 = zzfrVar2.zzo;
                        zzfr.zzQ(zzkcVar8);
                        zzkcVar8.zza.zza();
                        zzfrVar2.zzt().zzu(new AtomicReference());
                        zzjm zzjmVarZzt8 = zzfrVar2.zzt();
                        Bundle bundleZza8 = zzewVar2.zzs.zza();
                        zzjmVarZzt8.zzg();
                        zzjmVarZzt8.zza();
                        zzjmVarZzt8.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt8, zzjmVarZzt8.zzO(false), bundleZza8, 24));
                    }
                    break;
                } else if (zzfrVar2.zzJ()) {
                    zzfr.zzP(zzlbVar);
                    zzlbVar3 = zzlbVar;
                    if (!zzlbVar3.zzad("android.permission.INTERNET")) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("App is missing INTERNET permission");
                    }
                    if (!zzlbVar3.zzad("android.permission.ACCESS_NETWORK_STATE")) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("App is missing ACCESS_NETWORK_STATE permission");
                    }
                    context = zzfrVar2.zze;
                    if (!Wrappers.packageManager(context).isCallerInstantApp()) {
                        if (!zzlb.zzaj(context)) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("AppMeasurementReceiver not registered/enabled");
                        }
                        if (!zzlb.zzak(context)) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("AppMeasurementService not registered/enabled");
                        }
                    }
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza("Uploading is not possible. App measurement disabled");
                }
                zzewVar2.zzi.zza(true);
                return;
        }
    }

    public /* synthetic */ zza(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    private final void run$com$google$android$gms$ads$internal$util$zzi() {
        zzj zzjVar = (zzj) this.zza;
        SharedPreferences sharedPreferences = ((Context) this.zzb).getSharedPreferences("admob", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        try {
            synchronized (zzjVar.zza) {
                try {
                    zzjVar.zzf = sharedPreferences;
                    zzjVar.zzg = editorEdit;
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                    zzjVar.zzh = zzjVar.zzf.getBoolean("use_https", zzjVar.zzh);
                    zzjVar.zzu = zzjVar.zzf.getBoolean("content_url_opted_out", zzjVar.zzu);
                    zzjVar.zzi = zzjVar.zzf.getString("content_url_hashes", zzjVar.zzi);
                    zzjVar.zzk = zzjVar.zzf.getBoolean("gad_idless", zzjVar.zzk);
                    zzjVar.zzv = zzjVar.zzf.getBoolean("content_vertical_opted_out", zzjVar.zzv);
                    zzjVar.zzj = zzjVar.zzf.getString("content_vertical_hashes", zzjVar.zzj);
                    zzjVar.zzr = zzjVar.zzf.getInt("version_code", zzjVar.zzr);
                    if (((Boolean) zzbew.zzg.zze()).booleanValue() && zzbd.zza.zzd.zze()) {
                        zzjVar.zzn = new zzbzm("", 0L);
                    } else {
                        zzjVar.zzn = new zzbzm(zzjVar.zzf.getString("app_settings_json", zzjVar.zzn.zzc()), zzjVar.zzf.getLong("app_settings_last_update_ms", zzjVar.zzn.zza()));
                    }
                    zzjVar.zzo = zzjVar.zzf.getLong("app_last_background_time_ms", zzjVar.zzo);
                    zzjVar.zzq = zzjVar.zzf.getInt("request_in_session_count", zzjVar.zzq);
                    zzjVar.zzp = zzjVar.zzf.getLong("first_ad_req_time_ms", zzjVar.zzp);
                    zzjVar.zzs = zzjVar.zzf.getStringSet("never_pool_slots", zzjVar.zzs);
                    zzjVar.zzw = zzjVar.zzf.getString(QTaELkFI.pyGaFp, zzjVar.zzw);
                    zzjVar.zzB = zzjVar.zzf.getInt("app_measurement_npa", zzjVar.zzB);
                    zzjVar.zzC = zzjVar.zzf.getInt("sd_app_measure_npa", zzjVar.zzC);
                    zzjVar.zzD = zzjVar.zzf.getLong("sd_app_measure_npa_ts", zzjVar.zzD);
                    zzjVar.zzx = zzjVar.zzf.getString("inspector_info", zzjVar.zzx);
                    zzjVar.zzy = zzjVar.zzf.getBoolean("linked_device", zzjVar.zzy);
                    zzjVar.zzz = zzjVar.zzf.getString("linked_ad_unit", zzjVar.zzz);
                    zzjVar.zzA = zzjVar.zzf.getString("inspector_ui_storage", zzjVar.zzA);
                    zzjVar.zzl = zzjVar.zzf.getString("IABTCF_TCString", zzjVar.zzl);
                    zzjVar.zzm = zzjVar.zzf.getInt("gad_has_consent_for_cookies", zzjVar.zzm);
                    try {
                        zzjVar.zzt = new JSONObject(zzjVar.zzf.getString("native_advanced_settings", "{}"));
                    } catch (JSONException e) {
                        int i = zze.$r8$clinit;
                        zzo.zzk("Could not convert native advanced settings to json object", e);
                    }
                    zzjVar.zzS();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            zzv.zza.zzi.zzw(th2, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
            zze.zzb("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", th2);
        }
    }

    private final void run$com$google$android$gms$ads$nonagon$signalgeneration$zzbl() {
        String string;
        zzbm zzbmVar = (zzbm) this.zza;
        zzbk zzbkVar = (zzbk) this.zzb;
        com.google.android.gms.ads.nonagon.signalgeneration.zzb zzbVar = zzbmVar.zza;
        String str = zzbmVar.zzc;
        zzbVar.getClass();
        if (TextUtils.isEmpty(str) || zzbVar.zze()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(eoBKjVuj.cBKZ, zzbkVar.zza);
            jSONObject2.put("signal_dictionary", zzbb.zzb.zzc.zzn(zzbkVar.zzf));
            jSONObject.put("sr", jSONObject2);
            String str2 = zzbkVar.zzc;
            if (TextUtils.isEmpty(str2)) {
                string = "";
            } else {
                jSONObject.put("rs", Base64.encodeToString(com.google.android.gms.ads.nonagon.signalgeneration.zzb.zzb(str2).getBytes(StandardCharsets.UTF_8), 10));
                zzv.zza.zzl.getClass();
                jSONObject.put("ts_ms", System.currentTimeMillis());
                string = jSONObject.toString();
            }
        } catch (JSONException e) {
            zzv.zza.zzi.zzw(e, "DiskCachingManager.createStringToWrite");
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.google.android.gms.ads.nonagon.signalgeneration.zzd zzdVar = zzbVar.zzb;
        zzdVar.zzk();
        synchronized (zzdVar.zzd) {
            zzdVar.zzb.putString(str, string).commit();
        }
    }

    public /* synthetic */ zza(Object obj, Object obj2, int i, boolean z) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    public /* synthetic */ zza(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.zza = obj2;
        this.zzb = obj3;
    }
}
