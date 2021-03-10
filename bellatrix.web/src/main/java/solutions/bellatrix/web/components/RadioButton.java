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

package solutions.bellatrix.web.components;

import solutions.bellatrix.core.plugins.EventListener;
import solutions.bellatrix.web.components.contracts.ComponentChecked;
import solutions.bellatrix.web.components.contracts.ComponentDisabled;
import solutions.bellatrix.web.components.contracts.ComponentValue;

public class RadioButton extends WebComponent implements ComponentDisabled, ComponentValue, ComponentChecked {
    public final static EventListener<ComponentActionEventArgs> CLICKING = new EventListener<>();
    public final static EventListener<ComponentActionEventArgs> CLICKED = new EventListener<>();

    public void click() {
        defaultClick(CLICKING, CLICKED);
    }

    @Override
    public Class<?> getComponentClass() {
        return getClass();
    }

    @Override
    public boolean isChecked() {
        return findElement().isSelected();
    }

    @Override
    public boolean isDisabled() {
        return defaultGetDisabledAttribute();
    }

    @Override
    public String getValue() {
        return defaultGetValue();
    }
}
