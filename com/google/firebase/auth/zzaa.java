package com.google.firebase.auth;

import android.app.Activity;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.TooltipPopup;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.PaintCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;
import androidx.emoji2.text.DefaultGlyphChecker;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.EmojiProcessor$ProcessorSm;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.savedstate.SavedStateRegistry;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Data;
import androidx.work.InputMergerFactory$1;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OverwritingInputMerger;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.android.billingclient.api.BillingFlowParams;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda1;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.internal.Utility;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzhhh;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.UnsafeAllocator$4;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaa implements InputContentInfoCompat$InputContentInfoCompatImpl, TaskExecutor, Utility.GraphMeRequestWithCacheCallback, Factory, zzbee, Continuation, ObjectConstructor {
    public static zzaa sInstance;
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public Object zzb;
    public Object zzc;

    public /* synthetic */ zzaa(int i) {
        this.$r8$classId = i;
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
            for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static zzaa obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new zzaa(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    /* JADX INFO: renamed from: build */
    public AutoValue_TransportContext m98build() {
        String strConcat = ((String) this.zza) == null ? FKidOcdAYt.sCNzODvlgVee : "";
        if (((Priority) this.zzc) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new AutoValue_TransportContext((String) this.zza, (byte[]) this.zzb, (Priority) this.zzc);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        try {
            return ((Streams) this.zza).newInstance((Class) this.zzb);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.zzc) + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }

    public void executeOnBackgroundThread(Runnable runnable) {
        ((SerialExecutor) this.zza).execute(runnable);
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 16:
                return new TransportRuntime(new GraphRequest.Companion(18), new GraphRequest.Companion(17), (Scheduler) ((Request.Builder) this.zza).get(), (Uploader) ((TooltipPopup) this.zzb).get(), (WorkInitializer) ((Dispatcher) this.zzc).get());
            default:
                return new JobInfoScheduler((Context) ((InstanceFactory) this.zza).instance, (EventStore) ((Provider) this.zzb).get(), (AutoValue_SchedulerConfig) ((GraphRequest.Companion) this.zzc).get());
        }
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.zzb;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = ContextCompat.getColorStateList((Context) this.zza, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getContentUri() {
        return (Uri) this.zza;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public ClipDescription getDescription() {
        return (ClipDescription) this.zzb;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.zzb;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : Headers.Companion.getDrawable((Context) this.zza, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable drawable;
        if (!((TypedArray) this.zzb).hasValue(i) || (resourceId = ((TypedArray) this.zzb).getResourceId(i, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = (Context) this.zza;
        synchronized (appCompatDrawableManager) {
            drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
        }
        return drawable;
    }

    public Typeface getFont(int i, int i2, AppCompatTextHelper.AnonymousClass1 anonymousClass1) {
        int resourceId = ((TypedArray) this.zzb).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.zzc) == null) {
            this.zzc = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.zzc;
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        Context context = (Context) this.zza;
        if (context.isRestricted()) {
            return null;
        }
        Resources resources = context.getResources();
        resources.getValue(resourceId, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            anonymousClass1.callbackFailAsync();
            return null;
        }
        int i3 = typedValue.assetCookie;
        LruCache lruCache = TypefaceCompat.sTypefaceCache;
        Typeface typeface = (Typeface) lruCache.get(TypefaceCompat.createResourceUid(resources, resourceId, string, i3, i2));
        if (typeface != null) {
            new Handler(Looper.getMainLooper()).post(new GraphRequest$Companion$$ExternalSyntheticLambda1(anonymousClass1, typeface, 3));
            return typeface;
        }
        try {
            if (string.toLowerCase().endsWith(".xml")) {
                FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry = CamUtils.parse(resources.getXml(resourceId), resources);
                if (fontResourcesParserCompat$FamilyResourceEntry != null) {
                    return TypefaceCompat.createFromResourcesFamilyXml(context, fontResourcesParserCompat$FamilyResourceEntry, resources, resourceId, string, typedValue.assetCookie, i2, anonymousClass1);
                }
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                anonymousClass1.callbackFailAsync();
                return null;
            }
            int i4 = typedValue.assetCookie;
            Typeface typefaceCreateFromResourcesFontFile = TypefaceCompat.sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, resourceId, string, i2);
            if (typefaceCreateFromResourcesFontFile != null) {
                lruCache.put(TypefaceCompat.createResourceUid(resources, resourceId, string, i4, i2), typefaceCreateFromResourcesFontFile);
            }
            if (typefaceCreateFromResourcesFontFile != null) {
                new Handler(Looper.getMainLooper()).post(new GraphRequest$Companion$$ExternalSyntheticLambda1(anonymousClass1, typefaceCreateFromResourcesFontFile, 3));
            } else {
                anonymousClass1.callbackFailAsync();
            }
            return typefaceCreateFromResourcesFontFile;
        } catch (IOException e) {
            Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e);
            anonymousClass1.callbackFailAsync();
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e2);
            anonymousClass1.callbackFailAsync();
            return null;
        }
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Object getInputContentInfo() {
        return null;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getLinkUri() {
        return (Uri) this.zzc;
    }

    public SystemIdInfo getSystemIdInfo(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?");
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.zza;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? new SystemIdInfo(cursorQuery.getString(MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "work_spec_id")), cursorQuery.getInt(MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "system_id"))) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) this.zzc;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset = metadataItem.__offset(8);
            if (i__offset != 0) {
                ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos);
            }
            defaultGlyphChecker.getClass();
            ThreadLocal threadLocal = DefaultGlyphChecker.sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = defaultGlyphChecker.mTextPaint;
            String string = sb.toString();
            int i3 = PaintCompat.$r8$clinit;
            boolean zHasGlyph = PaintCompat.Api23Impl.hasGlyph(textPaint, string);
            int i4 = typefaceEmojiRasterizer.mCache & 4;
            typefaceEmojiRasterizer.mCache = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (typefaceEmojiRasterizer.mCache & 3) == 2;
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.zza;
        workDatabase_Impl.assertNotSuspendingTransaction();
        workDatabase_Impl.beginTransaction();
        try {
            ((WorkTagDao_Impl$1) this.zzb).insert(systemIdInfo);
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
        }
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        GetTokenLoginMethodHandler getTokenLoginMethodHandler = (GetTokenLoginMethodHandler) this.zzb;
        LoginClient loginClient = getTokenLoginMethodHandler.getLoginClient();
        LoginClient.Request request = getTokenLoginMethodHandler.getLoginClient().pendingRequest;
        String message = facebookException == null ? null : facebookException.getMessage();
        ArrayList arrayList = new ArrayList();
        arrayList.add("Caught exception");
        if (message != null) {
            arrayList.add(message);
        }
        loginClient.complete(new LoginClient.Result(request, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        String string;
        Bundle bundle = (Bundle) this.zza;
        GetTokenLoginMethodHandler getTokenLoginMethodHandler = (GetTokenLoginMethodHandler) this.zzb;
        if (jSONObject == null) {
            string = null;
        } else {
            try {
                string = jSONObject.getString("id");
            } catch (JSONException e) {
                LoginClient loginClient = getTokenLoginMethodHandler.getLoginClient();
                LoginClient.Request request = getTokenLoginMethodHandler.getLoginClient().pendingRequest;
                String message = e.getMessage();
                ArrayList arrayList = new ArrayList();
                arrayList.add("Caught exception");
                if (message != null) {
                    arrayList.add(message);
                }
                loginClient.complete(new LoginClient.Result(request, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
                return;
            }
        }
        bundle.putString("com.facebook.platform.extra.USER_ID", string);
        getTokenLoginMethodHandler.onComplete((LoginClient.Request) this.zzc, bundle);
    }

    public void postDispatchRunnable(Lifecycle.Event event) {
        DefaultSpecialEffectsController.AnonymousClass6 anonymousClass6 = (DefaultSpecialEffectsController.AnonymousClass6) this.zzc;
        if (anonymousClass6 != null) {
            anonymousClass6.run();
        }
        DefaultSpecialEffectsController.AnonymousClass6 anonymousClass7 = new DefaultSpecialEffectsController.AnonymousClass6((LifecycleRegistry) this.zza, event);
        this.zzc = anonymousClass7;
        ((Handler) this.zzb).postAtFrontOfQueue(anonymousClass7);
    }

    public Object process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessor$EmojiProcessCallback emojiProcessor$EmojiProcessCallback) {
        int i4;
        char c;
        EmojiProcessor$ProcessorSm emojiProcessor$ProcessorSm = new EmojiProcessor$ProcessorSm((MetadataRepo$Node) ((Dispatcher) this.zzb).runningAsyncCalls);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        boolean zHandleEmoji = true;
        int i5 = 0;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (true) {
                if (iCharCount < i2 && i5 < i3 && zHandleEmoji) {
                    SparseArray sparseArray = emojiProcessor$ProcessorSm.mCurrentNode.mChildren;
                    MetadataRepo$Node metadataRepo$Node = sparseArray == null ? null : (MetadataRepo$Node) sparseArray.get(iCodePointAt);
                    if (emojiProcessor$ProcessorSm.mState == 2) {
                        if (metadataRepo$Node != null) {
                            emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                            emojiProcessor$ProcessorSm.mCurrentDepth++;
                        } else {
                            if (iCodePointAt == 65038) {
                                emojiProcessor$ProcessorSm.reset();
                            } else if (iCodePointAt != 65039) {
                                MetadataRepo$Node metadataRepo$Node2 = emojiProcessor$ProcessorSm.mCurrentNode;
                                if (metadataRepo$Node2.mData != null) {
                                    if (emojiProcessor$ProcessorSm.mCurrentDepth != 1) {
                                        emojiProcessor$ProcessorSm.mFlushNode = metadataRepo$Node2;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else if (emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        emojiProcessor$ProcessorSm.mFlushNode = emojiProcessor$ProcessorSm.mCurrentNode;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else {
                                        emojiProcessor$ProcessorSm.reset();
                                    }
                                    c = 3;
                                } else {
                                    emojiProcessor$ProcessorSm.reset();
                                }
                            }
                            c = 1;
                        }
                        c = 2;
                    } else if (metadataRepo$Node == null) {
                        emojiProcessor$ProcessorSm.reset();
                        c = 1;
                    } else {
                        emojiProcessor$ProcessorSm.mState = 2;
                        emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                        emojiProcessor$ProcessorSm.mCurrentDepth = 1;
                        c = 2;
                    }
                    emojiProcessor$ProcessorSm.mLastCodepoint = iCodePointAt;
                    if (c == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                        if (iCharCount >= i2) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c == 3) {
                        if (!z && hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData)) {
                            break;
                        }
                        zHandleEmoji = emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData);
                        i5++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (emojiProcessor$ProcessorSm.mState == 2 && emojiProcessor$ProcessorSm.mCurrentNode.mData != null && ((emojiProcessor$ProcessorSm.mCurrentDepth > 1 || emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) && i5 < i3 && zHandleEmoji && (z || !hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData)))) {
            emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData);
        }
        return emojiProcessor$EmojiProcessCallback.getResult();
    }

    public void recycle() {
        ((TypedArray) this.zzb).recycle();
    }

    public void removeSystemIdInfo(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.zza;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = (WorkSpecDao_Impl.AnonymousClass2) this.zzc;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(1, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public void requestPermission() {
    }

    public void send(AutoValue_Event autoValue_Event) {
        DifferentialMotionFlingController$$ExternalSyntheticLambda0 differentialMotionFlingController$$ExternalSyntheticLambda0 = new DifferentialMotionFlingController$$ExternalSyntheticLambda0(19);
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.zza;
        Encoding encoding = (Encoding) this.zzb;
        TransportRuntime transportRuntime = (TransportRuntime) this.zzc;
        Priority priority = Priority.DEFAULT;
        zzaa zzaaVarBuilder = AutoValue_TransportContext.builder();
        zzaaVarBuilder.setBackendName(autoValue_TransportContext.backendName);
        zzaaVarBuilder.zzc = priority;
        zzaaVarBuilder.zzb = autoValue_TransportContext.extras;
        AutoValue_TransportContext autoValue_TransportContextM98build = zzaaVarBuilder.m98build();
        Request request = new Request(2);
        request.tags = new HashMap();
        request.headers = Long.valueOf(transportRuntime.eventClock.getTime());
        request.body = Long.valueOf(transportRuntime.uptimeClock.getTime());
        request.method = "PLAY_BILLING_LIBRARY";
        request.url = new EncodedPayload(encoding, autoValue_Event.payload.zzc());
        request.lazyCacheControl = null;
        AutoValue_EventInternal autoValue_EventInternalBuild = request.build();
        DefaultScheduler defaultScheduler = (DefaultScheduler) transportRuntime.scheduler;
        defaultScheduler.getClass();
        defaultScheduler.executor.execute(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(defaultScheduler, autoValue_TransportContextM98build, differentialMotionFlingController$$ExternalSyntheticLambda0, autoValue_EventInternalBuild));
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(((FirebaseUser) this.zzc).zza());
        String token = getTokenResult.getToken();
        com.google.android.gms.common.internal.zzah.checkNotNull(token);
        return firebaseAuth.zzr(token, (String) this.zza, (ActionCodeSettings) this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public void zza() {
        zzbef zzbefVar = (zzbef) this.zza;
        RoomOpenHelper roomOpenHelperBuild = new BillingFlowParams(zzbefVar.zza()).build();
        Context context = (Context) this.zzb;
        ((Intent) roomOpenHelperBuild.mConfiguration).setPackage(zzhhh.zza(context));
        roomOpenHelperBuild.launchUrl(context, (Uri) this.zzc);
        zzbefVar.zzf((Activity) context);
    }

    public zzaa(FirebaseUser firebaseUser, String str, ActionCodeSettings actionCodeSettings) {
        this.$r8$classId = 0;
        this.zzc = firebaseUser;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public void setBackendName(String str) {
        if (str == null) {
            throw new NullPointerException(kBfGXgdfpo.Tdz);
        }
        this.zza = str;
    }

    public /* synthetic */ zzaa(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public zzaa(String str, byte[] bArr, String str2) {
        this.$r8$classId = 20;
        this.zzb = bArr;
        this.zza = str;
        this.zzc = str2;
    }

    public zzaa(com.google.android.gms.ads.internal.util.zzs zzsVar, zzbef zzbefVar, Context context, Uri uri) {
        this.$r8$classId = 18;
        this.zza = zzbefVar;
        this.zzb = context;
        this.zzc = uri;
        Objects.requireNonNull(zzsVar);
    }

    public zzaa(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 9;
        this.zza = workDatabase_Impl;
        this.zzb = new WorkTagDao_Impl$1(workDatabase_Impl, 3);
        this.zzc = new WorkSpecDao_Impl.AnonymousClass2(workDatabase_Impl, 1);
    }

    public OneTimeWorkRequest build() {
        UUID uuid = (UUID) this.zza;
        WorkSpec workSpec = (WorkSpec) this.zzb;
        HashSet hashSet = (HashSet) this.zzc;
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest();
        oneTimeWorkRequest.mId = uuid;
        oneTimeWorkRequest.mWorkSpec = workSpec;
        oneTimeWorkRequest.mTags = hashSet;
        Constraints constraints = workSpec.constraints;
        boolean z = (Build.VERSION.SDK_INT >= 24 && constraints.mContentUriTriggers.mTriggers.size() > 0) || constraints.mRequiresBatteryNotLow || constraints.mRequiresCharging || constraints.mRequiresDeviceIdle;
        if (((WorkSpec) this.zzb).expedited && z) {
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }
        this.zza = UUID.randomUUID();
        WorkSpec workSpec2 = (WorkSpec) this.zzb;
        WorkSpec workSpec3 = new WorkSpec();
        workSpec3.state = 1;
        Data data = Data.EMPTY;
        workSpec3.input = data;
        workSpec3.output = data;
        workSpec3.constraints = Constraints.NONE;
        workSpec3.backoffPolicy = 1;
        workSpec3.backoffDelayDuration = 30000L;
        workSpec3.scheduleRequestedAt = -1L;
        workSpec3.outOfQuotaPolicy = 1;
        workSpec3.id = workSpec2.id;
        workSpec3.workerClassName = workSpec2.workerClassName;
        workSpec3.state = workSpec2.state;
        workSpec3.inputMergerClassName = workSpec2.inputMergerClassName;
        workSpec3.input = new Data(workSpec2.input);
        workSpec3.output = new Data(workSpec2.output);
        workSpec3.initialDelay = workSpec2.initialDelay;
        workSpec3.intervalDuration = workSpec2.intervalDuration;
        workSpec3.flexDuration = workSpec2.flexDuration;
        Constraints constraints2 = workSpec2.constraints;
        Constraints constraints3 = new Constraints();
        constraints3.mRequiredNetworkType = 1;
        constraints3.mTriggerContentUpdateDelay = -1L;
        constraints3.mTriggerMaxContentDelay = -1L;
        constraints3.mContentUriTriggers = new ContentUriTriggers();
        constraints3.mRequiresCharging = constraints2.mRequiresCharging;
        constraints3.mRequiresDeviceIdle = constraints2.mRequiresDeviceIdle;
        constraints3.mRequiredNetworkType = constraints2.mRequiredNetworkType;
        constraints3.mRequiresBatteryNotLow = constraints2.mRequiresBatteryNotLow;
        constraints3.mRequiresStorageNotLow = constraints2.mRequiresStorageNotLow;
        constraints3.mContentUriTriggers = constraints2.mContentUriTriggers;
        workSpec3.constraints = constraints3;
        workSpec3.runAttemptCount = workSpec2.runAttemptCount;
        workSpec3.backoffPolicy = workSpec2.backoffPolicy;
        workSpec3.backoffDelayDuration = workSpec2.backoffDelayDuration;
        workSpec3.periodStartTime = workSpec2.periodStartTime;
        workSpec3.minimumRetentionDuration = workSpec2.minimumRetentionDuration;
        workSpec3.scheduleRequestedAt = workSpec2.scheduleRequestedAt;
        workSpec3.expedited = workSpec2.expedited;
        workSpec3.outOfQuotaPolicy = workSpec2.outOfQuotaPolicy;
        this.zzb = workSpec3;
        workSpec3.id = ((UUID) this.zza).toString();
        return oneTimeWorkRequest;
    }

    public ViewModel get(Class cls, String key) {
        ViewModel viewModel;
        Intrinsics.checkNotNullParameter(key, "key");
        ViewModelStore viewModelStore = (ViewModelStore) this.zza;
        viewModelStore.getClass();
        LinkedHashMap linkedHashMap = viewModelStore.map;
        ViewModel viewModel2 = (ViewModel) linkedHashMap.get(key);
        boolean zIsInstance = cls.isInstance(viewModel2);
        ViewModelProvider$Factory viewModelProvider$Factory = (ViewModelProvider$Factory) this.zzb;
        if (zIsInstance) {
            SavedStateViewModelFactory savedStateViewModelFactory = viewModelProvider$Factory instanceof SavedStateViewModelFactory ? (SavedStateViewModelFactory) viewModelProvider$Factory : null;
            if (savedStateViewModelFactory != null) {
                Intrinsics.checkNotNull(viewModel2);
                Lifecycle lifecycle = savedStateViewModelFactory.lifecycle;
                if (lifecycle != null) {
                    SavedStateRegistry savedStateRegistry = savedStateViewModelFactory.savedStateRegistry;
                    Intrinsics.checkNotNull(savedStateRegistry);
                    ViewTreeLifecycleOwner.attachHandleIfNeeded(viewModel2, savedStateRegistry, lifecycle);
                }
            }
            Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return viewModel2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) this.zzc);
        mutableCreationExtras.map.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1, key);
        try {
            viewModel = viewModelProvider$Factory.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            viewModel = viewModelProvider$Factory.create(cls);
        }
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ViewModel viewModel3 = (ViewModel) linkedHashMap.put(key, viewModel);
        if (viewModel3 != null) {
            viewModel3.onCleared();
        }
        return viewModel;
    }

    public zzaa(LifecycleService lifecycleService) {
        this.$r8$classId = 5;
        this.zza = new LifecycleRegistry(lifecycleService);
        this.zzb = new Handler();
    }

    public zzaa(AutoValue_TransportContext autoValue_TransportContext, Encoding encoding, InputMergerFactory$1 inputMergerFactory$1, TransportRuntime transportRuntime) {
        this.$r8$classId = 15;
        this.zza = autoValue_TransportContext;
        this.zzb = encoding;
        this.zzc = transportRuntime;
    }

    public zzaa(ExecutorService executorService) {
        this.$r8$classId = 10;
        this.zzb = new Handler(Looper.getMainLooper());
        this.zzc = new com.google.android.gms.tasks.zzu(this, 2);
        this.zza = new SerialExecutor(executorService);
    }

    public zzaa(ViewModelStore store, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras defaultCreationExtras) {
        this.$r8$classId = 6;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.zza = store;
        this.zzb = viewModelProvider$Factory;
        this.zzc = defaultCreationExtras;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzaa(ViewModelStore store, ViewModelProvider$Factory viewModelProvider$Factory) {
        this(store, viewModelProvider$Factory, CreationExtras.Empty.INSTANCE);
        this.$r8$classId = 6;
        Intrinsics.checkNotNullParameter(store, "store");
    }

    public zzaa(Context context, TypedArray typedArray) {
        this.$r8$classId = 2;
        this.zza = context;
        this.zzb = typedArray;
    }

    public zzaa(Context context, LocationManager locationManager) {
        this.$r8$classId = 1;
        this.zzc = new TwilightManager$TwilightState();
        this.zza = context;
        this.zzb = locationManager;
    }

    public zzaa(Class cls) {
        this.$r8$classId = 7;
        this.zzc = new HashSet();
        this.zza = UUID.randomUUID();
        this.zzb = new WorkSpec(((UUID) this.zza).toString(), cls.getName());
        ((HashSet) this.zzc).add(cls.getName());
        ((WorkSpec) this.zzb).inputMergerClassName = OverwritingInputMerger.class.getName();
    }

    public zzaa(Dispatcher dispatcher, InputMergerFactory$1 inputMergerFactory$1, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.$r8$classId = 4;
        this.zza = inputMergerFactory$1;
        this.zzb = dispatcher;
        this.zzc = defaultGlyphChecker;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new Symbol(str, 1));
        }
    }

    public zzaa() {
        this.$r8$classId = 8;
        this.zza = Collections.emptyList();
        this.zzb = Collections.emptyList();
    }

    public zzaa(Class cls, Type type) {
        Object unsafeAllocator$4;
        this.$r8$classId = 21;
        this.zzb = cls;
        this.zzc = type;
        try {
            try {
                try {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls2.getMethod("allocateInstance", Class.class);
                    unsafeAllocator$4 = new Streams() { // from class: com.google.gson.internal.UnsafeAllocator$1
                        @Override // com.google.gson.internal.Streams
                        public final Object newInstance(Class cls3) {
                            Streams.assertInstantiable(cls3);
                            return method.invoke(obj, cls3);
                        }
                    };
                } catch (Exception unused) {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    unsafeAllocator$4 = new Streams() { // from class: com.google.gson.internal.UnsafeAllocator$2
                        @Override // com.google.gson.internal.Streams
                        public final Object newInstance(Class cls3) {
                            Streams.assertInstantiable(cls3);
                            return declaredMethod2.invoke(null, cls3, Integer.valueOf(iIntValue));
                        }
                    };
                }
            } catch (Exception unused2) {
                final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                unsafeAllocator$4 = new Streams() { // from class: com.google.gson.internal.UnsafeAllocator$3
                    @Override // com.google.gson.internal.Streams
                    public final Object newInstance(Class cls3) {
                        Streams.assertInstantiable(cls3);
                        return declaredMethod3.invoke(null, cls3, Object.class);
                    }
                };
            }
        } catch (Exception unused3) {
            unsafeAllocator$4 = new UnsafeAllocator$4();
        }
        this.zza = unsafeAllocator$4;
    }
}
