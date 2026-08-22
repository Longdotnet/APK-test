package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessTokenCache;
import com.facebook.AccessTokenManager;
import com.facebook.appevents.internal.SessionInfo;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import kotlin.ranges.RangesKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatEditText extends EditText implements OnReceiveContentViewBehavior, TintableCompoundDrawablesView {
    public final AppCompatProgressBarHelper mAppCompatEmojiEditTextHelper;
    public final SessionInfo mBackgroundTintHelper;
    public final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    public SuperCaller mSuperCaller;
    public final AppCompatProgressBarHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX INFO: loaded from: classes.dex */
    public final class SuperCaller {
        public SuperCaller() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        SessionInfo sessionInfo = new SessionInfo(this);
        this.mBackgroundTintHelper = sessionInfo;
        sessionInfo.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper();
        appCompatProgressBarHelper.mView = this;
        this.mTextClassifierHelper = appCompatProgressBarHelper;
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatProgressBarHelper appCompatProgressBarHelper2 = new AppCompatProgressBarHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatProgressBarHelper2;
        appCompatProgressBarHelper2.loadFromAttributes(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListener2 = appCompatProgressBarHelper2.getKeyListener(keyListener);
        if (keyListener2 == keyListener) {
            return;
        }
        super.setKeyListener(keyListener2);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    private SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            this.mSuperCaller = new SuperCaller();
        }
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return RangesKt.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        AppCompatProgressBarHelper appCompatProgressBarHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatProgressBarHelper = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) appCompatProgressBarHelper.mSampleTile;
        return textClassifier == null ? AppCompatTextClassifierHelper$Api26Impl.getTextClassifier((TextView) appCompatProgressBarHelper.mView) : textClassifier;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0057 A[PHI: r1
  0x0057: PHI (r1v10 java.lang.String[]) = (r1v5 java.lang.String[]), (r1v11 java.lang.String[]) binds: [B:30:0x006a, B:22:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] onReceiveContentMimeTypes;
        String[] stringArray;
        InputConnectionWrapper inputConnectionWrapper;
        final InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        AppCompatTextHelper.populateSurroundingTextIfNeeded(editorInfo, inputConnectionOnCreateInputConnection, this);
        Protocol.Companion.onCreateInputConnection(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && (i = Build.VERSION.SDK_INT) <= 30 && (onReceiveContentMimeTypes = ViewCompat.getOnReceiveContentMimeTypes(this)) != null) {
            if (i >= 25) {
                editorInfo.contentMimeTypes = onReceiveContentMimeTypes;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", onReceiveContentMimeTypes);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", onReceiveContentMimeTypes);
            }
            final InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(this, 0);
            if (i >= 25) {
                inputConnectionWrapper = new InputConnectionWrapper(inputConnectionOnCreateInputConnection) { // from class: androidx.core.view.inputmethod.InputConnectionCompat$1
                    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                    public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                        AccessTokenCache accessTokenCache = null;
                        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
                            accessTokenCache = new AccessTokenCache(new InputContentInfoCompat$InputContentInfoCompatApi25Impl(inputContentInfo), 6);
                        }
                        if (inputConnectionCompat$$ExternalSyntheticLambda0.onCommitContent(accessTokenCache, i2, bundle)) {
                            return true;
                        }
                        return super.commitContent(inputContentInfo, i2, bundle);
                    }
                };
            } else {
                String[] strArr = EditorInfoCompat.EMPTY_STRING_ARRAY;
                if (i >= 25) {
                    stringArray = editorInfo.contentMimeTypes;
                    if (stringArray != null) {
                        strArr = stringArray;
                    }
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (stringArray == null) {
                            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                        if (stringArray != null) {
                            strArr = stringArray;
                        }
                    }
                }
                if (strArr.length != 0) {
                    inputConnectionWrapper = new InputConnectionWrapper(inputConnectionOnCreateInputConnection) { // from class: androidx.core.view.inputmethod.InputConnectionCompat$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                        public final boolean performPrivateCommand(String str, Bundle bundle2) throws Throwable {
                            byte b;
                            ResultReceiver resultReceiver;
                            InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda1 = inputConnectionCompat$$ExternalSyntheticLambda0;
                            boolean zOnCommitContent = false;
                            zOnCommitContent = false;
                            zOnCommitContent = false;
                            zOnCommitContent = false;
                            if (bundle2 != null) {
                                if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                                    b = false;
                                } else if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                                    b = true;
                                }
                                try {
                                    resultReceiver = (ResultReceiver) bundle2.getParcelable(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
                                    try {
                                        Uri uri = (Uri) bundle2.getParcelable(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                                        ClipDescription clipDescription = (ClipDescription) bundle2.getParcelable(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                                        Uri uri2 = (Uri) bundle2.getParcelable(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : CyjpdoedCdLTIO.dalbD);
                                        int i2 = bundle2.getInt(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                                        Bundle bundle3 = (Bundle) bundle2.getParcelable(b != false ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                                        if (uri != null && clipDescription != null) {
                                            zOnCommitContent = inputConnectionCompat$$ExternalSyntheticLambda1.onCommitContent(new AccessTokenCache(uri, clipDescription, uri2), i2, bundle3);
                                        }
                                        if (resultReceiver != null) {
                                            resultReceiver.send(zOnCommitContent ? 1 : 0, null);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        if (resultReceiver != null) {
                                            resultReceiver.send(0, null);
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    resultReceiver = null;
                                }
                            }
                            if (zOnCommitContent) {
                                return true;
                            }
                            return super.performPrivateCommand(str, bundle2);
                        }
                    };
                }
            }
            inputConnectionOnCreateInputConnection = inputConnectionWrapper;
        }
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean zOnDropForTextView = false;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zOnDropForTextView = AppCompatReceiveContentHelper$OnDropApi24Impl.onDropForTextView(dragEvent, this, activity);
            }
        }
        if (zOnDropForTextView) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, contentInfoCompat);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(RangesKt.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintList(colorStateList);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintMode(mode);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatProgressBarHelper appCompatProgressBarHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatProgressBarHelper = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            appCompatProgressBarHelper.mSampleTile = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        AccessTokenManager.RefreshResult refreshResult;
        ContentInfoCompat.BuilderCompat builderCompat;
        int i2;
        AccessTokenCache accessTokenCache;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 || ViewCompat.getOnReceiveContentMimeTypes(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(QTaELkFI.JwOxEDQLtpzg);
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i3 >= 31) {
                accessTokenCache = new AccessTokenCache(primaryClip, 1);
            } else {
                refreshResult = new AccessTokenManager.RefreshResult(1);
                refreshResult.accessToken = primaryClip;
                refreshResult.expiresAt = 1;
            }
            if (i == 16908322) {
                builderCompat = refreshResult;
                builderCompat = accessTokenCache;
                i2 = 0;
            } else {
                builderCompat = refreshResult;
                builderCompat = accessTokenCache;
                i2 = 1;
            }
            builderCompat.setFlags(i2);
            ViewCompat.performReceiveContent(this, builderCompat.build());
        }
        return true;
    }
}
