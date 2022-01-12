package com.company.gui;

import java.util.List;

public class MainWindowActions {
    public static void handleRunJobs(List<String> instancePathList, List<String> algorithmList) {
        Presenter.runJobs(instancePathList, algorithmList);
    }
}
