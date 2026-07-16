package com.android.settings.aetheria;

import android.app.settings.SettingsEnums;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;

import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.Indexable.SearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class ExtensionSettings extends DashboardFragment {

    private static final String TAG = "ExtensionSettings";

    @Override
    public int getMetricsCategory() {
        return SettingsEnums.DASHBOARD_SUMMARY;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public int getPreferenceScreenResId() {
        return R.xml.aetheria_extension_settings;
    }

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.aetheria_extension_settings);
}
