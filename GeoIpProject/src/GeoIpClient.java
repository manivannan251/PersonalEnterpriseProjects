import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class GeoIpClient {

	public static void main(String[] args) {
		String ip = "";
		GeoIPService service = new GeoIPService();
		GeoIPServiceSoap ssop = service.getGeoIPServiceSoap();
		ip = ssop.getIpLocation("142.250.196.36");
		System.out.println(ip);

	}

}
