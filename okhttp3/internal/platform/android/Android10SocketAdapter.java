package okhttp3.internal.platform.android;

import android.net.ssl.SSLSockets;
import android.os.Build;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.firebase.auth.zzr;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
public final class Android10SocketAdapter implements SocketAdapter {
    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) throws IOException {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sslParameters = sSLSocket.getSSLParameters();
            Intrinsics.checkNotNullExpressionValue(sslParameters, "sslParameters");
            Platform platform = Platform.platform;
            Object[] array = zzr.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        Platform platform = Platform.platform;
        return zzr.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(MnHfHMYQDPUO.loOxIXuCNqpsWTS))) {
            return null;
        }
        return applicationProtocol;
    }
}
