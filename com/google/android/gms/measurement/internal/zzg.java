package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class zzg {
    public static zzdg zza;

    /* JADX INFO: renamed from: zza */
    public static final String[] f3zza = {"ad_activeview", "ad_click", "ad_exposure", "ad_query", "ad_reward", "adunit_exposure", "app_background", "app_clear_data", "app_exception", "app_remove", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "app_upgrade", YcVWhnLsj.KzkdIG, "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "session_start_with_rollout", "user_engagement", FirebaseAnalytics.Event.AD_IMPRESSION, FirebaseAnalytics.Event.SCREEN_VIEW, "ga_extra_parameter", "firebase_campaign"};
    public static final String[] zzb = {FirebaseAnalytics.Event.AD_IMPRESSION};
    public static final String[] zzc = {"_aa", "_ac", "_xa", "_aq", "_ar", "_xu", "_ab", "_cd", "_ae", "_ui", "app_store_refund", DYYbQc.OQMniwpdqICqX, "app_store_subscription_convert", "app_store_subscription_renew", "_ug", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_ssr", "_e", "_ai", "_vs", "_ep", "_cmp"};
    public static final String[] zzd = {FirebaseAnalytics.Event.PURCHASE, FirebaseAnalytics.Event.REFUND, FirebaseAnalytics.Event.ADD_PAYMENT_INFO, JuorMn.jlr, gZrKCJ.iwdrxdqNsRNveLr, FirebaseAnalytics.Event.ADD_TO_WISHLIST, FirebaseAnalytics.Event.BEGIN_CHECKOUT, FirebaseAnalytics.Event.REMOVE_FROM_CART, FirebaseAnalytics.Event.SELECT_ITEM, FirebaseAnalytics.Event.SELECT_PROMOTION, FirebaseAnalytics.Event.VIEW_CART, FirebaseAnalytics.Event.VIEW_ITEM, FirebaseAnalytics.Event.VIEW_ITEM_LIST, FirebaseAnalytics.Event.VIEW_PROMOTION, "ecommerce_purchase", "purchase_refund", "set_checkout_option", "checkout_progress", FirebaseAnalytics.Event.SELECT_CONTENT, FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS};
    public static final String[] zza$1 = {"ga_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "ga_error", "ga_error_value", "ga_error_length", "ga_event_origin", "ga_screen", "ga_screen_class", "ga_screen_id", "ga_previous_screen", "ga_previous_class", "ga_previous_id", "manual_tracking", "message_device_time", "message_id", "message_name", "message_time", kBfGXgdfpo.QSXJR, "message_type", "previous_app_version", "previous_os_version", "topic", JrbhsraGtto.WXUfBfXg, "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "cached_campaign", "deferred_analytics_collection", "ga_session_number", "ga_session_id", "campaign_extra_referrer", "app_in_background", "firebase_feature_rollouts", "firebase_conversion", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "session_number", "session_id"};
    public static final String[] zzb$1 = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_mst", "_ndt", "_nmid", "_nmn", "_nmt", "_nmtid", "_nmc", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_cc", "_dac", "_sno", "_sid", "_cer", "_aib", "_ffr", "_c", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_sno", "_sid"};
    public static final String[] zzc$1 = {FirebaseAnalytics.Param.ITEMS};
    public static final String[] zzd$1 = {FirebaseAnalytics.Param.AFFILIATION, FirebaseAnalytics.Param.COUPON, FirebaseAnalytics.Param.CREATIVE_NAME, UUFMQdNK.WUF, FirebaseAnalytics.Param.CURRENCY, FirebaseAnalytics.Param.DISCOUNT, FirebaseAnalytics.Param.INDEX, FirebaseAnalytics.Param.ITEM_ID, FirebaseAnalytics.Param.ITEM_BRAND, FirebaseAnalytics.Param.ITEM_CATEGORY, FirebaseAnalytics.Param.ITEM_CATEGORY2, FirebaseAnalytics.Param.ITEM_CATEGORY3, FirebaseAnalytics.Param.ITEM_CATEGORY4, FirebaseAnalytics.Param.ITEM_CATEGORY5, FirebaseAnalytics.Param.ITEM_LIST_NAME, FirebaseAnalytics.Param.ITEM_LIST_ID, FirebaseAnalytics.Param.ITEM_NAME, FirebaseAnalytics.Param.ITEM_VARIANT, FirebaseAnalytics.Param.LOCATION_ID, FirebaseAnalytics.Param.PAYMENT_TYPE, ehgOP.EXHlbvdKkpq, FirebaseAnalytics.Param.PROMOTION_ID, FirebaseAnalytics.Param.PROMOTION_NAME, FirebaseAnalytics.Param.QUANTITY, FirebaseAnalytics.Param.SHIPPING, FirebaseAnalytics.Param.SHIPPING_TIER, FirebaseAnalytics.Param.TAX, FirebaseAnalytics.Param.TRANSACTION_ID, FirebaseAnalytics.Param.VALUE, "item_list", "checkout_step", "checkout_option", "item_location_id"};
    public static final String[] zza$2 = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};
    public static final String[] zzb$2 = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_lair", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    public static /* synthetic */ boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static /* synthetic */ boolean zza$1(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzb(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(FirebaseAnalytics.Param.VALUE, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(FirebaseAnalytics.Param.VALUE, ((Long) obj).longValue());
        } else {
            bundle.putString(FirebaseAnalytics.Param.VALUE, obj.toString());
        }
    }

    public static String zzc(Context context, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str)) {
            str = zza(context);
        }
        int identifier = resources.getIdentifier("google_app_id", "string", str);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static Object zza(Bundle bundle, String str, Class cls, Object obj) {
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return obj2;
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Invalid conditional user property field type. '", str, "' expected [", canonicalName, "] but was ["), obj2.getClass().getCanonicalName(), "]"));
    }

    public static void zzb(zzeh zzehVar, SQLiteDatabase sQLiteDatabase) {
        if (zzehVar != null) {
            File file = new File(sQLiteDatabase.getPath());
            boolean readable = file.setReadable(false, false);
            zzef zzefVar = zzehVar.zzg;
            if (!readable) {
                zzefVar.zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzefVar.zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzefVar.zza("Failed to turn on database read permission for owner");
            }
            if (file.setWritable(true, true)) {
                return;
            }
            zzefVar.zza("Failed to turn on database write permission for owner");
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    public static String zzb(String str, String[] strArr, String[] strArr2) {
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00e0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v2 */
    public static void zza(zzeh zzehVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        if (zzehVar != null) {
            zzef zzefVar = zzehVar.zzg;
            ?? r15 = 0;
            try {
                try {
                    cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                    try {
                        boolean zMoveToFirst = cursorQuery.moveToFirst();
                        cursorQuery.close();
                        if (!zMoveToFirst) {
                            sQLiteDatabase.execSQL(str2);
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        zzefVar.zzc(str, "Error querying for table", e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r15 != 0) {
                        r15.close();
                    }
                    throw th;
                }
                try {
                    HashSet hashSet = new HashSet();
                    Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                    try {
                        Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                        cursorRawQuery.close();
                        for (String str4 : str3.split(",")) {
                            if (!hashSet.remove(str4)) {
                                throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                            }
                        }
                        if (strArr != null) {
                            for (int i = 0; i < strArr.length; i += 2) {
                                if (!hashSet.remove(strArr[i])) {
                                    sQLiteDatabase.execSQL(strArr[i + 1]);
                                }
                            }
                        }
                        if (hashSet.isEmpty()) {
                            return;
                        }
                        zzefVar.zzc(str, "Table has extra columns. table, columns", TextUtils.join(", ", hashSet));
                        return;
                    } catch (Throwable th2) {
                        cursorRawQuery.close();
                        throw th2;
                    }
                } catch (SQLiteException e3) {
                    zzehVar.zzd.zzb(str, "Failed to verify columns on table that was just created");
                    throw e3;
                }
            } catch (Throwable th3) {
                th = th3;
                r15 = str2;
                if (r15 != 0) {
                    r15.close();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
