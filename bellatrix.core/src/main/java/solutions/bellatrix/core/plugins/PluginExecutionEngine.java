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

package solutions.bellatrix.core.plugins;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class PluginExecutionEngine {
    private final static Set<Plugin> plugins;

    static {
        plugins = new HashSet<>();
    }

    public static void addPlugin(Plugin plugin) {
        plugins.add(plugin);
    }

    public static void removePlugin(Plugin plugin) {
        plugins.remove(plugin);
    }

    @SuppressWarnings("rawtypes")
    public static void preBeforeClass(Class type) {
        for (var currentObserver: plugins) {
            currentObserver.preBeforeClass(type);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void postBeforeClass(Class type) {
        for (var currentObserver: plugins) {
            currentObserver.postBeforeClass(type);
        }
    }

    public static void beforeClassFailed(Exception e) {
        for (var currentObserver: plugins) {
            currentObserver.beforeClassFailed(e);
        }
    }

    public static void preBeforeTest(TestResult result, Method memberInfo) {
        for (var currentObserver: plugins) {
            currentObserver.preBeforeTest(result, memberInfo);
        }
    }

    public static void postBeforeTest(TestResult result, Method memberInfo) {
        for (var currentObserver: plugins) {
            currentObserver.postBeforeTest(result, memberInfo);
        }
    }

    public static void beforeTestFailed(Exception e) {
        for (var currentObserver: plugins) {
            currentObserver.beforeTestFailed(e);
        }
    }

    public static void preAfterTest(TestResult result, Method memberInfo) {
        for (var currentObserver: plugins) {
            currentObserver.preAfterTest(result, memberInfo);
        }
    }

    public static void postAfterTest(TestResult result, Method memberInfo) {
        for (var currentObserver: plugins) {
            currentObserver.postAfterTest(result, memberInfo);
        }
    }

    public static void afterTestFailed(Exception e) {
        for (var currentObserver: plugins) {
            currentObserver.afterTestFailed(e);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void preAfterClass(Class type) {
        for (var currentObserver: plugins) {
            currentObserver.preAfterClass(type);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void postAfterClass(Class type) {
        for (var currentObserver: plugins) {
            currentObserver.postAfterClass(type);
        }
    }

    public static void afterClassFailed(Exception e) {
        for (var currentObserver: plugins) {
            currentObserver.afterClassFailed(e);
        }
    }

//    public static void testInstantiated(Method memberInfo) {
//        for (var currentObserver: plugins) {
//            currentObserver.testInstantiated(memberInfo);
//        }
//    }
}
