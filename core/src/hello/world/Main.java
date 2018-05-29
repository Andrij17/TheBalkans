package hello.world;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img1;
    Sprite spr1;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img1 = new Texture("Mstanding.png");
		spr1= new Sprite (img1);
		spr1.setPosition(Gdx.graphics.getWidth()/2-spr1.getWidth()/2, Gdx.graphics.getHeight()/2-spr1.getHeight()/2);
		spr1.setRotation(0f);
		spr1.setScale(1f);
	}

	@Override
	public void render () {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            spr1.translateX(-2f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            spr1.translateX(2f);
        }
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(spr1, spr1.getX(), spr1.getY(), spr1.getWidth()/2,spr1.getHeight()/2, spr1.getWidth(), spr1.getHeight(),
                spr1.getScaleX(), spr1.getScaleY(), spr1.getRotation());
		batch.end();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
	}
}
