package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;

/* JADX INFO: loaded from: classes2.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                AppInitializer appInitializer = AppInitializer.getInstance(context);
                Context context2 = appInitializer.mContext;
                try {
                    try {
                        Trace.beginSection(eoBKjVuj.JdEqZAPdA);
                        appInitializer.discoverAndInitialize(context2.getPackageManager().getProviderInfo(new ComponentName(context2.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                        Trace.endSection();
                        return true;
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new StartupException(e);
                    }
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            return true;
        }
        throw new StartupException("Context cannot be null");
    }
}
