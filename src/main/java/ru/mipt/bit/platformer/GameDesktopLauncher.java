package ru.mipt.bit.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class GameDesktopLauncher extends GameLauncher {
    private LevelTiles levelTiles;
    private Player player;
    private MapRendering mapRendering;
    private PlayerController playerController;
    private GameRenderer gameRenderer;
    private InputHandler inputHandler;
    private TimeProvider timeProvider;

    @Override
    public void create() {
        levelTiles = new LevelTiles(GameConfig.mapFileName);
        player = new Player(GameConfig.textureFileName);
        mapRendering = new MapRendering(GameConfig.objectTextureFileName);

        inputHandler = new GdxInputHandler();
        timeProvider = new GdxTimeProvider();

        playerController = new PlayerController(player, mapRendering, inputHandler);
        gameRenderer = new GameRenderer(levelTiles, player, mapRendering);

        moveRectangleAtTileCenter(
                levelTiles.getGroundLayer(),
                mapRendering.getObjectObstacleRectangle(),
                mapRendering.getObjectObstacleCoordinates()
        );
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float deltaTime = timeProvider.getDeltaTime();

        playerController.handleInput();
        playerController.update(deltaTime);

        levelTiles.getTileMovement().moveRectangleBetweenTileCenters(player);

        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        // do not react to window resizing
    }

    @Override
    public void pause() {
        // game doesn't get paused
    }

    @Override
    public void resume() {
        // game doesn't get paused
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (classes which implement com.badlogic.gdx.utils.Disposable)
        mapRendering.getObjectTexture().dispose();
        player.getTexture().dispose();
        levelTiles.getLevel().dispose();
        levelTiles.getBatch().dispose();
    }
}
