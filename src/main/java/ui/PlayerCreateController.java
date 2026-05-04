package ui;


import java.util.List;

public class PlayerCreateController {

    private final SceneManager sceneManager;
    private final PlayerCreateView view;

    public PlayerCreateController(AssetManager assets, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.view = new PlayerCreateView(assets);

        bindUI();
    }

    public PlayerCreateView getView() {
        return view;
    }

    private void bindUI() {

    }

    private void startGame(List<String> names) {

    }
}
