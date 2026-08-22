package okhttp3.internal.platform.android;

import com.google.firebase.auth.zzr;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.Platform;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final BouncyCastleSocketAdapter$Companion$factory$1 factory = new BouncyCastleSocketAdapter$Companion$factory$1();

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (matchesSocket(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters sslParameters = bCSSLSocket.getParameters();
            Intrinsics.checkNotNullExpressionValue(sslParameters, "sslParameters");
            Platform platform = Platform.platform;
            Object[] array = zzr.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(sslParameters);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = BouncyCastlePlatform.isSupported;
        return BouncyCastlePlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return false;
    }
}
