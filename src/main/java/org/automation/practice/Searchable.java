package org.automation.practice;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexanderzaverukha on 2/4/17.
 */
public interface Searchable {
    void search(String search);

    void search(String search, String option);
}
