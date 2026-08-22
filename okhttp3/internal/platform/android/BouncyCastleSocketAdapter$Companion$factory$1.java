package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.JvmClassMappingKt;
import okhttp3.internal.platform.BouncyCastlePlatform;

/* JADX INFO: loaded from: classes3.dex */
public final class BouncyCastleSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        return new BouncyCastleSocketAdapter();
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        boolean z = BouncyCastlePlatform.isSupported;
        JvmClassMappingKt.isSupported();
        return false;
    }
}
