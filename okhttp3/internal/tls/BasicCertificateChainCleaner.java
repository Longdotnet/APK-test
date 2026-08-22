package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.ExceptionsKt;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BasicCertificateChainCleaner extends ExceptionsKt {
    public final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Intrinsics.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && Intrinsics.areEqual(((BasicCertificateChainCleaner) obj).trustRootIndex, this.trustRootIndex);
    }

    public final int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    @Override // kotlin.ExceptionsKt
    public final List clean(String hostname, List chain) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate x509CertificateFindByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (x509CertificateFindByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateFindByIssuerAndSignature)) {
                    arrayList.add(x509CertificateFindByIssuerAndSignature);
                }
                if (Intrinsics.areEqual(x509CertificateFindByIssuerAndSignature.getIssuerDN(), x509CertificateFindByIssuerAndSignature.getSubjectDN())) {
                    try {
                        x509CertificateFindByIssuerAndSignature.verify(x509CertificateFindByIssuerAndSignature.getPublicKey());
                        return arrayList;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
                while (true) {
                    if (!it.hasNext()) {
                        if (z) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                    }
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (Intrinsics.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                            break;
                        } catch (GeneralSecurityException unused2) {
                            continue;
                        }
                    }
                }
            }
        }
        throw new SSLPeerUnverifiedException(JuorMn.uxhgK + arrayList);
    }
}
