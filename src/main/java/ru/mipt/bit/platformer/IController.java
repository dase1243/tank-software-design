package ru.mipt.bit.platformer;

public interface IController {
    void handleInput();
    void update(float deltaTime);
}