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
        view.bindAddPlayerButton(() -> {});

        view.bindConfirmButton(this::startGame);

        view.bindResetButton(() -> sceneManager.showStartView());
    }

    private void startGame(List<String> names) {

    }
}
