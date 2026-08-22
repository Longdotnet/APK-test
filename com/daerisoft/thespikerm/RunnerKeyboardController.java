package com.daerisoft.thespikerm;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.regex.Pattern;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class RunnerKeyboardController {
    public static final int ms_estimatedKeyboardHeight = 48 + 100;
    public View m_activityView;
    public boolean m_bufferedTextInput;
    public RunnerActivity m_context;
    public int m_currentKeyboardHeight;
    public boolean m_currentPredictiveTextEnabled;
    public KeyboardInputEditText m_editText;
    public InputMethodManager m_inputMethodManager;
    public String m_keyboardStatus;
    public boolean m_physicalKeyboardConnected;
    public boolean m_setTextHandlerEnabled;
    public Rect m_viewActiveRect;
    public Handler m_viewHandler;
    public boolean m_virtualKeyboardActive;
    public AnonymousClass2 m_virtualKeyboardToggleResultReceiver;
    public AnonymousClass2 m_virtualKeyboardVisibilityCheckAdjustReceiver;
    public boolean m_virtualKeyboardVisible;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.RunnerKeyboardController$5, reason: invalid class name */
    public final class AnonymousClass5 implements Runnable {
        public final /* synthetic */ int val$_autoCapitalizationType;
        public final /* synthetic */ int[] val$_inputString;
        public final /* synthetic */ int val$_keyboardType;
        public final /* synthetic */ boolean val$_predictiveTextEnabled;
        public final /* synthetic */ int val$_returnKeyType;
        public final /* synthetic */ boolean val$_toggleOn;

        public AnonymousClass5(boolean z, int i, int i2, boolean z2, int i3, int[] iArr) {
            this.val$_toggleOn = z;
            this.val$_keyboardType = i;
            this.val$_autoCapitalizationType = i2;
            this.val$_predictiveTextEnabled = z2;
            this.val$_returnKeyType = i3;
            this.val$_inputString = iArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public final void run() {
            int i;
            RunnerKeyboardController runnerKeyboardController = RunnerKeyboardController.this;
            boolean z = true;
            if (!this.val$_toggleOn) {
                runnerKeyboardController.m_editText.clearFocus();
                runnerKeyboardController.m_inputMethodManager.hideSoftInputFromWindow(runnerKeyboardController.m_editText.getWindowToken(), 0, runnerKeyboardController.m_virtualKeyboardToggleResultReceiver);
                return;
            }
            int i2 = this.val$_keyboardType;
            if (i2 == 0) {
                i = 1;
            } else if (i2 == 2) {
                i = 16;
            } else if (i2 == 3) {
                i = 32;
            } else if (i2 == 4) {
                i = 2;
            } else if (i2 != 5) {
                i = i2 != 6 ? 0 : 96;
            } else {
                i = 3;
            }
            int i3 = this.val$_autoCapitalizationType;
            if (i3 == 1) {
                i |= 8192;
            } else if (i3 == 2) {
                i |= 16384;
            } else if (i3 == 3) {
                i |= 4096;
            }
            boolean z2 = this.val$_predictiveTextEnabled;
            if (!z2) {
                i |= Build.MANUFACTURER.equalsIgnoreCase("HTC") ? 524288 : 524432;
            }
            int i4 = 838860805;
            String str = null;
            switch (this.val$_returnKeyType) {
                case 1:
                    str = "Go";
                    i4 = 838860802;
                    break;
                case 2:
                    str = "Google";
                    i4 = 838860803;
                    break;
                case 3:
                    str = "Join";
                    i4 = 838860802;
                    break;
                case 4:
                    str = mnwSv.YhcNvQOEhnGA;
                    break;
                case 5:
                    str = "Route";
                    i4 = 838860802;
                    break;
                case 6:
                    i4 = 838860803;
                    break;
                case 7:
                    i4 = 838860804;
                    break;
                case 8:
                    str = "Yahoo";
                    i4 = 838860803;
                    break;
                case 9:
                    i4 = 838860806;
                    break;
                case 10:
                    str = "Continue";
                    break;
                case 11:
                    str = "Emergency Call";
                    i4 = 838860802;
                    break;
                default:
                    i4 = 838860800;
                    break;
            }
            int i5 = (-98305) & i4;
            runnerKeyboardController.getClass();
            runnerKeyboardController.m_currentPredictiveTextEnabled = z2;
            runnerKeyboardController.m_editText.setImeOptions(i5);
            runnerKeyboardController.m_editText.setImeActionLabel(str, i5);
            runnerKeyboardController.m_editText.setInputType(i);
            runnerKeyboardController.m_editText.requestFocus();
            if (!z2 && i3 == 0) {
                z = false;
            }
            runnerKeyboardController.m_bufferedTextInput = z;
            if (z) {
                runnerKeyboardController.SetInputString(this.val$_inputString);
            } else {
                runnerKeyboardController.SetInputString("");
            }
            runnerKeyboardController.m_inputMethodManager.showSoftInput(runnerKeyboardController.m_editText, 0, runnerKeyboardController.m_virtualKeyboardToggleResultReceiver);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class KeyboardInputConnectionWrapper extends InputConnectionWrapper {
        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean setComposingRegion(int i, int i2) {
            CharSequence charSequence;
            if (i > 0) {
                ExtractedText extractedText = getExtractedText(new ExtractedTextRequest(), 0);
                String string = (extractedText == null || (charSequence = extractedText.text) == null) ? "" : charSequence.toString();
                int length = string.length();
                if (length > 0) {
                    i = Math.min(i, length - 1);
                    while (i > 0) {
                        char cCharAt = string.charAt(i - 1);
                        String string2 = Character.toString(cCharAt);
                        if (Character.isWhitespace(cCharAt) || Pattern.matches("\\p{Punct}", string2)) {
                            break;
                        }
                        i--;
                    }
                }
            }
            return super.setComposingRegion(i, i2);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class KeyboardInputEditText extends AppCompatEditText {
        public final RunnerKeyboardController m_keyboardController;

        public KeyboardInputEditText(RunnerActivity runnerActivity, RunnerKeyboardController runnerKeyboardController) {
            super(runnerActivity, null);
            this.m_keyboardController = runnerKeyboardController;
        }

        @Override // android.widget.TextView
        public final boolean isSuggestionsEnabled() {
            RunnerKeyboardController runnerKeyboardController = this.m_keyboardController;
            return runnerKeyboardController != null ? runnerKeyboardController.m_currentPredictiveTextEnabled : super.isSuggestionsEnabled();
        }

        @Override // android.widget.TextView, android.view.View
        public final boolean onCheckIsTextEditor() {
            return true;
        }

        @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new KeyboardInputConnectionWrapper(super.onCreateInputConnection(editorInfo), true);
        }

        @Override // android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i != 4 && (i != 97 || (keyEvent.getSource() & 1025) != 1025)) {
                return false;
            }
            RunnerKeyboardController.this.VirtualKeyboardHide();
            return false;
        }
    }

    public static int[] GetStringCodepoints(String str) {
        int length = str.length();
        int iCharCount = 0;
        int iCharCount2 = 0;
        int i = 0;
        while (iCharCount2 < length) {
            i++;
            iCharCount2 += Character.charCount(str.codePointAt(iCharCount2));
        }
        int[] iArr = new int[i];
        int i2 = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iArr[i2] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i2++;
        }
        return iArr;
    }

    public final void SetInputString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        String string = sb.toString();
        Log.i(GooglePlayBillingService.TAG, "[VK] SetInputString. Length: " + iArr.length + ". New string: " + string);
        SetInputString(string);
    }

    public final void VirtualKeyboardHide() {
        KeyboardInputEditText keyboardInputEditText = this.m_editText;
        this.m_viewHandler.post(new AnonymousClass5(false, 0, 0, true, 0, GetStringCodepoints(keyboardInputEditText != null ? keyboardInputEditText.getText().toString() : "")));
    }

    public final void SetInputString(String str) {
        KeyboardInputEditText keyboardInputEditText = this.m_editText;
        if (keyboardInputEditText == null) {
            return;
        }
        this.m_setTextHandlerEnabled = false;
        keyboardInputEditText.setText(str);
        this.m_editText.setSelection(str.length());
        this.m_setTextHandlerEnabled = true;
    }
}
