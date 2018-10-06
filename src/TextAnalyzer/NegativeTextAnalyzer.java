package TextAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer{

    public NegativeTextAnalyzer(){
        this.keywords = new String []{":(", "=(", ":|"};
    }

    public String [] getKeywords(){
        return this.keywords;
    }

    public Label getLabel(String text, String [] keywords){
        text = text.toLowerCase();
        for(int i =0; i < keywords.length; i++)
        {
            if(text.contains(keywords[i]))
            {
                return Label.NEGATIVE_TEXT;
            }
        }
        return Label.OK;
    }

}
