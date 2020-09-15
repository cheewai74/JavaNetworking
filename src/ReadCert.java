import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CRL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class ReadCert {
	
	public static final String CRL_DISTRIBUTION_POINT_OID = "2.5.29.31";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = null;
		try {
			
			
			// Instantiate an X.509 certificate factory
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			
			// Read the certificate
			in = new BufferedInputStream(new FileInputStream(args[0]));
			X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
			
			// Print the information
			System.out.println("Subject: "+cert.getSubjectDN().getName());
			System.out.println("Validity: "+cert.getNotBefore() +" - " 
									+cert.getNotAfter());
			System.out.println("Issuer: "+cert.getIssuerDN().getName());
			System.out.println("Signature Algorithm: "+cert.getSigAlgName());
			
			// Print the CRL Distribution Point If there is One.
			byte[] crlDP = cert.getExtensionValue(CRL_DISTRIBUTION_POINT_OID);
			URL crlUrl = extractURL(crlDP);
			if(crlDP != null) {
				System.out.println("CRL Distributiob Point: "+ crlUrl);
				CRL crl = cf.generateCRL(crlUrl.openStream());
				System.out.println("Certificate revoked: "+crl.isRevoked(cert));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(in != null) {
				try {
					in.close();
				}
				catch(Exception e) {
					// Do Nothing
				}
			}
		}
		
	}
	
	public static URL extractURL(byte[] bytes) throws MalformedURLException{
	
		String s = new String(bytes);
		int urlOffset = s.lastIndexOf("http");
		return (urlOffset >=0 )? new URL(s.substring(urlOffset)):null;
	}
	

}
