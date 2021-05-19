/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package solutions.bellatrix.web.waitstrategies;

import solutions.bellatrix.web.components.WebComponent;

public class WaitStrategyElementsExtensions {
    public static WebComponent toExists1(WebComponent element) {
        var waitStrategy = new ToExistWaitStrategy();
        element.ensureState(waitStrategy);
        return element;
    }

    public static WebComponent toExists1(WebComponent element, int timeoutInterval, int sleepInterval) {
        var waitStrategy = new ToExistWaitStrategy(timeoutInterval, sleepInterval);
        element.ensureState(waitStrategy);
        return element;
    }

    public static <T> T or(T object, T ifNull) {
        return object != null ? object : ifNull;
    }
}
