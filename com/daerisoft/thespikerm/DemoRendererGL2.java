package com.daerisoft.thespikerm;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public final class DemoRendererGL2 extends DemoRenderer {
    @Override // com.daerisoft.thespikerm.DemoRenderer, android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int i = DemoRenderer.m_state;
        if (i != 1) {
            Log.i(GooglePlayBillingService.TAG, "onSurfaceCreated() aborted on re-create 1, state is currently ".concat(CoroutineAdapterKt$$ExternalSyntheticLambda0.stringValueOf$4(i)));
            return;
        }
        IntBuffer intBufferAllocate = IntBuffer.allocate(1);
        gl10.glGetIntegerv(36006, intBufferAllocate);
        DemoRenderer.m_defaultFrameBuffer = intBufferAllocate.get(0);
        Log.i(GooglePlayBillingService.TAG, "Renderer instance is gl2.0, framebuffer object is: " + DemoRenderer.m_defaultFrameBuffer);
        super.onSurfaceCreated(gl10, eGLConfig);
    }
}
