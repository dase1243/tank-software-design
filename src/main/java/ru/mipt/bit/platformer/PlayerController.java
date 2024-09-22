package ru.mipt.bit.platformer;

public class PlayerController implements IController {
    private Player player;
    private MapRendering mapRendering;
    private InputHandler inputHandler;

    public PlayerController(Player player, MapRendering mapRendering, InputHandler inputHandler) {
        this.player = player;
        this.mapRendering = mapRendering;
        this.inputHandler = inputHandler;
    }

    public void handleInput() {
        if (inputHandler.isUpPressed()) {
            player.moveUp(mapRendering);
        }
        if (inputHandler.isLeftPressed()) {
            player.moveLeft(mapRendering);
        }
        if (inputHandler.isDownPressed()) {
            player.moveDown(mapRendering);
        }
        if (inputHandler.isRightPressed()) {
            player.moveRight(mapRendering);
        }
    }

    public void update(float deltaTime) {
        player.applyMovementPerDeltaTime(deltaTime);
    }
}
