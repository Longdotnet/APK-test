package com.daerisoft.thespikerm;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.emoji2.text.EmojiCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Worker;
import com.daerisoft.thespikerm.RunnerActivity;
import com.facebook.internal.instrument.anrreport.eBpy.lxnc;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.dynamite.yXvB.MJoJJyFaOH;
import com.yoyogames.runner.RunnerJNILib;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt__MapsKt;
import kotlinx.coroutines.android.Mos.kiqcCZ;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RunnerActivity extends AppCompatActivity implements SensorEventListener, SurfaceHolder.Callback {
    public static float AccelX = 0.0f;
    public static float AccelY = 0.0f;
    public static float AccelZ = 0.0f;
    public static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnvY/yoIGZTPSVhPAlRslGN1TlrszARgKVan9GXXVGGiqCXFU8fV5oR2OdLS3sILBIfmjXOWbOh33qLMaPQmaHXcdB33x00QxiwvgfGCvrcjAmxz4ExFN7FeHf2uu8xAgldHmRMMXdkKqBr29JPKIuw7jQajJWsy07aKvWa6HsF/lBSBwg2dlq426iIl8H18dxDm/DXIAeH7EwOr9vty0RmJXFqwEdN9iTO40rvBi8tY93TNn2o49TRfljG5mbFsYd7M3YOuVZmdZnbVCyUa1mq2yWya6hehjZ4GeUGN3Ku4s6h0Nxv1355GQXMcttdG/kYVsrOkXTY94HtxQQyn8YQIDAQAB";
    public static int ConfigOrientation;
    public static RunnerActivity CurrentActivity;
    public static Display CurrentDisplay;
    public static int DefaultOrientation;
    public static int DisplayHeight;
    public static int DisplayWidth;
    public static String InputStringResult;
    public static int Orientation;
    public static int ShowQuestionYesNo;
    public static Handler ViewHandler;
    public static Object[] mExtension;
    public static IniBundle mYYPrefs;
    public static String m_versionName;
    public int EVENT_OTHER_SYSTEM_EVENT;
    public Sensor mAccelerometer;
    public DemoGLSurfaceView mGLView;
    public Handler mHandler;
    public final BroadcastReceiver mReceiver;
    public boolean mReceiverRegistered;
    public Handler mRestoreImmersiveModeHandler;
    public SensorManager mSensorManager;
    public Runnable mUpdateTimerTask;
    public RunnerKeyboardController m_keyboardController;
    public int maxRefreshRate;
    public boolean mbAppSuspended;
    public Runnable restoreImmersiveModeRunnable;
    public int selectedDisplayModeId;
    public Object vsyncHandler;
    public static AtomicBoolean DisplayUpdatePending = new AtomicBoolean(false);
    public static Display.Mode CurrentDisplayMode = null;
    public static final byte[] SALT = {-5, 12, -68, 7, -12, 67, 3, 4, 4, 19, 6, 7, 16, 11, 9, 51, 71, 34, 19, 16};
    public static int UIVisibilityFlags = 5894;
    public static boolean UseAPKExpansionFile = false;
    public static boolean APKExpansionFileReady = false;
    public static boolean UseDynamicAssetDelivery = false;
    public static boolean HasRestarted = false;
    public static boolean XPeriaPlay = false;
    public static String SaveFilesDir = null;
    public static boolean FocusOverride = false;
    public static boolean HasFocus = false;
    public static int AllowedOrientationMask = 15;
    public static Method mSetSystemUiVisibility = null;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.RunnerActivity$2 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 extends BroadcastReceiver {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(int i) {
            this.$r8$classId = i;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            switch (this.$r8$classId) {
                case 0:
                    String action = intent.getAction();
                    if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                        RunnerJNILib.onGamepadChange();
                        return;
                    } else {
                        if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                            RunnerJNILib.onGamepadChange();
                            return;
                        }
                        return;
                    }
                default:
                    synchronized (zzl.zzb) {
                        zzl.zzc = false;
                        zzl.zzd = false;
                        zzo.zzj("Ad debug logging enablement is out of date.");
                        break;
                    }
                    GamepadHandler_API19.zza(context);
                    return;
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.RunnerActivity$4 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass4 implements View.OnSystemUiVisibilityChangeListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i) {
            RunnerActivity runnerActivity = RunnerActivity.this;
            runnerActivity.setupUiVisibility();
            runnerActivity.setupUiVisibilityDelayed();
        }
    }

    public RunnerActivity() {
        getSavedStateRegistry().registerSavedStateProvider("androidx:appcompat", new AppCompatActivity.AnonymousClass1(this));
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.appcompat.app.AppCompatActivity.2
            public AnonymousClass2() {
            }

            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public final void onContextAvailable(ComponentActivity componentActivity) {
                RunnerActivity runnerActivity = this.this$0;
                AppCompatDelegate delegate = runnerActivity.getDelegate();
                delegate.installViewFactory();
                runnerActivity.getSavedStateRegistry().consumeRestoredStateForKey(AppCompatActivity.DELEGATE_TAG);
                delegate.onCreate();
            }
        });
        this.mbAppSuspended = false;
        this.maxRefreshRate = 0;
        this.selectedDisplayModeId = 0;
        this.mHandler = new Handler();
        this.vsyncHandler = null;
        this.m_keyboardController = null;
        this.mUpdateTimerTask = new RunnerJNILib.AnonymousClass1(7);
        this.mReceiverRegistered = false;
        this.mReceiver = new AnonymousClass2(0);
        this.EVENT_OTHER_SYSTEM_EVENT = 75;
        this.mRestoreImmersiveModeHandler = new Handler();
        this.restoreImmersiveModeRunnable = new Worker.AnonymousClass1(this, 19);
    }

    public static Display getCurrentActivityDisplay() {
        Display displayQueryCurrentActivityDisplay;
        try {
            if (CurrentDisplay == null && (displayQueryCurrentActivityDisplay = queryCurrentActivityDisplay(CurrentActivity)) != null) {
                CurrentDisplay = displayQueryCurrentActivityDisplay;
            }
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "[queryCurrentActivityDisplay] Error: " + e.getMessage());
        }
        return CurrentDisplay;
    }

    public static Display queryCurrentActivityDisplay(RunnerActivity runnerActivity) {
        int pixelFormat;
        try {
            Display defaultDisplay = runnerActivity.getWindowManager().getDefaultDisplay();
            if (defaultDisplay == null || (pixelFormat = defaultDisplay.getPixelFormat()) == 0) {
                return null;
            }
            Log.i(GooglePlayBillingService.TAG, "Got a display with PixelFormat =  " + pixelFormat);
            return defaultDisplay;
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "[queryCurrentActivityDisplay] Error: " + e.getMessage());
            return null;
        }
    }

    public static Display.Mode selectClosestDisplayModeForRefreshRate(int i) {
        int i2;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                if (i == 0) {
                    Log.i(GooglePlayBillingService.TAG, "[selectClosestDisplayModeForRefreshRate] Requested refreshRate 0, replacing with maximum available: " + String.valueOf(RunnerJNILib.mMaxRefreshRateSupported));
                    i = RunnerJNILib.mMaxRefreshRateSupported;
                }
                Display.Mode mode = null;
                Display.Mode mode2 = null;
                int i3 = 999;
                int i4 = 0;
                for (Display.Mode mode3 : getCurrentActivityDisplay().getSupportedModes()) {
                    int iRound = Math.round(mode3.getRefreshRate());
                    Log.i(GooglePlayBillingService.TAG, "Available refresh rate: " + iRound + " width:" + mode3.getPhysicalWidth() + " by " + mode3.getPhysicalHeight());
                    if (iRound >= i && (i2 = iRound - i) < i3) {
                        Log.i(GooglePlayBillingService.TAG, "Found matching mode with refresh rate: " + String.valueOf(iRound));
                        mode = mode3;
                        i3 = i2;
                    }
                    if (iRound > i4) {
                        mode2 = mode3;
                        i4 = iRound;
                    }
                }
                return (i3 == 0 || Math.round(mode.getRefreshRate()) % i == 0) ? mode : mode2;
            }
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "[selectClosestDisplayModeForRefreshRate] Error: " + e.getMessage());
        }
        return null;
    }

    public static void setupExtensions() {
        int i;
        if (mExtension != null) {
            return;
        }
        IniBundle iniBundle = mYYPrefs;
        if (iniBundle == null) {
            Log.i(GooglePlayBillingService.TAG, "Unable to initialise extensions as preferences have not been loaded");
            return;
        }
        int i2 = iniBundle.m_bundle.getInt("YYNumExtensionClasses");
        if (i2 > 0) {
            mExtension = new Object[i2];
        }
        for (int i3 = 0; i3 < i2; i3++) {
            IniBundle iniBundle2 = mYYPrefs;
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i3, "YYExtensionClass");
            Bundle bundle = iniBundle2.m_bundle;
            String string = bundle.getString(strM);
            if (string == null && (i = bundle.getInt(strM, -9876543)) != -9876543) {
                string = Integer.toString(i);
            }
            if (string != null && !string.isEmpty()) {
                try {
                    String str = "com.daerisoft.thespikerm." + string;
                    Log.i(GooglePlayBillingService.TAG, "Attempting to initialise extension class " + str);
                    mExtension[i3] = Class.forName(str).getConstructor(null).newInstance(null);
                    try {
                        Method method = mExtension[i3].getClass().getMethod("Init", null);
                        if (method != null) {
                            Log.i(GooglePlayBillingService.TAG, "Method found, attempting to invoke Init");
                            method.invoke(mExtension[i3], null);
                        }
                    } catch (Exception e) {
                        Log.i(GooglePlayBillingService.TAG, "No Init method found on extension class:" + string + " returned " + e.getMessage());
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    Log.i(GooglePlayBillingService.TAG, "Exception thrown attempting to create extension class " + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    public void GenerateAsyncEventForInsets() {
        WindowInsets rootWindowInsets;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 28 || (rootWindowInsets = getWindow().getDecorView().getRootWindowInsets()) == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
            if (displayCutout == null) {
                Log.i(GooglePlayBillingService.TAG, "Failed to find display cutout");
                return;
            }
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "DisplayLayoutInfo");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "safeinsetbottom", displayCutout.getSafeInsetBottom());
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "safeinsettop", displayCutout.getSafeInsetTop());
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "safeinsetleft", displayCutout.getSafeInsetLeft());
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "safeinsetright", displayCutout.getSafeInsetRight());
            if (i >= 30) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "waterfallinsetbottom", waterfallInsets.bottom);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "waterfallinsettop", waterfallInsets.top);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "waterfallinsetleft", waterfallInsets.left);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "waterfallinsetright", waterfallInsets.right);
            }
            for (Rect rect : displayCutout.getBoundingRects()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("left", rect.left);
                jSONObject.put("right", rect.right);
                jSONObject.put("top", rect.top);
                jSONObject.put("bottom", rect.bottom);
                jSONArray.put(jSONObject);
            }
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "boundrects", jSONArray.toString());
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, this.EVENT_OTHER_SYSTEM_EVENT);
        } catch (Exception unused) {
        }
    }

    public DemoGLSurfaceView GetGLView(RunnerVsyncHandler.Accessor accessor) {
        accessor.getClass();
        return this.mGLView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.daerisoft.thespikerm.RunnerKeyboardController$2] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.daerisoft.thespikerm.RunnerKeyboardController$2] */
    public RunnerKeyboardController GetKeyboardController() {
        final int i = 0;
        if (this.m_keyboardController == null) {
            View decorView = getWindow().getDecorView();
            Handler handler = ViewHandler;
            int i2 = RunnerKeyboardController.ms_estimatedKeyboardHeight;
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            RunnerKeyboardController runnerKeyboardController = null;
            if (inputMethodManager != null) {
                final RunnerKeyboardController runnerKeyboardController2 = new RunnerKeyboardController();
                runnerKeyboardController2.m_context = null;
                runnerKeyboardController2.m_inputMethodManager = null;
                runnerKeyboardController2.m_activityView = null;
                runnerKeyboardController2.m_viewHandler = null;
                runnerKeyboardController2.m_keyboardStatus = "hidden";
                runnerKeyboardController2.m_virtualKeyboardActive = false;
                runnerKeyboardController2.m_virtualKeyboardVisible = false;
                runnerKeyboardController2.m_physicalKeyboardConnected = false;
                runnerKeyboardController2.m_virtualKeyboardToggleResultReceiver = null;
                runnerKeyboardController2.m_virtualKeyboardVisibilityCheckAdjustReceiver = null;
                runnerKeyboardController2.m_editText = null;
                runnerKeyboardController2.m_viewActiveRect = new Rect();
                runnerKeyboardController2.m_currentKeyboardHeight = 0;
                runnerKeyboardController2.m_currentPredictiveTextEnabled = false;
                runnerKeyboardController2.m_bufferedTextInput = false;
                runnerKeyboardController2.m_setTextHandlerEnabled = false;
                runnerKeyboardController2.m_context = this;
                runnerKeyboardController2.m_inputMethodManager = inputMethodManager;
                runnerKeyboardController2.m_activityView = decorView;
                runnerKeyboardController2.m_viewHandler = handler;
                handler.post(new zza((Object) runnerKeyboardController2, (Object) runnerKeyboardController2, 18, false));
                runnerKeyboardController2.m_virtualKeyboardToggleResultReceiver = new ResultReceiver(runnerKeyboardController2, i) { // from class: com.daerisoft.thespikerm.RunnerKeyboardController.2
                    public final /* synthetic */ int $r8$classId;
                    public final RunnerKeyboardController m_keyboardController;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(null);
                        this.$r8$classId = i;
                        this.m_keyboardController = runnerKeyboardController2;
                    }

                    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
                    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
                    @Override // android.os.ResultReceiver
                    public final void onReceiveResult(int i3, Bundle bundle) {
                        switch (this.$r8$classId) {
                            case 0:
                                RunnerKeyboardController runnerKeyboardController3 = this.m_keyboardController;
                                if (i3 == 0) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i3 == 1) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                } else if (i3 == 2) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i3 == 3) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                }
                                if (i3 == 0) {
                                    runnerKeyboardController3.m_keyboardStatus = "visible";
                                } else if (i3 == 1) {
                                    runnerKeyboardController3.m_keyboardStatus = "hidden";
                                } else if (i3 == 2) {
                                    runnerKeyboardController3.m_keyboardStatus = "showing";
                                } else if (i3 != 3) {
                                    runnerKeyboardController3.getClass();
                                } else {
                                    runnerKeyboardController3.m_keyboardStatus = "hiding";
                                }
                                View view = runnerKeyboardController3.m_activityView;
                                Rect rect = runnerKeyboardController3.m_viewActiveRect;
                                view.getWindowVisibleDisplayFrame(rect);
                                int height = view.getHeight() - (rect.bottom - rect.top);
                                runnerKeyboardController3.m_currentKeyboardHeight = height;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController3.m_keyboardStatus, height);
                                break;
                            case 1:
                                RunnerKeyboardController runnerKeyboardController4 = this.m_keyboardController;
                                View view2 = runnerKeyboardController4.m_activityView;
                                Rect rect2 = runnerKeyboardController4.m_viewActiveRect;
                                view2.getWindowVisibleDisplayFrame(rect2);
                                int height2 = view2.getHeight() - (rect2.bottom - rect2.top);
                                runnerKeyboardController4.m_currentKeyboardHeight = height2;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController4.m_keyboardStatus, height2);
                                break;
                            default:
                                RunnerKeyboardController runnerKeyboardController5 = this.m_keyboardController;
                                runnerKeyboardController5.getClass();
                                if (i3 == 0) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = true;
                                    runnerKeyboardController5.m_keyboardStatus = "visible";
                                } else if (i3 == 1 || i3 == 2 || i3 == 3) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = false;
                                    runnerKeyboardController5.m_keyboardStatus = "hidden";
                                }
                                runnerKeyboardController5.m_viewHandler.post(new EmojiCompat.ListenerDispatcher(runnerKeyboardController5, i3, 2));
                                break;
                        }
                    }
                };
                final int i3 = 1;
                runnerKeyboardController2.m_virtualKeyboardVisibilityCheckAdjustReceiver = new ResultReceiver(runnerKeyboardController2, i3) { // from class: com.daerisoft.thespikerm.RunnerKeyboardController.2
                    public final /* synthetic */ int $r8$classId;
                    public final RunnerKeyboardController m_keyboardController;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(null);
                        this.$r8$classId = i3;
                        this.m_keyboardController = runnerKeyboardController2;
                    }

                    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
                    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
                    @Override // android.os.ResultReceiver
                    public final void onReceiveResult(int i4, Bundle bundle) {
                        switch (this.$r8$classId) {
                            case 0:
                                RunnerKeyboardController runnerKeyboardController3 = this.m_keyboardController;
                                if (i4 == 0) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i4 == 1) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                } else if (i4 == 2) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i4 == 3) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                }
                                if (i4 == 0) {
                                    runnerKeyboardController3.m_keyboardStatus = "visible";
                                } else if (i4 == 1) {
                                    runnerKeyboardController3.m_keyboardStatus = "hidden";
                                } else if (i4 == 2) {
                                    runnerKeyboardController3.m_keyboardStatus = "showing";
                                } else if (i4 != 3) {
                                    runnerKeyboardController3.getClass();
                                } else {
                                    runnerKeyboardController3.m_keyboardStatus = "hiding";
                                }
                                View view = runnerKeyboardController3.m_activityView;
                                Rect rect = runnerKeyboardController3.m_viewActiveRect;
                                view.getWindowVisibleDisplayFrame(rect);
                                int height = view.getHeight() - (rect.bottom - rect.top);
                                runnerKeyboardController3.m_currentKeyboardHeight = height;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController3.m_keyboardStatus, height);
                                break;
                            case 1:
                                RunnerKeyboardController runnerKeyboardController4 = this.m_keyboardController;
                                View view2 = runnerKeyboardController4.m_activityView;
                                Rect rect2 = runnerKeyboardController4.m_viewActiveRect;
                                view2.getWindowVisibleDisplayFrame(rect2);
                                int height2 = view2.getHeight() - (rect2.bottom - rect2.top);
                                runnerKeyboardController4.m_currentKeyboardHeight = height2;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController4.m_keyboardStatus, height2);
                                break;
                            default:
                                RunnerKeyboardController runnerKeyboardController5 = this.m_keyboardController;
                                runnerKeyboardController5.getClass();
                                if (i4 == 0) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = true;
                                    runnerKeyboardController5.m_keyboardStatus = "visible";
                                } else if (i4 == 1 || i4 == 2 || i4 == 3) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = false;
                                    runnerKeyboardController5.m_keyboardStatus = "hidden";
                                }
                                runnerKeyboardController5.m_viewHandler.post(new EmojiCompat.ListenerDispatcher(runnerKeyboardController5, i4, 2));
                                break;
                        }
                    }
                };
                final int i4 = 2;
                new ResultReceiver(runnerKeyboardController2, i4) { // from class: com.daerisoft.thespikerm.RunnerKeyboardController.2
                    public final /* synthetic */ int $r8$classId;
                    public final RunnerKeyboardController m_keyboardController;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(null);
                        this.$r8$classId = i4;
                        this.m_keyboardController = runnerKeyboardController2;
                    }

                    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
                    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
                    @Override // android.os.ResultReceiver
                    public final void onReceiveResult(int i5, Bundle bundle) {
                        switch (this.$r8$classId) {
                            case 0:
                                RunnerKeyboardController runnerKeyboardController3 = this.m_keyboardController;
                                if (i5 == 0) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i5 == 1) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                } else if (i5 == 2) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = true;
                                } else if (i5 == 3) {
                                    runnerKeyboardController3.m_virtualKeyboardActive = false;
                                }
                                if (i5 == 0) {
                                    runnerKeyboardController3.m_keyboardStatus = "visible";
                                } else if (i5 == 1) {
                                    runnerKeyboardController3.m_keyboardStatus = "hidden";
                                } else if (i5 == 2) {
                                    runnerKeyboardController3.m_keyboardStatus = "showing";
                                } else if (i5 != 3) {
                                    runnerKeyboardController3.getClass();
                                } else {
                                    runnerKeyboardController3.m_keyboardStatus = "hiding";
                                }
                                View view = runnerKeyboardController3.m_activityView;
                                Rect rect = runnerKeyboardController3.m_viewActiveRect;
                                view.getWindowVisibleDisplayFrame(rect);
                                int height = view.getHeight() - (rect.bottom - rect.top);
                                runnerKeyboardController3.m_currentKeyboardHeight = height;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController3.m_keyboardStatus, height);
                                break;
                            case 1:
                                RunnerKeyboardController runnerKeyboardController4 = this.m_keyboardController;
                                View view2 = runnerKeyboardController4.m_activityView;
                                Rect rect2 = runnerKeyboardController4.m_viewActiveRect;
                                view2.getWindowVisibleDisplayFrame(rect2);
                                int height2 = view2.getHeight() - (rect2.bottom - rect2.top);
                                runnerKeyboardController4.m_currentKeyboardHeight = height2;
                                RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController4.m_keyboardStatus, height2);
                                break;
                            default:
                                RunnerKeyboardController runnerKeyboardController5 = this.m_keyboardController;
                                runnerKeyboardController5.getClass();
                                if (i5 == 0) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = true;
                                    runnerKeyboardController5.m_keyboardStatus = "visible";
                                } else if (i5 == 1 || i5 == 2 || i5 == 3) {
                                    runnerKeyboardController5.m_virtualKeyboardActive = false;
                                    runnerKeyboardController5.m_keyboardStatus = "hidden";
                                }
                                runnerKeyboardController5.m_viewHandler.post(new EmojiCompat.ListenerDispatcher(runnerKeyboardController5, i5, 2));
                                break;
                        }
                    }
                };
                ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                AppCompatSpinner.AnonymousClass2 anonymousClass2 = new AppCompatSpinner.AnonymousClass2();
                anonymousClass2.this$0 = runnerKeyboardController2;
                viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                runnerKeyboardController = runnerKeyboardController2;
            }
            this.m_keyboardController = runnerKeyboardController;
        }
        return this.m_keyboardController;
    }

    public int GetOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int i = getResources().getConfiguration().orientation;
        int i2 = ((i == 2 && (rotation == 0 || rotation == 2)) || (i == 1 && (rotation == 1 || rotation == 3))) ? rotation : (rotation + 1) & 3;
        Log.i(GooglePlayBillingService.TAG, "calculated orientation - " + i2 + " from rotation " + rotation);
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void RestrictOrientation(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = z;
        if (z5) {
            if (mYYPrefs != null) {
                Log.i(GooglePlayBillingService.TAG, "RestrictOrientation setting from YYPrefs");
                boolean z7 = mYYPrefs.m_bundle.getInt("OrientLandscape") != 0;
                z2 = mYYPrefs.m_bundle.getInt("OrientPortrait") != 0;
                z3 = mYYPrefs.m_bundle.getInt("OrientLandscapeFlipped") != 0;
                if (mYYPrefs.m_bundle.getInt("OrientPortraitFlipped") != 0) {
                    z4 = true;
                    z6 = z7;
                } else {
                    z4 = false;
                    z6 = z7;
                }
            } else {
                z6 = 0;
                z2 = false;
                z3 = false;
                z4 = false;
            }
        }
        Log.i(GooglePlayBillingService.TAG, "RestrictOrientation(\"" + z6 + "\", \"" + z2 + "\"" + z3 + "\"" + z4 + "\")");
        AllowedOrientationMask = (z2 ? 2 : 0) | z6 | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        if (z6 != 0 && !z2 && !z3 && !z4) {
            setRequestedOrientation(0);
            return;
        }
        if (z6 == 0 && z2 && !z3 && !z4) {
            setRequestedOrientation(1);
            return;
        }
        if (z6 == 0 && !z2 && z3 && !z4) {
            setRequestedOrientation(8);
            return;
        }
        if (z6 == 0 && !z2 && !z3 && z4) {
            setRequestedOrientation(9);
            return;
        }
        if ((z6 != 0 && !z2 && z3 && !z4) || ((z6 != 0 && z2 && z3 && !z4) || (z6 != 0 && !z2 && z3 && z4))) {
            setRequestedOrientation(6);
            return;
        }
        if (!(z6 == 0 && z2 && !z3 && z4) && ((z6 == 0 || !z2 || z3 || !z4) && !(z6 == 0 && z2 && z3 && z4))) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(7);
        }
    }

    public void SetGLViewFrameRate(float f) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mGLView.getHolder().getSurface().setFrameRate(f, 0);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        GamepadHandler_API19 gamepadHandler_API19;
        GamepadHandler_API12$GamepadInstance gamepadHandler_API12$GamepadInstanceGetGamepad;
        boolean zDispatchGenericMotionEvent;
        if (mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zDispatchGenericMotionEvent = ((RunnerSocial) obj).dispatchGenericMotionEvent(motionEvent))) {
                    return zDispatchGenericMotionEvent;
                }
                i++;
            }
        }
        if (motionEvent.getSource() == 16777232 || motionEvent.getSource() == 1025) {
            int source = motionEvent.getSource();
            if ((source == 513 || source == 1025 || source == 16777232) && (gamepadHandler_API19 = MapsKt__MapsKt.ms_GamepadHandler) != null && (motionEvent.getSource() & 16777232) != 0) {
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getActionMasked() == 2 && (gamepadHandler_API12$GamepadInstanceGetGamepad = gamepadHandler_API19.GetGamepad(motionEvent.getDeviceId())) != null) {
                    for (int i2 = 0; i2 < gamepadHandler_API12$GamepadInstanceGetGamepad.axes.size(); i2++) {
                        InputDevice.MotionRange motionRange = (InputDevice.MotionRange) gamepadHandler_API12$GamepadInstanceGetGamepad.axes.get(i2);
                        RunnerJNILib.onGPNativeAxis(gamepadHandler_API12$GamepadInstanceGetGamepad.idDevice, i2, (((motionEvent.getAxisValue(motionRange.getAxis(), actionIndex) - motionRange.getMin()) / motionRange.getRange()) * 2.0f) - 1.0f);
                    }
                    for (int i3 = 0; i3 < gamepadHandler_API12$GamepadInstanceGetGamepad.hats.size(); i3 += 2) {
                        RunnerJNILib.onGPNativeHat(gamepadHandler_API12$GamepadInstanceGetGamepad.idDevice, i3 / 2, Math.round(motionEvent.getAxisValue(((InputDevice.MotionRange) gamepadHandler_API12$GamepadInstanceGetGamepad.hats.get(i3)).getAxis(), actionIndex)), Math.round(motionEvent.getAxisValue(((InputDevice.MotionRange) gamepadHandler_API12$GamepadInstanceGetGamepad.hats.get(i3 + 1)).getAxis(), actionIndex)));
                    }
                }
            }
            RunnerKeyboardController runnerKeyboardController = this.m_keyboardController;
            if (runnerKeyboardController == null || !runnerKeyboardController.m_virtualKeyboardActive) {
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GamepadHandler_API19 gamepadHandler_API19;
        GamepadHandler_API12$GamepadInstance gamepadHandler_API12$GamepadInstanceGetGamepad;
        boolean zDispatchKeyEvent;
        if (mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zDispatchKeyEvent = ((RunnerSocial) obj).dispatchKeyEvent(keyEvent))) {
                    return zDispatchKeyEvent;
                }
                i++;
            }
        }
        int deviceId = keyEvent.getDeviceId();
        InputDevice device = InputDevice.getDevice(deviceId);
        if (device != null && deviceId >= 0) {
            int sources = device.getSources();
            if (((sources & 16) == 16 || (sources & 1025) == 1025 || (sources & 513) == 513) && (gamepadHandler_API19 = MapsKt__MapsKt.ms_GamepadHandler) != null && (gamepadHandler_API12$GamepadInstanceGetGamepad = gamepadHandler_API19.GetGamepad(deviceId)) != null) {
                int action = keyEvent.getAction();
                if (action == 0) {
                    RunnerJNILib.onGPKeyDown(gamepadHandler_API12$GamepadInstanceGetGamepad.idDevice, keyEvent.getKeyCode());
                } else if (action == 1) {
                    RunnerJNILib.onGPKeyUp(gamepadHandler_API12$GamepadInstanceGetGamepad.idDevice, keyEvent.getKeyCode());
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void doSetup(String str) {
        Log.d(GooglePlayBillingService.TAG, "doSetup called - " + str);
        setupExtensions();
        GamepadHandler_API19 gamepadHandler_API19 = new GamepadHandler_API19();
        gamepadHandler_API19.m_Gamepads = new ArrayList();
        MapsKt__MapsKt.ms_GamepadHandler = gamepadHandler_API19;
        RestrictOrientation(false, false, false, false, true);
        DemoRenderer.m_state = 7;
    }

    public int getDeviceDefaultOrientation() {
        try {
            if (Class.forName("android.view.Display").getDeclaredMethod("getRotation", null) != null) {
                WindowManager windowManager = (WindowManager) getSystemService("window");
                Configuration configuration = getResources().getConfiguration();
                int rotation = windowManager.getDefaultDisplay().getRotation();
                if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
                    return 2;
                }
            }
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "ERROR: Enumerating API level " + e.getMessage());
        }
        return 1;
    }

    public float getRefreshRate() {
        float refreshRate = getWindowManager().getDefaultDisplay().getRefreshRate();
        if (refreshRate < 10.0f) {
            return 60.0f;
        }
        return refreshRate;
    }

    public boolean isTablet() {
        try {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            float f = displayMetrics.widthPixels / displayMetrics.xdpi;
            float f2 = displayMetrics.heightPixels / displayMetrics.ydpi;
            return Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.0d;
        } catch (Throwable unused) {
            Log.i(GooglePlayBillingService.TAG, "Failed to compute screen size");
            return false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i(GooglePlayBillingService.TAG, "Got activity result: " + i2);
        super.onActivityResult(i, i2, intent);
        if (mExtension != null) {
            int i3 = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i3 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i3];
                if (obj instanceof RunnerSocial) {
                    ((RunnerSocial) obj).onActivityResult(i, i2, intent);
                }
                i3++;
            }
        }
        setupUiVisibility();
        setupUiVisibilityDelayed();
        Log.i(GooglePlayBillingService.TAG, "End Got activity result");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Orientation = GetOrientation();
        RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = GetKeyboardController();
        int i = 0;
        if (runnerKeyboardControllerGetKeyboardController != null) {
            runnerKeyboardControllerGetKeyboardController.m_physicalKeyboardConnected = getResources().getConfiguration().hardKeyboardHidden == 1;
        }
        if (mExtension == null) {
            return;
        }
        while (true) {
            Object[] objArr = mExtension;
            if (i >= objArr.length) {
                return;
            }
            Object obj = objArr[i];
            if (obj instanceof RunnerSocial) {
                ((RunnerSocial) obj).onConfigurationChanged(configuration);
            }
            i++;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        kiqcCZ.GKZ.invoke(null, this, bundle);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        Dialog dialogOnCreateDialog;
        if (mExtension == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr = mExtension;
            if (i2 >= objArr.length) {
                return null;
            }
            Object obj = objArr[i2];
            if ((obj instanceof RunnerSocial) && (dialogOnCreateDialog = ((RunnerSocial) obj).onCreateDialog(i)) != null) {
                return dialogOnCreateDialog;
            }
            i2++;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean zOnCreateOptionsMenu;
        super.onCreateOptionsMenu(menu);
        if (mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zOnCreateOptionsMenu = ((RunnerSocial) obj).onCreateOptionsMenu(menu))) {
                    return zOnCreateOptionsMenu;
                }
                i++;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalAccessException, InvocationTargetException {
        lxnc.ZXlxhg.invoke(null, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean zOnKeyDown;
        int source = keyEvent.getSource();
        boolean z = keyEvent.getDeviceId() > 0;
        boolean z2 = (source & 257) == 257;
        boolean z3 = (source & 1025) == 1025;
        boolean z4 = (source & 16777232) == 16777232;
        if (mExtension != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if ((obj instanceof RunnerSocial) && (zOnKeyDown = ((RunnerSocial) obj).onKeyDown(i, keyEvent))) {
                    return zOnKeyDown;
                }
                i2++;
            }
        }
        if (z && z2 && !z3 && !z4) {
            GetKeyboardController();
        }
        if (i != 0 && !z3 && !z4) {
            RunnerJNILib.KeyEvent(0, i, keyEvent.getUnicodeChar(), source, keyEvent.getRepeatCount());
            RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = GetKeyboardController();
            if (i == 67 && runnerKeyboardControllerGetKeyboardController.m_virtualKeyboardActive) {
                RunnerJNILib.KeyEvent(1, i, keyEvent.getUnicodeChar(), source, 0);
            }
        }
        if (i == 4) {
            keyEvent.startTracking();
            return true;
        }
        if (i != 24 && i != 25 && i != 3 && i != 82 && i < 79) {
            return true;
        }
        setupUiVisibility();
        setupUiVisibilityDelayed();
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        boolean zOnKeyLongPress;
        if (mExtension != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if ((obj instanceof RunnerSocial) && (zOnKeyLongPress = ((RunnerSocial) obj).onKeyLongPress(i, keyEvent))) {
                    return zOnKeyLongPress;
                }
                i2++;
            }
        }
        if (i != 4) {
            return super.onKeyLongPress(i, keyEvent);
        }
        RunnerJNILib.BackKeyLongPressEvent();
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean zOnKeyUp;
        int source = keyEvent.getSource();
        boolean z = (source & 1025) == 1025;
        boolean z2 = (source & 16777232) == 16777232;
        if (mExtension != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if ((obj instanceof RunnerSocial) && (zOnKeyUp = ((RunnerSocial) obj).onKeyUp(i, keyEvent))) {
                    return zOnKeyUp;
                }
                i2++;
            }
        }
        if (!z && !z2) {
            RunnerJNILib.KeyEvent(1, i, keyEvent.getUnicodeChar(), keyEvent.getSource(), 0);
        }
        if (i == 24 || i == 25 || i == 3 || i == 82 || i >= 79) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mExtension == null) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr = mExtension;
            if (i >= objArr.length) {
                return;
            }
            Object obj = objArr[i];
            if (obj instanceof RunnerSocial) {
                ((RunnerSocial) obj).onNewIntent(intent);
            }
            i++;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean zOnOptionsItemSelected;
        if (mExtension != null) {
            int i = 0;
            while (true) {
                Object[] objArr = mExtension;
                if (i >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                if ((obj instanceof RunnerSocial) && (zOnOptionsItemSelected = ((RunnerSocial) obj).onOptionsItemSelected(menuItem))) {
                    return zOnOptionsItemSelected;
                }
                i++;
            }
        }
        menuItem.getItemId();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() throws IllegalAccessException, InvocationTargetException {
        lxnc.wjnI.invoke(null, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "onRequestPermissionsResult ", " returned with: ");
        sbM.append(strArr.toString());
        sbM.append(" results:");
        sbM.append(iArr.toString());
        Log.i(GooglePlayBillingService.TAG, sbM.toString());
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "permission_request_result");
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, strArr[i3], iArr[i3] == 0 ? 1 : 0);
        }
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, this.EVENT_OTHER_SYSTEM_EVENT);
        if (mExtension != null) {
            while (true) {
                Object[] objArr = mExtension;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if (obj instanceof RunnerSocial) {
                    ((RunnerSocial) obj).onRequestPermissionsResult(i, strArr, iArr);
                }
                i2++;
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        Log.i(GooglePlayBillingService.TAG, "onRestart");
        super.onRestart();
        if (mExtension == null) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr = mExtension;
            if (i >= objArr.length) {
                return;
            }
            Object obj = objArr[i];
            if (obj instanceof RunnerSocial) {
                ((RunnerSocial) obj).onRestart();
            }
            i++;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, InvocationTargetException {
        lxnc.oUx.invoke(null, this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (DefaultOrientation != 2) {
            float[] fArr = sensorEvent.values;
            AccelX = fArr[0] / 9.80665f;
            AccelY = fArr[1] / 9.80665f;
            AccelZ = fArr[2] / 9.80665f;
            return;
        }
        float[] fArr2 = sensorEvent.values;
        AccelX = fArr2[1] / 9.80665f;
        AccelY = (-fArr2[0]) / 9.80665f;
        AccelZ = fArr2[2] / 9.80665f;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() throws IllegalAccessException, InvocationTargetException {
        kiqcCZ.tDIXBtylmrj.invoke(null, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() throws IllegalAccessException, InvocationTargetException {
        MJoJJyFaOH.tXTzfEdUV.invoke(null, this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Log.i(GooglePlayBillingService.TAG, "onWindowFocusChanged(" + z + "|" + FocusOverride + ")");
        super.onWindowFocusChanged(z);
        if (RunnerJNILib.ms_exitcalled) {
            Log.i(GooglePlayBillingService.TAG, "Ignoring focus change as we are exiting");
            return;
        }
        HasFocus = FocusOverride | z;
        int i = 0;
        FocusOverride = false;
        setupUiVisibility();
        setupUiVisibilityDelayed();
        if (mExtension == null) {
            return;
        }
        while (true) {
            Object[] objArr = mExtension;
            if (i >= objArr.length) {
                return;
            }
            Object obj = objArr[i];
            if (obj instanceof RunnerSocial) {
                ((RunnerSocial) obj).onWindowFocusChanged(z);
            }
            i++;
        }
    }

    public final void ourSetSystemUiVisibility(int i) {
        Method method = mSetSystemUiVisibility;
        if (method == null) {
            Log.i(GooglePlayBillingService.TAG, "!!!!Unable to do mSetSystemUiVisibility(" + i + ")");
            return;
        }
        try {
            method.invoke(this.mGLView, Integer.valueOf(i));
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Exception while calling setSystemUiVisibility " + e.toString());
        }
    }

    public void resumeApp() {
    }

    public void setupIniFile() {
        Bundle bundle;
        Log.i(GooglePlayBillingService.TAG, "#####!!!! package name is " + getComponentName().getPackageName());
        Log.i(GooglePlayBillingService.TAG, "Loading INI from manifest file");
        try {
            bundle = getPackageManager().getApplicationInfo(getComponentName().getPackageName(), 128).metaData;
        } catch (Exception e) {
            Log.d(GooglePlayBillingService.TAG, "Exception while setting up Ini" + e.toString());
            bundle = null;
        }
        IniBundle iniBundle = new IniBundle();
        iniBundle.m_bundle = bundle;
        mYYPrefs = iniBundle;
        Log.i(GooglePlayBillingService.TAG, "INI loaded from AndroidManifest.xml");
    }

    public void setupUiVisibility() {
        if (this.mGLView != null) {
            try {
                mSetSystemUiVisibility = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
                int i = UIVisibilityFlags;
                if ((i & 256) != 0) {
                    ourSetSystemUiVisibility(i & (-257));
                }
                ourSetSystemUiVisibility(UIVisibilityFlags);
            } catch (Exception e) {
                Log.i(GooglePlayBillingService.TAG, "Exception while getting setSystemUiVisibility :: " + e.toString());
            }
        }
    }

    public void setupUiVisibilityDelayed() {
        this.mRestoreImmersiveModeHandler.postDelayed(this.restoreImmersiveModeRunnable, 500L);
    }

    public void setupView() {
        Log.i(GooglePlayBillingService.TAG, " + + + + setupView + + + +");
        setContentView(R.layout.main);
        this.mGLView = (DemoGLSurfaceView) findViewById(R.id.demogl);
        setupUiVisibility();
        setupUiVisibilityDelayed();
        Object obj = this.vsyncHandler;
        if (obj != null) {
            Choreographer.getInstance().postFrameCallback((RunnerVsyncHandler) obj);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        DemoGLSurfaceView demoGLSurfaceView = this.mGLView;
        if (demoGLSurfaceView != null) {
            demoGLSurfaceView.surfaceChanged(surfaceHolder, i, i2, i3);
            int i4 = RunnerJNILib.mGameSpeedControl;
            if (i4 != 0) {
                SetGLViewFrameRate(i4);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        DemoGLSurfaceView demoGLSurfaceView = this.mGLView;
        if (demoGLSurfaceView != null) {
            demoGLSurfaceView.surfaceCreated(surfaceHolder);
            int i = RunnerJNILib.mGameSpeedControl;
            if (i != 0) {
                SetGLViewFrameRate(i);
            }
        }
        Object obj = this.vsyncHandler;
        if (obj != null) {
            Choreographer.getInstance().postFrameCallback((RunnerVsyncHandler) obj);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        DemoGLSurfaceView demoGLSurfaceView = this.mGLView;
        if (demoGLSurfaceView != null) {
            demoGLSurfaceView.surfaceDestroyed(surfaceHolder);
        }
    }

    public void updateDisplayModeForRefreshRate(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (DisplayUpdatePending.get()) {
                    Log.i(GooglePlayBillingService.TAG, MnHfHMYQDPUO.UsSLYOLrBP);
                    return;
                }
                Display.Mode modeSelectClosestDisplayModeForRefreshRate = selectClosestDisplayModeForRefreshRate(i);
                if (modeSelectClosestDisplayModeForRefreshRate == null) {
                    Log.i(GooglePlayBillingService.TAG, "[updateDisplayModeForRefreshRate] Error: could not find supported DM for requested rate: " + String.valueOf(i));
                    DisplayUpdatePending.set(false);
                    return;
                }
                DisplayUpdatePending.set(true);
                if (Looper.getMainLooper() != null) {
                    CurrentActivity.runOnUiThread(new Worker.AnonymousClass1(modeSelectClosestDisplayModeForRefreshRate, 18));
                }
            } catch (Exception e) {
                Log.i(GooglePlayBillingService.TAG, "[updateDisplayModeForRefreshRate] Error: " + e.getMessage());
            }
        }
    }
}
