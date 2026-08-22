package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.res.CamUtils;
import androidx.fragment.app.Fragment;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzda;
import com.facebook.ProfileCache;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FontProvider {
    public static final FontProvider$$ExternalSyntheticLambda2 sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda2(0);

    /* JADX INFO: loaded from: classes.dex */
    public interface ContentQueryWrapper {
        void close();

        Cursor query(Uri uri, String[] strArr, String[] strArr2);
    }

    public static zzda getFontFamilyResult(Context context, Request.Builder builder) {
        Cursor cursorQuery;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) builder.method;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(iafHZUfOuHNwvy.eStpkeEkbtelhH, str));
        }
        String str2 = providerInfoResolveContentProvider.packageName;
        String str3 = (String) builder.url;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Found content provider ", str, ", but package was not ", str3));
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        FontProvider$$ExternalSyntheticLambda2 fontProvider$$ExternalSyntheticLambda2 = sByteArrayComparator;
        Collections.sort(arrayList, fontProvider$$ExternalSyntheticLambda2);
        List certs = (List) builder.body;
        if (certs == null) {
            certs = CamUtils.readCerts(resources, 0);
        }
        int i = 0;
        loop1: while (true) {
            cursorQuery = null;
            if (i >= certs.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) certs.get(i));
            Collections.sort(arrayList2, fontProvider$$ExternalSyntheticLambda2);
            if (arrayList.size() == arrayList2.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break loop1;
                    }
                    if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                        break;
                    }
                    i2++;
                }
            }
            i++;
        }
        if (providerInfoResolveContentProvider == null) {
            return new zzda(1, (Object) null);
        }
        String str4 = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str4).build();
        Uri uriBuild2 = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str4).appendPath("file").build();
        ContentQueryWrapper anonymousClass7 = Build.VERSION.SDK_INT < 24 ? new Fragment.AnonymousClass7(context, uriBuild) : new ProfileCache(context, uriBuild);
        try {
            cursorQuery = anonymousClass7.query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, new String[]{(String) builder.headers});
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                arrayList3 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    arrayList3.add(new FontsContractCompat$FontInfo(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0));
                }
            }
            return new zzda(0, (FontsContractCompat$FontInfo[]) arrayList3.toArray(new FontsContractCompat$FontInfo[0]));
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            anonymousClass7.close();
        }
    }
}
