package TextAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer{

    public SpamAnalyzer(String [] keywords){
        for (int i=0; i<keywords.length; i++)
            keywords[i] = keywords[i].toLowerCase();
        this.keywords = keywords;
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
                return Label.SPAM;
            }
        }
        return Label.OK;
    }

}
