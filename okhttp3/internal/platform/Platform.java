package okhttp3.internal.platform;

import android.util.Log;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.firebase.auth.zzr;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidLogHandler;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes3.dex */
public class Platform {
    public static final Logger logger;
    public static volatile Platform platform;

    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[PHI: r3
  0x0079: PHI (r3v3 okhttp3.internal.platform.Platform) = (r3v1 okhttp3.internal.platform.Platform), (r3v4 okhttp3.internal.platform.Platform) binds: [B:66:0x0169, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a0 A[PHI: r2
  0x00a0: PHI (r2v26 okhttp3.internal.platform.Platform) = 
  (r2v15 okhttp3.internal.platform.Platform)
  (r2v20 okhttp3.internal.platform.Platform)
  (r2v24 okhttp3.internal.platform.Platform)
  (r2v29 okhttp3.internal.platform.Platform)
 binds: [B:56:0x00f5, B:50:0x00e7, B:42:0x00c3, B:34:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:63:0x0110  */
    /* JADX WARN: Code duplicated, block: B:68:0x016d  */
    static {
        Provider provider;
        Provider provider2;
        Platform jdk9Platform;
        String jvmVersion;
        Platform platform2;
        Platform jdk8WithJettyBootPlatform = null;
        if (zzr.isAndroid()) {
            for (Map.Entry entry : AndroidLog.knownLoggers.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger2 = Logger.getLogger(str);
                if (AndroidLog.configuredLoggers.add(logger2)) {
                    Intrinsics.checkNotNullExpressionValue(logger2, "logger");
                    logger2.setUseParentHandlers(false);
                    logger2.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger2.addHandler(AndroidLogHandler.INSTANCE);
                }
            }
            platform2 = Android10Platform.isSupported ? new Android10Platform() : null;
            if (platform2 == null) {
                jdk8WithJettyBootPlatform = AndroidPlatform.isSupported ? new AndroidPlatform() : null;
                Intrinsics.checkNotNull(jdk8WithJettyBootPlatform);
                platform2 = jdk8WithJettyBootPlatform;
            }
        } else {
            Provider provider3 = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider3, "Security.getProviders()[0]");
            if ("Conscrypt".equals(provider3.getName())) {
                jdk9Platform = ConscryptPlatform.isSupported ? new ConscryptPlatform() : null;
                if (jdk9Platform != null) {
                    platform2 = jdk9Platform;
                } else {
                    provider = Security.getProviders()[0];
                    Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
                    if ("BC".equals(provider.getName())) {
                        if (BouncyCastlePlatform.isSupported) {
                            jdk9Platform = new BouncyCastlePlatform();
                        } else {
                            jdk9Platform = null;
                        }
                        if (jdk9Platform != null) {
                            platform2 = jdk9Platform;
                        } else {
                            provider2 = Security.getProviders()[0];
                            Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                            if (RDFWIi.PgrUYH.equals(provider2.getName())) {
                                if (OpenJSSEPlatform.isSupported) {
                                    jdk9Platform = new OpenJSSEPlatform();
                                } else {
                                    jdk9Platform = null;
                                }
                                if (jdk9Platform != null) {
                                    platform2 = jdk9Platform;
                                } else {
                                    if (Jdk9Platform.isAvailable) {
                                        jdk9Platform = new Jdk9Platform();
                                    } else {
                                        jdk9Platform = null;
                                    }
                                    if (jdk9Platform != null) {
                                        platform2 = jdk9Platform;
                                    } else {
                                        jvmVersion = System.getProperty("java.specification.version", "unknown");
                                        Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                        if (Integer.parseInt(jvmVersion) < 9) {
                                            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                            Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                            Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                            Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                                            Method getMethod = cls.getMethod("get", SSLSocket.class);
                                            Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                                            Intrinsics.checkNotNullExpressionValue(putMethod, "putMethod");
                                            Intrinsics.checkNotNullExpressionValue(getMethod, "getMethod");
                                            Intrinsics.checkNotNullExpressionValue(removeMethod, "removeMethod");
                                            Intrinsics.checkNotNullExpressionValue(clientProviderClass, "clientProviderClass");
                                            Intrinsics.checkNotNullExpressionValue(serverProviderClass, "serverProviderClass");
                                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
                                        }
                                        if (jdk8WithJettyBootPlatform != null) {
                                            platform2 = jdk8WithJettyBootPlatform;
                                        } else {
                                            platform2 = new Platform();
                                        }
                                    }
                                }
                            } else {
                                if (Jdk9Platform.isAvailable) {
                                    jdk9Platform = new Jdk9Platform();
                                } else {
                                    jdk9Platform = null;
                                }
                                if (jdk9Platform != null) {
                                    platform2 = jdk9Platform;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", "unknown");
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod2 = cls3.getMethod("put", SSLSocket.class, cls4);
                                        Method getMethod2 = cls3.getMethod("get", SSLSocket.class);
                                        Method removeMethod2 = cls3.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod2, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod2, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod2, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass2, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass2, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod2, getMethod2, removeMethod2, clientProviderClass2, serverProviderClass2);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform();
                                    }
                                }
                            }
                        }
                    } else {
                        provider2 = Security.getProviders()[0];
                        Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                        if (RDFWIi.PgrUYH.equals(provider2.getName())) {
                            if (Jdk9Platform.isAvailable) {
                                jdk9Platform = new Jdk9Platform();
                            } else {
                                jdk9Platform = null;
                            }
                            if (jdk9Platform != null) {
                                platform2 = jdk9Platform;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", "unknown");
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod3 = cls5.getMethod("put", SSLSocket.class, cls6);
                                    Method getMethod3 = cls5.getMethod("get", SSLSocket.class);
                                    Method removeMethod3 = cls5.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod3, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod3, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod3, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass3, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass3, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod3, getMethod3, removeMethod3, clientProviderClass3, serverProviderClass3);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform();
                                }
                            }
                        } else {
                            if (OpenJSSEPlatform.isSupported) {
                                jdk9Platform = new OpenJSSEPlatform();
                            } else {
                                jdk9Platform = null;
                            }
                            if (jdk9Platform != null) {
                                platform2 = jdk9Platform;
                            } else {
                                if (Jdk9Platform.isAvailable) {
                                    jdk9Platform = new Jdk9Platform();
                                } else {
                                    jdk9Platform = null;
                                }
                                if (jdk9Platform != null) {
                                    platform2 = jdk9Platform;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", "unknown");
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod4 = cls7.getMethod("put", SSLSocket.class, cls8);
                                        Method getMethod4 = cls7.getMethod("get", SSLSocket.class);
                                        Method removeMethod4 = cls7.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod4, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod4, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod4, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass4, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass4, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod4, getMethod4, removeMethod4, clientProviderClass4, serverProviderClass4);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform();
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                provider = Security.getProviders()[0];
                Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
                if ("BC".equals(provider.getName())) {
                    provider2 = Security.getProviders()[0];
                    Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                    if (RDFWIi.PgrUYH.equals(provider2.getName())) {
                        if (Jdk9Platform.isAvailable) {
                            jdk9Platform = new Jdk9Platform();
                        } else {
                            jdk9Platform = null;
                        }
                        if (jdk9Platform != null) {
                            platform2 = jdk9Platform;
                        } else {
                            jvmVersion = System.getProperty("java.specification.version", "unknown");
                            try {
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    try {
                                        Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass5 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass5 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod5 = cls9.getMethod("put", SSLSocket.class, cls10);
                                        Method getMethod5 = cls9.getMethod("get", SSLSocket.class);
                                        Method removeMethod5 = cls9.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod5, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod5, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod5, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass5, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass5, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod5, getMethod5, removeMethod5, clientProviderClass5, serverProviderClass5);
                                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                    }
                                }
                            } catch (NumberFormatException unused2) {
                            }
                            if (jdk8WithJettyBootPlatform != null) {
                                platform2 = jdk8WithJettyBootPlatform;
                            } else {
                                platform2 = new Platform();
                            }
                        }
                    } else {
                        if (OpenJSSEPlatform.isSupported) {
                            jdk9Platform = new OpenJSSEPlatform();
                        } else {
                            jdk9Platform = null;
                        }
                        if (jdk9Platform != null) {
                            platform2 = jdk9Platform;
                        } else {
                            if (Jdk9Platform.isAvailable) {
                                jdk9Platform = new Jdk9Platform();
                            } else {
                                jdk9Platform = null;
                            }
                            if (jdk9Platform != null) {
                                platform2 = jdk9Platform;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", "unknown");
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass6 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass6 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod6 = cls11.getMethod("put", SSLSocket.class, cls12);
                                    Method getMethod6 = cls11.getMethod("get", SSLSocket.class);
                                    Method removeMethod6 = cls11.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod6, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod6, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod6, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass6, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass6, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod6, getMethod6, removeMethod6, clientProviderClass6, serverProviderClass6);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform();
                                }
                            }
                        }
                    }
                } else {
                    if (BouncyCastlePlatform.isSupported) {
                        jdk9Platform = new BouncyCastlePlatform();
                    } else {
                        jdk9Platform = null;
                    }
                    if (jdk9Platform != null) {
                        platform2 = jdk9Platform;
                    } else {
                        provider2 = Security.getProviders()[0];
                        Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                        if (RDFWIi.PgrUYH.equals(provider2.getName())) {
                            if (Jdk9Platform.isAvailable) {
                                jdk9Platform = new Jdk9Platform();
                            } else {
                                jdk9Platform = null;
                            }
                            if (jdk9Platform != null) {
                                platform2 = jdk9Platform;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", "unknown");
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod7 = cls13.getMethod("put", SSLSocket.class, cls14);
                                    Method getMethod7 = cls13.getMethod("get", SSLSocket.class);
                                    Method removeMethod7 = cls13.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod7, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod7, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod7, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass7, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass7, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod7, getMethod7, removeMethod7, clientProviderClass7, serverProviderClass7);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform();
                                }
                            }
                        } else {
                            if (OpenJSSEPlatform.isSupported) {
                                jdk9Platform = new OpenJSSEPlatform();
                            } else {
                                jdk9Platform = null;
                            }
                            if (jdk9Platform != null) {
                                platform2 = jdk9Platform;
                            } else {
                                if (Jdk9Platform.isAvailable) {
                                    jdk9Platform = new Jdk9Platform();
                                } else {
                                    jdk9Platform = null;
                                }
                                if (jdk9Platform != null) {
                                    platform2 = jdk9Platform;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", "unknown");
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod8 = cls15.getMethod("put", SSLSocket.class, cls16);
                                        Method getMethod8 = cls15.getMethod("get", SSLSocket.class);
                                        Method removeMethod8 = cls15.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod8, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod8, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod8, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass8, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass8, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(putMethod8, getMethod8, removeMethod8, clientProviderClass8, serverProviderClass8);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        platform = platform2;
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static void log(int i, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        logger.log(i == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public ExceptionsKt buildCertificateChainCleaner(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(trustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int i) {
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, i);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable() {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public void logCloseableLeak(Object obj, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (obj == null) {
            message = message.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(5, message, (Throwable) obj);
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextNewSSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            String string = Arrays.toString(trustManagers);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager != null) {
            return (X509TrustManager) trustManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
