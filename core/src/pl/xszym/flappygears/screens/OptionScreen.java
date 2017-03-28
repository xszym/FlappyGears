package pl.xszym.flappygears.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.service.WinService;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyNumberInputListener;
import pl.xszym.flappygears.ui.MyTextButton;

public class OptionScreen extends AbstractScreen {

	MyNumberInputListener myNumberInputListener;
	WinService winService;

	private int buttonsX = FlappeGears.WIDTH - 200;
	
	
	public OptionScreen(FlappeGears game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		
		winService = new WinService();
		stage.addActor(FlappeGears.bg);
		
		initMenuButton();
		initButtonSticker();
		initButtonBracelet();
		initButtonPen();
		initButtonTshirt();
		
	}
	
	@Override
	public void render(float delta) {

		super.render(delta);

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	
	private void initMenuButton() {

		MyTextButton menuButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new MenuScreen(game));
			}
		}, "Menu", FlappeGears.WIDTH - 280, FlappeGears.HEIGHT - 150);
		stage.addActor(menuButton);

	}
	
	private void initButtonSticker() {
		
		MyTextButton stickerButton = new MyTextButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				
				myNumberInputListener = new MyNumberInputListener();
				
				Gdx.input.getTextInput(new TextInputListener() {
					
					@Override
					public void input(String text) {
						
						winService.setScoreSticker(Integer.parseInt(text));
						
					}
					
					@Override
					public void canceled() {
						// TODO Auto-generated method stub
						
					}
					
					
				}, "Sticker", String.valueOf(winService.getScoreSticker()), "");
				
			}
		}, "Sticker", buttonsX , FlappeGears.HEIGHT - 300);
		stage.addActor(stickerButton);
	}
	private void initButtonBracelet() {
		
		MyTextButton braceletButton = new MyTextButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				
				myNumberInputListener = new MyNumberInputListener();
				
				Gdx.input.getTextInput(new TextInputListener() {
					
					@Override
					public void input(String text) {
						
						winService.setScoreBracelet(Integer.parseInt(text));
						
					}
					
					@Override
					public void canceled() {
						// TODO Auto-generated method stub
						
					}
					
					
				}, "Bracelet", String.valueOf(winService.getScoreBracelet()), "");
				
			}
		}, "Bracelet", buttonsX , FlappeGears.HEIGHT - 400);
		stage.addActor(braceletButton);
	}

	
	

	private void initButtonPen() {
	
			MyTextButton penButton = new MyTextButton(new IClickCallback() {

				@Override
				public void onClick() {

					myNumberInputListener = new MyNumberInputListener();

					Gdx.input.getTextInput(new TextInputListener() {

						@Override
						public void input(String text) {
							
							winService.setScorePen(Integer.parseInt(text));

						}

						@Override
						public void canceled() {
							// TODO Auto-generated method stub
							
						}

						
					}, "Pen", String.valueOf(winService.getScorePen()), "");

				}
			}, "Pen", buttonsX, FlappeGears.HEIGHT - 500 );
			stage.addActor(penButton);
	}
	
	private void initButtonTshirt() {
		
		MyTextButton tShirstButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {

				myNumberInputListener = new MyNumberInputListener();

				Gdx.input.getTextInput(new TextInputListener() {

					@Override
					public void input(String text) {
						
						winService.setScoreTshirt(Integer.parseInt(text));

					}

					@Override
					public void canceled() {
						// TODO Auto-generated method stub
						
					}

					
				}, "TShirst", String.valueOf(winService.getScoreTshirt()), "");

			}
		}, "Tshirst", buttonsX, FlappeGears.HEIGHT - 600 );
		stage.addActor(tShirstButton);
}

	


}
