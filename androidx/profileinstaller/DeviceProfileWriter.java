package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import com.google.protobuf.DescriptorProtos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceProfileWriter {
    public final String mApkName;
    public final File mCurProfile;
    public final byte[] mDesiredVersion;
    public boolean mDeviceSupportsAotProfile = false;
    public final ProfileInstaller$DiagnosticsCallback mDiagnostics;
    public final Executor mExecutor;
    public DexProfileData[] mProfile;
    public byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, String str, File file) {
        this.mExecutor = executor;
        this.mDiagnostics = profileInstaller$DiagnosticsCallback;
        this.mApkName = str;
        this.mCurProfile = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24 && i <= 34) {
            switch (i) {
                case 24:
                case 25:
                    bArr = Encoding.V001_N;
                    break;
                case 26:
                    bArr = Encoding.V005_O;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    bArr = Encoding.V009_O_MR1;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = Encoding.V010_P;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case 32:
                case 33:
                case 34:
                    bArr = Encoding.V015_S;
                    break;
            }
        }
        this.mDesiredVersion = bArr;
    }

    public final FileInputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived();
            }
            return null;
        }
    }

    public final void result(int i, Serializable serializable) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, i, 0, serializable));
    }
}
