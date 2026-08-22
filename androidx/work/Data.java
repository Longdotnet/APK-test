package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class Data {
    public static final Data EMPTY;
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Data");
    public final HashMap mValues;

    static {
        Data data = new Data(new HashMap());
        toByteArrayInternal(data);
        EMPTY = data;
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    public static byte[] toByteArrayInternal(Data data) throws Throwable {
        String str = TAG;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(data.mValues.size());
                    for (Map.Entry entry : data.mValues.entrySet()) {
                        objectOutputStream2.writeUTF((String) entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        Log.e(str, "Error in Data#toByteArray: ", e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(str, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                    Log.e(str, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            Log.e(str, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        Log.e(str, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(str, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        Log.e(str, "Error in Data#toByteArray: ", e7);
                        throw th;
                    }
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        HashMap map = this.mValues;
        Set<String> setKeySet = map.keySet();
        HashMap map2 = ((Data) obj).mValues;
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = map.get(str);
            Object obj3 = map2.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public final String getString(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        HashMap map = this.mValues;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Data fromByteArray(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable e;
        String str = TAG;
        if (bArr.length > 10240) {
            throw new IllegalStateException(mnwSv.aKKfwwJPUjcnQbz);
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int i = objectInputStream.readInt(); i > 0; i--) {
                            map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            Log.e(str, "Error in Data#fromByteArray: ", e2);
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        Log.e(str, "Error in Data#fromByteArray: ", e);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e4) {
                                Log.e(str, "Error in Data#fromByteArray: ", e4);
                            }
                        }
                        byteArrayInputStream.close();
                    } catch (ClassNotFoundException e5) {
                        e = e5;
                        Log.e(str, "Error in Data#fromByteArray: ", e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        byteArrayInputStream.close();
                    }
                } catch (IOException e6) {
                    e = e6;
                    Throwable th = e;
                    objectInputStream = null;
                    e = th;
                    Log.e(str, "Error in Data#fromByteArray: ", e);
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (ClassNotFoundException e7) {
                    e = e7;
                    Throwable th2 = e;
                    objectInputStream = null;
                    e = th2;
                    Log.e(str, "Error in Data#fromByteArray: ", e);
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e8) {
                            Log.e(str, "Error in Data#fromByteArray: ", e8);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e9) {
                        Log.e(str, "Error in Data#fromByteArray: ", e9);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                Log.e(str, "Error in Data#fromByteArray: ", e10);
            }
            return new Data(map);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public Data(HashMap map) {
        this.mValues = new HashMap(map);
    }
}
