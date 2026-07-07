package com.android.settings.aetheria.display;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.core.TogglePreferenceController;

public class ForcePeakRefreshRatePreferenceController extends TogglePreferenceController {

    private static final String SETTING_KEY = "aetheria_display_force_peak_refresh_rate";

    public ForcePeakRefreshRatePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.System.getInt(mContext.getContentResolver(), SETTING_KEY, 0) == 1;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        return Settings.System.putInt(mContext.getContentResolver(), SETTING_KEY, isChecked ? 1 : 0);
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return 0;
    }
}
