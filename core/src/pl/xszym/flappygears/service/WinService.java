package pl.xszym.flappygears.service;

public class WinService {

	private int scoreSticker = 3;
	private int scoreBracelet = 5;
	private int scorePen = 10;
	private int scoreTshirt = 25;
	private String winThink;
	
	public WinService() {

	}

	public boolean chackWin(int score) {
		if (score > scoreSticker) {
			
			winThink = "Sticker";
			
			if (score >= scoreBracelet){
				
				winThink = "Bracelet";
				
				if (score >= scorePen){
					
					winThink = "Pen";
					
					if (score >= scoreTshirt){
						winThink = "T-Shirt";
						
						
					}
				}
			}
			
			return true;
		} else {
			return false;
		}

	}

	public int getScoreSticker() {
		return scoreSticker;
	}

	public void setScoreSticker(int scoreSticker) {
		this.scoreSticker = scoreSticker;
	}

	public int getScoreBracelet() {
		return scoreBracelet;
	}

	public void setScoreBracelet(int scoreBracelet) {
		this.scoreBracelet = scoreBracelet;
	}

	public int getScorePen() {
		return scorePen;
	}

	public void setScorePen(int scorePen) {
		this.scorePen = scorePen;
	}

	public int getScoreTshirt() {
		return scoreTshirt;
	}

	public void setScoreTshirt(int scoreTshirt) {
		this.scoreTshirt = scoreTshirt;
	}

	public String getWinThink() {
		// TODO Auto-generated method stub
		return winThink;
	}

}
