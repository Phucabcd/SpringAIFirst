package ntp.springaifirst.builder;

import ntp.springaifirst.enums.SystemModel;
import ntp.springaifirst.enums.ToneStyle;

public class PromptBuiler {

    public static String builderPrompt(SystemModel systemModel, ToneStyle toneStyle){
       StringBuilder sb = new StringBuilder();
       sb.append(systemModel.getValue());
       sb.append(toneStyle.getValue());
       return sb.toString();
    }
}
