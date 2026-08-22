package com.daerisoft.thespikerm;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SuncyanNet$$ExternalSyntheticLambda7 implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return SuncyanNet.lambda$SetCreateSuncyanMTLSClient$0(str, sSLSession);
    }
}
