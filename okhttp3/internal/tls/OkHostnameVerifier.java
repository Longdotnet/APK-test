package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    public static List getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        EmptyList emptyList = EmptyList.INSTANCE;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return emptyList;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00f1  */
    public static boolean verify(String host, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        Intrinsics.checkNotNullParameter(host, "host");
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        Regex regex = Util.VERIFY_AS_IP_ADDRESS;
        regex.getClass();
        if (regex.nativePattern.matcher(host).matches()) {
            String canonicalHost = TextStreamsKt.toCanonicalHost(host);
            List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
            if (!subjectAltNames.isEmpty()) {
                Iterator it = subjectAltNames.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(canonicalHost, TextStreamsKt.toCanonicalHost((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            String lowerCase = host.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
            if (!subjectAltNames2.isEmpty()) {
                for (String strConcat : subjectAltNames2) {
                    if (lowerCase.length() == 0 || StringsKt__StringsKt.startsWith(lowerCase, ".", false) || lowerCase.endsWith("..") || strConcat == null || strConcat.length() == 0 || StringsKt__StringsKt.startsWith(strConcat, ".", false) || strConcat.endsWith("..")) {
                        zAreEqual = false;
                    } else {
                        String strConcat2 = !lowerCase.endsWith(".") ? lowerCase.concat(".") : lowerCase;
                        if (!strConcat.endsWith(".")) {
                            strConcat = strConcat.concat(".");
                        }
                        Locale locale2 = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(locale2, "Locale.US");
                        if (strConcat == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = strConcat.toLowerCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (!StringsKt__StringsKt.contains$default(lowerCase2, "*")) {
                            zAreEqual = Intrinsics.areEqual(strConcat2, lowerCase2);
                        } else if (!StringsKt__StringsKt.startsWith(lowerCase2, "*.", false) || StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase2, '*', 1, false, 4) != -1 || strConcat2.length() < lowerCase2.length() || "*.".equals(lowerCase2)) {
                            zAreEqual = false;
                        } else {
                            String strSubstring = lowerCase2.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            if (strConcat2.endsWith(strSubstring) && ((length = strConcat2.length() - strSubstring.length()) <= 0 || StringsKt__StringsKt.lastIndexOf$default(strConcat2, '.', length - 1, 4) == -1)) {
                                zAreEqual = true;
                            } else {
                                zAreEqual = false;
                            }
                        }
                    }
                    if (zAreEqual) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
