package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class jClass;

    public PackageReference(Class cls) {
        this.jClass = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageReference) {
            if (Intrinsics.areEqual(this.jClass, ((PackageReference) obj).jClass)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    public final int hashCode() {
        return this.jClass.hashCode();
    }

    public final String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
