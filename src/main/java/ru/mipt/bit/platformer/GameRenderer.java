package ru.mipt.bit.platformer;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class GameRenderer implements IRenderer{
    private LevelTiles levelTiles;
    private Player player;
    private MapRendering mapRendering;

    public GameRenderer(LevelTiles levelTiles, Player player, MapRendering mapRendering) {
        this.levelTiles = levelTiles;
        this.player = player;
        this.mapRendering = mapRendering;
    }

    @Override
    public void render() {
        levelTiles.getLevelRenderer().render();

        levelTiles.getBatch().begin();

        drawTextureRegionUnscaled(levelTiles.getBatch(), player.getGraphics(), player.getRectangle(), player.getRotation());

        drawTextureRegionUnscaled(levelTiles.getBatch(), mapRendering.getObjectObstacleGraphics(), mapRendering.getObjectObstacleRectangle(), 0f);

        levelTiles.getBatch().end();
    }

    private void drawTextureRegionUnscaled(Batch batch, TextureRegion region, Rectangle rectangle, float rotation) {
        batch.draw(region, rectangle.x, rectangle.y, rectangle.width / 2, rectangle.height / 2, rectangle.width, rectangle.height, 1, 1, rotation);
    }
}