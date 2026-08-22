package okhttp3.internal.platform.android;

import com.google.firebase.auth.zzr;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidSocketAdapter implements SocketAdapter {
    public static final AndroidSocketAdapter$Companion$factory$1 playProviderFactory = new AndroidSocketAdapter$Companion$factory$1();
    public final Method getAlpnSelectedProtocol;
    public final Method setAlpnProtocols;
    public final Method setHostname;
    public final Method setUseSessionTickets;
    public final Class sslSocketClass;

    public AndroidSocketAdapter(Class cls) throws NoSuchMethodException {
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = cls.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, str);
                }
                Method method = this.setAlpnProtocols;
                Platform platform = Platform.platform;
                method.invoke(sSLSocket, zzr.concatLengthPrefixed(protocols));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (!this.sslSocketClass.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e2) {
            if (Intrinsics.areEqual(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = AndroidPlatform.isSupported;
        return AndroidPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.sslSocketClass.isInstance(sSLSocket);
    }
}
