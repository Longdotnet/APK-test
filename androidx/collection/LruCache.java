package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<Object, Object> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public Object create(Object obj) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final Object get(Object obj) {
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj2 = this.map.get(obj);
                if (obj2 != null) {
                    this.hitCount++;
                    return obj2;
                }
                this.missCount++;
                Object objCreate = create(obj);
                if (objCreate == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.createCount++;
                        objPut = this.map.put(obj, objCreate);
                        if (objPut != null) {
                            this.map.put(obj, objPut);
                        } else {
                            this.size += safeSizeOf(obj, objCreate);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objPut != null) {
                    entryRemoved(false, obj, objCreate, objPut);
                    return objPut;
                }
                trimToSize(this.maxSize);
                return objCreate;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.putCount++;
                this.size += safeSizeOf(obj, obj2);
                objPut = this.map.put(obj, obj2);
                if (objPut != null) {
                    this.size -= safeSizeOf(obj, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            entryRemoved(false, obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final Object remove(Object obj) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                objRemove = this.map.remove(obj);
                if (objRemove != null) {
                    this.size -= safeSizeOf(obj, objRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            entryRemoved(false, obj, objRemove, null);
        }
        return objRemove;
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    public final int safeSizeOf(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    public final synchronized int size() {
        return this.size;
    }

    public int sizeOf(Object obj, Object obj2) {
        return 1;
    }

    public final synchronized Map<Object, Object> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        try {
            int i2 = this.hitCount;
            int i3 = this.missCount + i2;
            i = i3 != 0 ? (i2 * 100) / i3 : 0;
            Locale locale = Locale.US;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i + "%]";
    }

    public void trimToSize(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size > i && !this.map.isEmpty()) {
                        Map.Entry<Object, Object> next = this.map.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }
}
