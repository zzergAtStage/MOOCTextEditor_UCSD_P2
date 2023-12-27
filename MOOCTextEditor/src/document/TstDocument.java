package document;

public class TstDocument extends Document {

	protected TstDocument(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getNumWords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumSentences() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumSyllables() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TstDocument doc = new TstDocument("123.334.5999.579");
		System.out.println("Doc: " + doc.getTokens("123|334|5999|579"));
	}

}
