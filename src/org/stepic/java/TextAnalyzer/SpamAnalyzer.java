package org.stepic.java.TextAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer{
    private String [] keywords;

    public SpamAnalyzer(String [] keywords){
        for (int i=0; i<keywords.length; i++)
            keywords[i] = keywords[i].toLowerCase();
        this.keywords = keywords;
    }

    public String [] getKeywords(){
        return this.keywords;
    }

    public Label getLabel(){
        return Label.SPAM;
    }
}
