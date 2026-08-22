package com.facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ProfileManager {
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(6);
    public static volatile ProfileManager instance;
    public Profile currentProfileField;
    public final LocalBroadcastManager localBroadcastManager;
    public final ProfileCache profileCache;

    public ProfileManager(LocalBroadcastManager localBroadcastManager, ProfileCache profileCache) {
        this.localBroadcastManager = localBroadcastManager;
        this.profileCache = profileCache;
    }

    public final void setCurrentProfile(Profile profile, boolean z) {
        boolean zEquals;
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z) {
            SharedPreferences sharedPreferences = (SharedPreferences) this.profileCache.sharedPreferences;
            if (profile != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", profile.id);
                    jSONObject.put("first_name", profile.firstName);
                    jSONObject.put("middle_name", profile.middleName);
                    jSONObject.put("last_name", profile.lastName);
                    jSONObject.put("name", profile.name);
                    Uri uri = profile.linkUri;
                    if (uri != null) {
                        jSONObject.put("link_uri", uri.toString());
                    }
                    Uri uri2 = profile.pictureUri;
                    if (uri2 != null) {
                        jSONObject.put("picture_uri", uri2.toString());
                    }
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
                }
            } else {
                sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
            }
        }
        if (profile2 == null) {
            zEquals = profile == null;
        } else {
            zEquals = profile2.equals(profile);
        }
        if (zEquals) {
            return;
        }
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile2);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile);
        this.localBroadcastManager.sendBroadcast(intent);
    }
}
