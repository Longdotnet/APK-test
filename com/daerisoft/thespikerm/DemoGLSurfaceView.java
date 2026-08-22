package com.daerisoft.thespikerm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.yoyogames.runner.RunnerJNILib;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes2.dex */
public class DemoGLSurfaceView extends GLSurfaceView implements GLSurfaceView.EGLConfigChooser {
    public static int m_astcSupported;
    public static int m_usingGL2;
    public final DemoRenderer mRenderer;
    public final Context m_context;

    public DemoGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        RunnerActivity.CurrentActivity.setupIniFile();
        RunnerActivity.CurrentActivity.RestrictOrientation(false, false, false, false, true);
        Log.i(GooglePlayBillingService.TAG, "Trying GL2 config...");
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
        egl10.eglTerminate(eGLDisplayEglGetDisplay);
        int i = iArr[0] > 0 ? 1 : 0;
        if ((RunnerJNILib.ms_loadLibraryFailed ? i : i > 0 ? RunnerJNILib.initGLFuncs(1) : RunnerJNILib.initGLFuncs(0)) == 0) {
            m_usingGL2 = 0;
            Log.i(GooglePlayBillingService.TAG, "Using OpenGL ES 1 renderer");
            Log.i(GooglePlayBillingService.TAG, "DemoGLSurfaceView: CREATED");
            this.m_context = context;
            DemoRenderer demoRenderer = new DemoRenderer(context);
            this.mRenderer = demoRenderer;
            setEGLConfigChooser(this);
            setRenderer(demoRenderer);
            return;
        }
        m_usingGL2 = 1;
        setEGLContextClientVersion(2);
        Log.i(GooglePlayBillingService.TAG, "Using OpenGL ES 2 renderer");
        Log.i(GooglePlayBillingService.TAG, "DemoGLSurfaceView: CREATED");
        this.m_context = context;
        DemoRendererGL2 demoRendererGL2 = new DemoRendererGL2(context);
        this.mRenderer = demoRendererGL2;
        setEGLConfigChooser(this);
        setRenderer(demoRendererGL2);
    }

    public static int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        int[] iArr = new int[1];
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return 0;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean zOnGenericMotionEvent;
        if (RunnerActivity.mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = RunnerActivity.mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zOnGenericMotionEvent = ((RunnerSocial) obj).onGenericMotionEvent(motionEvent))) {
                    return zOnGenericMotionEvent;
                }
                i++;
            }
        }
        if (motionEvent.getSource() != 8194) {
            return super.onGenericMotionEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 2;
        if (actionMasked == 2 || actionMasked == 7) {
            RunnerJNILib.MouseMoveEvent(motionEvent.getX(), motionEvent.getY());
        } else if (actionMasked == 8) {
            RunnerJNILib.MouseWheelEvent(motionEvent.getAxisValue(9));
        } else if (actionMasked == 11 || actionMasked == 12) {
            int actionButton = motionEvent.getActionButton();
            if (actionButton == 1) {
                i2 = 0;
            } else if (actionButton == 2) {
                i2 = 1;
            } else if (actionButton != 4) {
                if (actionButton != 8) {
                    i2 = actionButton != 16 ? -1 : 4;
                } else {
                    i2 = 3;
                }
            }
            if (i2 != -1) {
                RunnerJNILib.MouseButtonEvent(i2, motionEvent.getActionMasked() == 11);
            }
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent;
        if (motionEvent.getSource() == 8194) {
            return true;
        }
        if (RunnerActivity.mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = RunnerActivity.mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zOnTouchEvent = ((RunnerSocial) obj).onTouchEvent(motionEvent))) {
                    return zOnTouchEvent;
                }
                i++;
            }
        }
        if (RunnerJNILib.ms_loadLibraryFailed) {
            return true;
        }
        int action = motionEvent.getAction();
        int i2 = action & 255;
        if (i2 == 6) {
            performClick();
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (i2 != 5 && i2 != 6) {
                RunnerJNILib.TouchEvent(i2, pointerId, motionEvent.getX(i3), motionEvent.getY(i3), pointerCount);
            } else if (((65280 & action) >> 8) == i3) {
                RunnerJNILib.TouchEvent(i2, pointerId, motionEvent.getX(i3), motionEvent.getY(i3), pointerCount);
            } else {
                RunnerJNILib.TouchEvent(2, pointerId, motionEvent.getX(i3), motionEvent.getY(i3), pointerCount);
            }
        }
        if (RunnerActivity.CurrentActivity.vsyncHandler == null) {
            try {
                int i4 = RunnerJNILib.mMaxRefreshRateSupported;
                int i5 = RunnerJNILib.mGameSpeedControl;
                if (i5 != 0) {
                    i4 = i5;
                }
                Thread.sleep((int) (1000.0f / i4));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick;
        super.performClick();
        if (RunnerActivity.mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = RunnerActivity.mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zPerformClick = ((RunnerSocial) obj).performClick())) {
                    return zPerformClick;
                }
                i++;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r11v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v7 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public final javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 r29, javax.microedition.khronos.egl.EGLDisplay r30) {
        /*
            Method dump skipped, instruction units count: 1217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daerisoft.thespikerm.DemoGLSurfaceView.chooseConfig(javax.microedition.khronos.egl.EGL10, javax.microedition.khronos.egl.EGLDisplay):javax.microedition.khronos.egl.EGLConfig");
    }
}
