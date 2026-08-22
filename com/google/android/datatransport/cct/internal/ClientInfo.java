package com.google.android.datatransport.cct.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class ClientInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class ClientType {
        public static final /* synthetic */ ClientType[] $VALUES;
        public static final ClientType ANDROID_FIREBASE;

        /* JADX INFO: Fake field, exist only in values array */
        ClientType EF2;

        static {
            ClientType clientType = new ClientType("UNKNOWN", 0);
            ClientType clientType2 = new ClientType("ANDROID_FIREBASE", 1);
            ANDROID_FIREBASE = clientType2;
            $VALUES = new ClientType[]{clientType, clientType2};
        }

        public static ClientType valueOf(String str) {
            return (ClientType) Enum.valueOf(ClientType.class, str);
        }

        public static ClientType[] values() {
            return (ClientType[]) $VALUES.clone();
        }
    }
}
