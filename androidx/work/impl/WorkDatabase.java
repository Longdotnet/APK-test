package androidx.work.impl;

import android.app.Service;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.android.billingclient.api.BillingFlowParams;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.auth.zzaa;
import java.util.concurrent.TimeUnit;
import kotlin.io.CloseableKt;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: androidx.work.impl.WorkDatabase$1 */
    public final class AnonymousClass1 implements SupportSQLiteOpenHelper.Factory {
        public final Context val$context;

        public /* synthetic */ AnonymousClass1(Context context) {
            this.val$context = context;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
        public SupportSQLiteOpenHelper create(BillingFlowParams billingFlowParams) {
            RoomOpenHelper roomOpenHelper = (RoomOpenHelper) billingFlowParams.zzf;
            if (roomOpenHelper == null) {
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }
            Context context = this.val$context;
            if (context == null) {
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            }
            String str = (String) billingFlowParams.zze;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
            BillingFlowParams billingFlowParams2 = new BillingFlowParams(context, str, roomOpenHelper, true);
            return new FrameworkSQLiteOpenHelper((Context) billingFlowParams2.zzd, (String) billingFlowParams2.zze, (RoomOpenHelper) billingFlowParams2.zzf, billingFlowParams2.zza);
        }

        public ApplicationInfo getApplicationInfo(int i, String str) {
            return this.val$context.getPackageManager().getApplicationInfo(str, i);
        }

        public CharSequence getApplicationLabel(String str) {
            Context context = this.val$context;
            return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
        }

        public PackageInfo getPackageInfo(int i, String str) {
            return this.val$context.getPackageManager().getPackageInfo(str, i);
        }

        public boolean isCallerInstantApp() {
            String nameForUid;
            int callingUid = Binder.getCallingUid();
            int iMyUid = Process.myUid();
            Context context = this.val$context;
            if (callingUid == iMyUid) {
                return CloseableKt.isInstantApp(context);
            }
            if (!Hex.isAtLeastO() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
                return false;
            }
            return context.getPackageManager().isInstantApp(nameForUid);
        }

        public AnonymousClass1(Service service) {
            zzah.checkNotNull(service);
            Context applicationContext = service.getApplicationContext();
            zzah.checkNotNull(applicationContext);
            this.val$context = applicationContext;
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.WorkDatabase$2 */
    public final class AnonymousClass2 {
    }

    public abstract RoomOpenHelper dependencyDao();

    public abstract RoomOpenHelper preferenceDao();

    public abstract zzaa systemIdInfoDao();

    public abstract RoomOpenHelper workNameDao();

    public abstract Dispatcher workProgressDao();

    public abstract WorkSpecDao_Impl workSpecDao();

    public abstract RoomOpenHelper workTagDao();
}
