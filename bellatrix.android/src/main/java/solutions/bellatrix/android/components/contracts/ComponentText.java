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

package solutions.bellatrix.android.components.contracts;

import lombok.SneakyThrows;
import solutions.bellatrix.android.components.AndroidComponent;
import solutions.bellatrix.android.validations.ComponentValidator;
import solutions.bellatrix.core.utilities.SingletonFactory;

import java.lang.reflect.Method;

public interface ComponentText extends Component {
    String getText();

    @SneakyThrows
    default void validateTextIs(String value) {
        Method method = ComponentValidator.class.getDeclaredMethod("defaultValidateAttributeIs", AndroidComponent.class, String.class, String.class, String.class);
        method.invoke(SingletonFactory.getInstance(ComponentValidator.class), (AndroidComponent)this, getText(), value, "inner text");
    }

    @SneakyThrows
    default void validateTextContains(String value) {
        Method method = ComponentValidator.class.getDeclaredMethod("defaultValidateAttributeContains", AndroidComponent.class, String.class, String.class, String.class);
        method.invoke(SingletonFactory.getInstance(ComponentValidator.class), (AndroidComponent)this, getText(), value, "inner text");
    }

    @SneakyThrows
    default void validateTextNotContains(String value) {
        Method method = ComponentValidator.class.getDeclaredMethod("defaultValidateAttributeNotContains", AndroidComponent.class, String.class, String.class, String.class);
        method.invoke(SingletonFactory.getInstance(ComponentValidator.class), (AndroidComponent)this, getText(), value, "inner text");
    }
}
