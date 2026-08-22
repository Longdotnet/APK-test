package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;

/* JADX INFO: loaded from: classes.dex */
public interface ViewModelProvider$Factory {
    ViewModel create(Class cls);

    ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras);
}
