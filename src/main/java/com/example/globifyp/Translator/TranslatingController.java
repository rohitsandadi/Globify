package com.example.globifyp.Translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatingController {

    @Autowired
    Translating mytranslating;

    @PostMapping("/translator/translating")
    public String translateInput1(@RequestParam(value = "text", defaultValue = "No text found") String text, @RequestParam(value = "language", defaultValue = "en-US") String language) throws Exception{
        String result = mytranslating.textTranslator(text, language);
        /*try{
            result = mytranslating.textTranslator(text, language);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        //System.out.println(result);
        return result;
    }
    @GetMapping("/translator/translating")
    public String translateInput2(@RequestParam(value = "text", defaultValue = "No text found") String text, @RequestParam(value = "language", defaultValue = "en-US") String language) throws Exception{
        String result = mytranslating.textTranslator(text, language);
        /*try{
            result = mytranslating.textTranslator(text, language);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        //System.out.println(result);
        return result;
    }
}
