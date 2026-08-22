package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeProtocol {
    public static final NativeProtocol INSTANCE;
    public static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final ArrayList facebookAppInfoList;
    public static final AtomicBoolean protocolVersionsAsyncUpdating;

    static {
        int i = 3;
        int i2 = 1;
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        ArrayList arrayList = null;
        if (!CrashShieldHandler.isObjectCrashing(nativeProtocol)) {
            try {
                ArrayList arrayListArrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new KatanaAppInfo(i2));
                arrayListArrayListOf.addAll(nativeProtocol.buildFacebookAppList());
                arrayList = arrayListArrayListOf;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(nativeProtocol, th);
            }
        }
        NativeProtocol nativeProtocol2 = INSTANCE;
        if (!CrashShieldHandler.isObjectCrashing(nativeProtocol2)) {
            try {
                HashMap map = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new KatanaAppInfo(i));
                ArrayList arrayList3 = facebookAppInfoList;
                map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.FEED_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.LIKE_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList2);
                map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList2);
                map.put("com.facebook.platform.action.request.CAMERA_EFFECT", arrayList);
                map.put("com.facebook.platform.action.request.SHARE_STORY", arrayList3);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(nativeProtocol2, th2);
            }
        }
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{20210906, 20171115, 20170417, 20170411, 20170213, 20161017, 20160327, 20150702, 20150401, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140313, 20140204, 20131107, 20131024, 20130618, 20130502, 20121101};
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(TreeSet treeSet, int i, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        if (treeSet == null) {
            return -1;
        }
        try {
            int length = iArr.length - 1;
            Iterator itDescendingIterator = treeSet.descendingIterator();
            int iMax = -1;
            while (itDescendingIterator.hasNext()) {
                Integer fbAppVersion = (Integer) itDescendingIterator.next();
                Intrinsics.checkNotNullExpressionValue(fbAppVersion, "fbAppVersion");
                iMax = Math.max(iMax, fbAppVersion.intValue());
                while (length >= 0 && iArr[length] > fbAppVersion.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == fbAppVersion.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(iMax, i);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
            return 0;
        }
    }

    public static final Intent createPlatformServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Iterator it = facebookAppInfoList.iterator();
            while (it.hasNext()) {
                Intent intentAddCategory = new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(((KatanaAppInfo) it.next()).getPackage()).addCategory("android.intent.category.DEFAULT");
                if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intentAddCategory == null) {
                    intentAddCategory = null;
                } else {
                    try {
                        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intentAddCategory, 0);
                        if (resolveInfoResolveService != null) {
                            HashSet hashSet = FacebookSignatureValidator.validAppSignatureHashes;
                            String str = resolveInfoResolveService.serviceInfo.packageName;
                            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.serviceInfo.packageName");
                            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                            }
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                    }
                    intentAddCategory = null;
                }
                if (intentAddCategory != null) {
                    return intentAddCategory;
                }
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th2);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        String stringExtra;
        UUID uuidFromString;
        Bundle bundle2;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                uuidFromString = null;
            } else {
                try {
                    if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                        Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                        stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
                    } else {
                        stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
                    }
                    if (stringExtra != null) {
                        try {
                            uuidFromString = UUID.fromString(stringExtra);
                        } catch (IllegalArgumentException unused) {
                            uuidFromString = null;
                        }
                    } else {
                        uuidFromString = null;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                }
            }
            if (uuidFromString == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(intent));
            Bundle bundle3 = new Bundle();
            bundle3.putString("action_id", uuidFromString.toString());
            if (facebookException != null) {
                if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                    bundle2 = null;
                    bundle3.putBundle("error", bundle2);
                } else {
                    try {
                        bundle2 = new Bundle();
                        bundle2.putString("error_description", facebookException.toString());
                        if (facebookException instanceof FacebookOperationCanceledException) {
                            bundle2.putString("error_type", "UserCanceled");
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(NativeProtocol.class, th2);
                        bundle2 = null;
                    }
                    bundle3.putBundle("error", bundle2);
                }
            }
            intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle3);
            if (bundle != null) {
                intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
            }
            return intent2;
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th3);
            return null;
        }
    }

    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? intent.getExtras() : intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
            return null;
        }
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return ArraysKt.contains(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i)) && i >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
            return false;
        }
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new AppEventQueue$$ExternalSyntheticLambda0(14));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
        }
    }

    public final ArrayList buildFacebookAppList() {
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return CollectionsKt__CollectionsKt.arrayListOf(new KatanaAppInfo(i), new KatanaAppInfo(4));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final Intent createNativeAppIntent(KatanaAppInfo katanaAppInfo, String str, HashSet hashSet, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2, String str5, boolean z3, LoginTargetApp loginTargetApp, boolean z4, boolean z5, String str6) {
        String str7;
        String str8 = "com.facebook.katana.ProxyAuth";
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            switch (katanaAppInfo.$r8$classId) {
                case 1:
                case 3:
                    str8 = null;
                    break;
                case 2:
                    str8 = "com.instagram.platform.AppAuthorizeActivity";
                    break;
            }
            if (str8 == null) {
                return null;
            }
            Intent intentPutExtra = new Intent().setClassName(katanaAppInfo.getPackage(), str8).putExtra("client_id", str);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            intentPutExtra.putExtra("facebook_sdk_version", "16.0.0");
            if (!(hashSet == null || hashSet.isEmpty())) {
                intentPutExtra.putExtra("scope", TextUtils.join(",", hashSet));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                intentPutExtra.putExtra("e2e", str2);
            }
            intentPutExtra.putExtra("state", str3);
            switch (katanaAppInfo.$r8$classId) {
                case 2:
                    str7 = "token,signed_request,graph_domain,granted_scopes";
                    break;
                default:
                    str7 = "id_token,token,signed_request,graph_domain";
                    break;
            }
            intentPutExtra.putExtra("response_type", str7);
            intentPutExtra.putExtra("nonce", str6);
            intentPutExtra.putExtra("return_scopes", "true");
            if (z) {
                intentPutExtra.putExtra(ehgOP.xqNLsdvnTdlLmsI, defaultAudience.nativeProtocolAudience);
            }
            intentPutExtra.putExtra(YcVWhnLsj.YDJRQJfLbiH, FacebookSdk.getGraphApiVersion());
            intentPutExtra.putExtra("auth_type", str4);
            if (z2) {
                intentPutExtra.putExtra("fail_on_logged_out", true);
            }
            intentPutExtra.putExtra("messenger_page_id", str5);
            intentPutExtra.putExtra("reset_messenger_state", z3);
            if (z4) {
                intentPutExtra.putExtra("fx_app", loginTargetApp.targetApp);
            }
            if (z5) {
                intentPutExtra.putExtra("skip_dedupe", true);
            }
            return intentPutExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final TreeSet fetchAllAvailableProtocolVersionsForAppInfo(KatanaAppInfo katanaAppInfo) {
        Uri uri;
        Cursor cursor;
        ProviderInfo providerInfoResolveContentProvider;
        Cursor cursorQuery;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            TreeSet treeSet = new TreeSet();
            ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
            String[] strArr = {"version"};
            if (CrashShieldHandler.isObjectCrashing(this)) {
                uri = null;
            } else {
                try {
                    Uri uri2 = Uri.parse("content://" + katanaAppInfo.getPackage() + ".provider.PlatformProvider/versions");
                    Intrinsics.checkNotNullExpressionValue(uri2, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
                    uri = uri2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                    uri = null;
                }
            }
            try {
                try {
                    providerInfoResolveContentProvider = FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider(Intrinsics.stringPlus(".provider.PlatformProvider", katanaAppInfo.getPackage()), 0);
                } catch (RuntimeException e) {
                    Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.", e);
                    providerInfoResolveContentProvider = null;
                }
                if (providerInfoResolveContentProvider != null) {
                    try {
                        try {
                            cursorQuery = contentResolver.query(uri, strArr, null, null, null);
                        } catch (NullPointerException unused) {
                            Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                            cursorQuery = null;
                        } catch (SecurityException unused2) {
                            Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                            cursorQuery = null;
                        }
                    } catch (IllegalArgumentException unused3) {
                        Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                        cursorQuery = null;
                    }
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                treeSet.add(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("version"))));
                            } catch (Throwable th2) {
                                cursor = cursorQuery;
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    cursorQuery = null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return treeSet;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(this, th4);
            return null;
        }
    }

    public final Logger$LogcatLogger getLatestAvailableProtocolVersionForAppInfoList(ArrayList arrayList, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (arrayList == null) {
                Logger$LogcatLogger logger$LogcatLogger = new Logger$LogcatLogger();
                logger$LogcatLogger.mLoggingLevel = -1;
                return logger$LogcatLogger;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                KatanaAppInfo katanaAppInfo = (KatanaAppInfo) it.next();
                TreeSet treeSet = katanaAppInfo.availableVersions;
                int iIntValue = 0;
                if (treeSet == null || !Boolean.valueOf(treeSet.isEmpty()).equals(Boolean.FALSE)) {
                    katanaAppInfo.fetchAvailableVersions(false);
                }
                TreeSet treeSet2 = katanaAppInfo.availableVersions;
                if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                    try {
                        iIntValue = KNOWN_PROTOCOL_VERSIONS[0].intValue();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                    }
                }
                int iComputeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(treeSet2, iIntValue, iArr);
                if (iComputeLatestAvailableVersionFromVersionSpec != -1) {
                    Logger$LogcatLogger logger$LogcatLogger2 = new Logger$LogcatLogger();
                    logger$LogcatLogger2.mLoggingLevel = iComputeLatestAvailableVersionFromVersionSpec;
                    return logger$LogcatLogger2;
                }
            }
            Logger$LogcatLogger logger$LogcatLogger3 = new Logger$LogcatLogger();
            logger$LogcatLogger3.mLoggingLevel = -1;
            return logger$LogcatLogger3;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }

    public static final int getProtocolVersionFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return intent.getIntExtra(mnwSv.AHleDchuSZiy, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
            return 0;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class KatanaAppInfo {
        public final /* synthetic */ int $r8$classId;
        public TreeSet availableVersions;

        public /* synthetic */ KatanaAppInfo(int i) {
            this.$r8$classId = i;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001a A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0003, B:6:0x0007, B:20:0x0031, B:22:0x0035, B:24:0x003b, B:25:0x003d, B:27:0x0041, B:29:0x004f, B:37:0x0060, B:36:0x005d, B:11:0x001a, B:19:0x002f, B:18:0x002c, B:15:0x0026), top: B:42:0x0003, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        public final synchronized void fetchAvailableVersions(boolean z) {
            NativeProtocol nativeProtocol;
            TreeSet treeSetFetchAllAvailableProtocolVersionsForAppInfo;
            if (z) {
                nativeProtocol = NativeProtocol.INSTANCE;
                treeSetFetchAllAvailableProtocolVersionsForAppInfo = null;
                if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                    treeSetFetchAllAvailableProtocolVersionsForAppInfo = nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
                }
                this.availableVersions = treeSetFetchAllAvailableProtocolVersionsForAppInfo;
            } else {
                try {
                    TreeSet treeSet = this.availableVersions;
                    if (treeSet == null || !Intrinsics.areEqual(Boolean.valueOf(treeSet.isEmpty()), Boolean.FALSE)) {
                        nativeProtocol = NativeProtocol.INSTANCE;
                        treeSetFetchAllAvailableProtocolVersionsForAppInfo = null;
                        if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                            try {
                                treeSetFetchAllAvailableProtocolVersionsForAppInfo = nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                            }
                        }
                        this.availableVersions = treeSetFetchAllAvailableProtocolVersionsForAppInfo;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            TreeSet treeSet2 = this.availableVersions;
            if (treeSet2 == null || treeSet2.isEmpty()) {
                switch (this.$r8$classId) {
                    case 0:
                        if (FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30) {
                            Log.w(CrashShieldHandler.isObjectCrashing(NativeProtocol.class) ? null : "com.facebook.internal.NativeProtocol", "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
                        }
                        break;
                    default:
                        break;
                }
                throw th2;
            }
        }

        public final String getPackage() {
            switch (this.$r8$classId) {
                case 0:
                    return "com.facebook.katana";
                case 1:
                    return "com.facebook.arstudio.player";
                case 2:
                    return "com.instagram.android";
                case 3:
                    return "com.facebook.orca";
                default:
                    return "com.facebook.wakizashi";
            }
        }

        public final void onAvailableVersionsNullOrEmpty$com$facebook$internal$NativeProtocol$NativeAppInfo() {
        }
    }
}
