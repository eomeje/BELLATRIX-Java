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

package solutions.bellatrix.infrastructure;

import lombok.SneakyThrows;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import plugins.screenshots.ScreenshotsPlugin;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import solutions.bellatrix.configuration.ConfigurationService;
import solutions.bellatrix.configuration.WebSettings;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Paths;
import java.util.UUID;

public class WebScreenshotsPlugin extends ScreenshotsPlugin {
    public WebScreenshotsPlugin(Boolean isEnabled) {
        super(isEnabled);
    }

    public static WebScreenshotsPlugin of() {
        Boolean isEnabled = ConfigurationService.get(WebSettings.class).getScreenshotsOnFailEnabled();
        return new WebScreenshotsPlugin(isEnabled);
    }

    @Override
    @SneakyThrows
    protected void takeScreenshot( String screenshotSaveDir, String filename) {
        var screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(DriverService.getWrappedDriver());
        var destFile = new File(Paths.get(screenshotSaveDir, filename).toString());
        ImageIO.write(screenshot.getImage(), "png", destFile);
    }

    @Override
    protected String getOutputFolder() {
        String saveLocation = ConfigurationService.get(WebSettings.class).getScreenshotsSaveLocation();
        if (saveLocation.startsWith("user.home")) {
            var userHomeDir = System.getProperty("user.home");
            saveLocation = saveLocation.replace("user.home", userHomeDir);
        }

        var directory = new File(saveLocation);
        if (! directory.exists()){
            directory.mkdirs();
        }

        return saveLocation;
    }

    @Override
    protected String getUniqueFileName(String testName) {
        return testName.concat(UUID.randomUUID().toString()).concat(".png");
    }
}
