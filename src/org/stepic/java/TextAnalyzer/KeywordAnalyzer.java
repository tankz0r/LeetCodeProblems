package org.stepic.java.TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{

    protected abstract String [] getKeywords();
    protected abstract Label getLabel();

    public Label processText(String text){
        text = text.toLowerCase();
        String [] keywords = getKeywords();
        for(int i=0; i < keywords.length; i++)
        {
            if(text.contains(keywords[i]))
            {
                return getLabel();
            }
        }
        return Label.OK;
    }
}


