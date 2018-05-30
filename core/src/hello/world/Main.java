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
	Texture img2;
    Sprite sprMstanding;
    Sprite sprsprGoomba;
    int i;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img1 = new Texture("MStanding.png");
        img2 = new Texture("sprGoomba_edited-1.png");
       sprMstanding= new Sprite (img1);
		sprGoomba= new Sprite (img2);

        sprMstanding.setPosition(Gdx.graphics.getWidth()/2-sprMstanding.getWidth()/2, Gdx.graphics.getHeight()/2-sprMstanding.getHeight()/2);
        sprMstanding.setScale(1f);
        sprsprGoomba.setPosition(Gdx.graphics.getWidth()/2-sprMstanding.getWidth()/2,-100);
        sprsprGoomba.setScale(0.5f);
	}

	@Override
	public void render () {
	    //Mario keyboard control (left & right)
	   if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
           sprMstanding.translateX(-1f);
	   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
           sprMstanding.translateX(1f);

        //sprGoomba sliding across
            sprsprGoomba.translateX(-1f);


	   //background
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//draw Mario
		batch.draw(Mstanding,sprMstanding.getX(),sprMstanding.getY(),sprMstanding.getWidth()/2,Mstanding.getHeight()/2,
               sprMstanding.getWidth(),sprMstanding.getHeight(),Mstanding.getScaleX(),sprMstanding.getScaleY(),sprMstanding.getRotation());
		//draw sprGoomba
        batch.draw(sprGoomba, sprGoomba.getX(), sprGoomba.getY(), sprGoomba.getWidth()/2,sprGoomba.getHeight()/2,
                sprGoomba.getWidth(), sprGoomba.getHeight(),sprGoomba.getScaleX(), sprGoomba.getScaleY(), sprGoomba.getRotation());
		batch.end();
	}


	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
	}
}
