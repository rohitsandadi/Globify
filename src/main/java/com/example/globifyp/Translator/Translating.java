package com.example.globifyp.Translator;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Translating {
    Translator translator;

    public String textTranslator(String text, String language) throws Exception{
        String authKey = "a0b100b7-3f66-5380-728a-aab9ad705bf1:fx";
        translator = new Translator(authKey);
        TextResult translatedText = translator.translateText(text, null, language);
        return translatedText.getText();
    }

}
