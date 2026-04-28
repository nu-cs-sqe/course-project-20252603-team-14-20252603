package ui;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {

    private final Map<String, Image> images = new HashMap<>();
    private final Map<String, String> svgPaths = new HashMap<>();

    private String cssUrl;

    public void addImage(String key, String imageUrl) {
        Image image = new Image(imageUrl);
        images.put(key, image);
    }

    public Image getImage(String key) {
        return images.get(key);
    }

    public void addSvg(String key, String pathData) {
        svgPaths.put(key, pathData);
    }

    public String getSvg(String key) {
        return svgPaths.get(key);
    }

    public void setStylesheet(String url) {
        this.cssUrl = url;
    }

    public String getStylesheet() {
        return cssUrl;
    }

}
