package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.*;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.SpriteFilter;

import net.thevpc.gaming.atom.engine.maintasks.MoveToPointSpriteMainTask;

import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.*;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.Layers;

import java.awt.*;

/**
 * Created by vpc on 9/23/16.
 */
@AtomScene(
        id = "hello",
        title = "Hello World",
        tileWidth = 100,
        tileHeight = 100
        
)
@AtomSceneEngine(
        id="hello",
        columns = 10,
        rows = 10,
        fps = 15
)
public class HelloWorldScene {

    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;

    @OnSceneStarted
    private void init() {
       // scene.addLayer(Layers.fillScreen(Color.black));
        scene.addLayer(Layers.debug());
//        scene.addLayer(Layers.fillScreen(Color.red));
        scene.addController(new SpriteController(SpriteFilter.byName("Ball1")).setArrowKeysLayout());
        scene.addController(new SpriteController(SpriteFilter.byName("Ball2")).setESDFLayout());
        scene.addLayer(Layers.fillScreenImage("/imageNft.jpg"));

        scene.addController(new Target()); //controle by mousse

/*         scene.setSpriteView(SpriteFilter.byName("Ball2"),new DefaultSpriteView() {
           @Override
            public void draw(SpriteDrawingContext context) {
                context.getGraphics().setPaint(Color.MAGENTA);
                context.getGraphics().fill(context.getSpriteShape());
            }
        });*/


        scene.addController(new AdjustViewController());
        scene.addComponent(
                new SLabel("Click CTRL-D to switch debug mode, use Arrows to move the ball")
                        .setLocation(Point.ratio(0.5f, 0.5f))
        );
        //scene.addLayer(Layers.fillBoardGradient(Color.GRAY,Color.CYAN, Orientation.NORTH));
        //scene.addComponent(new SLabel("Vies:3"));

//        scene.setSpriteView("Ball1", new DefaultSpriteView() {
//            @Override
//            public void draw(SpriteDrawingContext context) {
//                ViewBox sb = context.getSpriteBounds();
//                context.getGraphics().setPaint(Color.BLUE);
//                context.getGraphics().fillRect(
//                        sb.getX(),sb.getY(),
//                        sb.getWidth(),
//                        sb.getHeight()
//                );
//            }
//        });
//        scene.setSpriteView("Ball2", new DefaultSpriteView() {
//            @Override
//            public void draw(SpriteDrawingContext context) {
//                ViewBox sb = context.getSpriteBounds();
//                context.getGraphics().setPaint(Color.RED);
//                context.getGraphics().fillRect(
//                        sb.getX(),sb.getY(),
//                        sb.getWidth(),
//                        sb.getHeight()
//                );
//            }
//        });
        //scene.setSpriteView(SpriteFilter.byKind("Ball"), new ImageSpriteView("/ball.png", 8, 4));
        scene.setSpriteView(SpriteFilter.byName("Ball1"), new ImageSpriteView("/ball.png", 8, 4));
        scene.setSpriteView(SpriteFilter.byName("Ball2"), new ImageSpriteView("/sprite.png", 6, 4));
        scene.setSpriteView(SpriteFilter.byName("Rocket"), new ImageSpriteView("/rocket.png", 5, 4));

        scene.addComponent(new SLabel("vie=Ball1"+sceneEngine.findSpriteByName("Ball1").getLife()+"\r\n"+"vie=Ball2"+sceneEngine.findSpriteByName("Ball2").getLife()));



    }

    @OnNextFrame
    public int aChaqueTic(){
        Sprite a=sceneEngine.findSpriteByName("Ball2");
        return (a.getLife());
    }


}
class Target implements SceneController{
    @Override
    public void mouseClicked(SceneMouseEvent e){
        Sprite sprite=e.getSceneEngine().findSpriteByName("Ball2");
        e.getSceneEngine().setSpriteMainTask(sprite, new MoveToPointSpriteMainTask(e.getPoint()));
    }
}

