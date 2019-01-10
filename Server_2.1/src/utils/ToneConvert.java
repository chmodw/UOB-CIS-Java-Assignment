package utils;

import com.google.gson.Gson;

import application.DocumentTone;

/**
 * contains functions to convert JSON File to a java object
 * @author Chamodya Wimansha
 *
 */
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