package com.daerisoft.thespikerm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.yoyogames.runner.RunnerJNILib;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

/* JADX INFO: loaded from: classes2.dex */
public class DemoRenderer implements GLSurfaceView.Renderer {
    public static volatile int elapsedVsyncs = -1;
    public static String m_apkFilePath = null;
    public static int m_defaultFrameBuffer = -1;
    public static String m_saveFilesDir;
    public static int m_state;
    public static boolean ms_displayedLoadLibraryFailed;
    public HashMap localeMap;
    public final Context m_context;
    public int m_height;
    public final String m_packageName;
    public int m_texHeight;
    public int m_texRawHeight;
    public int m_texRawWidth;
    public int m_texWidth;
    public int m_width;
    public int m_SplashFillMode = 0;
    public int m_SplashFillColour = 0;
    public boolean m_pauseRunner = false;
    public long splashEndTime = 0;
    public float m_refreshRate = 60.0f;

    public DemoRenderer(Context context) {
        this.m_context = context;
        m_state = 1;
        this.m_packageName = context.getPackageName();
    }

    public static int getNextPow2(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        int i7 = i6 | (i6 >> 16);
        int i8 = i7 + 1;
        return i8 == 0 ? i7 + 2 : i8;
    }

    public final InputStream getResourceAsReader(String str) {
        System.out.println(str);
        try {
            return this.m_context.getResources().getAssets().open(str);
        } catch (Exception unused) {
            System.out.println("Exception while getting Resource");
            return null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.m_width = i;
        this.m_height = i2;
        gl10.glViewport(0, 0, i, i2);
        Log.i(GooglePlayBillingService.TAG, "onSurfaceChanged :: width=" + this.m_width + " height=" + this.m_height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (RunnerJNILib.ms_loadLibraryFailed) {
            if (ms_displayedLoadLibraryFailed) {
                return;
            }
            ms_displayedLoadLibraryFailed = true;
            RunnerActivity.ViewHandler.post(new RunnerJNILib.AnonymousClass1(2));
        }
        if (this.m_pauseRunner) {
            try {
                Thread.sleep(100L);
                return;
            } catch (InterruptedException e) {
                Log.i(GooglePlayBillingService.TAG, "Paused runner has thrown an exception!");
                e.printStackTrace();
                return;
            }
        }
        int i = 0;
        switch (Fragment$$ExternalSyntheticOutline0.ordinal(m_state)) {
            case 0:
                m_state = 2;
                Log.i(GooglePlayBillingService.TAG, "State->Splash");
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                gl10.glClear(16384);
                break;
            case 1:
                if (RunnerActivity.mYYPrefs == null) {
                    this.splashEndTime = System.currentTimeMillis() + 1000;
                } else {
                    this.splashEndTime = System.currentTimeMillis() + ((long) (RunnerActivity.mYYPrefs.m_bundle.getInt("SplashscreenTime") * 1000));
                }
                Log.i(GooglePlayBillingService.TAG, "State->Splash    time: " + System.currentTimeMillis());
                Log.i(GooglePlayBillingService.TAG, "State->Splash endTime: " + this.splashEndTime);
                if (RunnerActivity.UseAPKExpansionFile) {
                    m_state = 4;
                    Log.i(GooglePlayBillingService.TAG, DaWYVMJ.yvYKfCj);
                } else {
                    Log.i(GooglePlayBillingService.TAG, "State->InitRunner");
                    m_state = 5;
                }
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                break;
            case 2:
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                break;
            case 3:
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                if (RunnerActivity.APKExpansionFileReady) {
                    m_apkFilePath = (String) RunnerJNILib.CallExtensionFunction("PlayAPKExpansionExtension", "GetExpansionAPKFilename", 0, null);
                    Log.i(GooglePlayBillingService.TAG, "Download complete- path is:" + m_apkFilePath);
                    m_state = 5;
                }
                break;
            case 4:
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                m_state = 6;
                RunnerActivity.ViewHandler.post(new RunnerJNILib.AnonymousClass1(3));
                break;
            case 5:
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                break;
            case 6:
                RunnerJNILib.RenderSplash(this.m_width, this.m_height, this.m_texRawWidth, this.m_texRawHeight, this.m_texWidth, this.m_texHeight, this.m_SplashFillMode, this.m_SplashFillColour);
                if (System.currentTimeMillis() >= this.splashEndTime) {
                    m_state = 8;
                }
                break;
            case 7:
                gl10.glDeleteTextures(1, new int[1], 0);
                IniBundle iniBundle = RunnerActivity.mYYPrefs;
                String str = this.m_packageName;
                if (iniBundle == null) {
                    RunnerJNILib.Startup(m_apkFilePath, m_saveFilesDir, str, 0, RunnerActivity.UseDynamicAssetDelivery);
                } else {
                    Log.i(GooglePlayBillingService.TAG, "Sleepmargin: " + RunnerActivity.mYYPrefs.m_bundle.getInt("SleepMargin"));
                    RunnerJNILib.Startup(m_apkFilePath, m_saveFilesDir, str, RunnerActivity.mYYPrefs.m_bundle.getInt("SleepMargin"), RunnerActivity.UseDynamicAssetDelivery);
                }
                RunnerJNILib.OnDisplayFrequencyChanged();
                if (RunnerJNILib.ChangeInitialScreenFrequency()) {
                    RunnerActivity.CurrentActivity.updateDisplayModeForRefreshRate(RunnerJNILib.mGameSpeedControl);
                    if (RunnerJNILib.mGameSpeedControl != 0) {
                        RunnerActivity.CurrentActivity.SetGLViewFrameRate(RunnerJNILib.mGameSpeedControl);
                    }
                }
                m_state = 9;
                break;
            case 8:
                if (!RunnerJNILib.ms_exitcalled) {
                    if (RunnerActivity.XPeriaPlay) {
                        Context context = this.m_context;
                        if (context.getResources().getConfiguration().navigation == 2 && context.getResources().getConfiguration().navigationHidden == 1) {
                            i = 1;
                        }
                    }
                    do {
                        if (RunnerJNILib.UpdateGameSpeed()) {
                            Log.i(GooglePlayBillingService.TAG, "RunnerJNILib.mGameSpeedControl changed: " + String.valueOf(RunnerJNILib.mGameSpeedControl));
                            RunnerActivity.CurrentActivity.updateDisplayModeForRefreshRate(RunnerJNILib.mGameSpeedControl);
                            if (RunnerJNILib.mGameSpeedControl != 0) {
                                RunnerActivity.CurrentActivity.SetGLViewFrameRate(RunnerJNILib.mGameSpeedControl);
                            }
                        }
                        if (!RunnerActivity.DisplayUpdatePending.get()) {
                            this.m_refreshRate = Math.round(RunnerJNILib.mCurrentRefreshRate);
                        }
                        int iProcess = RunnerJNILib.Process(this.m_width, this.m_height, RunnerActivity.AccelX, RunnerActivity.AccelY, RunnerActivity.AccelZ, i, RunnerActivity.Orientation, this.m_refreshRate);
                        if (iProcess == 0) {
                            Log.i(GooglePlayBillingService.TAG, "RunnerJNILib.Process returned 0");
                            RunnerJNILib.ExitApplication();
                        } else if (iProcess == 2) {
                            Log.i(GooglePlayBillingService.TAG, "RunnerJNILib.Process has returned that it is due to restart");
                            m_state = 1;
                            RunnerActivity.HasRestarted = true;
                        }
                        if (RunnerJNILib.canFlip()) {
                            break;
                        }
                    } while (m_state == 9);
                }
                break;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Locale locale;
        int i = m_state;
        if (i != 1) {
            Log.i(GooglePlayBillingService.TAG, "onSurfaceCreated() aborted on re-create, state is currently ".concat(CoroutineAdapterKt$$ExternalSyntheticLambda0.stringValueOf$4(i)));
            return;
        }
        if (m_defaultFrameBuffer == -1 && (gl10 instanceof GL11)) {
            IntBuffer intBufferAllocate = IntBuffer.allocate(1);
            gl10.glGetIntegerv(36006, intBufferAllocate);
            m_defaultFrameBuffer = intBufferAllocate.get(0);
            Log.i(GooglePlayBillingService.TAG, "Renderer instance is gl1.1, framebuffer object is: " + m_defaultFrameBuffer);
        }
        StringBuilder sb = new StringBuilder();
        Context context = this.m_context;
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append("/");
        m_saveFilesDir = sb.toString();
        m_apkFilePath = null;
        try {
            m_apkFilePath = context.getPackageManager().getApplicationInfo("com.daerisoft.thespikerm", 0).sourceDir;
            Log.i(GooglePlayBillingService.TAG, ZRqOdXiy.ZheeocZCsQAsby + m_apkFilePath);
            int[] iArr = new int[1];
            gl10.glGenTextures(1, iArr, 0);
            gl10.glBindTexture(3553, iArr[0]);
            gl10.glTexParameterf(3553, 10241, 9728.0f);
            gl10.glTexParameterf(3553, 10240, 9729.0f);
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
            if (deviceConfigurationInfo.reqGlEsVersion >= 131072) {
                Log.i(GooglePlayBillingService.TAG, "OpenGL ES-2.0 is supported: " + deviceConfigurationInfo.reqGlEsVersion);
            } else {
                Log.i(GooglePlayBillingService.TAG, "OpenGL ES-CM 1.1 is supported: " + deviceConfigurationInfo.reqGlEsVersion);
            }
            InputStream resourceAsReader = context.getResources().getConfiguration().orientation == 2 ? getResourceAsReader("splash.png") : getResourceAsReader("portrait_splash.png");
            if (resourceAsReader != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(resourceAsReader, null, options);
                    this.m_texWidth = bitmapDecodeStream.getWidth();
                    this.m_texHeight = bitmapDecodeStream.getHeight();
                    try {
                        resourceAsReader.close();
                    } catch (IOException unused) {
                    }
                    IniBundle iniBundle = RunnerActivity.mYYPrefs;
                    if (iniBundle != null) {
                        this.m_SplashFillMode = iniBundle.m_bundle.getInt("SplashscreenFill", 2);
                        this.m_SplashFillColour = RunnerActivity.mYYPrefs.m_bundle.getInt("YYLaunchScreenBackgroundColour");
                    }
                    this.m_texRawWidth = getNextPow2(this.m_texWidth);
                    int nextPow2 = getNextPow2(this.m_texHeight);
                    this.m_texRawHeight = nextPow2;
                    GLUtils.texImage2D(3553, 0, Bitmap.createBitmap(this.m_texRawWidth, nextPow2, Bitmap.Config.ARGB_8888), 0);
                    GLUtils.texSubImage2D(3553, 0, 0, 0, bitmapDecodeStream);
                    bitmapDecodeStream.recycle();
                } catch (Throwable th) {
                    try {
                        resourceAsReader.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            }
            String[] iSOCountries = Locale.getISOCountries();
            this.localeMap = new HashMap(iSOCountries.length);
            for (String str : iSOCountries) {
                Locale locale2 = new Locale("", str);
                this.localeMap.put(locale2.getISO3Country().toUpperCase(Locale.US), locale2);
            }
            if (RunnerJNILib.ms_loadLibraryFailed) {
                return;
            }
            RunnerJNILib.SetKeyValue(0, RunnerActivity.CurrentActivity.isTablet() ? 1 : 0, "");
            RunnerJNILib.SetKeyValue(1, 0, context.getCacheDir().getAbsolutePath());
            RunnerJNILib.SetKeyValue(2, 0, Locale.getDefault().getLanguage());
            RunnerJNILib.SetKeyValue(3, context.getResources().getDisplayMetrics().densityDpi, "");
            RunnerJNILib.SetKeyValue(4, context.getResources().getDisplayMetrics().densityDpi, "");
            RunnerJNILib.SetKeyValue(5, Build.VERSION.SDK_INT, Build.VERSION.RELEASE);
            try {
                String iSO3Country = Locale.getDefault().getISO3Country();
                HashMap map = this.localeMap;
                if (map != null && (locale = (Locale) map.get(iSO3Country)) != null) {
                    iSO3Country = locale.getCountry();
                }
                RunnerJNILib.SetKeyValue(8, 0, iSO3Country);
            } catch (MissingResourceException unused3) {
                RunnerJNILib.SetKeyValue(8, 0, "zz");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to locate assets, aborting...");
        }
    }
}
