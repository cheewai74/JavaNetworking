

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GradingService extends UnicastRemoteObject implements SchoolGrades{
	
	static int subjectGrades[];
	
	static {
		subjectGrades = new int[3];
		subjectGrades[0] = 10;
		subjectGrades[1] = 1;
		subjectGrades[2] = 3;
	}
	
	protected GradingService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GradingService gService = new GradingService();
			Naming.rebind("/GradingService", gService);
			System.out.println("GradingService bound in registry");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public int getAverageGrade() throws RemoteException {
		
		System.out.println("GradingService: computing average grade");
		int numOfSubjects = subjectGrades.length;
		int sumOfAllSubjects = 0;
		for(int i =0; i< numOfSubjects; i++) {
			sumOfAllSubjects += subjectGrades[i];
		}
		// TODO Auto-generated method stub
		return (sumOfAllSubjects / numOfSubjects);
	}

}
