package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.annotations.AtomScene;
import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnSceneStarted;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.presentation.KeyCode;
import net.thevpc.gaming.atom.presentation.Scene;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.Layers;

@AtomScene(
        id = "welcome",
        title = "Welcome",
        tileWidth = 100,
        tileHeight = 100

)
@AtomSceneEngine(
        id="welcome",
        columns = 10,
        rows = 10,
        fps = 8
)

public class Welcome {
    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;

    @OnSceneStarted
    private void init() {

        scene.addLayer(Layers.fillScreenImage("/welcome.jpeg"));

        scene.addComponent(new SLabel("Welcome ")/*.setSize(new RatioDimension(0.3f,0.2f))*/
                .setLocation(Point.ratio(0.4f,0.5f)));

        scene.addComponent(new SLabel("Press space to start")/*.setSize(new RatioDimension(0.3f,0.2f))*/
                .setLocation(Point.ratio(0.7f,0.6f)));

        scene.addController(new DefaultSceneController(){
            @Override
            public void keyPressed(SceneKeyEvent e){
                if (e.getKeyCode() == KeyCode.SPACE) {sceneEngine.getGameEngine().setActiveSceneEngine("hello");}
            }});
    }
}
