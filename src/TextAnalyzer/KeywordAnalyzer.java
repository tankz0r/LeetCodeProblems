package TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{
    String [] keywords;

    protected abstract String [] getKeywords();
    protected abstract Label getLabel(String text, String [] keywords);

    public Label processText(String text){
        return getLabel(text, getKeywords());
    }

}
