package classes;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.classes.Question;
import rmi.interfaces.IQuestionnaire;

public class QuestionnaireClient {
	
	private IQuestionnaire remoteQuestionnaireClass;
	
	public QuestionnaireClient() {
		
		try {
			
			remoteQuestionnaireClass = (IQuestionnaire) Naming.lookup("//127.0.0.1:8080/betaservay/Questionnaire");
		
//			remoteQuestionnaireClass = (IQuestionnaire) Naming.lookup("//localhost/betaservay/Questionnaire");
			
		}catch (Exception e) {
			//Logger Class
		}
		
	}
	
	public ArrayList<Question> getQuestions(){
		
		try {
			
			return remoteQuestionnaireClass.getQuestions();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean submitQuestions(ArrayList<Question> answerdQList) throws RemoteException{
		
		return remoteQuestionnaireClass.submitAnswer(answerdQList);
			
	}

}
