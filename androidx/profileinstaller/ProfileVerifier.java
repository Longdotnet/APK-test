package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.work.InputMergerFactory$1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileVerifier {
    public static final ResolvableFuture sFuture = new ResolvableFuture();
    public static final Object SYNC_OBJ = new Object();
    public static InputMergerFactory$1 sCompilationStatus = null;

    public abstract class Api33Impl {
        public static PackageInfo getPackageInfo(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public final class Cache {
        public final long mInstalledCurrentProfileSize;
        public final long mPackageLastUpdateTime;
        public final int mResultCode;
        public final int mSchema;

        public Cache(long j, int i, int i2, long j2) {
            this.mSchema = i;
            this.mResultCode = i2;
            this.mPackageLastUpdateTime = j;
            this.mInstalledCurrentProfileSize = j2;
        }

        public static Cache readFromFile(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) obj;
            return this.mResultCode == cache.mResultCode && this.mPackageLastUpdateTime == cache.mPackageLastUpdateTime && this.mSchema == cache.mSchema && this.mInstalledCurrentProfileSize == cache.mInstalledCurrentProfileSize;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        public final void writeOnFile(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static long getPackageLastUpdateTime(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static InputMergerFactory$1 setCompilationStatus() {
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(18);
        sCompilationStatus = inputMergerFactory$1;
        sFuture.set(inputMergerFactory$1);
        return sCompilationStatus;
    }

    public static void writeProfileVerification(Context context, boolean z) {
        Cache fromFile;
        int i;
        if (z || sCompilationStatus == null) {
            synchronized (SYNC_OBJ) {
                if (!z) {
                    try {
                        if (sCompilationStatus != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28 && i2 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    int i3 = 0;
                    boolean z2 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z3 = file2.exists() && length2 > 0;
                    try {
                        long packageLastUpdateTime = getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                fromFile = Cache.readFromFile(file3);
                            } catch (IOException unused) {
                                setCompilationStatus();
                                return;
                            }
                        } else {
                            fromFile = null;
                        }
                        if (fromFile != null && fromFile.mPackageLastUpdateTime == packageLastUpdateTime && (i = fromFile.mResultCode) != 2) {
                            i3 = i;
                        } else if (z2) {
                            i3 = 1;
                        } else if (z3) {
                            i3 = 2;
                        }
                        if (z && z3 && i3 != 1) {
                            i3 = 2;
                        }
                        Cache cache = new Cache(packageLastUpdateTime, 1, (fromFile == null || fromFile.mResultCode != 2 || i3 != 1 || length >= fromFile.mInstalledCurrentProfileSize) ? i3 : 3, length2);
                        if (fromFile == null || !fromFile.equals(cache)) {
                            try {
                                cache.writeOnFile(file3);
                            } catch (IOException unused2) {
                            }
                        }
                        setCompilationStatus();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        setCompilationStatus();
                        return;
                    }
                }
                setCompilationStatus();
            }
        }
    }
}
