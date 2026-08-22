package com.facebook.login;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoginManager {
    public static final Set OTHER_PUBLISH_PERMISSIONS = GamepadHandler_API19.setOf("ads_management", "create_event", "rsvp_event");

    static {
        Intrinsics.checkNotNullExpressionValue(LoginManager.class.toString(), "LoginManager::class.java.toString()");
    }
}
