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
    Sprite Mstanding;
    Sprite Goomba;
    int i;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img1 = new Texture("MStanding.png");
        img2 = new Texture("Goomba_edited-1.png");
        Mstanding= new Sprite (img1);
		Goomba= new Sprite (img2);

        Mstanding.setPosition(Gdx.graphics.getWidth()/2-Mstanding.getWidth()/2, Gdx.graphics.getHeight()/2-Mstanding.getHeight()/2);
        Mstanding.setScale(1f);
        Goomba.setPosition(Gdx.graphics.getWidth()/2-Mstanding.getWidth()/2,-100);
        Goomba.setScale(0.5f);
	}

	@Override
	public void render () {
	    //Mario keyboard control (left & right)
	   if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
           Mstanding.translateX(-1f);
	   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
           Mstanding.translateX(1f);

        //Goomba sliding across
            Goomba.translateX(-1f);


	   //background
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//draw Mario
		batch.draw(Mstanding, Mstanding.getX(), Mstanding.getY(), Mstanding.getWidth()/2,Mstanding.getHeight()/2,
                Mstanding.getWidth(), Mstanding.getHeight(),Mstanding.getScaleX(), Mstanding.getScaleY(), Mstanding.getRotation());
		//draw Goomba
        batch.draw(Goomba, Goomba.getX(), Goomba.getY(), Goomba.getWidth()/2,Goomba.getHeight()/2,
                Goomba.getWidth(), Goomba.getHeight(),Goomba.getScaleX(), Goomba.getScaleY(), Goomba.getRotation());
		batch.end();
	}


	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
	}
}
