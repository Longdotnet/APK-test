package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public final LinkedHashMap rcToKey = new LinkedHashMap();
    public final LinkedHashMap keyToRc = new LinkedHashMap();
    public final LinkedHashMap keyToLifecycleContainers = new LinkedHashMap();
    public final ArrayList launchedKeys = new ArrayList();
    public final transient LinkedHashMap keyToCallback = new LinkedHashMap();
    public final LinkedHashMap parsedPendingResults = new LinkedHashMap();
    public final Bundle pendingResults = new Bundle();

    /* JADX INFO: loaded from: classes2.dex */
    public final class CallbackAndContract {
        public final ActivityResultCallback callback;
        public final ActivityResultContract contract;

        public CallbackAndContract(ActivityResultContract contract, ActivityResultCallback activityResultCallback) {
            Intrinsics.checkNotNullParameter(activityResultCallback, jIKWv.GOgUaZUhZ);
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.callback = activityResultCallback;
            this.contract = contract;
        }
    }

    public final class LifecycleContainer {
        public final Lifecycle lifecycle;
        public final ArrayList observers = new ArrayList();

        public LifecycleContainer(Lifecycle lifecycle) {
            this.lifecycle = lifecycle;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.result.ActivityResultRegistry$register$2 */
    public final class AnonymousClass2 extends ActivityResultLauncher {
        public final /* synthetic */ ActivityResultContract $contract;
        public final /* synthetic */ String $key;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ActivityResultRegistry this$0;

        public /* synthetic */ AnonymousClass2(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, int i) {
            this.$r8$classId = i;
            this.this$0 = activityResultRegistry;
            this.$key = str;
            this.$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void launch(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ActivityResultRegistry activityResultRegistry = this.this$0;
                    LinkedHashMap linkedHashMap = activityResultRegistry.keyToRc;
                    String str = this.$key;
                    Object obj2 = linkedHashMap.get(str);
                    ActivityResultContract activityResultContract = this.$contract;
                    if (obj2 == null) {
                        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                    }
                    int iIntValue = ((Number) obj2).intValue();
                    ArrayList arrayList = activityResultRegistry.launchedKeys;
                    arrayList.add(str);
                    try {
                        activityResultRegistry.onLaunch(iIntValue, activityResultContract, obj);
                        return;
                    } catch (Exception e) {
                        arrayList.remove(str);
                        throw e;
                    }
                default:
                    ActivityResultRegistry activityResultRegistry2 = this.this$0;
                    LinkedHashMap linkedHashMap2 = activityResultRegistry2.keyToRc;
                    String str2 = this.$key;
                    Object obj3 = linkedHashMap2.get(str2);
                    ActivityResultContract activityResultContract2 = this.$contract;
                    if (obj3 == null) {
                        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                    }
                    int iIntValue2 = ((Number) obj3).intValue();
                    ArrayList arrayList2 = activityResultRegistry2.launchedKeys;
                    arrayList2.add(str2);
                    try {
                        activityResultRegistry2.onLaunch(iIntValue2, activityResultContract2, obj);
                        return;
                    } catch (Exception e2) {
                        arrayList2.remove(str2);
                        throw e2;
                    }
            }
        }

        public void unregister() {
            this.this$0.unregister$activity_release(this.$key);
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = (String) this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.keyToCallback.get(str);
        if ((callbackAndContract != null ? callbackAndContract.callback : null) != null) {
            ArrayList arrayList = this.launchedKeys;
            if (arrayList.contains(str)) {
                callbackAndContract.callback.onActivityResult(callbackAndContract.contract.parseResult(i2, intent));
                arrayList.remove(str);
                return true;
            }
        }
        this.parsedPendingResults.remove(str);
        this.pendingResults.putParcelable(str, new ActivityResult(i2, intent));
        return true;
    }

    public abstract void onLaunch(int i, ActivityResultContract activityResultContract, Object obj);

    public final AnonymousClass2 register(final String key, LifecycleOwner lifecycleOwner, final ActivityResultContract contract, final ActivityResultCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle;
        if (lifecycleRegistry.state.compareTo(Lifecycle.State.STARTED) >= 0) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycleRegistry.state + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        registerKey(key);
        LinkedHashMap linkedHashMap = this.keyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ActivityResultRegistry this$0 = this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                String key2 = key;
                Intrinsics.checkNotNullParameter(key2, "$key");
                ActivityResultCallback callback2 = callback;
                Intrinsics.checkNotNullParameter(callback2, "$callback");
                ActivityResultContract contract2 = contract;
                Intrinsics.checkNotNullParameter(contract2, "$contract");
                Lifecycle.Event event2 = Lifecycle.Event.ON_START;
                LinkedHashMap linkedHashMap2 = this$0.keyToCallback;
                if (event2 != event) {
                    if (Lifecycle.Event.ON_STOP == event) {
                        linkedHashMap2.remove(key2);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY == event) {
                            this$0.unregister$activity_release(key2);
                            return;
                        }
                        return;
                    }
                }
                linkedHashMap2.put(key2, new ActivityResultRegistry.CallbackAndContract(contract2, callback2));
                LinkedHashMap linkedHashMap3 = this$0.parsedPendingResults;
                if (linkedHashMap3.containsKey(key2)) {
                    Object obj = linkedHashMap3.get(key2);
                    linkedHashMap3.remove(key2);
                    callback2.onActivityResult(obj);
                }
                Bundle bundle = this$0.pendingResults;
                ActivityResult activityResult = (ActivityResult) Okio.getParcelable(bundle, key2);
                if (activityResult != null) {
                    bundle.remove(key2);
                    callback2.onActivityResult(contract2.parseResult(activityResult.resultCode, activityResult.data));
                }
            }
        };
        lifecycleContainer.lifecycle.addObserver(lifecycleEventObserver);
        lifecycleContainer.observers.add(lifecycleEventObserver);
        linkedHashMap.put(key, lifecycleContainer);
        return new AnonymousClass2(this, key, contract, 0);
    }

    public final void registerKey(String str) {
        LinkedHashMap linkedHashMap = this.keyToRc;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        for (Number number : new ConstrainedOnceSequence(new GeneratorSequence(new SequencesKt__SequencesKt$generateSequence$1(1), 0))) {
            int iIntValue = number.intValue();
            LinkedHashMap linkedHashMap2 = this.rcToKey;
            if (!linkedHashMap2.containsKey(Integer.valueOf(iIntValue))) {
                int iIntValue2 = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue2), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue2));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void unregister$activity_release(String key) {
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.launchedKeys.contains(key) && (num = (Integer) this.keyToRc.remove(key)) != null) {
            this.rcToKey.remove(num);
        }
        this.keyToCallback.remove(key);
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(key)) {
            StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Dropping pending result for request ", key, ": ");
            sbM21m.append(linkedHashMap.get(key));
            Log.w("ActivityResultRegistry", sbM21m.toString());
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.pendingResults;
        if (bundle.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) Okio.getParcelable(bundle, key)));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.keyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap2.get(key);
        if (lifecycleContainer != null) {
            ArrayList arrayList = lifecycleContainer.observers;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                lifecycleContainer.lifecycle.removeObserver((LifecycleEventObserver) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }

    public final AnonymousClass2 register(String key, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        registerKey(key);
        this.keyToCallback.put(key, new CallbackAndContract(activityResultContract, activityResultCallback));
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.pendingResults;
        ActivityResult activityResult = (ActivityResult) Okio.getParcelable(bundle, key);
        if (activityResult != null) {
            bundle.remove(key);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.resultCode, activityResult.data));
        }
        return new AnonymousClass2(this, key, activityResultContract, 1);
    }
}
