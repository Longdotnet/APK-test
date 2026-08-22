package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public final Class clientProviderClass;
    public final Method getMethod;
    public final Method putMethod;
    public final Method removeMethod;
    public final Class serverProviderClass;

    public final class AlpnProvider implements InvocationHandler {
        public final ArrayList protocols;
        public String selected;
        public boolean unsupported;

        public AlpnProvider(ArrayList arrayList) {
            this.protocols = arrayList;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.areEqual(name, "supports") && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics.areEqual(name, "unsupported") && Intrinsics.areEqual(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            boolean zAreEqual = Intrinsics.areEqual(name, "protocols");
            ArrayList arrayList = this.protocols;
            if (zAreEqual && objArr.length == 0) {
                return arrayList;
            }
            if ((Intrinsics.areEqual(name, "selectProtocol") || Intrinsics.areEqual(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj2 = list.get(i);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (arrayList.contains(str)) {
                                this.selected = str;
                                return str;
                            }
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    String str2 = (String) arrayList.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!Intrinsics.areEqual(name, "protocolSelected") && !Intrinsics.areEqual(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.selected = (String) obj3;
            return null;
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : protocols) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Protocol) it.next()).protocol);
        }
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(arrayList2)));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            boolean z = alpnProvider.unsupported;
            if (!z && alpnProvider.selected == null) {
                Platform.log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z) {
                return null;
            }
            return alpnProvider.selected;
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
