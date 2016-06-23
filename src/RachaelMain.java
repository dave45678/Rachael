//import java.io.FileNotFoundException;
import java.io.IOException;

public class RachaelMain {

	public static void main(String[] args) {
		String msg = "I love my  teacher  She is nice";
		try {
			System.out.println(Sentiment.SentimentAnalysis.getSentimentScore(msg));
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
