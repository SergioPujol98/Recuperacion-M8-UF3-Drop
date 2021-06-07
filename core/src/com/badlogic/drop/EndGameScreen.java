package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class EndGameScreen implements Screen {
    final Drop game;

    private TextureRegion region;
    Texture background;
    OrthographicCamera camera;
    int contador;

    public EndGameScreen(Drop game, int dropsGathered) {
        this.game = game;
        this.contador = dropsGathered;


        background = new Texture(Gdx.files.internal("gameover.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.batch.end();

        game.batch.begin();
        game.fontDoble.draw(game.batch, "Puntos obtenidos: " + contador, 10, 100);
        game.batch.end();

        //Volver a empezar el juego
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

