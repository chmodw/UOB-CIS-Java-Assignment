package utils;

import com.google.gson.Gson;

import application.DocumentTone;

public class  ToneConvert{

	private DocumentTone docTone;
	
    public ToneConvert(String text){

        // Now do the magic.
        docTone = new Gson().fromJson(text, DocumentTone.class);

    }
    
    public DocumentTone getDocTone() {
    	return docTone;
    }

}