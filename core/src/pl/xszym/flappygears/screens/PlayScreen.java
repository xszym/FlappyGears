package pl.xszym.flappygears.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.entities.Ground;
import pl.xszym.flappygears.entities.Player;
import pl.xszym.flappygears.entities.Tube;
import pl.xszym.flappygears.entities.WallGear;
import pl.xszym.flappygears.ui.GameLabel;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.LeftButton;
import pl.xszym.flappygears.ui.RightButton;

public class PlayScreen extends AbstractScreen {

	private static final int TUBE_SPACING = 300;
	private static final int TUBE_COUNT = 4;
	private static final int WALLGEAR_COUNT = 20;
	public static final int PLAYER_UP = 300;

	private Image bgGame;
	private Player player;
	private RightButton rButton;
	private LeftButton lButton;
	private Ground ground;
	private GameLabel scoreLabel;

	private Array<Tube> tubes;

	private Array<WallGear> rWallGears;
	private Array<WallGear> lWallGears;

	public PlayScreen(FlappeGears game) {
		super(game);
	}

	@Override
	protected void init() {
		initBG();
		initGround();
		initTubes();
		initScoreService();
		initScoreLabel();
		initWalls();
		initPlayer();
		initButtons();

	}

	public void lose() {
		game.setScreen(new GameOverScreen(game));
		stage.dispose();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		update(delta);
		
		checkComputerKeyPressed();
		

		drawStage();
	}



	private void update(float delta) {

		player.updatePlayer(delta);

		camera.position.y = player.getY() + PLAYER_UP;

		updateButtonPosition();

		createTubes();

		updateWalls();

		updateGround();

		bgGame.setPosition(0, camera.position.y - (camera.viewportHeight / 2));

		updateScoreLabel();

		camera.update();
	}

	private void drawStage() {
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void updateGround() {
		ground.setPosition2(player);
		ground.update();

		if (ground.collides(player.getBoundsPlayer())) {
			lose();
		}
	}

	private void initGround() {
		ground = new Ground();
		stage.addActor(ground);
	}

	private void createTubes() {
		for (Tube tube : tubes) {
			if (camera.position.y - (camera.viewportHeight / 2) > tube.getY() + tube.getHeight()) {
				tube.reposition(tube.getY() + (Tube.TUBE_HEIGHT + TUBE_SPACING) * TUBE_COUNT);
				scoreService.addPoint();
				
		        scoreLabel.addAction(Actions.scaleTo(500, 100, 4));
			}

			if (tube.collides(player.getBoundsPlayer())) {
				lose();
			}
		}
	}

	private void initTubes() {
		tubes = new Array<Tube>();

		for (int i = 1; i <= TUBE_COUNT; i++) {
			tubes.add(new Tube(i * (Tube.TUBE_HEIGHT + TUBE_SPACING)));
			stage.addActor(tubes.get(i - 1));
		}
	}

	private void initBG() {
		bgGame = new Image(new Texture("bgGame.jpg"));
		stage.addActor(bgGame);
	}

	private void initPlayer() {
		player = new Player();

		stage.addActor(player);
	}

	private void initButtons() {

		
		
		rButton = new RightButton(new IClickCallback() {

			@Override
			public void onClick() {
				player.fly(-250, 350);
			}
		});

		lButton = new LeftButton(new IClickCallback() {

			@Override
			public void onClick() {
				player.fly(250, 350);
			}
		});

		stage.addActor(lButton);
		stage.addActor(rButton);
	}

	private void updateButtonPosition() {
		lButton.setY(player.getY() - PLAYER_UP);
		rButton.setY(player.getY() - PLAYER_UP);
	}

	private void initWalls() {
		rWallGears = new Array<WallGear>();
		lWallGears = new Array<WallGear>();

		for (int i = 1; i <= WALLGEAR_COUNT; i++) {
			rWallGears.add(new WallGear(0 - (WallGear.WALLGEAR_WIDHT / 2),
					i * (WallGear.WALLGEAR_HEIGHT) + (WallGear.WALLGEAR_HEIGHT / 2 - PLAYER_UP) - 100));
			stage.addActor(rWallGears.get(i - 1));
		}

		for (int i = 1; i <= WALLGEAR_COUNT; i++) {
			lWallGears.add(new WallGear(FlappeGears.WIDTH - (WallGear.WALLGEAR_WIDHT / 2),
					i * (WallGear.WALLGEAR_HEIGHT) + WallGear.WALLGEAR_HEIGHT / 2 - PLAYER_UP));
			stage.addActor(lWallGears.get(i - 1));
		}
	}

	private void updateWalls() {
		for (WallGear wallGear : rWallGears) {
			if (camera.position.y - (camera.viewportHeight / 2) > wallGear.getY() + wallGear.getHeight()) {
				wallGear.reposition(0 - (WallGear.WALLGEAR_WIDHT / 2),
						wallGear.getY() + (WallGear.WALLGEAR_HEIGHT) + FlappeGears.HEIGHT - 10);
			}
		}

		for (WallGear wallGear : lWallGears) {
			if (camera.position.y - (camera.viewportHeight / 2) > wallGear.getY() + wallGear.getHeight()) {
				wallGear.reposition(FlappeGears.WIDTH - (WallGear.WALLGEAR_WIDHT / 2),
						wallGear.getY() + (WallGear.WALLGEAR_HEIGHT) + FlappeGears.HEIGHT - 10);
			}
		}

		if (player.maxLeft || player.maxRight) {
			lose();
		}

	}

	private void updateScoreLabel() {
		scoreLabel.setPosition(FlappeGears.WIDTH - 210,
				FlappeGears.HEIGHT - 50 + camera.position.y - (camera.viewportHeight / 2));
		scoreLabel.setText("Points: " + scoreService.getPoints());
	}

	private void initScoreService() {
		
		scoreService.resetGameScore();
	}

	private void initScoreLabel() {
		scoreLabel = new GameLabel();
		stage.addActor(scoreLabel);
	}
	
	private void checkComputerKeyPressed() {
		if (Gdx.input.isKeyPressed(21)){
			player.fly(-250, 350);
		}
		if (Gdx.input.isKeyPressed(22)){
			player.fly(250, 350);
		}
	}
}
