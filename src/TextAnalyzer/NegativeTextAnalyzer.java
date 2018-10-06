package TextAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer{
    private String [] keywords;

    public NegativeTextAnalyzer(){
        this.keywords = new String []{":(", "=(", ":|"};
    }

    public String [] getKeywords(){
        return this.keywords;
    }

    public Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
}
