package is.ru.Mylla;

import static spark.Spark.*;
import spark.*;

public class Mylla {

	public static void main(String[] args) {
		final GameLogic gameLogic = new GameLogic();

		staticFileLocation("/public");

		setPort(Integer.valueOf(System.getenv("PORT")));

		post(new Route("/processTurn") {
			@Override
			public Object handle(Request request, Response response) {
				int temp = Integer.valueOf(request.queryParams("ClickedBox"));
				
				return gameLogic.processTurn(temp) + " " + temp;
			}
		});
		
		post(new Route("/resetGame") {
			@Override
			public Object handle(Request request, Response response) {
				gameLogic.reset_game();
				
				return 0;
			}
		});
	}
}