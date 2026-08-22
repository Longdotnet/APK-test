package com.daerisoft.thespikerm;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public final class RunnerVsyncHandler implements Choreographer.FrameCallback {
    public static final Accessor accessor = new Accessor();

    /* JADX INFO: loaded from: classes.dex */
    public final class Accessor {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        DemoGLSurfaceView demoGLSurfaceViewGetGLView = RunnerActivity.CurrentActivity.GetGLView(accessor);
        if (demoGLSurfaceViewGetGLView != null && demoGLSurfaceViewGetGLView.mRenderer != null) {
            DemoRenderer.elapsedVsyncs++;
        }
        Choreographer.getInstance().postFrameCallback(this);
    }
}
