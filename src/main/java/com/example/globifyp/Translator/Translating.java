package com.example.globifyp.Translator;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import org.springframework.stereotype.Service;

import static com.example.globifyp.Translator.authKey.AUTH_KEY;

@Service
public class Translating {
    Translator translator;

    public String textTranslator(String text, String language) throws Exception{
        translator = new Translator(AUTH_KEY);
        TextResult translatedText = translator.translateText(text, null, language);
        return translatedText.getText();
    }

}
