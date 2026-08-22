package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.daerisoft.thespikerm.R;
import com.facebook.ProfileCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    public static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    public final AccessibilityDelegateAdapter mBridge;
    public final View.AccessibilityDelegate mOriginalDelegate;

    public final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.mCompat = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = this.mCompat.mOriginalDelegate.getAccessibilityNodeProvider(view);
            ProfileCache profileCache = accessibilityNodeProvider != null ? new ProfileCache(accessibilityNodeProvider, 8) : null;
            if (profileCache != null) {
                return (AccessibilityNodeProvider) profileCache.sharedPreferences;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            Object tag;
            Object tag2;
            Object tag3;
            Object stateDescription;
            int iKeyAt;
            int i = 1;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (Build.VERSION.SDK_INT >= 28) {
                tag = Boolean.valueOf(ViewCompat.Api28Impl.isScreenReaderFocusable(view));
            } else {
                tag = view.getTag(R.id.tag_screen_reader_focusable);
                if (!Boolean.class.isInstance(tag)) {
                    tag = null;
                }
            }
            Boolean bool = (Boolean) tag;
            int i2 = 0;
            boolean z = (bool == null || !bool.booleanValue()) ? 0 : 1;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                accessibilityNodeInfo.setScreenReaderFocusable(z);
            } else {
                Bundle extras = accessibilityNodeInfo.getExtras();
                if (extras != null) {
                    extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", z | (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-2)));
                }
            }
            if (Build.VERSION.SDK_INT >= 28) {
                tag2 = Boolean.valueOf(ViewCompat.Api28Impl.isAccessibilityHeading(view));
            } else {
                tag2 = view.getTag(R.id.tag_accessibility_heading);
                if (!Boolean.class.isInstance(tag2)) {
                    tag2 = null;
                }
            }
            Boolean bool2 = (Boolean) tag2;
            boolean z2 = bool2 != null && bool2.booleanValue();
            if (i3 >= 28) {
                accessibilityNodeInfo.setHeading(z2);
            } else {
                Bundle extras2 = accessibilityNodeInfo.getExtras();
                if (extras2 != null) {
                    extras2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (z2 ? 2 : 0) | (extras2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-3)));
                }
            }
            if (i3 >= 28) {
                tag3 = ViewCompat.Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag3)) {
                    tag3 = null;
                }
            }
            CharSequence charSequence = (CharSequence) tag3;
            if (i3 >= 28) {
                accessibilityNodeInfo.setPaneTitle(charSequence);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
            if (i3 >= 30) {
                stateDescription = ViewCompat.Api30Impl.getStateDescription(view);
            } else {
                Object tag4 = view.getTag(R.id.tag_state_description);
                stateDescription = CharSequence.class.isInstance(tag4) ? tag4 : null;
            }
            CharSequence charSequence2 = (CharSequence) stateDescription;
            if (i3 >= 30) {
                AccessibilityNodeInfoCompat.Api30Impl.setStateDescription(accessibilityNodeInfo, charSequence2);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
            }
            this.mCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            CharSequence text = accessibilityNodeInfo.getText();
            if (i3 < 26) {
                accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                        if (((WeakReference) sparseArray.valueAt(i4)).get() == null) {
                            arrayList.add(Integer.valueOf(i4));
                        }
                    }
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        sparseArray.remove(((Integer) arrayList.get(i5)).intValue());
                    }
                }
                ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                    }
                    int i6 = 0;
                    while (i6 < clickableSpanArr.length) {
                        ClickableSpan clickableSpan = clickableSpanArr[i6];
                        int i7 = i2;
                        while (true) {
                            if (i7 >= sparseArray2.size()) {
                                iKeyAt = AccessibilityNodeInfoCompat.sClickableSpanId;
                                AccessibilityNodeInfoCompat.sClickableSpanId = iKeyAt + 1;
                                break;
                            } else {
                                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i7)).get())) {
                                    iKeyAt = sparseArray2.keyAt(i7);
                                    break;
                                }
                                i7 += i;
                            }
                        }
                        sparseArray2.put(iKeyAt, new WeakReference(clickableSpanArr[i6]));
                        ClickableSpan clickableSpan2 = clickableSpanArr[i6];
                        Spanned spanned = (Spanned) text;
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
                        i = 1;
                        i6++;
                        i2 = 0;
                    }
                }
            }
            List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
            if (listEmptyList == null) {
                listEmptyList = Collections.emptyList();
            }
            for (int i8 = 0; i8 < listEmptyList.size(); i8++) {
                accessibilityNodeInfoCompat.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listEmptyList.get(i8)).mAction);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.mCompat.performAccessibilityAction(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View view, int i) {
            this.mCompat.mOriginalDelegate.sendAccessibilityEvent(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        boolean z = false;
        for (int i2 = 0; i2 < listEmptyList.size() && ((AccessibilityNodeInfo.AccessibilityAction) ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listEmptyList.get(i2)).mAction).getId() != i; i2++) {
        }
        boolean zPerformAccessibilityAction = this.mOriginalDelegate.performAccessibilityAction(view, i, bundle);
        if (zPerformAccessibilityAction || i != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i3)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i4 = 0; clickableSpanArr != null && i4 < clickableSpanArr.length; i4++) {
                if (clickableSpan.equals(clickableSpanArr[i4])) {
                    clickableSpan.onClick(view);
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
