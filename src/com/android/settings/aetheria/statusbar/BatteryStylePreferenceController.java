package com.android.settings.aetheria.statusbar;

import android.content.Context;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.core.BasePreferenceController;

import lineageos.providers.LineageSettings;

public class BatteryStylePreferenceController extends BasePreferenceController
        implements Preference.OnPreferenceChangeListener {

    public BatteryStylePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        ListPreference pref = screen.findPreference(getPreferenceKey());
        if (pref == null) return;

        int current = LineageSettings.System.getInt(mContext.getContentResolver(),
                LineageSettings.System.STATUS_BAR_BATTERY_STYLE, 0);
        pref.setValue(String.valueOf(current));
        pref.setSummary(pref.getEntry());
        pref.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        int value = Integer.parseInt((String) newValue);
        LineageSettings.System.putInt(mContext.getContentResolver(),
                LineageSettings.System.STATUS_BAR_BATTERY_STYLE, value);

        ListPreference pref = (ListPreference) preference;
        int index = pref.findIndexOfValue((String) newValue);
        if (index >= 0) {
            pref.setSummary(pref.getEntries()[index]);
        }
        return true;
    }

    @Override
    public CharSequence getSummary() {
        return null;
    }
}
