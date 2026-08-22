package okhttp3.internal.platform.android;

import com.google.firebase.auth.zzr;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes3.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final ConscryptSocketAdapter$Companion$factory$1 factory = new ConscryptSocketAdapter$Companion$factory$1();

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (matchesSocket(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = ConscryptPlatform.isSupported;
        return ConscryptPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (matchesSocket(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Platform platform = Platform.platform;
            Object[] array = zzr.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException(JuorMn.cTpUWyTSqqZ);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
