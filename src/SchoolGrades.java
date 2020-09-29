import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SchoolGrades extends Remote {
	int getAverageGrade() throws RemoteException;

}
