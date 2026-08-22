package okhttp3;

import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {
    Response intercept(RealInterceptorChain realInterceptorChain);
}
