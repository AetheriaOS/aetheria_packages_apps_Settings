package com.android.settings.aetheria.statusbar;

import android.app.settings.SettingsEnums;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;

import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.Indexable.SearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class StatusbarSettings extends DashboardFragment {

    private static final String TAG = "StatusbarSettings";

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
        return R.xml.aetheria_statusbar_settings;
    }

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.aetheria_statusbar_settings);
}
