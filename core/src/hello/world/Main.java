package hello.world;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Sprite spr2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Gomba1.png");
		spr2= new Sprite (img);
		spr2.setPosition(Gdx.graphics.getWidth()/2-spr1.getWidth()/2, Gdx.graphics.getHeight()/2-spr1.getHeight()/2);
		spr2.setRotation(0f);
		spr2.setScale(1f);
	}

	@Override
	public void render () {
	   if(spr2.input.isKeyPressed(Input.Keys.LEFT))
	   	sprite.translateX(-1f);
	   if(spr2.input.isKeyPressed(Input.Keys.RIGHT))
	   sprite.translateX(1f);


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
		img.dispose();
	}
}
