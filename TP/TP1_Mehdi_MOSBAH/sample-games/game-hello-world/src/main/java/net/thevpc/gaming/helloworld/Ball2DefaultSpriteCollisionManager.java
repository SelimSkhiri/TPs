package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollision;
import net.thevpc.gaming.atom.model.DirectionTransform;
import net.thevpc.gaming.atom.engine.collisiontasks.DefaultSpriteCollisionTask;

public class Ball2DefaultSpriteCollisionManager extends DefaultSpriteCollisionTask {

    @Override
    public void collideWithBorder(BorderCollision borderCollision) {
        borderCollision.adjustSpritePosition();
        borderCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }


    @Override
    public void collideWithSprite(SpriteCollision spriteCollision) {
        spriteCollision.adjustSpritePosition();
        spriteCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }

}
