package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.AtomSprite;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnInit;
import net.thevpc.gaming.atom.engine.collisiontasks.BounceSpriteCollisionTask;
import net.thevpc.gaming.atom.engine.maintasks.MoveSpriteMainTask;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.ImageSpriteView;
import net.thevpc.gaming.atom.presentation.Scene;




@AtomSprite(
        name ="Ball2",
        kind="Square",
        sceneEngine ="hello",
        x =0,
        y=0,
       // height = 1,
        //width = 2,

        direction =Math.PI/2,
        speed = 0.4,

        mainTask = MoveSpriteMainTask.class,
       // collisionTask = BounceSpriteCollisionTask.class
        collisionTask = Ball2DefaultSpriteCollisionManager.class
)

public class Ball2 {
    @Inject
    Sprite sprite2;
    @Inject
    Scene scene;

    @OnInit
    private void init(){
        sprite2.setLife(4);

    }
}

