import java.rmi.Naming;

public class RemoteGetGrades {

	static SchoolGrades gServer = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			gServer=(SchoolGrades) Naming.lookup("//localhost/GradingService");
			System.out.println("Average grade is " +gServer.getAverageGrade() + " out of 10");
		}
		catch(Exception e) {
			System.out.println("RemoteGetGrades exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
