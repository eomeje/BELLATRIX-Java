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

package solutions.bellatrix.desktop.findstrategies;

import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

import java.util.List;

public abstract class FindStrategy {
    private final String value;

    protected FindStrategy(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public abstract WindowsElement findElement(WindowsDriver<WindowsElement> driver);

    public abstract List<WindowsElement> findAllElements(WindowsDriver<WindowsElement> driver);

    public abstract MobileElement findElement(WindowsElement element);

    public abstract List<MobileElement> findAllElements(WindowsElement element);
}
