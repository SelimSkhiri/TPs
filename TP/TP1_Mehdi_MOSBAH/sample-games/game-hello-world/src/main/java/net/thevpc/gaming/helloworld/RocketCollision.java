package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollision;
import net.thevpc.gaming.atom.model.DirectionTransform;

import net.thevpc.gaming.atom.engine.collisiontasks.DefaultSpriteCollisionTask;

public class RocketCollision extends DefaultSpriteCollisionTask {
    @Override
    public void collideWithBorder(BorderCollision borderCollision) {
        borderCollision.adjustSpritePosition();
        borderCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }
    @Override
    public void collideWithSprite(SpriteCollision spriteCollision) {
        System.out.println(spriteCollision.getOther().getLife());

        spriteCollision.adjustSpritePosition();
        spriteCollision.getOther().setLife(spriteCollision.getOther().getLife()-1);
        spriteCollision.getSprite().die();
        System.out.println(spriteCollision.getOther().getLife());
    }
}
