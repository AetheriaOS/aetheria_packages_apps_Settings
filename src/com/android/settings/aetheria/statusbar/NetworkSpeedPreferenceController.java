package com.android.settings.aetheria.statusbar;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.core.TogglePreferenceController;

public class NetworkSpeedPreferenceController extends TogglePreferenceController {

    private static final String KEY = "aetheria_statusbar_network_speed";

    public NetworkSpeedPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.System.getInt(mContext.getContentResolver(),
                "aetheria_statusbar_network_speed", 0) == 1;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        return Settings.System.putInt(mContext.getContentResolver(),
                "aetheria_statusbar_network_speed", isChecked ? 1 : 0);
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return 0;
    }
}
