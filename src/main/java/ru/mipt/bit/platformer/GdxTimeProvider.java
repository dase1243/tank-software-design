package ru.mipt.bit.platformer;

import com.badlogic.gdx.Gdx;

public class GdxTimeProvider implements TimeProvider {
    @Override
    public float getDeltaTime() {
        return Gdx.graphics.getDeltaTime();
    }
}