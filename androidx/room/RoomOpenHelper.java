package androidx.room;

import android.animation.Animator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.AbsActionBarView$VisibilityAnimListener;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.provider.FontRequestWorker;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.work.InputMergerFactory$1;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.Operation$State$SUCCESS;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.utils.futures.SettableFuture;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.zzcc;
import com.android.billingclient.api.zzcj;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.facebook.AccessTokenCache;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.ProfileCache;
import com.facebook.appevents.AppEventCollection;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import com.facebook.login.WebViewLoginMethodHandler;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.CreationContextFactory;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.internal.util.client.zzd;
import com.google.android.gms.ads.internal.util.client.zze;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.client.zzt;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.zzaa;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class RoomOpenHelper implements ActionMode.Callback, EmojiProcessor$EmojiProcessCallback, CancellationSignal.OnCancelListener, Operation, zzcc, WebDialog.OnCompleteListener, Factory, zze, zzaqh {
    public final /* synthetic */ int $r8$classId;
    public Object mConfiguration;
    public Object mDelegate;

    public /* synthetic */ RoomOpenHelper(int i) {
        this.$r8$classId = i;
    }

    public static void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e) {
            Log.w("SupportSQLite", "delete failed: ", e);
        }
    }

    public void dispatchOnFragmentActivityCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentAttached(boolean z) {
        FragmentManager fragmentManager = (FragmentManager) this.mDelegate;
        FragmentActivity fragmentActivity = fragmentManager.mHost.mContext;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDestroyed(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDetached(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPaused(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPaused(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreAttached(boolean z) {
        FragmentManager fragmentManager = (FragmentManager) this.mDelegate;
        FragmentActivity fragmentActivity = fragmentManager.mHost.mContext;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentResumed(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentResumed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentSaveInstanceState(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentSaveInstanceState(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStarted(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStarted(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStopped(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStopped(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewDestroyed(boolean z) {
        Fragment fragment = ((FragmentManager) this.mDelegate).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.mConfiguration).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 25:
                return new MetadataBackendRegistry((Context) ((InstanceFactory) this.mConfiguration).instance, (CreationContextFactory) ((CreationContextFactory_Factory) this.mDelegate).get());
            default:
                return new SQLiteEventStore(new GraphRequest.Companion(18), new GraphRequest.Companion(17), AutoValue_EventStoreConfig.DEFAULT, (SchemaManager) ((CreationContextFactory_Factory) this.mConfiguration).get(), (Provider) this.mDelegate);
        }
    }

    public ArrayList getDependentWorkIds(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.mConfiguration;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    public Long getLongValue(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT long_value FROM Preference where `key`=?");
        roomSQLiteQueryAcquire.bindString(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.mConfiguration;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            Long lValueOf = null;
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return (UnprecomputeTextOnModificationSpannable) this.mConfiguration;
    }

    public ArrayList getTagsForWorkSpecId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.mConfiguration;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
            return true;
        }
        if (((UnprecomputeTextOnModificationSpannable) this.mConfiguration) == null) {
            this.mConfiguration = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((InputMergerFactory$1) this.mDelegate).getClass();
        ((UnprecomputeTextOnModificationSpannable) this.mConfiguration).setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    public void insertPreference(Preference preference) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.mConfiguration;
        workDatabase_Impl.assertNotSuspendingTransaction();
        workDatabase_Impl.beginTransaction();
        try {
            ((WorkTagDao_Impl$1) this.mDelegate).insert(preference);
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
        }
    }

    public void launchUrl(Context context, Uri uri) {
        Intent intent = (Intent) this.mConfiguration;
        intent.setData(uri);
        ContextCompat.startActivity(context, intent, (Bundle) this.mDelegate);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((ActionMode.Callback) this.mConfiguration).onActionItemClicked(actionMode, menuItem);
    }

    @Override // com.facebook.internal.WebDialog.OnCompleteListener
    public void onComplete(Bundle bundle, FacebookException facebookException) {
        WebViewLoginMethodHandler webViewLoginMethodHandler = (WebViewLoginMethodHandler) this.mConfiguration;
        webViewLoginMethodHandler.getClass();
        LoginClient.Request request = (LoginClient.Request) this.mDelegate;
        Intrinsics.checkNotNullParameter(request, "request");
        webViewLoginMethodHandler.onComplete(request, bundle, facebookException);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        return ((ActionMode.Callback) this.mConfiguration).onCreateActionMode(actionMode, menuBuilder);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((ActionMode.Callback) this.mConfiguration).onDestroyActionMode(actionMode);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.mDelegate;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
        }
        if (appCompatDelegateImpl.mActionModeView != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
            viewPropertyAnimatorCompatAnimate.alpha(0.0f);
            appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
            viewPropertyAnimatorCompatAnimate.setListener(new AppCompatDelegateImpl.AnonymousClass7(this, 2));
        }
        appCompatDelegateImpl.mAppCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl.mActionMode);
        appCompatDelegateImpl.mActionMode = null;
        ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        appCompatDelegateImpl.updateBackInvokedCallbackState();
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        ViewGroup viewGroup = ((AppCompatDelegateImpl) this.mDelegate).mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        return ((ActionMode.Callback) this.mConfiguration).onPrepareActionMode(actionMode, menuBuilder);
    }

    public void onQueryPurchasesResponse(List list) {
        GooglePlayBillingService googlePlayBillingService = (GooglePlayBillingService) this.mDelegate;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(FirebaseAnalytics.Param.SUCCESS, true);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                if (!googlePlayBillingService.m_purchaseRequests.containsKey(purchase.getPurchaseToken())) {
                    googlePlayBillingService.m_purchaseRequests.put(purchase.getPurchaseToken(), purchase);
                }
                jSONArray.put(new JSONObject(purchase.zza));
            }
            jSONObject.put("purchases", jSONArray);
            String string = jSONObject.toString();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12010.0d});
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", string);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "sku_type", (String) this.mConfiguration);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
        } catch (JSONException unused) {
            Log.e(GooglePlayBillingService.TAG, "Malformed JSON data from queryPurchases.");
        }
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        int i = typefaceResult.mResult;
        Handler handler = (Handler) this.mDelegate;
        AccessTokenCache accessTokenCache = (AccessTokenCache) this.mConfiguration;
        if (i == 0) {
            handler.post(new zza(accessTokenCache, typefaceResult.mTypeface, 4));
        } else {
            handler.post(new Worker.AnonymousClass1(accessTokenCache, i));
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    /* JADX WARN: Code duplicated, block: B:18:0x003c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:88:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[LOOP:3: B:11:0x0024->B:94:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x005d A[SYNTHETIC] */
    public void onUpgrade(FrameworkSQLiteProgram frameworkSQLiteProgram, int i, int i2) {
        List listEmptyList;
        TreeMap treeMap;
        Set setKeySet;
        Iterator it;
        boolean z;
        int iIntValue;
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.mConfiguration;
        ProfileCache profileCache = (ProfileCache) this.mDelegate;
        if (databaseConfiguration != null) {
            AppEventCollection appEventCollection = databaseConfiguration.migrationContainer;
            appEventCollection.getClass();
            if (i == i2) {
                listEmptyList = Collections.emptyList();
            } else {
                boolean z2 = i2 > i;
                ArrayList arrayList = new ArrayList();
                int i3 = i;
                while (true) {
                    if (z2) {
                        if (i3 < i2) {
                            treeMap = (TreeMap) appEventCollection.stateMap.get(Integer.valueOf(i3));
                            if (treeMap != null) {
                                if (z2) {
                                    setKeySet = treeMap.descendingKeySet();
                                } else {
                                    setKeySet = treeMap.keySet();
                                }
                                it = setKeySet.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    Integer num = (Integer) it.next();
                                    iIntValue = num.intValue();
                                    if (z2) {
                                        if (iIntValue <= i2 && iIntValue > i3) {
                                            arrayList.add(treeMap.get(num));
                                            z = true;
                                            i3 = iIntValue;
                                            break;
                                        }
                                    } else {
                                        if (iIntValue >= i2 && iIntValue < i3) {
                                            arrayList.add(treeMap.get(num));
                                            z = true;
                                            i3 = iIntValue;
                                            break;
                                            break;
                                        }
                                    }
                                }
                                if (!z) {
                                }
                            }
                            listEmptyList = null;
                        } else {
                            listEmptyList = arrayList;
                        }
                    } else if (i3 > i2) {
                        treeMap = (TreeMap) appEventCollection.stateMap.get(Integer.valueOf(i3));
                        if (treeMap != null) {
                            if (z2) {
                                setKeySet = treeMap.descendingKeySet();
                            } else {
                                setKeySet = treeMap.keySet();
                            }
                            it = setKeySet.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    z = false;
                                    break;
                                    break;
                                }
                                Integer num2 = (Integer) it.next();
                                iIntValue = num2.intValue();
                                if (z2) {
                                    if (iIntValue <= i2) {
                                        continue;
                                    }
                                } else if (iIntValue >= i2) {
                                    continue;
                                }
                            }
                            if (!z) {
                            }
                        }
                        listEmptyList = null;
                    } else {
                        listEmptyList = arrayList;
                    }
                }
            }
            if (listEmptyList != null) {
                ArrayList<String> arrayList2 = new ArrayList();
                Cursor cursorQuery = frameworkSQLiteProgram.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList2.add(cursorQuery.getString(0));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
                for (String str : arrayList2) {
                    if (str.startsWith("room_fts_content_sync_")) {
                        frameworkSQLiteProgram.execSQL("DROP TRIGGER IF EXISTS ".concat(str));
                    }
                }
                Iterator it2 = listEmptyList.iterator();
                while (it2.hasNext()) {
                    ((Migration) it2.next()).migrate(frameworkSQLiteProgram);
                }
                ValidationResult validationResultOnValidateSchema = ProfileCache.onValidateSchema(frameworkSQLiteProgram);
                if (!validationResultOnValidateSchema.isValid) {
                    throw new IllegalStateException("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg);
                }
                updateIdentity(frameworkSQLiteProgram);
                return;
            }
        }
        DatabaseConfiguration databaseConfiguration2 = (DatabaseConfiguration) this.mConfiguration;
        if (databaseConfiguration2 != null) {
            if (!((i <= i2 || !databaseConfiguration2.allowDestructiveMigrationOnDowngrade) ? databaseConfiguration2.requireMigration : false)) {
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `Dependency`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `WorkName`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS `Preference`");
                int i4 = WorkDatabase_Impl.$r8$clinit;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) profileCache.sharedPreferences;
                ArrayList arrayList3 = workDatabase_Impl.mCallbacks;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((WorkDatabase.AnonymousClass2) workDatabase_Impl.mCallbacks.get(i5)).getClass();
                    }
                }
                ProfileCache.createAllTables(frameworkSQLiteProgram);
                return;
            }
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public void setShadowPadding(int i, int i2, int i3, int i4) {
        CardView cardView = (CardView) this.mDelegate;
        cardView.mShadowBounds.set(i, i2, i3, i4);
        Rect rect = cardView.mContentPadding;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public void setState(RangesKt rangesKt) {
        ((MutableLiveData) this.mConfiguration).postValue(rangesKt);
        boolean z = rangesKt instanceof Operation$State$SUCCESS;
        SettableFuture settableFuture = (SettableFuture) this.mDelegate;
        if (z) {
            settableFuture.set((Operation$State$SUCCESS) rangesKt);
        } else if (rangesKt instanceof Operation$State$FAILURE) {
            settableFuture.setException(((Operation$State$FAILURE) rangesKt).mThrowable);
        }
    }

    public void updateIdentity(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteProgram.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    public zzt zza(String str) {
        zzt zztVar = zzt.zza;
        switch (this.$r8$classId) {
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                new zzd((zzf) this.mConfiguration, (Context) this.mDelegate, str).start();
                break;
            default:
                com.google.android.gms.ads.internal.util.zzf zzfVar = zzs.zza;
                zzs zzsVar = zzv.zza.zzd;
                new zzbw((Context) this.mConfiguration, (String) this.mDelegate, str, null).zzb();
                break;
        }
        return zztVar;
    }

    public void zzc(zzge zzgeVar) {
        if (zzgeVar == null) {
            return;
        }
        try {
            zzhd zzhdVarZzy = zzhe.zzy();
            zzhdVarZzy.zzn((zzgu) this.mConfiguration);
            zzhdVarZzy.zzm(zzgeVar);
            ((zzcj) this.mDelegate).zza((zzhe) zzhdVarZzy.zzf());
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class ValidationResult {
        public final /* synthetic */ int $r8$classId = 1;
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(String str, boolean z) {
            this.expectedFoundMsg = str;
            this.isValid = z;
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 1:
                    String str = this.isValid ? "Applink" : "Unclassified";
                    String str2 = this.expectedFoundMsg;
                    if (str2 == null) {
                        return str;
                    }
                    return str + '(' + ((Object) str2) + ')';
                default:
                    return super.toString();
            }
        }

        public ValidationResult(boolean z, String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public /* synthetic */ RoomOpenHelper(Object obj, int i) {
        this.$r8$classId = i;
        this.mConfiguration = obj;
        this.mDelegate = null;
    }

    public BillingFlowParams build() {
        ArrayList arrayList = (ArrayList) this.mConfiguration;
        boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
        if (!z) {
            throw new IllegalArgumentException("Details of the products must be provided.");
        }
        if (!z) {
            throw null;
        }
        if (((ArrayList) this.mConfiguration).contains(null)) {
            throw new IllegalArgumentException("SKU cannot be null.");
        }
        if (((ArrayList) this.mConfiguration).size() > 1) {
            SkuDetails skuDetails = (SkuDetails) ((ArrayList) this.mConfiguration).get(0);
            String type = skuDetails.getType();
            ArrayList arrayList2 = (ArrayList) this.mConfiguration;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i);
                if (!type.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !type.equals(skuDetails2.getType())) {
                    throw new IllegalArgumentException("SKUs should have the same type.");
                }
            }
            String strOptString = skuDetails.zzb.optString("packageName");
            ArrayList arrayList3 = (ArrayList) this.mConfiguration;
            int size2 = arrayList3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i2);
                if (!type.equals("play_pass_subs") && !skuDetails3.getType().equals("play_pass_subs") && !strOptString.equals(skuDetails3.zzb.optString("packageName"))) {
                    throw new IllegalArgumentException(sgtsHsWT.JKHsEqZmJzQBMSs);
                }
            }
        }
        BillingFlowParams billingFlowParams = new BillingFlowParams();
        billingFlowParams.zza = z && !((SkuDetails) ((ArrayList) this.mConfiguration).get(0)).zzb.optString("packageName").isEmpty();
        AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener = (AbsActionBarView$VisibilityAnimListener) this.mDelegate;
        boolean z2 = true;
        if (TextUtils.isEmpty((String) absActionBarView$VisibilityAnimListener.this$0) && TextUtils.isEmpty(null)) {
            z2 = false;
        }
        boolean zIsEmpty = TextUtils.isEmpty(null);
        if (z2 && !zIsEmpty) {
            throw new IllegalArgumentException(eoBKjVuj.XVFhpIOcIWvhsk);
        }
        if (!absActionBarView$VisibilityAnimListener.mCanceled && !z2 && zIsEmpty) {
            throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
        }
        BillingResult.Builder builder = new BillingResult.Builder();
        builder.zzb = (String) absActionBarView$VisibilityAnimListener.this$0;
        builder.zza = absActionBarView$VisibilityAnimListener.mFinalVisibility;
        billingFlowParams.zzd = builder;
        ArrayList arrayList4 = (ArrayList) this.mConfiguration;
        billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
        billingFlowParams.zze = zzai.zzk();
        return billingFlowParams;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        ((Animator) this.mConfiguration).end();
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", yzwzcWHcnH.MRBWDaS + ((SpecialEffectsController$FragmentStateManagerOperation) this.mDelegate) + " has been canceled.");
        }
    }

    public /* synthetic */ RoomOpenHelper(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.mDelegate = obj;
        this.mConfiguration = obj2;
    }

    public /* synthetic */ RoomOpenHelper(Object obj, Object obj2, int i, boolean z) {
        this.$r8$classId = i;
        this.mConfiguration = obj;
        this.mDelegate = obj2;
    }

    public RoomOpenHelper(Context context, zzgu zzguVar) {
        this.$r8$classId = 19;
        zzcj zzcjVar = new zzcj(0);
        try {
            TransportRuntime.initialize(context);
            zzaa zzaaVarNewFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
            Encoding encoding = new Encoding("proto");
            InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(22);
            Set set = (Set) zzaaVarNewFactory.zza;
            if (set.contains(encoding)) {
                zzcjVar.zzb = new zzaa((AutoValue_TransportContext) zzaaVarNewFactory.zzb, encoding, inputMergerFactory$1, (TransportRuntime) zzaaVarNewFactory.zzc);
                this.mDelegate = zzcjVar;
                this.mConfiguration = zzguVar;
                return;
            }
            throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
        } catch (Throwable unused) {
            zzcjVar.zza = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqh
    public void zza(zzaqm zzaqmVar) {
        String strM = Fragment$$ExternalSyntheticOutline0.m(new StringBuilder("Failed to load URL: "), (String) this.mConfiguration, "\n", zzaqmVar.toString());
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        zzo.zzj(strM);
        ((zzbk) this.mDelegate).zzc(null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    public CctBackendFactory get(String str) {
        Bundle bundle;
        Map mapEmptyMap;
        Object obj;
        Map map = (Map) this.mDelegate;
        String str2 = ehgOP.NefKXnp;
        if (map == null) {
            Context context = (Context) this.mConfiguration;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(str2, "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w(str2, "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w(str2, "Could not retrieve metadata, returning empty list of transport backends.");
                        mapEmptyMap = Collections.emptyMap();
                    } else {
                        HashMap map2 = new HashMap();
                        for (String str3 : bundle.keySet()) {
                            obj = bundle.get(str3);
                            if (!(obj instanceof String) && str3.startsWith("backend:")) {
                                for (String str4 : ((String) obj).split(",", -1)) {
                                    String strTrim = str4.trim();
                                    if (!strTrim.isEmpty()) {
                                        map2.put(strTrim, str3.substring(8));
                                    }
                                }
                            }
                        }
                        mapEmptyMap = map2;
                    }
                    this.mDelegate = mapEmptyMap;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(str2, "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w(str2, "Could not retrieve metadata, returning empty list of transport backends.");
                mapEmptyMap = Collections.emptyMap();
            } else {
                HashMap map3 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str3);
                    if (!(obj instanceof String)) {
                    }
                }
                mapEmptyMap = map3;
            }
            this.mDelegate = mapEmptyMap;
        }
        String str5 = (String) ((Map) this.mDelegate).get(str);
        if (str5 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str5).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w(str2, "Class " + str5 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w(str2, "Could not instantiate " + str5 + ".", e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w(str2, "Could not instantiate " + str5 + ".", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w(str2, "Could not instantiate ".concat(str5), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w(str2, "Could not instantiate ".concat(str5), e5);
            return null;
        }
    }

    public void zza(zzga zzgaVar) {
        if (zzgaVar == null) {
            return;
        }
        try {
            zzhd zzhdVarZzy = zzhe.zzy();
            zzhdVarZzy.zzn((zzgu) this.mConfiguration);
            zzhdVarZzy.zzl(zzgaVar);
            ((zzcj) this.mDelegate).zza((zzhe) zzhdVarZzy.zzf());
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    public RoomOpenHelper(zzbo zzboVar, String str, zzbk zzbkVar) {
        this.$r8$classId = 28;
        this.mConfiguration = str;
        this.mDelegate = zzbkVar;
        Objects.requireNonNull(zzboVar);
    }

    public RoomOpenHelper(WorkDatabase_Impl workDatabase_Impl, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 14:
                this.mConfiguration = workDatabase_Impl;
                this.mDelegate = new WorkTagDao_Impl$1(workDatabase_Impl, 2);
                break;
            case 15:
                this.mConfiguration = workDatabase_Impl;
                this.mDelegate = new WorkTagDao_Impl$1(workDatabase_Impl, 4);
                break;
            case 16:
                this.mConfiguration = workDatabase_Impl;
                this.mDelegate = new WorkTagDao_Impl$1(workDatabase_Impl, 0);
                break;
            default:
                this.mConfiguration = workDatabase_Impl;
                this.mDelegate = new WorkTagDao_Impl$1(workDatabase_Impl, 1);
                break;
        }
    }

    public RoomOpenHelper() {
        this.$r8$classId = 12;
        this.mConfiguration = new MutableLiveData();
        this.mDelegate = new SettableFuture();
        setState(Operation.IN_PROGRESS);
    }

    public RoomOpenHelper(FragmentManager fragmentManager) {
        this.$r8$classId = 10;
        this.mConfiguration = new CopyOnWriteArrayList();
        this.mDelegate = fragmentManager;
    }

    public RoomOpenHelper(Animator animator) {
        this.$r8$classId = 9;
        this.mConfiguration = null;
        this.mDelegate = animator;
    }

    public RoomOpenHelper(ArrayList arrayList, ArrayList arrayList2) {
        this.$r8$classId = 4;
        int size = arrayList.size();
        this.mConfiguration = new int[size];
        this.mDelegate = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.mConfiguration)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.mDelegate)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public RoomOpenHelper(int i, int i2) {
        this.$r8$classId = 4;
        this.mConfiguration = new int[]{i, i2};
        this.mDelegate = new float[]{0.0f, 1.0f};
    }

    public RoomOpenHelper(int i, int i2, int i3) {
        this.$r8$classId = 4;
        this.mConfiguration = new int[]{i, i2, i3};
        this.mDelegate = new float[]{0.0f, 0.5f, 1.0f};
    }

    public RoomOpenHelper(EditText editText) {
        this.$r8$classId = 7;
        this.mConfiguration = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.mDelegate = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        if (EmojiEditableFactory.sInstance == null) {
            synchronized (EmojiEditableFactory.INSTANCE_LOCK) {
                try {
                    if (EmojiEditableFactory.sInstance == null) {
                        EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
                        try {
                            EmojiEditableFactory.sWatcherClass = Class.forName(MnHfHMYQDPUO.FLg, false, EmojiEditableFactory.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        EmojiEditableFactory.sInstance = emojiEditableFactory;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(EmojiEditableFactory.sInstance);
    }

    public RoomOpenHelper(CardView cardView) {
        this.$r8$classId = 3;
        this.mDelegate = cardView;
    }
}
