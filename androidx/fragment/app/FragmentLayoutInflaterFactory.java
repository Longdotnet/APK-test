package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        final FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.mFragmentManager;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = Fragment.class.isAssignableFrom(FragmentManager.AnonymousClass3.loadClass(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment fragmentFindFragmentById = resourceId != -1 ? fragmentManager.findFragmentById(resourceId) : null;
                if (fragmentFindFragmentById == null && string != null) {
                    fragmentFindFragmentById = fragmentManager.findFragmentByTag(string);
                }
                if (fragmentFindFragmentById == null && id != -1) {
                    fragmentFindFragmentById = fragmentManager.findFragmentById(id);
                }
                if (fragmentFindFragmentById == null) {
                    FragmentManager.AnonymousClass3 fragmentFactory = fragmentManager.getFragmentFactory();
                    context.getClassLoader();
                    fragmentFindFragmentById = Fragment.instantiate(FragmentManager.this.mHost.mContext, attributeValue, null);
                    fragmentFindFragmentById.mFromLayout = true;
                    fragmentFindFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                    fragmentFindFragmentById.mContainerId = id;
                    fragmentFindFragmentById.mTag = string;
                    fragmentFindFragmentById.mInLayout = true;
                    fragmentFindFragmentById.mFragmentManager = fragmentManager;
                    FragmentActivity.HostCallbacks hostCallbacks = fragmentManager.mHost;
                    fragmentFindFragmentById.mHost = hostCallbacks;
                    fragmentFindFragmentById.onInflate((Context) hostCallbacks.mContext, attributeSet, fragmentFindFragmentById.mSavedFragmentState);
                    fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.addFragment(fragmentFindFragmentById);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Fragment " + fragmentFindFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    if (fragmentFindFragmentById.mInLayout) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    fragmentFindFragmentById.mInLayout = true;
                    fragmentFindFragmentById.mFragmentManager = fragmentManager;
                    FragmentActivity.HostCallbacks hostCallbacks2 = fragmentManager.mHost;
                    fragmentFindFragmentById.mHost = hostCallbacks2;
                    fragmentFindFragmentById.onInflate((Context) hostCallbacks2.mContext, attributeSet, fragmentFindFragmentById.mSavedFragmentState);
                    fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.createOrGetFragmentStateManager(fragmentFindFragmentById);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Retained Fragment " + fragmentFindFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                }
                ViewGroup viewGroup = (ViewGroup) view;
                FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                FragmentStrictMode.logIfDebuggingEnabled(new FragmentTagUsageViolation(fragmentFindFragmentById, viewGroup, 0));
                FragmentStrictMode.getNearestPolicy(fragmentFindFragmentById).getClass();
                fragmentFindFragmentById.mContainer = viewGroup;
                fragmentStateManagerCreateOrGetFragmentStateManager.moveToExpectedState();
                fragmentStateManagerCreateOrGetFragmentStateManager.ensureInflatedView();
                View view2 = fragmentFindFragmentById.mView;
                if (view2 == null) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (fragmentFindFragmentById.mView.getTag() == null) {
                    fragmentFindFragmentById.mView.setTag(string);
                }
                fragmentFindFragmentById.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view3) {
                        FragmentStateManager fragmentStateManager = fragmentStateManagerCreateOrGetFragmentStateManager;
                        Fragment fragment = fragmentStateManager.mFragment;
                        fragmentStateManager.moveToExpectedState();
                        DefaultSpecialEffectsController.getOrCreateController((ViewGroup) fragment.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view3) {
                    }
                });
                return fragmentFindFragmentById.mView;
            }
        }
        return null;
    }
}
